package inout;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Pipe extends OutputStream implements Runnable{
    public static final String CLOSE_PIPE = "This line causes the reader to terminate.";
    boolean done = false;
    PrintStream sysOut;
    boolean inputRead = false;
    List<String> lines = new ArrayList<>();
    Thread scannerThread;
    int nextLine = 0;
    final PipedInputStream pis = new PipedInputStream();
    PipedOutputStream pos;
    final Scanner scan = new Scanner(pis);

    public Pipe()  {
        this(System.out);
    }

    public Pipe(PrintStream sysOut)  {
        this.sysOut = sysOut;
        try {
            pos = new PipedOutputStream(pis);
            scannerThread = new Thread(this);
            scannerThread.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public OutputStream getOutputStream(){return pos;}
    public String readAll() throws IOException {
        waitUntilInputRead();
        StringBuffer sb = new StringBuffer();
        // while (pis.available() > 0) scanner reades pipe empty!
        while (hasNextLine()){
            String line = readLine();
            sb.append(line);
            sb.append("\n");
        }
        return sb.toString();
    }
    public String readLine() {
        waitUntilInputRead();
        //sysOut.println("start readLine");
        synchronized(lines) {
            if (!hasNextLine())
                throw new IllegalStateException("No line available.");
            return lines.get(nextLine++);
        }
    }
    public boolean hasNextLine(){
        waitUntilInputRead();
        return nextLine < lines.size();
    }

    public void close(){
        PrintStream output = new PrintStream(pos);
        output.println(CLOSE_PIPE);
       /* output.println(CLOSE_PIPE);
        output.println(CLOSE_PIPE);
        output.println(CLOSE_PIPE);
        output.println(CLOSE_PIPE);*/
/*
        done = true;
        try {
            pos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/
        // scan.close();

        /*
        try {
            //pis.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

         */

/*
        try {
            scannerThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        */

    }
    private synchronized void waitUntilInputRead(){
        while(!inputRead){
            try {
                wait(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }

    @Override
    public void write(int b) throws IOException {
        pos.write(b);
    }
    @Override
    public void run(){
        while(!done){
            //sysOut.println("start inner loop "+inputRead);
            String newLine = null;
            try {
                 newLine = scan.nextLine();
            } catch(NoSuchElementException e){
                done = true;
            }
            //sysOut.println("line read: "+newLine+"\n");
            if (CLOSE_PIPE.equals(newLine))
                done = true;
            else {
                synchronized(lines) {
                    lines.add(newLine);
                    inputRead = true;
                }
            }
        }
     //   sysOut.println("thread done");
    }
}
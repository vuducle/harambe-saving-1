package inout;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CaptureInOut {
    Pipe outPipe, errPipe;
    StringInput stringInput;
    private final PrintStream originalSystemOut = System.out;
    private final PrintStream originalSystemErr = System.err;
    private final InputStream originalSystemIn = System.in;

    public CaptureInOut(){
        redirectInOut();
    }
    public void redirectInOut() {
        outPipe = new Pipe();
        System.setOut(new PrintStream(outPipe.getOutputStream(), true));
        errPipe = new Pipe();
        System.setErr(new PrintStream(errPipe.getOutputStream(), true));
        stringInput = new StringInput();
        System.setIn(stringInput);
    }
    public void restoreStreams() {

        System.setOut(originalSystemOut);
        System.setErr(originalSystemErr);
        System.setIn(originalSystemIn);
        outPipe.close();
        errPipe.close();
    }
    public void provideInputLine(String line){
        stringInput.add(line);
    }

    public String getOutputLine(){
        return outPipe.readLine();
    }
    public String getOutput(){
        try {
            return outPipe.readAll();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static String file2string(String filename) throws IOException {
        return new String(Files.readAllBytes(Paths.get(filename)));
    }
}

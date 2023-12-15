package inout;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;
import java.util.Queue;

/**
 * StringInput provides a dynamic InputStream to pass to System.in
 * that can be fed one line of input at a time
 * Idea adapted from https://stackoverflow.com/questions/48980345/is-it-possible-to-generate-a-dynamic-inputstream-in-java
 */
public class StringInput extends InputStream {
    private static byte data[] = null;
    private static int index = 0;
    Queue<String> inputQueue = new LinkedList<>();
    public StringInput(){
       // inputQueue.add("\n");
    }
    public boolean add(String line) {
        return inputQueue.add(line);
    }

    @Override
    public int read() throws IOException {
        if ((data == null) || (index >= data.length)) {
            String nextLine = inputQueue.poll();
            if (nextLine == null) return -1;
            data = nextLine.getBytes(StandardCharsets.UTF_8);
            index = 0;
        }
        if (data.length == 0)
            return -1;
        return data[index++];
    }
}

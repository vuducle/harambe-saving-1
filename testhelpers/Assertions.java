package testhelpers;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * This class contains methods to be re-used
 * in Unit Tests Classes.
 *
 * @author  Barne Kleinen
 */
public class Assertions
{
    /**
     * just here to make BlueJ show this as unit test
     */
    @BeforeEach
    public void doNothing(){}
    
    
    public static void assertAllLinesContained(String expected, String output){
        String[] lines = expected.split("\n");
        for (String line : lines)
            assertTrue(output.contains(line),"missing part: ["+line+"]");
    }
}
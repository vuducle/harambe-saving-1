
import static org.junit.jupiter.api.Assertions.*;

import inout.CaptureInOut;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameSystemTest {
    Game game;
    CaptureInOut captureInOut;

    @BeforeEach
    public void setUp() {
        captureInOut = new CaptureInOut();
        game = new Game();
    }

    @AfterEach
    public void restoreStreams() {
        captureInOut.restoreStreams();
    }

    public GameSystemTest() {
    }

    @Test
    public void testWelcome() {
        captureInOut.provideInputLine("quit");
        game.play();
        String output = captureInOut.getOutput();
        String expected = """
                                
                Welcome to the World of Zuul!
                World of Zuul is a new, incredibly boring adventure game.
                Type 'help' if you need help.
                                
                You are outside the main entrance of the university
                Exits: east south west\s
                
                """;
        String[] lines = expected.split("\n");
        for (String line : lines)
            assertTrue(output.contains(line),"missing: "+line);
       
        //assertEquals(expected, output);
    }

    @Test
    public void testGoSouth() {
        captureInOut.provideInputLine("go south\n");
        captureInOut.provideInputLine("quit\n\n");
        game.play();
        String output = captureInOut.getOutput();
        String expected = """
                                
                Welcome to the World of Zuul!
                World of Zuul is a new, incredibly boring adventure game.
                Type 'help' if you need help.
                                
                You are outside the main entrance of the university
                Exits: east south west
                > You are in a computing lab
                Exits: north east
                
                """;
        String[] lines = expected.split("\n");
        for (String line : lines)
            assertTrue(output.contains(line),"missing: "+line);
        //assertEquals(expected, output);
    }
}



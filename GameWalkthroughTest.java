import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * This is a Game System Tests - it tests the
 * whole game and the endpoints between user input
 * and output to the console.
 *
 * @author  Barne Kleinen
 */
public class GameWalkthroughTest
{
    private Game game;

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
        game = new Game();
    }
  
    /**
     * This test needs to be adapted to your world.
     * If your world becomes very complicated, you 
     * may want to split the walkthrough up to 
     * several tests.
     */
    @Test
    public void completeWalkthrough()
    {
        goAndSee("east",  "lecture theater");
        goAndSee("west",  "main entrance");
        goAndSee("west",  "campus pub");
        goAndSee("east",  "main entrance");
        goAndSee("south", "computing lab");
        goAndSee("east",  "admin office");
        goAndSee("west",  "computing lab");
        goAndSee("north", "main entrance");
    }

    private void goAndSee(String direction, String whatShouldBeContained){
        //when
        String result = game.processInputLine("go "+direction);
        //then
        if (!result.contains(whatShouldBeContained))
            fail(result +" does not contain "+whatShouldBeContained);
    }

}

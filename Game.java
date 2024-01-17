/**
 * SAVING HARAMBE
 * To play this game, create an instance of this class and call the "play"
 * method.
 * <p>
 * This main class creates and initialises all the others: it creates all
 * rooms, creates the parser and starts the game.  It also evaluates and
 * executes the commands that the parser returns.
 */

import java.util.Timer;
import java.util.ArrayList; // where did all the imports go in the hierachy?

public class Game {
    private final Parser parser;
    private final Player player;
    // private Room currentRoom;
    Timer timer = new Timer();
    private RoomManager roomManager;

    /**
     * Create the game and initialise its internal map.
     */
    public Game() {
        player = new Player();
        roomManager = new RoomManager();
        player.setCurrentRoom(roomManager.getLobby());
        parser = new Parser();
    }
    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() {
        //TODO: need to change the Code
        timer.schedule(new TimerCount(), 0, 10000);
        System.out.println(new Welcome().processCommand(player));
        ImgGeneration img = new ImgGeneration("./harambe.png");

        boolean finished = false;
        while (!finished) {
            Command command = parser.getCommand();
            String output = command.processCommand(player);
            finished = (null == output);
            if (!finished) {
                System.out.println(output);
            }
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * This is a further method added by BK to
     * provide a clearer interface that can be tested:
     * Game processes a commandLine and returns output.
     * @param commandLine - the line entered as String
     * @return output of the command
     */
    public String processInputLine(String line) {
        Command command = parser.getCommand(line);
        return command.processCommand(player);
    }
}

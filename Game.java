/**
 * SAVING HARAMBE
 * This class is the main class of the "World of Zuul" application.
 * "World of Zuul" is a very simple, text based adventure game.  Users
 * can walk around some scenery. That's all. It should really be extended
 * to make it more interesting!
 * <p>
 * To play this game, create an instance of this class and call the "play"
 * method.
 * <p>
 * This main class creates and initialises all the others: it creates all
 * rooms, creates the parser and starts the game.  It also evaluates and
 * executes the commands that the parser returns.
 *
 * @author Michael Kölling and David J. Barnes
 * @version 2016.02.29
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
        timer.schedule(new TimerCount(), 0, 10000);
    }

    /**
     * Create all the rooms and link their exits together.
     */
    
    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() {
        //TODO: need to change the Code
        System.out.println(new Welcome().processCommand(player));
        ImgGeneration img = new ImgGeneration();

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

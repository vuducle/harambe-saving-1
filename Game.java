/**
 *                      SAVING HARAMBE
 *  This class is the main class of the "World of Zuul" application. 
 *  "World of Zuul" is a very simple, text based adventure game.  Users 
 *  can walk around some scenery. That's all. It should really be extended 
 *  to make it more interesting!
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */
import java.util.Timer;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
public class Game 
{
    private Parser parser;
    private Room currentRoom;
    Timer timer = new Timer();
    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        createRooms();
        parser = new Parser();
        timer.schedule(new TimerCount(), 0, 10000);
    }

    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms()
    {
        Room lobby, storage, prison, lab;

        // create the rooms
        lobby = new Room("in an untidy room");
        storage = new Room("in a storage-room filled with all sorts of objects and exotic wildlife.");
        prison = new Room("in a prison with Harambe sitting in the middle.");
        lab = new Room("in a hastily left lab with an enormous glas window at the north wall.");

        // initialise room exits (north, east, south, west)
        lobby.setExits(storage, lab, null, null);
        storage.setExits(null, prison, lobby, null);
        prison.setExits(null, null, lab, storage);
        lab.setExits(prison, null, null, lobby);

        currentRoom = lobby;  // start game lobby
    }

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {            
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.

        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            String output = processCommand(command);
            finished = (null == output);
            if (!finished)
            {
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
    public String processInputLine(String line){
        Command command = parser.getCommand(line);
        return processCommand(command);
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to the world of Harambe!");
        System.out.println("You need to try to save Harambe, before the bomb explodes! :(");
        System.out.println("--------------");
        System.out.println("You have " + TimerCount.countdown + " minutes!");
        System.out.println("--------------");
        System.out.println("Type 'help' if you need help.");


        String bildDateiPfad = "harambe.png";

        try {
            BufferedImage bild = ImageIO.read(new File(bildDateiPfad));

            JFrame frame = new JFrame();
            frame.setSize(400, 400);
            JLabel label = new JLabel(new ImageIcon(bild));
            frame.add(label);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        } catch (IOException e) {
            e.printStackTrace();
        }


        System.out.println();
        System.out.println("You are " + currentRoom.getDescription());
        System.out.print("Exits: ");
        if(currentRoom.northExit != null) {
            System.out.print("north ");
        }
        if(currentRoom.eastExit != null) {
            System.out.print("east ");
        }
        if(currentRoom.southExit != null) {
            System.out.print("south ");
        }
        if(currentRoom.westExit != null) {
            System.out.print("west ");
        }
        System.out.println();


    }

    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private String processCommand(Command command) 
    {
        boolean wantToQuit = false;

        if(command.isUnknown()) {
            return "I don't know what you mean...";       
        }
        String result = null;
        String commandWord = command.getCommandWord();
        // see https://docs.oracle.com/javase/8/docs/technotes/guides/language/strings-switch.html
        
        switch(commandWord){
            case "help": 
                result = printHelp();
                break;
            case "go": 
                result = goRoom(command);
                break;
            case "eat":
                result = eat();
                break;
            case "quit": 
                result = quit(command);
                timer.cancel();
                break;
        }

        return result ;
    }

    // implementations of user commands:

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    private String printHelp() 
    {
        return "You are lost. You are alone. You wander"
        +"\n"
        + "around at the university."
        +"\n"
        +"\n"
        +"Your command words are:"
        +"\n"
        +"   go quit help eat"
        +"\n";
    }

    /** 
     * Try to go in one direction. If there is an exit, enter
     * the new room, otherwise print an error message.
     */
    
    private String eat(){
        return "You ate thin air. It was breathable.";
    }
    
    private String goRoom(Command command) 
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            return "Go where?";
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = null;
        if(direction.equals("north")) {
            nextRoom = currentRoom.northExit;
        }
        if(direction.equals("east")) {
            nextRoom = currentRoom.eastExit;
        }
        if(direction.equals("south")) {
            nextRoom = currentRoom.southExit;
        }
        if(direction.equals("west")) {
            nextRoom = currentRoom.westExit;
        }
        String result = "";
        if (nextRoom == null) {
            result += "There is no door!";
        }
        else {
            currentRoom = nextRoom;
            result += "You are " + currentRoom.getDescription()+"\n";
            result += "Exits: ";
            if(currentRoom.northExit != null) {
                result += "north ";
            }
            if(currentRoom.eastExit != null) {
                result += "east ";
            }
            if(currentRoom.southExit != null) {
                result += "south ";
            }
            if(currentRoom.westExit != null) {
                result += "west ";
            }         
        }
        return result + "\n";
    }

    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    private String quit(Command command) 
    {
        if(command.hasSecondWord()) {
            return "Quit what?";
        }
        else {
            return null;  // signal that we want to quit
        }
    }
}

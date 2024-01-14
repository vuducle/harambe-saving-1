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
import java.util.ArrayList; // where did all the imports go in the hierachy?

public class Game 
{
    private Parser parser;
    private Player player;
    // private Room currentRoom;
    Timer timer = new Timer();
    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        player = new Player();
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
        Prop box, pinnboard, fridge, bomb, chair, table, cupboard;

        // create the rooms
        lobby = new Room("in an untidy room", "You can see: -pinnboard- and -cupboard-");
        storage = new Room("in a storage-room filled with all sorts of objects and exotic wildlife.", "You can see: -cupboard-, -fridge- and -box-");
        prison = new Room("in a prison with Harambe sitting in the middle.", "You can see: -bomb- and -Harambe-");
        lab = new Room("in a hastily left lab with an enormous glas window at the north wall.", "You can see: -glass-, -chair- and -table-");
        
        // create the Props (PROP-NAME, CONTAINSKEY, CONTAINSBANANA)
        pinnboard = new Prop("pinnboard", false, false);
        cupboard = new Prop("pinnboard", false, false);
        fridge = new Prop("fridge", false, false);
        box = new Prop("box", false, true);
        bomb = new Prop("bomb", false, false);
        chair = new Prop("chair", false, false);
        table = new Prop("table", false, false);
        
        // create the Items (Item-Description, Amount)
        Item banana = new Item("Yellow banana", 3);
        Item key = new Item("Magic Key", 1);
        Item notes = new Item("Code Zettelchen", 4);
        Item SECRET_BANANA = new Item("Secret Banana", 1);
        Item NYAN_CAT = new Item("Nyan Cat", 1);

        // initialise room exits (north, east, south, west)
        lobby.setExits(storage, lab, null, null);
    
        lobby.setProps(pinnboard, cupboard, null,null);
        // prison.setItem(banana);

        // Add Items in the ArrayList
        ArrayList<Item> specificItems = new ArrayList<>();
        specificItems.add(banana);
        specificItems.add(key);
        specificItems.add(notes);
        specificItems.add(SECRET_BANANA);
        
        prison.addItem(banana);
        lab.addItem(key);
        lab.addItem(notes);
        storage.addItem(SECRET_BANANA);
        lab.addRandomItem(specificItems, NYAN_CAT);


        storage.setExits(null, null, lobby, null);
        
        storage.setProps(cupboard, fridge, box,null);
        prison.setExits(null, null, lab, null);
        
        prison.setProps(bomb, null, null,null);
        lab.setExits(prison, null, null, lobby);
        
        lab.setProps(chair, table, null,null);
        

        player.setCurrentRoom(lobby);
        
        // prison.displayItemInfo();
    }

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {            
        //TODO: need to change the Code
        System.out.println(new Welcome().processCommand(player));
        
        // TODO: Refactor the image generation
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

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.

        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            String output = command.processCommand(player);
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
        return command.processCommand(player);
    }
}

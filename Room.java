import java.util.ArrayList;
import java.util.Random;
/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  The exits are labelled north, 
 * east, south, west.  For each direction, the room stores a reference
 * to the neighboring room, or null if there is no exit in that direction.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */
public class Room 
{
    public String description;
    public String details;
    public Room northExit;
    public Room southExit;
    public Room eastExit;
    public Room westExit;
    ArrayList<Prop> props = new ArrayList<>();
    public ArrayList<Item> items = new ArrayList<>();

    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     */
    public Room(String description, String details) 
    {
        this.description = description;
        this.details = details;
        this.items = new ArrayList<>();
    }

    /**
     * Define the exits of this room.  Every direction either leads
     * to another room or is null (no exit there).
     * @param north The north exit.
     * @param east The east east.
     * @param south The south exit.
     * @param west The west exit.
     */
    public void setExits(Room north, Room east, Room south, Room west) 
    {
        if(north != null) {
            northExit = north;
        }
        if(east != null) {
            eastExit = east;
        }
        if(south != null) {
            southExit = south;
        }
        if(west != null) {
            westExit = west;
        }
    }
   
    
    public void setProps(Prop prop1, Prop prop2, Prop prop3, Prop prop4){
        if(prop1 != null){
            props.add(prop1);
        }
        if(prop2 != null){
            props.add(prop2);
        }
        if(prop3 != null){
            props.add(prop3);
        }
        if(prop4 != null){
            props.add(prop4);
        }
    }
    
    public void addItem(Item item) {
        items.add(item);
    }
    
    public ArrayList<Item> getItems() {
        return items;
    }

    public Item getItem() {
        if (!items.isEmpty()) {
            return items.get(0);
        } else {
            return null; 
        }
    }

    public void addRandomItem(ArrayList<Item> specificItems, Item additionalItem) {
        if (!specificItems.isEmpty()) {
            Random random = new Random();
            int randomIndex = random.nextInt(specificItems.size());
            addItem(specificItems.get(randomIndex));
            specificItems.remove(randomIndex);
        }
        addItem(additionalItem);
    }

    public Room getExit(String direction) {
        switch (direction.toLowerCase()) {
            case "north":
                return northExit;
            case "east":
                return eastExit;
            case "south":
                return southExit;
            case "west":
                return westExit;
            default:
                return null;
        }
    }
    /**
     * @return The description of the room.
     */
    public String getDescription()
    {
        return description;
    }
    
    public String getDetails(){
        return details;
    }

    public void displayItems() {
        if (!items.isEmpty()) {
            System.out.println("Items in the room:");
            for (Item item : items) {
                System.out.println(item.getDescriptionString());
            }
        } else {
            System.out.println("No items in the room.");
        }
    }

   
}

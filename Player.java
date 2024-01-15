import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Stack;

/**
 * This class represents the Game State for the Single Player.
 *
 */
public class Player
{
    public Room currentRoom;
    public Room previousRoom;
    public Stack<Room> previouslyVisitedRooms = new Stack<>();

    public ArrayList<Item> inventory;

     public Player() {
        
        this.currentRoom = null;
        this.previousRoom = null;
        this.inventory = new ArrayList<>();
    }

    public Room getCurrentRoom(){
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom){
        this.currentRoom = currentRoom;
        this.previouslyVisitedRooms.add(currentRoom);
        currentRoom.displayItems();
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }
    public void setInventory(ArrayList<Item> inventory) {
        this.inventory = inventory;
    }

    public void goBack() {
        if (!previouslyVisitedRooms.isEmpty()) {
            this.previouslyVisitedRooms.pop();
            this.currentRoom = this.previouslyVisitedRooms.peek();
            System.out.println("You go back: " + currentRoom.getDescription());          
        } else {
            System.out.println("There is no previous room.");
        }
    }
}

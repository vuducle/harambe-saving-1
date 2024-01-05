
/**
 * This class represents the Game State for the Single Player.
 *
 */
public class Player
{
    public Room currentRoom;
    public Room previousRoom;

     public Player() {
        
        this.currentRoom = currentRoom;
        this.previousRoom = null;
    }

    public Room getCurrentRoom(){
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom){
        this.currentRoom = currentRoom;
        this.previousRoom = this.currentRoom;
        currentRoom.displayItems();
    }

    public void goBack() {
        if (previousRoom != null) {
            Room temp = currentRoom;
            currentRoom = previousRoom;
            previousRoom = temp;
            System.out.println("You go back: " + currentRoom.getDescription());          
        } else {
            System.out.println("There is no previous room.");
        }
    }
}

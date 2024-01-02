
/**
 * This class represents the Game State for the Single Player.
 *
 */
public class Player
{
    public Room currentRoom;

    public Room getCurrentRoom(){
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom){
        this.currentRoom = currentRoom;
    }

}

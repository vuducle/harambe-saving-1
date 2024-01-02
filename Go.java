public class Go extends Command

{

    public Go(CommandWord firstWord, String secondWord){
        super(firstWord, secondWord);
    }

    /** 
     * Try to go in one direction. If there is an exit, enter
     * the new room, otherwise print an error message.
     */
    public String processCommand(Player player)
    {
        Command command = this;
        Room currentRoom = player.getCurrentRoom();

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
        } else {
            player.setCurrentRoom(nextRoom);
            currentRoom = nextRoom;

            result += nextRoom.getDescription()+"\n";

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
            player.setCurrentRoom(nextRoom);
        }
        return result + "\n";
    }

}

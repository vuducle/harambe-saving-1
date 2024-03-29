public class InspectRoom extends Command
{
    public InspectRoom (CommandWord firstWord, String secondWord){
        super(firstWord, secondWord);
    }

     /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    public String processCommand(Player player) 
    {
        String result = player.currentRoom.details;
        return result;
    }
}
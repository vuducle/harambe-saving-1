public class Quit extends Command
{
    public Quit(CommandWord firstWord, String secondWord){
        super(firstWord, secondWord);
    }

     /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    public String processCommand(Player player) 
    {
        if(this.hasSecondWord()) {
            return "Quit what?";
        }
        else {
            //return "Thank you for playing.  Good bye.";  // signal that we want to quit
            return null;  // signal that we want to quit
            // should be replaced with a flag in player class to
            // signal quit to game loop
        }
    }
}

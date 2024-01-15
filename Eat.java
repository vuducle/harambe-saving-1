public class Eat extends Command
{
    public Eat(CommandWord firstWord, String secondWord){
        super(firstWord, secondWord);
    }

     /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    @Override
    public String processCommand(Player player) 
    {
        if (!this.hasSecondWord()) {
            return "You ate thin air. It was breathable.";

        }
        return "";
    }
}

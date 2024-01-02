public class Help extends Command
{

    public Help(CommandWord firstWord, String secondWord){
        super(firstWord, secondWord);
    }

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    public String processCommand(Player player) 
    {
        return "You are lost. You are alone. You wander"
        +"\n"
        + "around at the university."
        +"\n"
        +"\n"
        +"Your command words are:"
        +"\n"
        +"   go quit help"
        +"\n";
    }
}


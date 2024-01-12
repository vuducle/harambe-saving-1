
/**
 * Beschreiben Sie hier die Klasse Back.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Back extends Command
{
    public Back(CommandWord firstWord, String secondWord){
        super(firstWord, secondWord);
    }
    
    public String processCommand(Player player) 
    {
        if (!this.hasSecondWord()) {
            player.goBack();
            return "";
        }
        return "You mean what? You can't write a second word for the 'back' command!";
    }
}

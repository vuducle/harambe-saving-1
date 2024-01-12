public class Unknown extends Command
{

    public Unknown(CommandWord firstWord, String secondWord){
        super(firstWord, secondWord);
    }

    public String processCommand(Player player){
        return "I don't know what you mean...";      
    }
}

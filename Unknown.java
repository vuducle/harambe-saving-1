public class Unknown extends Command
{

    public Unknown(String firstWord, String secondWord){
        super(firstWord, secondWord);
    }

    public String processCommand(Player player){
        return "I don't know what you mean...";      
    }
}

import java.util.ArrayList;

public class Think extends Command
{
    public Think(CommandWord firstWord, String secondWord){
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
        ArrayList<String> answers = new ArrayList<>();
        answers.add("You think about bananas.");
        answers.add("You think about Harambe.");
        answers.add("You think about your life.");
        answers.add("You think about your day.");
        answers.add("You just got a random thought, sadly you forgot it.");
        answers.add("Surely there must be something hidden in these props.");
        answers.add("Your brain suddenly starts to hurt.");
        
        int i = (int)(Math.random()*answers.size());
        
        if (!this.hasSecondWord()) {
            return answers.get(i);
        }
        return "";
    }
}

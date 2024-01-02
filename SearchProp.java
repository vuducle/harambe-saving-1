public class SearchProp extends Command
{
    public SearchProp(String firstWord, String secondWord){
        super(firstWord, secondWord);
    }
    
    public String processCommand(Player player) {
    if(!this.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            return "Search what?";
        }
        
        String key;
        String banana;
        String propToSearch = this.getSecondWord();
        MusicPlayer searchSound = new MusicPlayer("sound/searchSound.wav");
        
        for(Prop prop : player.currentRoom.props){
            if (prop.getDescription().equalsIgnoreCase(propToSearch)) {
                if(prop.getKey()){key="YES";}
                else{key="NO :("; searchSound.play();}
                if(prop.getBanana()){banana=" but you found a banana.";}
                return "You found: " + prop.getDescription() + " - Contains key: " + key;
            }
        }
    
        // Prop not found
        return "You don't find anything interesting.";
    }
}
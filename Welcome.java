public class Welcome extends Command
{
    
    public Welcome(){
        super(CommandWord.WELCOME,"");
    }

    public Welcome(CommandWord firstWord, String secondWord){
        super(firstWord, secondWord);
    }
    
    public String processCommand(Player player) {
        Room currentRoom = player.getCurrentRoom();
        String result = "\n";
        result += "Welcome to the world of Harambe!\n";
        result += "You need to try to save Harambe, before the bomb explodes! :(\n";
        result += "--------------\n";
        result += "You have " + TimerCount.countdown + " minutes!\n";
        result += "--------------\n";
        result += "Type 'help' if you need help.\n\n";
    
        result += "You are " + currentRoom.getDescription() + "\n";
        result += "Exits: ";
        if (currentRoom.northExit != null) {
            result += "north ";
        }
        if (currentRoom.eastExit != null) {
            result += "east ";
        }
        if (currentRoom.southExit != null) {
            result += "south ";
        }
        if (currentRoom.westExit != null) {
            result += "west ";
        }
        result += "\n";
        MusicPlayer musicPlayer = new MusicPlayer("./sound/harambemusic.wav");
        musicPlayer.play();
    
        return result;
}

}
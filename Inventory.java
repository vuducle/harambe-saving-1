public class Inventory extends Command{
    public Inventory(CommandWord firstWord, String secondWord) {
        super(firstWord, secondWord);
    }

    @Override
    public String processCommand(Player player) {
        String string = "Items you picked up: \n";
        for (Item item: player.getInventory())
        {
            string += " - " + item.getDescriptionString()  + "\n";
        }
        return string;
    }
}

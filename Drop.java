public class Drop extends Command
{
    public Drop(CommandWord firstWord, String secondWord) {
        super(firstWord, secondWord);
    }

    @Override
    public String processCommand(Player player) {
        if (getSecondWord().equals("all")) {
            for (Item item : player.getInventory()) {
                player.currentRoom.addItem(item);
            }
            player.getInventory().clear();
            return "You dropped all items.";
        }

        if (this.hasSecondWord())
        {
            for (Item item: player.getInventory())
            {
                if (item.getDescription().equals(this.getSecondWord()))
                {
                    player.currentRoom.addItem(item);
                    player.getInventory().remove(item);
                    return String.format("You dropped the item: '%s'", this.getSecondWord());
                }
            }
            return String.format("No item with name '%s' in your inventory found", this.getSecondWord());
        }  else
        {
            return "No item named to drop";
        }


    }

}

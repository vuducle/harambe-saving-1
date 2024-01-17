import java.util.ArrayList;

public class Take extends Command {
    public Take(CommandWord firstWord, String secondWord) {
        super(firstWord, secondWord);
    }

    @Override
    public String processCommand(Player player) {
        Command command = this;
        if (command.hasSecondWord())
        {
            String itemName = this.getSecondWord();
            ArrayList<Item> playerInventory = player.getInventory();
            for (Item roomItem : player.currentRoom.items)
            {
                if (roomItem.getDescription().equals(itemName))
                {
                    if (playerInventory.isEmpty())
                    {
                        player.currentRoom.removeItem(roomItem);
                        playerInventory.add(roomItem);
                        if (roomItem.getDescription().equals("Nyan Cat")){
                            System.out.println("You picked up the legendary Nyan Cat! Meow! \n");
                            ImgGeneration img = new ImgGeneration("./nyancat.png");
                        }
                        return String.format("You took the item '%s'", itemName);
                    }
                    else
                    {
                        for (Item item: playerInventory)
                        {
                            if (playerInventory.size() > 3) {
                                return "Your inventory is full, you have only 3 slots available";
                            }
                            // if player inventory has item
                            if (!item.getDescription().equals(itemName))
                            {
                                playerInventory.add(roomItem);
                                return String.format("You took the item '%s'", itemName);
                            }
                            else
                            {
                                return String.format("You already picked up the item: '%s'", itemName);
                            }

                        }
                    }
                }
            }
        }
        return "You need to name the item you want to pick up...., YEEEET";
    }
}

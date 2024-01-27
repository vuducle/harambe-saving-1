import java.util.ArrayList;

public class Take extends Command {
    public Take(CommandWord firstWord, String secondWord) {
        super(firstWord, secondWord);
    }

    @Override
    public String processCommand(Player player) {
        Command command = this;
        // this method is way to complex!!
        if (!command.hasSecondWord()) // heres's the check for second word and in line 58 was the action 
        // use a guard clause like this instead.
            return "You need to name the item you want to pick up...., YEEEET";
        {
            String itemName = this.getSecondWord();
            ArrayList<Item> playerInventory = player.getInventory();
            // look for item in room. Which class should be responsible for this?
            for (Item roomItem : player.currentRoom.items)
            {
                if (roomItem.getDescription().equals(itemName))
                {
                    // first check for playerInventory fullness
                    if (playerInventory.isEmpty())
                    {
                        player.currentRoom.removeItem(roomItem);
                        playerInventory.add(roomItem);
                        // again, in which class should this go? 
                        // if you add more and more special items, this method becomes even longer.
                        if (roomItem.getDescription().equals("Nyan Cat")){
                            System.out.println("You picked up the legendary Nyan Cat! Meow! \n");
                            ImgGeneration img = new ImgGeneration("./nyancat.png");
                        }
                        return String.format("You took the item '%s'", itemName);
                    }
                    else
                    {
                        // why is this done for each item in the inventory??
                        for (Item item: playerInventory)
                        {
                            // second check for playerInventory fullness
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
                                // why is it impossible to pick up 2 apples if they are in a room?
                                return String.format("You already picked up the item: '%s'", itemName);
                            }

                        }
                    }
                }
            }
        }
        // ...here is/was  the action for the conditional in line 12!!! Use a guard instead in line 12
        // (see above)
        // also, at least theoretically, this line may be reached on certain conditions:
        return null; 
    }

}

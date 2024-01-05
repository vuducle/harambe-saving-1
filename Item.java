
/**
 * Beschreiben Sie hier die Klasse Item.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Item
{
    public String description;
    public int amount;
    public Item(String description, int amount) 
    {
        this.description = description;
        this.amount = amount;
    }
    public String getDescription(){
        return description;
    }
    public int getAmount(){
        return amount;
    }
}

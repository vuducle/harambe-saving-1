
/**
 * Beschreiben Sie hier die Klasse Prop.
 * 
 * @author (Harambe) 
 * @version (20.12.2023)
 */
public class Prop
{
    public String description;
    public boolean containsKey;
    public boolean containsBanana;
    public Prop(String description, boolean containsKey, boolean containsBanana) 
    {
        this.description = description;
        this.containsKey = containsKey;
        this.containsBanana = containsBanana;
    }
    public String getDescription()
    {
        return description;
    }
    
    public boolean getKey(){
        return containsKey;
    }
    public boolean getBanana(){
        return containsBanana;
    }

}

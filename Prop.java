
/**
 * Beschreiben Sie hier die Klasse Prop.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Prop
{
    public String description;
    public boolean containsKey;
    public boolean containsBanana;
    /**
     * Create a Prop described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The Prop's description.
     */
    public Prop(String description, boolean containsKey, boolean containsBanana) 
    {
        this.description = description;
        this.containsKey = containsKey;
        this.containsBanana = containsBanana;
    }
    /**
     * @return The description of the Prop.
     */
    public String getDescription()
    {
        return description;
    }
    
    public boolean getKey(){
        return containsKey;
    }

}

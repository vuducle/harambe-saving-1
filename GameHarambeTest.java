

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
/**
 * Die Test-Klasse GameHarambeTest.
 *
 * @author  (Ihr Name)
 * @version (eine Versionsnummer oder ein Datum)
 */
public class GameHarambeTest
{
    /**
     * Konstruktor fuer die Test-Klasse GameHarambeTest
     */
    public GameHarambeTest()
    {
    }

    /**
     *  Setzt das Testgerüst fuer den Test.
     *
     * Wird vor jeder Testfall-Methode aufgerufen.
     */
    @BeforeEach
    public void setUp()
    {
    }

    /**
     * Gibt das Testgerüst wieder frei.
     *
     * Wird nach jeder Testfall-Methode aufgerufen.
     */
    @AfterEach
    public void tearDown()
    {
    }
    
    @Test
    public void testRoomItems() {
        // Create rooms
        Room lobby = new Room("Lobby", "A welcoming lobby with comfortable chairs.");
        Room storage = new Room("Storage", "A room filled with shelves and boxes.");
        Room prison = new Room("Prison", "A cold and dimly lit prison cell.");
        Room lab = new Room("Lab", "A high-tech laboratory with various equipment.");

        // Create items
        Item banana = new Item("Yellow banana", 3);
        Item key = new Item("Magic Key", 1);
        Item notes = new Item("Code Zettelchen", 4);
        Item SECRET_BANANA = new Item("Secret Banana", 1);
        Item NYAN_CAT = new Item("Nyan Cat", 1);

        // List of specific items and rooms
        lobby.addItem(banana);
        storage.addItem(key);
        prison.addItem(notes);
        lab.addItem(SECRET_BANANA);

        // Add NYAN_CAT randomly among the specific items
lab.addRandomItem(new ArrayList<>(Arrays.asList(banana, key, notes, SECRET_BANANA)), NYAN_CAT);

        // Test cases
        assertEquals("Yellow banana", lobby.getItem().getDescription());
        assertEquals("Magic Key", storage.getItem().getDescription());
        assertEquals("Code Zettelchen", prison.getItem().getDescription());
        assertEquals("Secret Banana", lab.getItem().getDescription());
        
    }
}

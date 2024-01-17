/*Diese Klasse kümmert sich um das erstellen der Räume
   und ihre dazugehörigen Items.
   */

import java.util.ArrayList;

public class RoomManager {
    private ArrayList<Room> rooms;

    public RoomManager() {
        rooms = new ArrayList<>();
        createRooms();
    }

    private void createRooms() {
        Room lobby, storage, prison, lab;
        Prop pinnboard, cupboard, fridge, box, bomb, chair, table;

        // Create rooms and props as before
        lobby = new Room("in an untidy room", "You can see: -pinnboard- and -cupboard-");
        storage = new Room("in a storage-room filled with all sorts of objects and exotic wildlife.", "You can see: -cupboard-, -fridge- and -box-");
        prison = new Room("in a prison with Harambe sitting in the middle.", "You can see: -bomb- and -Harambe-");
        lab = new Room("in a hastily left lab with an enormous glas window at the north wall.", "You can see: -glass-, -chair- and -table-");

                // create the Props (PROP-NAME, CONTAINSKEY, CONTAINSBANANA)
        pinnboard = new Prop("pinnboard", false, false);
        cupboard = new Prop("pinnboard", false, false);
        fridge = new Prop("fridge", false, false);
        box = new Prop("box", false, true);
        bomb = new Prop("bomb", false, false);
        chair = new Prop("chair", false, false);
        table = new Prop("table", false, false);

        // create the Items (Item-Description, Amount)
        Item banana = new Item("Yellow banana", 3);
        Item key = new Item("Magic Key", 1);
        Item notes = new Item("Code Zettelchen", 4);
        Item SECRET_BANANA = new Item("Secret Banana", 1);
        Item NYAN_CAT = new Item("Nyan Cat", 1);
        // Add the rooms to the list
        rooms.add(lobby);
        rooms.add(storage);
        rooms.add(prison);
        rooms.add(lab);

        // Set room exits and props as before
                lobby.setExits(storage, lab, null, null);

        lobby.setProps(pinnboard, cupboard);
        // prison.setItem(banana);

        // Add Items in the ArrayList
        ArrayList<Item> specificItems = new ArrayList<>();
        specificItems.add(banana);
        specificItems.add(key);
        specificItems.add(notes);
        specificItems.add(SECRET_BANANA);

        prison.addItem(banana);
        lab.addItem(key);
        lab.addItem(notes);
        storage.addItem(SECRET_BANANA);
        lab.addRandomItem(specificItems, NYAN_CAT);


        storage.setExits(null, null, lobby, null);

        storage.setProps(cupboard, fridge, box);
        prison.setExits(null, null, lab, null);

        prison.setProps(bomb);
        lab.setExits(prison, null, null, lobby);

        lab.setProps(chair, table);



        // prison.displayItemInfo();
    }

    // Getter methods to access rooms
    public Room getLobby() {
        return rooms.get(0);
    }

    public Room getStorage() {
        return rooms.get(1);
    }

    public Room getPrison() {
        return rooms.get(2);
    }

    public Room getLab() {
        return rooms.get(3);
    }
}

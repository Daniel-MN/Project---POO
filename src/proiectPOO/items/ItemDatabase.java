package proiectPOO.items;

import proiectPOO.adapters.ItemTypes;

import java.util.HashMap;

public class ItemDatabase {
    private static ItemDatabase database;
    private static HashMap<String, Item> items;

    private ItemDatabase() {
        setItems();
    }

    public static ItemDatabase Instance() {
        if (database == null)
            database = new ItemDatabase();
        return database;
    }

    private static void setItems() {
        items = ItemTypes.getAll();
    }

    public HashMap<String, Item> getItems() {
        return items;
    }
}

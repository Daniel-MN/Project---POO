package proiectPOO.items;

import java.util.HashMap;

public class ItemFactory {
    // Returns a copy of an object from database
    public static Item makeItem(String name) {
        if (name.equals("nothing")) {
            return null;
        }

        ItemDatabase database = ItemDatabase.Instance();
        HashMap<String, Item> objects = database.getItems();
        Item obj = objects.get(name);
        if (obj == null) {
            System.out.println("Item " + name + " does not exist!");
            return null;
        }
        return new Item(obj);
    }
}

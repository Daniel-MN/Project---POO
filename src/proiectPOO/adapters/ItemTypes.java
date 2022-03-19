package proiectPOO.adapters;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import proiectPOO.items.Item;
import proiectPOO.pokemon.Pokemon;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

public class ItemTypes {
    public static HashMap<String, Item> getAll() {
        HashMap<String, Item> items = new HashMap<>();

        final File file = new File("./in/Items/items.json");
        Gson gson = new Gson();
        JsonReader reader;
        try {
            reader = new JsonReader(new FileReader(file));
            ArrayList<Item> greatItems= gson.fromJson(reader, new TypeToken<ArrayList<Item>>(){}.getType());
            for (Item item : greatItems) {
                items.put(item.getName(), item);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found exception: " + e);
        }

        return items;
    }
}

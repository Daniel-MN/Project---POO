package proiectPOO.adapters;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import proiectPOO.pokemon.Pokemon;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

public class PokemonTypes {
    public static HashMap<String, Pokemon> getAll() {
        HashMap<String, Pokemon> pokemons = new HashMap<>();

        final File file = new File("./in/Pokemon/pokemons.json");
        Gson gson = new Gson();
        JsonReader reader;
        try {
            reader = new JsonReader(new FileReader(file));
            ArrayList<Pokemon> greatPokemons= gson.fromJson(reader, new TypeToken<ArrayList<Pokemon>>(){}.getType());
            for (Pokemon pokemon : greatPokemons) {
                pokemons.put(pokemon.getName(), pokemon);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found exception: " + e);
        }

        return pokemons;
    }
}

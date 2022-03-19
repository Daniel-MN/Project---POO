package proiectPOO.pokemon;
import proiectPOO.adapters.PokemonTypes;
import java.util.HashMap;

public class PokemonDatabase {
    private static PokemonDatabase database;
    private static HashMap<String, Pokemon> pokemons;

    private PokemonDatabase() {
        setPokemons();
    }

    public static PokemonDatabase Instance() {
        if (database == null)
            database = new PokemonDatabase();
        return database;
    }

    private void setPokemons() {
        pokemons = PokemonTypes.getAll();
    }

    public HashMap<String, Pokemon> getPokemons() {
        return pokemons;
    }
}

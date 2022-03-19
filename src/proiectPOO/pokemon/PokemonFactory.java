package proiectPOO.pokemon;

import java.util.HashMap;

public class PokemonFactory {
    // Returns a copy of a pokemon from database
    public static Pokemon makePokemon(String name) {
        PokemonDatabase database = PokemonDatabase.Instance();
        HashMap<String, Pokemon> pokemons = database.getPokemons();
        Pokemon pokemon = pokemons.get(name);
        if (pokemon == null) {
            throw new RuntimeException("Pokemon " + name + " does not exist!");
        }
        return pokemon.clone();
    }
}

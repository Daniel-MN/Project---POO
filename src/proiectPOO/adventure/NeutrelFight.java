package proiectPOO.adventure;

import proiectPOO.logger.MyLogger;
import proiectPOO.pokemon.Pokemon;
import proiectPOO.pokemon.PokemonFactory;
import proiectPOO.pokemon.PokemonReady;

import java.util.Random;

//the fight with Neutrel1
public class NeutrelFight implements Fight {
    PokemonReady[] pokemons;
    PokemonReady[] neutrels;

    public NeutrelFight(PokemonReady pokemon1, PokemonReady pokemon2, int i) {
        pokemons = new PokemonReady[2];
        neutrels = new PokemonReady[2];
        pokemons[0] = pokemon1;
        pokemons[1] = pokemon2;
        Pokemon neutrelNotReady = PokemonFactory.makePokemon("Neutrel" + i);
        neutrels[0] = new PokemonReady(neutrelNotReady, null); // Neutrel is ready now :)))
        neutrels[1] = new PokemonReady(neutrelNotReady.clone(), null); //Another Neutrel is ready now :))
    }

    @Override
    public void go() {
        MyLogger log = MyLogger.getLogger();
        log.print("\t\tIncep luptele cu " + neutrels[0].getPokemon().getName());
        log.print("");
        new BattlePokemons(pokemons[0], neutrels[0]).battle();
        new BattlePokemons(pokemons[1], neutrels[1]).battle();
    }
}

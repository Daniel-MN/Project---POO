package proiectPOO.adventure;

import proiectPOO.logger.MyLogger;
import proiectPOO.pokemon.PokemonReady;

public class LastFight implements Fight {
    PokemonReady pokemon1;
    PokemonReady pokemon2;

    public LastFight(PokemonReady pokemon1, PokemonReady pokemon2) {
        this.pokemon1 = pokemon1;
        this.pokemon2 = pokemon2;
    }

    @Override
    public void go() {
        MyLogger log = MyLogger.getLogger();
        log.print("\t\tAu ajuns in batalia finala:");
        new BattlePokemons(pokemon1, pokemon2).battle();
    }
}

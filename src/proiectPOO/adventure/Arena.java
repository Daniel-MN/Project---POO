package proiectPOO.adventure;

import proiectPOO.logger.MyLogger;
import proiectPOO.pokemon.PokemonReady;

public class Arena {
    PokemonReady pokemon1;
    PokemonReady pokemon2;

    public Arena(PokemonReady pokemon1, PokemonReady pokemon2) {
        this.pokemon1 = pokemon1;
        this.pokemon2 = pokemon2;
    }

    public void doArena() {
        Fight fight;
        MyLogger log = MyLogger.getLogger();
        log.print("\tIntra in arena: " + pokemon1.getPokemon().getName() + " si " + pokemon2.getPokemon().getName());
        do {
            fight = FightType.choose(pokemon1, pokemon2);
            fight.go();
        } while (!(fight instanceof LastFight));
    }
}

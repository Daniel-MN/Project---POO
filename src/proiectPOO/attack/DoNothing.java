package proiectPOO.attack;

import proiectPOO.logger.MyLogger;
import proiectPOO.pokemon.PokemonReady;

public class DoNothing extends Command {
    PokemonReady pokemon;

    public DoNothing(PokemonReady pokemon) {
        this.pokemon = pokemon;
    }

    @Override
    public void execute() {
        MyLogger log = MyLogger.getLogger();
        log.print(pokemon.getPokemon().getName() + " nu face nimic!");
        pokemon.setStun(false);
    }

    @Override
    public void cancel() {
        return;
    }
}

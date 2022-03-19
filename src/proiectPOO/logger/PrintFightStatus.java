package proiectPOO.logger;

import proiectPOO.pokemon.Pokemon;
import proiectPOO.pokemon.PokemonReady;

public class PrintFightStatus {
    public static void statusFight(PokemonReady pokemon1, PokemonReady pokemon2) {
        MyLogger log = MyLogger.getLogger();
        
        log.print(statusPokemon(pokemon1));
        log.print(statusPokemon(pokemon2));
        log.print("");
    }
    
    private static String statusPokemon(PokemonReady pokemon) {
        String message = pokemon.getPokemon().getName() + " - " +
                pokemon.getHPbattle() + " HP";
        if (pokemon.getAbility1Cd() != -1) {
            message += " - abilitate1 cooldown: " + pokemon.getAbility1Cd();
        }

        if (pokemon.getAbility2Cd() != -1) {
            message += " - abilitate2 cooldown: " + pokemon.getAbility2Cd();
        }
        return message;
    }
}

package proiectPOO.adventure;

import proiectPOO.pokemon.PokemonReady;

import java.util.Random;

public class FightType {
    public static Fight choose(PokemonReady pokemon1, PokemonReady pokemon2) {
        Random rand = new Random();
        int randomNumber = rand.nextInt(3) + 1;
        switch (randomNumber) {
            case 1:
            case 2:
                return new NeutrelFight(pokemon1, pokemon2, randomNumber);
            case 3:
                return new LastFight(pokemon1, pokemon2);
        }
        throw new IllegalArgumentException("" + randomNumber +
                " is not an accepted random number!");
    }
}

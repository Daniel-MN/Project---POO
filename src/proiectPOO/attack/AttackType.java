package proiectPOO.attack;

import proiectPOO.pokemon.PokemonReady;

import java.util.ArrayList;
import java.util.Random;

public class AttackType {
    public static Command choose(PokemonReady pokemon1, PokemonReady pokemon2) {
        if (pokemon1.isStun()) {
            return new DoNothing(pokemon1);
        }

        String command = chooseCommand(pokemon1);
        switch (command) {
            case "attack":
                return new Attack(pokemon1, pokemon2);
            case "ability1":
                return new AbilityAttack(pokemon1, pokemon2, 1);
            case "ability2":
                return new AbilityAttack(pokemon1, pokemon2, 2);
        }
        throw new IllegalArgumentException(command +
                " is not an accepted command!");
    }

    private static String chooseCommand(PokemonReady pokemon) {
        ArrayList<String> commands = new ArrayList<>();
        commands.add("attack");

        if (pokemon.getAbility1Cd() == -1 && pokemon.getPokemon().getAbility1() != null) {
            commands.add("ability1");
        }
        if (pokemon.getAbility2Cd() == -1 && pokemon.getPokemon().getAbility2() != null) {
            commands.add("ability2");
        }

        Random rand = new Random();
        int randomNumber = rand.nextInt(commands.size());
        return commands.get(randomNumber);
    }
}

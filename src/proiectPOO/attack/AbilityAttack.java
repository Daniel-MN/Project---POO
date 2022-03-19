package proiectPOO.attack;

import proiectPOO.logger.MyLogger;
import proiectPOO.pokemon.Ability;
import proiectPOO.pokemon.PokemonReady;

public class AbilityAttack extends Command {
    private final int enemyHP;
    private final PokemonReady pokemon;
    private final PokemonReady enemy;
    private final int i;
    private Ability pokemonAbility;

    public AbilityAttack(PokemonReady pokemon, PokemonReady enemy, int i) {
        this.pokemon = pokemon;
        this.enemy = enemy;
        this.i = i;
        if (i == 1) {
            pokemonAbility = pokemon.getPokemon().getAbility1();
            pokemon.ability1Used();
        }

        if (i == 2) {
            pokemonAbility = pokemon.getPokemon().getAbility2();
            pokemon.ability2Used();
        }

        if (i != 1 && i != 2)
            throw new IllegalArgumentException("Ability " + i +
                    " does not exist!");

        enemyHP = enemy.getHPbattle() - pokemonAbility.getDmg();
    }


    @Override
    public void execute() {
        MyLogger log = MyLogger.getLogger();
        log.print(pokemon.getPokemon().getName() + " - abilitate " + i);
        pokemon.setDodge(pokemonAbility.isDodge());
        enemy.setStun(pokemonAbility.isStun());
        if (enemyHP <= 0) {
            enemy.setHPbattle(0);
            return;
        }
        enemy.setHPbattle(enemyHP);
    }

    @Override
    public void cancel() {
        enemy.setStun(false);
        enemy.setHPbattle(enemyHP + pokemonAbility.getDmg());
    }
}

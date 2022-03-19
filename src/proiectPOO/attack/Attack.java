package proiectPOO.attack;

import proiectPOO.logger.MyLogger;
import proiectPOO.pokemon.PokemonReady;

public class Attack extends Command{
    private PokemonReady pokemon;
    private PokemonReady enemy;
    private int attack;
    private int enemyHP;

    public Attack(PokemonReady pokemon, PokemonReady enemy) {
        this.pokemon = pokemon;
        this.enemy = enemy;
        this.enemyHP = enemy.getHPbattle();
    }

    @Override
    public void execute() {
        int enemyHP = enemy.getHPbattle();
        String name = pokemon.getPokemon().getName();
        MyLogger log = MyLogger.getLogger();

        int enemyDef = enemy.getPokemon().getDefense();
        int attack = pokemon.getPokemon().getNormalAttack();
        if (attack != 0) {
            log.print(name + " - atac normal");
            goAttack(enemyHP, enemyDef, attack);
            return;
        }

        enemyDef = enemy.getPokemon().getSpecialDefense();
        attack = pokemon.getPokemon().getSpecialAttack();
        if (attack != 0) {
            log.print(name + " - atac special");
            goAttack(enemyHP, enemyDef, attack);
        }
    }

    @Override
    public void cancel() {
        enemy.setHPbattle(enemyHP);
    }

    private void goAttack(int enemyHP, int enemyDef, int attack) {
        if (enemyDef >= attack) {
            return;
        }
        int enemyNewHP = enemyHP - (attack - enemyDef);
        if (enemyNewHP < 0) {
            enemy.setHPbattle(0);
            return;
        }
        enemy.setHPbattle(enemyNewHP);
    }
}

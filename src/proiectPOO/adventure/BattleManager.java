package proiectPOO.adventure;

import proiectPOO.attack.AttackType;
import proiectPOO.attack.Command;
import proiectPOO.logger.MyLogger;
import proiectPOO.logger.PrintFightStatus;
import proiectPOO.pokemon.PokemonReady;

public class BattleManager {
    PokemonReady pokemon1;
    PokemonReady pokemon2;
    boolean firstAttack;
    Command firstPokemonLastCommand;
    Command secondPokemonLastCommand;

    public BattleManager(PokemonReady pokemon1, PokemonReady pokemon2) {
        String message;
        message = "\tSe lupta " + pokemon1.getPokemon().getName() + " - " + pokemon1.getHPbattle() + " HP";
        message += " cu " + pokemon2.getPokemon().getName() + " - " + pokemon2.getHPbattle() + " HP\n";
        MyLogger log = MyLogger.getLogger();
        log.print(message);
        this.pokemon1 = pokemon1;
        this.pokemon2 = pokemon2;
        firstAttack = false;
    }

    public void P1AttacksP2() throws InterruptedException {
        while (pokemon1.getHPbattle() > 0 && pokemon2.getHPbattle() > 0) {
            synchronized (this) {
                //get a command for pokemon 1
                Command attack = AttackType.choose(pokemon1, pokemon2);
                attack.execute();
                firstAttack =  true;
                firstPokemonLastCommand = attack;
                //now the second one can attack
                notify();
                if (firstAttack)
                    wait();
            }
        }
    }

    public void P2AttacksP1() throws InterruptedException {
        while (pokemon1.getHPbattle() > 0 && pokemon2.getHPbattle() > 0 || firstAttack) {
            synchronized (this) {
                if (!firstAttack)
                    wait();

                //get a command for pokemon2
                Command attack = AttackType.choose(pokemon2, pokemon1);
                attack.execute();
                firstAttack = false;
                secondPokemonLastCommand = attack;

                //cancel dodged attacks
                oooPokemonsHaveDodge();
                PrintFightStatus.statusFight(pokemon1, pokemon2);
                prepareNextAttacks();
                notify();
            }
        }
    }

    private void prepareNextAttacks() {
        pokemon1.prepareNextAttack();
        pokemon2.prepareNextAttack();
    }

    private void oooPokemonsHaveDodge() {
        if (pokemon1.hasDodge()) {
            secondPokemonLastCommand.cancel();
        }

        if (pokemon2.hasDodge()) {
            firstPokemonLastCommand.cancel();
        }
    }
}

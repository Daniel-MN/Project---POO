package proiectPOO.adventure;

import proiectPOO.logger.MyLogger;
import proiectPOO.pokemon.PokemonReady;

public class BattlePokemons {
    PokemonReady pokemon1;
    PokemonReady pokemon2;

    public BattlePokemons(PokemonReady pokemon1, PokemonReady pokemon2) {
        this.pokemon1 = pokemon1;
        this.pokemon2 = pokemon2;
    }

    public int battle() {
        BattleManager manager = new BattleManager(pokemon1, pokemon2);
        Thread t1 = new Thread(() -> {
            try {
                manager.P1AttacksP2();
            } catch (InterruptedException e) {
                System.out.println("InterruptedException :::" + e);
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                manager.P2AttacksP1();
            } catch (InterruptedException e) {
                System.out.println("InterruptedException :::" + e);
            }
        });
        t1.start();
        t2.start();

        try {
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        int i = getWinner();
        pokemon1.preparePokemonNextBattle();
        pokemon2.preparePokemonNextBattle();
        return i;
    }
    
    private int getWinner() {
        int HP1 = pokemon1.getHPbattle();
        int HP2 = pokemon2.getHPbattle();
        MyLogger log = MyLogger.getLogger();

        if (HP1 == 0 && HP2 != 0) {
            log.print("\tBatalie castigata de " + pokemon2.getPokemon().getName());
            log.print("");
            pokemon2.increaseStats();
            return 2;
        }

        if (HP1 != 0 && HP2 == 0) {
            log.print("\tBatalie castigata de " + pokemon1.getPokemon().getName());
            log.print("");
            pokemon1.increaseStats();
            return 1;
        }

        if (HP1 == 0 && HP2 == 0) {
            log.print("\tDraw");
            log.print("");
            return 0;
        }

        return -1;
    }
}

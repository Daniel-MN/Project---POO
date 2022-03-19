package proiectPOO.adventure;

import proiectPOO.logger.MyLogger;
import proiectPOO.pokemon.PokemonReady;
import proiectPOO.trainer.TrainerReady;

public class Adventure {
    TrainerReady player1;
    TrainerReady player2;

    public Adventure(TrainerReady player1, TrainerReady player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void doAdventure() {
        MyLogger log = MyLogger.getLogger();
        log.print("\t\t\tAventura jucatorilor " + player1.getTrainer().getName() + " si "
                + player2.getTrainer().getName() + " incepe:\n");
        log.print(player1.toString());
        log.print(player2.toString());
        log.print("\n");

        for (int i = 0; i < 3; i++) {
            Arena arena = new Arena(player1.getPokemons()[i], player2.getPokemons()[i]);
            arena.doArena();
        }

        PokemonReady bestPokemon1 = player1.getTheBestPokemon();
        PokemonReady bestPokemon2 = player2.getTheBestPokemon();

        log.print("---Cel mai bun pokemon al lui " + player1.getTrainer().getName() + " este "
                + bestPokemon1.getPokemon().getName());
        log.print("---Cel mai bun pokemon al lui " + player2.getTrainer().getName() + " este "
                + bestPokemon2.getPokemon().getName());
        log.print("");

        int winner = new BattlePokemons(bestPokemon1, bestPokemon2).battle();
        if (winner == 1) {
            log.print("\t\t\t\t" + player1.getTrainer().getName() + " A CASTIGAT!\n");
        }

        if (winner == 2) {
            log.print("\t\t\t\t" + player2.getTrainer().getName() + " A CASTIGAT!\n");
        }

        if (winner == 0) {
            log.print("\t\t\t\tDRAW intre " + player1.getTrainer().getName() +
                    " si " + player2.getTrainer().getName());
        }

        log.print(player1.toString());
        log.print(player2.toString());

        log.print("\n");

        log.endWrite();
    }
}

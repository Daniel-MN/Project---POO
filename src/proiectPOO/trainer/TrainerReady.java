package proiectPOO.trainer;

import proiectPOO.items.Item;
import proiectPOO.items.ItemFactory;
import proiectPOO.pokemon.Pokemon;
import proiectPOO.pokemon.PokemonFactory;
import proiectPOO.pokemon.PokemonReady;

import java.util.Arrays;

// This class describes a Trainer ready for battle
public class TrainerReady {
    final private Trainer trainer;
    final private PokemonReady[] pokemons = new PokemonReady[3];
    private int nrPokemon = 0;

    public TrainerReady(Trainer trainer) {
        this.trainer = trainer;
        preaparePokemonsforBattle();
    }

    private void preaparePokemonsforBattle() {
        int i;
        String[] pokemons = trainer.getPokemons();
        String[] trainerItems = trainer.getItems();
        for (String namePokemon : pokemons) {
            if (nrPokemon >= 3) {
                // the trainer tries to have more than 3 pokemons in an arena
                break;
            }
            Pokemon pokemon = PokemonFactory.makePokemon(namePokemon);


            Item[] items = new Item[3];

            // If there are items for the next pokemon:
            if (nrPokemon < trainerItems.length) {
                String[] itemNames = trainerItems[nrPokemon].split("[.,]");
                i = 0;
                for (String itemName : itemNames) {
                    if (i >= 3) {
                        //the trainer tries to put more than three items on a pokemon
                        break;
                    }
                    items[i] = ItemFactory.makeItem(itemName);
                    i++;
                }
            }
            this.pokemons[nrPokemon] = new PokemonReady(pokemon, items);
            nrPokemon++;
        }
    }

    public PokemonReady[] getPokemons() {
        return pokemons;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public PokemonReady getTheBestPokemon() {
        PokemonReady theBest = null;
        for (int i = 0; i < 3; i++) {
            if (pokemons[i].compareTo(theBest) > 0) {
                theBest = pokemons[i];
            }
        }

        return theBest;
    }

    @Override
    public String toString() {
        return "TrainerReady{" +
                "trainer=\n\t\t" + trainer +
                ", pokemons=\n\t\t" + Arrays.toString(pokemons) +
                ", nrPokemon=" + nrPokemon +
                '}';
    }
}

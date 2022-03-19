package proiectPOO.pokemon;

import proiectPOO.items.Item;

// describes a pokemon ready for battle
public class PokemonReady implements IPokemon, Comparable<PokemonReady> {
    private Pokemon pokemon;
    private int HPbattle;
    private int ability1Cd;
    private int ability2Cd;
    private BattleRestrictions restrictions;

    public PokemonReady(Pokemon pokemon, Item[] items) {
        this.pokemon = pokemon;
        this.HPbattle = pokemon.getHP();
        this.ability1Cd = -1;
        this.ability2Cd = -1;
        putItems(items);
        restrictions = new BattleRestrictions();
    }

    private void putItems(Item[] items) {
        // If there are no items for this pokemon
        if (items == null) {
            return;
        }

        for (Item item : items) {
            //If this item does not exist
            if (item == null) {
                continue;
            }
            pokemon.setHP(pokemon.getHP() + item.getHP());
            pokemon.setDefense(pokemon.getDefense() + item.getDefense());
            pokemon.setSpecialDefense(pokemon.getSpecialDefense() + item.getSpecialDefense());
            if (pokemon.getNormalAttack() == 0) {
                pokemon.setSpecialAttack(pokemon.getSpecialAttack() + item.getSpecialAttack());
                continue;
            }

            pokemon.setNormalAttack(pokemon.getNormalAttack() + item.getAttack());
        }
    }

    public Pokemon getPokemon() {
        return pokemon;
    }

    public int getHPbattle() {
        return HPbattle;
    }

    public void setHPbattle(int HPbattle) {
        this.HPbattle = HPbattle;
    }

    public int getAbility1Cd() {
        return ability1Cd;
    }

    public int getAbility2Cd() {
        return ability2Cd;
    }

    public boolean isStun() {
        return restrictions.isStunnedTime1();
    }

    public boolean hasDodge() {
        return restrictions.isHasDodge();
    }

    public void preparePokemonNextBattle() {
        restoreHP();
        restrictions = new BattleRestrictions();
    }

    private void restoreHP() {
        this.HPbattle = pokemon.getHP();
    }

    public void setStun(boolean stun) {
        restrictions.setStunnedTime2(stun);
    }

    public void setDodge(boolean dodge) {
        restrictions.setHasDodge(dodge);
    }

    public void ability1Used() {
        this.ability1Cd = pokemon.getAbility1().getCd();
    }

    public void ability2Used() {
        this.ability2Cd = pokemon.getAbility2().getCd();
    }

    public void prepareNextAttack() {
        restrictions.nextAttacks();
        if (ability1Cd != -1) {
            ability1Cd--;
        }

        if (ability2Cd != -1) {
            ability2Cd--;
        }
    }

    public void increaseStats() {
        pokemon.increaseStats();
    }

    @Override
    public int compareTo(PokemonReady o) {
        if (o == null) {
            return 1000;
        }
        int rating1 = this.pokemon.rating();
        int rating2 = o.getPokemon().rating();
        if (rating1 == rating2) {
            return o.getPokemon().getName().compareTo(this.pokemon.getName());
        }

        return rating1 - rating2;
    }

    @Override
    public String toString() {
        return "PokemonReady{" +
                "pokemon=\n\t\t\t" + pokemon;
    }
}

package proiectPOO.trainer;

import java.util.Arrays;

public class Trainer {
    final private String name;
    private int age;
    private String[] pokemons;
    private String[] items;

    public Trainer(String name, int age, String[] pokemons, String[] items) {
        this.name = name;
        this.age = age;
        this.pokemons = pokemons;
        this.items = items;
    }

    public String[] getItems() {
        return items;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String[] getPokemons() {
        return pokemons;
    }

    @Override
    public String toString() {
        return "Trainer{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", pokemons=" + Arrays.toString(pokemons) +
                ", items=" + Arrays.toString(items) +
                '}';
    }
}

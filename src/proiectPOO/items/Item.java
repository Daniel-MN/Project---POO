package proiectPOO.items;

public class Item implements Cloneable {
    private String name;
    private int HP;
    private int attack;
    private int specialAttack;
    private int defense;
    private int specialDefense;

    public Item(String name, int HP, int attack, int specialAttack, int defense, int specialDefense) {
        this.name = name;
        this.HP = HP;
        this.attack = attack;
        this.specialAttack = specialAttack;
        this.defense = defense;
        this.specialDefense = specialDefense;
    }

    public Item(Item obj) {
        this.name = obj.getName();
        this.HP = obj.getHP();
        this.attack = obj.getAttack();
        this.specialAttack = obj.getSpecialAttack();
        this.defense = obj.getDefense();
        this.specialDefense = obj.getSpecialDefense();
    }

    public String getName() {
        return name;
    }

    public int getHP() {
        return HP;
    }

    public int getAttack() {
        return attack;
    }

    public int getSpecialAttack() {
        return specialAttack;
    }

    public int getDefense() {
        return defense;
    }

    public int getSpecialDefense() {
        return specialDefense;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", HP=" + HP +
                ", attack=" + attack +
                ", specialAttack=" + specialAttack +
                ", defense=" + defense +
                ", specialDefense=" + specialDefense +
                '}';
    }
}

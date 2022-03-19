package proiectPOO.pokemon;

public class Pokemon implements IPokemon, Cloneable {
    private final String name;
    private int HP;
    private int normalAttack;
    private int specialAttack;
    private int defense;
    private int specialDefense;
    private Ability ability1;
    private Ability ability2;

    public Pokemon(String name, int HP, int normalAttack, int specialAttack, int defense, int specialDefense, Ability ability1, Ability ability2) {
        this.name = name;
        this.HP = HP;
        this.normalAttack = normalAttack;
        this.specialAttack = specialAttack;
        this.defense = defense;
        this.specialDefense = specialDefense;
        this.ability1 = ability1;
        this.ability2 = ability2;
    }

    public String getName() {
        return name;
    }

    public int getHP() {
        return HP;
    }

    public int getNormalAttack() {
        return normalAttack;
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

    public Ability getAbility1() {
        return ability1;
    }

    public Ability getAbility2() {
        return ability2;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public void setNormalAttack(int normalAttack) {
        this.normalAttack = normalAttack;
    }

    public void setSpecialAttack(int specialAttack) {
        this.specialAttack = specialAttack;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public void setSpecialDefense(int specialDefense) {
        this.specialDefense = specialDefense;
    }

    public int rating() {
        return this.HP + this.normalAttack + this.specialAttack + this.defense + this.specialDefense;
    }

    void increaseStats() {
        this.HP++;
        this.defense++;
        this.specialDefense++;
        if (this.normalAttack != 0) {
            this.normalAttack++;
            return;
        }
        this.specialAttack++;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "name='" + name + '\'' +
                ", HP=" + HP +
                ", normalAttack=" + normalAttack +
                ", specialAttack=" + specialAttack +
                ", defense=" + defense +
                ", specialDefense=" + specialDefense +
                ", ability1=" + ability1 +
                ", ability2=" + ability2 +
                '}';
    }

    @Override
    public Pokemon clone() {
        Ability ability1;
        if (this.ability1 == null) {
            ability1 = null;
        } else {
            ability1 = this.ability1.clone();
        }

        Ability ability2;
        if (this.ability2 == null) {
            ability2 = null;
        } else {
            ability2 = this.ability2.clone();
        }

        return new Pokemon(name, HP, normalAttack, specialAttack, defense, specialDefense, ability1, ability2);
    }
}

package proiectPOO.pokemon;

public class Ability implements Cloneable {
    private final int dmg;
    private final boolean stun;
    private final boolean dodge;
    private int cd;

    public Ability(int dmg, boolean stun, boolean dodge, int cd) {
        this.dmg = dmg;
        this.stun = stun;
        this.dodge = dodge;
        this.cd = cd;
    }

    public int getDmg() {
        return dmg;
    }

    public boolean isStun() {
        return stun;
    }

    public boolean isDodge() {
        return dodge;
    }

    public int getCd() {
        return cd;
    }

    @Override
    public String toString() {
        return "Ability{" +
                "dmg=" + dmg +
                ", stun=" + stun +
                ", dodge=" + dodge +
                ", cd=" + cd +
                '}';
    }

    @Override
    public Ability clone() {
        return new Ability(this.dmg, this.stun, this.dodge, this.cd);
    }
}

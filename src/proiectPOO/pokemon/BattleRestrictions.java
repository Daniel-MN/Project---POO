package proiectPOO.pokemon;

public class BattleRestrictions {
    private boolean isStunnedTime1;
    private boolean isStunnedTime2;
    private boolean hasDodge;

    BattleRestrictions() {
        this.isStunnedTime1 = false;
        this.isStunnedTime2 = false;
        this.hasDodge = false;
    }

    void nextAttacks() {
        this.isStunnedTime1 = this.isStunnedTime2;
        this.hasDodge = false;
    }

    public boolean isStunnedTime1() {
        return isStunnedTime1;
    }

    public boolean isHasDodge() {
        return hasDodge;
    }

    public void setStunnedTime2(boolean stunnedTime2) {
        isStunnedTime2 = stunnedTime2;
    }

    public void setHasDodge(boolean hasDodge) {
        this.hasDodge = hasDodge;
    }
}

package PokemonPack;

public class Stats {
    private int hp;
    private int attackPower;
    private int defensePower;

    public Stats() {
        
    }

    public Stats(int hp, int attackPower, int defensePower) {
        this.hp = hp;
        this.attackPower = attackPower;
        this.defensePower = defensePower;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public int getDefensePower() {
        return defensePower;
    }

    public void setDefensePower(int defensePower) {
        this.defensePower = defensePower;
    }

}

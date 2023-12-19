package PokemonPack;

public class Stats {
    private int hp;
    private int attackPower;
    private int defensePower;
    private double effectiveness;

    public Stats() {
        
    }

    public Stats(int hp, int attackPower, int defensePower, double effectiveness) {
        this.hp = hp;
        this.attackPower = attackPower;
        this.defensePower = defensePower;
        this.effectiveness = effectiveness;
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

    public double getEffectiveness() {
        return effectiveness;
    }

    public void setEffectiveness(double effectiveness) {
        this.effectiveness = effectiveness;
    }

    



}

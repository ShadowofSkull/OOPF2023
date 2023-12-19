package game_mechanics;

public class Ball {
    private String type;
    private double catchChance;
    private int catchGrade;

    Ball(String type, double catchChance, int catchGrade) {
        this.type = type;
        this.catchChance = catchChance;
        this.catchGrade = catchGrade;
    }

    public String getType() {
        return this.type;
    }

    public double getCatchChance() {
        return this.catchChance;
    }

    public int getCatchGrade() {
        return this.catchGrade;
    }

    @Override
    public String toString() {
        return "Ball [type=" + type + ", catchChance=" + catchChance + ", catchGrade=" + catchGrade + "]";
    }
}
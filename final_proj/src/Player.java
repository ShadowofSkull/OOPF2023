

import game_mechanics.Attack;

public class Player {
    private String name;
    private int score;

    public Player() {
    }

    public Player(String name, int score) {
        setName(name);
        setScore(score);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScore(int score) {
        if (score >= 0) {
            this.score += Attack.getDamage();
        } else {
            throw new IllegalArgumentException("Score must be a positive integer.");
        }
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return String.format("Player{name='%s', score=%d}", name, score);
    }
}


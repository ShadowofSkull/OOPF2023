package Player;

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
        if (name.length() >= 3 && name.length() <= 15) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Name must be between 3 and 15 characters.");
        }
    }

    public void setScore(int score) {
        if (score >= 0) {
            this.score = score;
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


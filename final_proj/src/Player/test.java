package Player;

public class test {
    public static void main(String[] args) {
        Score s = new Score();
        s.printScore();

        s.updateScore("test", 100);
        s.updateScore("test2", 200);
        s.updateScore("test3", 300);
        s.printScore();

    }
}

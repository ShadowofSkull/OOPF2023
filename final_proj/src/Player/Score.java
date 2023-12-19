package Player;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Score {
    private List<Integer> scores;

    public Score() {
        scores = new ArrayList<>();
    }

    public void updateScore(int score) {
        scores.add(score);
    }

    public void displayLeaderboard() {
        List<Integer> sortedScores = new ArrayList<>(scores);
        Collections.sort(sortedScores, Collections.reverseOrder()); // Sort the entire List in Highest to Lowest.

        // Display only the top five players.
        System.out.println("Leaderboard:");
        for (int i = 0; i < Math.min(sortedScores.size(), 5); i++) {
            System.out.println((i + 1) + ". " + sortedScores.get(i));
        }
    }
}

package Player;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Score {
    List<List<String>> scores;
    private String filePath;

    public Score() {
        this.filePath = "score.txt";
    }

    public void printScore() {

        List<List<String>> records = readFileInto2DList(filePath); // Read the file and store the records in a 2D list
        
        // Sort the records based on the score in descending order
        records.sort((r1, r2) -> Integer.compare(Integer.parseInt(r2.get(1)), Integer.parseInt(r1.get(1))));
        
        // Display only the top 5 scores
        System.out.println("Top 5 Scores:");
        for (int i = 0; i < Math.min(records.size(), 5); i++) { // Math.min() is used to prevent errors when there are less than 5 records.
            List<String> record = records.get(i); 
            
            System.out.println((i + 1) + ". " + record.get(0) + " - " + record.get(1)); // Display the username and score
        }
    }


    public void updateScore(String username, int score) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true))) {
            bw.write(username + "|" + score); // Write the username and score to the file
            bw.newLine(); // Add a new line to the end of the file
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    

    public List<List<String>> readFileInto2DList(String fp) {
        List<List<String>> scores = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fp))) {
            String lines;   // Stores each line of the file
            while ((lines = br.readLine()) != null) { // Read each line of the file
                String[] data = lines.split("\\|"); // Split the line into an array of strings
                scores.add(Arrays.asList(data)); // Add the array of strings as a row in the 2D list
            }
            // Error handling for the file not found case.
        } catch (IOException e) {
            e.printStackTrace();
        }
        return scores;
    }
}

    







    // public void updateScore(int score) {
    //     scores.add(score);
    // }

    // public void displayLeaderboard() {
    //     List<Integer> sortedScores = new ArrayList<>(scores);
    //     Collections.sort(sortedScores, Collections.reverseOrder()); // Sort the entire List in Highest to Lowest.

    //     // Display only the top five players.
    //     System.out.println("Leaderboard:");
    //     for (int i = 0; i < Math.min(sortedScores.size(), 5); i++) {
    //         System.out.println((i + 1) + ". " + sortedScores.get(i));
    //     }
    // }

    



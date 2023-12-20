package Render;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Leaderboard {
    public List<List<String>> scores;
    private String filePath;

    public Leaderboard() {
        this.filePath = "score.txt"; // MAKE SURE when reading the file, the .txt file must have 1 empty line at the end of the file, or error will form
    }

    public void printScore() {

        List<List<String>> scores = readFileInto2DList(filePath); // Read the file and store the records in a 2D list
        
        // Sort the records based on the score in descending order
        // parseInt used to convert the string score to an integer
        // compare is used to compare the two scores
        scores.sort((r1, r2) -> Integer.compare(Integer.parseInt(r2.get(1)), Integer.parseInt(r1.get(1))));
        
        // Display only the top 5 scores
        System.out.println("Top 5 Scores:");
        for (int i = 0; i < Math.min(scores.size(), 5); i++) { // Math.min() is used to prevent errors when there are less than 5 records.
            List<String> record = scores.get(i); 
            
            System.out.println((i + 1) + ". " + record.get(0) + ": " + record.get(1)); // Display the username and score
        }
    }


    public void updateScore(String username, int score) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true))) { // FileWriter is used to append to the file
            bw.write(username + "|" + score); // Write the username and score to the file
            bw.newLine(); // Add a new line to the end of the file
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    

    private List<List<String>> readFileInto2DList(String fp) {
        List<List<String>> scores = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fp))) {
            String lines;   // Stores each line of the file
            while ((lines = reader.readLine()) != null) { // Read each line of the file
                String[] data = lines.split("\\|"); // Split the line into an array of strings
                scores.add(Arrays.asList(data)); // Add the array of strings as a row in the 2D list
            }
            // Error handling if the file is not found.
        } catch (IOException e) {
            e.printStackTrace(); // Print the error message
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

    



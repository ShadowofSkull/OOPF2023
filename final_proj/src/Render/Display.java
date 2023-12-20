package Render;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Display {

    public void displaySlides(String[] slides) throws InterruptedException {
        for (String slide : slides) {
            // Clear console
            System.out.println("\033c");
            System.out.println(slide);
            Thread.sleep(500);

        }

    }

    public static void displayUI(String path) {
        try {
            File file = new File(path);
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                System.out.println(data);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File reading error");
            e.printStackTrace();
        }
    }
}

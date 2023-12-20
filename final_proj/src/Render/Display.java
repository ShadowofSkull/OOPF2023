package Render;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import PokemonPack.Ally;
import PokemonPack.Enemy;

public class Display {

    public static void displayPokemonsHP() throws InterruptedException {
        // Display enemy pokemons
        System.out.println(Enemy.getEnemyPokemons()[0].getStats().getHp());
        System.out.println(Enemy.getEnemyPokemons()[1].getStats().getHp());
        // Display ally pokemons
        System.out.println(Ally.getAllyPokemons()[0].getStats().getHp());
        System.out.println(Ally.getAllyPokemons()[1].getStats().getHp());
        Thread.sleep(2000);

    }

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

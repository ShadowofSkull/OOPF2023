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
        Thread.sleep(3000);

    }

    public static void displaySlides(String[] slides) {
        // Clear console
        for (String slide : slides) {
            System.out.println("\033c");
            System.out.println(slide);
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

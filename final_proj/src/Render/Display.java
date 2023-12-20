package Render;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import PokemonPack.Ally;
import PokemonPack.Enemy;
import PokemonPack.Pokemon;

public class Display {
    public static void displayStats() {
        Pokemon ally1 = Ally.getAllyPokemons()[0];
        Pokemon ally2 = Ally.getAllyPokemons()[1];
        Pokemon enemy1 = Enemy.getEnemyPokemons()[0];
        Pokemon enemy2 = Enemy.getEnemyPokemons()[1];
        // Display stats of ally and enemy pokemon
        System.out.println("ALL POKEMONS CURRENT STATUS");
        System.out.print("ALLY POKEMON 1: " + ally1.getName().toUpperCase() + " HP: " + ally1.getStats().getHp()
                + " TYPE: " + ally1.getType().getType().toUpperCase() + "\t\t\t");
        System.out.println("ENEMY POKEMON 1: " + enemy1.getName().toUpperCase() + " HP: " + enemy1.getStats().getHp()
                + " TYPE: " + enemy1.getType().getType().toUpperCase());
        System.out.print("ALLY POKEMON 2: " + ally2.getName().toUpperCase() + " HP: " + ally2.getStats().getHp()
                + " TYPE: " + ally2.getType().getType().toUpperCase() + "\t\t\t");
        System.out.println("ENEMY POKEMON 2: " + enemy2.getName().toUpperCase() + " HP: " + enemy2.getStats().getHp()
                + " TYPE: " + enemy2.getType().getType().toUpperCase());
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

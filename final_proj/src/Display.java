import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import PokemonPack.Ally;
import PokemonPack.Enemy;
// not real class temporarily testing
public class Display {

    public static void displayStats() throws InterruptedException {
        // Display enemy pokemons
        System.out.println(Enemy.getEnemyPokemons()[0].getStats().getHp());
        System.out.println(Enemy.getEnemyPokemons()[1].getStats().getHp());
        // Display ally pokemons
        System.out.println(Ally.getAllyPokemons()[0].getStats().getHp());
        System.out.println(Ally.getAllyPokemons()[1].getStats().getHp());
        Thread.sleep(3000);

    }
    // public static void main(String[] args) {
    // try {
    // File myObj = new File("final_proj/pickachu.txt");
    // Scanner myReader = new Scanner(myObj);
    // while (myReader.hasNextLine()) {
    // String data = myReader.nextLine();
    // System.out.println(data);
    // }
    // myReader.close();
    // } catch (FileNotFoundException e) {
    // System.out.println("An error occurred.");
    // e.printStackTrace();
    // }
    // }
}

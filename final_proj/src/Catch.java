import java.util.Random;

import PokemonPack.Enemy;
import PokemonPack.Pokemon;
import Render.CatchingScreen;
import game_mechanics.Ball;
import game_mechanics.PokeballRoulette;

public class Catch {

    public static boolean pokemonCatchable(Pokemon pokemon) {
        int hp = pokemon.getStats().getHp();
        if (hp <= 0)
            return true;
        return false;
    }

    public static void pokeballCaught() throws InterruptedException {
        Pokemon[] enemy = Enemy.getEnemyPokemons();
        int enemyGrade1 = enemy[0].getGrade();
        int enemyGrade2 = enemy[1].getGrade();
        Ball pokeball = PokeballRoulette.getBallSelected();
        int ballGrade = pokeball.getCatchGrade();
        int catchChance = (int) (pokeball.getCatchChance() * 10);
        boolean allowCatch = false;

        Random rand = new Random();
        int randNum = rand.nextInt(10);
        // Chance system
        switch (catchChance) {
            case 1:
                if (randNum == 0)
                    allowCatch = true;
                break;
            case 3:
                for (int i = 0; i < 3; i++) {
                    if (randNum == i) {
                        allowCatch = true;
                        break;
                    }
                }
                break;
            case 5:
                for (int i = 0; i < 5; i++) {
                    if (randNum == i) {
                        allowCatch = true;
                        break;
                    }
                }
                break;
            case 9:
                for (int i = 0; i < 9; i++) {
                    if (randNum == i) {
                        allowCatch = true;
                        break;
                    }
                }
                break;
            default:
                System.out.println("Error in catch chance");
                break;
        }

        // Display catching pokemon screen for anticipation
        CatchingScreen catchingScreen = new CatchingScreen();
        for (int i = 0; i < 3; i++) {
            catchingScreen.displayCatchingAnimation();
        }
        System.out.println("\033c");
        // comparing grade of enemy pokemon to grade of pokeball and chance
        if ((enemyGrade1 <= ballGrade) && allowCatch && pokemonCatchable(enemy[0])) {
            System.out.printf("Enemy Pokemon 1 %s is caught with %s%n", enemy[0].getName(), pokeball.getType());
        } else {
            System.out.printf("Enemy Pokemon 1 %s is not caught with %s%n", enemy[0].getName(), pokeball.getType());
        }
        if ((enemyGrade2 <= ballGrade) && allowCatch && pokemonCatchable(enemy[1])) {
            System.out.printf("Enemy Pokemon 2 %s is caught with %s%n", enemy[1].getName(), pokeball.getType());
        } else {
            System.out.printf("Enemy Pokemon 2 %s is not caught with %s%n", enemy[1].getName(), pokeball.getType());
        }
        
    }
}

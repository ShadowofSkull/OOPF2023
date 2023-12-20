import java.util.Random;

import PokemonPack.Enemy;
import PokemonPack.Pokemon;
import game_mechanics.Ball;
import game_mechanics.PokeballRoulette;

public class Catch {

    public static boolean pokemonCatchable(Pokemon pokemon) {
        int hp = pokemon.getStats().getHp();
        if (hp <= 0)
            return true;
        return false;
    }

    public static boolean pokeballCaught() {
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
        boolean enemy1Caught = false;
        boolean enemy2Caught = false;
        // comparing grade of enemy pokemon to grade of pokeball and chance
        if ((enemyGrade1 <= ballGrade) && allowCatch && pokemonCatchable(enemy[0])) {
            System.out.println("Pokemon1 caught");
            enemy1Caught = true;
        } else {
            System.out.println("Pokemon1 not caught");
        }
        if ((enemyGrade2 <= ballGrade) && allowCatch && pokemonCatchable(enemy[1])) {
            System.out.println("Pokemon2 caught");
            enemy2Caught = true;
        } else {
            System.out.println("Pokemon2 not caught");
        }
        System.out.println(PokeballRoulette.getBallSelected());

        if (enemy1Caught && enemy2Caught) {
            return true;
        }
        return false;

    }
}

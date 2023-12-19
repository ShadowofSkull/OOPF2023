import java.util.Random;

import PokemonPack.Enemy;
import PokemonPack.Pokemon;
import game_mechanics.Ball;
import game_mechanics.PokeballRoulette;

public class Catch {
    private static int hp;

    public static int getHp() {
        return hp;
    }

    public static void setHp(int hp) {
        Catch.hp = hp;
    }

    public static boolean pokemonCatchable() {
        // this.hp = Pokemon.getHP();
        // temp placeholder to get hp
        if (hp == 0)
            return true;
        return false;
    }

    public static void pokeballCaught() {
        Pokemon[] pokemonGrade = Enemy.getEnemyPokemons();
        int pokemonGrade1 = pokemonGrade[0].getGrade();
        int pokemonGrade2 = pokemonGrade[1].getGrade();
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
                    if (randNum == i)
                        allowCatch = true;
                }
                break;
            case 5:
                for (int i = 0; i < 5; i++) {
                    if (randNum == i)
                        allowCatch = true;
                }
                break;
            case 9:
                for (int i = 0; i < 9; i++) {
                    if (randNum == i)
                        allowCatch = true;
                }
        
            default:
                System.out.println("Error in catch chance");
                break;
        }
        
        // comparing grade of enemy pokemon to grade of pokeball and chance
        if (pokemonGrade1 <= ballGrade && allowCatch) {
            System.out.println("Pokemon1 caught");
        } else {
            System.out.println("Pokemon1 not caught");
        }
        if (pokemonGrade2 <= ballGrade && allowCatch) {
            System.out.println("Pokemon2 caught");
        } else {
            System.out.println("Pokemon2 not caught");
        }
    }
}

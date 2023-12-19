package PokemonPack;

import java.util.Random;

public class Enemy {
    private static Pokemon[] enemyPokemons = {
            clonePokemon(Pokemon.getRandomPokemon()),
            clonePokemon(Pokemon.getRandomPokemon())
    };

    // To clone pokemon and throw exception if it fails
    private static Pokemon clonePokemon(Pokemon pokemon) {
        try {
            return (Pokemon) pokemon.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Pokemon[] getEnemyPokemons() {
        return enemyPokemons;
    }

    public static void displayHP() {
        System.out.println("Enemy Pokemon 1 HP: " + enemyPokemons[0].getStats().getHp());
        System.out.println("Enemy Pokemon 2 HP: " + enemyPokemons[1].getStats().getHp());
    }

    public static int botDamage() {
        Random rand = new Random();
        int damage = rand.nextInt(10000);
        return damage;
    }

    public static int botDefend() {
        Random rand = new Random();
        int defend = rand.nextInt(5000);
        return defend;
    }
}

package PokemonPack;

import java.util.Random;

public class Enemy {
    private static Pokemon[] enemyPokemons = {
            clonePokemon(Pokemon.getRandomPokemon()),
            clonePokemon(Pokemon.getRandomPokemon())
    };

    // To clone premade pokemon stats so it doesn't modify the premade stats and throw exception if it fails
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

    public static int botDamage() {
        Random rand = new Random();
        int max = 8000;
        int min = 4000;
        // Generate random number between 4000-8000
        int damage = rand.nextInt(max- min) + min;
        return damage;
    }

    public static int botDefend() {
        Random rand = new Random();
        int max = 5000;
        int min = 2500;
        // Generate random number between 2500-5000
        int defend = rand.nextInt(max - min) + min;
        return defend;
    }
}

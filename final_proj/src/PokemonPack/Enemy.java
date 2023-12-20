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
        int damage = rand.nextInt(10000);
        return damage;
    }

    public static int botDefend() {
        Random rand = new Random();
        int defend = rand.nextInt(5000);
        return defend;
    }
}

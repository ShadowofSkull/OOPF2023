package PokemonPack;

import java.util.Arrays;

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

    // not necessary
    public static String toStringEnemyPokemons() {
        return Arrays.toString(enemyPokemons);
    }
}

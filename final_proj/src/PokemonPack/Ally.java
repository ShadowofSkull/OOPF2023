package PokemonPack;


public class Ally{
    private static Pokemon[] allyPokemons = new Pokemon[2];

    public static void choosePokemon(Pokemon pokemon) {
        allyPokemons[0] = clonePokemon(Pokemon.getRandomPokemon());
        allyPokemons[1] = pokemon;
    }

    // To clone premade pokemon stats so it doesn't modify the premade stats and throw exception if it fails
    private static Pokemon clonePokemon(Pokemon pokemon) {
        try {
            return (Pokemon) pokemon.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Pokemon[] getAllyPokemons() {
        return allyPokemons;
    }

    public static Pokemon[] displayPokemons() {
        System.out.println("\033c");
        System.out.println("Pick a pokemon by pressing 1-3 to choose: ");
        Pokemon pokemon1 = clonePokemon(Pokemon.getRandomPokemon());
        Pokemon pokemon2 = clonePokemon(Pokemon.getRandomPokemon());
        Pokemon pokemon3 = clonePokemon(Pokemon.getRandomPokemon());
        System.out.println("1. " + pokemon1.getName());
        System.out.println("2. " + pokemon2.getName());
        System.out.println("3. " + pokemon3.getName());

        Pokemon[] pokemons = { pokemon1, pokemon2, pokemon3 };
        return pokemons;
    }

}

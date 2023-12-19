import PokemonPack.Ally;
import PokemonPack.Enemy;
import PokemonPack.Pokemon;
import game_mechanics.Attack;
import game_mechanics.AttackRoulette;
import game_mechanics.Mash;
import game_mechanics.PokeballRoulette;

public class Game {
    public static void main(String[] args) throws Exception {
        // Class to track keyboard input
        Mash mash = new Mash();
        // might end up containing these code in ally
        // Choose one out of three pokemons
        mash.setPhase("choosePokemon");
        Pokemon[] pokemons = Ally.displayPokemons();
        mash.setPokemons(pokemons);

        // Check if player has picked a pokemon every second to know when to move on
        while (mash.getPhase().equals("choosePokemon")) {
            Thread.sleep(1000);
        }

        // Display enemy pokemons
        System.out.println(Enemy.getEnemyPokemons()[0].getStats().getHp());
        System.out.println(Enemy.getEnemyPokemons()[1].getStats().getHp());
        // Display ally pokemons
        System.out.println(Ally.getAllyPokemons()[0].getStats().getHp());
        System.out.println(Ally.getAllyPokemons()[1].getStats().getHp());
        // Wait to allow user to see the pokemons
        Thread.sleep(5000);

        // Battle phase
        // Attack phase
        Attack attack = new Attack(new AttackRoulette(mash), mash);
        attack.attack();
        System.out.println(Enemy.getEnemyPokemons()[0].getStats().getHp());
        System.out.println(Enemy.getEnemyPokemons()[1].getStats().getHp());
        // Display ally pokemons
        System.out.println(Ally.getAllyPokemons()[0].getStats().getHp());
        System.out.println(Ally.getAllyPokemons()[1].getStats().getHp());
        // Defense phase
        // Catch phase

        // Pokeball roulette
        // mash.setPhase("pokeballRoulette");
        // System.out.println("Press space to stop the roulette");

        // PokeballRoulette.displayRoulette();
    }

}

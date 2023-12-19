import PokemonPack.Ally;
import PokemonPack.Enemy;
import PokemonPack.Pokemon;
import game_mechanics.Attack;
import game_mechanics.AttackRoulette;
import game_mechanics.Defend;
import game_mechanics.DefendRoulette;
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

        Display.displayStats();

        // Battle phase
        Battle battle = new Battle(mash);
        battle.battle();
        // Attack phase
        // Attack attack = new Attack(new AttackRoulette(mash), mash);
        // attack.attack();
        // Display.displayStats();

        // // Defense phase
        // Defend defend = new Defend(new DefendRoulette(mash), mash);
        // defend.defend();
        // Display.displayStats();
        // Catch phase
        Thread.sleep(3000);
        // Pokeball roulette
        mash.setPhase("pokeballRoulette");
        PokeballRoulette pokeballRoulette = new PokeballRoulette(mash);
        while (mash.getPhase().equals("pokeballRoulette")) {
            pokeballRoulette.displayPokeballAnimation();
        }
    }

}

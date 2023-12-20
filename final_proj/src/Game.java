import PokemonPack.Ally;
import PokemonPack.Pokemon;
import Render.Display;
import Render.TitleScreen;
import Render.Leaderboard;
import game_mechanics.Mash;

public class Game {
    public static void main(String[] args) throws Exception {
        // Class to track keyboard input
        Mash mash = new Mash();
        
        // Title screen
        mash.setPhase("titleScreen");
        TitleScreen titleScreen = new TitleScreen();
        while (mash.getPhase().equals("titleScreen")) {
            titleScreen.displayTitleAnimation();
        }

        // Choose one out of three pokemons
        Pokemon[] pokemons = Ally.displayPokemons();
        // Store pokemons in mash to know the pokemons that can be chosen by players
        mash.setPokemons(pokemons);

        // Check if player has picked a pokemon every second to know when to move on
        while (mash.getPhase().equals("choosePokemon")) {
            Thread.sleep(1000);
        }
        // Display enemy and ally hp
        Display.displayPokemonsHP();

        // Battle phase
        Battle battle = new Battle(mash);
        battle.battle(); 
        // Scoreboard
        Leaderboard scoreboard = new Leaderboard();
        

    }

}

import PokemonPack.Ally;
import PokemonPack.Pokemon;
import Player.Player;
import Render.TitleScreen;
import Render.Leaderboard;
import game_mechanics.Attack;
import game_mechanics.Mash;
import java.util.Scanner;

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
        Battle.displayStats();
        // Battle phase
        Battle battle = new Battle(mash);
        battle.battle(); 
        
        // Scoreboard and player
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String name = sc.nextLine();
        Player player = new Player(name, Attack.getTotalDamage());
        Leaderboard scoreboard = new Leaderboard();
        scoreboard.updateScore(player.getName(), player.getScore());
        scoreboard.printScore();


    }

}

package game_mechanics;

import java.awt.RenderingHints.Key;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

import PokemonPack.Ally;
import PokemonPack.Pokemon;

public class Mash extends JFrame implements KeyListener {

    private String phase = "";
    private Pokemon[] pokemons;

    public Mash() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.addKeyListener(this);
    }

    public String getPhase() {
        return phase;
    }

    public void setPhase(String phase) {
        this.phase = phase;
    }

    public void setPokemons(Pokemon[] pokemons) {
        this.pokemons = pokemons;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // method not needed
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // method not needed
    }

    // Method to track keyboard input
    @Override
    public void keyReleased(KeyEvent e) {
        // Get keycode of key pressed
        int keyCode = e.getKeyCode();
        // Check if space is pressed
        boolean spacePressed = (keyCode == KeyEvent.VK_SPACE);

        // Title screen
        if ((keyCode == KeyEvent.VK_ENTER) && phase.equals("titleScreen")) {
            System.out.println("GAME LOADING PLEASE WAIT");
            setPhase("choosePokemon");
        }
        // Check if phase is choosePokemon
        if (phase.equals("choosePokemon")) {
            // Let user pick one out of three pokemons
            if (keyCode == KeyEvent.VK_1) {
                System.out.printf("PICKED %s%n%n", pokemons[0].getName());
                Ally.choosePokemon(pokemons[0]);
                setPhase("");
            }
            if (keyCode == KeyEvent.VK_2) {
                System.out.printf("PICKED %s%n%n", pokemons[1].getName());
                Ally.choosePokemon(pokemons[1]);
                setPhase("");
            }
            if (keyCode == KeyEvent.VK_3) {
                System.out.printf("PICKED %s%n%n", pokemons[2].getName());
                Ally.choosePokemon(pokemons[2]);
                setPhase("");
            }

        }

        // Attack/Defense/Pokeball roulette
        if (spacePressed && (phase.equals("attackRoulette") || phase.equals("defendRoulette")
                || phase.equals("pokeballRoulette"))) {
            setPhase("stopRoulette");
        }

        // Spirit phase
        if (spacePressed && phase.equals("spirit")) {
            Spirit.increaseSpirit();
        }

    }

}

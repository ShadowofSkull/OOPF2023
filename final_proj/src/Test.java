import java.util.Random;

import PokemonPack.Ally;
import PokemonPack.Enemy;
import PokemonPack.Pokemon;
import PokemonPack.PokemonType;
import PokemonPack.Stats;
import Render.MashButton;
import game_mechanics.Mash;

public class Test {

    public static void main(String[] args) {
        Mash mash = new Mash();
        mash.setPhase("mash");
        while (true)
            MashButton.displayMashAnimation();

    }
}
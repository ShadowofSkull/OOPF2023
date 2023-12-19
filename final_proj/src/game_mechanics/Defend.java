package game_mechanics;

import PokemonPack.Ally;
import PokemonPack.Enemy;
import PokemonPack.Pokemon;

public class Defend {
    private DefendRoulette defendRoulette;
    private Mash mash;
    private String move;

    public Defend(DefendRoulette defendRoulette, Mash mash) {
        this.defendRoulette = defendRoulette;
        this.mash = mash;
    }

    public String getMove() {
        return move;
    }

    public void setMove(String move) {
        this.move = move;
    }

    public void defend() throws InterruptedException {
        mash.setPhase("defendRoulette");
        while (mash.getPhase().equals("defendRoulette")) {
            defendRoulette.displayDefendAnimation();
        }
        int defend1 = calcDefend(Ally.getAllyPokemons()[0]);
        int defend2 = calcDefend(Ally.getAllyPokemons()[1]);
        int botDamage = Enemy.botDamage();

        // Reduce ally pokemons hp only if bot damage is greater than defend or else hp
        // remain the same
        if (botDamage >= defend1) {
            Ally.getAllyPokemons()[0].getStats()
                    .setHp(Ally.getAllyPokemons()[0].getStats().getHp() - (botDamage - defend1));
        }
        if (botDamage >= defend2) {
            Ally.getAllyPokemons()[1].getStats()
                    .setHp(Ally.getAllyPokemons()[1].getStats().getHp() - (botDamage - defend2));
        }

    }

    private int calcDefend(Pokemon defendingPokemon) {
        return defendRoulette.getDefendBoost() * defendingPokemon.getStats().getDefensePower();

    }

}

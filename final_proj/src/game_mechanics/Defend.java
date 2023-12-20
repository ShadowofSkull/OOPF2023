package game_mechanics;

import PokemonPack.Ally;
import PokemonPack.Enemy;
import PokemonPack.Pokemon;
import Render.Display;

public class Defend {
    private DefendRoulette defendRoulette;
    private Mash mash;
    private String move;
    private Pokemon attackingPokemon;
    private int turn = 1;

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
        // To allow enemy pokemon to attack in turns
        if (turn == 1) {
            turn = 0;
        } else if (turn == 0) {
            turn = 1;
        }
        attackingPokemon = Enemy.getEnemyPokemons()[turn];
        System.out.println("ATTACKING ENEMY POKEMON: " + attackingPokemon.getName().toUpperCase());
        Thread.sleep(5000);
        mash.setPhase("defendRoulette");
        while (mash.getPhase().equals("defendRoulette")) {
            defendRoulette.displayDefendAnimation();
        }
        // Clear console
        System.out.println("\033c");
        int defend1 = calcDefend(Ally.getAllyPokemons()[0]);
        int defend2 = calcDefend(Ally.getAllyPokemons()[1]);
        int botDamage = Enemy.botDamage();

        String[] effectiveType = attackingPokemon.getType().getEffectiveType();
        String[] nonEffectiveType = attackingPokemon.getType().getNonEffectiveType();

        Pokemon ally1 = Ally.getAllyPokemons()[0];
        Pokemon ally2 = Ally.getAllyPokemons()[1];
        String ally1Type = ally1.getType().getType();
        String ally2Type = ally2.getType().getType();

        for (String effective : effectiveType) {
            if (effective.equals(ally1Type)) {
                botDamage *= 1.5;
            }
            if (effective.equals(ally2Type)) {
                botDamage *= 1.5;
            }
        }
        for (String nonEffective : nonEffectiveType) {
            if (nonEffective.equals(ally1Type)) {
                botDamage *= 0.5;
            }
            if (nonEffective.equals(ally2Type)) {
                botDamage *= 0.5;
            }
        }
        
        System.out.println("BEFORE ATTACK:");
        System.out.println(ally1.getName() + " HP: " + ally1.getStats().getHp());
        System.out.println(ally2.getName() + " HP: " + ally2.getStats().getHp() + "\n");
        // Display damage caused
        System.out.println("DAMAGE CAUSED:");
        System.out.println("Damage received by " + ally1.getName().toUpperCase() + ": " + botDamage);
        System.out.println("Damage received by " + ally2.getName().toUpperCase() + ": " + botDamage + "\n");

        // Reduce ally pokemons hp only if bot damage is greater than defend or else hp
        // remain the same
        if (botDamage >= defend1) {
            ally1.getStats().setHp(ally1.getStats().getHp() - (botDamage - defend1));
        }
        if (botDamage >= defend2) {
            ally2.getStats().setHp(ally2.getStats().getHp() - (botDamage - defend2));
        }
        // Display hp after attack
        System.out.println("AFTER ATTACK:");
        Display.displayStats();
    }

    private int calcDefend(Pokemon defendingPokemon) {
        return defendRoulette.getDefendBoost() * defendingPokemon.getStats().getDefensePower();

    }

}

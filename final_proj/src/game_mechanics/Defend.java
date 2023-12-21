package game_mechanics;

import PokemonPack.Ally;
import PokemonPack.Enemy;
import PokemonPack.Pokemon;
import Render.Display;
import Render.FireAttack;
import Render.LightningAttack;
import Render.PokemonRender;
import Render.WaterAttack;

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
        if (turn == 1 && Enemy.getEnemyPokemons()[0].getStats().getHp() > 0) {
            turn = 0;
        } else if (turn == 0 && Enemy.getEnemyPokemons()[1].getStats().getHp() > 0) {
            turn = 1;
        }
        attackingPokemon = Enemy.getEnemyPokemons()[turn];
        System.out.println("ATTACKING ENEMY POKEMON: " + attackingPokemon.getName().toUpperCase());
        // Display ASCII art
        PokemonRender.displayPokemon(attackingPokemon);
        Thread.sleep(5000);
        mash.setPhase("defendRoulette");
        while (mash.getPhase().equals("defendRoulette")) {
            defendRoulette.displayDefendAnimation();
        }
        // Clear console
        System.out.println("\033c");
        int defend1 = calcDefend(Ally.getAllyPokemons()[0]);
        int defend2 = calcDefend(Ally.getAllyPokemons()[1]);
        int effectiveBotDamage1 = Enemy.botDamage();
        int effectiveBotDamage2 = Enemy.botDamage();

        String[] effectiveType = attackingPokemon.getType().getEffectiveType();
        String[] nonEffectiveType = attackingPokemon.getType().getNonEffectiveType();

        Pokemon ally1 = Ally.getAllyPokemons()[0];
        Pokemon ally2 = Ally.getAllyPokemons()[1];
        String ally1Type = ally1.getType().getType();
        String ally2Type = ally2.getType().getType();

        for (String effective : effectiveType) {
            if (effective.equals(ally1Type)) {
                effectiveBotDamage1 *= 1.5;
            }
            if (effective.equals(ally2Type)) {
                effectiveBotDamage2 *= 1.5;
            }
        }
        for (String nonEffective : nonEffectiveType) {
            if (nonEffective.equals(ally1Type)) {
                effectiveBotDamage1 *= 0.5;
            }
            if (nonEffective.equals(ally2Type)) {
                effectiveBotDamage2 *= 0.5;
            }
        }
        // Switch statement to display attack animation
        switch (attackingPokemon.getType().getType()) {
            case "Fire":
                FireAttack fire = new FireAttack();
                fire.displayFireAnimation();
                break;
            case "Water":
                WaterAttack water = new WaterAttack();
                water.displayWaterAnimation();
                break;
            case "Electric":
                LightningAttack electric = new LightningAttack();
                electric.displayLightningAnimation();
                break;
        }

        System.out.println("BEFORE ATTACK:");
        System.out.println(ally1.getName() + " HP: " + ally1.getStats().getHp());
        System.out.println(ally2.getName() + " HP: " + ally2.getStats().getHp() + "\n");

        // Reduce ally pokemons hp only if bot damage is greater than defend or else hp
        // remain the same
        if (effectiveBotDamage1 >= defend1) {
            ally1.getStats().setHp(ally1.getStats().getHp() - (effectiveBotDamage1 - defend1));
        }
        if (effectiveBotDamage2 >= defend2) {
            ally2.getStats().setHp(ally2.getStats().getHp() - (effectiveBotDamage2 - defend2));
        }
        // Damage dealt to ally pokemon
        System.out.println("DAMAGE DEALT TO " + ally1.getName() + ": " + (effectiveBotDamage1 - defend1));
        System.out.println("DAMAGE DEALT TO " + ally2.getName() + ": " + (effectiveBotDamage2 - defend2) + "\n");

        // Display hp after attack
        System.out.println("AFTER ATTACK:");
        Display.displayStats();
    }

    private int calcDefend(Pokemon defendingPokemon) {
        return defendRoulette.getDefendBoost() * defendingPokemon.getStats().getDefensePower();

    }

}

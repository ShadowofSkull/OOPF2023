package game_mechanics;

import PokemonPack.Ally;
import PokemonPack.Enemy;
import PokemonPack.Pokemon;
import Render.MashButton;
import Render.*;

public class Attack {
    private AttackRoulette attackRoulette;
    private Mash mash;
    private static int totalDamage = 0;
    private Pokemon attackingPokemon;
    private int turn = 1;
    private static int damage;

    public Attack(AttackRoulette attackRoulette, Mash mash) {
        this.attackRoulette = attackRoulette;
        this.mash = mash;
    }

    public void attack() throws InterruptedException {
        // To allow ally pokemon to attack in turns
        if (turn == 1) {
            turn = 0;
        } else if (turn == 0) {
            turn = 1;
        }
        attackingPokemon = Ally.getAllyPokemons()[turn];
        System.out.println("Attacking pokemon: " + attackingPokemon.getName());
        Thread.sleep(1500);
        // Attack roulette
        mash.setPhase("attackRoulette");
        while (mash.getPhase().equals("attackRoulette")) {
            attackRoulette.displayAttackAnimation();
        }
        // Spirit phase
        mash.setPhase("spirit");
        // Allow user to mash for 1 seconds
        // display sleep for 0.5 seconds every slide so 2 is 1 seconds
        MashButton mashButton = new MashButton();
        for (int i = 0; i < 3; i++) {
            
            mashButton.displayMashAnimation();
        }

        // Set phase to empty so spirit can't be increase anymore
        mash.setPhase("");
        System.out.println("Final Spirit: " + Spirit.getSpirit());

        // Display attack animation
        if (attackingPokemon.getType().getType() == "Fire") {
            FireAttack fire = new FireAttack();
            fire.displayFireAnimation();
        } else if (attackingPokemon.getType().getType() == "Water") {
            WaterAttack water = new WaterAttack();
            water.displayWaterAnimation();
        } else if (attackingPokemon.getType().getType() == "Electric") {
            LightningAttack electric = new LightningAttack();
            electric.displayLightningAnimation();
        }

        // Calculate damage
        Attack.damage = calcDamage();
        Attack.totalDamage += Attack.damage;
        System.out.println("Damage: " + damage);
        // Reduce enemy pokemons hp
        Enemy.getEnemyPokemons()[0].getStats().setHp(Enemy.getEnemyPokemons()[0].getStats().getHp() - damage);
        Enemy.getEnemyPokemons()[1].getStats().setHp(Enemy.getEnemyPokemons()[1].getStats().getHp() - damage);
    }

    private int calcDamage() {
        return attackRoulette.getDamageBoost() * Spirit.getSpirit() * attackingPokemon.getStats().getAttackPower();
    }

    public static int getDamage() {
        return damage;
    }

    public static int getTotalDamage() {
        return totalDamage;
    }
}

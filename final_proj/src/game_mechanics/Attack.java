package game_mechanics;

import PokemonPack.Ally;
import PokemonPack.Enemy;
import PokemonPack.Pokemon;
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
        if (turn == 1 && Ally.getAllyPokemons()[0].getStats().getHp() > 0) {
            turn = 0;
        } else if (turn == 0 && Ally.getAllyPokemons()[1].getStats().getHp() > 0) {
            turn = 1;
        }
        attackingPokemon = Ally.getAllyPokemons()[turn];
        System.out.println("ATTACKING ALLY POKEMON: " + attackingPokemon.getName().toUpperCase());
        // Display ASCII art
        PokemonRender.displayPokemon(attackingPokemon);
        Thread.sleep(5000);
        // Attack roulette
        mash.setPhase("attackRoulette");
        while (mash.getPhase().equals("attackRoulette")) {
            attackRoulette.displayAttackAnimation();
        }
        // Spirit phase
        mash.setPhase("spirit");
        // Display spirit animation
        MashButton mashButton = new MashButton();
        for (int i = 0; i < 6; i++) {
            mashButton.displayMashAnimation();
        }

        // Set phase to empty so spirit can't be increase anymore
        mash.setPhase("");
        System.out.println("\033c");
        System.out.println("FINAL SPIRIT: " + Spirit.getSpirit());
        Thread.sleep(2000);

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

        // Calculate damage
        Attack.damage = calcDamage();
        int effectivenessDamage1 = damage;
        int effectivenessDamage2 = damage;
        String[] effectiveType = attackingPokemon.getType().getEffectiveType();
        String[] nonEffectiveType = attackingPokemon.getType().getNonEffectiveType();
        Pokemon enemy1 = Enemy.getEnemyPokemons()[0];
        Pokemon enemy2 = Enemy.getEnemyPokemons()[1];
        // Two different getter in different classes with same name former gets type
        // class in pokemon latter get name of type
        String enemy1Type = enemy1.getType().getType();
        String enemy2Type = enemy2.getType().getType();

        for (String effective : effectiveType) {
            if (effective.equals(enemy1Type)) {
                effectivenessDamage1 *= 1.5;
            }
            if (effective.equals(enemy2Type)) {
                effectivenessDamage2 *= 1.5;
            }
        }
        for (String nonEffective : nonEffectiveType) {
            if (nonEffective.equals(enemy1Type)) {
                effectivenessDamage1 *= 0.5;
            }
            if (nonEffective.equals(enemy2Type)) {
                effectivenessDamage2 *= 0.5;
            }
        }
        Attack.totalDamage += (effectivenessDamage1 + effectivenessDamage2);
        // Display hp before attack
        System.out.println("BEFORE ATTACK:");
        System.out.println(Enemy.getEnemyPokemons()[0].getName() + " HP: "
                + Enemy.getEnemyPokemons()[0].getStats().getHp());
        System.out.println(Enemy.getEnemyPokemons()[1].getName() + " HP: "
                + Enemy.getEnemyPokemons()[1].getStats().getHp() + "\n");

        // Reduce enemy pokemons hp
        int defend = Enemy.botDefend();
        Enemy.getEnemyPokemons()[0].getStats()
                .setHp(Enemy.getEnemyPokemons()[0].getStats().getHp() - effectivenessDamage1 + defend);
        Enemy.getEnemyPokemons()[1].getStats()
                .setHp(Enemy.getEnemyPokemons()[1].getStats().getHp() - effectivenessDamage2 + defend);

        // Damage dealt to enemy pokemon
        System.out.println("DAMAGE DEALT TO " + Enemy.getEnemyPokemons()[0].getName() + ": "
                + (effectivenessDamage1 - defend));
        System.out.println("DAMAGE DEALT TO " + Enemy.getEnemyPokemons()[1].getName() + ": "
                + (effectivenessDamage2 - defend) + "\n");

        // Display hp after attack
        System.out.println("AFTER ATTACK:");
        Display.displayStats();

    }

    private int calcDamage() {
        return attackRoulette.getDamageBoost() * Spirit.getSpirit() * attackingPokemon.getStats().getAttackPower() / 10;
    }

    public static int getDamage() {
        return damage;
    }

    public static int getTotalDamage() {
        return totalDamage;
    }
}

package game_mechanics;

import PokemonPack.Ally;
import PokemonPack.Enemy;
import PokemonPack.Pokemon;

public class Attack{
    private AttackRoulette attackRoulette;
    private Mash mash;
    private Pokemon attackingPokemon;
    private int turn = 1;
    private int damage;

    public Attack(AttackRoulette attackRoulette, Mash mash) {
        this.attackRoulette = attackRoulette;
        this.mash = mash;
    }

    public void attack() throws InterruptedException{
        // To allow ally pokemon to attack in turns
        if (turn == 1){
            turn = 0;
        }
        else if (turn == 0){
            turn = 1;
        }
        attackingPokemon = Ally.getAllyPokemons()[turn];

        // Attack roulette
        mash.setPhase("attackRoulette");
        while (mash.getPhase().equals("attackRoulette")) {
            attackRoulette.displayAttackAnimation();
        }
        // Spirit phase
        mash.setPhase("spirit");
        System.out.println("Press space to increase SPIRIT!");
        // Allow user to mash for 2 seconds
        Thread.sleep(2000);
        System.out.println("Final Spirit: " + Spirit.getSpirit());
        // Calculate damage
        this.damage = calcDamage();
        System.out.println("Damage: " + damage);
        // Reduce enemy pokemons hp
        Enemy.getEnemyPokemons()[0].getStats().setHp(Enemy.getEnemyPokemons()[0].getStats().getHp() - damage);
        Enemy.getEnemyPokemons()[1].getStats().setHp(Enemy.getEnemyPokemons()[1].getStats().getHp() - damage);
    }

    private int calcDamage() {
        return attackRoulette.getDamageBoost() * Spirit.getSpirit() * attackingPokemon.getStats().getAttackPower();
    }

    public int getDamage() {
        return damage;
    }
}

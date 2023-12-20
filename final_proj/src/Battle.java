import PokemonPack.Ally;
import PokemonPack.Enemy;
import game_mechanics.Attack;
import game_mechanics.AttackRoulette;
import game_mechanics.Defend;
import game_mechanics.DefendRoulette;
import game_mechanics.Mash;
import game_mechanics.PokeballRoulette;

public class Battle {
    private Attack attack;
    private Defend defend;
    private Mash mash;

    public Battle(Mash mash) {
        this.attack = new Attack(new AttackRoulette(mash), mash);
        this.defend = new Defend(new DefendRoulette(mash), mash);
        this.mash = mash;
    }

    // Battle phase
    public void battle() throws InterruptedException {
        while (Enemy.getEnemyPokemons()[0].getStats().getHp() > 0
                && Enemy.getEnemyPokemons()[1].getStats().getHp() > 0) {
            // Attack phase
            attack.attack();
            Battle.displayStats();
            // Check if catch phase requirement is met
            if (Catch.pokemonCatchable(Enemy.getEnemyPokemons()[0])
                    && Catch.pokemonCatchable(Enemy.getEnemyPokemons()[1])) {
                mash.setPhase("pokeballRoulette");
                PokeballRoulette pokeballRoulette = new PokeballRoulette(mash);
                while (mash.getPhase().equals("pokeballRoulette")) {
                    pokeballRoulette.displayPokeballAnimation();
                }
                Catch.pokeballCaught();
                return;
                
            }
            // Defense phase
            defend.defend();
            Battle.displayStats();
        }

    }

    public static void displayStats() throws InterruptedException {
        // Display enemy pokemons
        System.out.println(Enemy.getEnemyPokemons()[0].getStats().getHp());
        System.out.println(Enemy.getEnemyPokemons()[1].getStats().getHp());
        // Display ally pokemons
        System.out.println(Ally.getAllyPokemons()[0].getStats().getHp());
        System.out.println(Ally.getAllyPokemons()[1].getStats().getHp());
        Thread.sleep(3000);

    }
}

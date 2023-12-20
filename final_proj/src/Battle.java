import PokemonPack.Ally;
import PokemonPack.Enemy;
import PokemonPack.Pokemon;
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
        while (true) {
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

            // Check if player lost
            if (Ally.getAllyPokemons()[0].getStats().getHp() <= 0
                    && Ally.getAllyPokemons()[1].getStats().getHp() <= 0) {
                System.out.println("You lost");
                return;
            }
        }

    }

    public static void displayStats() throws InterruptedException {
        Pokemon ally1 = Ally.getAllyPokemons()[0];
        Pokemon ally2 = Ally.getAllyPokemons()[1];
        Pokemon enemy1 = Enemy.getEnemyPokemons()[0];
        Pokemon enemy2 = Enemy.getEnemyPokemons()[1];
        // Display stats of ally and enemy pokemon
        System.out.println("All pokemons current status");
        System.out.print("Ally Pokemon 1: " + ally1.getName() + " HP: " + ally1.getStats().getHp() + " Type: " + ally1.getType().getType() + "\t\t");
        System.out.println("Enemy Pokemon 1: " + enemy1.getName() + " HP: " + enemy1.getStats().getHp() + " Type: " + enemy1.getType().getType());
        System.out.print("Ally Pokemon 2: " + ally2.getName() + " HP: " + ally2.getStats().getHp() + " Type: " + ally2.getType().getType() + "\t\t");
        System.out.println("Enemy Pokemon 2: " + enemy2.getName() + " HP: " + enemy2.getStats().getHp() + " Type: " + enemy2.getType().getType());
        Thread.sleep(6000);
    }
}

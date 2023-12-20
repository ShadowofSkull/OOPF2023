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
            Thread.sleep(5000);
            System.out.println("\033c");

            System.out.println(
                    "----------------------------------------\n\nYOUR TURN TO ATTACK\n\n----------------------------------------");
            attack.attack();
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
            Thread.sleep(5000);
            System.out.println("\033c");
            System.out.println(
                    "----------------------------------------\n\nENEMY TURN TO ATTACK\n\n----------------------------------------");
            defend.defend();

            // Check if player lost
            if (Ally.getAllyPokemons()[0].getStats().getHp() <= 0
                    && Ally.getAllyPokemons()[1].getStats().getHp() <= 0) {
                System.out.println("YOU LOST");
                return;
            }
        }

    }

}

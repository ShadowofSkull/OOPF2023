package PokemonPack;

import java.util.Random;

public class Pokemon implements Cloneable {
    private String name;
    private PokemonType type;
    private int power_level;
    private Stats stats;
    private int grade;
    private static Pokemon[] pokemons = {
            new Pokemon("Charmander", new PokemonType("Fire", "Fire Blast", "Fire Wall"), 100,
                    new Stats(18000, 80, 100, 100), 1),
            new Pokemon("Squirtle", new PokemonType("Water", "Water Blast", "Water Wall"), 100,
                    new Stats(17000, 90, 100, 100), 1),
            new Pokemon("Pikachu", new PokemonType("Electric", "Thunderbolt", "Electric Shield"), 100,
                    new Stats(20000, 100, 100, 100), 1) };

    public Pokemon() {
    }

    public Pokemon(String name, PokemonType type, int power_level, Stats stats) {
        this.name = name;
        setType(type); // Add validation check for PokemonType
        this.power_level = power_level;
        this.stats = stats;
    }

    public Pokemon(String name, PokemonType type, int power_level, Stats stats, int grade) {
        this.name = name;
        this.type = type;
        this.power_level = power_level;
        this.stats = stats;
        setGrade(grade);
    }

    public void setType(PokemonType type) {
        if (type.getType().equals("Fire") || type.getType().equals("Water") || type.getType().equals("Electric")) {
            this.type = type;
        } else {
            throw new IllegalArgumentException("Invalid PokemonType. Only Fire, Water, and Electric are allowed.");
        }
    }

    public void setGrade(int grade) {
        if (grade >= 1 && grade <= 4) {
            this.grade = grade;
        } else {
            throw new IllegalArgumentException("Grade must be between 1 and 4.");
        }
    }

    public static Pokemon getRandomPokemon() {
        Random rand = new Random();
        int randNum = rand.nextInt(3);
        return pokemons[randNum];
    }

    // To clone preset pokemons so their hp can be changed without affecting the
    // original or each other
    public Object clone() throws CloneNotSupportedException {
        Pokemon p = (Pokemon) super.clone();
        p.stats = new Stats(this.stats.getHp(), this.stats.getAttackPower(), this.stats.getDefensePower(),
                this.stats.getEffectiveness());
        return p;
    }

    public int getGrade() {
        return grade;
    }

    public String getName() {
        return name;
    }

    public PokemonType getType() {
        return type;
    }

    public int getPower_level() {
        return power_level;
    }

    public Stats getStats() {
        return stats;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPower_level(int power_level) {
        this.power_level = power_level;
    }

    public void setStats(Stats stats) {
        this.stats = stats;
    }


    @Override
    public String toString() {
        return String.format(
                "Name: %s\n" + "Type: %s\n" + "Power Level: %d\n" + "HP: %d\n" + "Attack Power: %d\n"
                        + "Defense Power: %d\n" + "Effectiveness: %s\n" + "Unique Skill: %s\n" + "Unique Defense: %s\n"
                        + "Weakness Type: %s\n" + "Effective Type: %s\n" + "Grade: %d",
                this.name, this.type.getType(), this.power_level, this.stats.getHp(), this.stats.getAttackPower(),
                this.stats.getDefensePower(), this.stats.getEffectiveness(), this.type.getUnique_skill(),
                this.type.getUnique_defense(), this.type.getNonEffectiveType(), this.type.getEffective_type(),
                this.grade);
    }
}
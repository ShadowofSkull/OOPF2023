package PokemonPack;

import java.util.Random;

public class Pokemon implements Cloneable { // Cloneable is used to clone the preset pokemons
    private String name;
    private PokemonType type;
    private int power_level;
    private Stats stats;
    private int grade;
    private static Pokemon[] pokemons = {
            new Pokemon("Charmander", new PokemonType("Fire", "Fire Blast", "Fire Wall"), 100,
                    new Stats(18000, 80, 70), 1),
            new Pokemon("Squirtle", new PokemonType("Water", "Water Blast", "Water Wall"), 100,
                    new Stats(17000, 90, 60), 1),
            new Pokemon("Pikachu", new PokemonType("Electric", "Thunderbolt", "Electric Shield"), 100,
                    new Stats(20000, 100, 50), 2) };

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
        // Add validation check for PokemonType
        if (type.getType().equals("Fire") || type.getType().equals("Water") || type.getType().equals("Electric")) {
            this.type = type;
        } else {
            throw new IllegalArgumentException("Invalid PokemonType. Only Fire, Water, and Electric are allowed.");
        }
    }

    public void setGrade(int grade) {
        // Add validation check for grade
        if (grade >= 1 && grade <= 4) {
            this.grade = grade;
        } else {
            // Throw an exception if the grade is not between 1 and 4
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
        p.stats = new Stats(this.stats.getHp(), this.stats.getAttackPower(), this.stats.getDefensePower());
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
                        + "Defense Power: %d\n" + "Unique Skill: %s\n" + "Unique Defense: %s\n"
                        + "Weakness Type: %s\n" + "Effective Type: %s\n" + "Grade: %d",
                this.name, this.type.getType(), this.power_level, this.stats.getHp(), this.stats.getAttackPower(),
                this.stats.getDefensePower(), this.type.getUnique_skill(),
                this.type.getUnique_defense(), this.type.getNonEffectiveType(), this.type.getEffectiveType(),
                this.grade);
    }
}
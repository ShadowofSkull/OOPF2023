package PokemonPack;


public class PokemonType {
    private String type;
    private String[] non_effective_type;
    private String[] effective_type;
    private String unique_skill;
    private String unique_defense;

    public PokemonType() {
    }

    // Constructor
    public PokemonType(String type, String unique_skill, String unique_defense) {
        this.type = type;
        assignEffectiveness();
        this.unique_skill = unique_skill;
        this.unique_defense = unique_defense;
    }

    private void assignEffectiveness() {
        switch (type) {
        case "Fire":
            this.non_effective_type = new String[2];
            this.non_effective_type[0] = "Water";
            this.non_effective_type[1] = "Fire";
            this.effective_type = new String[1];
            this.effective_type[0] = "";
            break;
        case "Water":
            this.non_effective_type = new String[1];
            this.non_effective_type[0] = "Water";
            this.effective_type = new String[1];
            this.effective_type[0] = "Fire";
            break;
        case "Electric":
            this.non_effective_type = new String[1];
            this.non_effective_type[0] = "Electric";
            this.effective_type = new String[1];
            this.effective_type[0] = "Water";
            break;
        default:
            System.out.println("Error assigning effectiveness");
            break;
        }
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        try {
            this.type = type;
        } catch (Exception e) {
            System.out.println("Error setting type: " + e.getMessage());
        }
    }

    public String[] getNonEffectiveType() {
        return non_effective_type;
    }

    public String[] getEffectiveType() {
        return effective_type;
    }

    public String getUnique_skill() {
        return unique_skill;
    }

    public void setUnique_skill(String unique_skill) {
        try {
            this.unique_skill = unique_skill;
        } catch (Exception e) {
            System.out.println("Error setting unique skill: " + e.getMessage());
        }
    }

    public String getUnique_defense() {
        return unique_defense;
    }

    public void setUnique_defense(String unique_defense) {
        try {
            this.unique_defense = unique_defense;
        } catch (Exception e) {
            System.out.println("Error setting unique defense: " + e.getMessage());
        }
    }

    @Override
    public String toString() {
        return String.format("Type: %s", this.type);
    }

}
package game_mechanics;

public class Spirit {
    private static int spirit = 3;

    public static int getSpirit() {
        return spirit;
    }

    public static void increaseSpirit() {
        Spirit.spirit += 3;
    }

}

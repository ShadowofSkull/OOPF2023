package game_mechanics;

public class PokeballRoulette extends Roulette{
    private static Ball[] balls = { new Ball("Normalball", 0.1, 1), new Ball("Greatball", 0.3, 2), new Ball("Ultraball", 0.5, 3),
            new Ball("Masterball", 0.9, 4) };

    private static Ball ballSelected;

    public PokeballRoulette(Mash mash) {
        super(mash);
    }

    public static Ball getBallSelected() {
        return ballSelected;
    }

    public static void setBallSelected(Ball ballSelected) {
        PokeballRoulette.ballSelected = ballSelected;
    }
    
    public static void displayRoulette() throws InterruptedException {



        displayAnimation();
    }

}
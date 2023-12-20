package game_mechanics;

public class Roulette {
    // roulette require mash to be passed in to determine when to stop the roulette
    private Mash mash;
    private int index;

    public Roulette(Mash mash) {
        this.mash = mash;
    }

    protected void displayRoulette(String[] animationSlides) throws InterruptedException { // displays animation
        index = -1;
        for (String slide : animationSlides) {
            if (mash.getPhase().equals("stopRoulette")) {
                break;
            }
            clearConsole();
            System.out.println(slide);
            System.out.println("Press space to stop the roulette");

            index++;
            Thread.sleep(250);
        }
    }

    public int getIndex() {
        return index;
    }

    private void clearConsole() { // clears the console
        System.out.println("\033c");
    }

}
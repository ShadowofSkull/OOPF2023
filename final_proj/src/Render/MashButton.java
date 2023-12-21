package Render;

import game_mechanics.Spirit;

public class MashButton extends Display {
    @Override
    public void displaySlides(String[] slides) throws InterruptedException {
        for (String slide : slides) {
            // Clear console
            System.out.println("\033c");
            System.out.println(slide.toUpperCase()); // Capitalize all words
            System.out.println("SMASH SPACEBAR TO INCREASE YOUR SPIRIT!");
            System.out.println("SPIRIT: " + Spirit.getSpirit());
            Thread.sleep(100);
        }
    }

    public void displayMashAnimation() throws InterruptedException {
        String[] mashAnimationSlides = { "+----------------------------------------------------------------+\r\n" + //
                "|                                                                |\r\n" + //
                "|       |      |         /\\       //---\\   |       |    | | |    |\r\n" + //
                "|      / \\    / \\       /  \\     --    \\-- |       |    | | |    |\r\n" + //
                "|      | |    | |      |    |    -\\----    |-------|    | | |    |\r\n" + //
                "|     /   \\  /   \\     /----\\      ---\\\\   |-------|    | | |    |\r\n" + //
                "|     |   |  |   |    /      \\  \\-     --  |       |    | | |    |\r\n" + //
                "|    /     \\/     \\  |        |  -\\-----   |       |    - - -    |\r\n" + //
                "|                                                                |\r\n" + //
                "|                                                                |\r\n" + //
                "|                                                                |\r\n" + //
                "|                                                                |\r\n" + //
                "|                       -----------------                        |\r\n" + //
                "|                     -/                 \\-                      |\r\n" + //
                "|                    |                     |                     |\r\n" + //
                "|                    |                     |                     |\r\n" + //
                "|                  ---------------------------                   |\r\n" + //
                "|                  ---------------------------                   |\r\n" + //
                "|                                                                |\r\n" + //
                "|                                                                |\r\n" + //
                "+----------------------------------------------------------------+",
                "+----------------------------------------------------------------+\r\n" + //
                        "|                                                                |\r\n" + //
                        "|       |      |         /\\       //---\\   |       |    | | |    |\r\n" + //
                        "|      / \\    / \\       /  \\     --    \\-- |       |    | | |    |\r\n" + //
                        "|      | |    | |      |    |    -\\----    |-------|    | | |    |\r\n" + //
                        "|     /   \\  /   \\     /----\\      ---\\\\   |-------|    | | |    |\r\n" + //
                        "|     |   |  |   |    /      \\  \\-     --  |       |    | | |    |\r\n" + //
                        "|    /     \\/     \\  |        |  -\\-----   |       |    - - -    |\r\n" + //
                        "|                                                                |\r\n" + //
                        "|                                                                |\r\n" + //
                        "|                        -            -                          |\r\n" + //
                        "|                         \\          /                           |\r\n" + //
                        "|               -          \\        /           -                |\r\n" + //
                        "|                \\-                           -/                 |\r\n" + //
                        "|                  \\-                       -/                   |\r\n" + //
                        "|                       -----------------                        |\r\n" + //
                        "|                  ----/-----------------\\----                   |\r\n" + //
                        "|                  ---------------------------                   |\r\n" + //
                        "|                                                                |\r\n" + //
                        "|                                                                |\r\n" + //
                        "+----------------------------------------------------------------+" };

        displaySlides(mashAnimationSlides);
    }
}

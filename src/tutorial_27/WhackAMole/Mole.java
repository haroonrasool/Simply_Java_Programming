package tutorial_27.WhackAMole;

// Exercise 27.13: Mole.java
// A class that represents the mole in the Whack A Mole application.

import java.awt.*;
import java.util.*;

public class Mole {
    // int for storing the row in which the mole is in
    private int moleRow = -1;

    // int for storing the column in wich the mole is in
    private int moleColumn = -1;

    // Random object to generate new mole position
    private final Random randomGenerator = new Random();

    // draw the mole in a new cell
    public void drawMole(Graphics g) {
        // if mole data is not -1
        if (!(moleRow == -1 || moleColumn == -1)) {
            // calculate cell dimensions
            int x = moleColumn * 50;
            int y = moleRow * 50;

            // set the mole's head color
            g.setColor(new Color(155, 126, 87));

            // draw the mole's head
            g.fillOval(x + 38, y + 72, 44, 44);

            g.setColor(Color.YELLOW); // set the mole's eye color

            // draw the mole's eyes
            g.fillOval(x + 47, y + 84, 8, 8);
            g.fillOval(x + 65, y + 84, 8, 8);

            g.setColor(Color.BLACK); // set the mole's nose color
            g.fillOval(x + 58, y + 97, 5, 5); // draw the mole's nose

        } // end if

    } // end method drawMole

    // move the mole to a random hole
    public void moveMole() {
        // create random chart location
        moleRow = randomGenerator.nextInt(5);
        moleColumn = randomGenerator.nextInt(5);

    } // end method move

    // clear mole data so that a new game can begin
    public void reset() {
        moleRow = -1;
        moleColumn = -1;

    } // end method reset

    // returns whether or not mole is hit by given mouse coordinates
    public boolean isHit(int mouseX, int mouseY) {
        // if game has not yet started
        if (moleRow == -1) {
            return false;
        }

        // calculate cell dimensions
        int x = moleColumn * 50;
        int y = moleRow * 50;

        // if mouse coordinate are inside the mole's current cell
       // user missed hitting the mole
       return mouseX > 35 + x && mouseX < 85 + x &&
               mouseY > 68 + y && mouseY < 118 + y;

    } // end method isHit

} // end class Mole

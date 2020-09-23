package tutorial_20.BrickWall;

// Exercise 20.11: DrawJPanel.java
// This class defines the DrawJPanel object.

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class DrawJPanel extends JPanel {
    // ArrayList object to hold MyRectangle objects
    private final ArrayList<Object> brickArrayList = new ArrayList<>();

    // no-argument constructor
    public DrawJPanel() {
        super();
        drawBricks();
    }  // end constructor

    // add randomNumber brick to ArrayList and draw all bricks
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // iterate through ArrayList and draw all MyRectangles
        for (Object object : brickArrayList) {
            MyRectangle currentRectangle = (MyRectangle) object;
            // draw brick
            currentRectangle.drawMyRectangle(g);
        } // end for loop

    } // end method paintComponent

    // draw 10 rows and 9 columns of bricks
    public void drawBricks() {
        // declare a new MyRectangle object
        MyRectangle brick;

        // set the bricks color
        Color red = Color.RED;

        // initialize width and height variables
        int width = 45;
        int height = 20;

        // cycling through ech row and column of bricks.

        // outer for loop to cycle through each row of bricks.
        for (int row = 0; row <= 9; row++) {
            // set the y-position
            int y = row * 25;

            // inner for loop to cycle through each column of bricks
            for (int column = 0; column <= 9; column++) {
                // set the x-position
                int x = column * 50;

                // check if the row is odd.
                if (row % 2 == 1) {
                    // draw the odd row of bricks
                    brick = new MyRectangle(x, y, width, height, red);
                } else {
                    // draw the even row of bricks
                    brick = new MyRectangle(x - 25, y, width, height, red);
                }
                brickArrayList.add(brick);
            } // end of inner for loop

        } // end of outer for loop

        // repaint JPanel
        repaint();

    } // end method drawBricks

} // end class DrawJPanel

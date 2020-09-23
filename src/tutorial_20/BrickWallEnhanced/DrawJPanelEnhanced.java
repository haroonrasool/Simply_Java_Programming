package tutorial_20.BrickWallEnhanced;

// Exercise 20.12: DrawJPanel.java
// This class defines the DrawJPanel object.

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class DrawJPanelEnhanced extends JPanel {
    // ArrayList object to hold MyRectangle objects
    private final ArrayList<Object> brickArrayList = new ArrayList<>();

    // no-argument constructor
    public DrawJPanelEnhanced() {
        super();
    }  // end constructor

    // add randomNumber brick to ArrayList and draw all bricks
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // iterate through ArrayList and draw all MyRectangles
        for (Object object : brickArrayList) {
            MyRectangleEnhanced currentRectangle = (MyRectangleEnhanced) object;
            // draw brick
            currentRectangle.drawMyRectangle(g);
        } // end for loop

    } // end method paintComponent

    // create brick wall based on user input
    public void drawBricks(int wallRows, int wallColumns) {
        // clear the JPanel
        clearArray();

        // declare a new MyRectangle object
        MyRectangleEnhanced brick;

        // set the bricks color
        Color myColor = Color.RED;

        // initialize width and height variables
        int width = 45;
        int height = 20;

        // set the y position
        for (int row = 0; row <= wallRows; row++) {
            int y = (9 - row) * 25;

            // set the x position
            for (int column = 0; column <= wallColumns; column++) {
                int x = column * 50;

                // if row is odd
                if (row % 2 == 1) {
                    // draw the odd rows of bricks
                    brick = new MyRectangleEnhanced(x, y, width, height, myColor);
                } else {
                    // draw the even rows of bricks
                    brick = new MyRectangleEnhanced(x - 25, y, width, height, myColor);
                }
                brickArrayList.add(brick);

            } // end inner for

            // add a small brick to the end of even rows
            if (row % 2 == 0) {
                brick = new MyRectangleEnhanced(wallColumns * 50 - 25, y, width - 25, height, myColor);
                brickArrayList.add(brick);
            }

        } // end outer for

        // repaint JPanel
        repaint();

    } // end method drawBricks

    // clear rectangleArray
    public void clearArray() {
        // clear ArrayList
        brickArrayList.clear();

    } // end method clearArray

} // end class DrawJPanel

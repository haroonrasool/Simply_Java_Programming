package tutorial_20.CafeteriaEnhanced;

// Exercise 20.13: DrawJPanel.java
// This class defines the DrawJPanel object.

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class DrawJPanel extends JPanel {
    // ArrayList object to hold MyRectangle objects
    private final ArrayList<Object> barArray = new ArrayList<>();

    // no-argument constructor
    public DrawJPanel() {
        super();
    }  // end constructor

    // draw all bar rectangles
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // iterate through ArrayList and draw all MyRectangles
        for (Object object : barArray) {
            MyRectangle barRectangle =
                    (MyRectangle) object;
            // draw bar
            barRectangle.drawMyRectangle(g);
        } // end for loop

    } // end method paintComponent

    // draw the bar graph
    public void drawGraph(int[] answers) {
        // initializing the local variables
        int x = 5;
        int y = 5;
        int width; // depends on the responses
        int height = 20;

        // create a new MyRectangle object named bar.
        MyRectangle bar;

        // looping through the responses.
        for (int counter = 1; counter <= 10; counter++) {
            width = 15 * answers[counter];

            // draw the bar
            bar = new MyRectangle(x, y, width, height, Color.BLACK);

            // update the y position to secure the graph is evenly spaced
            y = y + 25;

            // add the newly created MyRectangle object bar to barArray
            barArray.add(bar);
        }

        // repaint JPanel
        repaint();

    } // end method drawGraph

} // end class DrawJPanel

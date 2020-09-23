package tutorial_20.ScreenSaver;

// Tutorial 20: DrawJPanel.java
// This class draws a random rectangle every .25 seconds.

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import javax.swing.*;

public class DrawJPanel extends JPanel {
    // Random object to create random numbers
    private final Random randomNumber = new Random();

    // ArrayList object to hold MyRectangle objects
    private final ArrayList<MyRectangle> rectangleArrayList = new ArrayList<>();

    // array of possible MyRectangle colors
    private final Color[] colors = {Color.BLUE, Color.ORANGE, Color.PINK,
            Color.CYAN, Color.MAGENTA, Color.YELLOW, Color.BLACK,
            Color.WHITE, Color.RED, Color.GREEN};

    // no-argument constructor
    public DrawJPanel() {
        super();

        // anonymous inner class
        // event handler called every 250 microseconds
        // end anonymous inner class
        // Timer object to generate events
        // anonymous inner class
        // event handler called every 250 microseconds
        Timer drawTimer = new Timer(250,

                event -> drawTimerActionPerformed() // end anonymous inner class

        ); // end call to new Timer

        drawTimer.start(); // start timer

    }  // end constructor

    // create new MyRectangle object and add it to rectangleArrayList
    private void drawTimerActionPerformed() {
        // get random dimensions and a random color
        int x = randomNumber.nextInt(380);
        int y = randomNumber.nextInt(380);
        int width = randomNumber.nextInt(150);
        int height = randomNumber.nextInt(150);
        int color = randomNumber.nextInt(10);

        // create MyRectangle object and add it to rectangleArrayList
        MyRectangle rectangle = new MyRectangle(x, y, width, height, colors[color]);
        rectangleArrayList.add(rectangle);

        repaint();

    } // end method drawTimerActionPerformed

    // draw all rectangles
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // create iterator
        Iterator<MyRectangle> rectangleIterator = rectangleArrayList.iterator();

        MyRectangle currentRectangle; // create MyRectangle

        // iterate through ArrayList and draw all MyRectangles
        while (rectangleIterator.hasNext()) {
            currentRectangle =
                    rectangleIterator.next();

            currentRectangle.draw(g); // draw rectangle
        }

    } // end method paintComponent

    // clear rectangleArray
    public void clear() {
        rectangleArrayList.clear(); // clear ArrayList

        repaint(); // repaint JPanel

    } // end method clear

} // end class DrawJPanel

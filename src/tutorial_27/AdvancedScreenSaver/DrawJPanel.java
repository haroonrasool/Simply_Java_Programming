package tutorial_27.AdvancedScreenSaver;

// Exercise 27.11: DrawJPanel.java
// JPanel that allows shapes to be drawn on.

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

public class DrawJPanel extends JPanel {

    // ArrayList for storing all of the shapes
    private final ArrayList<MyShape> shapeArrayList = new ArrayList<>();

    // Random object for creating shapes
    private final Random randomNumber = new Random();

    // no-argument constructor
    public DrawJPanel() {
        setBackground(Color.BLACK); // set background color

        // set up drawTimer
        // anonymous inner class
        // event handler called every SHAPE_DELAY
        // end anonymous inner class
        // Timer to fire when another shape should be drawn
        // anonymous inner class
        // event handler called every SHAPE_DELAY
        // set delay for the next shape to be drawn
        int SHAPE_DELAY = 20;
        Timer drawTimer = new Timer(SHAPE_DELAY,

                this::drawTimerActionPerformed // end anonymous inner class

        ); // end drawTimer declaration

        drawTimer.start(); // start timer

        // set up resetTimer
        // anonymous inner class
        // event handler called every CLEAR_DELAY
        // end anonymous inner class
        // Timer to fire when screen should be cleared
        // set delay for the screen to be cleared
        int CLEAR_DELAY = 40000;
        Timer resetTimer = new Timer(CLEAR_DELAY,

                this::resetTimerActionPerformed // end anonymous inner class

        ); // end call to new Timer

        resetTimer.start(); // start timer

    } // end constructor

    // paint all the shapes
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        MyShape nextShape;

        // iterate through all of the shapes
        for (Object object : shapeArrayList) {
            // draw each shape
            nextShape = (MyShape) object;
            nextShape.draw(g);
        }

    } // end method paintComponent

    // paint new shape
    private void drawTimerActionPerformed(ActionEvent actionEvent) {
        // select a random number for the shape type
        int shapeType = randomNumber.nextInt(4);

        // randomly generate the x- and y-coordinates
        int x = randomNumber.nextInt(660) - 35;
        int y = randomNumber.nextInt(510) - 35;

        // randomly generate the width and height of the shape
        int width = randomNumber.nextInt(60) + 6;
        int height = randomNumber.nextInt(60) + 6;

        // randomly generate the color using ints for the red,
        // green, and blue values
        int red = randomNumber.nextInt(200);
        int green = randomNumber.nextInt(200);
        int blue = randomNumber.nextInt(200);
        Color shapeColor = new Color(red, green, blue);

        MyShape currentShape; // create new shape

        // if shape is an outlined oval
        if (shapeType == 0) {
            // create an outlined oval
            currentShape = new MyOval(x, y, width + x + 20, height + y,
                    shapeColor, false);
        } else if (shapeType == 1) // else if shape is a filled oval
        {
            // create a filled oval
            currentShape = new MyOval(x, y, width + x + 20, height + y,
                    shapeColor, true);
        }
        // else if shape is an outlined rectangle
        else if (shapeType == 2) {
            // create an outlined rectangle
            currentShape = new MyRectangle(x, y, width + x,
                    height + y + 20, shapeColor, false);
        } else // else if shape is a filled rectangle
        {
            // create a filled rectangle
            currentShape = new MyRectangle(x, y, width + x,
                    height + y + 20, shapeColor, true);
        }

        // add generated shape to ArrayList
        shapeArrayList.add(currentShape);

        repaint();

    } // end method drawTimerActionPerformed

    // clear the ArrayList
    private void resetTimerActionPerformed(ActionEvent actionEvent) {
        shapeArrayList.clear();
    }

} // end class DrawJPanel

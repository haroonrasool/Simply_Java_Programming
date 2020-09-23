package tutorial_27.LogoDesigner;

// Exercise 27.12: DrawJPanel.java
// Creates a JPanel that allows a user to create shapes on.

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class DrawJPanel extends JPanel {
    // ArrayList for storing all of the shapes
    private final ArrayList<MyShape> shapeArrayList = new ArrayList<>();

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

    // add shape to shapeArray and then repaint
    public void addShape(MyShape shape) {
        shapeArrayList.add(shape);
        repaint();
    } // end method addShape

    // clear the ArrayList
    public void clear() {
        shapeArrayList.clear();
        repaint();
    } // end method clear

} // end class DrawJPanel

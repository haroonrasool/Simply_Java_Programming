package tutorial_27.MovingShapes;

// Exercise 27.16: PaintJPanel.java
// Creates a component that allows a user to draw shapes.

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

public class PaintJPanel extends JPanel {

    // ArrayList for storing all of the shapes
    private final ArrayList<MyMovingShape> shapeArrayList = new ArrayList<>();

    // Color for storing the currently selected color
    private Color currentColor;

    // String for storing which shape type is currently being drawn
    private String currentShapeType = "Line";

    // MyMovingShape for storing the shape currently being drawn
    private MyMovingShape currentShape;

    // constructor
    public PaintJPanel() {
        addMouseListener(

                new MouseAdapter() // anonymous inner class
                {
                    // event handler called when mouse button is pressed
                    public void mousePressed(MouseEvent event) {
                        paintJPanelMousePressed(event);
                    }

                    // event handler called when mouse button is released
                    public void mouseReleased(MouseEvent event) {
                        paintJPanelMouseReleased(event);
                    }

                } // end anonymous inner class

        ); // end call to addMouseListener

        addMouseMotionListener(

                new MouseMotionAdapter() // anonymous inner class
                {
                    // event handler called when the mouse is dragged
                    public void mouseDragged(MouseEvent event) {
                        paintJPanelMouseDragged(event);
                    }

                } // end anonymous inner class

        ); // end call to addMouseMotionListener

        // set timer for moving shapes
        // anonymous inner class
        // event handler called every 30 milliseconds
        // end anonymous inner class
        // Timer for repainting and moving every 30 milliseconds
        // anonymous inner class
        // event handler called every 30 milliseconds
        Timer moveTimer = new Timer(30,

                this::moveTimerActionPerformed // end anonymous inner class

        ); // end moveTimer declaration

        moveTimer.start(); // start timer

    } // end constructor

    // paint all the shapes
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        MyMovingShape nextShape;

        // iterate through all of the shapes
        for (Object object : shapeArrayList) {
            // draw each shape
            nextShape = (MyMovingShape) object;
            nextShape.draw(g);
        }

        // if the user is currently drawing a shape
        if (currentShape != null) {
            // draw the shape currently being drawn by a user
            currentShape.draw(g);
        }

    } // end paintComponent

    // add a shape to the ArrayList
    public void paintJPanelMousePressed(MouseEvent event) {
        // store the new shape being drawn to currentShape
        switch (currentShapeType) {
            case "Line":
                currentShape = new MyLine(event.getX(), event.getY(),
                        event.getX(), event.getY(), currentColor);
                break;
            case "Rectangle":
                currentShape = new MyRectangle(event.getX(), event.getY(),
                        event.getX(), event.getY(), currentColor);
                break;
            case "Oval":
                currentShape = new MyOval(event.getX(), event.getY(),
                        event.getX(), event.getY(), currentColor);
                break;
        }

    } // end method paintJPanelMousePressed

    // resize the shape being drawn
    public void paintJPanelMouseDragged(MouseEvent event) {
        // set the location of currentShape to its resized location
        currentShape.setX2(event.getX());
        currentShape.setY2(event.getY());
    } // end method paintJPanelMouseDragged

    // finish resizing the shape being drawn and start its movement
    public void paintJPanelMouseReleased(MouseEvent event) {
        // set the location of currentShape to its resized location
        currentShape.setX2(event.getX());
        currentShape.setY2(event.getY());

        // add completed shape to shapeArray
        shapeArrayList.add(currentShape);

        // the user is no longer drawing so set currentShape to null
        currentShape = null;

    } // end method paintJPanelMouseReleased

    // move the shapes
    private void moveTimerActionPerformed(ActionEvent event) {
        MyMovingShape nextShape;

        // iterate through all of the shapes
        for (MyMovingShape myMovingShape : shapeArrayList) {
            // move each shape
            nextShape = myMovingShape;
            nextShape.moveShape();
        }

        repaint(); // repaint JPanel

    } // end method drawTimerActionPerformed

    // set currentShapeType value
    public void setCurrentShapeType(String s) {
        currentShapeType = s;

    } // end method setCurrentShapeType

    // set CurrentColor value
    public void setCurrentColor(Color c) {
        currentColor = c;

    } // end method setCurrentColor

} // end class PaintJPanel

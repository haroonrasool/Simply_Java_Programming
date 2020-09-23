package tutorial_22;

// Exercise 21.16: Circle.java
// This class represents a circle.

import java.awt.*;

public class Circle {
    // instance variables
    private int diameter;
    private Point location;
    private Color drawnColor;

    // constructor with size, corner and shade supplied
    public Circle(int size, Point corner, Color shade) {
        setDiameter(size);
        setLocation(corner);
        setDrawnColor(shade);
    } // end constructor

    // get the diameter of the circle
    public int getDiameter() {
        return diameter;
    } // end method getDiameter

    // set the diameter of the circle
    public void setDiameter(int size) {
        diameter = Math.max(size, 0);
    } // end method setDiameter

    // get the location of the upper-left corner of the circle
    public Point getLocation() {
        return location;
    } // end method getLocation

    // set the location of the upper-left corner of the circle
    public void setLocation(Point corner) {
        location = corner;
    } // end method setLocation

    // get the color of the circle
    public Color getDrawnColor() {
        return drawnColor;
    } // end method getDrawnColor

    // set the color of the circle
    public void setDrawnColor(Color shade) {
        drawnColor = shade;
    } // end method setDrawnColor

    // draw the circle
    public void draw(Graphics g) {
        g.setColor(getDrawnColor()); // set the color

        // draw a circle with the specified x, y and diameter
        g.fillOval(getLocation().x, getLocation().y,
                getDiameter(), getDiameter());

    } // end method draw

} // end class Circle

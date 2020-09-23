package tutorial_27.AdvancedScreenSaver;

// Exercise 27.11: MyRectangle.java
// Class that declares a rectangle object.

import java.awt.*;

public class MyRectangle extends MyShape {
    // boolean for storing whether or not the rectangle is filled
    private final boolean filled;

    // constructor
    public MyRectangle(int firstX, int firstY, int secondX,
                       int secondY, Color shapeColor, boolean fill) {
        super(firstX, firstY, secondX, secondY, shapeColor);

        filled = fill; // specify if shape will be filled

    } // end constructor

    // draw a rectangle
    public void draw(Graphics g) {
        // set dimensions of bounding box
        int upperLeftX = Math.min(getX1(), getX2());
        int upperLeftY = Math.min(getY1(), getY2());
        int width = Math.abs(getX1() - getX2());
        int height = Math.abs(getY1() - getY2());

        g.setColor(getColor());

        // if the rectangle is filled
        if (filled) {
            // draw filled rectangle
            g.fillRect(upperLeftX, upperLeftY, width, height);
        } else {
            // draw outlined rectangle
            g.drawRect(upperLeftX, upperLeftY, width, height);
        }

    } // end method draw

} // end class MyRectangle

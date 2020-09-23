package tutorial_27.MovingShapes;

// Exercise 27.16: MyRectangle.java
// Class that declares an rectangle object.

import java.awt.*;

public class MyRectangle extends MyMovingShape {
    // constructor
    public MyRectangle(int firstX, int firstY, int secondX,
                       int secondY, Color shapeColor) {
        super(firstX, firstY, secondX, secondY, shapeColor);

    } // end constructor

    // draw the rectangle
    public void draw(Graphics g) {
        int upperLeftX = Math.min(getX1(), getX2());
        int upperLeftY = Math.min(getY1(), getY2());
        int width = Math.abs(getX1() - getX2());
        int height = Math.abs(getY1() - getY2());

        g.setColor(getColor());
        g.fillRect(upperLeftX, upperLeftY, width, height);

    } // end method draw

} // end class MyRectangle

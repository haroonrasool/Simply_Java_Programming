package tutorial_27.MovingShapes;

// Exercise 27.16: MyLine.java
// Class that declares a line object.

import java.awt.*;

public class MyLine extends MyMovingShape {
    // constructor
    public MyLine(int firstX, int firstY, int secondX, int secondY,
                  Color shapeColor) {
        super(firstX, firstY, secondX, secondY, shapeColor);

    } // end constructor

    // draw the line
    public void draw(Graphics g) {
        g.setColor(getColor());
        g.drawLine(getX1(), getY1(), getX2(), getY2());

    } // end method draw

} // end class MyLine

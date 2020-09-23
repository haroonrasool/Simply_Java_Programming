package tutorial_27.LogoDesigner;

// Exercise 27.12: MyOval.java
// Class that declares an oval object.

import java.awt.*;

public class MyOval extends MyShape {
    // boolean for storing whether or not the oval is filled
    private final boolean filled;

    // constructor
    public MyOval(int firstX, int firstY, int secondX, int secondY,
                  Color shapeColor, boolean fill) {
        super(firstX, firstY, secondX, secondY, shapeColor);

        filled = fill; // specify if shape will be filled

    } // end constructor

    // draw an oval
    public void draw(Graphics g) {
        // set dimensions of bounding box
        int upperLeftX = Math.min(getX1(), getX2());
        int upperLeftY = Math.min(getY1(), getY2());
        int width = Math.abs(getX1() - getX2());
        int height = Math.abs(getY1() - getY2());

        g.setColor(getColor());

        // if the oval is filled
        if (filled) {
            // draw filled oval
            g.fillOval(upperLeftX, upperLeftY, width, height);
        } else {
            // draw outlined oval
            g.drawOval(upperLeftX, upperLeftY, width, height);
        }

    } // end method draw

} // end class MyOval

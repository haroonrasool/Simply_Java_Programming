package tutorial_20.Elevator;

// Exercise 20.13: MyRectangle.java
// This class defines the MyRectangle object.

import java.awt.*;

public class MyRectangle extends Rectangle {
    // instance variable to hold fillColor of MyRectangle
    private Color fillColor;

    // constructor
    public MyRectangle(int xValue, int yValue, int widthValue,
                       int heightValue, Color colorValue) {
        // call constructor of superclass
        super(xValue, yValue, widthValue, heightValue);

        // set fillColor of MyRectangle
        setFillColor(colorValue);

    } // end constructor

    // set fillColor value
    public void setFillColor(Color colorValue) {
        fillColor = colorValue;

    } // end method setColor

    // draw MyRectangle
    public void drawMyRectangle(Graphics g) {
        g.setColor(fillColor);
        g.fillRect(x, y, width, height);

    } // end method drawRect

} // end class MyRectangle

package tutorial_20.BrickWallEnhanced;

// Tutorial 20: MyRectangle.java
// This class defines the MyRectangle object.

import java.awt.*;

public class MyRectangleEnhanced extends Rectangle {
    // instance variable to hold fillColor of MyRectangle
    private Color fillColor;

    // constructor
    public MyRectangleEnhanced(int xValue, int yValue, int widthValue,
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

    // get fillColor value
    public Color getFillColor() {
        return fillColor;
    } // end method getColor

    // method drawMyRectangle
    public void drawMyRectangle(Graphics g) {
        g.setColor(fillColor);
        g.fillRect(x, y, width, height);
    } // end method drawMyRectangle

} // end class MyRectangle

package tutorial_27.MovingShapes;

// Exercise 27.16: MyMovingShape.java
// Superclass for all Shape objects.

import java.awt.*;
import java.util.Random;

public abstract class MyMovingShape {
    // ints for storing the location of the shape
    private int x1;
    private int y1;
    private int x2;
    private int y2;

    // Color for storing the color of the shape
    private Color color;

    // ints for storing the change in position
    private int dx;
    private int dy;

    // constructor
    public MyMovingShape(int firstX, int firstY, int secondX,
                         int secondY, Color shapeColor) {
        setX1(firstX);
        setY1(firstY);
        setX2(secondX);
        setY2(secondY);
        setColor(shapeColor);

        // generate a random velocity for dx and dy from -4 to 4
        // Random for generating random ints
        Random generateRandom = new Random();
        setDx(generateRandom.nextInt(9) - 4);
        setDy(generateRandom.nextInt(9) - 4);

    } // end constructor

    // set x1 value
    public void setX1(int x) {
        x1 = x;

    } // end method setX1

    // get x1 value
    public int getX1() {
        return x1;

    } // end method getX1

    // set Y1 value
    public void setY1(int y) {
        y1 = y;

    } // end method setY1

    // get Y1 value
    public int getY1() {
        return y1;

    } // end method getY1

    // set x2 value
    public void setX2(int x) {
        x2 = x;

    } // end method setX2

    // get x2 value
    public int getX2() {
        return x2;

    } // end method getX2

    // set y2 value
    public void setY2(int y) {
        y2 = y;

    } // end method setY2

    // get y2 value
    public int getY2() {
        return y2;

    } // end method getY2

    // set color value
    public void setColor(Color c) {
        color = c;

    } // end method setColor

    // get color value
    public Color getColor() {
        return color;

    } // end method getColor

    // set dx value
    public void setDx(int x) {
        dx = x;

    } // end method setDx

    // get dx value
    public int getDx() {
        return dx;

    } // end method getDx

    // set dy value
    public void setDy(int y) {
        dy = y;

    } // end method setDy

    // get dy value
    public int getDy() {
        return dy;

    } // end method getDx

    // abstract draw method
    public abstract void draw(Graphics g);

    // move the shape
    public void moveShape() {
        setX1(getX1() + getDx());
        setY1(getY1() + getDy());
        setX2(getX2() + getDx());
        setY2(getY2() + getDy());

        // if the shape has hit a side, make it bounce
        if (getX1() <= 0 || getX2() <= 0 ||
                getX1() >= 400 || getX2() >= 400) {
            setDx(-getDx());
        }

        // if the shape has hit the top or bottom, make it bounce
        if (getY1() <= 0 || getY2() <= 0 ||
                getY1() >= 340 || getY2() >= 340) {
            setDy(-getDy());
        }

    } // end method moveShape

} // end class MyMovingShape

package tutorial_18.TriangleCreator;

// Exercise 18.11: Triangle.java
// This class holds the properties of a triangle.

public class Triangle {
    // declare integer type variables to hold the length of each side of a triangle.
    private double side1, side2, side3;

    // constructor to create a triangle.
    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    // getter method
    public double getSide1() {
        return side1;
    }

    // getter method
    public double getSide2() {
        return side2;
    }

    // getter method
    public double getSide3() {
        return side3;
    }

    // setter method
    public void setSide1(double side1) {
        this.side1 = Math.max(side1, 0);
    }

    // setter method
    public void setSide2(double side2) {
        this.side2 = Math.max(side2, 0);
    }

    // setter method
    public void setSide3(double side3) {
        this.side3 = Math.max(side3, 0);
    }

    // isRightTriangle method using Pythagorean Theorem.
    public boolean isRightTriangle() {
        return Math.pow(getSide1(), 2) + Math.pow(getSide2(), 2) == Math.pow(getSide3(), 2) ||
                Math.pow(getSide1(), 2) + Math.pow(getSide3(), 2) == Math.pow(getSide2(), 2) ||
                Math.pow(getSide3(), 2) + Math.pow(getSide2(), 2) == Math.pow(getSide1(), 2);
    }

    // isEquilateralTriangle method using Pythagorean Theorem.
    public boolean isEquilateralTriangle() {
        return side1 == side2 && side2 == side3;
    }

} // end class Triangle

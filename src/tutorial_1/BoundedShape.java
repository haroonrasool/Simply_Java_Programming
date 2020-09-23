package tutorial_1;

public abstract class BoundedShape extends Shape {
    public BoundedShape() {
        super();
    }

    public BoundedShape(int x1, int y1, int x2, int y2) {
        super(x1, y1, x2, y2);
    }

    public int getUpperLeftX() {
        return Math.min(getX1(), getX2());
    }

    public int getUpperLeftY() {
        return Math.min(getY1(), getY2());
    }

    public int getWidth() {
        return Math.abs(getX1() - getX2());
    }

    public int getHeight() {
        return Math.abs(getY1() - getY2());
    }
}

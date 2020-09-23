package tutorial_1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

public class PaintPanel extends JPanel implements MouseListener, MouseMotionListener, ActionListener {
    private final Vector shapes; // dynamically resizeable array of Objects from java.util
    private Shape currentShape;
    private String currentShapeType = "Line"; // default
    private Color currentColor = Color.black;
    Timer timer = new Timer(40, this);

    public PaintPanel() {
        shapes = new Vector<>(); // creates empty Vector
        addMouseListener(this);
        addMouseMotionListener(this);
        setBackground(Color.white);
        timer.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Shape current;

        for (int i = 0; i < shapes.size(); i++) {
            current = (Shape) shapes.elementAt(i);
            current.draw(g);
        }
    }

    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    /*
     * In the following method, we use features that have not been covered in the
     * text. We could have used an if/else structure to choose which shape to
     * create. Instead,
     *
     * Class c = Class.forName( currentShapeType );
     *
     * loads the class definition for the class with the String name stored in
     * currentShapeType. The statement
     *
     * currentShape = (Shape) c.newInstance();
     *
     * creates a new instance of the class that was loaded. The next line adds the
     * new shape to the Vector (at the end).
     *
     * The try/catch syntax is covered in chapter 14. It is required here because
     * both the Class.forName method call and the c.newInstance method call can
     * cause runtime exceptions (problems). In this case we are saying
     * "if a runtime problem occurs, ignore it."
     */
    public void mousePressed(MouseEvent e) {
        try {
            Class aClass = Class.forName(currentShapeType);
            currentShape = (Shape) aClass.newInstance();
            currentShape.setX1(e.getX());
            currentShape.setY1(e.getY());
            currentShape.setX2(e.getX());
            currentShape.setY2(e.getY());
            currentShape.setColor(currentColor);
            shapes.addElement(currentShape);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void mouseReleased(MouseEvent e) {
        currentShape.setX2(e.getX());
        currentShape.setY2(e.getY());

        // NOTE: We should store these for termination later.
        MovingShape mover = new MovingShape(currentShape, this, (int) (Math.random() * 5 + 1),
                (int) (Math.random() * 5 + 1));
        mover.start();

        repaint();
    }

    public void mouseClicked(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mouseMoved(MouseEvent e) {
    }

    public void mouseDragged(MouseEvent e) {
        currentShape.setX2(e.getX());
        currentShape.setY2(e.getY());
        repaint();
    }

    public void setCurrentShapeType(String s) {
        currentShapeType = s;
    }

    public void setCurrentColor(Color c) {
        currentColor = c;
    }
}

package tutorial_21.AdvancedPainter;

// Exercise 21.16 PainterJPanel.java
// A customized JPanel class for AdvancedPainter.java.

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class PainterJPanel extends JPanel {
    private int circleDiameter; // diameter of circle
    private Color circleColor;  // color of circle

    // ArrayList to hold drawn circles
    private final ArrayList<Circle> circleArrayList = new ArrayList<>();

    // constructor
    public PainterJPanel(Color colorValue, int diameter) {
        circleColor = colorValue;
        circleDiameter = diameter;

        // set up mouse motion listener
        addMouseMotionListener(

                new MouseMotionListener() // anonymous inner class
                {
                    // event handler called when mouse is dragged
                    public void mouseDragged(MouseEvent event) {
                        painterJPanelMouseDragged(event);
                    }

                    // event handler must exist to implement interface
                    public void mouseMoved(MouseEvent event) {
                    }

                } // end anonymous inner class

        ); // end call to addMouseMotionListener

    } // end constructor

    // sets the circleColor
    public void setColor(Color choice) {
        circleColor = choice;

    } // end method setColor

    // sets the circleDiameter
    public void setDiameter(int diameter) {
        circleDiameter = diameter;

    } // end method setDiameter

    // paint a circle on this PainterJPanel
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Iterator<Circle> circleIterator = circleArrayList.iterator();
        Circle drawCircle;

        // iterate through the ArrayList
        while (circleIterator.hasNext()) {
            drawCircle = circleIterator.next();
            drawCircle.draw(g); // draw each circle
        }

    } // end method paintComponent

    // create a circle and add it to the ArrayList
    private void painterJPanelMouseDragged(MouseEvent event) {
        // Circle to add to the ArrayList
        Circle newCircle;
        if (event.isMetaDown()) {
            // erase circle if right mouse button is pressed
            newCircle = new Circle(circleDiameter, event.getPoint(),
                    getBackground());
        } else {
            // draw circle if left mouse button is pressed
            newCircle = new Circle(circleDiameter, event.getPoint(),
                    circleColor);
        }

        circleArrayList.add(newCircle);

        repaint(); // repaint this PainterJPanel

    } // end method painterJPanelMouseDragged

} // end class PainterJPanel

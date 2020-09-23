package tutorial_21.CirclePainter;

// Exercise 21.12: DrawJPanel.java
// This class defines the DrawJPanel class.

import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

public class DrawJPanel extends JPanel {
    // Random object to create random numbers
    private final Random generator = new Random();

    int x;        // x position of circle
    int y;        // y position of circle
    int diameter; // diameter of circle

    // no-argument constructor
    public DrawJPanel() {
        // add MouseListener to DrawJPanel
        addMouseListener(

                new MouseListener() // anonymous inner class
                {
                    // event handler called when mouse button is pressed
                    public void mousePressed(MouseEvent event) {
                        drawJPanelMousePressed(event);
                    }

                    // event handler must exist to implement interface
                    public void mouseReleased(MouseEvent event) {
                    }

                    // event handler must exist to implement interface
                    public void mouseClicked(MouseEvent event) {
                    }

                    // event handler must exist to implement interface
                    public void mouseEntered(MouseEvent event) {
                    }

                    // event handler must exist to implement interface
                    public void mouseExited(MouseEvent event) {
                    }

                } // end anonymous inner class

        ); // end call to new MouseListener

    } // end constructor

    // set dimensions of circle and call repaint
    private void drawJPanelMousePressed(MouseEvent event) {
        x = event.getX(); // get x position of mouse
        y = event.getY(); // get y position of mouse

        // set width to random int from 5 to 199
        diameter = 5 + generator.nextInt(194);

        repaint(); // repaint DrawJPanel

    } // end method drawJPanelMousePressed

    // draw circle
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // draw circle
        g.setColor(Color.BLUE);
        g.drawOval(x, y, diameter, diameter);

    } // end method paintComponent

} // end class DrawJPanel

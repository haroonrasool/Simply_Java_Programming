package tutorial_21.LineLength;

// Exercise 21.11: LineLength.java
// This application allows the user to draw a line and then displays
// the length of the line.

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DecimalFormat;

public class LineLength extends JFrame {
    private JTextField lengthJTextField;

    // variables to hold coordinates of endpoints
    int point1x;
    int point1y;
    int point2x;
    int point2y;

    // DecimalFormat to display numbers in digital format
    DecimalFormat value = new DecimalFormat("0.00");

    // no-argument constructor
    public LineLength() {
        createUserInterface();
    }

    // create and position GUI components; register event handlers
    public void createUserInterface() {
        // get content pane for attaching GUI components
        Container contentPane = getContentPane();

        // enable explicit positioning of GUI components
        contentPane.setLayout(null);

        // set up lengthJLabel
        // JLabel and JTextField for length of line
        JLabel lengthJLabel = new JLabel();
        lengthJLabel.setBounds(8, 240, 64, 24);
        lengthJLabel.setText("Length =");
        contentPane.add(lengthJLabel);

        // set up lengthJTextField
        lengthJTextField = new JTextField();
        lengthJTextField.setBounds(72, 240, 48, 24);
        lengthJTextField.setHorizontalAlignment(JTextField.CENTER);
        lengthJTextField.setEditable(false);
        contentPane.add(lengthJTextField);

        // add mouse listener to JFrame
        addMouseListener(

                new MouseListener() // anonymous inner class
                {
                    // event handler called when mouse button is pressed
                    public void mousePressed(MouseEvent event) {
                        lineLengthMousePressed(event);
                    }

                    // event handler called when mouse button is released
                    public void mouseReleased(MouseEvent event) {
                        lineLengthMouseReleased(event);
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

        ); // end call to addMouseListener

        // set properties of application's window
        setTitle("Line Length"); // set title bar text
        setSize(300, 310);       // set window size
        setVisible(true);        // display window

    } // end method createUserInterface

    // mouse is pressed
    public void lineLengthMousePressed(MouseEvent event) {
        lengthJTextField.setText(""); // clear lengthJTextField

        // get x- and y- coordinates of mouse click
        point1x = event.getX();
        point1y = event.getY();

    } // end method lineLengthMousePressed

    // mouse is released
    public void lineLengthMouseReleased(MouseEvent event) {
        // final point
        point2x = event.getX();
        point2y = event.getY();

        // find distance between two points
        double distance = lineLength();

        // display distance in lengthJTextField
        lengthJTextField.setText(value.format(distance));

        repaint(); // draw line connecting the two points

    } // end method lineLengthMouseReleased

    // find the length of the line
    private double lineLength() {
        double xDistance = point1x - point2x; // horizontal distance
        double yDistance = point1y - point2y; // vertical distance

        return Math.sqrt((xDistance * xDistance) + (yDistance *
                yDistance));

    } // end method lineLength

    // paint graphics
    public void paint(Graphics g) {
        super.paint(g); // call super class's paint method

        // draw each line
        g.drawLine(point1x, point1y, point2x, point2y);

    } // end method paint

    // main method
    public static void main(String[] args) {
        LineLength application = new LineLength();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    } // end method main

} // end class LineLength

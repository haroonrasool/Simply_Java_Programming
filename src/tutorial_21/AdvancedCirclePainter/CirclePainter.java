package tutorial_21.AdvancedCirclePainter;

// Exercise 21.13: CirclePainter.java
// Application draws circles of random sizes when mouse is clicked.

import java.awt.*;
import javax.swing.*;

public class CirclePainter extends JFrame {

    // no-argument constructor
    public CirclePainter() {
        createUserInterface();
    }

    // create and position GUI components; register event handlers
    private void createUserInterface() {
        // get content pane for attaching GUI components
        Container contentPane = getContentPane();

        // enable explicit positioning of GUI components
        contentPane.setLayout(null);

        // set up myDrawJPanel
        // DrawJPanel for displaying circles
        DrawJPanel myDrawJPanel = new DrawJPanel();
        myDrawJPanel.setBounds(0, 40, 450, 450);
        contentPane.add(myDrawJPanel);

        // set properties of application's window
        setTitle("Circle Painter"); // set title bar text
        setSize(450, 450);          // set window size
        setVisible(true);           // display window

    } // end method createUserInterface

    // main method
    public static void main(String[] args) {
        CirclePainter application = new CirclePainter();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    } // end method main

} // end class CirclePainter

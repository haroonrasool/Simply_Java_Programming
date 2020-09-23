package tutorial_20.BrickWall;

// Exercise 20.11: BrickWall.java
// Program builds a brick wall using rectangles.

import javax.swing.*;
import java.awt.*;

public class BrickWall extends JFrame {
    // no-argument constructor
    public BrickWall() {
        createUserInterface();
    }

    // main method
    public static void main(String[] args) {
        BrickWall application = new BrickWall();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } // end method main

    // create and position GUI components; register event handlers
    private void createUserInterface() {
        // get content pane for attaching GUI components
        Container contentPane = getContentPane();

        // enable explicit positioning of GUI components
        contentPane.setLayout(null);

        // set up drawingJPanel
        // DrawJPanel for displaying bricks
        DrawJPanel drawingJPanel = new DrawJPanel();
        drawingJPanel.setBounds(0, 0, 450, 250);
        drawingJPanel.setBackground(Color.WHITE);
        contentPane.add(drawingJPanel);

        // set properties of application's window
        setTitle("Brick Wall");   // set title bar text
        setSize(475, 300);        // set window size
        setVisible(true);         // display window

    } // end method createUserInterface

} // end class BrickWall

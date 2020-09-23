package tutorial_27.AdvancedScreenSaver;

// Exercise 27.11: ScreenSaver.java
// Application simulates a Screen Saver by drawing random shapes.

import java.awt.*;
import javax.swing.*;

public class ScreenSaver extends JFrame {

    // no-argument constructor
    public ScreenSaver() {
        createUserInterface();
    }

    // main method
    public static void main(String[] args) {
        ScreenSaver application = new ScreenSaver();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } // end method main

    // create and position GUI components; register event handlers
    private void createUserInterface() {
        // get content pane for attaching GUI components
        Container contentPane = getContentPane();

        // enable explicit positioning of GUI components
        contentPane.setLayout(null);

        // set up shapesDrawJPanel
        // DrawJPanel for displaying shapes
        DrawJPanel shapesDrawJPanel = new DrawJPanel();
        shapesDrawJPanel.setBounds(0, 0, 600, 450);
        contentPane.add(shapesDrawJPanel);

        // set properties of application's window
        setTitle("Screen Saver"); // set title bar string
        setSize(600, 450);        // set window size
        setVisible(true);         // display window

    } // end method createUserInterface

} // end class ScreenSaver

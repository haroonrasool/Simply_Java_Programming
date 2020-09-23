package tutorial_20.ScreenSaver;

// Tutorial 20: ScreenSaver.java
// Program simulates screen saver by drawing random shapes.

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ScreenSaver extends JFrame {

    // DrawJPanel for displaying rectangles
    private DrawJPanel drawingJPanel;

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

        // set up clearJButton
        // JButton to clear drawingJPanel
        JButton clearJButton = new JButton();
        clearJButton.setBounds(189, 16, 72, 23);
        clearJButton.setText("Clear");
        contentPane.add(clearJButton);
        // anonymous inner class
        // method called when clearJButton is pressed
        clearJButton.addActionListener(

                this::clearJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set up drawingJPanel
        drawingJPanel = new DrawJPanel();
        drawingJPanel.setBounds(0, 40, 450, 450);
        contentPane.add(drawingJPanel);

        // set properties of application's window
        setTitle("Screen Saver"); // set title bar text
        setSize(500, 500);        // set window size
        setVisible(true);         // display window

    } // end method createUserInterface

    // reset drawingJPanel
    private void clearJButtonActionPerformed(ActionEvent event) {
        drawingJPanel.clear();

    } // end method clearJButtonActionPerformed

} // end class ScreenSaver

package tutorial_2;

// Tutorial 2: Welcome.java
// This application welcomes the user to Java programming.

import javax.swing.*;
import java.awt.*;

public class Welcome2 extends JFrame {
    // no-argument constructor
    public Welcome2() {
        createUserInterface();
    }

    // main method
    public static void main(String[] args) {
        Welcome2 application = new Welcome2();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } // end method main

    // create and position GUI components; register event handlers
    private void createUserInterface() {
        // get content pane and set layout to null
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        // set up textJLabel
        // JLabel that displays text
        JLabel textJLabel = new JLabel();
        contentPane.add(textJLabel);

        // set up pictureJLabel
        // JLabel that displays an image
        JLabel pictureJLabel = new JLabel();
        contentPane.add(pictureJLabel);

        // set properties of application's window
        setSize(100, 100);   // set width and height of JFrame
        setVisible(true);    // display JFrame on screen

    } // end method createUserInterface

} // end class Welcome

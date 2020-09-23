package tutorial_2;

// Tutorial 2: Welcome.java
// This application welcomes the user to Java programming.

import javax.swing.*;
import java.awt.*;

public class Welcome extends JFrame {
    // no-argument constructor
    public Welcome() {
        createUserInterface();
    }

    // main method
    public static void main(String[] args) {
        Welcome application = new Welcome();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } // end method main

    // create and position GUI components; register event handlers
    private void createUserInterface() {
        // get content pane and set layout to null
        Container contentPane = getContentPane();
        contentPane.setBackground(Color.YELLOW);
        contentPane.setLayout(null);

        // set up textJLabel
        // JLabel that displays text
        JLabel textJLabel = new JLabel();
        textJLabel.setText("Welcome to Java Programming!");
        textJLabel.setLocation(35, 0);
        textJLabel.setSize(550, 88);
        textJLabel.setFont(new Font("SansSerif", Font.PLAIN, 36));
        textJLabel.setHorizontalAlignment(JLabel.CENTER);
        contentPane.add(textJLabel);

        // set up pictureJLabel
        // JLabel that displays an image
        JLabel pictureJLabel = new JLabel();
        pictureJLabel.setIcon(new ImageIcon("../Simply Java Programming/src/images/bug.png"));
        pictureJLabel.setBounds(54, 120, 500, 250);
        pictureJLabel.setHorizontalAlignment(JLabel.CENTER);
        contentPane.add(pictureJLabel);

        // set properties of application's window
        setTitle("Welcome"); // set JFrame's title bar string
        setSize(608, 413);   // set width and height of JFrame
        setVisible(true);    // display JFrame on screen

    } // end method createUserInterface

} // end class Welcome

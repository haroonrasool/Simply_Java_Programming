package tutorial_3;

// Exercise 3.13: Password.java
// GUI for a password-protected message application.

import java.awt.*;
import javax.swing.*;

public class Password extends JFrame {
    // no-argument constructor
    public Password() {
        createUserInterface();
    }

    // main method
    public static void main(String[] args) {
        Password application = new Password();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } // end method main

    // create and position GUI components
    public void createUserInterface() {
        // get content pane and set its layout
        Container container = getContentPane();
        container.setLayout(null);

        // set up userNameJLabel
        // JLabel and JTextField for user name
        JLabel userNameJLabel = new JLabel();
        userNameJLabel.setBounds(16, 16, 150, 21);
        userNameJLabel.setText("Enter your full name:");
        container.add(userNameJLabel);

        // set up userNameJTextField
        JTextField userNameJTextField = new JTextField();
        userNameJTextField.setBounds(172, 16, 140, 21);
        userNameJTextField.setText("Joe Purple");
        container.add(userNameJTextField);

        // set up passwordJLabel
        // JLabel and JTextField for password
        JLabel passwordJLabel = new JLabel();
        passwordJLabel.setBounds(16, 48, 150, 21);
        passwordJLabel.setText("Enter your password:");
        container.add(passwordJLabel);

        // set up passwordJPasswordField
        JPasswordField passwordJPasswordField = new JPasswordField();
        passwordJPasswordField.setBounds(172, 48, 140, 21);
        passwordJPasswordField.setText("Hello2world");
        container.add(passwordJPasswordField);

        // set up reenterPasswordJLabel
        // JLabel and JTextField for reentering password
        JLabel re_enterPasswordJLabel = new JLabel();
        re_enterPasswordJLabel.setBounds(16, 80, 150, 21);
        re_enterPasswordJLabel.setText("Re-enter your password:");
        container.add(re_enterPasswordJLabel);

        // set up reenterPasswordJPasswordField
        JPasswordField re_enterPasswordJPasswordField = new JPasswordField();
        re_enterPasswordJPasswordField.setBounds(172, 80, 140, 21);
        re_enterPasswordJPasswordField.setText("Hello2world");
        container.add(re_enterPasswordJPasswordField);

        // set up logInJButton
        // JButton for logging in to the Message Application
        JButton logInJButton = new JButton();
        logInJButton.setBounds(240, 120, 72, 24);
        logInJButton.setText("Log In");
        container.add(logInJButton);

        // set up messageJLabel
        // JLabel and JTextArea for messages
        JLabel messageJLabel = new JLabel();
        messageJLabel.setBounds(16, 136, 164, 21);
        messageJLabel.setText("Enter your secret message:");
        container.add(messageJLabel);

        // set up messageJTextArea
        JTextArea messageJTextArea = new JTextArea();
        messageJTextArea.setBounds(16, 160, 295, 72);
        messageJTextArea.setText("Welcome to Simply Java Programming:\n" +
                "An application-driven tutorial approach.\n" +
                "First edition.");
        container.add(messageJTextArea);

        // set up saveJButton
        // JButtons to save a message, log out and clear all input
        JButton saveJButton = new JButton();
        saveJButton.setBounds(58, 248, 72, 24);
        saveJButton.setText("Save");
        container.add(saveJButton);

        // set up logOutJButton
        JButton logOutJButton = new JButton();
        logOutJButton.setBounds(146, 248, 78, 24);
        logOutJButton.setText("Log Out");
        container.add(logOutJButton);

        // set up clearJButton
        JButton clearJButton = new JButton();
        clearJButton.setBounds(240, 248, 72, 24);
        clearJButton.setText("Clear");
        container.add(clearJButton);

        // set properties of application�s window
        setTitle("Message Application"); // set title bar text
        setSize(336, 320); // set window size
        setVisible(true); // display window

    } // end method createUserInterface

} // end class Password

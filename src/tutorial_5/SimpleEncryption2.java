package tutorial_5;

// Exercise 5.11 SimpleEncryption.java
// Application that uses a simple formula to encrypt numbers.

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SimpleEncryption2 extends JFrame {
    private JTextField enterJTextField;

    private JTextField encryptedJTextField;

    // no-argument constructor
    public SimpleEncryption2() {
        createUserInterface();
    }

    // main method
    public static void main(String[] args) {
        SimpleEncryption2 application = new SimpleEncryption2();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } // end method main

    // create and position GUI components; register event handlers
    private void createUserInterface() {
        // get content pane for attaching GUI components
        Container contentPane = getContentPane();

        // enable explicit positioning of GUI components
        contentPane.setLayout(null);

        // set up enterJLabel
        // JLabel and JTextField for entering number to encrypt
        JLabel enterJLabel = new JLabel();
        enterJLabel.setText("Enter a number to encrypt:");
        enterJLabel.setBounds(20, 20, 150, 20);
        contentPane.add(enterJLabel);

        // set up enterJTextField
        enterJTextField = new JTextField();
        enterJTextField.setBounds(180, 20, 50, 20);
        contentPane.add(enterJTextField);
        enterJTextField.addKeyListener(

                new KeyAdapter() // anonymous inner class
                {
                    // called when key pressed in enterJTextField
                    public void keyPressed(KeyEvent event) {
                        enterJTextFieldKeyPressed();
                    }

                } // end anonymous inner class

        ); // end call to addKeyListener

        // set up encryptedJLabel
        // JLabel and JTextField for displaying encrypted number
        JLabel encryptedJLabel = new JLabel();
        encryptedJLabel.setText("Encrypted number:");
        encryptedJLabel.setBounds(20, 50, 140, 20);
        contentPane.add(encryptedJLabel);

        // set up encryptedJTextField
        encryptedJTextField = new JTextField();
        encryptedJTextField.setEditable(false);
        encryptedJTextField.setBounds(180, 50, 50, 20);
        contentPane.add(encryptedJTextField);

        // set up encryptJButton
        // JButton to initiate encryption
        JButton encryptJButton = new JButton();
        encryptJButton.setText("Encrypt");
        encryptJButton.setBounds(250, 20, 80, 20);
        contentPane.add(encryptJButton);
        // anonymous inner class
        // called when encryptJButton is pressed
        encryptJButton.addActionListener(

                this::encryptJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set properties of application's window
        setTitle("Simple Encryption"); // set title bar text
        setSize(350, 120);             // set window size
        setVisible(true);              // display window

    } // end method createUserInterface

    // encrypt number input by user
    private void encryptJButtonActionPerformed(ActionEvent event) {
        int plainText = Integer.parseInt(enterJTextField.getText());
        int cypherText = plainText * 7 + 5;
        // display result in encryptedJTextField
        encryptedJTextField.setText(String.valueOf(cypherText));
    } // end method encryptJButtonActionPerformed

    // clear encryptedJTextField because the value is now invalid
    private void enterJTextFieldKeyPressed() {
        encryptedJTextField.setText("");
    } // end method enterJTextFieldKeyPressed

} // end class SimpleEncryption

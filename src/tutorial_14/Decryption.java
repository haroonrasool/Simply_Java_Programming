package tutorial_14;

// Exercise 14.16: Decryption.java
// This application decrypts encrypted data one character at a time.

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Decryption extends JFrame {
    private JTextField encryptedLetterJTextField;
    private JTextField messageJTextField;
    // String to hold decrypted message

    private String message = "";
    // no-argument constructor

    public Decryption() {
        createUserInterface();
    }

    // main method
    public static void main(String[] args) {
        Decryption application = new Decryption();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } // end method main

    // create and position GUI components; register event handlers
    private void createUserInterface() {
        // get content pane for attaching GUI components
        Container contentPane = getContentPane();

        // enable explicit positioning of GUI components
        contentPane.setLayout(null);

        // set up encryptedLetterJLabel
        // JLabel and JTextField for encrypted letter
        JLabel encryptedLetterJLabel = new JLabel();
        encryptedLetterJLabel.setBounds(16, 16, 150, 21);
        encryptedLetterJLabel.setText("Encrypted letter:");
        contentPane.add(encryptedLetterJLabel);

        // set up encryptedLetterJTextField
        encryptedLetterJTextField = new JTextField();
        encryptedLetterJTextField.setBounds(142, 16, 43, 24);
        encryptedLetterJTextField.setHorizontalAlignment(
                JTextField.RIGHT);
        contentPane.add(encryptedLetterJTextField);

        // set up decryptJButton
        // JButton to decrypt letter
        JButton decryptJButton = new JButton();
        decryptJButton.setBounds(229, 16, 86, 24);
        decryptJButton.setText("Decrypt");
        contentPane.add(decryptJButton);
        // anonymous inner class
        // event handler called when decryptJButton is clicked
        decryptJButton.addActionListener(

                this::decryptJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set up messageJLabel
        // JLabel and JTextField for message
        JLabel messageJLabel = new JLabel();
        messageJLabel.setBounds(16, 56, 150, 21);
        messageJLabel.setText("Decrypted message:");
        contentPane.add(messageJLabel);

        // set up messageJTextField
        messageJTextField = new JTextField();
        messageJTextField.setBounds(142, 56, 173, 24);
        messageJTextField.setHorizontalAlignment(JTextField.CENTER);
        messageJTextField.setEditable(false);
        contentPane.add(messageJTextField);

        // set properties of applications' window
        setTitle("Decryption"); // set title bar string
        setSize(335, 125);      // set window size
        setVisible(true);       // display window

    } // end method createUserInterface

    // decrypt letter and append to output
    public void decryptJButtonActionPerformed(ActionEvent event) {
        // Store the user input
        int encryptedLetter = Integer.parseInt(encryptedLetterJTextField.getText());

        // testing the user input.
        if (encryptedLetter >= 0 && encryptedLetter <= 94) {
            // decrypt the uer input and append it to message String.
            message += (char) (encryptedLetter + 32);

            // append letter to messageJTextField
            messageJTextField.setText(message);
        } else {
            JOptionPane.showMessageDialog(null, "Please enter a number between 0 and 94 only.");
        }

        // clear the encryptedLetterJTextField
        encryptedLetterJTextField.setText("");

    } // end method decryptJButtonActionPerformed

} // end class Decryption

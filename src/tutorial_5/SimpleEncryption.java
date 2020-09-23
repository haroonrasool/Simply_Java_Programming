package tutorial_5;

// Exercise 6.17: Encryption.java
// Encrypts data given by user.

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SimpleEncryption extends JFrame {
    private JTextField numberJTextField;
    private JTextField encryptedDigit1JTextField;
    private JTextField encryptedDigit2JTextField;
    private JTextField encryptedDigit3JTextField;
    private JTextField encryptedDigit4JTextField;

    // no-argument constructor
    public SimpleEncryption() {
        createUserInterface();
    }

    // main method
    public static void main(String[] args) {
        SimpleEncryption application = new SimpleEncryption();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } // end method main

    // create and position GUI components; register event handlers
    private void createUserInterface() {
        // get content pane for attaching GUI components
        Container contentPane = getContentPane();

        // enable explicit positioning of GUI components
        contentPane.setLayout(null);

        // set up numberJLabel
        // JLabel and JTextField for inputting number
        JLabel numberJLabel = new JLabel();
        numberJLabel.setBounds(10, 10, 140, 25);
        numberJLabel.setText("Enter a 4-digit integer:");
        contentPane.add(numberJLabel);

        // set up numberJTextField
        numberJTextField = new JTextField();
        numberJTextField.setBounds(145, 10, 95, 25);
        contentPane.add(numberJTextField);
        numberJTextField.addKeyListener(

                new KeyAdapter() // anonymous inner class
                {
                    // event handler called when key pressed
                    // in numberJTextField
                    public void keyPressed(KeyEvent event) {
                        numberJTextFieldKeyPressed();
                    }

                } // end anonymous inner class

        ); // end call to addKeyListener

        // set up encryptedResultsJLabel
        // JLabel and JTextFields for displaying encrypted results
        JLabel encryptedResultsJLabel = new JLabel();
        encryptedResultsJLabel.setBounds(10, 45, 140, 25);
        encryptedResultsJLabel.setText("Encrypted digits:");
        contentPane.add(encryptedResultsJLabel);

        // set up encryptedDigit1JTextField
        encryptedDigit1JTextField = new JTextField();
        encryptedDigit1JTextField.setBounds(145, 45, 20, 25);
        encryptedDigit1JTextField.setHorizontalAlignment(
                JTextField.CENTER);
        encryptedDigit1JTextField.setEditable(false);
        contentPane.add(encryptedDigit1JTextField);

        // set up encryptedDigit2JTextField
        encryptedDigit2JTextField = new JTextField();
        encryptedDigit2JTextField.setBounds(170, 45, 20, 25);
        encryptedDigit2JTextField.setHorizontalAlignment(
                JTextField.CENTER);
        encryptedDigit2JTextField.setEditable(false);
        contentPane.add(encryptedDigit2JTextField);

        // set up encryptedDigit3JTextField
        encryptedDigit3JTextField = new JTextField();
        encryptedDigit3JTextField.setBounds(195, 45, 20, 25);
        encryptedDigit3JTextField.setHorizontalAlignment(
                JTextField.CENTER);
        encryptedDigit3JTextField.setEditable(false);
        contentPane.add(encryptedDigit3JTextField);

        // set up encryptedDigit4JTextField
        encryptedDigit4JTextField = new JTextField();
        encryptedDigit4JTextField.setBounds(220, 45, 20, 25);
        encryptedDigit4JTextField.setHorizontalAlignment(
                JTextField.CENTER);
        encryptedDigit4JTextField.setEditable(false);
        contentPane.add(encryptedDigit4JTextField);

        // set up encryptJButton and register its event handler
        // JButton to initiate encryption
        JButton encryptJButton = new JButton();
        encryptJButton.setText("Encrypt");
        encryptJButton.setBounds(250, 10, 100, 25);
        contentPane.add(encryptJButton);
        // anonymous inner class
        // event handler called when encryptJButton is pressed
        encryptJButton.addActionListener(

                this::encryptJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set properties of application's window
        setTitle("Encryption"); // set title bar text
        setSize(370, 110);      // set window size
        setVisible(true);       // display window

    } // end method createUserInterface

    // method called when key pressed in numberJTextField
    private void numberJTextFieldKeyPressed() {
        // clear JTextFields for encrypted digits when new number input
        encryptedDigit1JTextField.setText("");
        encryptedDigit2JTextField.setText("");
        encryptedDigit3JTextField.setText("");
        encryptedDigit4JTextField.setText("");
    } // end method numberJTextFieldKeyPressed

    // method called when user clicks encryptJButton
    private void encryptJButtonActionPerformed(ActionEvent event) {
        int number = Integer.parseInt(numberJTextField.getText());
        int result1, result2, result3, result4;
        // isolating the numbers.
        result4 = number % 10;
        result3 = (number / 10) % 10;
        result2 = (number / 100) % 10;
        result1 = (number / 1000) % 10;

        int digit1, digit2, digit3, digit4;
        digit1 = result1;
        digit2 = result2;
        digit3 = result3;
        digit4 = result4;

        // Encrypting the digits
        digit1 = (digit1 + 7) % 10;
        digit2 = (digit2 + 7) % 10;
        digit3 = (digit3 + 7) % 10;
        digit4 = (digit4 + 7) % 10;

        // swap the digit1 with digit3
        int swap;
        swap = digit1;
        digit1 = digit3;
        digit3 = swap;

        // swap digit2 with digit4
        swap = digit2;
        digit2 = digit4;
        digit4 = swap;

        encryptedDigit1JTextField.setText(String.valueOf(digit1));
        encryptedDigit2JTextField.setText(String.valueOf(digit2));
        encryptedDigit3JTextField.setText(String.valueOf(digit3));
        encryptedDigit4JTextField.setText(String.valueOf(digit4));

    } // end method encryptJButtonActionPerformed

} // end class Encryption

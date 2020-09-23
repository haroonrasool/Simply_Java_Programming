package tutorial_23;

// Exercise 23.12: Encryption.java
// Encrypts data entered by users.

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class CypherEncryption extends JFrame {
    private JTextField plainJTextField;
    private JTextField cipherJTextField;

    // JRadioButtons to allow two types of encryption
    private JRadioButton substitutionJRadioButton;

    // no-argument constructor
    public CypherEncryption() {
        createUserInterface();
    }

    // main method
    public static void main(String[] args) {
        CypherEncryption application = new CypherEncryption();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } // end method main

    // create and position GUI components; register event handlers
    private void createUserInterface() {
        // get content pane for attaching GUI components
        Container contentPane = getContentPane();

        // enable explicit positioning of GUI components
        contentPane.setLayout(null);

        // set up instructionJLabel
        // JLabel and JTextField for user input
        JLabel instructionJLabel = new JLabel();
        instructionJLabel.setBounds(16, 16, 126, 21);
        instructionJLabel.setText("Enter text to encrypt:");
        contentPane.add(instructionJLabel);

        // set up plainJTextField
        plainJTextField = new JTextField();
        plainJTextField.setBounds(150, 16, 207, 21);
        contentPane.add(plainJTextField);

        // create logical relationship between JRadioButtons
        // ButtonGroup to contain JRadioButtons
        ButtonGroup radioButtonGroup = new ButtonGroup();

        // set up substitutionJRadioButton
        substitutionJRadioButton = new JRadioButton();
        substitutionJRadioButton.setBounds(24, 56, 140, 24);
        substitutionJRadioButton.setText("Substitution Cipher");
        substitutionJRadioButton.setSelected(true);
        radioButtonGroup.add(substitutionJRadioButton);
        contentPane.add(substitutionJRadioButton);

        // set up transpositionJRadioButton
        JRadioButton transpositionJRadioButton = new JRadioButton();
        transpositionJRadioButton.setBounds(184, 56, 148, 24);
        transpositionJRadioButton.setText("Transposition Cipher");
        radioButtonGroup.add(transpositionJRadioButton);
        contentPane.add(transpositionJRadioButton);

        // set up resultJLabel
        // JLabel and JTextField for output
        JLabel resultJLabel = new JLabel();
        resultJLabel.setBounds(16, 96, 100, 21);
        resultJLabel.setText("Encrypted text:");
        contentPane.add(resultJLabel);

        // set up cipherJTextField
        cipherJTextField = new JTextField();
        cipherJTextField.setBounds(150, 96, 207, 21);
        cipherJTextField.setEditable(false);
        contentPane.add(cipherJTextField);

        // set up encryptJButton
        // JButton to encrypt phrase
        JButton encryptJButton = new JButton();
        encryptJButton.setBounds(272, 128, 85, 23);
        encryptJButton.setText("Encrypt");
        contentPane.add(encryptJButton);
        // anonymous inner class
        // method called when encryptJButton is pressed
        encryptJButton.addActionListener(

                this::encryptJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set properties of application's window
        setTitle("Encryption"); // set title bar string
        setSize(390, 210);      // set window size
        setVisible(true);       // display window

    } // end method createUserInterface

    // encrypt a String of characters
    private void encryptJButtonActionPerformed(ActionEvent event) {
        // determine the selected JRadioButton
        if (substitutionJRadioButton.isSelected()) {
            // call substitutionCipher
            substitutionCipher();
        } else {
            // call transpositionCipher
            transpositionCipher();
        }

    } // end method encryptJButtonActionPerformed

    // using the substitution cipher, display encrypted text
    private void substitutionCipher() {
        // normal alphabet String
        String normalAlphabet = "abcdefghijklmnopqrstuvwxyz .!?,";

        // substitution alphabet String
        String cipherAlphabet = "cdefg.hijk!lmn opqr?stuv,wxyzab";

        // encrypted String
        StringBuilder cipher = new StringBuilder();

        // get text and change all the characters to lower case
        String plainText = plainJTextField.getText().toLowerCase();

        // iterate through the length of the plainText String
        for (int i = 0; i < plainText.length(); i++) {
            // get the normal alphabet index of the current letter
            int index = normalAlphabet.indexOf(plainText.charAt(i));

            // valid index
            if (index != -1) {
                // add the cipher alphabet letter of that index to cipher
                cipher.append(cipherAlphabet.charAt(index));
            }

        } // end for

        // output the encrypted String
        cipherJTextField.setText(cipher.toString());

    } // end method substitutionCipher

    // using the transposition cipher, display encrypted text
    private void transpositionCipher() {
        StringBuilder firstWord = new StringBuilder(); // first word
        StringBuilder lastWord = new StringBuilder();  // second word

        // get text from plainJTextField
        String plainText = plainJTextField.getText();

        // create first and second words
        for (int counter = 0; counter < plainText.length();
             counter++) {
            if ((counter % 2) == 0) {
                // add character from specified location to firstWord
                firstWord.append(plainText.charAt(counter));
            } else {
                // add character from specified location to lastWord
                lastWord.append(plainText.charAt(counter));
            }

        } // loop through the entire String

        // output encrypted text
        cipherJTextField.setText(firstWord + " " + lastWord);

    } // end method transpositionCipher

} // end class Encryption

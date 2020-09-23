package tutorial_5;

// Exercise 5.17 DigitExtractor.java
// Application that separates a five-digit number into digits.

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DigitExtractor extends JFrame {
    private JTextField enterNumberJTextField;
    private JTextField firstNumberJTextField;
    private JTextField secondNumberJTextField;
    private JTextField thirdNumberJTextField;
    private JTextField fourthNumberJTextField;
    private JTextField fifthNumberJTextField;

    // no-argument constructor
    public DigitExtractor() {
        createUserInterface();
    }

    // main method
    public static void main(String[] args) {
        DigitExtractor application = new DigitExtractor();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } // end method main

    // create and position GUI components; register event handlers
    private void createUserInterface() {
        // get content pane for attaching GUI components
        Container contentPane = getContentPane();

        // enable explicit positioning of GUI components
        contentPane.setLayout(null);

        // set up enterNumberJLabel
        // JLabel and JTextField for user to input number
        JLabel enterNumberJLabel = new JLabel();
        enterNumberJLabel.setText("Enter a five-digit number:");
        enterNumberJLabel.setBounds(10, 10, 150, 24);
        contentPane.add(enterNumberJLabel);

        // set up enterNumberJTextField
        enterNumberJTextField = new JTextField();
        enterNumberJTextField.setBounds(160, 10, 110, 24);
        contentPane.add(enterNumberJTextField);

        // set up extractedDigitsJLabel
        // JLabel and JTextFields for displaying extracted digits
        JLabel extractedDigitsJLabel = new JLabel();
        extractedDigitsJLabel.setText("Extracted digits:");
        extractedDigitsJLabel.setBounds(10, 45, 150, 24);
        contentPane.add(extractedDigitsJLabel);

        // set up firstNumberJTextField
        firstNumberJTextField = new JTextField();
        firstNumberJTextField.setEditable(false);
        firstNumberJTextField.setBounds(160, 45, 15, 24);
        firstNumberJTextField.setHorizontalAlignment(
                JTextField.CENTER);
        contentPane.add(firstNumberJTextField);

        // set up secondNumberJTextField
        secondNumberJTextField = new JTextField();
        secondNumberJTextField.setEditable(false);
        secondNumberJTextField.setBounds(180, 45, 15, 24);
        secondNumberJTextField.setHorizontalAlignment(
                JTextField.CENTER);
        contentPane.add(secondNumberJTextField);

        // set up thirdNumberJTextField
        thirdNumberJTextField = new JTextField();
        thirdNumberJTextField.setEditable(false);
        thirdNumberJTextField.setBounds(200, 45, 15, 24);
        thirdNumberJTextField.setHorizontalAlignment(
                JTextField.CENTER);
        contentPane.add(thirdNumberJTextField);

        // set up fourthNumberJTextField
        fourthNumberJTextField = new JTextField();
        fourthNumberJTextField.setEditable(false);
        fourthNumberJTextField.setBounds(220, 45, 15, 24);
        fourthNumberJTextField.setHorizontalAlignment(
                JTextField.CENTER);
        contentPane.add(fourthNumberJTextField);

        // set up fifthNumberJTextField
        fifthNumberJTextField = new JTextField();
        fifthNumberJTextField.setEditable(false);
        fifthNumberJTextField.setBounds(240, 45, 15, 24);
        fifthNumberJTextField.setHorizontalAlignment(
                JTextField.CENTER);
        contentPane.add(fifthNumberJTextField);

        // set up enterJButton
        // JButton to initiate extraction of digits
        JButton enterJButton = new JButton();
        enterJButton.setText("Enter");
        enterJButton.setBounds(280, 10, 70, 24);
        // anonymous inner class
        // called when enterJButton is pressed
        enterJButton.addActionListener(

                this::enterJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        contentPane.add(enterJButton);

        // set properties of application's window
        setTitle("Digit Extractor"); // set title bar text
        setSize(370, 120);           // set window size
        setVisible(true);            // display window

    } // end method createUserInterface

    // extract and display individual digits
    private void enterJButtonActionPerformed(ActionEvent event) {
        // retrieving the numbers from the enterNumberJTextField.
        int number = Integer.parseInt(enterNumberJTextField.getText());
        // isolating the 5th number by modulus of 10.
        int result = number % 10;
        // displaying the 5th number.
        fifthNumberJTextField.setText(String.valueOf(result));
        // isolating the 4th number by modulus of 10.
        result = (number / 10) % 10;
        // displaying the 4th number.
        fourthNumberJTextField.setText(String.valueOf(result));
        // isolating the 3rd number by modulus of 10.
        result = (number / 100) % 10;
        // displaying the 3rd number.
        thirdNumberJTextField.setText(String.valueOf(result));
        // isolating the 2nd number by modulus of 10.
        result = (number / 1000) % 10;
        // displaying the 2nd number.
        secondNumberJTextField.setText(String.valueOf(result));
        // isolating the 1st number by modulus of 10.
        result = (number / 10000) % 10;
        // displaying the 1st number.
        firstNumberJTextField.setText(String.valueOf(result));

    } // end method enterJButtonActionPerformed

} // end class DigitExtractor

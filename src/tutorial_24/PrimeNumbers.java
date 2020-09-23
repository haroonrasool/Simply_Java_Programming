package tutorial_24;

// Exercise 24.12: PrimeNumbers.java
// Determines all prime numbers within a user-specified range.

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class PrimeNumbers extends JFrame {
    private JTextField lowerBoundJTextField;
    private JTextField upperBoundJTextField;
    private JTextArea primeNumbersJTextArea;

    // no-argument constructor
    public PrimeNumbers() {
        createUserInterface();
    }

    // main method
    public static void main(String[] args) {
        PrimeNumbers application = new PrimeNumbers();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } // end method main

    // create and position GUI components; register event handlers
    private void createUserInterface() {
        // get content pane for attaching GUI components
        Container contentPane = getContentPane();

        // enable explicit positioning of GUI components
        contentPane.setLayout(null);

        // set up lowerBoundJLabel
        // JLabel and JTextField to enter the lower bound
        JLabel lowerBoundJLabel = new JLabel();
        lowerBoundJLabel.setBounds(16, 16, 80, 21);
        lowerBoundJLabel.setText("Lower bound:");
        contentPane.add(lowerBoundJLabel);

        // set up lowerBoundJTextField
        lowerBoundJTextField = new JTextField();
        lowerBoundJTextField.setBounds(104, 16, 56, 21);
        lowerBoundJTextField.setHorizontalAlignment(
                JTextField.RIGHT);
        contentPane.add(lowerBoundJTextField);

        // set up upperBoundJLabel
        // JLabel and JTextField to enter the upper bound
        JLabel upperBoundJLabel = new JLabel();
        upperBoundJLabel.setBounds(16, 56, 80, 21);
        upperBoundJLabel.setText("Upper bound:");
        contentPane.add(upperBoundJLabel);

        // set up upperBoundJTextField
        upperBoundJTextField = new JTextField();
        upperBoundJTextField.setBounds(104, 56, 56, 21);
        upperBoundJTextField.setHorizontalAlignment(
                JTextField.RIGHT);
        contentPane.add(upperBoundJTextField);

        // set up primeNumbersJLabel
        // JLabel, JTextField and JScrollPane to display primes
        JLabel primeNumbersJLabel = new JLabel();
        primeNumbersJLabel.setBounds(16, 100, 96, 21);
        primeNumbersJLabel.setText("Prime numbers:");
        contentPane.add(primeNumbersJLabel);

        // set up primeNumbersJTextArea
        primeNumbersJTextArea = new JTextArea();
        primeNumbersJTextArea.setEditable(false);

        // set up outputJScrollPane
        JScrollPane outputJScrollPane = new JScrollPane(primeNumbersJTextArea);
        outputJScrollPane.setBounds(16, 120, 144, 96);
        contentPane.add(outputJScrollPane);

        // set up calculatePrimesJButton
        // JButton for determining primes between the bounds
        JButton calculatePrimesJButton = new JButton();
        calculatePrimesJButton.setBounds(16, 232, 144, 23);
        calculatePrimesJButton.setText("Calculate Primes");
        contentPane.add(calculatePrimesJButton);
        // anonymous inner class
        // event handler called when calculatePrimesJButton is pressed
        calculatePrimesJButton.addActionListener(

                this::calculatePrimesJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set properties of application's window
        setTitle("Prime Numbers"); // set title bar String
        setSize(185, 300);         // set window size
        setVisible(true);          // display window

    } // end method createUserInterface

    // calculate and display primes using method prime
    private void calculatePrimesJButtonActionPerformed(
            ActionEvent event) {
        // clear primeNumbersJTextField
        primeNumbersJTextArea.setText("");

        // try to receive user input
        try {
            // get user input
            int lowerBound = Integer.parseInt(
                    lowerBoundJTextField.getText());
            int upperBound = Integer.parseInt(
                    upperBoundJTextField.getText());

            // display prime numbers
            displayPrimes(lowerBound, upperBound);
        } catch (NumberFormatException exception) {
            JOptionPane.showMessageDialog(this,
                    "Please enter integers for the lower and upper bounds",
                    "Number Format Error", JOptionPane.ERROR_MESSAGE);
        } // end of catch block

    } // end method calculatePrimesJButtonActionPerformed

    // display prime numbers within given bounds
    private void displayPrimes(int lowerBound, int upperBound) {
        // if bounds are within appropriate range,
        // display prime numbers
        if ((lowerBound <= 0) || (upperBound <= 0)) {
            JOptionPane.showMessageDialog(this,
                    "Bounds must be greater than 0", "Invalid Bounds",
                    JOptionPane.ERROR_MESSAGE);
        } else if (upperBound < lowerBound) {
            JOptionPane.showMessageDialog(this,
                    "Upper bound cannot be less than lower bound",
                    "Invalid Bounds", JOptionPane.ERROR_MESSAGE);
        } else {
            // loop from lower bound to upper bound
            for (int counter = lowerBound; counter <= upperBound;
                 counter++) {
                // if prime number, display in JTextArea
                if (prime(counter)) {
                    primeNumbersJTextArea.append(counter + "\n");
                }

            } // end for loop

        } // end else

    } // end method displayPrimes

    // determine if number is prime
    private boolean prime(int number) {
        // 1 is not a valid prime number
        if (number == 1) {
            return false;
        }

        // set square root of number as limit
        double limit = Math.sqrt(number);

        // loop until count reaches square root of number
        for (int count = 2; count <= limit; count++) {
            if ((number % count) == 0) {
                return false; // number is not prime
            }

        } // end for loop

        return true; // number is prime

    } // end method prime

} // end class PrimeNumbers

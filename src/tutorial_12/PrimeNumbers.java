package tutorial_12;// Exercise 12.17: PrimeNumbers.java
// Determines all prime numbers between a user-specified range.

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
        // JLabel and JTextField for lower bound
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
        // JLabel and JTextField for upper bound
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
        // JLabel, JTextArea and JScrollPane for displaying prime numbers
        JLabel primeNumbersJLabel = new JLabel();
        primeNumbersJLabel.setBounds(16, 100, 96, 21);
        primeNumbersJLabel.setText("Prime numbers:");
        contentPane.add(primeNumbersJLabel);

        // set up primeNumbersJTextArea
        primeNumbersJTextArea = new JTextArea();
        primeNumbersJTextArea.setEditable(false);

        // set up primeNumbersJScrollPane
        JScrollPane primeNumbersJScrollPane = new JScrollPane(
                primeNumbersJTextArea);
        primeNumbersJScrollPane.setBounds(16, 120, 144, 96);
        contentPane.add(primeNumbersJScrollPane);

        // set up calculatePrimesJButton
        // JButton initiates calculation and display of prime numbers
        JButton calculatePrimesJButton = new JButton();
        calculatePrimesJButton.setBounds(16, 232, 144, 23);
        calculatePrimesJButton.setText("Calculate Primes");
        contentPane.add(calculatePrimesJButton);
        // anonymous inner class
        // event handler called when
        // calculatePrimesJButton is clicked
        calculatePrimesJButton.addActionListener(

                this::calculatePrimesJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set properties of application's window
        setTitle("Prime Numbers"); // set title bar string
        setSize(184, 296);         // set window size
        setVisible(true);          // display window

    } // end method createUserInterface

    // calculate and display primes using method prime
    private void calculatePrimesJButtonActionPerformed(
            ActionEvent event) {
        // declare variables and get values
        int lowerBound = Integer.parseInt(lowerBoundJTextField.getText());
        int upperBound = Integer.parseInt(upperBoundJTextField.getText());
        int counter;
        primeNumbersJTextArea.setText("");

        if ((lowerBound <= 0) || (upperBound <= 0)) {
            JOptionPane.showMessageDialog(null,
                    "Bounds must be greater than 0", "Invalid Bounds",
                    JOptionPane.ERROR_MESSAGE);
        } else if (upperBound < lowerBound) {
            JOptionPane.showMessageDialog(null,
                    "Upper bound cannot be less than lower bound",
                    "Invalid Bounds", JOptionPane.ERROR_MESSAGE);
        } else {
            // loop from lower bound to upper bound
            for (counter = lowerBound; counter <= upperBound;
                 counter++) {
                // if prime number, display in primeNumbersJTextArea
                if (isPrime(counter)) {
                    primeNumbersJTextArea.append(counter + "\n");
                }
            } // end for loop
        } // end else

    } // end method calculatePrimesJButtonActionPerformed

    // method to determine if a number is a Prime number?
    private boolean isPrime(int number) {
        // number 1 is not a Prime number
        if (number == 1)
            return false;

        int limit = (int) Math.sqrt(number);

        for (int counter = 2; counter <= limit; counter++) {
            if (number % counter == 0) {
                return false;
            }
        }
        return true;
    }

} // end class PrimeNumbers

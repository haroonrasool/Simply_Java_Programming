package tutorial_12;

// Tutorial 12: HypotenuseCalculator.java
// This program finds and displays hypotenuse of a triangle
// whose sides are entered by the user.

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.text.DecimalFormat;

public class HypotenuseCalculator extends JFrame {
    private JTextField lengthSideAJTextField;

    private JTextField lengthSideBJTextField;

    private JTextField lengthHypotenuseJTextField;

    // no-argument constructor
    public HypotenuseCalculator() {
        createUserInterface();
    }

    // main method
    public static void main(String[] args) {
        HypotenuseCalculator application = new HypotenuseCalculator();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } // end method main

    // create and position GUI components; register event handlers
    private void createUserInterface() {
        // get content pane for attaching GUI components
        Container contentPane = getContentPane();

        // enable explicit positioning of GUI components
        contentPane.setLayout(null);

        // set up lengthSideAJLabel
        // JLabel and JTextField for length of side A
        JLabel lengthSideAJLabel = new JLabel();
        lengthSideAJLabel.setBounds(16, 13, 100, 21);
        lengthSideAJLabel.setText("Length of side A:");
        contentPane.add(lengthSideAJLabel);

        // set up lengthSideAJTextField
        lengthSideAJTextField = new JTextField();
        lengthSideAJTextField.setBounds(150, 13, 90, 21);
        lengthSideAJTextField.setHorizontalAlignment(
                JTextField.RIGHT);
        contentPane.add(lengthSideAJTextField);

        // set up lengthSideBJLabel
        // JLabel and JTextField for length of side B
        JLabel lengthSideBJLabel = new JLabel();
        lengthSideBJLabel.setBounds(16, 45, 100, 21);
        lengthSideBJLabel.setText("Length of side B:");
        contentPane.add(lengthSideBJLabel);

        // set up lengthSideBJTextField
        lengthSideBJTextField = new JTextField();
        lengthSideBJTextField.setBounds(150, 45, 90, 21);
        lengthSideBJTextField.setHorizontalAlignment(
                JTextField.RIGHT);
        contentPane.add(lengthSideBJTextField);

        // setup Formula JLabel
        // JLabel for hypotenuse formula
        JLabel hypotenuseFormulaJLabel = new JLabel();
        hypotenuseFormulaJLabel.setBounds(16, 70, 250, 21);
        hypotenuseFormulaJLabel.setText("Hypotenuse Formula: (a^2 + b^2)^1/2");
        contentPane.add(hypotenuseFormulaJLabel);

        // set up lengthHypotenuseJLabel
        // JLabel and JTextField for hypotenuse
        JLabel lengthHypotenuseJLabel = new JLabel();
        lengthHypotenuseJLabel.setBounds(16, 89, 130, 21);
        lengthHypotenuseJLabel.setText("Length of hypotenuse:");
        contentPane.add(lengthHypotenuseJLabel);

        // set up lengthHypotenuseJTextField
        lengthHypotenuseJTextField = new JTextField();
        lengthHypotenuseJTextField.setBounds(150, 89, 90, 21);
        lengthHypotenuseJTextField.setHorizontalAlignment(
                JTextField.CENTER);
        lengthHypotenuseJTextField.setEditable(false);
        contentPane.add(lengthHypotenuseJTextField);

        // set up calculateJButton
        // JButton to initiate calculation of hypotenuse
        JButton calculateJButton = new JButton();
        calculateJButton.setBounds(150, 121, 90, 23);
        calculateJButton.setText("Calculate");
        contentPane.add(calculateJButton);
        // anonymous inner class
        // event handler called when calculateJButton is pressed
        calculateJButton.addActionListener(

                this::calculateJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set properties of application's window
        setTitle("Hypotenuse Calculator"); // set title bar string
        setSize(262, 185);                 // set window size
        setVisible(true);                  // display window

    } // end method createUserInterface

    // calculate and display hypotenuse length
    private void calculateJButtonActionPerformed(ActionEvent event) {
        // get input from JTextFields
        double sideA = Double.parseDouble(
                lengthSideAJTextField.getText());
        double sideB = Double.parseDouble(
                lengthSideBJTextField.getText());

        // display error message if user enters invalid input
        if (sideA <= 0 || sideB <= 0) {
            JOptionPane.showMessageDialog(null,
                    "You must enter positive numbers",
                    "Invalid Input Entered", JOptionPane.ERROR_MESSAGE);
        } else {
            // calculate the squares of sides A and B
            double squaredSideA = square(sideA);
            double squaredSideB = square(sideB);

            // use the Pythagorean theorem to calculate
            // square of the hypotenuse
            double squaredHypotenuse = squaredSideA + squaredSideB;

            // use built-in method Math.sqrt to calculate the square
            // root of the hypotenuse squared (this is the hypotenuse)
            double hypotenuse = Math.sqrt(squaredHypotenuse);

            DecimalFormat twoDigits = new DecimalFormat("0.00");

            // format hypotenuse value
            String hypotenuseText = twoDigits.format(hypotenuse);

            // display hypotenuse in JTextField
            lengthHypotenuseJTextField.setText(hypotenuseText);

        } // end else

    } // end method calculateJButtonActionPerformed

    // return the square of side
    private double square(double side) {
        return side * side;  // return square of argument

    } // end method square

} // end class HypotenuseCalculator

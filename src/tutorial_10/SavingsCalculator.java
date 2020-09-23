package tutorial_10;

// Exercise 10.16: SavingsCalculator.java
// Application that calculates the amount of money the user will have
// after one year of saving $100 a month, plus an initial deposit.

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class SavingsCalculator extends JFrame {
    private JTextField startingJTextField;

    private JTextField yearJTextField;

    // no-argument constructor
    public SavingsCalculator() {
        createUserInterface();
    }

    // main method
    public static void main(String[] args) {
        SavingsCalculator application = new SavingsCalculator();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } // end method main

    // create and position GUI components; register event handlers
    private void createUserInterface() {
        // get content pane for attaching GUI components
        Container contentPane = getContentPane();

        // enable explicit positioning of GUI components
        contentPane.setLayout(null);

        // set up startingJLabel
        // JLabel and JTextField for starting amount
        JLabel startingJLabel = new JLabel();
        startingJLabel.setBounds(15, 15, 120, 20);
        startingJLabel.setText("Starting amount:");
        contentPane.add(startingJLabel);

        // set up startingJTextField
        startingJTextField = new JTextField();
        startingJTextField.setBounds(155, 15, 90, 20);
        startingJTextField.setHorizontalAlignment(JTextField.RIGHT);
        contentPane.add(startingJTextField);

        // set up yearJLabel
        // JLabel and JTextField for amount after one year
        JLabel yearJLabel = new JLabel();
        yearJLabel.setBounds(15, 50, 160, 20);
        yearJLabel.setText("Amount after one year:");
        contentPane.add(yearJLabel);

        // set up yearJTextField
        yearJTextField = new JTextField();
        yearJTextField.setBounds(155, 50, 90, 20);
        yearJTextField.setText("");
        yearJTextField.setHorizontalAlignment(JTextField.RIGHT);
        yearJTextField.setEditable(false);
        contentPane.add(yearJTextField);

        // set up calculateJButton
        // JButton calculates amounts after one, two and three years
        JButton calculateJButton = new JButton();
        calculateJButton.setBounds(155, 85, 90, 20);
        calculateJButton.setText("Calculate");
        contentPane.add(calculateJButton);
        // anonymous inner class
        // event handler called when calculateJButton is pressed
        calculateJButton.addActionListener(

                this::calculateJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set properties of application's window
        setTitle("Savings Calculator"); // set title bar text
        setSize(280, 160);              // set window size
        setVisible(true);               // display window

    } // end method createUserInterface

    // calculate and display amount
    private void calculateJButtonActionPerformed(ActionEvent event) {
        // retrieving deposit from startingJTextField
        int deposit = Integer.parseInt(startingJTextField.getText());

        // for loop increments deposit
        for (int counter = 1; counter <= 12; counter++) {
            deposit += 100;
        }

        // display deposit in yearJTextField
        yearJTextField.setText(String.valueOf(deposit));

    } // end method calculateJButtonActionPerformed

}  // end class SavingsCalculator

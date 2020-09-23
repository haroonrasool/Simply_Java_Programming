package tutorial_8;

// Exercise 8.12: MortgageCalculator.java
// Calculates mortgage rate based on user inputs

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;

public class MortgageCalculator extends JFrame {
    private JTextField amountJTextField;

    private JTextField interestJTextField;

    // JTextArea for displaying results
    private JTextArea outputJTextArea;

    // no-argument constructor
    public MortgageCalculator() {
        createUserInterface();
    }

    // main method
    public static void main(String[] args) {
        MortgageCalculator application = new MortgageCalculator();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } // end method main

    // create and position the GUI components; register event handlers
    private void createUserInterface() {
        // get content pane for attaching GUI components
        Container contentPane = getContentPane();

        // enable explicit positioning of GUI components
        contentPane.setLayout(null);

        // set up amountJLabel
        // JLabel and JTextField for the mortgage amount
        JLabel amountJLabel = new JLabel();
        amountJLabel.setBounds(16, 16, 104, 26);
        amountJLabel.setText("Mortgage amount:");
        contentPane.add(amountJLabel);

        // set up amountJTextField
        amountJTextField = new JTextField();
        amountJTextField.setBounds(144, 16, 56, 26);
        amountJTextField.setHorizontalAlignment(JTextField.RIGHT);
        contentPane.add(amountJTextField);
        amountJTextField.addKeyListener(

                new KeyAdapter() // anonymous inner class
                {
                    // event handler for key pressed in amountJTextField
                    public void keyPressed(KeyEvent event) {
                        amountJTextFieldKeyPressed(event);
                    }

                } // end anonymous inner class

        ); // end call to addKeyListener

        // set up interestJLabel
        // JLabel and JTextField for interest percentage rate
        JLabel interestJLabel = new JLabel("Annual interest rate:");
        interestJLabel.setBounds(16, 56, 115, 26);
        interestJLabel.setText("Annual interest rate:");
        contentPane.add(interestJLabel);

        // set up interestJTextField
        interestJTextField = new JTextField();
        interestJTextField.setBounds(144, 56, 56, 26);
        interestJTextField.setHorizontalAlignment(JTextField.RIGHT);
        contentPane.add(interestJTextField);
        interestJTextField.addKeyListener(

                new KeyAdapter() // anonymous inner class
                {
                    // event handler for key pressed in interestJTextField
                    public void interestJTextField(KeyEvent event) {
                        interestJTextFieldKeyPressed(event);
                    }

                } // end anonymous inner class

        ); // end call to addKeyListener

        // set up calculateJButton
        // JButton to initiate calculations
        JButton calculateJButton = new JButton();
        calculateJButton.setBounds(224, 56, 90, 26);
        calculateJButton.setText("Calculate");
        contentPane.add(calculateJButton);
        // anonymous inner class
        // event handler called when calculateJButton is pressed
        calculateJButton.addActionListener(

                this::calculateJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set up outputJTextArea
        outputJTextArea = new JTextArea();
        outputJTextArea.setBounds(16, 96, 298, 110);
        outputJTextArea.setEditable(false);
        contentPane.add(outputJTextArea);

        // set properties of application's window
        setTitle("Mortgage Calculator"); // set title bar text
        setSize(340, 250);  // set window's size
        setVisible(true);                // display window

    } // end method createUserInterface

    // called when user presses key in amountJTextField
    private void amountJTextFieldKeyPressed(KeyEvent event) {
        // clear outputJTextArea
        outputJTextArea.setText("");
    }

    // called when user presses key in interestJTextField
    private void interestJTextFieldKeyPressed(KeyEvent event) {
        // clear outputJTextArea
        outputJTextArea.setText("");
    }

    // method called when the user clicks on calculateJButton
    private void calculateJButtonActionPerformed(ActionEvent event) {
        int years = 10;         // length of the mortgage in years
        int months;             // payment period
        double monthlyPayment; // monthly payment

        // clear JTextArea
        outputJTextArea.setText("");

        // add header to outputJTextArea
        outputJTextArea.append("Mortgage Length (Years)\tMonthly Payment");

        // retrieve user inputs and store in variables
        int mortgageAmount = Integer.parseInt(amountJTextField.getText());
        double annualRate = Double.parseDouble(interestJTextField.getText());

        // calculate monthly interest rate
        double monthlyInterest = (annualRate / 100) / 12;

        // format to display monthlyPayment in currency format
        DecimalFormat currency = new DecimalFormat("$0.00");

        // while years is less than or equal to 30 years
        while (years <= 30) {

            // calculate payment period
            months = 12 * years;

            // get monthlyPayment
            monthlyPayment = calculateMonthlyPayment(monthlyInterest, months, mortgageAmount);

            // insert result into outputJTextArea
            outputJTextArea.append("\n" + years + "\t\t" + currency.format(monthlyPayment));

            // increment the counter
            years += 5;
        }

    } // end method calculateJButtonActionPerformed

    // calculate monthlyPayment
    private double calculateMonthlyPayment(double monthlyInterest, int months, int loanAmount) {
        double base = Math.pow(1 + monthlyInterest, months);
        return loanAmount * monthlyInterest / (1 - (1 / base));
    }

} // end class MortgageCalculator

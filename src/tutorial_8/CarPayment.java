package tutorial_8;

// Tutorial 8: CarPayment.java
// Calculate different billing plans for a car loan.

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.text.DecimalFormat;

public class CarPayment extends JFrame {
    // JTextFields
    private JTextField priceJTextField;
    private JTextField downPaymentJTextField;
    private JTextField interestJTextField;

    // JTextArea to display results
    private JTextArea paymentsJTextArea;

    // no-argument constructor
    public CarPayment() {
        createUserInterface();
    }

    // main method
    public static void main(String[] args) {
        CarPayment application = new CarPayment();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } // end method main

    // create and position GUI components; register event handlers
    private void createUserInterface() {
        // get content pane for attaching GUI components
        Container contentPane = getContentPane();
        // enable explicit positioning of GUI components
        // set layout to null
        contentPane.setLayout(null);

        // set up priceJLabel
        JLabel priceJLabel = new JLabel();
        priceJLabel.setBounds(40, 24, 80, 21);
        priceJLabel.setText("Price:");
        contentPane.add(priceJLabel);

        // set up priceJTextField
        priceJTextField = new JTextField();
        priceJTextField.setBounds(184, 24, 56, 21);
        priceJTextField.setHorizontalAlignment(JTextField.RIGHT);
        contentPane.add(priceJTextField);

        // set up downPaymentJLabel
        // JLabel and JTextField for down payment
        JLabel downPaymentJLabel = new JLabel();
        downPaymentJLabel.setBounds(40, 56, 96, 21);
        downPaymentJLabel.setText("Down payment:");
        contentPane.add(downPaymentJLabel);

        // set up downPaymentJTextField
        downPaymentJTextField = new JTextField();
        downPaymentJTextField.setBounds(184, 56, 56, 21);
        downPaymentJTextField.setHorizontalAlignment(JTextField.RIGHT);
        contentPane.add(downPaymentJTextField);

        // set up interestJLabel
        JLabel interestJLabel = new JLabel();
        interestJLabel.setBounds(40, 88, 120, 21);
        interestJLabel.setText("Annual interest rate:");
        contentPane.add(interestJLabel);

        // set up interestJTextField
        interestJTextField = new JTextField();
        interestJTextField.setBounds(184, 88, 56, 21);
        interestJTextField.setHorizontalAlignment(JTextField.RIGHT);
        contentPane.add(interestJTextField);

        // set up calculateJButton and register its event handler
        // JButton to initiate calculation
        JButton calculateJButton = new JButton();
        calculateJButton.setBounds(92, 128, 94, 24);
        calculateJButton.setText("Calculate");
        contentPane.add(calculateJButton);
        // anonymous inner class
        // event handler called when user clicks calculateJButton
        calculateJButton.addActionListener(

                this::calculateJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set up paymentsJTextArea
        paymentsJTextArea = new JTextArea();
        paymentsJTextArea.setBounds(28, 168, 232, 90);
        paymentsJTextArea.setEditable(false);
        contentPane.add(paymentsJTextArea);

        // set properties of application's window
        setTitle("Car Payment Calculator"); // set title bar text
        setSize(240, 310);     // set window's size
        setVisible(true);                   // display window

    } // end method createUserInterface

    // method called when user clicks calculateJButton
    private void calculateJButtonActionPerformed(ActionEvent event) {
        int years = 2;          // length of the loan in years
        int months;             // payment period
        double monthlyPayment;  // monthly payment

        // clear paymentsJTextArea
//        paymentsJTextArea.setText("");
        clearJTextArea();
        // add header to paymentsJTextArea
        paymentsJTextArea.append("Months\tMonthly Payments");

        // retrieve user input
        int carPrice = Integer.parseInt(priceJTextField.getText());
        int downPayment = Integer.parseInt(downPaymentJTextField.getText());
        double annualInterest = Double.parseDouble(interestJTextField.getText());

        // calculate loan amount and monthly interest
        int loanAmount = carPrice - downPayment;
        double monthlyInterest = (annualInterest / 100) / 12;

        // format to display monthlyPayment in currency format
        DecimalFormat currency = new DecimalFormat("$0.00");

        // while years is less than or equal to five years
        while (years <= 5) {
            // calculate payment period
            months = 12 * years;

            // get monthlyPayment
            monthlyPayment = calculateMonthlyPayment(
                    monthlyInterest, months, loanAmount);

            // insert result into paymentsJTextArea
            paymentsJTextArea.append("\n" + months + "\t" +
                    currency.format(monthlyPayment));

            years++;  // increment counter

        } // end while

    } // end method calculateJButtonActionPerformed

    // method to clear JTextArea contents
    private void clearJTextArea() {
        // clear JTextArea contents
        paymentsJTextArea.setText("");
    }

    // calculate monthlyPayment
    private double calculateMonthlyPayment(double monthlyInterest, int months, int loanAmount) {
        double base = Math.pow(1 + monthlyInterest, months);
        return loanAmount * monthlyInterest / (1 - (1 / base));
    }

} // end class CarPayment

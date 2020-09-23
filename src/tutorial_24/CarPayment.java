package tutorial_24;

// Tutorial 24: CarPayment.java
// This application uses exception-handling to handle invalid input.

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.text.DecimalFormat;

public class CarPayment extends JFrame {
    private JTextField priceJTextField;
    private JTextField downPaymentJTextField;
    private JTextField interestRateJTextField;

    // JTextArea to display the monthly payments
    private JTextArea monthlyPaymentsJTextArea;

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
        contentPane.setLayout(null);

        // set up priceJLabel
        // JLabel and JTextField for price
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
        downPaymentJTextField.setHorizontalAlignment(
                JTextField.RIGHT);
        contentPane.add(downPaymentJTextField);

        // set up interestRateJLabel
        // JLabel and JTextField for interest rate
        JLabel interestRateJLabel = new JLabel();
        interestRateJLabel.setBounds(40, 88, 120, 21);
        interestRateJLabel.setText("Annual interest rate:");
        contentPane.add(interestRateJLabel);

        // set up interestRateJTextField
        interestRateJTextField = new JTextField();
        interestRateJTextField.setBounds(184, 88, 56, 21);
        interestRateJTextField.setHorizontalAlignment(
                JTextField.RIGHT);
        contentPane.add(interestRateJTextField);

        // set up calculateJButton
        // JButton to calculate the monthly payments
        JButton calculateJButton = new JButton();
        calculateJButton.setBounds(92, 128, 94, 24);
        calculateJButton.setText("Calculate");
        contentPane.add(calculateJButton);
        // anonymous inner class
        // event handler called when calculateJButton is clicked
        calculateJButton.addActionListener(

                this::calculateJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set up monthlyPaymentsJTextArea
        monthlyPaymentsJTextArea = new JTextArea();
        monthlyPaymentsJTextArea.setBounds(28, 168, 232, 90);
        monthlyPaymentsJTextArea.setEditable(false);
        contentPane.add(monthlyPaymentsJTextArea);

        // set properties of application's window
        setTitle("Car Payment Calculator"); // set title bar String
        setSize(290, 310);                  // set window size
        setVisible(true);                   // display window

    } // end method createUserInterface

    // calculate the monthly car payments
    private void calculateJButtonActionPerformed(ActionEvent event) {
        // clear JTextArea
        monthlyPaymentsJTextArea.setText("");

        // try to retrieve price and down payment
        try {
            // get an integer from priceJTextField
            int carPrice = Integer.parseInt(priceJTextField.getText());

            // get an integer from downPaymentJTextField
            int downPayment =
                    Integer.parseInt(downPaymentJTextField.getText());

            // get a double from interestRateJTextField
            double interest =
                    Double.parseDouble(interestRateJTextField.getText());

            // create table of options over different periods of time
            processData(carPrice, downPayment, interest);
        } catch (NumberFormatException exception) {
            // integers were not input in the JTextFields
            JOptionPane.showMessageDialog(this,
                    "Please enter integers for the price and down\n" +
                            "payment and a decimal number for the interest",
                    "Number Format Error", JOptionPane.ERROR_MESSAGE);
        }

    } // end method calculateJButtonActionPerformed

    // process entered data and calculate payments over
    // each time interval
    private void processData(int carPrice, int downPayment,
                             double interest) {
        // calculate loan amount and monthly interest
        int loanAmount = carPrice - downPayment;
        double monthlyInterest = interest / 1200;

        // format to display monthlyPayment in currency format
        DecimalFormat currency = new DecimalFormat("$0.00");

        // repetition counter
        int years = 2;

        // add header JTextArea
        monthlyPaymentsJTextArea.append("Months\tMonthly Payments");

        // while years is less than or equal to five years
        while (years <= 5) {
            // calculate payment period
            int months = 12 * years;

            // get monthlyPayment
            double monthlyPayment = calculateMonthlyPayment(
                    monthlyInterest, months, loanAmount);

            // insert result into JTextArea
            monthlyPaymentsJTextArea.append("\n" + months + "\t" +
                    currency.format(monthlyPayment));

            years++;  // increment counter

        } // end while

    } // end method processData

    // calculate monthlyPayment
    private double calculateMonthlyPayment(double monthlyInterest,
                                           int months, int loanAmount) {
        double base = Math.pow(1 + monthlyInterest, months);
        return loanAmount * monthlyInterest / (1 - (1 / base));

    } // end method calculateMonthlyPayment

} // end class CarPayment

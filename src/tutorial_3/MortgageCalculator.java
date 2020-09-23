package tutorial_3;

// Exercise 3.12: MortgageCalculator.java
// GUI for mortgage calculator application.

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class MortgageCalculator extends JFrame {
    // no-argument constructor
    public MortgageCalculator() {
        createUserInterface();
    }

    // main method
    public static void main(String[] args) {
        MortgageCalculator application = new MortgageCalculator();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } // end method main

    // create and position GUI components
    public void createUserInterface() {
        // get content pane and set its layout
        Container container = getContentPane();
        container.setLayout(null);

        // set up homeValueJLabel
        // JLabel and JTextField for home value
        JLabel homeValueJLabel = new JLabel();
        homeValueJLabel.setBounds(16, 16, 80, 21);
        homeValueJLabel.setText("Home value:");
        container.add(homeValueJLabel);

        // set up homeValueJTextField
        JTextField homeValueJTextField = new JTextField();
        homeValueJTextField.setBounds(212, 16, 100, 21);
        homeValueJTextField.setText("125000");
        homeValueJTextField.setHorizontalAlignment(JTextField.RIGHT);
        container.add(homeValueJTextField);

        // set up loanAmountJLabel
        // JLabel and JTextField for loan amount
        JLabel loanAmountJLabel = new JLabel();
        loanAmountJLabel.setBounds(16, 56, 80, 21);
        loanAmountJLabel.setText("Loan amount:");
        container.add(loanAmountJLabel);

        // set up loanAmountJTextField
        JTextField loanAmountJTextField = new JTextField();
        loanAmountJTextField.setText("100000");
        loanAmountJTextField.setBounds(212, 56, 100, 21);
        loanAmountJTextField.setHorizontalAlignment(JTextField.RIGHT);
        container.add(loanAmountJTextField);

        // set up termJLabel
        // JLabel and JTextField for mortgage term in years
        JLabel termJLabel = new JLabel();
        termJLabel.setBounds(16, 96, 80, 21);
        termJLabel.setText("Term (years):");
        container.add(termJLabel);

        // set up termJTextField
        JTextField termJTextField = new JTextField();
        termJTextField.setBounds(212, 96, 100, 21);
        termJTextField.setText("20");
        termJTextField.setHorizontalAlignment(JTextField.RIGHT);
        container.add(termJTextField);

        // set up insuranceJLabel
        // JLabel and JTextField for yearly homeowner's insurance
        JLabel insuranceJLabel = new JLabel();
        insuranceJLabel.setBounds(16, 136, 196, 21);
        insuranceJLabel.setText("Homeowner's insurance (yearly):");
        container.add(insuranceJLabel);

        // set up insuranceJTextField
        JTextField insuranceJTextField = new JTextField();
        insuranceJTextField.setBounds(212, 136, 100, 21);
        insuranceJTextField.setText("500");
        insuranceJTextField.setHorizontalAlignment(JTextField.RIGHT);
        container.add(insuranceJTextField);

        // set up propertyTaxesJLabel
        // JLabel and JTextField for yearly property taxes
        JLabel propertyTaxesJLabel = new JLabel();
        propertyTaxesJLabel.setBounds(16, 176, 148, 21);
        propertyTaxesJLabel.setText("Property taxes (yearly):");
        container.add(propertyTaxesJLabel);

        // set up propertyTaxesJTextField
        JTextField propertyTaxesJTextField = new JTextField();
        propertyTaxesJTextField.setBounds(212, 176, 100, 21);
        propertyTaxesJTextField.setText("2100");
        propertyTaxesJTextField.setHorizontalAlignment(JTextField.RIGHT);
        container.add(propertyTaxesJTextField);

        // set up interestJLabel
        // JLabel and JTextField for interest rate percentage
        JLabel interestJLabel = new JLabel();
        interestJLabel.setBounds(16, 216, 140, 21);
        interestJLabel.setText("Interest rate (percent):");
        container.add(interestJLabel);

        // set up interestJTextField
        JTextField interestJTextField = new JTextField();
        interestJTextField.setBounds(212, 216, 100, 21);
        interestJTextField.setText("5.5");
        interestJTextField.setHorizontalAlignment(JTextField.RIGHT);
        container.add(interestJTextField);

        // set up monthlyPaymentJLabel
        // JLabel and JTextField for monthly payment amount
        JLabel monthlyPaymentJLabel = new JLabel();
        monthlyPaymentJLabel.setBounds(16, 256, 106, 21);
        monthlyPaymentJLabel.setText("Monthly payment:");
        container.add(monthlyPaymentJLabel);

        // set up monthlyPaymentJTextField
        JTextField monthlyPaymentJTextField = new JTextField();
        monthlyPaymentJTextField.setBounds(212, 256, 100, 21);
        monthlyPaymentJTextField.setHorizontalAlignment(JTextField.CENTER);
        monthlyPaymentJTextField.setBorder(new BevelBorder(BevelBorder.LOWERED));
        monthlyPaymentJTextField.setEditable(false);
        container.add(monthlyPaymentJTextField);

        // set up calculateJButton
        // JButtons to calculate monthly payment and clear all JTextFields
        JButton calculateJButton = new JButton();
        calculateJButton.setBounds(133, 296, 90, 23);
        calculateJButton.setText("Calculate");
        container.add(calculateJButton);

        // set up clearJButton
        JButton clearJButton = new JButton();
        clearJButton.setBounds(237, 296, 75, 23);
        clearJButton.setText("Clear");
        container.add(clearJButton);

        // set properties of application�s window
        setTitle("Mortgage Calculator"); // set title bar text
        setSize(335, 365);               // set window size
        setVisible(true);                // display window

    } // end method createUserInterface

} // end class MortgageCalculator

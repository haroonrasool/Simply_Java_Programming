package tutorial_6;

// Exercise 6.13: CreditChecker.java
// This application calculates a credit balance and 
// determines whether the credit limit has been exceeded.

import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import javax.swing.*;

public class CreditChecker extends JFrame {

    private JTextField startBalanceJTextField;

    private JTextField totalChargesJTextField;

    private JTextField totalCreditsJTextField;

    private JTextField creditLimitJTextField;

    private JTextField newBalanceJTextField;

    // JTextField for displaying error message
    private JTextField errorJTextField;

    // no-argument constructor
    public CreditChecker() {
        createUserInterface();
    }

    // main method
    public static void main(String[] args) {
        CreditChecker application = new CreditChecker();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } // end method main

    // create and position GUI components; register event handlers
    private void createUserInterface() {
        // get content pane for attaching GUI components
        Container contentPane = getContentPane();

        // enable explicit positioning of GUI components
        contentPane.setLayout(null);

        // set up accountNumberJLabel
        // JLabel and JTextField for account number
        JLabel accountNumberJLabel = new JLabel();
        accountNumberJLabel.setBounds(16, 16, 106, 21);
        accountNumberJLabel.setText("Account number:");
        contentPane.add(accountNumberJLabel);

        // set up accountNumberJTextField
        JTextField accountNumberJTextField = new JTextField();
        accountNumberJTextField.setBounds(130, 16, 96, 21);
        accountNumberJTextField.setHorizontalAlignment(
                JTextField.RIGHT);
        contentPane.add(accountNumberJTextField);
        accountNumberJTextField.addKeyListener(

                new KeyAdapter() // anonymous inner class
                {
                    // event handler called when key pressed in
                    // accountNumberJTextField
                    public void keyPressed(KeyEvent event) {
                        accountNumberJTextFieldKeyPressed();
                    }

                } // end anonymous inner class

        ); // end call to addKeyListener

        // set up startBalanceJLabel
        // JLabel and JTextField for starting balance
        JLabel startBalanceJLabel = new JLabel();
        startBalanceJLabel.setBounds(16, 56, 106, 21);
        startBalanceJLabel.setText("Starting balance:");
        contentPane.add(startBalanceJLabel);

        // set up startBalanceJTextField
        startBalanceJTextField = new JTextField();
        startBalanceJTextField.setBounds(130, 56, 96, 21);
        startBalanceJTextField.setHorizontalAlignment(
                JTextField.RIGHT);
        contentPane.add(startBalanceJTextField);

        // set up totalChargesJLabel
        // JLabel and JTextField for total charges
        JLabel totalChargesJLabel = new JLabel();
        totalChargesJLabel.setBounds(16, 96, 106, 21);
        totalChargesJLabel.setText("Total charges:");
        contentPane.add(totalChargesJLabel);

        // set up totalChargesJTextField
        totalChargesJTextField = new JTextField();
        totalChargesJTextField.setBounds(130, 96, 96, 21);
        totalChargesJTextField.setHorizontalAlignment(
                JTextField.RIGHT);
        contentPane.add(totalChargesJTextField);

        // set up totalCreditsJLabel
        // JLabel and JTextField for total credits
        JLabel totalCreditsJLabel = new JLabel();
        totalCreditsJLabel.setBounds(16, 136, 106, 21);
        totalCreditsJLabel.setText("Total credits:");
        contentPane.add(totalCreditsJLabel);

        // set up totalCreditsJTextField
        totalCreditsJTextField = new JTextField();
        totalCreditsJTextField.setBounds(130, 136, 96, 21);
        totalCreditsJTextField.setHorizontalAlignment(
                JTextField.RIGHT);
        contentPane.add(totalCreditsJTextField);

        // set up creditLimitJLabel
        // JLabel and JTextField for credit limit
        JLabel creditLimitJLabel = new JLabel();
        creditLimitJLabel.setBounds(16, 176, 106, 21);
        creditLimitJLabel.setText("Credit limit:");
        contentPane.add(creditLimitJLabel);

        // set up creditLimitJTextField
        creditLimitJTextField = new JTextField();
        creditLimitJTextField.setBounds(130, 176, 96, 21);
        creditLimitJTextField.setHorizontalAlignment(
                JTextField.RIGHT);
        contentPane.add(creditLimitJTextField);

        // set up newBalanceJTextField
        newBalanceJTextField = new JTextField();
        newBalanceJTextField.setBounds(130, 216, 96, 21);
        newBalanceJTextField.setHorizontalAlignment(
                JTextField.RIGHT);
        newBalanceJTextField.setEditable(false);
        contentPane.add(newBalanceJTextField);

        // set up newBalanceJLabel
        // JLabel and JTextField for displaying new balance
        JLabel newBalanceJLabel = new JLabel();
        newBalanceJLabel.setBounds(16, 216, 156, 21);
        newBalanceJLabel.setText("New balance:");
        contentPane.add(newBalanceJLabel);

        // set up errorJTextField
        errorJTextField = new JTextField();
        errorJTextField.setBounds(16, 256, 210, 21);
        errorJTextField.setHorizontalAlignment(JTextField.CENTER);
        errorJTextField.setEditable(false);
        contentPane.add(errorJTextField);

        // set up calculateJButton and register its event handler
        // JButton to initiate new balance calculation
        JButton calculateJButton = new JButton();
        calculateJButton.setBounds(90, 296, 136, 23);
        calculateJButton.setText("Calculate Balance");
        contentPane.add(calculateJButton);
        // anonymous inner class
        // event handler called when calculateJButton is pressed
        calculateJButton.addActionListener(

                this::calculateJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set properties of application's window
        setTitle("Credit Checker"); // set title bar text
        setSize(250, 370);          // set window size
        setVisible(true);           // display window

    } // end method createUserInterface

    // method called when key pressed in accountNumberJTextField
    private void accountNumberJTextFieldKeyPressed() {
        // clear all JTextFields when account number is changed
        startBalanceJTextField.setText("");
        totalChargesJTextField.setText("");
        totalCreditsJTextField.setText("");
        creditLimitJTextField.setText("");
        newBalanceJTextField.setText("");
        errorJTextField.setText("");

    } // end method accountNumberJTextFieldKeyPressed

    // method called when user clicks calculateJButton
    private void calculateJButtonActionPerformed(ActionEvent event) {
        double startBalance, totalCharges, totalCredits, creditLimit, newBalance;
        startBalance = Double.parseDouble(startBalanceJTextField.getText());
        totalCharges = Double.parseDouble(totalChargesJTextField.getText());
        totalCredits = Double.parseDouble(totalCreditsJTextField.getText());
        creditLimit = Double.parseDouble(creditLimitJTextField.getText());

        newBalance = startBalance + totalCharges - totalCredits;

        // specify output format
        DecimalFormat dollars = new DecimalFormat("$0.00");

        // display newBalance
        newBalanceJTextField.setText(dollars.format(newBalance));

        // determine if the credit limit has been reached?
        if (newBalance > creditLimit) {
            errorJTextField.setText("Credit Limit Exceeded!");
        } else {
            errorJTextField.setText("Credit Available!");
        }
    } // end method calculateJButtonActionPerformed

} // end class CreditChecker

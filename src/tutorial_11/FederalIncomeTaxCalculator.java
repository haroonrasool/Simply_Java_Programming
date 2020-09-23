package tutorial_11;

// Exercise 11.12: IncomeTaxCalculator.java
// Calculates a person's Federal income tax 
// depending that person's salary.

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;

public class FederalIncomeTaxCalculator extends JFrame {
    private JTextField salaryJTextField;

    private JTextField incomeTaxJTextField;

    // no-argument constructor
    public FederalIncomeTaxCalculator() {
        createUserInterface();
    }

    // main method
    public static void main(String[] args) {
        FederalIncomeTaxCalculator application = new FederalIncomeTaxCalculator();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } // end method main

    // create and position GUI components; register event handlers
    private void createUserInterface() {
        // get content pane for attaching GUI components
        Container contentPane = getContentPane();

        // enable explicit positioning of GUI components
        contentPane.setLayout(null);

        // set up salaryJLabel
        // JLabel and JTextField for user to input yearly salary
        JLabel salaryJLabel = new JLabel();
        salaryJLabel.setBounds(20, 20, 100, 20);
        salaryJLabel.setText("Yearly Salary:");
        contentPane.add(salaryJLabel);

        // set up salaryJTextField
        salaryJTextField = new JTextField();
        salaryJTextField.setBounds(140, 20, 90, 20);
        salaryJTextField.setHorizontalAlignment(JTextField.RIGHT);
        contentPane.add(salaryJTextField);
        salaryJTextField.addKeyListener(

                new KeyAdapter() // anonymous inner class
                {
                    // event handler called when key
                    // pressed in salaryJTextField
                    public void keyPressed(KeyEvent event) {
                        salaryJTextFieldKeyPressed();
                    }

                } // end anonymous inner class

        ); // end call to addKeyListener

        // set up incomeTaxJLabel
        // JLabel and JTextField to display income tax
        JLabel incomeTaxJLabel = new JLabel();
        incomeTaxJLabel.setText("Income Tax:");
        incomeTaxJLabel.setBounds(20, 60, 100, 20);
        contentPane.add(incomeTaxJLabel);

        // set up incomeTaxJTextField
        incomeTaxJTextField = new JTextField();
        incomeTaxJTextField.setBounds(140, 60, 90, 20);
        incomeTaxJTextField.setHorizontalAlignment(JTextField.RIGHT);
        incomeTaxJTextField.setEditable(false);
        contentPane.add(incomeTaxJTextField);

        // set up calculateJButton
        // JButton to initiate tax calculation
        JButton calculateJButton = new JButton();
        calculateJButton.setBounds(140, 100, 90, 25);
        calculateJButton.setText("Calculate");
        contentPane.add(calculateJButton);
        // anonymous inner class
        // event handler called when calculateJButton is pressed
        calculateJButton.addActionListener(

                this::calculateJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set properties of application's window
        setTitle("Income Tax Calculator"); // set window title
        setSize(255, 170);                 // set window size
        setVisible(true);                  // display window

    } // end method createUserInterface

    // clear incomeTaxJTextField when user types in salaryJTextField
    private void salaryJTextFieldKeyPressed() {
        incomeTaxJTextField.setText("");
    } // end method incomeTaxJTextFieldKeyPressed

    // calculate income tax based on user input
    private void calculateJButtonActionPerformed(ActionEvent event) {
        // retrieve yearly salary from salaryJTextField
        int salary = Integer.parseInt(salaryJTextField.getText());

        // declare the tax rate variable
        double taxRate;

        // switch statement
        switch (salary / 25000) {
            case 0: // yearly salary under $25,000
                taxRate = 0.02; // 2% tax rate
                break;

            case 1: // yearly salary in range $25,000-49,999
                taxRate = 0.05; // 5% tax rate
                break;

            case 2: // yearly salary in range $50,000-74,999
                taxRate = 0.1;  // 10% tax rate
                break;

            case 3: // yearly salary in range $75,000-99,999
                taxRate = 0.15; // 15% tax rate
                break;

            default: // yearly salary $100,000 or higher
                taxRate = 0.2;  // 20% tax rate

        } // end switch statement

        // display income tax
        double incomeTax = salary * taxRate;

        // format to display amount in currency format
        DecimalFormat dollars = new DecimalFormat("$0.00");

        // display incomeTax in incomeTaxJTextField
        incomeTaxJTextField.setText(dollars.format(incomeTax));

    } // end method calculateJButtonActionPerformed

} // end class IncomeTaxCalculator

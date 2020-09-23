package tutorial_6;

// Tutorial 6: WageCalculator.java
// This application inputs the hourly wage and number of hours
// worked for an employee, then calculates the employee's gross 
// wages (with overtime for hours worked over 40 hours).

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.text.DecimalFormat;

public class WageCalculator extends JFrame {
    private JTextField hourlyWageJTextField;

    private JTextField hoursWorkedJTextField;

    private JTextField grossWagesJTextField;

    // no-argument constructor
    public WageCalculator() {
        createUserInterface();
    }

    // main method
    public static void main(String[] args) {
        WageCalculator application = new WageCalculator();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } // end method main

    // create and position GUI components; register event handlers
    public void createUserInterface() {
        // get content pane for attaching GUI components
        Container contentPane = getContentPane();

        // enable explicit positioning of GUI components
        contentPane.setLayout(null);

        // set up hourlyWageJLabel
        // JLabel and JTextField for wage per hour
        JLabel hourlyWageJLabel = new JLabel();
        hourlyWageJLabel.setBounds(16, 16, 90, 21);
        hourlyWageJLabel.setText("Hourly wage:");
        contentPane.add(hourlyWageJLabel);

        // set up hourlyWageJTextField
        hourlyWageJTextField = new JTextField();
        hourlyWageJTextField.setBounds(120, 16, 90, 21);
        hourlyWageJTextField.setHorizontalAlignment(
                JTextField.RIGHT);
        contentPane.add(hourlyWageJTextField);

        // set up hoursWorkedJLabel
        // JLabel and JTextField for hours worked in a week
        JLabel hoursWorkedJLabel = new JLabel();
        hoursWorkedJLabel.setBounds(16, 56, 90, 21);
        hoursWorkedJLabel.setText("Hours worked:");
        contentPane.add(hoursWorkedJLabel);

        // set up hoursWorkedJTextField
        hoursWorkedJTextField = new JTextField();
        hoursWorkedJTextField.setBounds(120, 56, 90, 21);
        hoursWorkedJTextField.setHorizontalAlignment(
                JTextField.RIGHT);
        contentPane.add(hoursWorkedJTextField);

        // set up grossWagesJLabel
        // JLabel and JTextField for gross wages
        JLabel grossWagesJLabel = new JLabel();
        grossWagesJLabel.setBounds(16, 96, 90, 21);
        grossWagesJLabel.setText("Gross wages:");
        contentPane.add(grossWagesJLabel);

        // set up grossWagesJTextField
        grossWagesJTextField = new JTextField();
        grossWagesJTextField.setBounds(120, 96, 90, 21);
        grossWagesJTextField.setHorizontalAlignment(
                JTextField.RIGHT);
        grossWagesJTextField.setEditable(false);
        contentPane.add(grossWagesJTextField);

        // set up calculateJButton
        // JButton to initiate wage calculation
        JButton calculateJButton = new JButton();
        calculateJButton.setBounds(120, 136, 90, 24);
        calculateJButton.setText("Calculate");
        contentPane.add(calculateJButton);
        // anonymous inner class
        // event handler called when calculateJButton is pressed
        calculateJButton.addActionListener(

                this::calculateJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set properties of application's window
        setTitle("Wage Calculator"); // set title bar text
        setSize(240, 210);           // set window size
        setVisible(true);            // display window

    } // end method createUserInterface

    // method called when user presses calculateJButton
    private void calculateJButtonActionPerformed(ActionEvent event) {
        // get hourly wage
        double hourlyWage = Double.parseDouble(hourlyWageJTextField.getText());

        // get number of hours worked this week
        double hoursWorked = Double.parseDouble(hoursWorkedJTextField.getText());

        // constant for maximum hours employee can
        // work before being paid for overtime
        final double HOUR_LIMIT = 40.0;

        // gross wages for week; calculated in if...else statement
        double wages;

        // determine gross wages
        if (hoursWorked <= HOUR_LIMIT) {
            // regular wages for HOUR_LIMIT (40) hours or less
            wages = (hoursWorked * hourlyWage);
        } else // worked more than HOUR_LIMIT (40) hours
        {
            // wages for first HOUR_LIMIT (40) hours
            wages = HOUR_LIMIT * hourlyWage;

            // add time-and-a-half for overtime hours
            wages +=
                    (hoursWorked - HOUR_LIMIT) * (1.5 * hourlyWage);
        }

        // specify output format
        DecimalFormat dollars = new DecimalFormat("$0.00");

        // display gross wages
        grossWagesJTextField.setText(dollars.format(wages));

    } // end method calculateJButtonActionPerformed

} // end class WageCalculator

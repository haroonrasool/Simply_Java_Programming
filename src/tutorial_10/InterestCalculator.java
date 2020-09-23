package tutorial_10;

// Tutorial 10: InterestCalculator.java
// Calculate the total value of an investment.

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.text.DecimalFormat;

public class InterestCalculator extends JFrame {
    private JTextField principalJTextField;

    private JTextField interestRateJTextField;

    private JSpinner yearsJSpinner;

    private JTextArea yearlyBalanceJTextArea;

    // no-argument constructor
    public InterestCalculator() {
        createUserInterface();
    }

    // main method
    public static void main(String[] args) {
        InterestCalculator application = new InterestCalculator();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } // end method main

    // create and position GUI components; register event handlers
    private void createUserInterface() {
        // get content pane for attaching GUI components
        Container contentPane = getContentPane();

        // enable explicit positioning of GUI components
        contentPane.setLayout(null);

        // set up principalJLabel
        // JLabel and JTextField for principal invested
        JLabel principalJLabel = new JLabel();
        principalJLabel.setBounds(16, 16, 56, 24);
        principalJLabel.setText("Principal:");
        contentPane.add(principalJLabel);

        // set up principalJTextField
        principalJTextField = new JTextField();
        principalJTextField.setBounds(100, 16, 100, 24);
        principalJTextField.setHorizontalAlignment(
                JTextField.RIGHT);
        contentPane.add(principalJTextField);

        // set up interestRateJLabel
        // JLabel and JTextField for interest rate
        JLabel interestRateJLabel = new JLabel();
        interestRateJLabel.setBounds(16, 56, 80, 24);
        interestRateJLabel.setText("Interest rate:");
        contentPane.add(interestRateJLabel);

        // set up interestRateJTextField
        interestRateJTextField = new JTextField();
        interestRateJTextField.setBounds(100, 56, 100, 24);
        interestRateJTextField.setHorizontalAlignment(
                JTextField.RIGHT);
        contentPane.add(interestRateJTextField);

        // set up yearsJLabel
        // JLabel and JTextField for the number of years
        JLabel yearsJLabel = new JLabel();
        yearsJLabel.setBounds(16, 96, 48, 24);
        yearsJLabel.setText("Years:");
        contentPane.add(yearsJLabel);

        // set up yearsJSpinner
        yearsJSpinner = new JSpinner(
                new SpinnerNumberModel(1, 1, 10, 1));
        yearsJSpinner.setBounds(100, 96, 100, 24);
        contentPane.add(yearsJSpinner);

        // set up yearlyBalanceJLabel
        // JLabel and JTextArea display amount on deposit at
        // the end of each year up to number of years entered
        JLabel yearlyBalanceJLabel = new JLabel();
        yearlyBalanceJLabel.setBounds(16, 136, 150, 24);
        yearlyBalanceJLabel.setText("Yearly account balance:");
        contentPane.add(yearlyBalanceJLabel);

        // set up yearlyBalanceJTextArea
        yearlyBalanceJTextArea = new JTextArea();
        yearlyBalanceJTextArea.setEditable(false);

        // set up yearlyBalanceJScrollPane
        // JScrollPane adds scrollbars to JTextArea for lengthy output
        JScrollPane yearlyBalanceJScrollPane = new JScrollPane(
                yearlyBalanceJTextArea);
        yearlyBalanceJScrollPane.setBounds(16, 160, 300, 92);
        contentPane.add(yearlyBalanceJScrollPane);

        // set up calculateJButton
        // JButton calculates amount on deposit at the
        // end of each year up to number of years entered
        JButton calculateJButton = new JButton();
        calculateJButton.setBounds(216, 96, 100, 24);
        calculateJButton.setText("Calculate");
        contentPane.add(calculateJButton);
        // anonymous inner class
        // event handler called when calculateJButton is clicked
        calculateJButton.addActionListener(

                this::calculateJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener


        // set properties of application's window
        setTitle("Interest Calculator"); // set title bar text
        setSize(350, 300);               // set window size
        setVisible(true);                // display window

    } // end method createUserInterface

    // calculate and display amounts
    private void calculateJButtonActionPerformed(ActionEvent event) {
        // declare variables to store user input
        double principal = Double.parseDouble(
                principalJTextField.getText());
        double interestRate = Double.parseDouble(
                interestRateJTextField.getText());

        // read the years from JSpinner
        Integer years = (Integer) yearsJSpinner.getValue();

        // display error message
        // check if principal or rate are negative or rate is over ten.
        if (principal < 0 || interestRate < 0 || interestRate > 10) {
            JOptionPane.showMessageDialog(null, "The information input was not within the correct range of values.",
                    "Invalid Input", JOptionPane.ERROR_MESSAGE);
        } else {
            // add header to yearlyBalanceJTextArea
            yearlyBalanceJTextArea.setText("Year\tAmount on Deposit");
            // format to display the amount in currency format
            DecimalFormat dollars = new DecimalFormat("$0.00");

            // calculate the total value for each year
            for (int counter = 1; counter <= years; counter++) {
                double amount = principal * Math.pow((1 + interestRate / 100), counter);
                yearlyBalanceJTextArea.append("\n" + counter + "\t" + dollars.format(amount));
            } // end for

        } // end else

    } // end method calculateJButtonActionPerformed

} // end class InterestCalculator

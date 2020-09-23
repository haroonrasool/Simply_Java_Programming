package tutorial_10;

// Exercise 10.11: PresentValue.java
// Application that calculates how much money should be invested in
// order to achieve a certain financial goal.

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.text.DecimalFormat;

public class PresentValue extends JFrame {
    private JTextField futureValueJTextField;

    private JTextField interestRateJTextField;

    private JSpinner yearsJSpinner;

    private JTextArea amountNeededJTextArea;

    // no-argument constructor
    public PresentValue() {
        createUserInterface();
    }

    // main method
    public static void main(String[] args) {
        PresentValue application = new PresentValue();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } // end method main

    // create and position GUI components; register event handlers
    private void createUserInterface() {
        // get content pane for attaching GUI components
        Container contentPane = getContentPane();

        // enable explicit positioning of GUI components
        contentPane.setLayout(null);

        // set up futureValueJLabel
        // JLabel and JTextField for future value
        JLabel futureValueJLabel = new JLabel();
        futureValueJLabel.setBounds(20, 25, 90, 20);
        futureValueJLabel.setText("Future value:");
        contentPane.add(futureValueJLabel);

        // set up futureValueJTextField
        futureValueJTextField = new JTextField();
        futureValueJTextField.setBounds(130, 25, 100, 20);
        futureValueJTextField.setText("");
        futureValueJTextField.setHorizontalAlignment(JTextField.RIGHT);
        contentPane.add(futureValueJTextField);

        // set up interestRateJLabel
        // JLabel and JTextField for interest rate
        JLabel interestRateJLabel = new JLabel();
        interestRateJLabel.setBounds(20, 60, 90, 20);
        interestRateJLabel.setText("Interest rate:");
        contentPane.add(interestRateJLabel);

        // set up interestRateJTextField
        interestRateJTextField = new JTextField();
        interestRateJTextField.setBounds(130, 60, 100, 20);
        interestRateJTextField.setText("");
        interestRateJTextField.setHorizontalAlignment(JTextField.RIGHT);
        contentPane.add(interestRateJTextField);

        // set up yearsJLabel
        // JLabel and JSpinner for number of years
        JLabel yearsJLabel = new JLabel();
        yearsJLabel.setBounds(20, 95, 80, 20);
        yearsJLabel.setText("Years:");
        contentPane.add(yearsJLabel);

        // set up yearsJSpinner
        yearsJSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 30, 5));
        yearsJSpinner.setBounds(130, 95, 100, 20);
        contentPane.add(yearsJSpinner);

        // set up amountNeededJLabel
        // JLabel and JTextArea for initial amounts
        // needed to reach future value
        JLabel amountNeededJLabel = new JLabel();
        amountNeededJLabel.setBounds(20, 130, 150, 20);
        amountNeededJLabel.setText("Annual amount needed:");
        contentPane.add(amountNeededJLabel);

        // set up amountNeededJTextArea
        amountNeededJTextArea = new JTextArea();
        amountNeededJTextArea.setBounds(20, 155, 320, 115);
        amountNeededJTextArea.setEditable(false);
        contentPane.add(amountNeededJTextArea);

        // set up calculateJButton
        // JButton calculates initial amounts needed
        // to reach future value
        JButton calculateJButton = new JButton();
        calculateJButton.setBounds(250, 95, 90, 20);
        calculateJButton.setText("Calculate");
        contentPane.add(calculateJButton);
        // anonymous inner class
        // event handler called when calculateJButton is pressed
        calculateJButton.addActionListener(

                this::calculateJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set properties of application's window
        setTitle("Present Value Calculator"); // set title bar text
        setSize(370, 320);                    // set window size
        setVisible(true);                     // display window

    } // end method createUserInterface

    // calculate and display amounts
    private void calculateJButtonActionPerformed(ActionEvent event) {
        // declare variables to store user inputs
        int futureValue = Integer.parseInt(
                futureValueJTextField.getText());
        double interestRate = Double.parseDouble(
                interestRateJTextField.getText());

        // read the years from JSpinner
        int years = (Integer) yearsJSpinner.getValue();

        // add header to amountNeededJTextArea
        amountNeededJTextArea.setText("Year\tInitial Deposit");

        // format to display amount in currency format
        DecimalFormat dollars = new DecimalFormat("$0.00");

        // for loop calculates total amount
        for (int counter = 5; counter <= years; counter += 5) {
            double amount = futureValue / Math.pow((1 + interestRate / 100), counter);
            amountNeededJTextArea.append("\n" + counter + "\t" + dollars.format(amount));
        } // end for

    } // end method calculateJButtonActionPerformed

} // end class PresentValue

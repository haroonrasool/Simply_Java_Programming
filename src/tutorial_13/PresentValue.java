package tutorial_13;

// Exercise 13.11: PresentValue.java
// Application that calculates how much money should be invested in
// order to achieve a certain financial goal.

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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

        // set up futureJLabel
        // JLabel and JTextField for future value input
        JLabel futureValueJLabel = new JLabel();
        futureValueJLabel.setBounds(20, 25, 90, 20);
        futureValueJLabel.setText("Future value:");
        contentPane.add(futureValueJLabel);

        // set up futureValueJTextField
        futureValueJTextField = new JTextField();
        futureValueJTextField.setBounds(130, 25, 100, 20);
        futureValueJTextField.setHorizontalAlignment(
                JTextField.RIGHT);
        contentPane.add(futureValueJTextField);
        futureValueJTextField.addKeyListener(

                new KeyAdapter() // anonymous inner class
                {
                    // event handler called when
                    // futureValueJTextField is edited
                    public void keyPressed(KeyEvent event) {
                        futureValueJTextFieldKeyPressed();
                    }

                } // end anonymous inner class

        ); // end call to addKeyListener

        // set up interestRateJLabel
        // JLabel and JTextField for interest rate input
        JLabel interestRateJLabel = new JLabel();
        interestRateJLabel.setBounds(20, 60, 90, 20);
        interestRateJLabel.setText("Interest rate:");
        contentPane.add(interestRateJLabel);

        // set up interestRateJTextField
        interestRateJTextField = new JTextField();
        interestRateJTextField.setBounds(130, 60, 100, 20);
        interestRateJTextField.setHorizontalAlignment(
                JTextField.RIGHT);
        contentPane.add(interestRateJTextField);
        interestRateJTextField.addKeyListener(

                new KeyAdapter() // anonymous inner class
                {
                    // event handler called when
                    // interestRateJTextField is edited
                    public void keyPressed(KeyEvent event) {
                        interestRateJTextFieldKeyPressed();
                    }

                } // end anonymous inner class

        ); // end call to addKeyListener

        // set up yearsJLabel
        // JLabel and JSpinner for number of years input
        JLabel yearsJLabel = new JLabel();
        yearsJLabel.setBounds(20, 95, 80, 20);
        yearsJLabel.setText("Years:");
        contentPane.add(yearsJLabel);

        // set up yearsJSpinner
        yearsJSpinner = new JSpinner(
                new SpinnerNumberModel(0, 0, 30, 5));
        yearsJSpinner.setBounds(130, 95, 100, 20);
        contentPane.add(yearsJSpinner);
        // anonymous inner class
        // event handler called when yearsJSpinner is changed
        yearsJSpinner.addChangeListener(

                event -> {

                } // end anonymous inner class

        ); // end call to addChangeListener

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
        calculateJButton.setBounds(250, 25, 90, 20);
        calculateJButton.setText("Calculate");
        contentPane.add(calculateJButton);
        // anonymous inner class
        // event handler called when calculateJButton is pressed
        calculateJButton.addActionListener(

                this::calculateJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // JButton to clear values
        JButton clearJButton = new JButton();
        clearJButton.setBounds(250, 60, 90, 20);
        clearJButton.setText("Clear");
        contentPane.add(clearJButton);
        // anonymous inner class
        // event handler called when clearJButton is pressed
        clearJButton.addActionListener(

                event -> {

                } // end anonymous inner class

        ); // end call to addActionListener

        // set properties of application's window
        setTitle("Present Value Calculator"); // set title bar string
        setSize(370, 320);                    // set window size
        setVisible(true);                     // show window

    } // end method createUserInterface

    // calculate and display amounts
    private void calculateJButtonActionPerformed(ActionEvent event) {
        String futureValueText = futureValueJTextField.getText();
        int futureValue = Integer.parseInt(futureValueText);
        String rateText = interestRateJTextField.getText();
        double rate = Double.parseDouble(rateText);

        int years = (Integer) yearsJSpinner.getValue();

        amountNeededJTextArea.setText("Year\tInitial Deposit");

        DecimalFormat dollars = new DecimalFormat("$0.00");

        // for loop calculates total amount
        for (int counter = 5; counter <= years; counter += 5) {
            double amount = futureValue / Math.pow(
                    (1 + rate / 100), counter);
            amountNeededJTextArea.append(
                    "\n" + counter + "\t" + dollars.format(amount));
        } // end for loop

    } // end method calculateJButtonActionPerformed

    // clear the JTextArea
    private void futureValueJTextFieldKeyPressed() {
        amountNeededJTextArea.setText("");
    } // end method futureValueJTextFieldKeyPressed

    // clear the JTextArea
    private void interestRateJTextFieldKeyPressed() {
        amountNeededJTextArea.setText("");
    } // end method interestRateJTextFieldKeyPressed

} // end class PresentValue

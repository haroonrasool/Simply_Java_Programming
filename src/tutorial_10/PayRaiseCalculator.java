package tutorial_10;

// Exercise 10.17: PayRaise.java
// Application that calculates how much money should be invested in
// order to achieve a certain financial goal.

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.text.DecimalFormat;

public class PayRaiseCalculator extends JFrame {
    private JSpinner raiseJSpinner;

    private JSpinner yearsJSpinner;

    private JTextArea amountEarnedJTextArea;

    // no-argument constructor
    public PayRaiseCalculator() {
        createUserInterface();
    }

    // main method
    public static void main(String[] args) {
        PayRaiseCalculator application = new PayRaiseCalculator();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } // end method main

    // create and position GUI components; register event handlers
    private void createUserInterface() {
        // get content pane for attaching GUI components
        Container contentPane = getContentPane();

        // enable explicit positioning of GUI components
        contentPane.setLayout(null);

        // set up raiseJLabel
        // JLabel and JSpinner for yearly raise
        JLabel raiseJLabel = new JLabel();
        raiseJLabel.setBounds(20, 25, 150, 20);
        raiseJLabel.setText("Amount of raise (in %):");
        contentPane.add(raiseJLabel);

        // set up raiseJSpinner
        raiseJSpinner = new JSpinner(new SpinnerNumberModel(3, 3, 8, 1));
        raiseJSpinner.setBounds(170, 25, 70, 22);
        contentPane.add(raiseJSpinner);

        // set up yearsJLabel
        // JLabel and JSpinner for number of years
        JLabel yearsJLabel = new JLabel();
        yearsJLabel.setBounds(20, 60, 80, 20);
        yearsJLabel.setText("Years:");
        contentPane.add(yearsJLabel);

        // set up yearsJSpinner
        yearsJSpinner = new JSpinner(new SpinnerNumberModel(1, 1, 50, 1));
        yearsJSpinner.setBounds(170, 60, 70, 22);
        contentPane.add(yearsJSpinner);

        // set up amountEarnedJLabel
        // JLabel and JTextArea for amount earned
        // after a certain number of years
        JLabel amountEarnedJLabel = new JLabel();
        amountEarnedJLabel.setBounds(20, 95, 150, 20);
        amountEarnedJLabel.setText("Yearly amount earned:");
        contentPane.add(amountEarnedJLabel);

        // set up amountEarnedJTextArea
        amountEarnedJTextArea = new JTextArea();
        amountEarnedJTextArea.setEditable(false);

        // set up amountEarnedJScrollPane
        // JScrollPane adds scrollbars to amountEarnedJTextArea
        JScrollPane amountEarnedJScrollPane = new JScrollPane(amountEarnedJTextArea);
        amountEarnedJScrollPane.setBounds(20, 120, 330, 115);
        contentPane.add(amountEarnedJScrollPane);

        // set up calculateJButton
        // JButton calculates amount earned
        JButton calculateJButton = new JButton();
        calculateJButton.setBounds(260, 60, 90, 20);
        calculateJButton.setText("Calculate");
        contentPane.add(calculateJButton);
        // anonymous inner class
        // event handler called when calculateJButton is pressed
        calculateJButton.addActionListener(

                this::calculateJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set properties of application's window
        setTitle("Pay Raise Calculator"); // set title bar text
        setSize(385, 290);                // set window size
        setVisible(true);                 // display window

    } // end method createUserInterface

    // calculate and display amounts
    private void calculateJButtonActionPerformed(ActionEvent event) {
        // store weekly starting wage
        double wage = 500;

        // retrieve raise from raise
        int raise = (Integer) raiseJSpinner.getValue();

        // retrieve years from yearsJSpinner
        int years = (Integer) yearsJSpinner.getValue();

        // add header to amountEarnedJTextArea
        amountEarnedJTextArea.setText("Year\tAmount");

        // format to display the amount in currency format
        DecimalFormat dollars = new DecimalFormat("$0.00");

        // for-loop calculates total
        for (int counter = 1; counter <= years; counter++) {
            // multiply the wage set to 500 by the number of 52 weeks in a year and
            // store the result in a double type variable named amount.
            double amount = wage * 52;
            wage *= (1 + (double) raise / 100);
            // display the wage in amountEarnedJTextArea
            amountEarnedJTextArea.append("\n" + counter + "\t" + dollars.format(amount));
        } // end for

    } // end method calculateJButtonActionPerformed

} // end class PayRaise

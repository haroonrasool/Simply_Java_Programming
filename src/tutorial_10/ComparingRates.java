package tutorial_10;

// Exercise 10.12: ComparingRates.java
// Application that calculates the amount of money the user will have
// after one year of saving $100 a month, plus an initial deposit.

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.text.DecimalFormat;

public class ComparingRates extends JFrame {
    private JTextField principalJTextField;

    private JTextArea resultJTextArea;

    // no-argument constructor
    public ComparingRates() {
        createUserInterface();
    }

    // main method
    public static void main(String[] args) {
        ComparingRates application = new ComparingRates();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } // end method main

    // create and position GUI components; register event handlers
    private void createUserInterface() {
        // get content pane for attaching GUI components
        Container contentPane = getContentPane();

        // enable explicit positioning of GUI components
        contentPane.setLayout(null);

        // set up principalJLabel
        // JLabel and JTextField for principal amount
        JLabel principalJLabel = new JLabel();
        principalJLabel.setBounds(20, 20, 80, 20);
        principalJLabel.setText("Principal:");
        contentPane.add(principalJLabel);

        // set up principalJTextField
        principalJTextField = new JTextField();
        principalJTextField.setBounds(80, 20, 90, 20);
        principalJTextField.setText("");
        principalJTextField.setHorizontalAlignment(JTextField.RIGHT);
        contentPane.add(principalJTextField);

        // set up resultJLabel
        // JLabel and JTextArea for resulting amounts
        JLabel resultJLabel = new JLabel();
        resultJLabel.setBounds(20, 60, 100, 20);
        resultJLabel.setText("Result:");
        contentPane.add(resultJLabel);

        // set up resultJTextArea
        resultJTextArea = new JTextArea();
        resultJTextArea.setBounds(20, 85, 260, 120);
        resultJTextArea.setEditable(false);
        contentPane.add(resultJTextArea);

        // set up calculateJButton
        // JButton calculates resulting amounts for various interest rates
        JButton calculateJButton = new JButton();
        calculateJButton.setBounds(190, 20, 90, 20);
        calculateJButton.setText("Calculate");
        contentPane.add(calculateJButton);
        // anonymous inner class
        // event handler called when calculateJButton is pressed
        calculateJButton.addActionListener(

                this::calculateJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set properties of application's window
        setTitle("Comparing Rates"); // set title bar text
        setSize(310, 255);           // set window size
        setVisible(true);            // display window

    } // end method createUserInterface

    // calculate and display amounts
    private void calculateJButtonActionPerformed(ActionEvent event) {
        // retrieving principal amount from principalJTextField
        int principalAmount = Integer.parseInt(principalJTextField.getText());
        int numberOfYears = 10;

        // add header to resultJTextArea
        resultJTextArea.setText("Rate (%)\tAmount after 10 years");

        // format to display the amount in currency format
        DecimalFormat dollars = new DecimalFormat("$0.00");

        // for loop to calculate interest amount with a % rate counter
        for (int interestRate = 5; interestRate <= 10; interestRate++) {
            double investmentAmount = principalAmount * Math.pow((1 + (double) interestRate / 100), numberOfYears);
            resultJTextArea.append("\n" + interestRate + "\t" + dollars.format(investmentAmount));
        } // end for loop

    } // end method calculateJButtonActionPerformed

} // end class ComparingRates

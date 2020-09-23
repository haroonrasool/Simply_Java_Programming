package tutorial_13;

// Tutorial 13: InterestCalculator.java
// Calculate the total value of an investment.

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;

public class InterestCalculator extends JFrame {
    private JTextField principalJTextField;

    private JTextField rateJTextField;

    private JSpinner yearsJSpinner;

    private JTextArea accountJTextArea;

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
        // get content pane and set layout to null
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        // set up principalJLabel
        // JLabel and JTextField for principal
        JLabel principalJLabel = new JLabel();
        principalJLabel.setText("Principal:");
        principalJLabel.setBounds(16, 16, 56, 24);
        contentPane.add(principalJLabel);

        // set up principalJTextField
        principalJTextField = new JTextField();
        principalJTextField.setHorizontalAlignment(JTextField.RIGHT);
        principalJTextField.setBounds(96, 16, 104, 24);
        contentPane.add(principalJTextField);
        principalJTextField.addKeyListener(

                new KeyAdapter() // anonymous inner class
                {
                    // event handler called when principalJTextField
                    // is edited
                    public void keyPressed(KeyEvent event) {
                        principalJTextFieldKeyPressed();
                    }

                } // end anonymous inner class

        ); // end call to addKeyListener

        // set up rateJLabel
        // JLabel and JTextField for interest rate
        JLabel rateJLabel = new JLabel();
        rateJLabel.setText("Interest rate:");
        rateJLabel.setBounds(16, 56, 80, 24);
        contentPane.add(rateJLabel);

        // set up rateJTextField
        rateJTextField = new JTextField();
        rateJTextField.setHorizontalAlignment(JTextField.RIGHT);
        rateJTextField.setBounds(96, 56, 104, 24);
        contentPane.add(rateJTextField);
        rateJTextField.addKeyListener(

                new KeyAdapter() // anonymous inner class
                {
                    // event handler called when rateJTextField is edited
                    public void keyPressed(KeyEvent event) {
                        rateJTextFieldKeyPressed();
                    }

                } // end anonymous inner class

        ); // end call to addKeyListener

        // set up yearsJLabel
        // JLabel and JSpinner for years
        JLabel yearsJLabel = new JLabel();
        yearsJLabel.setText("Years:");
        yearsJLabel.setBounds(16, 96, 48, 24);
        contentPane.add(yearsJLabel);

        // set up yearsJSpinner
        yearsJSpinner = new JSpinner(
                new SpinnerNumberModel(1, 1, 10, 1));
        yearsJSpinner.setBounds(96, 96, 104, 24);
        contentPane.add(yearsJSpinner);
        // anonymous inner class
        // event handler called when value in
        // yearsJSpinner changes
        yearsJSpinner.addChangeListener(

                this::yearsJSpinnerStateChanged // end anonymous inner class

        ); // end call to addChangeListener

        // set up calculateJButton
        // JButton to calculate the yearly balances
        JButton calculateJButton = new JButton();
        calculateJButton.setText("Calculate");
        calculateJButton.setBounds(216, 16, 100, 24);
        contentPane.add(calculateJButton);
        // anonymous inner class
        // event handler called when calculateJButton is clicked
        calculateJButton.addActionListener(

                this::calculateJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set up clearJButton
        // JButton to clear the components
        JButton clearJButton = new JButton();
        clearJButton.setBounds(216, 56, 100, 24);
        clearJButton.setText("Clear");
        contentPane.add(clearJButton);
        // anonymous inner class
        // event handler called when clearJButton is clicked
        clearJButton.addActionListener(

                this::clearJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set up accountJLabel
        // JLabel, JTextArea and JScrollPane for yearly balances
        JLabel accountJLabel = new JLabel();
        accountJLabel.setText("Account balance:");
        accountJLabel.setBounds(16, 136, 150, 24);
        contentPane.add(accountJLabel);

        // set up accountJTextArea
        accountJTextArea = new JTextArea();
        accountJTextArea.setEditable(false);

        // set up accountJScrollPane
        JScrollPane accountJScrollPane = new JScrollPane(accountJTextArea);
        accountJScrollPane.setBounds(16, 160, 300, 88);
        contentPane.add(accountJScrollPane);

        // set properties of application's window
        setTitle("Interest Calculator"); // set title bar string
        setSize(340, 300);               // set window size
        setVisible(true);                // show window

    } // end method createUserInterface

    // clear the accountJTextArea
    private void rateJTextFieldKeyPressed() {
        accountJTextArea.setText("");

    } // end method rateJTextFieldKeyPressed

    // clear the accountJTextArea
    private void principalJTextFieldKeyPressed() {
        accountJTextArea.setText("");

    } // end method principalJTextFieldKeyPressed

    // calculate yearly values of investment
    private void calculateJButtonActionPerformed(ActionEvent event) {
        // declare variables to store user input
        double principal = Double.parseDouble(
                principalJTextField.getText());
        double rate = Double.parseDouble(rateJTextField.getText());
        int year = (Integer) yearsJSpinner.getValue();

        accountJTextArea.setText("Year\tAmount on Deposit");
        DecimalFormat dollars = new DecimalFormat("$0.00");

        // calculate the total value for each year
        for (int count = 1; count <= year; count++) {
            double amount = principal *
                    Math.pow((1 + rate / 100), count);
            accountJTextArea.append("\n" + count + "\t" +
                    dollars.format(amount));

        } // end for

    } // end method calculateJButtonActionPerformed

    // clear GUI components
    private void clearJButtonActionPerformed(ActionEvent event) {
        // clear the JTextFields
        principalJTextField.setText("");
        rateJTextField.setText("");

        // clear the JTextArea
        accountJTextArea.setText("");

        // reset the value of the JSpinner
        yearsJSpinner.setValue(1);

    } // end method clearJButtonActionPerformed

    // clear the JTextArea
    private void yearsJSpinnerStateChanged(ChangeEvent event) {
        accountJTextArea.setText("");

    } // end method yearJSpinnerStateChanged

} // end class InterestCalculator

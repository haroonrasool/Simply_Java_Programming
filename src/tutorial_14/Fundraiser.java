package tutorial_14;

// Tutorial 14: Fundraiser.java
// Calculates the amount of a donation after expenses and then 
// totals repeated donations.

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;

public class Fundraiser extends JFrame {
    private JTextField donationJTextField;

    private JTextField afterExpensesJTextField;

    private JTextField totalRaisedJTextField;

    // instance variable stores total raised for charity
    private double totalNetDonations = 0.00;

    // no-argument constructor
    public Fundraiser() {
        createUserInterface();
    }

    // main method
    public static void main(String[] args) {
        Fundraiser application = new Fundraiser();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } // end method main

    // create and position GUI components; register event handlers
    private void createUserInterface() {
        // get content pane for attaching GUI components
        Container contentPane = getContentPane();

        // enable explicit positioning of GUI components
        contentPane.setLayout(null);

        // set up donationJLabel
        // JLabel and JTextField to hold donation
        JLabel donationJLabel = new JLabel();
        donationJLabel.setBounds(16, 16, 80, 20);
        donationJLabel.setText("Donation:");
        contentPane.add(donationJLabel);

        // set up donationJTextField
        donationJTextField = new JTextField();
        donationJTextField.setBounds(122, 16, 120, 21);
        donationJTextField.setHorizontalAlignment(JTextField.RIGHT);
        contentPane.add(donationJTextField);
        donationJTextField.addKeyListener(

                new KeyAdapter() // anonymous inner class
                {
                    // event handler called when donationJTextField is edited
                    public void keyPressed(KeyEvent event) {
                        donationJTextFieldKeyPressed();
                    }

                } // end anonymous inner class

        ); // end call to addKeyListener

        // set up afterExpensesJLabel
        // JLabel and JTextField to display amount after expenses
        JLabel afterExpensesJLabel = new JLabel();
        afterExpensesJLabel.setBounds(16, 48, 98, 20);
        afterExpensesJLabel.setText("After expenses:");
        contentPane.add(afterExpensesJLabel);

        // set up afterExpensesJTextField
        afterExpensesJTextField = new JTextField();
        afterExpensesJTextField.setBounds(122, 48, 120, 20);
        afterExpensesJTextField.setText("$0.00");
        afterExpensesJTextField.setEditable(false);
        afterExpensesJTextField.setHorizontalAlignment(
                JTextField.RIGHT);
        contentPane.add(afterExpensesJTextField);

        // set up totalRaisedJLabel
        // JLabel and JTextField to display total amount raised
        JLabel totalRaisedJLabel = new JLabel();
        totalRaisedJLabel.setBounds(16, 80, 88, 20);
        totalRaisedJLabel.setText("Total raised:");
        contentPane.add(totalRaisedJLabel);

        // set up totalRaisedJTextField
        totalRaisedJTextField = new JTextField();
        totalRaisedJTextField.setBounds(122, 80, 120, 20);
        totalRaisedJTextField.setText("$0.00");
        totalRaisedJTextField.setEditable(false);
        totalRaisedJTextField.setHorizontalAlignment(
                JTextField.RIGHT);
        contentPane.add(totalRaisedJTextField);

        // set up donateJButton
        // JButton to allow user to enter donation
        JButton donateJButton = new JButton();
        donateJButton.setBounds(63, 112, 122, 24);
        donateJButton.setText("Donate");
        contentPane.add(donateJButton);
        // anonymous inner class
        // event handler called when donateJButton is clicked
        donateJButton.addActionListener(

                this::donateJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set properties of application's window
        setTitle("Fundraiser");  // set title bar string
        setSize(263, 174);       // set window size
        setVisible(true);        // display window

    } // end method createUserInterface

    // returns donation amount after operating expenses
    private double calculateDonation(int donatedAmount) {
        final double NET_PERCENTAGE = 0.83;

        // calculate amount of donation for charity
        return NET_PERCENTAGE * donatedAmount;

    } // end method calculateDonation

    // calculate the donation and fill the JTextFields
    private void donateJButtonActionPerformed(ActionEvent event) {
        // get donation amount
        int grossDonation =
                Integer.parseInt(donationJTextField.getText());

        // obtain donation amount after operating expenses deduction
        double netDonation = calculateDonation(grossDonation);

        // specify display format
        DecimalFormat dollars = new DecimalFormat("$0.00");

        // display amount of donation after expenses
        afterExpensesJTextField.setText(
                dollars.format(netDonation));

        // update total amount of donations received
        totalNetDonations += netDonation;

        // display total amount collected for charity
        totalRaisedJTextField.setText(
                dollars.format(totalNetDonations));

    } // end method donateJButtonActionPerformed

    // clear afterExpensesJTextField
    private void donationJTextFieldKeyPressed() {
        // clear afterExpensesJTextField
        afterExpensesJTextField.setText("");

    } // end method donationJTextFieldKeyPressed

} // end class Fundraiser

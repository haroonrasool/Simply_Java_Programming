package tutorial_13;

// Exercise 13.13: SalesCommissionCalculator.java
// Application calculates a salesperson's commission from the number 
// of units sold.

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;

public class SalesCommissionCalculator extends JFrame {
    private JTextField itemsSoldJTextField;

    private JTextField priceJTextField;

    private JTextField grossSalesJTextField;

    private JSpinner commissionJSpinner;

    private JTextField earningsJTextField;

    // no-argument constructor
    public SalesCommissionCalculator() {
        createUserInterface();
    }

    // main method
    public static void main(String[] args) {
        SalesCommissionCalculator application =
                new SalesCommissionCalculator();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } // end method main

    // create and position GUI components; register event handlers
    private void createUserInterface() {
        // get content pane for attaching GUI components
        Container contentPane = getContentPane();

        // enable explicit positioning of GUI components
        contentPane.setLayout(null);

        // set up itemsSoldJLabel
        // JLabel and JTextField for items sold
        JLabel itemsSoldJLabel = new JLabel();
        itemsSoldJLabel.setBounds(20, 20, 130, 20);
        itemsSoldJLabel.setText("Number of items sold:");
        contentPane.add(itemsSoldJLabel);

        // set up itemsSoldJTextField
        itemsSoldJTextField = new JTextField();
        itemsSoldJTextField.setBounds(170, 20, 90, 20);
        itemsSoldJTextField.setHorizontalAlignment(JTextField.RIGHT);
        contentPane.add(itemsSoldJTextField);

        // set up priceJLabel
        // JLabel and JTextField for price of items
        JLabel priceJLabel = new JLabel();
        priceJLabel.setBounds(20, 55, 130, 20);
        priceJLabel.setText("Price of items:");
        contentPane.add(priceJLabel);

        // set up priceJTextField
        priceJTextField = new JTextField();
        priceJTextField.setBounds(170, 55, 90, 20);
        priceJTextField.setHorizontalAlignment(JTextField.RIGHT);
        contentPane.add(priceJTextField);

        // set up grossSalesJLabel
        // JLabel and JTextField for gross sales
        JLabel grossSalesJLabel = new JLabel();
        grossSalesJLabel.setBounds(20, 90, 80, 20);
        grossSalesJLabel.setText("Gross sales:");
        contentPane.add(grossSalesJLabel);

        // set up grossSalesJTextField
        grossSalesJTextField = new JTextField();
        grossSalesJTextField.setBounds(170, 90, 90, 20);
        grossSalesJTextField.setEditable(false);
        grossSalesJTextField.setHorizontalAlignment(
                JTextField.RIGHT);
        contentPane.add(grossSalesJTextField);

        // set up commissionJLabel
        // JLabel and JSpinner for commission
        JLabel commissionJLabel = new JLabel();
        commissionJLabel.setBounds(20, 130, 110, 20);
        commissionJLabel.setText("Commission (%):");
        contentPane.add(commissionJLabel);

        // set up commissionJSpinner
        commissionJSpinner = new JSpinner(
                new SpinnerNumberModel(1, 1, 10, 1));
        commissionJSpinner.setBounds(170, 130, 90, 20);
        contentPane.add(commissionJSpinner);
        // anonymous inner class
        // event handler called when value in
        // commissionJSpinner changes
        commissionJSpinner.addChangeListener(

                event -> {

                } // end anonymous inner class

        ); // end call to addChangeListener

        // set up earningsJLabel
        // JLabel and JTextField for earnings
        JLabel earningsJLabel = new JLabel();
        earningsJLabel.setBounds(20, 170, 90, 20);
        earningsJLabel.setText("Earnings:");
        contentPane.add(earningsJLabel);

        // set up earningsJTextField
        earningsJTextField = new JTextField();
        earningsJTextField.setBounds(170, 170, 90, 20);
        earningsJTextField.setEditable(false);
        earningsJTextField.setHorizontalAlignment(JTextField.RIGHT);
        contentPane.add(earningsJTextField);

        // set up calculateJButton
        // JButton to calculate the earnings
        JButton calculateJButton = new JButton();
        calculateJButton.setBounds(170, 205, 90, 25);
        calculateJButton.setText("Calculate");
        contentPane.add(calculateJButton);
        // anonymous inner class
        // event handler called when calculateJButton is pressed
        calculateJButton.addActionListener(

                event -> calculateEarnings() // end anonymous inner class

        ); // end call to addActionListener

        // set properties of application's window
        setTitle("Sales Commission Calculator"); // set window title
        setSize(285, 285);                       // set window size
        setVisible(true);                        // show window

    } // end method createUserInterface

    // calculate and display sales and earnings
    private void calculateEarnings() {
        // get user input
        int items = Integer.parseInt(itemsSoldJTextField.getText());
        double price = Double.parseDouble(priceJTextField.getText());
        int commissionRate = (Integer) commissionJSpinner.getValue();

        // calculate total sales and earnings
        double sales = items * price;
        double earnings = (sales * commissionRate) / 100;

        // display the results
        DecimalFormat dollars = new DecimalFormat("$0.00");
        grossSalesJTextField.setText(dollars.format(sales));
        earningsJTextField.setText(dollars.format(earnings));

    } // end method calculateEarnings

} // end class SalesCommissionCalculator

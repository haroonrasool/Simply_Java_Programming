package tutorial_11;

// Exercise 11.11: SalesCommissionCalculator.java
// Calculates a salesperson's commission 
// from the number of units sold.

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.text.DecimalFormat;

public class SalesCommissionCalculator extends JFrame {
    private JTextField itemsSoldJTextField;

    private JTextField grossSalesJTextField;

    private JTextField commissionJTextField;

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
        // JLabel and JTextField to display number of items sold
        JLabel itemsSoldJLabel = new JLabel();
        itemsSoldJLabel.setBounds(20, 20, 130, 20);
        itemsSoldJLabel.setText("Number of items sold:");
        contentPane.add(itemsSoldJLabel);

        // set up itemsSoldJTextField
        itemsSoldJTextField = new JTextField();
        itemsSoldJTextField.setBounds(170, 20, 90, 20);
        itemsSoldJTextField.setHorizontalAlignment(JTextField.RIGHT);
        contentPane.add(itemsSoldJTextField);

        // set up calculateJButton
        // JButton to initiate calculations
        JButton calculateJButton = new JButton();
        calculateJButton.setBounds(170, 45, 90, 25);
        calculateJButton.setText("Calculate");
        contentPane.add(calculateJButton);
        // anonymous inner class
        // event handler called when calculateJButton is pressed
        calculateJButton.addActionListener(

                this::calculateJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set up salesJLabel
        // JLabel and JTextField to display gross sales
        JLabel salesJLabel = new JLabel();
        salesJLabel.setBounds(20, 95, 80, 20);
        salesJLabel.setText("Gross sales:");
        contentPane.add(salesJLabel);

        // set up salesJTextField
        grossSalesJTextField = new JTextField();
        grossSalesJTextField.setBounds(170, 95, 90, 20);
        grossSalesJTextField.setHorizontalAlignment(JTextField.RIGHT);
        grossSalesJTextField.setEditable(false);
        contentPane.add(grossSalesJTextField);

        // set up commissionJLabel
        // JLabel and JTextField to display commission percentage
        JLabel commissionJLabel = new JLabel();
        commissionJLabel.setBounds(20, 130, 110, 20);
        commissionJLabel.setText("Commission (%):");
        contentPane.add(commissionJLabel);

        // set up commissionJTextField
        commissionJTextField = new JTextField();
        commissionJTextField.setBounds(170, 130, 90, 20);
        commissionJTextField.setHorizontalAlignment(
                JTextField.RIGHT);
        commissionJTextField.setEditable(false);
        contentPane.add(commissionJTextField);

        // set up earningsJLabel
        // JLabel and JTextField to display total earnings
        JLabel earningsJLabel = new JLabel();
        earningsJLabel.setBounds(20, 165, 90, 20);
        earningsJLabel.setText("Earnings:");
        contentPane.add(earningsJLabel);

        // set up earningsJTextField
        earningsJTextField = new JTextField();
        earningsJTextField.setBounds(170, 165, 90, 20);
        earningsJTextField.setHorizontalAlignment(JTextField.RIGHT);
        earningsJTextField.setEditable(false);
        contentPane.add(earningsJTextField);

        // set properties of application's window
        setTitle("Sales Commission Calculator"); // set window title
        setSize(285, 230);                       // set window size
        setVisible(true);                        // display window

    } // end method createUserInterface

    // calculate the commission
    private void calculateJButtonActionPerformed(ActionEvent event) {
        // number of items sold
        int items = Integer.parseInt(itemsSoldJTextField.getText());

        // cost for each item
        final double DOLLARS_PER_UNIT = 100.0;

        // sales total
        double sales = items * DOLLARS_PER_UNIT;

        // commission percentage
        int commission;

        switch (items / 10) {
            case 0: // number of items sold 0-9
                commission = 1; // 1% commission
                break;

            case 1: // number of items sold 10-39
            case 2:
            case 3:
                commission = 2; // 2% commission
                break;
            case 4: // number of items sold 40-99
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                commission = 3; // 3% commission
                break;
            default:
                commission = 4; // 4% commission
        } // end switch statement

        // divide commission by 100 to convert commission
        // percentage to a decimal value for use in the calculation
        double commissionRate = (double) commission / 100.00;

        // calculate earnings
        double earnings = sales * commissionRate;

        // format to display the amount in currency format
        DecimalFormat dollars = new DecimalFormat("$0.00");

        // display results
        grossSalesJTextField.setText(dollars.format(sales));
        commissionJTextField.setText(String.valueOf(commission));
        earningsJTextField.setText(dollars.format(earnings));

    } // end method calculateJButtonActionPerformed

} // end class SalesCommissionCalculator

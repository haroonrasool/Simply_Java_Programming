package tutorial_7;

// Exercise 7.11: DentalPayment.java
// This application calculates the total cost of the bill for a 
// patient at a dental office.

import java.awt.*;
import java.awt.event.*;
import java.text.*;
import javax.swing.*;

public class DentalPaymentEnhanced extends JFrame {

    private JTextField patientNameJTextField;

    // JCheckBox and JLabel for cleaning
    private JCheckBox cleaningJCheckBox;

    // JCheckBox and JLabel for cavity filling
    private JCheckBox cavityFillingJCheckBox;

    // JCheckBox and JLabel for X-Ray
    private JCheckBox xRayJCheckBox;

    // JCheckBox and JLabel for fluoride
    private JCheckBox fluorideJCheckBox;

    // JCheckBox and JLabel for root canal
    private JCheckBox rootCanalJCheckBox;

    // JCheckBox, JLabel and JTextField for other services
    private JCheckBox otherJCheckBox;
    private JTextField otherPriceJTextField;

    private JTextField totalJTextField;

    // no-argument constructor
    public DentalPaymentEnhanced() {
        createUserInterface();
    }

    // main method
    public static void main(String[] args) {
        DentalPaymentEnhanced application = new DentalPaymentEnhanced();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } // end method main

    // create and position GUI components; register event handlers
    private void createUserInterface() {
        // get content pane for attaching GUI components
        Container contentPane = getContentPane();

        // enable explicit positioning of GUI components
        contentPane.setLayout(null);

        // set up dentalPaymentFormJLabel
        // JLabel that displays header on application window
        JLabel dentalPaymentFormJLabel = new JLabel();
        dentalPaymentFormJLabel.setBounds(19, 19, 235, 28);
        dentalPaymentFormJLabel.setText("Dental Payment Form");
        dentalPaymentFormJLabel.setFont(
                new Font("Default", Font.PLAIN, 22));
        dentalPaymentFormJLabel.setHorizontalAlignment(
                JLabel.CENTER);
        contentPane.add(dentalPaymentFormJLabel);

        // set up patientNameJLabel
        // JLabel and JTextField for patient name
        JLabel patientNameJLabel = new JLabel();
        patientNameJLabel.setBounds(19, 65, 91, 21);
        patientNameJLabel.setText("Patient name:");
        contentPane.add(patientNameJLabel);

        // set up patientNameJTextField
        patientNameJTextField = new JTextField();
        patientNameJTextField.setBounds(132, 65, 117, 21);
        contentPane.add(patientNameJTextField);

        // set up cleaningJCheckBox
        cleaningJCheckBox = new JCheckBox();
        cleaningJCheckBox.setBounds(16, 112, 140, 24);
        cleaningJCheckBox.setText("Cleaning");
        contentPane.add(cleaningJCheckBox);

        // set up cleaningPriceJLabel
        JLabel cleaningPriceJLabel = new JLabel();
        cleaningPriceJLabel.setBounds(211, 112, 38, 24);
        cleaningPriceJLabel.setText("$35");
        cleaningPriceJLabel.setHorizontalAlignment(JLabel.RIGHT);
        contentPane.add(cleaningPriceJLabel);

        // set up cavityFillingJCheckBox
        cavityFillingJCheckBox = new JCheckBox();
        cavityFillingJCheckBox.setBounds(16, 144, 140, 24);
        cavityFillingJCheckBox.setText("Cavity Filling");
        contentPane.add(cavityFillingJCheckBox);

        // set up cavityFillingPriceJLabel
        JLabel cavityFillingPriceJLabel = new JLabel();
        cavityFillingPriceJLabel.setBounds(211, 144, 38, 24);
        cavityFillingPriceJLabel.setText("$150");
        cavityFillingPriceJLabel.setHorizontalAlignment(
                JLabel.RIGHT);
        contentPane.add(cavityFillingPriceJLabel);

        // set up xRayJCheckBox
        xRayJCheckBox = new JCheckBox();
        xRayJCheckBox.setBounds(16, 178, 140, 24);
        xRayJCheckBox.setText("X-Ray");
        contentPane.add(xRayJCheckBox);

        // set up xRayPriceJLabel
        JLabel xRayPriceJLabel = new JLabel();
        xRayPriceJLabel.setBounds(211, 178, 38, 24);
        xRayPriceJLabel.setText("$85");
        xRayPriceJLabel.setHorizontalAlignment(JLabel.RIGHT);
        contentPane.add(xRayPriceJLabel);

        // set up fluorideJCheckBox
        fluorideJCheckBox = new JCheckBox();
        fluorideJCheckBox.setBounds(16, 210, 140, 24);
        fluorideJCheckBox.setText("Fluoride");
        contentPane.add(fluorideJCheckBox);

        // set up fluoridePriceJLabel
        JLabel fluoridePriceJLabel = new JLabel();
        fluoridePriceJLabel.setBounds(211, 210, 38, 24);
        fluoridePriceJLabel.setText("$50");
        fluoridePriceJLabel.setHorizontalAlignment(JLabel.RIGHT);
        contentPane.add(fluoridePriceJLabel);

        // set up rootCanalJCheckBox
        rootCanalJCheckBox = new JCheckBox();
        rootCanalJCheckBox.setBounds(16, 242, 140, 24);
        rootCanalJCheckBox.setText("Root Canal");
        contentPane.add(rootCanalJCheckBox);

        // set up rootCanalPriceJLabel
        JLabel rootCanalPriceJLabel = new JLabel();
        rootCanalPriceJLabel.setBounds(211, 242, 38, 24);
        rootCanalPriceJLabel.setText("$225");
        rootCanalPriceJLabel.setHorizontalAlignment(JLabel.RIGHT);
        contentPane.add(rootCanalPriceJLabel);

        // set up otherJCheckBox
        otherJCheckBox = new JCheckBox();
        otherJCheckBox.setBounds(16, 274, 140, 24);
        otherJCheckBox.setText("Other");
        contentPane.add(otherJCheckBox);

        // set up otherPriceJLabel
        JLabel otherPriceJLabel = new JLabel();
        otherPriceJLabel.setBounds(206, 274, 32, 24);
        otherPriceJLabel.setText("$"); // not showing up
        otherPriceJLabel.setHorizontalAlignment(JLabel.RIGHT);
        contentPane.add(otherPriceJLabel);

        // set up otherPriceJTextField
        otherPriceJTextField = new JTextField();
        otherPriceJTextField.setBounds(214, 274, 34, 24);
        otherPriceJTextField.setHorizontalAlignment(JTextField.RIGHT);
        contentPane.add(otherPriceJTextField);

        // set up totalJLabel
        // JLabel and JTextField for total fee
        JLabel totalJLabel = new JLabel();
        totalJLabel.setBounds(144, 314, 41, 21);
        totalJLabel.setText("Total:");
        contentPane.add(totalJLabel);

        // set up totalJTextField
        totalJTextField = new JTextField();
        totalJTextField.setBounds(192, 314, 56, 21);
        totalJTextField.setEditable(false);
        totalJTextField.setHorizontalAlignment(JTextField.CENTER);
        contentPane.add(totalJTextField);

        // set up calculateJButton
        // JButton to initiate calculation of fee
        JButton calculateJButton = new JButton();
        calculateJButton.setBounds(155, 346, 94, 24);
        calculateJButton.setText("Calculate");
        contentPane.add(calculateJButton);
        // anonymous inner class
        // event handler called when user clicks calculateJButton
        calculateJButton.addActionListener(

                this::calculateJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set properties of application's window
        setTitle("Dental Payment"); // set title bar string
        setSize(280, 420);          // set window size
        setVisible(true);           // display window

    } // end method createUserInterface

    // calculate cost of patient's visit
    private void calculateJButtonActionPerformed(ActionEvent event) {
        // get patient's name
        String patientName = patientNameJTextField.getText();

        // display error message if no name entered or no box selected
        if ((patientName.equals("")) ||
                (!cleaningJCheckBox.isSelected() &&
                        !cavityFillingJCheckBox.isSelected() &&
                        !xRayJCheckBox.isSelected() &&
                        !fluorideJCheckBox.isSelected() &&
                        !rootCanalJCheckBox.isSelected() &&
                        !otherJCheckBox.isSelected())) {
            // display error message
            JOptionPane.showMessageDialog(null,
                    "Please enter a name and check at least one item.",
                    "Missing information", JOptionPane.WARNING_MESSAGE);
        } else // otherwise, do calculations
        {
            double total = 0.0; // sum of all services provided

            // if patient had a cleaning
            if (cleaningJCheckBox.isSelected()) {
                total += 35; // add 35 to total
            }

            // if patient had cavity filled
            if (cavityFillingJCheckBox.isSelected()) {
                total += 150; // add 150 to total
            }

            // if patient had x-ray taken
            if (xRayJCheckBox.isSelected()) {
                total += 85; // add 85 to total
            }

            // if patient had a cleaning
            if (fluorideJCheckBox.isSelected()) {
                total += 50; // add 50 to total
            }

            // if patient had a cleaning
            if (rootCanalJCheckBox.isSelected()) {
                total += 225; // add 225 to total
            }

            // if patient had a cleaning
            if (otherJCheckBox.isSelected()) {
                total += Integer.parseInt(otherPriceJTextField.getText()); // add Other to total
            }

            // specify display format
            DecimalFormat dollars = new DecimalFormat("$0.00");

            // display total
            totalJTextField.setText(dollars.format(total));

        } // end else

    } // end method calculateJButtonActionPerformed

} // end class DentalPayment

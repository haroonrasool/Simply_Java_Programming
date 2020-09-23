package tutorial_7;

// Tutorial 7: DentalPayment.java
// This application calculates the total cost of the bill for a 
// patient at a dental office.

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;

public class DentalPayment extends JFrame {

    private JTextField patientNameJTextField;

    // JCheckBox and JLabel for cleaning
    private JCheckBox cleaningJCheckBox;

    // JCheckBox and JLabel for cavity filling
    private JCheckBox cavityFillingJCheckBox;

    // JCheckBox and JLabel for X-Ray
    private JCheckBox xRayJCheckBox;

    private JTextField totalJTextField;

    // no-argument constructor
    public DentalPayment() {
        createUserInterface();
    }

    // main method
    public static void main(String[] args) {
        DentalPayment application = new DentalPayment();
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
        cleaningJCheckBox.setBounds(16, 112, 122, 24);
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
        cavityFillingJCheckBox.setBounds(16, 159, 122, 24);
        cavityFillingJCheckBox.setText("Cavity Filling");
        contentPane.add(cavityFillingJCheckBox);

        // set up cavityFillingPriceJLabel
        JLabel cavityFillingPriceJLabel = new JLabel();
        cavityFillingPriceJLabel.setBounds(211, 159, 38, 24);
        cavityFillingPriceJLabel.setText("$150");
        cavityFillingPriceJLabel.setHorizontalAlignment(
                JLabel.RIGHT);
        contentPane.add(cavityFillingPriceJLabel);

        // set up xRayJCheckBox
        xRayJCheckBox = new JCheckBox();
        xRayJCheckBox.setBounds(16, 206, 122, 24);
        xRayJCheckBox.setText("X-Ray");
        contentPane.add(xRayJCheckBox);

        // set up xRayPriceJLabel
        JLabel xRayPriceJLabel = new JLabel();
        xRayPriceJLabel.setBounds(211, 206, 38, 24);
        xRayPriceJLabel.setText("$85");
        xRayPriceJLabel.setHorizontalAlignment(JLabel.RIGHT);
        contentPane.add(xRayPriceJLabel);

        // set up totalJLabel
        // JLabel and JTextField for total fee
        JLabel totalJLabel = new JLabel();
        totalJLabel.setBounds(144, 256, 41, 21);
        totalJLabel.setText("Total:");
        contentPane.add(totalJLabel);

        // set up totalJTextField
        totalJTextField = new JTextField();
        totalJTextField.setBounds(192, 256, 56, 21);
        totalJTextField.setEditable(false);
        totalJTextField.setHorizontalAlignment(JTextField.CENTER);
        contentPane.add(totalJTextField);

        // set up calculateJButton
        // JButton to initiate calculation of fee
        JButton calculateJButton = new JButton();
        calculateJButton.setBounds(155, 296, 94, 24);
        calculateJButton.setText("Calculate");
        contentPane.add(calculateJButton);
        // anonymous inner class
        // event handler called when user clicks calculateJButton
        calculateJButton.addActionListener(

                event -> calculateJButtonActionPerformed() // end anonymous inner class

        ); // end call to addActionListener

        // set properties of application's window
        setTitle("Dental Payment"); // set title bar string
        setSize(280, 370);          // set window size
        setVisible(true);           // display window

    } // end method createUserInterface

    // calculate cost of patient's visit
    private void calculateJButtonActionPerformed() {
        // get patient's name
        String patientName = patientNameJTextField.getText();

        // display error message if no name entered or
        // no JCheckBox is selected
        if ((patientName.equals("")) ||
                (!cleaningJCheckBox.isSelected() &&
                        !cavityFillingJCheckBox.isSelected() &&
                        !xRayJCheckBox.isSelected())) {
            // display error message
            JOptionPane.showMessageDialog(null,
                    "Please enter a name and check at least one item.",
                    "Missing Information", JOptionPane.ERROR_MESSAGE);
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

            // specify display format
            DecimalFormat dollars = new DecimalFormat("$0.00");

            // display total
            totalJTextField.setText(dollars.format(total));

        } // end else

    } // end method calculateJButtonActionPerformed

} // end class DentalPayment

package tutorial_24;

// Exercise 12.13: MilesPerGallon.java
// Calculates miles per gallon based on user input.

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.text.DecimalFormat;

public class MilesPerGallon extends JFrame {
    private JTextField milesDrivenJTextField;
    private JTextField gallonsUsedJTextField;
    private JTextField milesPerGallonJTextField;

    // no-argument constructor
    public MilesPerGallon() {
        createUserInterface();
    }

    // main method
    public static void main(String[] args) {
        MilesPerGallon application = new MilesPerGallon();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } // end method main

    // create and position GUI components; register event handlers
    private void createUserInterface() {
        // get content pane for attaching GUI components
        Container contentPane = getContentPane();

        // enable explicit positioning of GUI components
        contentPane.setLayout(null);

        // set up milesDrivenJLabel
        // JLabel and JTextField to enter the miles driven
        JLabel milesDrivenJLabel = new JLabel();
        milesDrivenJLabel.setBounds(16, 16, 81, 21);
        milesDrivenJLabel.setText("Miles driven:");
        contentPane.add(milesDrivenJLabel);

        // set up milesDrivenJTextField
        milesDrivenJTextField = new JTextField();
        milesDrivenJTextField.setBounds(128, 16, 64, 21);
        milesDrivenJTextField.setHorizontalAlignment(
                JTextField.RIGHT);
        contentPane.add(milesDrivenJTextField);

        // set up gallonsUsedJLabel
        // JLabel and JTextField to enter the number of gallons used
        JLabel gallonsUsedJLabel = new JLabel();
        gallonsUsedJLabel.setBounds(16, 56, 81, 21);
        gallonsUsedJLabel.setText("Gallons used:");
        contentPane.add(gallonsUsedJLabel);

        // set up gallonsUsedJTextField
        gallonsUsedJTextField = new JTextField();
        gallonsUsedJTextField.setBounds(128, 56, 64, 21);
        gallonsUsedJTextField.setHorizontalAlignment(
                JTextField.RIGHT);
        contentPane.add(gallonsUsedJTextField);

        // set up MilesPerGallonJLabel
        // JLabel and JTextField to display the miles per gallon
        JLabel milesPerGallonJLabel = new JLabel();
        milesPerGallonJLabel.setBounds(16, 104, 96, 21);
        milesPerGallonJLabel.setText("Miles per gallon:");
        contentPane.add(milesPerGallonJLabel);

        // set up milesPerGallonJTextField
        milesPerGallonJTextField = new JTextField();
        milesPerGallonJTextField.setBounds(128, 104, 64, 21);
        milesPerGallonJTextField.setHorizontalAlignment(
                JTextField.CENTER);
        milesPerGallonJTextField.setEditable(false);
        contentPane.add(milesPerGallonJTextField);

        // set up calculateMPGJButton
        // JButton for calculating the miles per gallon
        JButton calculateMPGJButton = new JButton();
        calculateMPGJButton.setBounds(62, 144, 130, 23);
        calculateMPGJButton.setText("Calculate MPG");
        contentPane.add(calculateMPGJButton);
        // anonymous inner class
        // event handler called when calculateMPGJButton is pressed
        calculateMPGJButton.addActionListener(

                this::calculateMPGJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set properties of application's window
        setTitle("Miles Per Gallon"); // set title-bar String
        setSize(224, 208);            // set window size
        setVisible(true);             // display window

    } // end method createUserInterface

    // get user input, calculate miles per gallon, and display results
    private void calculateMPGJButtonActionPerformed(
            ActionEvent event) {
        // DecimalFormat to display numbers
        DecimalFormat dollars = new DecimalFormat("0.00");

        // try block to retrieve user input
        try {
            // retrieving input from JTextFields
            double milesDriven = Double.parseDouble(
                    milesDrivenJTextField.getText());
            double gallonsUsed = Double.parseDouble(
                    gallonsUsedJTextField.getText());

            // display miles per gallon
            milesPerGallonJTextField.setText(dollars.format(
                    milesPerGallon(milesDriven, gallonsUsed)));
        } catch (NumberFormatException exception) {
            JOptionPane.showMessageDialog(this, "Please enter " +
                            "decimal numbers for the miles driven and gallons",
                    "Number Format Error", JOptionPane.ERROR_MESSAGE);
        }

    } // end method calculateMPGJButtonActionPerformed

    // calculate and return miles per gallon
    private double milesPerGallon(double milesDriven,
                                  double gallonsUsed) {
        return milesDriven / gallonsUsed;

    } // end method milesPerGallon

} // end class MilesPerGallon

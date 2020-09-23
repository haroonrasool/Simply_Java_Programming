package tutorial_12;

// Exercise 12.16: GasPump.java
// Calculates gas prices based on the number of gallons and grade.

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.text.DecimalFormat;

public class GasPump extends JFrame {
    private JTextField numberGallonsJTextField;

    private JTextField totalJTextField;

    private double gallons = 0.0; // number of gallons

    // no-argument constructor
    public GasPump() {
        createUserInterface();
    }

    // main method
    public static void main(String[] args) {
        GasPump application = new GasPump();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } // end method main

    // create and position GUI components; register event handlers
    private void createUserInterface() {
        // get content pane for attaching GUI components
        Container contentPane = getContentPane();

        // enable explicit positioning of GUI components
        contentPane.setLayout(null);

        // set up numberGallonsJLabel
        // JLabel and JTextField for number of gallons
        JLabel numberGallonsJLabel = new JLabel();
        numberGallonsJLabel.setBounds(16, 16, 114, 21);
        numberGallonsJLabel.setText("Number of gallons:");
        contentPane.add(numberGallonsJLabel);

        // set up numberGallonsJTextField
        numberGallonsJTextField = new JTextField();
        numberGallonsJTextField.setBounds(138, 16, 86, 21);
        numberGallonsJTextField.setHorizontalAlignment(
                JTextField.RIGHT);
        contentPane.add(numberGallonsJTextField);

        // set up totalJLabel
        // JLabel and JTextField for total price
        JLabel totalJLabel = new JLabel();
        totalJLabel.setBounds(240, 16, 40, 21);
        totalJLabel.setText("Total:");
        contentPane.add(totalJLabel);

        // set up totalJTextField
        totalJTextField = new JTextField();
        totalJTextField.setBounds(291, 16, 61, 21);
        totalJTextField.setHorizontalAlignment(
                JTextField.CENTER);
        totalJTextField.setEditable(false);
        contentPane.add(totalJTextField);

        // set up regularJLabel
        // JLabel and JButton for regular grade gas
        JLabel regularJLabel = new JLabel();
        regularJLabel.setBounds(16, 56, 85, 21);
        regularJLabel.setText("Regular: $1.61");
        contentPane.add(regularJLabel);

        // set up regularJButton
        JButton regularJButton = new JButton();
        regularJButton.setBounds(16, 77, 85, 85);
        regularJButton.setText("Regular");
        contentPane.add(regularJButton);
        // anonymous inner class
        // event handler called when regularJButton is pressed
        regularJButton.addActionListener(

                this::regularJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set up specialJLabel
        // JLabel and JButton for special grade gas
        JLabel specialJLabel = new JLabel();
        specialJLabel.setBounds(144, 56, 85, 21);
        specialJLabel.setText("Special: $1.67");
        contentPane.add(specialJLabel);

        // set up specialJButton
        JButton specialJButton = new JButton();
        specialJButton.setBounds(144, 77, 85, 85);
        specialJButton.setText("Special");
        contentPane.add(specialJButton);
        // anonymous inner class
        // event handler called when specialJButton is pressed
        specialJButton.addActionListener(

                this::specialJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set up superJLabel
        // JLabel and JButton for super+ grade gas
        JLabel superJLabel = new JLabel();
        superJLabel.setBounds(272, 56, 85, 21);
        superJLabel.setText("Super+: $1.77");
        contentPane.add(superJLabel);

        // set up superJButton
        JButton superJButton = new JButton();
        superJButton.setBounds(272, 77, 85, 85);
        superJButton.setText("Super+");
        contentPane.add(superJButton);
        // anonymous inner class
        // event handler called when superJButton is clicked
        superJButton.addActionListener(

                this::superJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set properties of application's window
        setTitle("Gas Pump"); // set title bar string
        setSize(380, 205);    // set window size
        setVisible(true);     // display window

    } // end method createUserInterface

    // calculate total for regular gas grade
    private void regularJButtonActionPerformed(ActionEvent event) {
        gallons = Double.parseDouble(
                numberGallonsJTextField.getText());

        // call method to determine total
        total(1, gallons);

    } // end method regularJButtonActionPerformed

    // calculates total for special gas grade
    private void specialJButtonActionPerformed(ActionEvent event) {
        gallons = Double.parseDouble(
                numberGallonsJTextField.getText());

        // call method to determine total
        total(2, gallons);

    } // end method specialJButtonActionPerformed

    // calculates total for super gas grade
    private void superJButtonActionPerformed(ActionEvent event) {
        gallons = Double.parseDouble(
                numberGallonsJTextField.getText());

        // call method to determine total
        total(3, gallons);

    } // end method superJButtonActionPerformed

    // calculate and display total price based on gas grade
    private void total(int grade, double gallons) {
        DecimalFormat dollars = new DecimalFormat("$0.00");

        // determine grade selected and output total
        switch (grade) {
            case 1:
                totalJTextField.setText(
                        dollars.format(1.61 * gallons));
                break;
            case 2:
                totalJTextField.setText(
                        dollars.format(1.67 * gallons));
                break;
            case 3:
                totalJTextField.setText(
                        dollars.format(1.77 * gallons));
                break;

        } // end switch

    } // end method total

} // end class GasPump

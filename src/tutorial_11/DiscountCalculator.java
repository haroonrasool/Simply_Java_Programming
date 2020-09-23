package tutorial_11;

// Exercise 11.15: DiscountCalculator.java
// Calculates a the discount the user will receive
// based on how much the user spends.

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class DiscountCalculator extends JFrame {
    private JTextField spentJTextField;

    // no-argument constructor
    public DiscountCalculator() {
        createUserInterface();
    }

    // main method
    public static void main(String[] args) {
        DiscountCalculator application = new DiscountCalculator();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } // end method main

    // create and position GUI components; register event handlers
    private void createUserInterface() {
        // get content pane for attaching GUI components
        Container contentPane = getContentPane();

        // enable explicit positioning of GUI components
        contentPane.setLayout(null);

        // set up spentJLabel
        // JLabel and JTextField allow user to enter amount spent
        JLabel spentJLabel = new JLabel();
        spentJLabel.setBounds(10, 10, 120, 25);
        spentJLabel.setText("Enter amount spent:");
        contentPane.add(spentJLabel);

        // set up spentJTextField
        spentJTextField = new JTextField();
        spentJTextField.setBounds(140, 10, 90, 25);
        spentJTextField.setHorizontalAlignment(JTextField.CENTER);
        contentPane.add(spentJTextField);

        // set up discountJButton
        // JButton that initiates discount calculation
        JButton discountJButton = new JButton();
        discountJButton.setBounds(140, 45, 90, 25);
        discountJButton.setText("Calculate");
        contentPane.add(discountJButton);
        // anonymous inner class
        // event handler called when discountJButton is pressed
        discountJButton.addActionListener(

                this::discountJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set properties of application's window
        setTitle("Discount Calculator"); // set window title
        setSize(245, 120);  // set window size
        setVisible(true);               // display window

    } // end method createUserInterface

    // display a message stating the users discount
    private void discountJButtonActionPerformed(ActionEvent event) {
        int discountRate; // variable to store discount rate
        int amount = Integer.parseInt( spentJTextField.getText() );

        // determine discount percentage
        switch ( amount / 50 )
        {
            case 0: // values in the range $0-49
                discountRate = 0;
                break;

            case 1: // values in the range $50-99
                discountRate = 5;
                break;

            case 2: // values in the range $100-149
                discountRate = 10;
                break;

            default: // values $150 or greater
                discountRate = 15;

        } // end switch statement

        // display discount percentage
        JOptionPane.showMessageDialog(null,
                "Your Discount is: " + discountRate + " %",
                "Discount", JOptionPane.INFORMATION_MESSAGE);

    } // end method discountJButtonActionPerformed

} // end class DiscountCalculator

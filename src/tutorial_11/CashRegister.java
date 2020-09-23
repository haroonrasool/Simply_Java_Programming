package tutorial_11;

// Exercise: 11.16 CashRegister.java
// Application simulates the behavior of a cash register, allowing
// the user to input prices, keep a running subtotal, and
// calculate the sales tax and total.

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.*;

public class CashRegister extends JFrame {
    double subtotal = 0.0; // stores subtotal of items purchased

    private JTextField amountJTextField;

    private JTextField subtotalJTextField;

    private JTextField taxJTextField;

    private JTextField totalJTextField;

    // DecimalFormat to format dollar amounts
    private final DecimalFormat dollars = new DecimalFormat("$0.00");

    // no-argument constructor
    public CashRegister() {
        createUserInterface();
    }

    // main method
    public static void main(String[] args) {
        CashRegister application = new CashRegister();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } // end method main

    // create and position GUI components; register event handlers
    private void createUserInterface() {
        // get content pane for attaching GUI components
        Container contentPane = getContentPane();

        // enable explicit positioning of GUI components
        contentPane.setLayout(null);

        // set up amountJLabel
        // JLabel and JTextField to enter amount
        JLabel amountJLabel = new JLabel();
        amountJLabel.setBounds(20, 20, 15, 20);
        amountJLabel.setText("$");
        contentPane.add(amountJLabel);

        // set up amountJTextField
        amountJTextField = new JTextField();
        amountJTextField.setBounds(40, 20, 260, 20);
        contentPane.add(amountJTextField);

        // set up oneJButton
        // JButtons to enter numbers in amountJTextField
        JButton oneJButton = new JButton();
        oneJButton.setBounds(55, 70, 45, 20);
        oneJButton.setText("1");
        contentPane.add(oneJButton);
        // anonymous inner class
        // event handler called when oneJButton is pressed
        oneJButton.addActionListener(

                event -> oneJButtonActionPerformed() // end anonymous inner class

        ); // end call to addActionListener

        // set up twoJButton
        JButton twoJButton = new JButton();
        twoJButton.setBounds(100, 70, 45, 20);
        twoJButton.setText("2");
        contentPane.add(twoJButton);
        // anonymous inner class
        // event handler called when twoJButton is pressed
        twoJButton.addActionListener(

                event -> twoJButtonActionPerformed() // end anonymous inner class

        ); // end call to addActionListener

        // set up threeJButton
        JButton threeJButton = new JButton();
        threeJButton.setBounds(145, 70, 45, 20);
        threeJButton.setText("3");
        contentPane.add(threeJButton);
        // anonymous inner class
        // event handler called when threeJButton is pressed
        threeJButton.addActionListener(

                event -> threeJButtonActionPerformed() // end anonymous inner class

        ); // end call to addActionListener

        // set up fourJButton
        JButton fourJButton = new JButton();
        fourJButton.setBounds(55, 90, 45, 20);
        fourJButton.setText("4");
        contentPane.add(fourJButton);
        // anonymous inner class
        // event handler called when fourJButton is pressed
        fourJButton.addActionListener(

                event -> fourJButtonActionPerformed() // end anonymous inner class

        ); // end call to addActionListener

        // set up fiveJButton
        JButton fiveJButton = new JButton();
        fiveJButton.setBounds(100, 90, 45, 20);
        fiveJButton.setText("5");
        contentPane.add(fiveJButton);
        // anonymous inner class
        // event handler called when fiveJButton is pressed
        fiveJButton.addActionListener(

                event -> fiveJButtonActionPerformed() // end anonymous inner class

        ); // end call to addActionListener

        // set up sixJButton
        JButton sixJButton = new JButton();
        sixJButton.setBounds(145, 90, 45, 20);
        sixJButton.setText("6");
        contentPane.add(sixJButton);
        // anonymous inner class
        // event handler called when sixJButton is pressed
        sixJButton.addActionListener(

                this::sixJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set up sevenJButton
        JButton sevenJButton = new JButton();
        sevenJButton.setBounds(55, 110, 45, 20);
        sevenJButton.setText("7");
        contentPane.add(sevenJButton);
        // anonymous inner class
        // event handler called when sevenJButton is pressed
        sevenJButton.addActionListener(

                this::sevenJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set up eightJButton
        JButton eightJButton = new JButton();
        eightJButton.setBounds(100, 110, 45, 20);
        eightJButton.setText("8");
        contentPane.add(eightJButton);
        // anonymous inner class
        // event handler called when eightJButton is pressed
        eightJButton.addActionListener(

                this::eightJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set up nineJButton
        JButton nineJButton = new JButton();
        nineJButton.setBounds(145, 110, 45, 20);
        nineJButton.setText("9");
        contentPane.add(nineJButton);
        // anonymous inner class
        // event handler called when nineJButton is pressed
        nineJButton.addActionListener(

                event -> nineJButtonActionPerformed() // end anonymous inner class

        ); // end call to addActionListener

        // set up zeroJButton
        JButton zeroJButton = new JButton();
        zeroJButton.setBounds(100, 130, 45, 20);
        zeroJButton.setText("0");
        contentPane.add(zeroJButton);
        // anonymous inner class
        // event handler called when zeroJButton is pressed
        zeroJButton.addActionListener(

                this::zeroJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set up pointJButton
        JButton pointJButton = new JButton();
        pointJButton.setBounds(145, 130, 45, 20);
        pointJButton.setText(".");
        contentPane.add(pointJButton);
        // anonymous inner class
        // event handler called when pointJButton is pressed
        pointJButton.addActionListener(

                this::pointJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set up enterJButton
        // JButton to add value in amountJTextField to subtotal
        JButton enterJButton = new JButton();
        enterJButton.setBounds(205, 70, 70, 20);
        enterJButton.setText("Enter");
        contentPane.add(enterJButton);
        // anonymous inner class
        // event handler called when enterJButton is pressed
        enterJButton.addActionListener(

                this::enterJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set up totalJButton
        // JButton to determine tax and calculate final total
        JButton totalJButton = new JButton();
        totalJButton.setBounds(205, 90, 70, 20);
        totalJButton.setText("Total");
        contentPane.add(totalJButton);
        // anonymous inner class
        // event handler called when totalJButton is pressed
        totalJButton.addActionListener(

                this::totalJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set up deleteJButton
        // JButton to delete value displayed in amountJTextField
        JButton deleteJButton = new JButton();
        deleteJButton.setBounds(205, 110, 70, 20);
        deleteJButton.setText("Delete");
        contentPane.add(deleteJButton);
        // anonymous inner class
        // event handler called when deleteJButton is pressed
        deleteJButton.addActionListener(

                this::deleteJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set up clearJButton
        // JButton to clear results
        JButton clearJButton = new JButton();
        clearJButton.setBounds(205, 130, 70, 20);
        clearJButton.setText("Clear");
        contentPane.add(clearJButton);
        // anonymous inner class
        // event handler called when clearJButton is pressed
        clearJButton.addActionListener(

                this::clearJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set up subtotalJLabel;
        // JLabel and JTextField to display subtotal
        JLabel subtotalJLabel = new JLabel();
        subtotalJLabel.setBounds(20, 180, 90, 20);
        subtotalJLabel.setText("Subtotal:");
        contentPane.add(subtotalJLabel);

        // set up subtotalJTextField
        subtotalJTextField = new JTextField();
        subtotalJTextField.setBounds(160, 180, 140, 20);
        subtotalJTextField.setHorizontalAlignment(JTextField.RIGHT);
        subtotalJTextField.setEditable(false);
        subtotalJTextField.setText("$0.00");
        contentPane.add(subtotalJTextField);

        // set up taxJLabel
        // JLabel and JTextField to display tax
        JLabel taxJLabel = new JLabel();
        taxJLabel.setBounds(20, 220, 60, 20);
        taxJLabel.setText("Tax:");
        contentPane.add(taxJLabel);

        // set up taxJTextField
        taxJTextField = new JTextField();
        taxJTextField.setBounds(160, 220, 140, 20);
        taxJTextField.setHorizontalAlignment(JTextField.RIGHT);
        taxJTextField.setEditable(false);
        taxJTextField.setText("$0.00");
        contentPane.add(taxJTextField);

        // set up totalJLabel
        // JLabel and JTextField to display final total
        JLabel totalJLabel = new JLabel();
        totalJLabel.setBounds(20, 260, 70, 20);
        totalJLabel.setText("Total:");
        contentPane.add(totalJLabel);

        // set up totalJTextField
        totalJTextField = new JTextField();
        totalJTextField.setBounds(160, 260, 140, 20);
        totalJTextField.setHorizontalAlignment(JTextField.RIGHT);
        totalJTextField.setEditable(false);
        totalJTextField.setText("$0.00");
        contentPane.add(totalJTextField);

        // set properties of application's window
        setTitle("Cash Register"); // set window title
        setSize(345, 330);         // set window size
        setVisible(true);          // display window

    } // end method createUserInterface

    // append "0" to the amount in amountJTextField
    private void zeroJButtonActionPerformed(ActionEvent event) {
        amountJTextField.setText(amountJTextField.getText() + "0");
    } // end method zeroJButtonActionPerformed

    // append "1" to the amount in amountJTextField
    private void oneJButtonActionPerformed() {
        amountJTextField.setText(amountJTextField.getText() + "1");
    } // end method oneJButtonActionPerformed

    // append "2" to the amount in amountJTextField
    private void twoJButtonActionPerformed() {
        amountJTextField.setText(amountJTextField.getText() + "2");
    } // end method twoJButtonActionPerformed

    // append "3" to the amount in amountJTextField
    private void threeJButtonActionPerformed() {
        amountJTextField.setText(amountJTextField.getText() + "3");
    } // end method threeJButtonActionPerformed

    // append "4" to the amount in amountJTextField
    private void fourJButtonActionPerformed() {
        amountJTextField.setText(amountJTextField.getText() + "4");
    } // end method fourJButtonActionPerformed

    // append "5" to the amount in amountJTextField
    private void fiveJButtonActionPerformed() {
        amountJTextField.setText(amountJTextField.getText() + "5");
    } // end method fiveJButtonActionPerformed

    // append "6" to the amount in amountJTextField
    private void sixJButtonActionPerformed(ActionEvent event) {
        amountJTextField.setText(amountJTextField.getText() + "6");
    } // end method sixJButtonActionPerformed

    // append "7" to the amount in amountJTextField
    private void sevenJButtonActionPerformed(ActionEvent event) {
        amountJTextField.setText(amountJTextField.getText() + "7");
    } // end method sevenJButtonActionPerformed

    // append "8" to the amount in amountJTextField
    private void eightJButtonActionPerformed(ActionEvent event) {
        amountJTextField.setText(amountJTextField.getText() + "8");
    } // end method eightJButtonActionPerformed

    // append "9" to the amount in amountJTextField
    private void nineJButtonActionPerformed() {
        amountJTextField.setText(amountJTextField.getText() + "9");
    } // end method nineJButtonActionPerformed

    // append "." to the amount in amountJTextField
    private void pointJButtonActionPerformed(ActionEvent event) {
        amountJTextField.setText(amountJTextField.getText() + ".");
    } // end method pointJButtonActionPerformed

    // calculate and display subtotal
    private void enterJButtonActionPerformed(ActionEvent event) {
        // add amount in amountJTextField to subtotal
        subtotal += Double.parseDouble(amountJTextField.getText());

        // display subtotal, then clear amountJTextField
        subtotalJTextField.setText(dollars.format(subtotal));
        amountJTextField.setText("");

    } // end method enterJButtonActionPerformed

    // calculate and display total after taxes
    private void totalJButtonActionPerformed(ActionEvent event) {
        double taxRate; // store tax rate to apply to subtotal

        // determine tax rate based on subtotal;
        switch ((int) subtotal / 100) {
            case 0: // amounts in the range $0-99
                taxRate = .05;  // 5% tax
                break;

            case 1: // amounts in the range $100-499
            case 2:
            case 3:
            case 4:
                taxRate = .075; // 7.5% tax
                break;

            default: // amounts $500 and above
                taxRate = .1;   // 10% tax

        } // end switch statement

        double tax = taxRate * subtotal; // calculate taxes
        double total = subtotal + tax;   // calculate total with taxes

        // display tax and total
        taxJTextField.setText(dollars.format(tax));
        totalJTextField.setText(dollars.format(total));

        amountJTextField.setText(""); // clear amountJTextField
        subtotal = 0.0; // reset subtotal to 0.0

    } // end method totalJButtonActionPerformed

    // clear current amount displayed in amountJTextField
    private void deleteJButtonActionPerformed(ActionEvent event) {
        amountJTextField.setText("");
    } // end method deleteJButtonActionPerformed

    // clear all results
    private void clearJButtonActionPerformed(ActionEvent event) {
        amountJTextField.setText("");
        subtotalJTextField.setText("$0.00");
        taxJTextField.setText("$0.00");
        totalJTextField.setText("$0.00");
        subtotal = 0.0; // reset subtotal to 0.0

    } // end method clearJButtonActionPerformed

} // end class CashRegister

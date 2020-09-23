package tutorial_7;

// Exercise 7.13: FuzzyDiceOrderForm.java
// This application calculates the total cost of a
// purchase order for different colored fuzzy dice.

import java.awt.*;
import java.awt.event.*;
import java.text.*;
import javax.swing.*;

public class FuzzyDiceOrderForm extends JFrame {

    private JTextField orderNumberJTextField;

    private JTextField fullNameJTextField;

    private JTextField addressJTextField1;
    private JTextField addressJTextField2;

    private JCheckBox whiteTypeJCheckBox;
    private JCheckBox redTypeJCheckBox;

    private JTextField whiteQuantityJTextField;
    private JTextField redQuantityJTextField;

    private JTextField whiteTotalsJTextField;
    private JTextField redTotalsJTextField;

    private JTextField subtotalJTextField;

    private JTextField taxJTextField;

    private JTextField totalJTextField;

    // no-argument constructor
    public FuzzyDiceOrderForm() {
        createUserInterface();
    }

    // main method
    public static void main(String[] args) {
        FuzzyDiceOrderForm application = new FuzzyDiceOrderForm();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } // end method main

    // create and position GUI components; register event handlers
    private void createUserInterface() {
        // get content pane for attaching GUI components
        Container contentPane = getContentPane();

        // enable explicit positioning of GUI components
        contentPane.setLayout(null);

        // set up fuzzyDiceJLabel
        // JLabel that displays header on application window
        JLabel fuzzyDiceJLabel = new JLabel();
        fuzzyDiceJLabel.setBounds(80, 16, 235, 24);
        fuzzyDiceJLabel.setText("Fuzzy Dice Order Form");
        fuzzyDiceJLabel.setFont(new Font("Default", Font.PLAIN, 22));
        contentPane.add(fuzzyDiceJLabel);

        // set up orderNumberJLabel
        // JLabel and JTextField for order number
        JLabel orderNumberJLabel = new JLabel();
        orderNumberJLabel.setBounds(15, 65, 100, 16);
        orderNumberJLabel.setText("Order Number:");
        contentPane.add(orderNumberJLabel);

        // set up orderNumberJTextField
        orderNumberJTextField = new JTextField();
        orderNumberJTextField.setBounds(111, 65, 48, 21);
        orderNumberJTextField.setText("0");
        orderNumberJTextField.setHorizontalAlignment(JTextField.RIGHT);
        contentPane.add(orderNumberJTextField);

        // set up nameJLabel
        // JLabel and JTextField for user's name
        JLabel fullNameJLabel = new JLabel();
        fullNameJLabel.setBounds(15, 105, 65, 16);
        fullNameJLabel.setText("Full Name:");
        contentPane.add(fullNameJLabel);

        // set up nameJTextField
        fullNameJTextField = new JTextField();
        fullNameJTextField.setBounds(111, 105, 245, 21);
        fullNameJTextField.setText("Enter full name here");
        contentPane.add(fullNameJTextField);

        // set up addressJLabel
        // JLabel and JTextFields for user's address
        JLabel addressJLabel = new JLabel();
        addressJLabel.setBounds(15, 129, 55, 16);
        addressJLabel.setText("Address:");
        contentPane.add(addressJLabel);

        // set up addressJTextField1
        addressJTextField1 = new JTextField();
        addressJTextField1.setBounds(111, 129, 245, 21);
        addressJTextField1.setText("Address Line 1");
        contentPane.add(addressJTextField1);

        // set up addressJTextField2
        addressJTextField2 = new JTextField();
        addressJTextField2.setBounds(111, 153, 245, 21);
        addressJTextField2.setText("City, State, Zip");
        contentPane.add(addressJTextField2);

        // set up typeJLabel
        // JLabel and JCheckBoxes for dice types
        JLabel typeJLabel = new JLabel();
        typeJLabel.setBounds(15, 204, 40, 16);
        typeJLabel.setText("Type:");
        contentPane.add(typeJLabel);

        // set up whiteTypeJCheckBox
        whiteTypeJCheckBox = new JCheckBox();
        whiteTypeJCheckBox.setBounds(10, 227, 93, 21);
        whiteTypeJCheckBox.setText("White/Black");
        contentPane.add(whiteTypeJCheckBox);

        // set up redTypeJCheckBox
        redTypeJCheckBox = new JCheckBox();
        redTypeJCheckBox.setBounds(10, 252, 88, 21);
        redTypeJCheckBox.setText("Red/Black");
        contentPane.add(redTypeJCheckBox);

        // set up quantityJLabel
        // JLabel and JTextFields for dice quantities
        JLabel quantityJLabel = new JLabel();
        quantityJLabel.setBounds(111, 204, 72, 16);
        quantityJLabel.setText("Quantity:");
        contentPane.add(quantityJLabel);

        // set up whiteQuantityJTextField
        whiteQuantityJTextField = new JTextField();
        whiteQuantityJTextField.setBounds(111, 228, 64, 21);
        whiteQuantityJTextField.setText("0");
        whiteQuantityJTextField.setHorizontalAlignment(JTextField.RIGHT);
        contentPane.add(whiteQuantityJTextField);

        // set up redQuantityJTextField
        redQuantityJTextField = new JTextField();
        redQuantityJTextField.setBounds(111, 252, 64, 21);
        redQuantityJTextField.setText("0");
        redQuantityJTextField.setHorizontalAlignment(JTextField.RIGHT);
        contentPane.add(redQuantityJTextField);

        // set up priceJLabel
        // JLabels for dice prices
        JLabel priceJLabel = new JLabel();
        priceJLabel.setBounds(196, 204, 72, 16);
        priceJLabel.setText("Price:");
        contentPane.add(priceJLabel);

        // set up whitePriceJLabel
        JLabel whitePriceJLabel = new JLabel();
        whitePriceJLabel.setBounds(196, 228, 80, 21);
        whitePriceJLabel.setText("$6.25");
        contentPane.add(whitePriceJLabel);

        // set up redPriceJLabel
        JLabel redPriceJLabel = new JLabel();
        redPriceJLabel.setBounds(196, 252, 80, 21);
        redPriceJLabel.setText("$5.00");
        contentPane.add(redPriceJLabel);

        // set up totalsJLabel
        // JLabel and JTextFields for dice subtotals
        JLabel totalsJLabel = new JLabel();
        totalsJLabel.setBounds(267, 204, 72, 16);
        totalsJLabel.setText("Totals:");
        contentPane.add(totalsJLabel);

        // set up whiteTotalsJTextField
        whiteTotalsJTextField = new JTextField();
        whiteTotalsJTextField.setBounds(267, 228, 87, 16);
        whiteTotalsJTextField.setText("$0.00");
        whiteTotalsJTextField.setEditable(false);
        whiteTotalsJTextField.setHorizontalAlignment(JTextField.RIGHT);
        contentPane.add(whiteTotalsJTextField);

        // set up redTotalsJTextField
        redTotalsJTextField = new JTextField();
        redTotalsJTextField.setBounds(267, 252, 87, 16);
        redTotalsJTextField.setText("$0.00");
        redTotalsJTextField.setEditable(false);
        redTotalsJTextField.setHorizontalAlignment(JTextField.RIGHT);
        contentPane.add(redTotalsJTextField);

        // set up subtotalJLabel
        // JLabel and JTextField for total before tax
        JLabel subtotalJLabel = new JLabel();
        subtotalJLabel.setBounds(196, 293, 72, 16);
        subtotalJLabel.setText("Subtotal:");
        contentPane.add(subtotalJLabel);

        // set up subtotalJTextField
        subtotalJTextField = new JTextField();
        subtotalJTextField.setBounds(267, 293, 87, 16);
        subtotalJTextField.setText("$0.00");
        subtotalJTextField.setEditable(false);
        subtotalJTextField.setHorizontalAlignment(JTextField.RIGHT);
        contentPane.add(subtotalJTextField);

        // set up taxJLabel
        // JLabel and JTextField for tax
        JLabel taxJLabel = new JLabel();
        taxJLabel.setBounds(196, 317, 72, 16);
        taxJLabel.setText("Tax:");
        contentPane.add(taxJLabel);

        // set up taxJTextField
        taxJTextField = new JTextField();
        taxJTextField.setBounds(267, 317, 87, 16);
        taxJTextField.setText("$0.00");
        taxJTextField.setEditable(false);
        taxJTextField.setHorizontalAlignment(JTextField.RIGHT);
        contentPane.add(taxJTextField);

        // set up discountJLabel
        // JLabel and JTextField for discount
        JLabel discountJLabel = new JLabel();
        discountJLabel.setBounds(196, 341, 72, 16);
        discountJLabel.setText("Discount:");
        contentPane.add(discountJLabel);

        // set up discountJTextField
        JTextField discountJTextField = new JTextField();
        discountJTextField.setBounds(267, 341, 87, 16);
        discountJTextField.setText("$0.00");
        discountJTextField.setEditable(false);
        discountJTextField.setHorizontalAlignment(JTextField.RIGHT);
        contentPane.add(discountJTextField);

        // set up totalJLabel
        // JLabel and JTextField for final total
        JLabel totalJLabel = new JLabel();
        totalJLabel.setBounds(196, 365, 72, 16);
        totalJLabel.setText("Total:");
        contentPane.add(totalJLabel);

        // set up totalJTextField
        totalJTextField = new JTextField();
        totalJTextField.setBounds(267, 365, 87, 16);
        totalJTextField.setText("$0.00");
        totalJTextField.setEditable(false);
        totalJTextField.setHorizontalAlignment(JTextField.RIGHT);
        contentPane.add(totalJTextField);

        // set up calculateJButton and register its event handler
        // JButton to initiate calculate of user's bill
        JButton calculateJButton = new JButton();
        calculateJButton.setBounds(267, 397, 87, 23);
        calculateJButton.setText("Calculate");
        contentPane.add(calculateJButton);
        // anonymous inner class
        // event handler called when user clicks calculateJButton
        calculateJButton.addActionListener(

                this::calculateJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set properties of application's window
        setTitle("Fuzzy Dice Order Form"); // set title bar string
        setSize(380, 466); // set window size
        setVisible(true); // display window

    } // end method createUserInterface

    // calculate the cost of the order
    private void calculateJButtonActionPerformed(ActionEvent event) {
        // get user inputs
        String orderNumber = orderNumberJTextField.getText();
        String fullName = fullNameJTextField.getText();
        String address1 = addressJTextField1.getText();
        String address2 = addressJTextField2.getText();

        // total of white/black dice ordered
        double whiteTotals = 0.0;

        // total of red/black dice ordered
        double redTotals = 0.0;

        // calculate price if white/black JCheckBox is selected
        if (whiteTypeJCheckBox.isSelected()) {
            whiteTotals = Integer.parseInt(whiteQuantityJTextField.getText()) * 6.25;
        }

        // calculate price if red/black JCheckBox is selected
        if (redTypeJCheckBox.isSelected()) {
            redTotals = Integer.parseInt(redQuantityJTextField.getText()) * 5.00;
        }

        // display message if order number, name or address is empty
        if (orderNumber.equals("") || fullName.equals("") || address1.equals("") || address2.equals("")
                || orderNumber.equals("0") || fullName.equals("Enter name here") || address1.equals("Address Line 1")
                || address2.equals("City, State, Zip")) {
            // display message
            JOptionPane.showMessageDialog(null, "Please fill out all information fields.", "Empty Fields",
                    JOptionPane.WARNING_MESSAGE);
        } else if (!whiteTypeJCheckBox.isSelected() && !redTypeJCheckBox.isSelected()) {
            // display message if no JCheckBox is
            // selected and its quantity is 0
            JOptionPane.showMessageDialog(null, "Please select an item and enter a quantity.", "No Item selected",
                    JOptionPane.WARNING_MESSAGE);
        } else // otherwise, calculate totals
        {
            // set display format
            DecimalFormat dollars = new DecimalFormat("$0.00");

            // display totals of dice ordered
            whiteTotalsJTextField.setText(dollars.format(whiteTotals));
            redTotalsJTextField.setText(dollars.format(redTotals));

            // calculate and display subtotal
            double subtotal = whiteTotals + redTotals;
            subtotalJTextField.setText(dollars.format(subtotal));

            // determine amount ordered is greater than $50
            // if ( amount > 50 ) {

            // }
            // calculate and display tax
            double tax = subtotal * 0.05;
            taxJTextField.setText(dollars.format(tax));

            // calculate and display total
            totalJTextField.setText(dollars.format(subtotal + tax));

        } // end else

    } // end method calculateJButtonActionPerformed

} // end class FuzzyDiceOrderForm

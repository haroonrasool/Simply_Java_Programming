package tutorial_9;

// Exercise 9.17: RestaurantBill.java
// This application calculates a restaurant bill.

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.text.DecimalFormat;

public class RestaurantBill extends JFrame {
    private JTextArea quantityJTextArea;

    private JTextArea itemJTextArea;

    private JTextArea priceJTextArea;

    private JTextField totalCostJTextField;

    // no-argument constructor
    public RestaurantBill() {
        createUserInterface();
    }

    // main method
    public static void main(String[] args) {
        RestaurantBill application = new RestaurantBill();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } // end method main

    // create and position GUI components; register event handlers
    private void createUserInterface() {
        // get content pane for attaching GUI components
        Container contentPane = getContentPane();

        // enable explicit positioning of GUI components
        contentPane.setLayout(null);

        // set up quantityJLabel
        // JLabel and JTextArea for quantity of lunch items
        JLabel quantityJLabel = new JLabel();
        quantityJLabel.setBounds(16, 8, 56, 23);
        quantityJLabel.setText("Quantity:");
        contentPane.add(quantityJLabel);

        // set up quantityJTextArea
        quantityJTextArea = new JTextArea();
        quantityJTextArea.setBounds(16, 32, 72, 55);
        contentPane.add(quantityJTextArea);

        // set up itemJLabel
        // JLabel and JTextArea for name of lunch items
        JLabel itemJLabel = new JLabel();
        itemJLabel.setBounds(104, 8, 64, 23);
        itemJLabel.setText("Item:");
        contentPane.add(itemJLabel);

        // set up itemJTextArea
        itemJTextArea = new JTextArea();
        itemJTextArea.setBounds(104, 32, 104, 55);
        contentPane.add(itemJTextArea);

        // set up priceJLabel
        // JLabel and JTextArea for price of lunch items
        JLabel priceJLabel = new JLabel();
        priceJLabel.setBounds(224, 8, 56, 23);
        priceJLabel.setText("Price:");
        contentPane.add(priceJLabel);

        // set up priceJTextArea
        priceJTextArea = new JTextArea();
        priceJTextArea.setBounds(224, 32, 96, 55);
        contentPane.add(priceJTextArea);

        // set up addItemsJButton
        // JButton initiates calculation of bill
        JButton addItemsJButton = new JButton();
        addItemsJButton.setBounds(16, 105, 96, 23);
        addItemsJButton.setText("Add Items");
        contentPane.add(addItemsJButton);
        // anonymous inner class
        // event handler called when addItemsJButton is pressed
        addItemsJButton.addActionListener(

                this::addItemsJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set up totalCostJLabel
        // JLabel and JTextField displays total cost
        JLabel totalCostJLabel = new JLabel();
        totalCostJLabel.setBounds(144, 105, 64, 23);
        totalCostJLabel.setText("Total Cost:");
        contentPane.add(totalCostJLabel);

        // set up totalCostJTextField
        totalCostJTextField = new JTextField();
        totalCostJTextField.setBounds(224, 105, 96, 23);
        totalCostJTextField.setEditable(false);
        totalCostJTextField.setHorizontalAlignment(
                JTextField.CENTER);
        contentPane.add(totalCostJTextField);

        // set properties of application's window
        setTitle("Restaurant Bill"); // set title bar text
        setSize(350, 180);           // set window size
        setVisible(true);            // display window

    } // end method createUserInterface

    // method to retrieve input from users and calculate total
    private void addItemsJButtonActionPerformed(ActionEvent event) {
        // clear previous grades and calculation result
        totalCostJTextField.setText("");
        quantityJTextArea.setText("");
        itemJTextArea.setText("");
        priceJTextArea.setText("");

        int quantity;
        double price, total = 0;
        int counter = 1;

        // dollars format to display amount
        DecimalFormat dollars = new DecimalFormat("$0.00");

        // get user input and convert input
        do {
            // get quantity of item
            String quantityInput = JOptionPane.showInputDialog(null, "Enter the Quantity of Item " + counter);
            quantity = Integer.parseInt(quantityInput);

            // get name of item
            String itemInput = JOptionPane.showInputDialog(null, "Enter Name of Item " + counter);

            // get price of item
            String priceInput = JOptionPane.showInputDialog(null, "Enter the Price of Item " + counter);
            price = Double.parseDouble(priceInput);

            // add item info to JTextAreas
            quantityJTextArea.append(quantity + "\n");
            itemJTextArea.append(itemInput + "\n");
            priceJTextArea.append(dollars.format(price) + "\n");

            total += price * quantity; // calculate total
            counter++; // increment counter

        } while (counter <= 3);

        // display total price with monetary format
        totalCostJTextField.setText(dollars.format(total));

    } // end method addItemsJButtonActionPerformed

} // end class RestaurantBill

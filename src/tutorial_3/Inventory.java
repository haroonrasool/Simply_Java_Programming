package tutorial_3;

// Tutorial 3: Inventory.java
// Calculates the number of items in a shipment based on the number 
// of cartons received and the number of items per carton.

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Inventory extends JFrame {
    private JTextField cartonsJTextField;

    private JTextField itemsJTextField;

    private JTextField totalResultJTextField;

    private JTextField shipmentsJTextField;

    // no-argument constructor
    public Inventory() {
        createUserInterface();
    }

    // main method
    public static void main(String[] args) {
        Inventory application = new Inventory();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } // end method main

    // create and position GUI components; register event handlers
    public void createUserInterface() {
        // get content pane and set layout to null
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        // set up cartonsJLabel
        // JLabel and JTextField for cartons per shipment
        JLabel cartonsJLabel = new JLabel();
        cartonsJLabel.setText("Cartons per shipment:");
        cartonsJLabel.setBounds(16, 16, 130, 21);
        contentPane.add(cartonsJLabel);

        // set up itemsJLabel
        // JLabel and JTextField for items per carton
        JLabel itemsJLabel = new JLabel();
        itemsJLabel.setText("Items per carton:");
        itemsJLabel.setBounds(16, 48, 130, 21);
        contentPane.add(itemsJLabel);

        // set up totalJLabel
        // JLabel and JTextField for total items per shipment
        JLabel totalJLabel = new JLabel();
        totalJLabel.setText("Total:");
        totalJLabel.setBounds(204, 16, 40, 21);
        contentPane.add(totalJLabel);

        // set up shipmentsJLabel
        JLabel shipmentsJLabel = new JLabel();
        shipmentsJLabel.setText("Shipments this week:");
        shipmentsJLabel.setBounds(16, 80, 130, 21);
        contentPane.add(shipmentsJLabel);

        // set up cartonsJTextField
        cartonsJTextField = new JTextField();
        cartonsJTextField.setText("0");
        cartonsJTextField.setBounds(148, 16, 40, 21);
        cartonsJTextField.setHorizontalAlignment(JTextField.RIGHT);
        contentPane.add(cartonsJTextField);
        cartonsJTextField.addKeyListener(

                new KeyAdapter() // anonymous inner class
                {
                    // method called when user types in cartonsJTextField
                    public void keyPressed(KeyEvent event) {
                        cartonsJTextFieldKeyPressed();
                    }

                } // end anonymous inner class

        ); // end call to addKeyListener

        // set up itemsJTextField
        itemsJTextField = new JTextField();
        itemsJTextField.setText("0");
        itemsJTextField.setBounds(148, 48, 40, 21);
        itemsJTextField.setHorizontalAlignment(JTextField.RIGHT);
        contentPane.add(itemsJTextField);
        itemsJTextField.addKeyListener(

                new KeyAdapter() // anonymous inner class
                {
                    // method called when user types in itemsJTextField
                    public void keyPressed(KeyEvent event) {
                        cartonsJTextFieldKeyPressed();
                    }

                } // end anonymous inner class

        ); // end call to addKeyListener

        // set up shipmentsJTextField
        shipmentsJTextField = new JTextField();
        shipmentsJTextField.setText("0");
        shipmentsJTextField.setBounds(148, 80, 40, 21);
        shipmentsJTextField.setHorizontalAlignment(JTextField.RIGHT);
        contentPane.add(shipmentsJTextField);
        shipmentsJTextField.addKeyListener(

                new KeyAdapter() // anonymous inner class
                {
                    // method called when user types in itemsJTextField
                    public void keyPressed(KeyEvent event) {
                        cartonsJTextFieldKeyPressed();
                    }

                } // end anonymous inner class

        ); // end call to addKeyListener

        // set up totalResultJTextField
        totalResultJTextField = new JTextField();
        totalResultJTextField.setBounds(244, 16, 86, 21);
        totalResultJTextField.setHorizontalAlignment(JTextField.RIGHT);
        totalResultJTextField.setEditable(false);
        contentPane.add(totalResultJTextField);

        // set up calculateJButton
        // JButton to initiate calculation of total items per shipment
        JButton calculateJButton = new JButton();
        calculateJButton.setText("Calculate Total");
        calculateJButton.setBounds(204, 80, 126, 24);
        contentPane.add(calculateJButton);
        // anonymous inner class
        // method called when calculate JButton is pressed
        calculateJButton.addActionListener(

                this::calculateJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set properties of application�s window
        setTitle("Inventory"); // set title bar text
        setSize(354, 150);     // set window size
        setVisible(true);      // display window

    } // end method createUserInterface

    // calculate the total items in the shipment
    private void calculateJButtonActionPerformed(ActionEvent event) {
        // declare variables
        int cartons; // stores number of cartons in shipment
        int items;   // stores number of items per carton
        int shipments;
        int result;  // stores product of cartons and items

        // retrieve numbers from JTextFields
        cartons = Integer.parseInt(cartonsJTextField.getText());
        items = Integer.parseInt(itemsJTextField.getText());
        shipments = Integer.parseInt(shipmentsJTextField.getText());

        // multiply values input
        result = cartons * items * shipments;

        // display result in totalResultJTextField
        totalResultJTextField.setText(String.valueOf(result));

    } // end method calculateJButtonActionPerformed

    // clear totalResultJTextField because the value is now invalid
    private void cartonsJTextFieldKeyPressed() {
        totalResultJTextField.setText(""); // clear output JTextField
    } // end method cartonsJTextFieldKeyPressed

} // end class Inventory

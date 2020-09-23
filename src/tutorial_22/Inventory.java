package tutorial_22;

// Exercise 22.11: Inventory.java
// Calculates the number of items in a shipment based on the number 
// of cartons received and the number of items per carton.

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Inventory extends JFrame {
    private JTextField cartonsJTextField;
    private JTextField itemsJTextField;
    private JTextField totalJTextField;

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
    private void createUserInterface() {
        // get content pane and set layout to null
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        // set up cartonsJLabel
        // JLabel and JTextField for cartons per shipment
        JLabel cartonsJLabel = new JLabel();
        cartonsJLabel.setText("Cartons per shipment:");
        cartonsJLabel.setBounds(16, 16, 130, 21);
        contentPane.add(cartonsJLabel);

        // set up cartonsJTextField
        cartonsJTextField = new JTextField();
        cartonsJTextField.setText("0");
        cartonsJTextField.setBounds(148, 16, 40, 21);
        cartonsJTextField.setHorizontalAlignment(JTextField.RIGHT);
        contentPane.add(cartonsJTextField);
        cartonsJTextField.addKeyListener(

                new KeyAdapter() // anonymous inner class
                {
                    // event handler called when cartonsJTextField is edited
                    public void keyPressed(KeyEvent event) {
                        cartonsJTextFieldKeyPressed(event);
                    }

                } // end anonymous inner class

        ); // end call to addKeyListener

        // set up itemsJLabel
        // JLabel and JTextField for items per carton
        JLabel itemsJLabel = new JLabel();
        itemsJLabel.setText("Items per carton:");
        itemsJLabel.setBounds(16, 48, 104, 21);
        contentPane.add(itemsJLabel);

        // set up itemsJTextField
        itemsJTextField = new JTextField();
        itemsJTextField.setText("0");
        itemsJTextField.setBounds(148, 48, 40, 21);
        itemsJTextField.setHorizontalAlignment(JTextField.RIGHT);
        contentPane.add(itemsJTextField);
        itemsJTextField.addKeyListener(

                new KeyAdapter() // anonymous inner class
                {
                    // event handler called when itemsJTextField is edited
                    public void keyPressed(KeyEvent event) {
                        itemsJTextFieldKeyPressed(event);
                    }

                } // end anonymous inner class

        ); // end call to addKeyListener

        // set up totalJLabel
        // JLabel and JTextField for total items per shipment
        JLabel totalJLabel = new JLabel();
        totalJLabel.setText("Total:");
        totalJLabel.setBounds(204, 16, 40, 21);
        contentPane.add(totalJLabel);

        // set up totalJTextField
        totalJTextField = new JTextField();
        totalJTextField.setBounds(244, 16, 86, 21);
        totalJTextField.setHorizontalAlignment(JTextField.RIGHT);
        totalJTextField.setEditable(false);
        contentPane.add(totalJTextField);

        // set up calculateJButton
        // JButton to initiate calculation of total items per shipment
        JButton calculateJButton = new JButton();
        calculateJButton.setText("Calculate Total");
        calculateJButton.setBounds(204, 48, 126, 24);
        contentPane.add(calculateJButton);
        // anonymous inner class
        // event handler called when calculateJButton is clicked
        calculateJButton.addActionListener(

                this::calculateJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set properties of application's window
        setTitle("Inventory"); // set title bar string
        setSize(354, 112);     // set window size
        setVisible(true);      // display window

    } // end method createUserInterface

    // ensure only numbers are entered in cartonsJTextField
    private void cartonsJTextFieldKeyPressed(KeyEvent event) {
        // get the key code for the key pressed by the user.
        switch (event.getKeyCode()) {
            case KeyEvent.VK_0:
            case KeyEvent.VK_1:
            case KeyEvent.VK_2:
            case KeyEvent.VK_3:
            case KeyEvent.VK_4:
            case KeyEvent.VK_5:
            case KeyEvent.VK_6:
            case KeyEvent.VK_7:
            case KeyEvent.VK_8:
            case KeyEvent.VK_9:
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_BACK_SPACE:
            case KeyEvent.VK_ENTER:
                break;
            default:
                JOptionPane.showMessageDialog(this, "Enter numbers only.", "Invalid Input", JOptionPane.WARNING_MESSAGE);
                cartonsJTextField.setText("0");
                break;
        } // end switch statement

    } // end method cartonsJTextFieldKeyPressed

    // ensure only numbers are entered in itemsJTextField
    private void itemsJTextFieldKeyPressed(KeyEvent event) {
        // get the key code for the key pressed by the user.
        switch (event.getKeyCode()) {
            case KeyEvent.VK_0:
            case KeyEvent.VK_1:
            case KeyEvent.VK_2:
            case KeyEvent.VK_3:
            case KeyEvent.VK_4:
            case KeyEvent.VK_5:
            case KeyEvent.VK_6:
            case KeyEvent.VK_7:
            case KeyEvent.VK_8:
            case KeyEvent.VK_9:
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_BACK_SPACE:
            case KeyEvent.VK_ENTER:
                break;
            default:
                JOptionPane.showMessageDialog(this, "Enter numbers only.", "Invalid Input", JOptionPane.WARNING_MESSAGE);
                itemsJTextField.setText("0");
                break;
        } // end switch statement

    } // end method itemsJTextFieldKeyPressed

    // method to calculate the total inventory
    private void calculateJButtonActionPerformed(ActionEvent event) {
        // import data from JTextFields
        int cartons = Integer.parseInt(cartonsJTextField.getText());
        int items = Integer.parseInt(itemsJTextField.getText());

        // calculate the total
        int total = items * cartons;

        // convert output to string and display in totalJTextField
        totalJTextField.setText(String.valueOf(total));

    } // end method calculateJButtonActionPerformed

} // end class Inventory

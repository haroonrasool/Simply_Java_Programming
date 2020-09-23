package tutorial_23;

// Exercise 23.11: SupplyCalculator.java
// Enables users to select from a list of supplies
// and determine the price of the selected supplies.

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SupplyCalculator extends JFrame {
    private JList<String> stockJList;
    private JButton removeJButton;
    private JList<Object> itemsJList;
    private JTextField totalJTextField;
    // JButton to calculate total amount user is spending
    private JButton calculateJButton;

    // ArrayList for storing items user has selected
    private final ArrayList<Object> userArrayList = new ArrayList<>();

    // String for storing items in stock
    private final String[] stockItems = {"Staples - $2.10",
            "Stapler - $5.99", "Folder - $3.65", "Notebook - $4.99",
            "Pencil - $1.29", "Eraser - $1.49", "Pen - $1.89",
            "Post-it - $0.99", "Marker - $1.99", "MousePad - $2.49"};

    // format to display the amount in Dollars format.
    private final DecimalFormat dollars = new DecimalFormat("$0.00");

    // no-argument constructor
    public SupplyCalculator() {
        createUserInterface();
    }

    // main method
    public static void main(String[] args) {
        SupplyCalculator application = new SupplyCalculator();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } // end method main

    // create and position GUI components; register event handlers
    private void createUserInterface() {
        // get content pane for attaching GUI components
        Container contentPane = getContentPane();

        // enable explicit positioning of GUI components
        contentPane.setLayout(null);

        // set up stockListJLabel
        // JLabel, JList and JScrollPane for displaying items in stock
        JLabel stockListJLabel = new JLabel();
        stockListJLabel.setBounds(16, 16, 100, 21);
        stockListJLabel.setText("Items in Stock:");
        contentPane.add(stockListJLabel);

        // set up stockJList and stockJScrollPane
        stockJList = new JList<>(stockItems);
        JScrollPane stockJScrollPane = new JScrollPane(stockJList);
        stockJScrollPane.setBounds(16, 40, 120, 200);
        contentPane.add(stockJScrollPane);

        // set up addJButton
        // JButtons to add and remove items from the user item list
        JButton addJButton = new JButton();
        addJButton.setBounds(144, 56, 104, 23);
        addJButton.setText("Add >>");
        contentPane.add(addJButton);
        // anonymous inner class
        // event handler called when addJButton is pressed
        addJButton.addActionListener(

                this::addJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set up removeJButton
        removeJButton = new JButton();
        removeJButton.setBounds(144, 96, 104, 23);
        removeJButton.setText("<< Remove");
        removeJButton.setEnabled(false);
        contentPane.add(removeJButton);
        // anonymous inner class
        // event handler called when removeJButton is pressed
        removeJButton.addActionListener(

                this::removeJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set up calculateJButton
        calculateJButton = new JButton();
        calculateJButton.setBounds(144, 144, 104, 23);
        calculateJButton.setText("Calculate");
        calculateJButton.setEnabled(false);
        contentPane.add(calculateJButton);
        // anonymous inner class
        // event handler called when calculateJButton is pressed
        calculateJButton.addActionListener(

                this::calculateJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set up itemsJLabel
        // JLabel, JList and JScrollPane for displaying user item list
        JLabel itemsJLabel = new JLabel();
        itemsJLabel.setBounds(262, 16, 110, 21);
        itemsJLabel.setText("Items in Your List:");
        contentPane.add(itemsJLabel);

        // set up itemsJList and itemsJScrollPane
        itemsJList = new JList<>();
        JScrollPane itemsJScrollPane = new JScrollPane(itemsJList);
        itemsJScrollPane.setBounds(262, 40, 120, 200);
        contentPane.add(itemsJScrollPane);

        // set up totalJLabel
        // JLabel and JTextField for displaying total cost
        JLabel totalJLabel = new JLabel();
        totalJLabel.setBounds(180, 180, 40, 23);
        totalJLabel.setText("Total:");
        contentPane.add(totalJLabel);

        // set up totalJTextField
        totalJTextField = new JTextField();
        totalJTextField.setBounds(144, 210, 104, 23);
        totalJTextField.setHorizontalAlignment(JTextField.CENTER);
        totalJTextField.setEditable(false);
        contentPane.add(totalJTextField);

        // set properties of application's window
        setTitle("Supply Cost Calculator"); // set title bar string
        setSize(410, 290);                  // set window size
        setVisible(true);                   // display window

    } // end method createUserInterface

    // add shopping item to itemsJList
    private void addJButtonActionPerformed(ActionEvent event) {
        // Object array to hold user selection
        Object[] selectedValue = stockJList.getSelectedValuesList().toArray();

        // if there is at least one item selected
        if (selectedValue.length != 0) {
            Collections.addAll(userArrayList, selectedValue);
            // add item to itemsJList
            itemsJList.setListData(userArrayList.toArray());

            // enable Calculate and Remove JButtons
            removeJButton.setEnabled(true);
            calculateJButton.setEnabled(true);

            totalJTextField.setText(""); // clear totalJTextField
        } else {
            // display message if there is no item selected
            JOptionPane.showMessageDialog(this,
                    "Please select item to add", "Cannot Add",
                    JOptionPane.ERROR_MESSAGE);
        }

        // clear selected index
        stockJList.clearSelection();

    } // end method addJButtonActionPerformed

    // remove shopping item from itemsJList
    private void removeJButtonActionPerformed(ActionEvent event) {
        // int array to hold user selection
        int[] selectedValue = itemsJList.getSelectedIndices();

        // if there is at least one item selected
        if (selectedValue.length != 0) {
            for (int counter = 0; counter < selectedValue.length;
                 counter++) {
                // remove item at the selected index
                // subtract counter, to reset index based on
                // removals from previous iterations of the for loop
                userArrayList.remove(
                        selectedValue[counter] - counter);
            }

            // reset data based on changes to ArrayList
            itemsJList.setListData(userArrayList.toArray());
        } else {
            // display message if there is no item selected
            JOptionPane.showMessageDialog(this,
                    "Please select item to remove", "Cannot Remove",
                    JOptionPane.ERROR_MESSAGE);
        }

        // if there are no items remaining
        if (userArrayList.size() < 1) {
            // disable the Remove and Calculate JButtons
            removeJButton.setEnabled(false);
            calculateJButton.setEnabled(false);
        }

        // clear totalJTextField
        totalJTextField.setText("");

    } // end method removeJButtonActionPerformed

    // calculate total price
    private void calculateJButtonActionPerformed(ActionEvent event) {
        // local variables for calculation

        // total amount
        double total = 0.0;

        // temporary price variable
        String price;

        // enhanced for loop
        // for (int variableName : arrayName) {total += variableName;}

        // run through list of items
        for (Object object : userArrayList) {
            // retrieve price from items
            price = (String) object;

            // get substring starting after the $
            price = price.substring(price.indexOf("$") + 1);

            // add price of each item to total
            total += Double.parseDouble(price);

        } // end for loop

        // display total
        DecimalFormat dollars = new DecimalFormat("$0.00");
        totalJTextField.setText(dollars.format(total));

    } // end method calculateJButtonActionPerformed

} // end class SupplyCalculator

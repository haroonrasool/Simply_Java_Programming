package tutorial_26.RestaurantBillCalculator;

// Exercise 26.12: RestaurantBillCalculator.java
// Calculates a table's bill.

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import javax.swing.*;

public class RestaurantBillCalculator extends JFrame {

    // JPanel to display waiter information
    private JPanel waiterJPanel;

    private JTextField tableNumberJTextField;

    private JTextField waiterNameJTextField;

    // JPanel to display menu items
    private JPanel menuItemsJPanel;

    private JComboBox<String> beverageJComboBox;

    private JComboBox<String> appetizerJComboBox;

    private JComboBox<String> mainCourseJComboBox;

    private JComboBox<String> dessertJComboBox;

    private JTextField subtotalJTextField;

    private JTextField taxJTextField;

    private JTextField totalJTextField;

    // constant for tax rate
    private final static double TAX_RATE = 0.05;

    // declare instance variables for database processing
    private Connection myConnection;
    private Statement myStatement;
    private ResultSet myResultSet;

    // declare instance variable ArrayList to hold bill items
    private final ArrayList<String> billItems = new ArrayList<>();

    // constructor
    public RestaurantBillCalculator(
            String databaseDriver, String databaseURL) {
        // attempt database connection
        try {
            // load Cloudscape driver
            Class.forName(databaseDriver);

            // connect to database
            myConnection =
                    DriverManager.getConnection(databaseURL);

            // create statement
            myStatement = myConnection.createStatement();
        } catch (SQLException | ClassNotFoundException exception) {
            exception.printStackTrace();
        }

        createUserInterface(); // set up GUI

    } // end constructor

    // create and position GUI components; register event handlers
    private void createUserInterface() {
        // get content pane for attaching GUI components
        Container contentPane = getContentPane();

        // enable explicit positioning of GUI components
        contentPane.setLayout(null);

        // set up restaurantJLabel
        // JLabel for Restaurant
        JLabel restaurantJLabel = new JLabel();
        restaurantJLabel.setBounds(80, 8, 128, 24);
        restaurantJLabel.setText("Restaurant");
        restaurantJLabel.setFont(
                new Font("SansSerif", Font.BOLD, 16));
        contentPane.add(restaurantJLabel);

        // set up waiterJPanel
        createWaiterJPanel();
        contentPane.add(waiterJPanel);

        // set up menuItemsJPanel
        createMenuItemsJPanel();
        contentPane.add(menuItemsJPanel);

        // set up calculateBillJButton
        // JButton for calculate bill
        JButton calculateBillJButton = new JButton();
        calculateBillJButton.setBounds(92, 320, 90, 24);
        calculateBillJButton.setText("Calculate Bill");
        calculateBillJButton.setBorder(
                BorderFactory.createRaisedBevelBorder());
        contentPane.add(calculateBillJButton);
        // anonymous inner class
        // event handler called when calculateBillJButton is clicked
        calculateBillJButton.addActionListener(

                event -> calculateBillJButtonActionPerformed() // end anonymous inner class

        ); // end addActionListener

        // set up subtotalJLabel
        // JLabel and JTextField for subtotal
        JLabel subtotalJLabel = new JLabel();
        subtotalJLabel.setBounds(28, 360, 56, 16);
        subtotalJLabel.setText("Subtotal:");
        contentPane.add(subtotalJLabel);

        // set up subtotalJTextField
        subtotalJTextField = new JTextField();
        subtotalJTextField.setBounds(92, 360, 90, 20);
        subtotalJTextField.setEditable(false);
        subtotalJTextField.setBorder(
                BorderFactory.createLoweredBevelBorder());
        subtotalJTextField.setHorizontalAlignment(JTextField.RIGHT);
        contentPane.add(subtotalJTextField);

        // set up taxJLabel
        // JLabel and JTextField for tax
        JLabel taxJLabel = new JLabel();
        taxJLabel.setBounds(28, 392, 56, 16);
        taxJLabel.setText("Tax:");
        contentPane.add(taxJLabel);

        // set up taxJTextField
        taxJTextField = new JTextField();
        taxJTextField.setBounds(92, 392, 90, 20);
        taxJTextField.setEditable(false);
        taxJTextField.setBorder(
                BorderFactory.createLoweredBevelBorder());
        taxJTextField.setHorizontalAlignment(JTextField.RIGHT);
        contentPane.add(taxJTextField);

        // set up totalJLabel
        // JLabel and JTextField for total
        JLabel totalJLabel = new JLabel();
        totalJLabel.setBounds(28, 424, 56, 16);
        totalJLabel.setText("Total:");
        contentPane.add(totalJLabel);

        // set up totalJTextField
        totalJTextField = new JTextField();
        totalJTextField.setBounds(92, 424, 90, 20);
        totalJTextField.setEditable(false);
        totalJTextField.setBorder(
                BorderFactory.createLoweredBevelBorder());
        totalJTextField.setHorizontalAlignment(JTextField.RIGHT);
        contentPane.add(totalJTextField);

        // set properties of application's window
        setTitle("Restaurant Bill Calculator"); // set window title
        setSize(280, 500); // set window size
        setVisible(true);  // display window

        // ensure database connection is closed
        // when user quits application
        addWindowListener(

                new WindowAdapter() // anonymous inner class
                {
                    // event handler called when close button is clicked
                    public void windowClosing(WindowEvent event) {
                        frameWindowClosing();
                    }

                } // end anonymous inner class

        ); // end addWindowListener

    } // end method createUserInterface

    // set up waiterJPanel
    private void createWaiterJPanel() {
        // set up waiterJPanel
        waiterJPanel = new JPanel();
        waiterJPanel.setBounds(20, 48, 232, 88);
        waiterJPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(),
                "Waiter Information"));
        waiterJPanel.setLayout(null);

        // set up tableNumberJLabel
        // JLabel and JTextField for table number
        JLabel tableNumberJLabel = new JLabel();
        tableNumberJLabel.setBounds(35, 24, 90, 16);
        tableNumberJLabel.setText("Table number:");
        waiterJPanel.add(tableNumberJLabel);

        // set up tableNumberJTextField
        tableNumberJTextField = new JTextField();
        tableNumberJTextField.setBounds(128, 24, 88, 21);
        waiterJPanel.add(tableNumberJTextField);

        // set up waiterNameJLabel
        // JLabel and JTextField for waiter name
        JLabel waiterNameJLabel = new JLabel();
        waiterNameJLabel.setBounds(35, 56, 90, 16);
        waiterNameJLabel.setText("Waiter name:");
        waiterJPanel.add(waiterNameJLabel);

        // set up waiterNameJTextField
        waiterNameJTextField = new JTextField();
        waiterNameJTextField.setBounds(128, 56, 88, 21);
        waiterJPanel.add(waiterNameJTextField);

    } // end method createWaiterJPanel

    // create menuItemsJPanel
    private void createMenuItemsJPanel() {
        // set up menuItemsJPanel
        menuItemsJPanel = new JPanel();
        menuItemsJPanel.setBounds(20, 152, 232, 152);
        menuItemsJPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Menu Items"));
        menuItemsJPanel.setLayout(null);

        // set up beverageJLabel
        // JLabel and JComboBox for beverage
        JLabel beverageJLabel = new JLabel();
        beverageJLabel.setBounds(8, 24, 80, 24);
        beverageJLabel.setText("Beverage:");
        menuItemsJPanel.add(beverageJLabel);

        // set up beverageJComboBox
        beverageJComboBox = new JComboBox<>();
        beverageJComboBox.setBounds(88, 24, 128, 25);
        menuItemsJPanel.add(beverageJComboBox);
        // anonymous inner class
        // event handler called when item in beverageJComboBox is selected
        beverageJComboBox.addItemListener(

                this::beverageJComboBoxItemStateChanged // end anonymous inner class

        ); // end addItemListener

        // add items to beverageJComboBox
        beverageJComboBox.addItem("");
        loadCategory("Beverage", beverageJComboBox);

        // set up appetizerJLabel
        // JLabel and JComboBox for appetizer
        JLabel appetizerJLabel = new JLabel();
        appetizerJLabel.setBounds(8, 56, 80, 24);
        appetizerJLabel.setText("Appetizer:");
        menuItemsJPanel.add(appetizerJLabel);

        // set up appetizerJComboBox
        appetizerJComboBox = new JComboBox<>();
        appetizerJComboBox.setBounds(88, 56, 128, 25);
        menuItemsJPanel.add(appetizerJComboBox);
        // anonymous inner class
        // event handler called when item in appetizerJComboBox is selected
        appetizerJComboBox.addItemListener(

                this::appetizerJComboBoxItemStateChanged // end anonymous inner class

        ); // end addItemListener

        // add items to appetizerJComboBox
        appetizerJComboBox.addItem("");
        loadCategory("Appetizer", appetizerJComboBox);

        // set up mainCourseJLabel
        // JLabel and JComboBox for main course
        JLabel mainCourseJLabel = new JLabel();
        mainCourseJLabel.setText("Main Course:");
        mainCourseJLabel.setBounds(8, 88, 80, 24);
        menuItemsJPanel.add(mainCourseJLabel);

        // set up mainCourseJComboBox
        mainCourseJComboBox = new JComboBox<>();
        mainCourseJComboBox.setBounds(88, 88, 128, 25);
        // anonymous inner class
        // event handler called when item in mainCourseJComboBox is selected
        mainCourseJComboBox.addItemListener(

                this::mainCourseJComboBoxItemStateChanged // end anonymous inner class

        ); // end addItemListener

        menuItemsJPanel.add(mainCourseJComboBox);

        // add items to mainCourseJComboBox
        mainCourseJComboBox.addItem("");
        loadCategory("Main Course", mainCourseJComboBox);

        // set up dessertJLabel
        // JLabel and JComboBox for dessert
        JLabel dessertJLabel = new JLabel();
        dessertJLabel.setBounds(8, 120, 80, 24);
        dessertJLabel.setText("Dessert:");
        menuItemsJPanel.add(dessertJLabel);

        // set up dessertJComboBox
        dessertJComboBox = new JComboBox<>();
        dessertJComboBox.setBounds(88, 120, 128, 25);
        menuItemsJPanel.add(dessertJComboBox);
        // anonymous inner class
        // event handler called when item in dessertJComboBox is selected
        dessertJComboBox.addItemListener(

                this::dessertJComboBoxItemStateChanged // end anonymous inner class

        ); // end addItemListener

        // add items to dessertJComboBox
        dessertJComboBox.addItem("");
        loadCategory("Dessert", dessertJComboBox);

    } // end method createMenuItemsJPanel

    // add items to JComboBox
    private void loadCategory(
            String category, JComboBox<String> categoryJComboBox) {
        // read all items from database for specified category
        try {
            // execute query to obtain all items in specified category
            myResultSet = myStatement.executeQuery("SELECT name FROM "
                    + "menu WHERE category = '" + category + "'");

            // add items to JComboBox
            while (myResultSet.next()) {
                categoryJComboBox.addItem(
                        myResultSet.getString("name"));
            }

            myResultSet.close(); // close myResultSet

        } // end try
        catch (SQLException exception) {
            exception.printStackTrace();
        }

    } // end method loadCategory

    // user select beverage
    private void beverageJComboBoxItemStateChanged(ItemEvent event) {
        // select an item
        if (event.getStateChange() == ItemEvent.SELECTED) {
            billItems.add(
                    (String) beverageJComboBox.getSelectedItem());
        }

    } // end method beverageJComboBoxItemStateChanged

    // user select appetizer
    private void appetizerJComboBoxItemStateChanged(ItemEvent event) {
        // select an item
        if (event.getStateChange() == ItemEvent.SELECTED) {
            billItems.add(
                    (String) appetizerJComboBox.getSelectedItem());
        }

    } // end method appetizerJComboBoxItemStateChanged

    // user select main course
    private void mainCourseJComboBoxItemStateChanged(
            ItemEvent event) {
        // select an item
        if (event.getStateChange() == ItemEvent.SELECTED) {
            billItems.add(
                    (String) mainCourseJComboBox.getSelectedItem());
        }

    } // end method mainCourseJComboBoxItemStateChanged

    // user select dessert
    private void dessertJComboBoxItemStateChanged(ItemEvent event) {
        // select an item
        if (event.getStateChange() == ItemEvent.SELECTED) {
            billItems.add(
                    (String) dessertJComboBox.getSelectedItem());
        }

    } // end method dessertJComboBoxItemStateChanged

    // user click Calculate Bill JButton
    private void calculateBillJButtonActionPerformed() {
        // define display format
        DecimalFormat dollars = new DecimalFormat("$0.00");

        // ensure table number and waiter name have been entered
        if ((!tableNumberJTextField.getText().equals("")) &&
                (!waiterNameJTextField.getText().equals(""))) {
            double total = calculateSubtotal();

            // display subtotal
            subtotalJTextField.setText(
                    dollars.format(total));

            // calculate and display tax
            double tax = total * TAX_RATE;
            taxJTextField.setText(dollars.format(tax));

            // display total
            totalJTextField.setText(
                    dollars.format(total + tax));
        } else // table number or waiter name has not been entered
        {
            JOptionPane.showMessageDialog(null, "Please fill in both" +
                    " Table number and Waiter name fields.");
        }

    } // end method calculateBillJButtonActionPerformed

    // calculate subtotal
    private double calculateSubtotal() {
        double total = 0;
        Object[] items = billItems.toArray();

        // get data from database
        try {
            // get price for each item in items array
            for (Object item : items) {
                // execute query to get price
                myResultSet = myStatement.executeQuery("SELECT price " +
                        "FROM menu WHERE name = '" + item +
                        "'");

                // add price of item to total
                if (myResultSet.next()) {
                    total += myResultSet.getDouble("price");
                }

                myResultSet.close(); // close myResultSet

            } // end for

        } // end try
        catch (SQLException exception) {
            exception.printStackTrace();
        }

        return total;

    } // end method calculateSubtotal

    // user close window
    private void frameWindowClosing() {
        // close myStatement and database connection
        try {
            myStatement.close();
            myConnection.close();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

    }  // end method frameWindowClosing

    // method main
    public static void main(String[] args) {
        // check command-line arguments
        if (args.length == 2) {
            // get command-line arguments
            String databaseDriver = args[0];
            String databaseURL = args[1];

            // create new RestaurantBillCalculator
            RestaurantBillCalculator application =
                    new RestaurantBillCalculator(
                            databaseDriver, databaseURL);
        } else {
            System.out.println("Usage: java " +
                    "RestaurantBillCalculator databaseDriver databaseURL");
        }

    } // end method main

} // end class RestaurantBillCalculator

package tutorial_26.StockPortfolio;// Exercise 26.11: StockPortfolio.java
// Displays a client's stock portfolio.

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.*;
import java.text.DecimalFormat;

public class StockPortfolio extends JFrame {

    // JComboBox for stock names
    private JComboBox<String> stockNamesJComboBox;

    private JTextField stockNameJTextField;

    private JTextField stockSymbolJTextField;

    private JTextField sharesJTextField;

    private JTextField priceJTextField;

    private JTextField totalJTextField;

    // instance variables for database processing
    private Connection myConnection;
    private Statement myStatement;
    private ResultSet myResultSet;

    // constructor
    public StockPortfolio(String databaseDriver, String databaseURL) {
        // attempt database connection
        try {
            // load Cloudscape driver
            Class.forName(databaseDriver);

            // connect to database
            myConnection =
                    DriverManager.getConnection(databaseURL);

            // create Statement
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

        // set up prompt1JLabel
        // JLabels for prompt
        JLabel prompt1JLabel = new JLabel();
        prompt1JLabel.setBounds(8, 16, 350, 16);
        prompt1JLabel.setText("Select the name of " +
                "the stock for which you want ");
        contentPane.add(prompt1JLabel);

        // set up prompt2JLabel
        JLabel prompt2JLabel = new JLabel();
        prompt2JLabel.setBounds(8, 32, 350, 16);
        prompt2JLabel.setText("information, and then " +
                "press the Stock Information button.");
        contentPane.add(prompt2JLabel);

        // set up stockNamesJComboBox
        stockNamesJComboBox = new JComboBox<>();
        stockNamesJComboBox.setBounds(76, 65, 200, 26);
        stockNamesJComboBox.addItem("");
        contentPane.add(stockNamesJComboBox);

        // load stock names into stockNamesJComboBox
        loadStockNames();

        // set up stockInfoJButton
        // JButton for stock information
        JButton stockInfoJButton = new JButton();
        stockInfoJButton.setBounds(100, 100, 150, 23);
        stockInfoJButton.setText("Stock Information");
        contentPane.add(stockInfoJButton);
        // anonymous inner class
        // event handler called when stockInfoJButton is clicked
        stockInfoJButton.addActionListener(

                this::stockInfoJButtonActionPerformed // end anonymous inner class

        ); // end addActionListener

        // set up stockInfoJPanel
        // JPanel for displaying stock information
        JPanel stockInfoJPanel = new JPanel();
        stockInfoJPanel.setBounds(18, 145, 300, 192);
        stockInfoJPanel.setLayout(null);
        stockInfoJPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Stock Info"));
        contentPane.add(stockInfoJPanel);

        // set up stockNameJLabel
        // JLabel and JTextField for stock name
        JLabel stockNameJLabel = new JLabel();
        stockNameJLabel.setBounds(8, 24, 150, 23);
        stockNameJLabel.setText("Stock name:");
        stockInfoJPanel.add(stockNameJLabel);

        // set up stockNameJTextField
        stockNameJTextField = new JTextField();
        stockNameJTextField.setBounds(158, 24, 125, 24);
        stockNameJTextField.setEditable(false);
        stockNameJTextField.setBorder(
                BorderFactory.createLoweredBevelBorder());
        stockNameJTextField.setHorizontalAlignment(
                JTextField.CENTER);
        stockInfoJPanel.add(stockNameJTextField);

        // set up stockSymbolJLabel
        // JLabel and JTextField for stock symbol
        JLabel stockSymbolJLabel = new JLabel();
        stockSymbolJLabel.setBounds(8, 56, 150, 23);
        stockSymbolJLabel.setText("Stock symbol:");
        stockInfoJPanel.add(stockSymbolJLabel);

        // set up stockSymbolJTextField
        stockSymbolJTextField = new JTextField();
        stockSymbolJTextField.setBounds(158, 56, 125, 24);
        stockSymbolJTextField.setEditable(false);
        stockSymbolJTextField.setBorder(
                BorderFactory.createLoweredBevelBorder());
        stockSymbolJTextField.setHorizontalAlignment(
                JTextField.CENTER);
        stockInfoJPanel.add(stockSymbolJTextField);

        // set up sharesJLabel
        // JLabel and JTextField for number of shares
        JLabel sharesJLabel = new JLabel();
        sharesJLabel.setBounds(8, 88, 150, 23);
        sharesJLabel.setText("Number of shares:");
        stockInfoJPanel.add(sharesJLabel);

        // set up sharesJTextField
        sharesJTextField = new JTextField();
        sharesJTextField.setBounds(158, 88, 125, 24);
        sharesJTextField.setEditable(false);
        sharesJTextField.setBorder(
                BorderFactory.createLoweredBevelBorder());
        sharesJTextField.setHorizontalAlignment(JTextField.CENTER);
        stockInfoJPanel.add(sharesJTextField);

        // set up priceJLabel
        // JLabel and JTextField for price of shares
        JLabel priceJLabel = new JLabel();
        priceJLabel.setBounds(8, 120, 150, 23);
        priceJLabel.setText("Price per share:");
        stockInfoJPanel.add(priceJLabel);

        // set up priceJTextField
        priceJTextField = new JTextField();
        priceJTextField.setBounds(158, 120, 125, 24);
        priceJTextField.setEditable(false);
        priceJTextField.setBorder(
                BorderFactory.createLoweredBevelBorder());
        priceJTextField.setHorizontalAlignment(JTextField.CENTER);
        stockInfoJPanel.add(priceJTextField);

        // set up totalJLabel
        // JLabel and JTextField for total value
        JLabel totalJLabel = new JLabel();
        totalJLabel.setBounds(8, 152, 150, 23);
        totalJLabel.setText("Total value:");
        stockInfoJPanel.add(totalJLabel);

        // set up totalJTextField
        totalJTextField = new JTextField();
        totalJTextField.setBounds(158, 152, 125, 24);
        totalJTextField.setEditable(false);
        totalJTextField.setBorder(
                BorderFactory.createLoweredBevelBorder());
        totalJTextField.setHorizontalAlignment(JTextField.CENTER);
        stockInfoJPanel.add(totalJTextField);

        // ensure database connection is closed
        // when user quits application
        addWindowListener(

                new WindowAdapter()  // anonymous inner class
                {
                    public void windowClosing(WindowEvent event) {
                        frameWindowClosing();
                    }

                } // end anonymous inner class

        ); // end addWindowListener

        // set properties of application's window
        setTitle("Stock Portfolio"); // set title bar string
        setSize(350, 380);           // set window size
        setVisible(true);            // display window

    } // end method createUserInterface

    // load stock names into stockNamesJComboBox
    private void loadStockNames() {
        // add stock names in database to stockNamesJComboBox
        try {
            String stockName;

            // get stock names from database
            myResultSet = myStatement.executeQuery(
                    "SELECT stockName FROM stockInformation");

            // add each stockName to stockNamesJComboBox
            while (myResultSet.next()) {
                stockName = myResultSet.getString("stockName");
                stockNamesJComboBox.addItem(stockName);
            }

            myResultSet.close(); // close myResultSet
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

    } // end method loadStockNames

    // user clicked stockInfoJButton
    private void stockInfoJButtonActionPerformed(ActionEvent event) {
        String stockName =
                (String) stockNamesJComboBox.getSelectedItem();
        stockData(stockName);

    } // end method stockInfoJButtonActionPerformed

    // retrieve stock information from database and
    // display information in corresponding JTextFields
    private void stockData(String stockName) {
        // execute query to get stock information
        try {
            // get stock information from database
            myResultSet = myStatement.executeQuery(
                    "SELECT * FROM stockInformation WHERE stockName = '" +
                            stockName + "'");

            // if record exists
            if (myResultSet.next()) {
                int shares;
                double price;
                String total;

                // display stock name and symbol
                stockNameJTextField.setText(
                        myResultSet.getString("stockName"));
                stockSymbolJTextField.setText(
                        myResultSet.getString("stockSymbol"));

                // get shares and price
                shares = myResultSet.getInt("shares");
                price = myResultSet.getDouble("price");

                myResultSet.close(); // close myResultSet

                // define display format
                DecimalFormat dollars = new DecimalFormat("$0.00");

                // display shares and price
                sharesJTextField.setText(String.valueOf(shares));
                priceJTextField.setText(
                        dollars.format(price));

                // calculate total
                total = computeTotalValue(shares, price);

                // display total
                totalJTextField.setText(total);

            } // end if

        } // end try
        catch (SQLException exception) {
            exception.printStackTrace();
        }

    } // end method stockData

    // calculate total value
    private String computeTotalValue(int shares, double price) {
        // define display format
        DecimalFormat dollars = new DecimalFormat("$0.00");

        return dollars.format(shares * price);

    } // end method computeTotalValue

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

            // create new StockPortfolio
            StockPortfolio application =
                    new StockPortfolio(databaseDriver, databaseURL);
        } else {
            System.out.println("Usage: java StockPortfolio " +
                    "databaseDriver databaseURL");
        }

    } // end method main

} // end class StockPortfolio

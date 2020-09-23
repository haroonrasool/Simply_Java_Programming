package tutorial_26.AirlineReservation;

// Exercise 26.13: AirlineReservation.java
// Displays flight information.

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class AirlineReservation extends JFrame {
    private JComboBox<String> chooseFlightJComboBox;

    // JPanel for displaying flight information
    private JPanel flightInfoJPanel;

    private JTextField dateJTextField;

    private JTextField departureCityJTextField;

    private JTextField arrivalCityJTextField;

    // JPanel and JTextArea for displaying passenger list
    private JPanel passengerListJPanel;
    private JTextArea displayJTextArea;

    // declare instance variables for database processing
    private Connection myConnection;
    private Statement myStatement;
    private ResultSet myResultSet;

    // constructor
    public AirlineReservation(
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

        // set up chooseFlightJLabel
        // JLabel and JComboBox for Choose a Flight
        JLabel chooseFlightJLabel = new JLabel();
        chooseFlightJLabel.setBounds(24, 16, 100, 16);
        chooseFlightJLabel.setText("Choose a Flight:");
        contentPane.add(chooseFlightJLabel);

        // set up chooseFlightJComboBox
        chooseFlightJComboBox = new JComboBox<>();
        chooseFlightJComboBox.setBounds(130, 16, 72, 25);
        chooseFlightJComboBox.addItem("");
        contentPane.add(chooseFlightJComboBox);

        // load flight numbers into chooseFlightJComboBox
        loadFlightNumbers();

        // set up flightInfoJButton
        // JButton for View Flight Information
        JButton flightInfoJButton = new JButton();
        flightInfoJButton.setBounds(230, 16, 150, 30);
        flightInfoJButton.setText("View Flight Information");
        flightInfoJButton.setBorder(
                BorderFactory.createRaisedBevelBorder());
        contentPane.add(flightInfoJButton);
        // anonymous inner class
        // event handler called when flightInfoJButton is clicked
        flightInfoJButton.addActionListener(

                this::flightInfoJButtonActionPerformed // end anonymous inner class

        ); // end addActionListener

        // set up flightInformationJPanel
        createFlightInfoJPanel();
        contentPane.add(flightInfoJPanel);

        // set properties of application's window
        setTitle("Airline Reservation"); // set title bar string
        setSize(410, 250);               // set window size
        setVisible(true);                // display window

        // ensure database connection is closed
        // when user quits application
        addWindowListener(

                new WindowAdapter()  // anonymous inner class
                {
                    // event handler called when close button is clicked
                    public void windowClosing(WindowEvent event) {
                        frameWindowClosing();
                    }

                } // end anonymous inner class

        ); // end addWindowListener

    } // end method createUserInterface

    // set up flightInformationJPanel
    private void createFlightInfoJPanel() {
        // set up flightInfoJPanel
        flightInfoJPanel = new JPanel();
        flightInfoJPanel.setBounds(15, 56, 370, 152);
        flightInfoJPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(),
                "Flight Information"));
        flightInfoJPanel.setLayout(null);

        // set up dateJLabel
        // JLabel and JTextField for Date
        JLabel dateJLabel = new JLabel();
        dateJLabel.setBounds(16, 32, 100, 16);
        dateJLabel.setText("Date:");
        flightInfoJPanel.add(dateJLabel);

        // set up dateJTextField
        dateJTextField = new JTextField();
        dateJTextField.setBounds(116, 32, 88, 20);
        dateJTextField.setEditable(false);
        dateJTextField.setBorder(
                BorderFactory.createLoweredBevelBorder());
        flightInfoJPanel.add(dateJTextField);

        // set up departureCityJLabel
        // JLabel and JTextField for Departure City
        JLabel departureCityJLabel = new JLabel();
        departureCityJLabel.setBounds(16, 64, 100, 16);
        departureCityJLabel.setText("Departure City:");
        flightInfoJPanel.add(departureCityJLabel);

        // set up departureCityJTextField
        departureCityJTextField = new JTextField();
        departureCityJTextField.setBounds(116, 64, 88, 20);
        departureCityJTextField.setEditable(false);
        departureCityJTextField.setBorder(
                BorderFactory.createLoweredBevelBorder());
        flightInfoJPanel.add(departureCityJTextField);

        // set up arrivalCityJLabel
        // JLabel and JTextField for Arrival City
        JLabel arrivalCityJLabel = new JLabel();
        arrivalCityJLabel.setBounds(16, 96, 100, 16);
        arrivalCityJLabel.setText("Arrival City:");
        flightInfoJPanel.add(arrivalCityJLabel);

        // set up arrivalCityJTextField
        arrivalCityJTextField = new JTextField();
        arrivalCityJTextField.setBounds(116, 96, 88, 20);
        arrivalCityJTextField.setEditable(false);
        arrivalCityJTextField.setBorder(
                BorderFactory.createLoweredBevelBorder());
        flightInfoJPanel.add(arrivalCityJTextField);

        // set up passengerListJPanel
        createPassengerListJPanel();
        flightInfoJPanel.add(passengerListJPanel);

    } // end method createFlightInfoJPanel

    // set up passengerListJPanel
    private void createPassengerListJPanel() {
        // set up passengerListJPanel
        passengerListJPanel = new JPanel();
        passengerListJPanel.setBounds(220, 16, 128, 120);
        passengerListJPanel.setBorder(
                BorderFactory.createTitledBorder(
                        BorderFactory.createEtchedBorder(),
                        "Passenger List"));
        passengerListJPanel.setLayout(null);

        // set up displayJTextArea
        displayJTextArea = new JTextArea();
        displayJTextArea.setBounds(16, 24, 96, 82);
        displayJTextArea.setEditable(false);
        displayJTextArea.setBorder(
                BorderFactory.createLoweredBevelBorder());
        passengerListJPanel.add(displayJTextArea);

    } // end method createPassengerListJPanel

    // load flight numbers into chooseFlightJComboBox
    private void loadFlightNumbers() {
        // read flight numbers from database
        try {
            // execute query to obtain all flight numbers
            myResultSet = myStatement.executeQuery(
                    "SELECT flightNumber FROM flights");

            // add items to combo box
            while (myResultSet.next()) {
                chooseFlightJComboBox.addItem(
                        myResultSet.getString("flightNumber"));
            }

            myResultSet.close(); // close myResultSet

        } // end try
        catch (SQLException exception) {
            exception.printStackTrace();
        }

    } // end method loadFlightNumbers

    // user click View Flight Information JButton
    private void flightInfoJButtonActionPerformed(ActionEvent event) {
        // get selected flight number
        String flightNumber =
                (String) chooseFlightJComboBox.getSelectedItem();

        // display flight information
        displayFlightInformation(flightNumber);

    } // end flightInfoJButtonActionPerformed

    // display flight information
    private void displayFlightInformation(String flightNumber) {
        // display flight date, departure city and arrival city
        // display passenger list
        try {
            // get flight date, departure city and arrival city
            myResultSet = myStatement.executeQuery("SELECT flightDate,"
                    + " departureCity, arrivalCity FROM flights WHERE " +
                    "flightNumber = " + Integer.parseInt(flightNumber));

            // non-empty result
            if (myResultSet.next()) {
                dateJTextField.setText(
                        myResultSet.getString("flightDate"));
                departureCityJTextField.setText(
                        myResultSet.getString("departureCity"));
                arrivalCityJTextField.setText(
                        myResultSet.getString("arrivalCity"));
            }

            myResultSet.close(); // close myResultSet

            // get passenger list
            myResultSet = myStatement.executeQuery(
                    "SELECT lastName, firstName FROM reservations WHERE " +
                            "flightNumber = " + Integer.parseInt(flightNumber));

            displayJTextArea.setText(""); // clear displayJTextArea

            // display passenger list
            while (myResultSet.next()) {
                displayJTextArea.append(
                        myResultSet.getString("lastName") + ", " +
                                myResultSet.getString("firstName") + "\n");
            }

            myResultSet.close(); // close myResultSet

        } // end try
        catch (SQLException exception) {
            exception.printStackTrace();
        }

    } // end method displayFlightInformation

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

    // main method
    public static void main(String[] args) {
        // check command-line arguments
        if (args.length == 2) {
            // get command-line arguments
            String databaseDriver = args[0];
            String databaseURL = args[1];

            // create new AirlineReservation
            AirlineReservation application = new AirlineReservation(
                    databaseDriver, databaseURL);
        } else {
            System.out.println("Usage: java AirlineReservation " +
                    "databaseDriver databaseURL");
        }

    } // end method main

} // end class AirlineReservation

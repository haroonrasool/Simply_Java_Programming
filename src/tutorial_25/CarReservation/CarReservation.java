package tutorial_25.CarReservation;// Exercise 25.15: CarReservation.java
// This application allows users to input their names and
// reserve cars on various days.

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.*;
import java.util.Date;

public class CarReservation extends JFrame {
    private JSpinner dateJSpinner;

    private JTextField nameJTextField;

    // JButton to reserve car
    private JButton reserveCarJButton;

    // no-argument constructor
    public CarReservation() {
        createUserInterface();
    }

    // create and position GUI components
    public void createUserInterface() {
        // get content pane for attaching GUI components
        Container contentPane = getContentPane();

        // enable explicit positioning of GUI components
        contentPane.setLayout(null);

        // set up selectDateJLabel
        // JLabel and JSpinner to display date
        JLabel selectDateJLabel = new JLabel();
        selectDateJLabel.setBounds(16, 16, 96, 23);
        selectDateJLabel.setText("Select the date:");
        contentPane.add(selectDateJLabel);

        // set up dateJSpinner
        dateJSpinner = new JSpinner(new SpinnerDateModel());
        dateJSpinner.setBounds(16, 43, 250, 23);
        dateJSpinner.setEditor(new JSpinner.DateEditor(
                dateJSpinner, "MM/dd/yyyy"));
        contentPane.add(dateJSpinner);
        // anonymous inner class
        // event handler called when dateJSpinner is changed
        dateJSpinner.addChangeListener(

                event -> dateJSpinnerChanged() // end anonymous inner class

        ); // end call to addActionListener

        // set up nameJLabel
        // JLabel and JTextField to display name
        JLabel nameJLabel = new JLabel();
        nameJLabel.setBounds(16, 70, 100, 23);
        nameJLabel.setText("Name: ");
        contentPane.add(nameJLabel);

        // set up nameJTextField
        nameJTextField = new JTextField();
        nameJTextField.setBounds(16, 97, 250, 23);
        contentPane.add(nameJTextField);

        // set up reserveCarJButton
        reserveCarJButton = new JButton();
        reserveCarJButton.setBounds(16, 130, 250, 23);
        reserveCarJButton.setText("Reserve Car");
        contentPane.add(reserveCarJButton);
        // anonymous inner class
        // event handler called when reserveCarJButton is clicked
        reserveCarJButton.addActionListener(

                this::reserveCarJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set properties of application's window
        setTitle("Car Reservation"); // set title bar string
        setSize(287, 190);           // set window size
        setVisible(true);            // display window

    } // end method createUserInterface

    // write reservation to a file
    private void reserveCarJButtonActionPerformed(ActionEvent event) {
        File reserveFile = new File("src/tutorial_25/CarReservation/reservations.txt");

        // read reservations from, and write a reservation to, a file
        try {
            // create buffered reader to open and read text file
            FileReader inputFile = new FileReader(reserveFile);
            // BufferedReader and PrintWriter to allow
            // reading from, and writing to, a file
            BufferedReader input = new BufferedReader(inputFile);

            // get selected date
            Date fullDate = (Date) dateJSpinner.getValue();
            String currentDate = fullDate.toString();
            String monthDay = currentDate.substring(0, 10);
            String year = currentDate.substring(24, 28);
            currentDate = monthDay + " " + year;

            int dateCount = 1;
            String contents = input.readLine();

            // check if too many cars are reserved
            while (contents != null) {
                // check reservation date
                if (contents.equals(currentDate)) {
                    // check reservation number
                    if (dateCount < 4) {
                        dateCount++;
                    } else {
                        JOptionPane.showMessageDialog(this, "Too many " +
                                        "cars have already been reserved for that day.",
                                "Sorry", JOptionPane.INFORMATION_MESSAGE);

                        // disable reserveCarJButton
                        reserveCarJButton.setEnabled(false);

                        return; // exit method
                    }

                } // end if

                contents = input.readLine(); // read next line

            } // end while

            input.close(); // close BufferedReader

            // create PrintWriter to open and write text file
            FileWriter outputFile = new FileWriter(reserveFile, true);
            PrintWriter output = new PrintWriter(outputFile);

            // write user input to file
            output.println(currentDate);
            output.println(nameJTextField.getText());

            JOptionPane.showMessageDialog(this,
                    "Your car has been reserved.", "Thank you",
                    JOptionPane.INFORMATION_MESSAGE);

            output.close(); // close PrintWriter

        } // end try
        catch (IOException exception) {
            JOptionPane.showMessageDialog(this, "Invalid file.",
                    "Error", JOptionPane.ERROR_MESSAGE);

            // disable dateJSpinner and reserveCarJButton
            dateJSpinner.setEnabled(false);
            reserveCarJButton.setEnabled(false);
        }

        nameJTextField.setText("");

    } // end method reserveCarJButtonActionPerformed

    // enable reserveCarJButton
    private void dateJSpinnerChanged() {
        reserveCarJButton.setEnabled(true);

    } // end method dateJSpinnerChanged

    // main method
    public static void main(String[] args) {
        CarReservation application = new CarReservation();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    } // end method main

} // end class CarReservation

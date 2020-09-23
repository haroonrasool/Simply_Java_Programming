package tutorial_8;

// Exercise 8.11: TableOfPowers.java
// Displays a table of powers up to a given limit.

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TableOfPowers extends JFrame {
    private JTextField limitJTextField;

    // JTextArea for displaying results
    private JTextArea outputJTextArea;

    // no-argument constructor
    public TableOfPowers() {
        createUserInterface();
    }

    // main method
    public static void main(String[] args) {
        TableOfPowers application = new TableOfPowers();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } // end method main

    // create and position GUI components; register event handlers
    private void createUserInterface() {
        // get content pane for attaching GUI components
        Container contentPane = getContentPane();

        // enable explicit positioning of GUI components
        contentPane.setLayout(null);

        // set up limitJLabel
        // JLabel and JTextField for limit of loop counter
        JLabel limitJLabel = new JLabel();
        limitJLabel.setBounds(16, 16, 70, 26);
        limitJLabel.setText("Upper limit:");
        contentPane.add(limitJLabel);

        // set up limitJTextField
        limitJTextField = new JTextField();
        limitJTextField.setBounds(120, 16, 59, 26);
        limitJTextField.setHorizontalAlignment(JTextField.CENTER);
        contentPane.add(limitJTextField);
        limitJTextField.addKeyListener(

                new KeyAdapter() // anonymous inner class
                {
                    // event handler called if key pressed in limitJTextField
                    public void keyPressed(KeyEvent event) {
                        limitJTextFieldKeyPressed();
                    }

                } // end anonymous inner class

        ); // end call to addKeyListener

        // set up calculateJButton
        // JButton to initiate calculations
        JButton calculateJButton = new JButton();
        calculateJButton.setBounds(195, 16, 100, 26);
        calculateJButton.setText("Calculate");
        contentPane.add(calculateJButton);
        // anonymous inner class
        // event handler called when user clicks calculateJButton
        calculateJButton.addActionListener(

                this::calculateJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set up outputJTextArea
        outputJTextArea = new JTextArea();
        outputJTextArea.setEditable(false);

        // create JScrollPane that provides scrolling
        // for outputJTextArea
        JScrollPane scrollJScrollPane =
                new JScrollPane(outputJTextArea);
        scrollJScrollPane.setBounds(16, 56, 280, 195);
        contentPane.add(scrollJScrollPane);

        // set properties of application's window
        setTitle("Table Of Powers"); // set title bar text
        setSize(330, 300);           // set window's size
        setVisible(true);            // display window

    } // end method createUserInterface

    // called when user presses key in limitJTextField
    private void limitJTextFieldKeyPressed() {
        // clear outputJTextArea
        outputJTextArea.setText("");
    }

    // called when user clicks calculateJButton
    private void calculateJButtonActionPerformed(ActionEvent event) {
        // clearJTextArea();
        outputJTextArea.setText("");

        // declaring and initializing the counter
        int number = 1;
        int square;
        int cube;

        // retrieving the user input and storing it in a variable
        int limit = Integer.parseInt(limitJTextField.getText()); // null pointer exception

        // adding a header to outputJTextArea
        outputJTextArea.append("Number\tSquare\tCube");

        // calculating the powers from 1 to the specified upper limit
        // while loop to calculate the squares and cubes
        while (number <= limit) {
            square = number * number;
            cube = number * number * number;

            // insert result into outputJTextArea
            outputJTextArea.append("\n" + number + "\t" + square + "\t" + cube);

            // increment the counter
            number++;
        }

    } // end method calculateJButtonActionPerformed

} // end class TableOfPowers

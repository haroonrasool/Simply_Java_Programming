package tutorial_9;

// Exercise 9.16: Factorial.java
// This application accepts an integer and finds its factorial

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Factorial extends JFrame {
    private JTextField enterNumberJTextField;

    private JTextField factorialJTextField;

    // no-argument constructor
    public Factorial() {
        createUserInterface();
    }

    // main method
    public static void main(String[] args) {
        Factorial application = new Factorial();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } // end method main

    // create and position GUI components; register event handlers
    private void createUserInterface() {
        // get content pane for attaching GUI components
        Container contentPane = getContentPane();

        // enable explicit positioning of GUI components
        contentPane.setLayout(null);

        // set up enterNumberJLabel
        // JLabel and JTextField for input
        JLabel enterNumberJLabel = new JLabel();
        enterNumberJLabel.setBounds(16, 16, 80, 23);
        enterNumberJLabel.setText("Enter number:");
        contentPane.add(enterNumberJLabel);

        // set up factorialJLabel
        // JLabel and JTextField for displaying factorial
        JLabel factorialJLabel = new JLabel();
        factorialJLabel.setBounds(16, 56, 72, 23);
        factorialJLabel.setText("Factorial:");
        contentPane.add(factorialJLabel);

        // set up factorialJTextField
        factorialJTextField = new JTextField();
        factorialJTextField.setBounds(112, 56, 104, 23);
        factorialJTextField.setEditable(false);
        contentPane.add(factorialJTextField);

        // set up enterNumberJTextField
        enterNumberJTextField = new JTextField();
        enterNumberJTextField.setBounds(112, 16, 104, 23);
        contentPane.add(enterNumberJTextField);

        // set up calculateJButton
        // JButton initiates calculation of factorial
        JButton calculateJButton = new JButton();
        calculateJButton.setBounds(112, 96, 104, 26);
        calculateJButton.setText("Calculate");
        contentPane.add(calculateJButton);
        // anonymous inner class
        // event handler called when calculateJButton is pressed
        calculateJButton.addActionListener(

                this::calculateJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set properties of application's window
        setTitle("Factorial"); // set title bar text
        setSize(250, 180);     // set window size
        setVisible(true);      // display window

    } // end method createUserInterface

    // method to calculate factorial based on input
    private void calculateJButtonActionPerformed(ActionEvent event) {
        int counter;
        int factorial = 1;

        // retrieve user input, use as counter
        counter = Integer.parseInt(enterNumberJTextField.getText());

        do { // find factorial
            factorial *= counter;
            counter--; // decrease the counter by 1 with each iteration
        }
        while (counter >= 1);

        // display value in factorialJTextField
        factorialJTextField.setText(String.valueOf(factorial));

    } // end method calculateJButtonActionPerformed

} // end class Factorial

package tutorial_4;

// Exercise 4.12: Counter.java
// This application displays a number which increments each time the
// Count JButton is pressed.

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Counter extends JFrame {
    // JTextField for displaying total count
    private JTextField countJTextField;

    // no-argument constructor
    public Counter() {
        createUserInterface();
    }

    // main method
    public static void main(String[] args) {
        Counter application = new Counter();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } // end method main

    // create and position GUI components; register event handler
    private void createUserInterface() {
        // get content pane and set layout to null
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        // set up countJTextField
        countJTextField = new JTextField();
        countJTextField.setText("0");
        countJTextField.setHorizontalAlignment(JTextField.CENTER);
        countJTextField.setBounds(24, 24, 88, 21);
        countJTextField.setEditable(false);
        contentPane.add(countJTextField);

        // set up countJButton
        // JButton to initiate adding one to numeric value in JTextField
        JButton countJButton = new JButton();
        countJButton.setBounds(24, 64, 88, 24);
        countJButton.setText("Count");
        contentPane.add(countJButton);
        // anonymous inner class
        // event handler called when countJButton is pressed
        countJButton.addActionListener(

                this::countJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set properties of application�s window
        setTitle("Counter"); // set title bar text
        setSize(144, 136); // set window size
        setVisible(true); // display window

    } // end method createUserInterface

    // increment the count each time countJButton is pressed
    private void countJButtonActionPerformed(ActionEvent event) {
        // increment the value in the text field and sore it in a variable.
        int count = 1 + Integer.parseInt(countJTextField.getText());
        // cast the value of Counter into a String and set the incremented value in the text field.
        countJTextField.setText(String.valueOf(count));
    } // end method countJButtonActionPerformed

} // end class Counter

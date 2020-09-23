package tutorial_16;

// Tutorial 16: SumArray.java
// Sum the values in an array and display it.

import javax.swing.*;
import java.awt.*;

public class SumArray extends JFrame {
    private JTextField totalJTextField;

    // no-argument constructor
    public SumArray() {
        createUserInterface();
    }

    // main method
    public static void main(String[] args) {
        SumArray application = new SumArray();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } // end method main

    // create and position GUI components; register event handlers
    private void createUserInterface() {
        // get content pane for attaching GUI components
        Container contentPane = getContentPane();

        // enable explicit positioning of GUI components
        contentPane.setLayout(null);

        // set up totalJLabel
        // JLabel and JTextField for number of array elements
        JLabel totalJLabel = new JLabel();
        totalJLabel.setBounds(10, 16, 135, 23);
        totalJLabel.setText("Total of array elements:");
        contentPane.add(totalJLabel);

        // set up totalJTextField
        totalJTextField = new JTextField();
        totalJTextField.setBounds(152, 16, 24, 23);
        totalJTextField.setEditable(false);
        totalJTextField.setHorizontalAlignment(JLabel.RIGHT);
        contentPane.add(totalJTextField);

        // set up sumArrayJButton
        // JButton to sum the array
        JButton sumArrayJButton = new JButton();
        sumArrayJButton.setBounds(50, 56, 100, 23);
        sumArrayJButton.setText("Sum Array");
        contentPane.add(sumArrayJButton);
        // anonymous inner class
        // event handler called when sumArrayJButton is pressed
        sumArrayJButton.addActionListener(

                event -> sumArrayJButtonActionPerformed() // end anonymous inner class

        ); // end call to addActionListener

        // set properties of application's window
        setTitle("Sum of Array"); // set title bar string
        setSize(200, 140);     // set window size
        setVisible(true);      // display window

    } // end method createUserInterface

    // method called to determine sum of array
    private void sumArrayJButtonActionPerformed() {
        // declare and initialize array
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int total = 0;

        // sum the array elements by enhanced for loop
        for (int index : array) {
            total += index;
        }

        // sum the array elements by a simple for loop
//        for (int index = 0; index < array.length; index++) {
//            total += array[index];
//        }

        totalJTextField.setText(String.valueOf(total));

    } // end method sumArrayJButtonActionPerformed

} // end class SumArray

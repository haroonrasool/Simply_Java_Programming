package tutorial_8;

// Exercise 8.16: OddNumbers.java
// Displays a table of odd numbers up to a given limit.

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class OddNumbers extends JFrame {
    private JTextField limitJTextField;

    // JTextArea to display results
    private JTextArea outputJTextArea;

    // no-argument constructor
    public OddNumbers() {
        createUserInterface();
    }

    // main method
    public static void main(String[] args) {
        OddNumbers application = new OddNumbers();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } // end method main

    // create and position the GUI components; register event handlers
    public void createUserInterface() {
        // get content pane for attaching GUI components
        Container contentPane = getContentPane();

        // enable explicit positioning of GUI components
        contentPane.setLayout(null);

        // set up limitJLabel
        // JLabel and JTextField to input limit
        JLabel limitJLabel = new JLabel();
        limitJLabel.setBounds(16, 16, 70, 26);
        limitJLabel.setText("Upper limit:");
        contentPane.add(limitJLabel);

        // set up limitJTextField
        limitJTextField = new JTextField();
        limitJTextField.setBounds(96, 16, 55, 26);
        limitJTextField.setHorizontalAlignment(JTextField.CENTER);
        contentPane.add(limitJTextField);

        // set up viewJButton
        // JButton to initiate display of odd integers
        JButton viewJButton = new JButton();
        viewJButton.setBounds(168, 16, 90, 26);
        viewJButton.setText("View");
        contentPane.add(viewJButton);
        // anonymous inner class
        // event handler called when user clicks viewJButton
        viewJButton.addActionListener(

                this::viewJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set up outputJTextArea
        outputJTextArea = new JTextArea();
        outputJTextArea.setEditable(false);

        // set up scrollJScrollPane to allow outputJTextArea scrolling
        JScrollPane scrollJScrollPane = new JScrollPane(outputJTextArea);
        scrollJScrollPane.setBounds(16, 56, 242, 95);
        contentPane.add(scrollJScrollPane);

        // set properties of application's window
        setTitle("Odd Numbers"); // set title bar text
        setSize(250, 192); // set windows's size
        setVisible(true); // display window

    } // end method createUserInterface

    // called when user clicks viewJButton
    public void viewJButtonActionPerformed(ActionEvent event) {
        // retrieving the limit from limitJTextField.
        int upperLimit = Integer.parseInt(limitJTextField.getText());

        // initializing the counter.
        int counter = 1;

        // display header
        outputJTextArea.setText("Odd numbers:");

        // while loop to iterate the counter from 1 to maximum limit set
        while (counter <= upperLimit) {
            if (counter % 2 == 1) { // for even numbers: counter % 2 == 0
                outputJTextArea.append("\n" + counter);
            }
            counter++;
        } // end of while loop

    } // end method viewJButtonActionPerformed

} // end class OddNumbers

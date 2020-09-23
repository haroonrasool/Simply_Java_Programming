package tutorial_12;

// Tutorial 12: Maximum.java
// Program finds and displays the greatest value entered by the user.

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Maximum extends JFrame {
    private JTextField firstValueJTextField;

    private JTextField secondValueJTextField;

    private JTextField thirdValueJTextField;

    private JTextField maximumJTextField;

    // no-argument constructor
    public Maximum() {
        createUserInterface();
    }

    // main method
    public static void main(String[] args) {
        Maximum application = new Maximum();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } // end method main

    // create and position GUI components; register event handlers
    private void createUserInterface() {
        // get content pane for attaching GUI components
        Container contentPane = getContentPane();

        // enable explicit positioning of GUI components
        contentPane.setLayout(null);

        // set up firstValueJLabel
        // JLabel and JTextField for first value
        JLabel firstValueJLabel = new JLabel();
        firstValueJLabel.setBounds(16, 16, 100, 24);
        firstValueJLabel.setText("First value:");
        contentPane.add(firstValueJLabel);

        // set up firstValueJTextField
        firstValueJTextField = new JTextField();
        firstValueJTextField.setBounds(104, 16, 90, 24);
        firstValueJTextField.setHorizontalAlignment(JTextField.RIGHT);
        contentPane.add(firstValueJTextField);

        // set up secondValueJLabel
        // JLabel and JTextField for second value
        JLabel secondValueJLabel = new JLabel();
        secondValueJLabel.setBounds(16, 56, 120, 24);
        secondValueJLabel.setText("Second value:");
        contentPane.add(secondValueJLabel);

        // set up secondValueJTextField
        secondValueJTextField = new JTextField();
        secondValueJTextField.setBounds(104, 56, 90, 24);
        secondValueJTextField.setHorizontalAlignment(JTextField.RIGHT);
        contentPane.add(secondValueJTextField);

        // set up thirdValueJLabel
        // JLabel and JTextField for third value
        JLabel thirdValueJLabel = new JLabel();
        thirdValueJLabel.setBounds(16, 96, 120, 24);
        thirdValueJLabel.setText("Third value:");
        contentPane.add(thirdValueJLabel);

        // set up thirdValueJTextField
        thirdValueJTextField = new JTextField();
        thirdValueJTextField.setBounds(104, 96, 90, 24);
        thirdValueJTextField.setHorizontalAlignment(JTextField.RIGHT);
        contentPane.add(thirdValueJTextField);

        // set up maximumJLabel
        // JLabel and JTextField for maximum of three values entered
        JLabel maximumJLabel = new JLabel();
        maximumJLabel.setBounds(16, 152, 100, 24);
        maximumJLabel.setText("Maximum:");
        contentPane.add(maximumJLabel);

        // set up maximumJTextField
        maximumJTextField = new JTextField();
        maximumJTextField.setBounds(104, 152, 90, 24);
        maximumJTextField.setHorizontalAlignment(JTextField.CENTER);
        maximumJTextField.setEditable(false);
        contentPane.add(maximumJTextField);

        // set up maximumJButton
        // JButton initiates finding the maximum value
        JButton maximumJButton = new JButton();
        maximumJButton.setBounds(104, 192, 90, 24);
        maximumJButton.setText("Maximum");
        contentPane.add(maximumJButton);
        // anonymous inner class
        // event handler called when maximumJButton is pressed
        maximumJButton.addActionListener(

                this::maximumJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set properties of application's window
        setTitle("Maximum"); // set title bar string
        setSize(220, 258);   // set window size
        setVisible(true);    // display window

    } // end method createUserInterface

    // get user input, call method maximum, and display the maximum
    private void maximumJButtonActionPerformed(ActionEvent event) {
        // convert user input to double
        double first = Double.parseDouble(firstValueJTextField.getText());
        double second = Double.parseDouble(secondValueJTextField.getText());
        double third = Double.parseDouble(thirdValueJTextField.getText());

        // call method to find maximum of three values
        double maximum = determineMaximum(first, second, third);
        maximumJTextField.setText(String.valueOf(maximum));
    } // end method maximumJButtonActionPerformed

    // returns the largest of three values
    private double determineMaximum(double one, double two, double three) {
        double max = Math.max(one, two);
        return Math.max(max, three);
    } // end method determineMaximum
} // end class Maximum

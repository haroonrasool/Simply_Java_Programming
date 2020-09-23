package tutorial_5;
// Exercise 5.16: Average.java
// Application that finds the average of three integers.

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class AverageOfThreeNumbers extends JFrame {
    private JTextField firstNumberJTextField;

    private JTextField secondNumberJTextField;

    private JTextField thirdNumberJTextField;

    private JTextField averageJTextField;

    // no-argument constructor
    public AverageOfThreeNumbers() {
        createUserInterface();
    }

    // main method
    public static void main(String[] args) {
        AverageOfThreeNumbers application = new AverageOfThreeNumbers();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } // end method main

    // create and position GUI components; register event handlers
    private void createUserInterface() {
        // get content pane for attaching GUI components
        Container contentPane = getContentPane();

        // enable explicit positioning of GUI components
        contentPane.setLayout(null);

        // set up firstNumberJLabel
        // JLabel and JTextField for user to input first number
        JLabel firstNumberJLabel = new JLabel();
        firstNumberJLabel.setText("Enter first number:");
        firstNumberJLabel.setBounds(20, 20, 125, 20);
        contentPane.add(firstNumberJLabel);

        // set up firstNumberJTextField
        firstNumberJTextField = new JTextField();
        firstNumberJTextField.setText("");
        firstNumberJTextField.setBounds(165, 20, 40, 20);
        firstNumberJTextField.setHorizontalAlignment(JTextField.RIGHT);
        contentPane.add(firstNumberJTextField);

        // set up secondNumberJLabel
        // JLabel and JTextField for user to input second number
        JLabel secondNumberJLabel = new JLabel();
        secondNumberJLabel.setText("Enter second number:");
        secondNumberJLabel.setBounds(20, 50, 125, 20);
        contentPane.add(secondNumberJLabel);

        // set up secondNumberJTextField
        secondNumberJTextField = new JTextField();
        secondNumberJTextField.setText("");
        secondNumberJTextField.setBounds(165, 50, 40, 20);
        secondNumberJTextField.setHorizontalAlignment(JTextField.RIGHT);
        contentPane.add(secondNumberJTextField);

        // set up thirdNumberJLabel
        // JLabel and JTextField for user to input third number
        JLabel thirdNumberJLabel = new JLabel();
        thirdNumberJLabel.setText("Enter third number:");
        thirdNumberJLabel.setBounds(20, 80, 125, 20);
        contentPane.add(thirdNumberJLabel);

        // set up thirdNumberJTextField
        thirdNumberJTextField = new JTextField();
        thirdNumberJTextField.setText("");
        thirdNumberJTextField.setBounds(165, 80, 40, 20);
        thirdNumberJTextField.setHorizontalAlignment(JTextField.RIGHT);
        contentPane.add(thirdNumberJTextField);

        // set up averageJLabel
        // JLabel and JTextField to display average
        JLabel averageJLabel = new JLabel();
        averageJLabel.setText("Average is:");
        averageJLabel.setBounds(20, 110, 130, 20);
        contentPane.add(averageJLabel);

        // set up averageJTextField
        averageJTextField = new JTextField();
        averageJTextField.setText("");
        averageJTextField.setEditable(false);
        averageJTextField.setBounds(165, 110, 40, 20);
        averageJTextField.setHorizontalAlignment(JTextField.RIGHT);
        contentPane.add(averageJTextField);

        // set up calculateJButton
        // JButton to initiate average calculation
        JButton calculateJButton = new JButton();
        calculateJButton.setText("Calculate");
        calculateJButton.setBounds(225, 80, 90, 20);
        contentPane.add(calculateJButton);
        // anonymous inner class
        // method called when calculateJButton is pressed
        calculateJButton.addActionListener(

                this::calculateJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set properties of window
        setTitle("Average Three Numbers"); // set window title
        setSize(340, 180);                 // set window size
        setVisible(true);                  // display window

    } // end method createUserInterface

    // calculate the average of the three values
    private void calculateJButtonActionPerformed(ActionEvent event) {
        // get values input by user
        int number1 = Integer.parseInt(
                firstNumberJTextField.getText());
        int number2 = Integer.parseInt(
                secondNumberJTextField.getText());
        int number3 = Integer.parseInt(
                thirdNumberJTextField.getText());

        // sum number1, number2 and number3 and divide by 3
        int result = (number1 + number2 + number3) / 3;

        // display the result
        averageJTextField.setText(String.valueOf(result));

    } // end method calculateJButtonActionPerformed

} // end class Average

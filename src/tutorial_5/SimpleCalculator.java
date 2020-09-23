package tutorial_5;

// Exercise 5.13 SimpleCalculator.java
// Application that takes two numbers and performs arithmetic 
// operations with the input values.

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SimpleCalculator extends JFrame {
    private JTextField firstNumberJTextField;

    private JTextField secondNumberJTextField;

    private JTextField resultJTextField;

    // no-argument constructor
    public SimpleCalculator() {
        createUserInterface();
    }

    // main method
    public static void main(String[] args) {
        SimpleCalculator application = new SimpleCalculator();
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
        firstNumberJLabel.setBounds(20, 20, 130, 25);
        contentPane.add(firstNumberJLabel);

        // set up firstNumberJTextField
        firstNumberJTextField = new JTextField();
        firstNumberJTextField.setText("0");
        firstNumberJTextField.setBounds(170, 20, 60, 25);
        firstNumberJTextField.setHorizontalAlignment(
                JTextField.RIGHT);
        contentPane.add(firstNumberJTextField);
        firstNumberJTextField.addKeyListener(

                new KeyAdapter() // anonymous inner class
                {
                    // called when key pressed in firstNumberJTextField
                    public void keyPressed(KeyEvent event) {
                        firstNumberJTextFieldKeyPressed();
                    }

                } // end anonymous inner class

        ); // end call to addKeyListener

        // set up secondNumberJLabel
        // JLabel and JTextField for user to input second number
        JLabel secondNumberJLabel = new JLabel();
        secondNumberJLabel.setText("Enter second number:");
        secondNumberJLabel.setBounds(20, 55, 130, 25);
        contentPane.add(secondNumberJLabel);

        // set up secondNumberJTextField
        secondNumberJTextField = new JTextField();
        secondNumberJTextField.setText("0");
        secondNumberJTextField.setBounds(170, 55, 60, 25);
        secondNumberJTextField.setHorizontalAlignment(
                JTextField.RIGHT);
        contentPane.add(secondNumberJTextField);
        secondNumberJTextField.addKeyListener(

                new KeyAdapter() // anonymous inner class
                {
                    // called when key pressed in secondNumberJTextField
                    public void keyPressed(KeyEvent event) {
                        secondNumberJTextFieldKeyPressed();
                    }

                } // end anonymous inner class

        ); // end call to addKeyListener

        // set up resultJLabel
        // JLabel and JTextField to display result
        JLabel resultJLabel = new JLabel();
        resultJLabel.setText("Result:");
        resultJLabel.setBounds(20, 90, 130, 25);
        contentPane.add(resultJLabel);

        // set up resultJTextField
        resultJTextField = new JTextField();
        resultJTextField.setHorizontalAlignment(JTextField.RIGHT);
        resultJTextField.setEditable(false);
        resultJTextField.setBounds(170, 90, 60, 25);
        contentPane.add(resultJTextField);

        // set up addJButton
        // JButtons to initiate calculations
        JButton addJButton = new JButton();
        addJButton.setText("+");
        addJButton.setBounds(250, 20, 41, 25);
        addJButton.setFont(new Font("Monospaced", Font.PLAIN, 12));
        contentPane.add(addJButton);
        // anonymous inner class
        // called when addJButton is pressed
        addJButton.addActionListener(

                this::addJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set up subtractJButton
        JButton subtractJButton = new JButton();
        subtractJButton.setText("-");
        subtractJButton.setBounds(301, 20, 41, 25);
        subtractJButton.setFont(
                new Font("Monospaced", Font.PLAIN, 12));
        contentPane.add(subtractJButton);
        // anonymous inner class
        // called when subtractJButton is pressed
        subtractJButton.addActionListener(

                this::subtractJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set up multiplyJButton
        JButton multiplyJButton = new JButton();
        multiplyJButton.setText("*");
        multiplyJButton.setBounds(250, 55, 41, 25);
        multiplyJButton.setFont(
                new Font("Monospaced", Font.PLAIN, 12));
        contentPane.add(multiplyJButton);
        // anonymous inner class
        // called when multiplyJButton is pressed
        multiplyJButton.addActionListener(

                this::multiplyJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set up divideJButton
        JButton divideJButton = new JButton();
        divideJButton.setText("/");
        divideJButton.setBounds(301, 55, 41, 25);
        divideJButton.setFont(
                new Font("Monospaced", Font.PLAIN, 12));
        contentPane.add(divideJButton);
        // anonymous inner class
        // called when divideJButton is pressed
        divideJButton.addActionListener(

                this::divideJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set properties of window
        setTitle("Calculator"); // set window title
        setSize(370, 160);      // set window size
        setVisible(true);       // display window

    } // end method createUserInterface

    // clear resultJTextField because the value is now invalid
    private void firstNumberJTextFieldKeyPressed() {
        // clear resultJTextField
        resultJTextField.setText("");
    } // end method firstNumberKeyTyped

    // clear resultJTextField because the value is now invalid
    private void secondNumberJTextFieldKeyPressed() {
        // clear resultJTextField
        resultJTextField.setText("");
    } // end method secondNumberJTextFieldKeyTyped

    // add the two numbers
    private void addJButtonActionPerformed(ActionEvent event) {
        int num1 = Integer.parseInt(firstNumberJTextField.getText());
        int num2 = Integer.parseInt(secondNumberJTextField.getText());
        int result = num1 + num2;
        resultJTextField.setText(String.valueOf(result));
    } // end method addJButtonActionPerformed

    // subtract the two numbers
    private void subtractJButtonActionPerformed(ActionEvent event) {
        int num1 = Integer.parseInt(firstNumberJTextField.getText());
        int num2 = Integer.parseInt(secondNumberJTextField.getText());
        int result = num1 - num2;
        resultJTextField.setText(String.valueOf(result));
    } // end method subtractJButtonActionPerformed

    // multiply the two numbers
    private void multiplyJButtonActionPerformed(ActionEvent event) {
        int num1 = Integer.parseInt(firstNumberJTextField.getText());
        int num2 = Integer.parseInt(secondNumberJTextField.getText());
        int result = num1 * num2;
        resultJTextField.setText(String.valueOf(result));
    } // end method multiplyJButtonActionPerformed

    // divide the two numbers
    private void divideJButtonActionPerformed(ActionEvent event) {
        int num1 = Integer.parseInt(firstNumberJTextField.getText());
        int num2 = Integer.parseInt(secondNumberJTextField.getText());
        double result = (double) num1 / num2;
        resultJTextField.setText(String.valueOf(result));
    } // end method divideJButtonActionPerformed

} // end class SimpleCalculator

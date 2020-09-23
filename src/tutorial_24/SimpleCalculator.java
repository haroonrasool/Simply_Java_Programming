package tutorial_24;

// Exercise 24.13 SimpleCalculator.java
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

        // set up firstNumberLabel
        // JLabel and JTextField for user to input first number
        JLabel firstNumberJLabel = new JLabel();
        firstNumberJLabel.setBounds(20, 20, 130, 25);
        firstNumberJLabel.setText("Enter first number:");
        contentPane.add(firstNumberJLabel);

        // set up firstNumberJTextField
        firstNumberJTextField = new JTextField();
        firstNumberJTextField.setBounds(170, 20, 60, 25);
        firstNumberJTextField.setText("0");
        firstNumberJTextField.setHorizontalAlignment(
                JTextField.RIGHT);
        contentPane.add(firstNumberJTextField);
        firstNumberJTextField.addKeyListener(

                new KeyAdapter() // anonymous inner class
                {
                    // event handler called when key pressed
                    // in firstNumberJTextField
                    public void keyPressed(KeyEvent event) {
                        firstNumberJTextFieldKeyPressed();
                    }

                } // end anonymous inner class

        ); // end call to addKeyListener

        // set up secondNumberJLabel
        // JLabel and JTextField for user to input second number
        JLabel secondNumberJLabel = new JLabel();
        secondNumberJLabel.setBounds(20, 55, 130, 25);
        secondNumberJLabel.setText("Enter second number:");
        contentPane.add(secondNumberJLabel);

        // set up secondNumberJTextField
        secondNumberJTextField = new JTextField();
        secondNumberJTextField.setBounds(170, 55, 60, 25);
        secondNumberJTextField.setText("0");
        secondNumberJTextField.setHorizontalAlignment(
                JTextField.RIGHT);
        contentPane.add(secondNumberJTextField);
        secondNumberJTextField.addKeyListener(

                new KeyAdapter() // anonymous inner class
                {
                    // event handler called when key pressed
                    // in secondNumberJTextField
                    public void keyPressed(KeyEvent event) {
                        secondNumberJTextFieldKeyPressed();
                    }

                } // end anonymous inner class

        ); // end call to addKeyListener

        // set up resultJLabel
        // JLabel and JTextField to display result
        JLabel resultJLabel = new JLabel();
        resultJLabel.setBounds(20, 90, 130, 25);
        resultJLabel.setText("Result:");
        contentPane.add(resultJLabel);

        // set up resultJTextField
        resultJTextField = new JTextField();
        resultJTextField.setBounds(170, 90, 60, 25);
        resultJTextField.setText("");
        resultJTextField.setHorizontalAlignment(JTextField.RIGHT);
        resultJTextField.setEditable(false);
        contentPane.add(resultJTextField);

        // set up addJButton
        // JButtons to initiate calculations
        JButton addJButton = new JButton();
        addJButton.setBounds(250, 20, 41, 25);
        addJButton.setText("+");
        addJButton.setFont(new Font("Monospaced", Font.PLAIN, 12));
        contentPane.add(addJButton);
        // anonymous inner class
        // event handler called when addJButton is pressed
        addJButton.addActionListener(

                this::addJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set up subtractJButton
        JButton subtractJButton = new JButton();
        subtractJButton.setBounds(301, 20, 41, 25);
        subtractJButton.setText("-");
        subtractJButton.setFont(
                new Font("Monospaced", Font.PLAIN, 12));
        contentPane.add(subtractJButton);
        // anonymous inner class
        // event handler called when subtractJButton is pressed
        subtractJButton.addActionListener(

                this::subtractJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set up multiplyJButton
        JButton multiplyJButton = new JButton();
        multiplyJButton.setBounds(250, 55, 41, 25);
        multiplyJButton.setText("*");
        multiplyJButton.setFont(
                new Font("Monospaced", Font.PLAIN, 12));
        contentPane.add(multiplyJButton);
        // anonymous inner class
        // event handler called when multiplyJButton is pressed
        multiplyJButton.addActionListener(

                this::multiplyJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set up divideJButton
        JButton divideJButton = new JButton();
        divideJButton.setBounds(301, 55, 41, 25);
        divideJButton.setText("/");
        divideJButton.setFont(
                new Font("Monospaced", Font.PLAIN, 12));
        contentPane.add(divideJButton);
        // anonymous inner class
        // event handler called when divideJButton is pressed
        divideJButton.addActionListener(

                this::divideJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set properties of application's window
        setTitle("Calculator"); // set title bar String
        setSize(370, 160);      // set window size
        setVisible(true);       // display window

    } // end method createUserInterface

    // clear resultJTextField because the value is now invalid
    private void firstNumberJTextFieldKeyPressed() {
        // clear resultJTextField
        resultJTextField.setText("");
    } // end method firstNumberKeyPressed

    // clear resultJTextField because the value is now invalid
    private void secondNumberJTextFieldKeyPressed() {
        // clear resultJTextField
        resultJTextField.setText("");
    } // end method secondNumberJTextFieldKeyPressed

    // method to add the two numbers
    private void addJButtonActionPerformed(ActionEvent event) {
        // try to get values input by user
        try {
            int number1 =
                    Integer.parseInt(firstNumberJTextField.getText());
            int number2 =
                    Integer.parseInt(secondNumberJTextField.getText());

            // add the two values and store in result
            int result = number1 + number2;

            // display the result
            resultJTextField.setText(String.valueOf(result));
        } catch (NumberFormatException exception) {
            JOptionPane.showMessageDialog(this,
                    "Please enter two integer values",
                    "Number Format Error", JOptionPane.ERROR_MESSAGE);
        }

    } // end method addJButtonActionPerformed

    // method to subtract the two numbers
    private void subtractJButtonActionPerformed(ActionEvent event) {
        // try to get values input by user
        try {
            int number1 =
                    Integer.parseInt(firstNumberJTextField.getText());
            int number2 =
                    Integer.parseInt(secondNumberJTextField.getText());

            // subtract the two values and store in result
            int result = number1 - number2;

            // display the result
            resultJTextField.setText(String.valueOf(result));
        } catch (NumberFormatException exception) {
            JOptionPane.showMessageDialog(this,
                    "Please enter two integer values",
                    "Number Format Error", JOptionPane.ERROR_MESSAGE);
        }

    } // end method subtractJButtonActionPerformed

    // method to multiply the two numbers
    private void multiplyJButtonActionPerformed(ActionEvent event) {
        // try to get values input by user
        try {
            int number1 =
                    Integer.parseInt(firstNumberJTextField.getText());
            int number2 =
                    Integer.parseInt(secondNumberJTextField.getText());

            // multiply the two values and store in result
            int result = number1 * number2;

            // display the result
            resultJTextField.setText(String.valueOf(result));
        } catch (NumberFormatException exception) {
            JOptionPane.showMessageDialog(this,
                    "Please enter two integer values",
                    "Number Format Error", JOptionPane.ERROR_MESSAGE);
        }

    } // end method multiplyJButtonActionPerformed

    // method to divide the two numbers
    private void divideJButtonActionPerformed(ActionEvent event) {
        // try to get values input by user
        try {
            int number1 =
                    Integer.parseInt(firstNumberJTextField.getText());
            int number2 =
                    Integer.parseInt(secondNumberJTextField.getText());

            // divide the two values and store in result
            int result = number1 / number2;

            // display the result
            resultJTextField.setText(String.valueOf(result));
        } catch (NumberFormatException exception) {
            JOptionPane.showMessageDialog(this,
                    "Please enter two integer values",
                    "Number Format Error", JOptionPane.ERROR_MESSAGE);
        } catch (ArithmeticException exception) {
            JOptionPane.showMessageDialog(this,
                    "You cannot divide by 0.  Please enter another value",
                    "Arithmetic Error", JOptionPane.ERROR_MESSAGE);
        }

    } // end method divideJButtonActionPerformed

} // end class SimpleCalculator

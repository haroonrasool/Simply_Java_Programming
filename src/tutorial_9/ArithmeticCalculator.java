package tutorial_9;

// Exercise 9.13: ArithmeticCalculator.java
// This application accepts two operands and allows
// the user to perform multiplication or addition.

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ArithmeticCalculator extends JFrame {
    private JTextArea operandsJTextArea;

    private JTextField resultJTextField;

    // JButtons initiate adding and/or multiplying operands
    private JButton addJButton;
    private JButton multiplyJButton;

    private double value1 = 0; // holds the first value entered
    private double value2 = 0; // holds the second value entered

    // no-argument constructor
    public ArithmeticCalculator() {
        createUserInterface();
    }

    // main method
    public static void main(String[] args) {
        ArithmeticCalculator application = new ArithmeticCalculator();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } // end method main

    // create and position GUI components; register event handlers
    private void createUserInterface() {
        // get content pane for attaching GUI components
        Container contentPane = getContentPane();

        // enable explicit positioning of GUI components
        contentPane.setLayout(null);

        // set up operandsJLabel
        // JLabel and JTextArea for operands entered by user
        JLabel operandsJLabel = new JLabel();
        operandsJLabel.setBounds(16, 8, 100, 16);
        operandsJLabel.setText("Operands:");
        contentPane.add(operandsJLabel);

        // set up operandsJTextArea
        operandsJTextArea = new JTextArea();
        operandsJTextArea.setBounds(16, 27, 104, 32);
        operandsJTextArea.setEditable(false);
        contentPane.add(operandsJTextArea);

        // set up resultJLabel
        // JLabel and JTextField displays result of calculation
        JLabel resultJLabel = new JLabel();
        resultJLabel.setBounds(16, 64, 53, 23);
        resultJLabel.setText("Result:");
        contentPane.add(resultJLabel);

        // set up resultJTextField
        resultJTextField = new JTextField();
        resultJTextField.setBounds(16, 91, 104, 26);
        resultJTextField.setEditable(false);
        resultJTextField.setHorizontalAlignment(JTextField.CENTER);
        contentPane.add(resultJTextField);

        // set up enterOperandsJButton
        // JButton initiates asking user for operands
        JButton enterOperandsJButton = new JButton();
        enterOperandsJButton.setBounds(140, 27, 125, 26);
        enterOperandsJButton.setText("Enter Operands");
        contentPane.add(enterOperandsJButton);
        // anonymous inner class
        // event handler called when enterOperandsJButton pressed
        enterOperandsJButton.addActionListener(

                this::enterOperandsJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set up addJButton
        addJButton = new JButton();
        addJButton.setBounds(140, 59, 125, 26);
        addJButton.setText("Add");
        addJButton.setEnabled(false);
        contentPane.add(addJButton);
        // anonymous inner class
        // event handler  called when addJButton is pressed
        addJButton.addActionListener(

                this::addJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set up multiplyJButton
        multiplyJButton = new JButton();
        multiplyJButton.setBounds(140, 91, 125, 26);
        multiplyJButton.setText("Multiply");
        multiplyJButton.setEnabled(false);
        contentPane.add(multiplyJButton);
        // anonymous inner class
        // event handler called when multiplyJButton is pressed
        multiplyJButton.addActionListener(

                this::multiplyJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set properties of application's window
        setTitle("Arithmetic Calculator"); // set title bar text
        setSize(290, 159);                 // set window size
        setVisible(true);                  // display window

    } // end method createUserInterface

    // store and display input
    private void enterOperandsJButtonActionPerformed(ActionEvent event) {
        String input;

        // remove previous data
        operandsJTextArea.setText("");
        resultJTextField.setText("");

        // get user input and convert input
        input = JOptionPane.showInputDialog(null, "Enter Operand");
        value1 = Integer.parseInt(input);
        input = JOptionPane.showInputDialog(null, "Enter Operand");
        value2 = Integer.parseInt(input);

        // display operands
        operandsJTextArea.setText(value1 + "\n" + value2);

        // allow user to click calculate JButtons
        addJButton.setEnabled(true);
        multiplyJButton.setEnabled(true);

    } // end method enterOperandsJButtonActionPerformed

    // add and display result
    private void addJButtonActionPerformed(ActionEvent event) {
        double result = value1 + value2;
        resultJTextField.setText(String.valueOf(result));
    } // end method addJButtonActionPerformed

    // multiply and display result
    private void multiplyJButtonActionPerformed(ActionEvent event) {
        double result = value1 * value2;
        resultJTextField.setText(String.valueOf(result));
    } // end method multiplyJButtonActionPerformed

} // end class ArithmeticCalculator

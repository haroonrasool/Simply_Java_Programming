package tutorial_5;

// Exercise 5.12 TemperatureConversion.java
// Application that converts a Celsius temperature to its equivalent
// Fahrenheit temperature.

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TemperatureConversion extends JFrame {
    private JTextField celsiusJTextField;

    private JTextField fahrenheitJTextField;

    // no-argument constructor
    public TemperatureConversion() {
        createUserInterface();
    }

    // main method
    public static void main(String[] args) {
        TemperatureConversion application = new TemperatureConversion();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } // end method main

    // create and position GUI components; register event handlers
    private void createUserInterface() {
        // get content pane for attaching GUI components
        Container contentPane = getContentPane();

        // enable explicit positioning of GUI components
        contentPane.setLayout(null);

        // set up celsiusJLabel
        // JLabel and JTextField for Celsius input
        JLabel celsiusJLabel = new JLabel();
        celsiusJLabel.setText("Enter a Celsius temperature:");
        celsiusJLabel.setBounds(10, 10, 170, 24);
        contentPane.add(celsiusJLabel);

        // set up celsiusJTextField
        celsiusJTextField = new JTextField();
        celsiusJTextField.setBounds(180, 10, 100, 24);
        contentPane.add(celsiusJTextField);
        celsiusJTextField.addKeyListener(

                new KeyAdapter() // anonymous inner class
                {
                    // called when key pressed in celsiusJTextField
                    public void keyPressed(KeyEvent event) {
                        celsiusJTextFieldKeyPressed();
                    }

                } // end anonymous inner class

        ); // end call to addKeyListener

        // set up fahrenheitJLabel
        // JLabel and JTextField for Fahrenheit output
        JLabel fahrenheitJLabel = new JLabel();
        fahrenheitJLabel.setText("Fahrenheit equivalent:");
        fahrenheitJLabel.setBounds(10, 40, 170, 24);
        contentPane.add(fahrenheitJLabel);

        // set up fahrenheitJTextField
        fahrenheitJTextField = new JTextField();
        fahrenheitJTextField.setEditable(false);
        fahrenheitJTextField.setBounds(180, 40, 100, 24);
        contentPane.add(fahrenheitJTextField);

        // set up convertJButton
        // JButton to initiate Celsius to Fahrenheit conversion
        JButton convertJButton = new JButton();
        convertJButton.setText("Convert");
        convertJButton.setBounds(290, 10, 80, 24);
        contentPane.add(convertJButton);
        // anonymous inner class
        // called when convertJButton is pressed
        convertJButton.addActionListener(

                this::convertJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set properties of application's window
        setTitle("Temperature Conversion"); // set title bar text
        setSize(395, 115);                  // set window size
        setVisible(true);                   // display window

    } // end method createUserInterface

    // clear fahrenheitJTextField because the value is now invalid
    private void celsiusJTextFieldKeyPressed() {
        fahrenheitJTextField.setText("");
    } // end method celsiusJTextFieldKeyTyped

    // convert Celsius value to Fahrenheit value
    private void convertJButtonActionPerformed(ActionEvent event) {
        int celsius = Integer.parseInt(celsiusJTextField.getText());
        double fahrenheit = 9.0 / 5.0 * celsius + 32;
        fahrenheitJTextField.setText(String.valueOf(fahrenheit));
    } // end method convertJButtonActionPerformed

} // end class TemperatureConversion

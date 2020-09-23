package tutorial_13;

// Exercise 13.12: TemperatureConversion.java
// Converts a degree amount from Celsius to Fahrenheit,
// or from Fahrenheit to Celsius.

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.text.DecimalFormat;

public class TemperatureConversion extends JFrame {
    // DecimalFormat for temperatures
    DecimalFormat temperature = new DecimalFormat("0.0");

    // retrieving values from JTextFields.
    private JTextField fahrenheitJTextField;
    private JTextField celsiusJTextField;

    // no-argument constructor
    public TemperatureConversion() {
        createUserInterface();
    }

    // main method
    public static void main(String[] args) {
        TemperatureConversion application =
                new TemperatureConversion();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } // end method main

    // create and position GUI components; register event handlers
    private void createUserInterface() {
        // get content pane for attaching GUI components
        Container contentPane = getContentPane();

        // enable explicit positioning of GUI components
        contentPane.setLayout(null);

        // set up fahrenheitJLabel
        // JLabel and JTextField for Fahrenheit
        JLabel fahrenheitJLabel = new JLabel();
        fahrenheitJLabel.setBounds(12, 24, 72, 21);
        fahrenheitJLabel.setText("Fahrenheit:");
        contentPane.add(fahrenheitJLabel);

        // set up fahrenheitJTextField
        fahrenheitJTextField = new JTextField();
        fahrenheitJTextField.setBounds(78, 24, 64, 21);
        fahrenheitJTextField.setHorizontalAlignment(
                JTextField.RIGHT);
        contentPane.add(fahrenheitJTextField);
        // anonymous inner class
        // event handler called when enter is pressed in
        // fahrenheitJTextField
        fahrenheitJTextField.addActionListener(

                this::fahrenheitJTextFieldActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set up celsiusJLabel
        // JLabel and JTextField for Celsius
        JLabel celsiusJLabel = new JLabel();
        celsiusJLabel.setBounds(162, 24, 56, 21);
        celsiusJLabel.setText("Celsius:");
        contentPane.add(celsiusJLabel);

        // set up celsiusJTextField
        celsiusJTextField = new JTextField();
        celsiusJTextField.setBounds(212, 24, 64, 21);
        celsiusJTextField.setHorizontalAlignment(JTextField.RIGHT);
        contentPane.add(celsiusJTextField);
        // anonymous inner class
        // event handler called when enter is pressed in
        // celsiusJTextField
        celsiusJTextField.addActionListener(

                this::celsiusJTextFieldActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set properties of application's window
        setTitle("Temperature Converter"); // set title-bar string
        setSize(306, 100);                 // set window size
        setVisible(true);                  // show window

    } // end method createUserInterface

    // fahrenheitJTextFieldActionPerformed method
    private void fahrenheitJTextFieldActionPerformed(ActionEvent event) {
        double degreesFahrenheit = Double.parseDouble(fahrenheitJTextField.getText());
        double degreesCelsius = (degreesFahrenheit - 32.0) * 5.0 / 9.9;

        // display degreesCelsius in celsiusJTextField
        celsiusJTextField.setText(temperature.format(degreesCelsius));
    } // end of method fahrenheit

    // celsiusJTextFieldActionPerformed method
    private void celsiusJTextFieldActionPerformed(ActionEvent event) {
        double degreesCelsius = Double.parseDouble(celsiusJTextField.getText());
        double degreesFahrenheit = 9.0 / 5.0 * degreesCelsius + 32;

        // display degreesFahrenheit in fahrenheitJTextField
        fahrenheitJTextField.setText(temperature.format(degreesFahrenheit));
    } // end of method celsius

} // end class TemperatureConversion

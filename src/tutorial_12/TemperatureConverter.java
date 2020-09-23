package tutorial_12;

// Exercise 12.11: TemperatureConverter.java
// Converts a degree amount from Celsius to Fahrenheit,
// or from Fahrenheit to Celsius.

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.text.DecimalFormat;

public class TemperatureConverter extends JFrame {
    private JTextField degreesJTextField;

    // JTextField displays degrees converted to Fahrenheit or Celsius
    private JTextField outputJTextField;

    // no-argument constructor
    public TemperatureConverter() {
        createUserInterface();
    }

    // main method
    public static void main(String[] args) {
        TemperatureConverter application = new TemperatureConverter();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } // end method main

    // create and position GUI components; register event handlers
    private void createUserInterface() {
        // get content pane for attaching GUI components
        Container contentPane = getContentPane();

        // enable explicit positioning of GUI components
        contentPane.setLayout(null);

        // set up degreesJLabel
        // JLabel and JTextField for degrees value, entered by user
        JLabel degreesJLabel = new JLabel();
        degreesJLabel.setBounds(16, 16, 200, 21);
        degreesJLabel.setText("Temperature in Degrees:");
        contentPane.add(degreesJLabel);

        // set up degreesJTextField
        degreesJTextField = new JTextField();
        degreesJTextField.setBounds(200, 16, 64, 21);
        degreesJTextField.setHorizontalAlignment(JTextField.RIGHT);
        contentPane.add(degreesJTextField);

        // set up outputJTextField
        outputJTextField = new JTextField();
        outputJTextField.setBounds(16, 56, 354, 21);
        outputJTextField.setHorizontalAlignment(JTextField.CENTER);
        outputJTextField.setEditable(false);
        contentPane.add(outputJTextField);

        // set up convertFahrenheitJButton
        // JButtons initiate conversion to Fahrenheit or Celsius
        JButton convertFahrenheitJButton = new JButton();
        convertFahrenheitJButton.setBounds(16, 104, 162, 40);
        convertFahrenheitJButton.setText("Convert To Fahrenheit");
        contentPane.add(convertFahrenheitJButton);
        // anonymous inner class
        // event handler called when
        // convertFahrenheitJButton is clicked
        convertFahrenheitJButton.addActionListener(

                this::convertFahrenheitJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set up convertCelsiusJButton
        JButton convertCelsiusJButton = new JButton();
        convertCelsiusJButton.setBounds(208, 104, 162, 40);
        convertCelsiusJButton.setText("Convert To Celsius");
        contentPane.add(convertCelsiusJButton);
        // anonymous inner class
        // event handler called when
        // convertCelsiusJButton is clicked
        convertCelsiusJButton.addActionListener(

                this::convertCelsiusJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set properties of application's window
        setTitle("Temperature Converter"); // set title bar string
        setSize(396, 190);                 // set window size
        setVisible(true);                  // display window

    } // end method createUserInterface

    // converts degrees to Fahrenheit
    private void convertFahrenheitJButtonActionPerformed(
            ActionEvent event) {
        // format temperature value
        DecimalFormat temperature = new DecimalFormat("0.00");

        // retrieve input from user
        double degreeCelsius = Double.parseDouble(
                degreesJTextField.getText());

        // convert from Celsius to Fahrenheit
        double convertedDegree = convertToFahrenheit(degreeCelsius);

        // output converted temperature value
        outputJTextField.setText(degreeCelsius +
                " degrees Celsius is equal to " +
                temperature.format(convertedDegree) +
                " degrees Fahrenheit.");

    } // end method convertFahrenheitJButtonActionPerformed

    // converts degrees to Celsius
    private void convertCelsiusJButtonActionPerformed(
            ActionEvent event) {
        // format temperature value
        DecimalFormat temperature = new DecimalFormat("0.00");

        // retrieve input from user
        double degreeFahrenheit = Double.parseDouble(
                degreesJTextField.getText());

        // convert from Fahrenheit to Celsius
        double convertedDegree = convertToCelsius(degreeFahrenheit);

        // output converted temperature value
        outputJTextField.setText(degreeFahrenheit +
                " degrees Fahrenheit is equal to " +
                temperature.format(convertedDegree) +
                " degrees Celsius.");

    } // end method convertCelsiusJButtonActionPerformed

    // method to convert the temperature from Celsius to Fahrenheit
    private double convertToFahrenheit(double degree) {
        return (9.0 / 5.0) * degree + 32.0;
    }

    // method to convert the temperature from Fahrenheit to Celsius
    private double convertToCelsius(double degree) {
        return (5.0 / 9.0) * (degree - 32.0);
    }

} // end class TemperatureConverter

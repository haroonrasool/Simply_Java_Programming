package tutorial_6;

// Exercise 6.11: CurrencyConverter.java
// Converts dollar amounts into other currency.

import java.awt.*;
import java.awt.event.*;
import java.text.*;
import javax.swing.*;

public class CurrencyConverter extends JFrame {
    // String type array for the currencies
    private final String[] currencies = {"Euros", "Pesos", "Yen"};
    private JTextField dollarJTextField;
    private JComboBox typeJComboBox;
    private JTextField convertedJTextField;

    // no-argument constructor
    public CurrencyConverter() {
        createUserInterface();
    }

    // main method
    public static void main(String[] args) {
        CurrencyConverter application = new CurrencyConverter();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } // end method main

    // create and position GUI components; register event handlers
    private void createUserInterface() {
        // get content pane for attaching GUI components
        Container contentPane = getContentPane();

        // enable explicit positioning of GUI components
        contentPane.setLayout(null);

        // set up dollarJLabel
        // JLabel and JTextField to input dollar amount
        JLabel dollarJLabel = new JLabel();
        dollarJLabel.setBounds(16, 16, 128, 21);
        dollarJLabel.setText("Dollars to convert:");
        contentPane.add(dollarJLabel);

        // set up dollarJTextField
        dollarJTextField = new JTextField();
        dollarJTextField.setBounds(175, 16, 96, 21);
        dollarJTextField.setHorizontalAlignment(JTextField.RIGHT);
        contentPane.add(dollarJTextField);

        // set up typeJLabel
        // JLabel and JTextField to input currency type to convert to
        JLabel typeJLabel = new JLabel();
        typeJLabel.setBounds(16, 56, 150, 21);
        typeJLabel.setText("Convert from dollars to:");
        contentPane.add(typeJLabel);

        // set up typeJTextField
        typeJComboBox = new JComboBox<>(currencies);
        typeJComboBox.setBounds(175, 56, 96, 21);
        contentPane.add(typeJComboBox);

        // set up convertedJLabel
        // JLabel and JTextField to display converted value
        JLabel convertedJLabel = new JLabel();
        convertedJLabel.setBounds(16, 96, 112, 24);
        convertedJLabel.setText("Converted amount:");
        contentPane.add(convertedJLabel);

        // set up convertedJTextField
        convertedJTextField = new JTextField();
        convertedJTextField.setBounds(175, 96, 96, 21);
        convertedJTextField.setHorizontalAlignment(
                JTextField.RIGHT);
        convertedJTextField.setEditable(false);
        contentPane.add(convertedJTextField);

        // set up convertJButton and register its event handler
        // JButton to initiate conversion
        JButton convertJButton = new JButton();
        convertJButton.setText("Convert");
        convertJButton.setBounds(175, 136, 96, 24);
        contentPane.add(convertJButton);
        // anonymous inner class
        // event handler called when convertJButton is pressed
        convertJButton.addActionListener(

                this::convertJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set properties of application's window
        setTitle("Currency Converter"); // set title bar text
        setSize(300, 210);              // set window size
        setVisible(true);               // display window

    } // end method createUserInterface

    // this method is called when the user clicks convertJButton
    private void convertJButtonActionPerformed(ActionEvent event) {
        // specify output format
        DecimalFormat dollars = new DecimalFormat("0.00");

        // displaying the amount to be converted
        double amount = Double.parseDouble(dollarJTextField.getText());

        // displaying the currency name
        int currencyName = typeJComboBox.getSelectedIndex();
        switch (currencyName) {
            case 0: // convert to Euros
                amount *= 1.02;
                convertedJTextField.setText(dollars.format(amount));
                break;
            case 1: // convert to Pesos
                amount *= 10;
                convertedJTextField.setText(dollars.format(amount));
                break;
            case 2: // convert to Yen
                amount *= 120;
                convertedJTextField.setText(dollars.format(amount));
                break;
        }
    } // end method convertJButtonActionPerformed

} // end class CurrencyConverter

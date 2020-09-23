package tutorial_3;

// Exercise 3.11: AddressBook.java
// GUI that enables users to input address information.

import java.awt.*;
import javax.swing.*;

public class AddressBook extends JFrame {
    // no-argument constructor
    public AddressBook() {
        createUserInterface();
    }

    // main method
    public static void main(String[] args) {
        AddressBook application = new AddressBook();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } // end method main

    // create and position GUI components
    public void createUserInterface() {
        // get content pane and set its layout
        Container container = getContentPane();
        container.setLayout(null);

        // set up firstNameJLabel
        // JLabel and JTextField for first name
        JLabel firstNameJLabel = new JLabel();
        firstNameJLabel.setBounds(16, 16, 64, 21);
        firstNameJLabel.setText("First name:");
        container.add(firstNameJLabel);

        // set up firstNameJTextField
        JTextField firstNameJTextField = new JTextField();
        firstNameJTextField.setBounds(88, 16, 134, 21);
        firstNameJTextField.setText("John");
        container.add(firstNameJTextField);

        // set up lastNameJLabel
        // JLabel and JTextField for last name
        JLabel lastNameJLabel = new JLabel();
        lastNameJLabel.setBounds(242, 16, 64, 21);
        lastNameJLabel.setText("Last name:");
        container.add(lastNameJLabel);

        // set up lastNameJTextField
        JTextField lastNameJTextField = new JTextField();
        lastNameJTextField.setBounds(314, 16, 134, 21);
        lastNameJTextField.setText("Doe");
        container.add(lastNameJTextField);

        // set up addressJLabel
        // JLabel and JTextField for address
        JLabel addressJLabel = new JLabel();
        addressJLabel.setText("Address:");
        addressJLabel.setBounds(16, 56, 64, 21);
        container.add(addressJLabel);

        // set up addressJTextField
        JTextField addressJTextField = new JTextField();
        addressJTextField.setText("123 Main Street");
        addressJTextField.setBounds(88, 56, 360, 21); // x= , y= , w= , h=
        container.add(addressJTextField);

        // set up cityJLabel
        // JLabel and JTextField for city
        JLabel cityJLabel = new JLabel();
        cityJLabel.setBounds(16, 96, 32, 21);
        cityJLabel.setText("City:");
        container.add(cityJLabel);

        // set up cityJTextField
        JTextField cityJTextField = new JTextField();
        cityJTextField.setBounds(88, 96, 112, 21);
        cityJTextField.setText("Wembley");
        container.add(cityJTextField);

        // set up stateJLabel
        // JLabel and JTextField for state
        JLabel stateJLabel = new JLabel();
        stateJLabel.setBounds(222, 96, 40, 21);
        stateJLabel.setText("State:");
        container.add(stateJLabel);

        // set up stateJTextField
        JTextField stateJTextField = new JTextField();
        stateJTextField.setBounds(270, 96, 32, 21);
        stateJTextField.setText("ENG");
        container.add(stateJTextField);

        // set up zipJLabel
        // JLabel and JTextField for zip code
        JLabel zipJLabel = new JLabel();
        zipJLabel.setBounds(320, 96, 32, 21);
        zipJLabel.setText("Zip:");
        container.add(zipJLabel);

        // set up zipJTextField
        JTextField zipJTextField = new JTextField();
        zipJTextField.setBounds(360, 96, 88, 21);
        zipJTextField.setText("HA9 2AH");
        container.add(zipJTextField);

        // set up emailJLabel
        // JLabel and JTextField for email address
        JLabel emailJLabel = new JLabel();
        emailJLabel.setBounds(16, 136, 40, 21);
        emailJLabel.setText("E-mail:");
        container.add(emailJLabel);

        // set up emailJTextField
        JTextField emailJTextField = new JTextField();
        emailJTextField.setBounds(88, 136, 176, 21);
        emailJTextField.setText("John.Doe@not-a-domain.com");
        container.add(emailJTextField);

        // set up phoneJLabel
        // JLabel and JTextField for phone number
        JLabel phoneJLabel = new JLabel();
        phoneJLabel.setBounds(280, 136, 40, 21);
        phoneJLabel.setText("Phone:");
        container.add(phoneJLabel);

        // set up phoneJTextField
        JTextField phoneJTextField = new JTextField();
        phoneJTextField.setBounds(336, 136, 112, 21);
        phoneJTextField.setText("781-555-4567");
        container.add(phoneJTextField);

        // set up mobileJLabel
        // JLabel and JTextField for mobile-phone number
        JLabel mobileJLabel = new JLabel();
        mobileJLabel.setBounds(16, 176, 50, 21);
        mobileJLabel.setText("Mobile: ");
        container.add(mobileJLabel);

        // set up mobileJTextField
        JTextField mobileJTextField = new JTextField();
        mobileJTextField.setBounds(88, 176, 176, 21);
        mobileJTextField.setText("978-555-6541");
        container.add(mobileJTextField);

        // set up beeperJLabel
        // JLabel and JTextField for beeper number
        JLabel beeperJLabel = new JLabel();
        beeperJLabel.setBounds(280, 176, 48, 21);
        beeperJLabel.setText("Beeper:");
        container.add(beeperJLabel);

        // set up beeperJTextField
        JTextField beeperJTextField = new JTextField();
        beeperJTextField.setBounds(336, 176, 112, 21);
        beeperJTextField.setText("508-555-7896");
        container.add(beeperJTextField);

        // set up saveJButton
        // JButtons to save user input and clear all JTextFields
        JButton saveJButton = new JButton();
        saveJButton.setBounds(284, 216, 75, 23);
        saveJButton.setText("Save");
        container.add(saveJButton);

        // set up clearJButton
        JButton clearJButton = new JButton();
        clearJButton.setBounds(373, 216, 75, 23);
        clearJButton.setText("Clear");
        container.add(clearJButton);

        // set properties of application�s window
        setTitle("Address Book"); // set title bar text
        setSize(472, 290);        // set window size
        setVisible(true);         // display window

    } // end method createUserInterface

} // end class AddressBook

package tutorial_4;

// Exercise 4.13: AccountInformation.java
// This application inputs and outputs account information.

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class AccountInformation extends JFrame {

    private JTextField depositJTextField;

    private JTextField balanceJTextField;

    private JTextField withdrawJTextField;

    // no-argument constructor
    public AccountInformation() {
        createUserInterface();
    }

    // main method
    public static void main(String[] args) {
        AccountInformation application = new AccountInformation();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } // end method main

    // create and position GUI components; register event handlers
    private void createUserInterface() {
        // get content pane and set layout to null
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        // set up enterJPanel
        // JPanel to group deposit components
        JPanel enterJPanel = new JPanel();
        enterJPanel.setLayout(null);
        enterJPanel.setBounds(16, 16, 152, 126);
        enterJPanel.setBorder(new TitledBorder("Enter information"));
        contentPane.add(enterJPanel);

        // set up withdrawJLabel
        JLabel withdrawJLabel = new JLabel();
        withdrawJLabel.setText("Withdrawal amount:");
        withdrawJLabel.setBounds(16, 25, 120, 16);
        enterJPanel.add(withdrawJLabel);

        // set up withdrawJTextField
        withdrawJTextField = new JTextField();
        withdrawJTextField.setText("0");
        withdrawJTextField.setBounds(16, 45, 120, 21);
        withdrawJTextField.setHorizontalAlignment(JTextField.RIGHT);
        enterJPanel.add(withdrawJTextField);

        // set up depositJLabel
        // JLabel and JTextField for deposits
        JLabel depositJLabel = new JLabel();
        depositJLabel.setText("Deposit amount:");
        depositJLabel.setBounds(16, 75, 140, 16);
        enterJPanel.add(depositJLabel);

        // set up depositJTextField
        depositJTextField = new JTextField();
        depositJTextField.setText("0");
        depositJTextField.setBounds(16, 90, 120, 21);
        depositJTextField.setHorizontalAlignment(JTextField.RIGHT);
        enterJPanel.add(depositJTextField);

        // set up enterJButton
        // JButton to initiate balance calculation
        JButton enterJButton = new JButton();
        enterJButton.setText("Enter");
        enterJButton.setBounds(16, 150, 152, 34);
        contentPane.add(enterJButton);
        // anonymous inner class
        // event handler called when enterJButton is pressed
        enterJButton.addActionListener(

                this::enterJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set up accountJPanel
        // JPanel to group account information components
        JPanel accountJPanel = new JPanel();
        accountJPanel.setLayout(null);
        accountJPanel.setBounds(180, 16, 136, 170);
        accountJPanel.setBorder(new TitledBorder("Account information"));
        contentPane.add(accountJPanel);

        // set up nameJLabel
        // JLabel and JTextField for account holder's name
        JLabel nameJLabel = new JLabel();
        nameJLabel.setText("Name:");
        nameJLabel.setBounds(16, 24, 100, 16);
        accountJPanel.add(nameJLabel);

        // set up nameJTextField
        JTextField nameJTextField = new JTextField();
        nameJTextField.setText("Sue Purple");
        nameJTextField.setBounds(16, 40, 104, 21);
        nameJTextField.setEditable(false);
        accountJPanel.add(nameJTextField);

        // set up accountNumberJLabel
        // JLabel and JTextField for account number
        JLabel accountNumberJLabel = new JLabel();
        accountNumberJLabel.setText("Account Number:");
        accountNumberJLabel.setBounds(16, 70, 140, 16);
        accountJPanel.add(accountNumberJLabel);

        // set up accountNumberJTextField
        JTextField accountNumberJTextField = new JTextField();
        accountNumberJTextField.setText("12345");
        accountNumberJTextField.setBounds(16, 86, 104, 21);
        accountNumberJTextField.setEditable(false);
        accountNumberJTextField.setHorizontalAlignment(JTextField.RIGHT);
        accountJPanel.add(accountNumberJTextField);

        // set up balanceJLabel
        // JLabel and JTextField for balance
        JLabel balanceJLabel = new JLabel();
        balanceJLabel.setText("Balance:");
        balanceJLabel.setBounds(16, 116, 100, 16);
        accountJPanel.add(balanceJLabel);

        // set up balanceJTextField
        balanceJTextField = new JTextField();
        balanceJTextField.setText("0");
        balanceJTextField.setBounds(16, 132, 104, 21);
        balanceJTextField.setEditable(false);
        balanceJTextField.setHorizontalAlignment(JTextField.RIGHT);
        accountJPanel.add(balanceJTextField);

        // set properties of application's window
        setTitle("Account Information"); // set title bar text
        setSize(340, 230); // set window's size
        setVisible(true); // display window

    } // end method createUserInterface

    // add previous balance to deposit and display result
    private void enterJButtonActionPerformed(ActionEvent event) {
        // retrieving information from JTextFields
        double withdraw = Integer.parseInt(withdrawJTextField.getText());
        double deposit = Integer.parseInt(depositJTextField.getText());
        // calculating the balance.
        double balance = deposit - withdraw;
        // displaying the calculated balance in balanceJTextField.
        balanceJTextField.setText(String.valueOf(balance));
    } // end method enterJButtonActionPerformed

} // end class AccountInformation

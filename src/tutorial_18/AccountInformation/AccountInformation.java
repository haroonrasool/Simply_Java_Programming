package tutorial_18.AccountInformation;

// Exercise 18.13: AccountInformation.java
// This application displays bank account information.

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.text.DecimalFormat;

public class AccountInformation extends JFrame {
    private JTextField firstJTextField;

    private JTextField lastJTextField;

    private JTextField numberJTextField;

    private JTextField balanceJTextField;

    // integer for storing the index of the current record
    private int position = 0;

    // Client instance for storing an array of account records
    private final Client[] accountRecords;

    // no-argument constructor
    public AccountInformation() {
        createUserInterface();

        // variables hold data to be stored in accountRecords
        String[] firstName = new String[]{"John", "Sarah", "Jack",
                "Adam", "Diane", "David", "Kristin", "Jennifer", "Harry"};
        String[] lastName = new String[]{"Blue", "White", "Red",
                "Brown", "Yellow", "Black", "Green", "Orange", "Potter"};
        int[] accountNumber = new int[]{1234652, 1234666, 1234678,
                1234681, 1234690, 1234770, 1234787, 1234887, 1234598};
        double[] balance = new double[]{1000.78, 2056.24, 978.65,
                990.0, 432.75, 780.78, 4590.63, 7910.11, 9876.54};

        // initialize accountRecords and make it the same
        // length as the variables to be stored in it
        accountRecords = new Client[firstName.length];

        // store account information variables in accountRecords
        for (int i = 0; i < firstName.length; i++) {
            accountRecords[i] = new Client(firstName[i], lastName[i], accountNumber[i], balance[i]);
        }

    } // end constructor

    // main method
    public static void main(String[] args) {
        AccountInformation application = new AccountInformation();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } // end method main

    // create and position GUI components; register event handlers
    private void createUserInterface() {
        // get content pane for attaching GUI components
        Container contentPane = getContentPane();

        // enable explicit positioning of GUI components
        contentPane.setLayout(null);

        // set up firstJLabel
        // JLabel and JTextField for first name
        JLabel firstJLabel = new JLabel();
        firstJLabel.setBounds(16, 16, 100, 24);
        firstJLabel.setText("First name:");
        contentPane.add(firstJLabel);

        // set up firstJTextField
        firstJTextField = new JTextField();
        firstJTextField.setBounds(134, 16, 120, 24);
        firstJTextField.setEditable(false);
        contentPane.add(firstJTextField);

        // set up lastJLabel
        // JLabel and JTextField for last name
        JLabel lastJLabel = new JLabel();
        lastJLabel.setBounds(16, 56, 120, 24);
        lastJLabel.setText("Last name:");
        contentPane.add(lastJLabel);

        // set up lastJTextField
        lastJTextField = new JTextField();
        lastJTextField.setBounds(134, 56, 120, 24);
        lastJTextField.setEditable(false);
        contentPane.add(lastJTextField);

        // set up numberJLabel
        // JLabel and JTextField for account number
        JLabel numberJLabel = new JLabel();
        numberJLabel.setBounds(16, 96, 120, 24);
        numberJLabel.setText("Account number:");
        contentPane.add(numberJLabel);

        // set up numberJTextField
        numberJTextField = new JTextField();
        numberJTextField.setBounds(134, 96, 120, 24);
        numberJTextField.setEditable(false);
        contentPane.add(numberJTextField);

        // set up balanceJLabel
        // JLabel and JTextField for balance
        JLabel balanceJLabel = new JLabel();
        balanceJLabel.setBounds(16, 136, 100, 24);
        balanceJLabel.setText("Balance:");
        contentPane.add(balanceJLabel);

        // set up balanceJTextField
        balanceJTextField = new JTextField();
        balanceJTextField.setBounds(134, 136, 120, 24);
        balanceJTextField.setEditable(false);
        contentPane.add(balanceJTextField);

        // set up previousJButton
        // JButton to display previous or next record
        JButton previousJButton = new JButton();
        previousJButton.setBounds(16, 190, 90, 24);
        previousJButton.setText("Previous");
        contentPane.add(previousJButton);
        // anonymous inner class
        // event handler called when previousJButton is pressed
        previousJButton.addActionListener(

                this::previousJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set up nextJButton
        JButton nextJButton = new JButton();
        nextJButton.setBounds(164, 190, 90, 24);
        nextJButton.setText("Next");
        contentPane.add(nextJButton);
        // anonymous inner class
        // event handler called when nextJButton is pressed
        nextJButton.addActionListener(

                this::nextJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set properties of application's window
        setTitle("Account Information"); // set title bar string
        setSize(300, 260);               // set window size
        setVisible(true);                // display window

    } // end method createUserInterface

    // display next account
    private void nextJButtonActionPerformed(ActionEvent event) {
        position++;
        // prevent position from becoming invalid
        if (position >= accountRecords.length) {
            position = 0;
        }
        displayInformation();
    } // end method nextJButtonActionPerformed

    // display previous account
    private void previousJButtonActionPerformed(ActionEvent event) {
        position--;
        // prevent position from becoming invalid
        if (position < 0) {
            position = accountRecords.length - 1;
        }
        displayInformation();
    } // end method previousJButtonActionPerformed

    // display correct information in the correct JTextFields
    private void displayInformation() {
        // format to display decimal numbers.
        DecimalFormat balanceFormat = new DecimalFormat(".00");

        firstJTextField.setText(accountRecords[position].getFirstName());
        lastJTextField.setText(accountRecords[position].getLastName());
        numberJTextField.setText(String.valueOf(accountRecords[position].getAccountNumber()));
        balanceJTextField.setText(balanceFormat.format(accountRecords[position].getBalanceAmount()));

    } // end method displayInformation

} // end class AccountInformation

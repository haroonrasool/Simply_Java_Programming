package tutorial_11;

// Tutorial 11: SecurityPanel.java
// Enable user to enter security codes specifying access privileges.

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.text.DateFormat;
import java.util.Date;

public class SecurityPanel extends JFrame {
    private JPasswordField securityCodeJPasswordField;

    private JTextArea accessLogJTextArea;

    // no-argument constructor
    public SecurityPanel() {
        createUserInterface();
    }

    // main method
    public static void main(String[] args) {
        SecurityPanel application = new SecurityPanel();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } // end method main

    // create and position GUI components; register event handlers
    private void createUserInterface() {
        // get content pane for attaching GUI components
        Container contentPane = getContentPane();

        // enable explicit positioning of GUI components
        contentPane.setLayout(null);

        // set up securityCodeJLabel
        // JLabel and JPasswordField for user to input security code
        JLabel securityCodeJLabel = new JLabel();
        securityCodeJLabel.setBounds(16, 16, 90, 21);
        securityCodeJLabel.setText("Security code:");
        contentPane.add(securityCodeJLabel);

        // set up securityCodeJPasswordField
        securityCodeJPasswordField = new JPasswordField();
        securityCodeJPasswordField.setBounds(114, 16, 172, 26);
        securityCodeJPasswordField.setEditable(false);
        contentPane.add(securityCodeJPasswordField);

        // set up oneJButton
        // JButtons to represent security keypad
        JButton oneJButton = new JButton();
        oneJButton.setBounds(80, 64, 50, 50);
        oneJButton.setText("1");
        contentPane.add(oneJButton);
        // anonymous inner class
        // event handler called when oneJButton is pressed
        oneJButton.addActionListener(

                this::oneJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set up twoJButton
        JButton twoJButton = new JButton();
        twoJButton.setBounds(130, 64, 50, 50);
        twoJButton.setText("2");
        contentPane.add(twoJButton);
        // anonymous inner class
        // event handler called when twoJButton is pressed
        twoJButton.addActionListener(

                this::twoJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set up threeJButton
        JButton threeJButton = new JButton();
        threeJButton.setBounds(180, 64, 50, 50);
        threeJButton.setText("3");
        contentPane.add(threeJButton);
        // anonymous inner class
        // event handler called when threeJButton is pressed
        threeJButton.addActionListener(

                this::threeJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set up fourJButton
        JButton fourJButton = new JButton();
        fourJButton.setBounds(80, 114, 50, 50);
        fourJButton.setText("4");
        contentPane.add(fourJButton);
        // anonymous inner class
        // event handler called when fourJButton is pressed
        fourJButton.addActionListener(

                this::fourJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set up fiveJButton
        JButton fiveJButton = new JButton();
        fiveJButton.setBounds(130, 114, 50, 50);
        fiveJButton.setText("5");
        contentPane.add(fiveJButton);
        // anonymous inner class
        // event handler called when fiveJButton is pressed
        fiveJButton.addActionListener(

                this::fiveJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set up sixJButton
        JButton sixJButton = new JButton();
        sixJButton.setBounds(180, 114, 50, 50);
        sixJButton.setText("6");
        contentPane.add(sixJButton);
        // anonymous inner class
        // event handler called when sixJButton is pressed
        sixJButton.addActionListener(

                this::sixJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set up sevenJButton
        JButton sevenJButton = new JButton();
        sevenJButton.setBounds(80, 164, 50, 50);
        sevenJButton.setText("7");
        contentPane.add(sevenJButton);
        // anonymous inner class
        // event handler called when sevenJButton is pressed
        sevenJButton.addActionListener(

                this::sevenJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set up eightJButton
        JButton eightJButton = new JButton();
        eightJButton.setBounds(130, 164, 50, 50);
        eightJButton.setText("8");
        contentPane.add(eightJButton);
        // anonymous inner class
        // event handler called when eightJButton is pressed
        eightJButton.addActionListener(

                this::eightJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set up nineJButton
        JButton nineJButton = new JButton();
        nineJButton.setBounds(180, 164, 50, 50);
        nineJButton.setText("9");
        contentPane.add(nineJButton);
        // anonymous inner class
        // event handler called when nineJButton is pressed
        nineJButton.addActionListener(

                this::nineJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set up clearJButton
        JButton clearJButton = new JButton();
        clearJButton.setBounds(80, 214, 50, 50);
        clearJButton.setText("C");
        contentPane.add(clearJButton);
        // anonymous inner class
        // event handler called when clearJButton is pressed
        clearJButton.addActionListener(

                this::clearJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set up zeroJButton
        JButton zeroJButton = new JButton();
        zeroJButton.setBounds(130, 214, 50, 50);
        zeroJButton.setText("0");
        contentPane.add(zeroJButton);
        // anonymous inner class
        // event handler called when zeroJButton is pressed
        zeroJButton.addActionListener(

                this::zeroJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set up enterJButton
        JButton enterJButton = new JButton();
        enterJButton.setBounds(180, 214, 50, 50);
        enterJButton.setText("#");
        contentPane.add(enterJButton);
        // anonymous inner class
        // event handler called when enterJButton is pressed
        enterJButton.addActionListener(

                event -> enterJButtonActionPerformed() // end anonymous inner class

        ); // end call to addActionListener

        // set up accessLogJLabel
        // JLabel, JTextArea and JScrollPane to display access log
        JLabel accessLogJLabel = new JLabel();
        accessLogJLabel.setBounds(16, 285, 100, 16);
        accessLogJLabel.setText("Access log:");
        contentPane.add(accessLogJLabel);

        // set up accessLogJTextArea
        accessLogJTextArea = new JTextArea();

        // set up accessLogJScrollPane
        JScrollPane accessLogJScrollPane = new JScrollPane(accessLogJTextArea);
        accessLogJScrollPane.setBounds(16, 309, 270, 95);
        contentPane.add(accessLogJScrollPane);

        // set properties of application's window
        setTitle("Security Panel"); // set title bar string
        setSize(310, 450);          // set window's size
        setVisible(true);           // display window

    } // end method createUserInterface

    // append 1 to the security code
    private void oneJButtonActionPerformed(ActionEvent event) {
        securityCodeJPasswordField.setText(String.valueOf(
                securityCodeJPasswordField.getPassword()) + "1");

    } // end method oneJButtonActionPerformed

    // append 2 to the security code
    private void twoJButtonActionPerformed(ActionEvent event) {
        securityCodeJPasswordField.setText(String.valueOf(
                securityCodeJPasswordField.getPassword()) + "2");

    } // end method twoJButtonActionPerformed

    // append 3 to the security code
    private void threeJButtonActionPerformed(ActionEvent event) {
        securityCodeJPasswordField.setText(String.valueOf(
                securityCodeJPasswordField.getPassword()) + "3");

    } // end method threeJButtonActionPerformed

    // append 4 to the security code
    private void fourJButtonActionPerformed(ActionEvent event) {
        securityCodeJPasswordField.setText(String.valueOf(
                securityCodeJPasswordField.getPassword()) + "4");

    } // end method fourJButtonActionPerformed

    // append 5 to the security code
    private void fiveJButtonActionPerformed(ActionEvent event) {
        securityCodeJPasswordField.setText(String.valueOf(
                securityCodeJPasswordField.getPassword()) + "5");

    } // end method fiveJButtonActionPerformed

    // append 6 to the security code
    private void sixJButtonActionPerformed(ActionEvent event) {
        securityCodeJPasswordField.setText(String.valueOf(
                securityCodeJPasswordField.getPassword()) + "6");

    } // end method sixJButtonActionPerformed

    // append 7 to the security code
    private void sevenJButtonActionPerformed(ActionEvent event) {
        securityCodeJPasswordField.setText(String.valueOf(
                securityCodeJPasswordField.getPassword()) + "7");

    } // end method sevenJButtonActionPerformed

    // append 8 to the security code
    private void eightJButtonActionPerformed(ActionEvent event) {
        securityCodeJPasswordField.setText(String.valueOf(
                securityCodeJPasswordField.getPassword()) + "8");

    } // end method eightJButtonActionPerformed

    // append 9 to the security code
    private void nineJButtonActionPerformed(ActionEvent event) {
        securityCodeJPasswordField.setText(String.valueOf(
                securityCodeJPasswordField.getPassword()) + "9");

    } // end method nineJButtonActionPerformed

    // append 0 to the security code
    private void zeroJButtonActionPerformed(ActionEvent event) {
        securityCodeJPasswordField.setText(String.valueOf(
                securityCodeJPasswordField.getPassword()) + "0");

    } // end method zeroJButtonActionPerformed

    // clears the securityCodeJPasswordField
    private void clearJButtonActionPerformed(ActionEvent event) {
        securityCodeJPasswordField.setText("");

    } // end method clearJButtonActionPerformed

    // gets access code and determines level of clearance
    private void enterJButtonActionPerformed() {
        String message; // displays access status of users

        // stores access code entered
        int accessCode = Integer.parseInt(String.valueOf(
                securityCodeJPasswordField.getPassword()));

        securityCodeJPasswordField.setText("");

        switch (accessCode) // check access code input
        {
            // access code equal to 1234
            case 1234:
                message = "Testing";
                break;

            // access code is 7, 8 or 9
            case 7:
            case 8:
            case 9:
                message = "Restricted Access";
                break; // done processing case

            // access code equal to 1645
            case 1645:
                message = "Technician";
                break; // done processing case

            // access code equal to 8345
            case 8345:
                message = "Custodian";
                break; // done processing case

            // access code equal to 9998 or between 1006 and 1008
            case 9998:
            case 1006:
            case 1007:
            case 1008:
                message = "Scientist";
                break; // done processing case

            // if no other case is true
            default:
                message = "Access Denied";

        } // end switch statement

        // display time and message in accessLogJTextArea
        DateFormat formatter = DateFormat.getDateTimeInstance();
        accessLogJTextArea.append(formatter.format(new Date()) +
                "   " + message + "\n");

    } // end method enterJButtonActionPerformed

} // end class SecurityPanel

package tutorial_13;

// Exercise 13.16: PayRaise.java
// Application that calculates yearly salaries given an annual 
// raise percentage and number of years.

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;

public class PayRaise extends JFrame {
    private JSpinner raiseJSpinner;

    private JSpinner yearsJSpinner;

    private JTextArea amountEarnedJTextArea;

    // no-argument constructor
    public PayRaise() {
        createUserInterface();

        // display initial yearly wage in JTextArea
        calculateWages();
    }

    // main method
    public static void main(String[] args) {
        PayRaise application = new PayRaise();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } // end method main

    // create and position GUI components; register event handlers
    private void createUserInterface() {
        // get content pane for attaching GUI components
        Container contentPane = getContentPane();

        // enable explicit positioning of GUI components
        contentPane.setLayout(null);

        // set up raiseJLabel
        // JLabel and JSpinner for yearly raise
        JLabel raiseJLabel = new JLabel();
        raiseJLabel.setBounds(20, 25, 150, 20);
        raiseJLabel.setText("Amount of raise (in %):");
        contentPane.add(raiseJLabel);

        // set up raiseJSpinner
        raiseJSpinner = new JSpinner(
                new SpinnerNumberModel(3, 3, 8, 1));
        raiseJSpinner.setBounds(170, 25, 70, 22);
        contentPane.add(raiseJSpinner);
        // anonymous inner class
        // event handler called when raiseJSpinner is changed
        raiseJSpinner.addChangeListener(

                event -> {

                } // end anonymous inner class

        ); // end call to addChangeListener

        // set up yearsJLabel
        // JLabel and JSpinner for number of years
        JLabel yearsJLabel = new JLabel();
        yearsJLabel.setBounds(20, 60, 80, 20);
        yearsJLabel.setText("Years:");
        contentPane.add(yearsJLabel);

        // set up yearsJSpinner
        yearsJSpinner = new JSpinner(
                new SpinnerNumberModel(1, 1, 50, 1));
        yearsJSpinner.setBounds(170, 60, 70, 22);
        contentPane.add(yearsJSpinner);
        // anonymous inner class
        // event handler called when yearsJSpinner is changed
        yearsJSpinner.addChangeListener(

                event -> {

                } // end anonymous inner class

        ); // end call to addChangeListener

        // set up amountEarnedJLabel
        // JLabel and JTextArea for amount earned
        // after a certain number of years
        JLabel amountEarnedJLabel = new JLabel();
        amountEarnedJLabel.setBounds(20, 95, 150, 20);
        amountEarnedJLabel.setText("Yearly amount earned:");
        contentPane.add(amountEarnedJLabel);

        // set up amountEarnedJTextArea
        amountEarnedJTextArea = new JTextArea();
        amountEarnedJTextArea.setEditable(false);

        // set up amountEarnedJScrollPane
        // JScrollPane adds scrollbars to amountEarnedJTextArea
        JScrollPane amountEarnedJScrollPane = new JScrollPane(
                amountEarnedJTextArea);
        amountEarnedJScrollPane.setBounds(20, 120, 330, 115);
        contentPane.add(amountEarnedJScrollPane);

        // set properties of application's window
        setTitle("Pay Raise Calculator"); // set title-bar string
        setSize(380, 280);                // set window size
        setVisible(true);                 // show window

    } // end method createUserInterface

    // calculate and display yearly wages
    private void calculateWages() {
        // store weekly starting wage
        double wage = 500;

        // retrieve raise from raiseJSpinner
        int rate = (Integer) raiseJSpinner.getValue();

        // retrieve years from yearsJSpinner
        int years = (Integer) yearsJSpinner.getValue();

        // display amount earned in amountEarnedJTextArea
        amountEarnedJTextArea.setText("Year\tAmount");

        // decimal format
        DecimalFormat dollars = new DecimalFormat("$0.00");

        // for loop calculates total
        for (int counter = 1; counter <= years; counter++) {
            double amount = wage * 52;
            amountEarnedJTextArea.append(
                    "\n" + counter + "\t" + dollars.format(amount));

            wage *= (1 + ((double) rate / 100));

        } // end for

    } // end method calculateWages

} // end class PayRaise

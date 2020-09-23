package tutorial_16;

// Exercise 16.12: SalarySurvey.java
// Application that takes information about employee salaries and
// uses an array to keep track of the number of employees in each
// salary range.

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.text.DecimalFormat;

public class SalarySurvey extends JFrame {
    // format to display the amount in Dollars format.
    DecimalFormat dollars = new DecimalFormat("$0.00");

    // retrieving and displaying the amounts in JTextFields.
    private JTextField enterSalesJTextField;
    private JTextField salaryJTextField;
    private JTextArea resultJTextArea;

    // create an empty integer type array to store the number of employees.
    int[] resultArray = new int[11];

    // no-argument constructor
    public SalarySurvey() {
        createUserInterface();
    }

    // main method
    public static void main(String[] args) {
        SalarySurvey application = new SalarySurvey();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } // end method main

    // create and position GUI components; register event handlers
    private void createUserInterface() {
        // get content pane for attaching GUI components
        Container contentPane = getContentPane();

        // enable explicit positioning of GUI components
        contentPane.setLayout(null);

        // set up enterSalesJLabel
        // JLabel and JTextField for entering total sales
        JLabel enterSalesJLabel = new JLabel();
        enterSalesJLabel.setBounds(20, 20, 80, 20);
        enterSalesJLabel.setText("Enter sales:");
        contentPane.add(enterSalesJLabel);

        // set up salesJTextField
        enterSalesJTextField = new JTextField();
        enterSalesJTextField.setBounds(120, 20, 70, 20);
        enterSalesJTextField.setHorizontalAlignment(
                JTextField.RIGHT);
        contentPane.add(enterSalesJTextField);

        // set up calculateJButton
        // JButton to calculate the total salary
        JButton calculateJButton = new JButton();
        calculateJButton.setBounds(55, 60, 110, 20);
        calculateJButton.setText("Calculate");
        contentPane.add(calculateJButton);
        // anonymous inner class
        // event handler called when calculateJButton is pressed
        calculateJButton.addActionListener(

                this::calculateJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set up salaryJLabel
        // JLabel and JTextField for displaying the total salary
        JLabel salaryJLabel = new JLabel();
        salaryJLabel.setBounds(20, 100, 80, 20);
        salaryJLabel.setText("Total salary:");
        contentPane.add(salaryJLabel);

        // set up salaryJTextField
        salaryJTextField = new JTextField();
        salaryJTextField.setBounds(120, 100, 70, 20);
        salaryJTextField.setHorizontalAlignment(JTextField.CENTER);
        salaryJTextField.setEditable(false);
        contentPane.add(salaryJTextField);

        // set up totalsJButton
        // JButton for displaying the totals
        JButton totalsJButton = new JButton();
        totalsJButton.setBounds(55, 140, 110, 20);
        totalsJButton.setText("Show Totals");
        contentPane.add(totalsJButton);
        // anonymous inner class
        // event handler called when totalsJButton is pressed
        totalsJButton.addActionListener(

                this::totalsJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set up resultJLabel
        // JLabel and JTextArea for displaying the survey results
        JLabel resultJLabel = new JLabel();
        resultJLabel.setBounds(20, 180, 100, 20);
        resultJLabel.setText("Survey results:");
        contentPane.add(resultJLabel);

        // set up resultJTextArea
        resultJTextArea = new JTextArea();
        resultJTextArea.setBounds(20, 210, 170, 180);
        contentPane.add(resultJTextArea);

        // set properties of application's window
        setTitle("Salary Survey"); // set title bar string
        setSize(220, 450);         // set window size
        setVisible(true);          // display window

    } // end method createUserInterface

    // calculate salary; increment counters
    private void calculateJButtonActionPerformed(ActionEvent event) {
        // retrieving the user input from enterSalesJTextField.
        int sales = Integer.parseInt(enterSalesJTextField.getText());

        // calculating the salary based on the sales.
        double salary = 200 + .09 * sales;

        // determine the indexes for the salary ranges.
        int index = (int) salary / 100;

        // increment salary counters
        if (index >= 10) {
            // increment counters
            resultArray[10]++;
        } else {
            // increment counter
            resultArray[index]++;
        }

        // displaying the salary in salaryJTextField.
        salaryJTextField.setText(dollars.format(salary));

    } // end method calculateJButtonActionPerformed

    // display salary ranges and totals
    private void totalsJButtonActionPerformed(ActionEvent event) {
        int lowerBound;
        int upperBound;

        // set the header for the JTextArea
        resultJTextArea.setText("Salary Range:\tTotal:\n");

        // display the salary ranges in resultJTextArea
        for (int i = 2; i < resultArray.length - 1; i++) {
            lowerBound = i * 100;
            upperBound = lowerBound + 99;

            resultJTextArea.append("$" + lowerBound + "-" + upperBound + "\t" + resultArray[i] + "\n");
        }
        resultJTextArea.append("$1000+\t" + resultArray[10]);

        // clear the salesJTextField
        enterSalesJTextField.setText("");
    } // end method totalsJButtonActionPerformed

} // end class SalarySurvey

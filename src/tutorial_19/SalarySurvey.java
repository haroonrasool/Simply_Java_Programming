package tutorial_19;

// Exercise 19.11: SalarySurvey.java
// Application that takes information about employee salaries and
// uses an array to keep track of the number of employees in each
// salary range.

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;

public class SalarySurvey extends JFrame {
    // int array to hold totals
    int[] resultArray = new int[11];

    // DecimalFormat to format output
    DecimalFormat dollars = new DecimalFormat("$0.00");

    // JTextFields
    private JTextField enterSalesJTextField;
    private JTextField totalSalaryJTextField;

    // JTextArea
    private JTextArea surveyResultsJTextArea;

    // String[] and two ArrayLists to hold salaries
    private final String[] salaryRangesArray = {"$200-$299",
            "$300-$399", "$400-$499", "$500-$599",
            "$600-$699", "$700-$799", "$800-$899",
            "$900-$999", "$1000+"};
    private final ArrayList<Object> rangesArrayList = new ArrayList<>();

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
        // JLabel and JTextField for sales input
        JLabel enterSalesJLabel = new JLabel();
        enterSalesJLabel.setBounds(20, 20, 80, 20);
        enterSalesJLabel.setText("Enter sales:");
        contentPane.add(enterSalesJLabel);

        // set up enterSalesJTextField
        enterSalesJTextField = new JTextField();
        enterSalesJTextField.setBounds(120, 20, 70, 20);
        enterSalesJTextField.setHorizontalAlignment(
                JTextField.RIGHT);
        contentPane.add(enterSalesJTextField);

        // set up calculateJButton
        // JButton to initiate calculation of salary
        JButton calculateJButton = new JButton();
        calculateJButton.setBounds(55, 60, 110, 20);
        calculateJButton.setText("Calculate");
        contentPane.add(calculateJButton);
        // anonymous inner class
        // event handler called when calculateJButton is pressed
        calculateJButton.addActionListener(

                this::calculateJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set up totalSalaryJLabel
        // JLabel and JTextField for salary output
        JLabel totalSalaryJLabel = new JLabel();
        totalSalaryJLabel.setBounds(20, 100, 80, 20);
        totalSalaryJLabel.setText("Total salary:");
        contentPane.add(totalSalaryJLabel);

        // set up totalSalaryJTextField
        totalSalaryJTextField = new JTextField();
        totalSalaryJTextField.setBounds(120, 100, 70, 20);
        totalSalaryJTextField.setHorizontalAlignment(
                JTextField.CENTER);
        totalSalaryJTextField.setEditable(false);
        contentPane.add(totalSalaryJTextField);

        // set up showTotalsJButton
        // JButton to display salaries and totals
        JButton showTotalsJButton = new JButton();
        showTotalsJButton.setBounds(55, 140, 110, 20);
        showTotalsJButton.setText("Show Totals");
        contentPane.add(showTotalsJButton);
        // anonymous inner class
        // event handler called when showTotalsJButton is pressed
        showTotalsJButton.addActionListener(

                this::showTotalsJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set up surveyResultsJLabel
        // JLabel and JTextArea for salaries and totals
        JLabel surveyResultsJLabel = new JLabel();
        surveyResultsJLabel.setBounds(20, 180, 100, 20);
        surveyResultsJLabel.setText("Survey results:");
        contentPane.add(surveyResultsJLabel);

        // set up surveyResultsJTextArea
        surveyResultsJTextArea = new JTextArea();
        surveyResultsJTextArea.setBounds(20, 210, 170, 180);
        contentPane.add(surveyResultsJTextArea);

        // add all salary ranges to rangesArrayList
        rangesArrayList.addAll(Arrays.asList(salaryRangesArray).subList(0, 9));

        // set properties of application's window
        setTitle("Salary Survey"); // set title bar string
        setSize(220, 450);         // set window size
        setVisible(true);          // display window

    } // end method createUserInterface

    // calculate the total salary based on user input
    private void calculateJButtonActionPerformed(ActionEvent event) {
        // get user input from enterSalesJTextField.
        int sales = Integer.parseInt(enterSalesJTextField.getText());

        // calculate salary.
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

        // display salary
        totalSalaryJTextField.setText(dollars.format(salary));

    } // end calculateJButtonActionPerformed

    // display range of salaries
    private void showTotalsJButtonActionPerformed(
            ActionEvent event) {
        // clear surveyResultsJTextArea
        surveyResultsJTextArea.setText("");

        // add header to surveyResultsJTextArea
        surveyResultsJTextArea.append("Salary Range:\tTotal:\n");

        // counter variable
        int i = 2;

        // set iterator

        // for each salary, add output to List
        for (Object object : rangesArrayList) {
            // set reference variable
            String range = (String) object;

            // add output information to surveyResultsJTextArea
            surveyResultsJTextArea.append(range + '\t' +
                    +resultArray[i] + "\n");
            i++; // increment counter

        } // end while loop

        // clear the salesJTextField
        enterSalesJTextField.setText("");

    } // end showTotalsJButtonActionPerformed

} // end class SalarySurvey

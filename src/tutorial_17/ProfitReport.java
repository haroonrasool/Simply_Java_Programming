package tutorial_17;

// Exercise 17.13: ProfitReport.java
// This application calculates and displays one week's profits.

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.text.DecimalFormat;

public class ProfitReport extends JFrame {
    // JTextFields
    private JTextField itemJTextField;
    private JTextField mondayJTextField;
    private JTextField tuesdayJTextField;
    private JTextField wednesdayJTextField;
    private JTextField thursdayJTextField;
    private JTextField fridayJTextField;
    private JTextField profitsJTextField;

    // JButton to submit gain or loss
    private JButton submitItemJButton;

    // JRadioButton
    private JRadioButton gainJRadioButton;

    // JTextArea
    private JTextArea displayJTextArea;

    // constants
    private final int NUMBER_OF_DAYS = 5;
    private final int MAXIMUM_ITEMS = 10;

    // initialize number of items to zero
    private int itemCount = 0;

    // one-dimensional array to store names of items
    private final String[] itemNames = new String[MAXIMUM_ITEMS];

    // two-dimensional array to store items
    private final double[][] dailyItems =
            new double[MAXIMUM_ITEMS][NUMBER_OF_DAYS];

    // DecimalFormat for two digits of precision
    private final DecimalFormat dollars = new DecimalFormat("$0.00");

    // no-argument constructor
    public ProfitReport() {
        createUserInterface();
    }

    // main method
    public static void main(String[] args) {
        ProfitReport application = new ProfitReport();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } // end method main

    // create and position GUI components; register event handlers
    private void createUserInterface() {
        // get content pane for attaching GUI components
        Container contentPane = getContentPane();

        // enable explicit positioning of GUI components
        contentPane.setLayout(null);

        // set up inputItemJPanel
        // JPanel for user inputs
        JPanel inputItemJPanel = new JPanel();
        inputItemJPanel.setBounds(16, 16, 208, 242);
        inputItemJPanel.setBorder(new TitledBorder("Input Item"));
        inputItemJPanel.setLayout(null);
        contentPane.add(inputItemJPanel);

        // set up itemJLabel
        // JLabel and JTextField for item name
        JLabel itemJLabel = new JLabel();
        itemJLabel.setBounds(12, 32, 90, 23);
        itemJLabel.setText("Item:");
        inputItemJPanel.add(itemJLabel);

        // set up itemJTextField
        itemJTextField = new JTextField();
        itemJTextField.setBounds(104, 32, 88, 21);
        itemJTextField.setHorizontalAlignment(JTextField.LEFT);
        inputItemJPanel.add(itemJTextField);

        // set up mondayJLabel
        // JLabel and JTextField for monday
        JLabel mondayJLabel = new JLabel();
        mondayJLabel.setBounds(12, 74, 80, 23);
        mondayJLabel.setText("Monday:");
        inputItemJPanel.add(mondayJLabel);

        // set up mondayJTextField
        mondayJTextField = new JTextField();
        mondayJTextField.setBounds(136, 74, 56, 21);
        mondayJTextField.setHorizontalAlignment(JTextField.CENTER);
        inputItemJPanel.add(mondayJTextField);

        // set up tuesdayJLabel
        // JLabel and JTextField for tuesday
        JLabel tuesdayJLabel = new JLabel();
        tuesdayJLabel.setBounds(12, 98, 80, 23);
        tuesdayJLabel.setText("Tuesday:");
        inputItemJPanel.add(tuesdayJLabel);

        // set up tuesdayJTextField
        tuesdayJTextField = new JTextField();
        tuesdayJTextField.setBounds(136, 98, 56, 21);
        tuesdayJTextField.setHorizontalAlignment(JTextField.CENTER);
        inputItemJPanel.add(tuesdayJTextField);

        // set up wednesdayJLabel
        // JLabel and JTextField for wednesday
        JLabel wednesdayJLabel = new JLabel();
        wednesdayJLabel.setBounds(12, 122, 80, 23);
        wednesdayJLabel.setText("Wednesday:");
        inputItemJPanel.add(wednesdayJLabel);

        // set up wednesdayJTextField
        wednesdayJTextField = new JTextField();
        wednesdayJTextField.setBounds(136, 122, 56, 21);
        wednesdayJTextField.setHorizontalAlignment(JTextField.CENTER);
        inputItemJPanel.add(wednesdayJTextField);

        // set up thursdayJLabel
        // JLabel and JTextField for thursday
        JLabel thursdayJLabel = new JLabel();
        thursdayJLabel.setBounds(12, 146, 80, 23);
        thursdayJLabel.setText("Thursday:");
        inputItemJPanel.add(thursdayJLabel);

        // set up thursdayJTextField
        thursdayJTextField = new JTextField();
        thursdayJTextField.setBounds(136, 146, 56, 21);
        thursdayJTextField.setHorizontalAlignment(JTextField.CENTER);
        inputItemJPanel.add(thursdayJTextField);

        // set up fridayJLabel
        // JLabel and JTextField for friday
        JLabel fridayJLabel = new JLabel();
        fridayJLabel.setBounds(12, 170, 80, 23);
        fridayJLabel.setText("Friday:");
        inputItemJPanel.add(fridayJLabel);

        // set up fridayJTextField
        fridayJTextField = new JTextField();
        fridayJTextField.setBounds(136, 170, 56, 21);
        fridayJTextField.setHorizontalAlignment(JTextField.CENTER);
        inputItemJPanel.add(fridayJTextField);

        // set up submitItemJButton
        submitItemJButton = new JButton();
        submitItemJButton.setBounds(64, 206, 128, 24);
        submitItemJButton.setText("Submit Item");
        inputItemJPanel.add(submitItemJButton);
        // anonymous inner class
        // event handler called when submitItemJButton is clicked
        submitItemJButton.addActionListener(

                this::submitItemJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set up profitButtonGroup
        // ButtonGroup for gains and losses
        ButtonGroup profitButtonGroup = new ButtonGroup();

        // set up gainJRadioButton
        // JRadioButtons for gains and losses
        gainJRadioButton = new JRadioButton();
        gainJRadioButton.setBounds(55, 270, 75, 23);
        gainJRadioButton.setText("Gain");
        gainJRadioButton.setSelected(true);
        profitButtonGroup.add(gainJRadioButton);
        contentPane.add(gainJRadioButton);

        // set up lossJRadioButton
        JRadioButton lossJRadioButton = new JRadioButton();
        lossJRadioButton.setBounds(140, 270, 75, 23);
        lossJRadioButton.setText("Loss");
        profitButtonGroup.add(lossJRadioButton);
        contentPane.add(lossJRadioButton);

        // set up displayJLabel
        // JLabel and JTextArea to display profits
        JLabel displayJLabel = new JLabel();
        displayJLabel.setBounds(240, 16, 150, 23);
        displayJLabel.setText("Itemized profits:");
        contentPane.add(displayJLabel);

        // set up displayJTextArea
        displayJTextArea = new JTextArea();
        displayJTextArea.setEditable(false);

        // set up displayJScrollPane
        JScrollPane displayJScrollPane = new JScrollPane(displayJTextArea);
        displayJScrollPane.setBounds(240, 48, 535, 208);
        contentPane.add(displayJScrollPane);

        // set up profitsJLabel
        // JLabel and JTextField to display profits
        JLabel profitsJLabel = new JLabel();
        profitsJLabel.setBounds(624, 268, 96, 23);
        profitsJLabel.setText("Gross Profits:");
        contentPane.add(profitsJLabel);

        // set up profitsJTextField
        profitsJTextField = new JTextField();
        profitsJTextField.setBounds(708, 268, 66, 23);
        profitsJTextField.setHorizontalAlignment(JTextField.CENTER);
        profitsJTextField.setEditable(false);
        contentPane.add(profitsJTextField);

        // set properties of application's window
        setTitle("Profit Report"); // set title bar string
        setSize(800, 340);         // set window size
        setVisible(true);          // display window

    } // end method createUserInterface

    // calculate and display the item totals and weekly total
    private void submitItemJButtonActionPerformed(ActionEvent event) {
        // get user input
        String nameOfItem = itemJTextField.getText();
        double monday =
                Double.parseDouble(mondayJTextField.getText());
        double tuesday =
                Double.parseDouble(tuesdayJTextField.getText());
        double wednesday =
                Double.parseDouble(wednesdayJTextField.getText());
        double thursday =
                Double.parseDouble(thursdayJTextField.getText());
        double friday =
                Double.parseDouble(fridayJTextField.getText());

        // add name to array
        itemNames[itemCount] = nameOfItem;

        if (gainJRadioButton.isSelected()) {
            // add gains to array
            dailyItems[itemCount][0] = monday;
            dailyItems[itemCount][1] = tuesday;
            dailyItems[itemCount][2] = wednesday;
            dailyItems[itemCount][3] = thursday;
            dailyItems[itemCount][4] = friday;
        } else {
            // add losses to array
            dailyItems[itemCount][0] = -monday;
            dailyItems[itemCount][1] = -tuesday;
            dailyItems[itemCount][2] = -wednesday;
            dailyItems[itemCount][3] = -thursday;
            dailyItems[itemCount][4] = -friday;
        }

        itemCount++; // increment the number of items

        displayProfits();

        // clear other JTextFields for new data
        itemJTextField.setText("");
        mondayJTextField.setText("");
        tuesdayJTextField.setText("");
        wednesdayJTextField.setText("");
        thursdayJTextField.setText("");
        fridayJTextField.setText("");

        // if 10 or more items
        if (itemCount == MAXIMUM_ITEMS) {
            // disable submitItemJButton
            submitItemJButton.setEnabled(false);
        }

    } // end method submitItemJButtonActionPerformed

    // display profits by type and day of week
    private void displayProfits() {
        // add a header to displayJTextArea
        displayJTextArea.setText("Name\tMonday\tTuesday\t" +
                "Wednesday\tThursday\tFriday\tTotal\n");

        // declare weekly total
        double weekTotal;

        // initialize total profits
        double profitsTotal = 0;

        // calculate items
        for (int item = 0; item < itemCount; item++) {
            // append the name of the item to displayJTextArea
            displayJTextArea.append(itemNames[item] + "\t");

            weekTotal = 0; // initialize weekly total

            for (int day = 0; day < NUMBER_OF_DAYS; day++) {
                // append the day's gain
                displayJTextArea.append(dollars.format(
                        dailyItems[item][day]) + "\t");

                // add day's gain to weekly total
                weekTotal += dailyItems[item][day];

            } // end for

            profitsTotal += weekTotal; // add weekly total to profits

            // append the weekly total to displayJTextArea
            displayJTextArea.append(
                    dollars.format(weekTotal) + "\n");

        } // end for

        // output the total profits
        profitsJTextField.setText(dollars.format(profitsTotal));

    } // end method displayProfits

} // end class ProfitReport

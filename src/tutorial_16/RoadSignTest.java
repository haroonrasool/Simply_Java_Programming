package tutorial_16;

// Exercise 16.16: RoadSignTest.java
// Tests the user on their knowledge of road signs. The user must 
// try to match five signs to their meanings.

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Arrays;
import java.util.Random;

public class RoadSignTest extends JFrame {
    private JLabel signIconJLabel;

    private JComboBox<String> signJComboBox;

    // JTextField for providing feedback to the user
    private JTextField feedbackJTextField;

    // JButton to submit the users answer and display the result
    private JButton submitJButton;

    // JButton to display the next sign image
    private JButton nextSignJButton;

    private int currentIndex; // integer holds the current array index
    private int count = 1; // integer counts number of signs displayed

    // declaring an array to contain the user's input.
    String[] signs = new String[]{"Do Not Enter", "Narrow Bridge", "No Bicycles",
            "No Left Turn", "No Pedestrians", "No U-Turn", "Road Narrows",
            "Stop", "Stop Sign Ahead", "Traffic Signals Ahead", "Winding Road Ahead", "Yield"};

    // Declare a boolean array to store which signs are used.
    private final boolean[] signsUsed = new boolean[signs.length];

    // no-argument constructor
    public RoadSignTest() {
        createUserInterface();
    }

    // main method
    public static void main(String[] args) {
        RoadSignTest application = new RoadSignTest();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    } // end method main

    // create and position GUI components; register event handlers
    private void createUserInterface() {
        // get content pane for attaching GUI components
        Container contentPane = getContentPane();

        // enable explicit positioning of GUI components
        contentPane.setLayout(null);

        // set up signIconJPanel
        // JPanel and JLabel for displaying a sign image
        JPanel signIconJPanel = new JPanel();
        signIconJPanel.setBounds(16, 8, 100, 94);
        signIconJPanel.setBorder(new TitledBorder("Sign"));
        contentPane.add(signIconJPanel);

        // set up signIconJLabel
        signIconJLabel = new JLabel();
        signIconJLabel.setHorizontalAlignment(JLabel.CENTER);
        signIconJPanel.add(signIconJLabel);

        // set up chooseJLabel
        // JLabel and JComboBox for choosing a sign
        JLabel chooseJLabel = new JLabel();
        chooseJLabel.setBounds(136, 8, 88, 21);
        chooseJLabel.setText("Select sign:");
        contentPane.add(chooseJLabel);

        // set up signJComboBox
        signJComboBox = new JComboBox<>(signs);
        signJComboBox.setBounds(136, 32, 144, 21);
        contentPane.add(signJComboBox);

        // display the first sign
        displaySign();

        // sort the signs array alphabetically
        Arrays.sort(signs);

        // set up feedbackJTextField
        feedbackJTextField = new JTextField();
        feedbackJTextField.setBounds(136, 64, 144, 36);
        feedbackJTextField.setHorizontalAlignment(JTextField.CENTER);
        feedbackJTextField.setEditable(false);
        contentPane.add(feedbackJTextField);

        // set up submitJButton
        submitJButton = new JButton();
        submitJButton.setBounds(296, 8, 88, 32);
        submitJButton.setText("Submit");
        contentPane.add(submitJButton);
        // anonymous inner class
        // event handler called when submitJButton is pressed
        submitJButton.addActionListener(

                this::submitJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set up nextSignJButton
        nextSignJButton = new JButton();
        nextSignJButton.setBounds(296, 48, 88, 32);
        nextSignJButton.setText("Next Sign");
        nextSignJButton.setEnabled(false);
        contentPane.add(nextSignJButton);
        // anonymous inner class
        // event handler called when nextSignJButton is pressed
        nextSignJButton.addActionListener(

                this::nextSignJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set properties of application's window
        setTitle("Road Sign Test"); // set title bar string
        setSize(410, 150);          // set window size
        setVisible(true);           // display window

    } // end method createUserInterface

    // return an unused random number
    private int getUniqueRandomNumber() {
        Random randomGenerator = new Random();
        int randomNumber;
        // generate random numbers until unused sign is found
        do {
            // generate a random number between 0-11
            randomNumber = randomGenerator.nextInt(12);
        } while (signsUsed[randomNumber]);

        // indicate that sign has been used
        signsUsed[randomNumber] = true;

        return randomNumber;
    } // end method getUniqueRandomNumber

    // choose a sign and display it in the JLabel
    private void displaySign() {
        // get an unused sign
        currentIndex = getUniqueRandomNumber();

        // create the path for that sign
        String signPath = "src/images/sign" + currentIndex + ".png";

        // set the label to display the sign
        signIconJLabel.setIcon(new ImageIcon(signPath));

    } // end method displaySign

    // check the answer and update the quiz
    private void submitJButtonActionPerformed(ActionEvent event) {
        // determine whether the answer was correct
        if (signJComboBox.getSelectedIndex() == currentIndex) {
            feedbackJTextField.setText("Correct!");
        } else {
            feedbackJTextField.setText("Sorry, incorrect.");
        }

        // inform the user if the quiz is over
        if (count == 5) {
            nextSignJButton.setEnabled(false);
            submitJButton.setEnabled(false);
            signJComboBox.setEnabled(false);
        } else {
            submitJButton.setEnabled(false);
            nextSignJButton.setEnabled(true);
        }

    } // end method submitJButtonActionPerformed

    // display next sign in the quiz
    private void nextSignJButtonActionPerformed(ActionEvent event) {
        // display the next sign
        displaySign();

        // increment the counter
        count++;

        // reset the GUI components to the initial states
        feedbackJTextField.setText("");
        signJComboBox.setSelectedIndex(0);
        submitJButton.setEnabled(true);
        nextSignJButton.setEnabled(false);

    } // end method nextSignJButtonActionPerformed

} // end class RoadSignTest

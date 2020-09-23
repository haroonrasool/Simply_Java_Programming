package tutorial_16;

// Exercise 16.11: FlagQuiz.java
// Quiz the user on their knowledge of flags. The user must try to 
// match five flags to their countries.

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Arrays;
import java.util.Random;

public class FlagQuizEnhanced extends JFrame {
    // array of country names
    private final String[] countries = {"Russia", "China", "United States",
            "Italy", "Australia", "South Africa", "Brazil", "Spain"};

    // boolean array tracks displayed flags
    private final boolean[] flagsUsed = new boolean[countries.length];

    // contains the index of current flag
    private int currentIndex;

    // Storing the number of Correct answers.
    private int correctAnswers = 0;

    // tracks the number of flags that have been displayed
    private int count = 1;

    private JLabel flagIconJLabel;

    private JComboBox<String> selectCountryJComboBox;

    // JTextField for giving the user feedback
    private JTextField feedbackJTextField;

    // JButton to submit an answer
    private JButton submitJButton;

    // JButton to display the next flag
    private JButton nextFlagJButton;

    // JTextField for final comment
    private JTextField commentJTextField;

    // no-argument constructor
    public FlagQuizEnhanced() {
        createUserInterface();
    }

    // main method
    public static void main(String[] args) {
        FlagQuizEnhanced application = new FlagQuizEnhanced();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    } // end method main

    // create and position GUI components; register event handlers
    private void createUserInterface() {
        // get content pane for attaching GUI components
        Container contentPane = getContentPane();

        // enable explicit positioning of GUI components
        contentPane.setLayout(null);

        // set up flagJPanel
        // JPanel and JLabel for displaying a flag image
        JPanel flagJPanel = new JPanel();
        flagJPanel.setBounds(16, 8, 100, 90);
        flagJPanel.setLayout(null);
        flagJPanel.setBorder(new TitledBorder("Flag"));
        contentPane.add(flagJPanel);

        // set up flagIconJLabel
        flagIconJLabel = new JLabel();
        flagIconJLabel.setBounds(10, 14, 80, 80);
        flagIconJLabel.setHorizontalAlignment(JLabel.CENTER);
        flagJPanel.add(flagIconJLabel);

        // set up selectCountryJLabel
        // JLabel and JComboBox for choosing a country
        JLabel selectCountryJLabel = new JLabel();
        selectCountryJLabel.setBounds(136, 8, 88, 21);
        selectCountryJLabel.setText("Select country:");
        contentPane.add(selectCountryJLabel);

        Arrays.sort(countries); // sort the array

        // set up selectCountryJComboBox
        selectCountryJComboBox = new JComboBox<>(countries);
        selectCountryJComboBox.setBounds(136, 32, 135, 21);
        selectCountryJComboBox.setMaximumRowCount(3);
        contentPane.add(selectCountryJComboBox);

        displayFlag(); // display first flag

        // set up feedbackJTextField
        feedbackJTextField = new JTextField();
        feedbackJTextField.setBounds(136, 64, 135, 32);
        feedbackJTextField.setHorizontalAlignment(
                JTextField.CENTER);
        feedbackJTextField.setEditable(false);
        contentPane.add(feedbackJTextField);

        // set up submitJButton
        submitJButton = new JButton();
        submitJButton.setBounds(287, 8, 88, 32);
        submitJButton.setText("Submit");
        contentPane.add(submitJButton);
        // anonymous inner class
        // event handler called when submitJButton is pressed
        submitJButton.addActionListener(

                this::submitJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set up nextFlagJButton
        nextFlagJButton = new JButton();
        nextFlagJButton.setBounds(287, 48, 88, 32);
        nextFlagJButton.setText("Next Flag");
        nextFlagJButton.setEnabled(false);
        contentPane.add(nextFlagJButton);
        // anonymous inner class
        // event handler called when nextFlagJButton is pressed
        nextFlagJButton.addActionListener(

                event -> nextFlagJButtonActionPerformed() // end anonymous inner class

        ); // end call to addActionListener

        // set up commentJTextField
        commentJTextField = new JTextField();
        commentJTextField.setBounds(287, 88, 88, 24);
        commentJTextField.setHorizontalAlignment(JLabel.CENTER);
        commentJTextField.setEditable(false);
        contentPane.add(commentJTextField);

        // set properties of application's window
        setTitle("Flag Quiz"); // set title bar string
        setSize(405, 165);     // set window size
        setVisible(true);      // display window

    } // end method createUserInterface

    // return an unused random number
    private int getUniqueRandomNumber() {
        Random generator = new Random();
        int randomNumber;

        // generate random numbers until unused flag is found
        do {
            // generate a number between 0-7
            randomNumber = generator.nextInt(8);
        }
        while (flagsUsed[randomNumber]);

        // indicate that flag has been used
        flagsUsed[randomNumber] = true;

        return randomNumber;

    } // end method getUniqueRandomNumber

    // choose a flag and display it in the JLabel
    private void displayFlag() {
        currentIndex = getUniqueRandomNumber(); // get an unused flag

        // create the path for that flag
        String country =
                selectCountryJComboBox.getItemAt(currentIndex);
        String countryPath = "src/images/" + country + ".png";

        // set the flagIconJLabel to display the flag
        flagIconJLabel.setIcon(new ImageIcon(countryPath));

    } // end method displayFlag

    // check the answer and update the quiz
    private void submitJButtonActionPerformed(ActionEvent event) {
        // determine whether the answer was correct
        if (selectCountryJComboBox.getSelectedIndex()
                == currentIndex) {
            feedbackJTextField.setText("Correct!");
            correctAnswers++;
        } else // if an incorrect answer is given
        {
            feedbackJTextField.setText("Sorry, incorrect.");
        }

        // inform user if quiz is over
        if (count == 5) {
            feedbackJTextField.setText(
                    feedbackJTextField.getText() + "   Done!");

            // switch statement to display the message
            switch (correctAnswers) {
                case 5:
                    commentJTextField.setText("Excellent!");
                    break;
                case 4:
                    commentJTextField.setText("Very Good!");
                    break;
                case 3:
                    commentJTextField.setText("Good.");
                    break;
                case 2:
                    commentJTextField.setText("Poor.");
                    break;
                case 1:
                case 0:
                    commentJTextField.setText("Fail:");
                    break;
                default:
            }

            nextFlagJButton.setEnabled(false);
            submitJButton.setEnabled(false);
            selectCountryJComboBox.setEnabled(false);
        } else // if less than 5 flags have been displayed
        {
            submitJButton.setEnabled(false);
            nextFlagJButton.setEnabled(true);
        }

    } // end method submitJButtonActionPerformed

    // display next flag in the quiz
    private void nextFlagJButtonActionPerformed() {
        displayFlag(); // display next flag
        count++;

        // reset GUI components to initial states
        feedbackJTextField.setText("");
        selectCountryJComboBox.setSelectedIndex(0);
        submitJButton.setEnabled(true);
        nextFlagJButton.setEnabled(false);

    } // end method nextFlagJButtonActionPerformed

} // end class FlagQuiz

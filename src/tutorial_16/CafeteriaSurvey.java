package tutorial_16;

// Exercise 16.13: CafeteriaSurvey.java
// Application that asks 20 users to enter a rating of the quality of
// food in the student cafeteria and displays a histogram of the
// data. User can add ratings between the values of 1 and 10, with
// 1 being "awful" and 10 being "excellent."

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class CafeteriaSurvey extends JFrame {
    // JComboBox to display choices
    private JComboBox<Object> ratingJComboBox;

    // JButton to submit a rating
    private JButton submitRatingJButton;

    private JTextArea resultJTextArea;

    // track number of responses
    private int responseCounter = 0;

    // create a String type array of possible choices.
    String[] choices = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};

    // create an integer type array to store the responses.
    int[] responses = new int[11];

    // no-argument constructor
    public CafeteriaSurvey() {
        createUserInterface();
    }

    // main method
    public static void main(String[] args) {
        CafeteriaSurvey application = new CafeteriaSurvey();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } // end method main

    // create and position GUI components; register event handlers
    private void createUserInterface() {
        // get content pane for attaching GUI components
        Container contentPane = getContentPane();

        // enable explicit positioning of GUI components
        contentPane.setLayout(null);

        // set up ratingJLabel
        // JLabel and JComboBox for choosing a rating
        JLabel ratingJLabel = new JLabel();
        ratingJLabel.setBounds(20, 20, 140, 20);
        ratingJLabel.setText("Rate cafeteria food:");
        contentPane.add(ratingJLabel);

        // set up ratingJComboBox
        ratingJComboBox = new JComboBox<>(choices);
        ratingJComboBox.setBounds(180, 20, 80, 20);
        contentPane.add(ratingJComboBox);

        // set up submitJButton
        submitRatingJButton = new JButton();
        submitRatingJButton.setBounds(80, 55, 130, 20);
        submitRatingJButton.setText("Submit Rating");
        contentPane.add(submitRatingJButton);
        // anonymous inner class
        // event handler called when
        // submitRatingJButton is clicked
        submitRatingJButton.addActionListener(

                this::submitRatingJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set up resultJLabel
        // JLabel and JTextArea for displaying all ratings
        JLabel resultJLabel = new JLabel();
        resultJLabel.setBounds(20, 100, 100, 20);
        resultJLabel.setText("Survey results:");
        contentPane.add(resultJLabel);

        // set up resultJTextArea
        resultJTextArea = new JTextArea();
        resultJTextArea.setBounds(20, 130, 240, 190);
        resultJTextArea.setEditable(false);
        contentPane.add(resultJTextArea);

        // set properties of application's window
        setTitle("Cafeteria Survey"); // set title bar string
        setSize(290, 370);            // set window size
        setVisible(true);             // display window

    } // end method createUserInterface

    // submit response and display results
    private void submitRatingJButtonActionPerformed(ActionEvent event) {
        responseCounter++;
        int input = ratingJComboBox.getSelectedIndex() + 1;
        responses[input]++;

        // if 20 ratings have been entered, display histogram
        if (responseCounter == 20) {
            resultJTextArea.setText("Rating\tFrequency:\n");

            // outer for loop
            for (int i = 1; i <= 10; i++) {
                resultJTextArea.append(i + "\t");

                // inner for loop
                for (int j = 1; j <= responses[i]; j++) {
                    resultJTextArea.append("*");
                } // end inner for loop

                resultJTextArea.append("\n");

            } // end outer for loop

            submitRatingJButton.setEnabled(false);

        } // end if statement

    } // end submitJButtonActionPerformed

} // end class CafeteriaSurvey

package tutorial_20.CafeteriaEnhanced;

// Exercise 16.13: CafeteriaSurvey.java
// Program that asks 20 users to enter a rating of the quality of
// food in the student cafeteria and displays a bar graph of the
// data. User can add ratings between the values of 1 and 10, with
// 1 being "awful" and 10 being "excellent."

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class CafeteriaSurvey extends JFrame {

    private JComboBox<Object> ratingJComboBox;

    // JButton to submit a rating
    private JButton submitRatingJButton;

    private DrawJPanel drawingJPanel;

    // String array to hold the user's choices
    private final String[] choices = {"1", "2", "3", "4", "5", "6",
            "7", "8", "9", "10"};

    // integer array to track user responses
    private final int[] responses = new int[11];

    // track number of responses
    private int responseCounter = 0;

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

        // set up oneJLabel
        // JLabels for labeling x-axis bar graph
        JLabel oneJLabel = new JLabel();
        oneJLabel.setBounds(50, 135, 25, 25);
        oneJLabel.setText("1");
        contentPane.add(oneJLabel);

        // set up ratingsJLabel
        JLabel ratingsJLabel = new JLabel();
        ratingsJLabel.setBounds(10, 245, 50, 25);
        ratingsJLabel.setText("Ratings");
        contentPane.add(ratingsJLabel);

        // set up tenJLabel
        JLabel tenJLabel = new JLabel();
        tenJLabel.setBounds(50, 370, 25, 25);
        tenJLabel.setText("10");
        contentPane.add(tenJLabel);

        // set up ratingJLabel
        // JLabel and JComboBox for choosing a rating
        JLabel ratingJLabel = new JLabel();
        ratingJLabel.setBounds(75, 20, 140, 20);
        ratingJLabel.setText("Rate cafeteria food:");
        contentPane.add(ratingJLabel);

        // set up ratingJComboBox
        ratingJComboBox = new JComboBox<>(choices);
        ratingJComboBox.setBounds(285, 20, 80, 25);
        contentPane.add(ratingJComboBox);

        // set up submitJButton
        submitRatingJButton = new JButton();
        submitRatingJButton.setBounds(135, 60, 130, 25);
        submitRatingJButton.setText("Submit Rating");
        contentPane.add(submitRatingJButton);
        // anonymous inner class
        // event handler called when
        // submitRatingJButton is pressed
        submitRatingJButton.addActionListener(

                this::submitRatingJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set up resultJLabel
        // JLabel and JTextArea for displaying all ratings
        JLabel resultJLabel = new JLabel();
        resultJLabel.setBounds(75, 100, 100, 20);
        resultJLabel.setText("Survey results:");
        contentPane.add(resultJLabel);

        // set up drawingJPanel
        drawingJPanel = new DrawJPanel();
        drawingJPanel.setBounds(75, 135, 310, 255);
        drawingJPanel.setBackground(Color.WHITE);
        contentPane.add(drawingJPanel);

        // set up zeroJLabel
        // JLabels for labeling y-axis of bar graph
        JLabel zeroJLabel = new JLabel();
        zeroJLabel.setBounds(75, 390, 25, 25);
        zeroJLabel.setText("0");
        contentPane.add(zeroJLabel);

        // set up resultsJLabel
        JLabel resultsJLabel = new JLabel();
        resultsJLabel.setBounds(200, 405, 50, 25);
        resultsJLabel.setText("Results");
        contentPane.add(resultsJLabel);

        // set up twentyJLabel
        JLabel twentyJLabel = new JLabel();
        twentyJLabel.setBounds(370, 390, 25, 25);
        twentyJLabel.setText("20");
        contentPane.add(twentyJLabel);

        // set properties of application's window
        setTitle("Cafeteria Survey"); // set title bar text
        setSize(450, 475);            // set window size
        setVisible(true);             // display window

    } // end method createUserInterface

    // submit response and display results
    private void submitRatingJButtonActionPerformed(ActionEvent event) {
        // increment counter
        responseCounter++;

        // variable to hold user input
        int input = ratingJComboBox.getSelectedIndex() + 1;

        // add user input to responses array
        responses[input]++;

        // draw the bar graph
        drawingJPanel.drawGraph(responses);

        // if 20 ratings have been entered
        if (responseCounter == 20) {
            // disable the submitRatingsJButton
            submitRatingJButton.setEnabled(false);
        }

    } // end submitJButtonActionPerformed

} // end class CafeteriaSurvey

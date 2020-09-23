package tutorial_14;

// Exercise 14.12: QuizAverage.java
// Application enables a user to enter grades and have the average
// calculated.

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.text.DecimalFormat;

public class QuizAverage extends JFrame {
    private JTextField quizJTextField;
    private JTextField numberJTextField;
    private JTextField averageJTextField;

    // DecimalFormat to display average of numbers.
    private final DecimalFormat numbers = new DecimalFormat("0.00");

    // instance variable to store number of quiz scores entered.
    int quizzesTaken;

    // instance variable to store sum of all quiz scores entered.
    double totalScore;

    // no-argument constructor
    public QuizAverage() {
        createUserInterface();
    }

    // main method
    public static void main(String[] args) {
        QuizAverage application = new QuizAverage();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } // end method main

    // create and position GUI components; register event handlers
    private void createUserInterface() {
        // get content pane for attaching GUI components
        Container contentPane = getContentPane();

        // enable explicit positioning of GUI components
        contentPane.setLayout(null);

        // set up quizJLabel
        // JLabel and JTextField to display quiz score
        JLabel quizJLabel = new JLabel();
        quizJLabel.setBounds(16, 16, 88, 21);
        quizJLabel.setText("Quiz score:");
        contentPane.add(quizJLabel);

        // set up quizJTextField
        quizJTextField = new JTextField();
        quizJTextField.setBounds(122, 16, 40, 24);
        quizJTextField.setHorizontalAlignment(JTextField.RIGHT);
        contentPane.add(quizJTextField);

        // set up submitJButton
        // JButton to enter quiz score
        JButton submitJButton = new JButton();
        submitJButton.setBounds(183, 16, 116, 24);
        submitJButton.setText("Submit Score");
        contentPane.add(submitJButton);
        // anonymous inner class
        // event handler called when submitJButton is clicked
        submitJButton.addActionListener(

                this::submitJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set up numberJLabel
        // JLabel and JTextField to display number of quizzes taken
        JLabel numberJLabel = new JLabel();
        numberJLabel.setBounds(16, 56, 88, 21);
        numberJLabel.setText("Number taken:");
        contentPane.add(numberJLabel);

        // set up numberJTextField
        numberJTextField = new JTextField();
        numberJTextField.setBounds(122, 56, 40, 24);
        numberJTextField.setHorizontalAlignment(JTextField.CENTER);
        numberJTextField.setEditable(false);
        contentPane.add(numberJTextField);

        // set up averageJLabel
        // JLabel and JTextField to display average of all quiz scores
        JLabel averageJLabel = new JLabel();
        averageJLabel.setBounds(175, 56, 56, 21);
        averageJLabel.setText("Average:");
        contentPane.add(averageJLabel);

        // set up averageJTextField
        averageJTextField = new JTextField();
        averageJTextField.setBounds(259, 56, 40, 24);
        averageJTextField.setHorizontalAlignment(JTextField.CENTER);
        averageJTextField.setEditable(false);
        contentPane.add(averageJTextField);

        // set properties of application's window
        setTitle("Quiz Average"); // set title bar string
        setSize(325, 125);        // set window size
        setVisible(true);         // display window

    } // end method createUserInterface

    // calculate and display average score
    public void submitJButtonActionPerformed(ActionEvent event) {
        // retrieve the user input from quizJTextField
        double input = Integer.parseInt(quizJTextField.getText());

        // increment the number of quiz scores entered.
        quizzesTaken++;

        // display quizzes taken in numberJTextField
        numberJTextField.setText(String.valueOf(quizzesTaken));

        // update the sum of all scores entered.
        totalScore += input;

        // calculate the average score.
        double average = totalScore / quizzesTaken;

        // display the average in averageJTextField
        averageJTextField.setText(String.valueOf(numbers.format(average)));

        // clear the quizJTextField
        quizJTextField.setText("");

    } // end method submitJButtonActionPerformed

} // end class QuizAverage

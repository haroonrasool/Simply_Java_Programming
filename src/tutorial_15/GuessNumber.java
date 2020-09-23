package tutorial_15;

// Exercise 15.11: GuessNumber.java
// This game asks the user to guess a number from 1 to 100.

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Random;

public class GuessNumber extends JFrame {
    // instance variable
    private final Random randomObject = new Random();

    // instance variable
    private int randomNumber = 0;

    private JTextField guessJTextField;

    // JButton to enter guess
    private JButton enterJButton;

    private JTextField resultJTextField;

    // JButton to start a new game
    private JButton newGameJButton;

    // no-argument constructor
    public GuessNumber() {
        createUserInterface();
    }

    // main method
    public static void main(String[] args) {
        GuessNumber application = new GuessNumber();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } // end method main

    // create and position GUI components; register event handlers
    private void createUserInterface() {
        // get content pane for attaching GUI components
        Container contentPane = getContentPane();

        // enable explicit positioning of GUI components
        contentPane.setLayout(null);

        // set up question1JLabel
        // JLabels to display question
        JLabel question1JLabel = new JLabel();
        question1JLabel.setText(
                "I have a number between 1 and 100.");
        question1JLabel.setBounds(40, 10, 216, 34);
        contentPane.add(question1JLabel);

        // set up question2JLabel
        JLabel question2JLabel = new JLabel();
        question2JLabel.setText("Can you guess my number?");
        question2JLabel.setBounds(40, 24, 216, 34);
        contentPane.add(question2JLabel);

        // set up guessJLabel
        // JLabel and JTextField to get user guess
        JLabel guessJLabel = new JLabel();
        guessJLabel.setText("Guess:");
        guessJLabel.setBounds(16, 74, 50, 20);
        contentPane.add(guessJLabel);

        // set up guessJTextField
        guessJTextField = new JTextField();
        guessJTextField.setBounds(70, 74, 130, 20);
        guessJTextField.setHorizontalAlignment(JTextField.CENTER);
        contentPane.add(guessJTextField);

        // set up enterJButton
        enterJButton = new JButton();
        enterJButton.setText("Enter");
        enterJButton.setBounds(208, 74, 96, 21);
        contentPane.add(enterJButton);
        // anonymous inner class
        // event handler called when enterJButton is clicked
        enterJButton.addActionListener(

                this::enterJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set up resultJLabel
        // JLabel and JTextField to display if user is correct
        JLabel resultJLabel = new JLabel();
        resultJLabel.setText("Result:");
        resultJLabel.setBounds(16, 106, 50, 23);
        contentPane.add(resultJLabel);

        // set up resultJTextField
        resultJTextField = new JTextField();
        resultJTextField.setBounds(70, 104, 130, 23);
        resultJTextField.setHorizontalAlignment(JTextField.CENTER);
        resultJTextField.setEditable(false);
        contentPane.add(resultJTextField);

        // set up newGameJButton
        newGameJButton = new JButton();
        newGameJButton.setText("New Game");
        newGameJButton.setBounds(208, 106, 96, 21);
        newGameJButton.setEnabled(false);
        contentPane.add(newGameJButton);
        // anonymous inner class
        // event handler called when newGameJButton is clicked
        newGameJButton.addActionListener(

                this::newGameJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set properties of application's window
        setTitle("Guess the Number"); // set title bar string
        setSize(340, 190); // set window size
        setVisible(true);             // display window

    } // end method createUserInterface

    // compare guess to answer
    private void enterJButtonActionPerformed(ActionEvent event) {
        // retrieve user input from guessJTextField
        int userGuess = Integer.parseInt(guessJTextField.getText());

        // compare userGuess with random number generated.
        if (userGuess < randomNumber) {
            resultJTextField.setText("Guess is Lower than " + randomNumber);
        } else if (userGuess > randomNumber) {
            resultJTextField.setText("Guess is Higher than " + randomNumber);
        } else {
            resultJTextField.setText("Correct!");
        }

        // disable enterJButton
        enterJButton.setEnabled(false);

        // enable newGameJButton
        newGameJButton.setEnabled(true);

    } // end method enterJButtonActionPerformed

    // reset resultJTextField and generate new question
    private void newGameJButtonActionPerformed(ActionEvent event) {
        // clear guessJTextField.
        guessJTextField.setText("");

        // clear resultJTextField.
        resultJTextField.setText("");

        // create a new random number for the instance variable.
        randomNumber = 1 + randomObject.nextInt(99);

        // disable new game button
        newGameJButton.setEnabled(false);

        // enable EnterJButton.
        enterJButton.setEnabled(true);

    } // end method newGameJButtonActionPerformed

} // end class GuessNumber

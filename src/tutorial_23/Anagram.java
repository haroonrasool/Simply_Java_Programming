package tutorial_23;

// Exercise 23.13: Anagram.java
// Application provides an anagram game to users.

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Random;

public class Anagram extends JFrame {
    private JTextField guessJTextField;
    private JTextField anagramJTextField;

    // instance of class Random
    Random randomGenerator = new Random();

    // JTextField for correct or incorrect message
    private JTextField resultJTextField;

    // array of words to be scrambled
    private final String[] anagramList = {"components", "events",
            "properties", "visual", "program", "application", "basic",
            "debugger", "database", "files", "inheritance", "assembly",
            "multimedia", "procedures", "functions", "arrays", "strings",
            "collections", "integration", "structures"};

    // random index variable
    private int randomNumber;

    // no-argument constructor
    public Anagram() {
        createUserInterface();
    }

    // main method
    public static void main(String[] args) {
        Anagram application = new Anagram();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } // end method main

    // create and position GUI components; register event handlers
    private void createUserInterface() {
        // get content pane for attaching GUI components
        Container contentPane = getContentPane();

        // enable explicit positioning of GUI components
        contentPane.setLayout(null);

        // set up anagramJTextField
        // JTextField for scrambled word
        anagramJTextField = new JTextField();
        anagramJTextField.setBounds(16, 16, 148, 21);
        anagramJTextField.setEditable(false);
        anagramJTextField.setHorizontalAlignment(JTextField.CENTER);
        contentPane.add(anagramJTextField);

        // set up guessJLabel
        // JLabel and JTextField for guess from user
        JLabel guessJLabel = new JLabel();
        guessJLabel.setBounds(16, 72, 72, 21);
        guessJLabel.setText("Your guess:");
        contentPane.add(guessJLabel);

        // set up guessJTextField
        guessJTextField = new JTextField();
        guessJTextField.setBounds(16, 96, 148, 21);
        contentPane.add(guessJTextField);

        // set up submitJButton
        // JButton to allow user to submit guess
        JButton submitJButton = new JButton();
        submitJButton.setBounds(48, 136, 74, 23);
        submitJButton.setText("Submit");
        contentPane.add(submitJButton);
        // anonymous inner class
        // event handler called when submitJButton is pressed
        submitJButton.addActionListener(

                this::submitJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set up resultJTextField
        resultJTextField = new JTextField();
        resultJTextField.setBounds(16, 176, 148, 21);
        resultJTextField.setEditable(false);
        resultJTextField.setHorizontalAlignment(JTextField.CENTER);
        contentPane.add(resultJTextField);

        // set properties of application's window
        setTitle("Anagram Game"); // set title bar string
        setSize(188, 240);        // set window size
        setVisible(true);         // display window

        generateAnagram(); // generate new word

    } // end method createUserInterface

    // check if guess is correct
    private void submitJButtonActionPerformed(ActionEvent event) {
        // get text from guessJTextField
        String text = guessJTextField.getText();

        // if answer is correct
        if (text.equals(anagramList[randomNumber])) {
            resultJTextField.setText("You are Correct!");

            // clear the JTextField
            guessJTextField.setText("");

            // place focus on guessJTextField
            guessJTextField.requestFocusInWindow();

            // generate first word
            generateAnagram();
        } else // answer is incorrect
        {
            resultJTextField.setText("Wrong answer. Try again!");

            // clear the JTextField
            guessJTextField.setText("");

            // place focus on guessJTextField
            guessJTextField.requestFocusInWindow();
        }

    } // end method submitJButtonActionPerformed

    // scramble random word and display it in anagramJTextField
    private void generateAnagram() {
        // generate new random number
        randomNumber = randomGenerator.nextInt(20);

        // select new word from array with random index
        String scrambled = anagramList[randomNumber];

        // generate new random index
        int randomIndex =
                randomGenerator.nextInt(scrambled.length());

        // loop to generate scrambled word
        for ( int counter = 0; counter < 20; counter++ )
        {
            // extract first character to be added at a new location
            char firstCharacter = scrambled.charAt( 0 );

            // remove character from beginning of String
            scrambled = scrambled.substring( 1 );

            // temporary Strings used to swap characters
            String temporary1 = scrambled.substring( 0, randomIndex );
            String temporary2 = scrambled.substring( randomIndex );
            temporary1 += String.valueOf( firstCharacter );
            scrambled = temporary1 + temporary2;

            // new random index
            randomIndex = randomGenerator.nextInt( scrambled.length() );
        }

        // display scrambled word
        anagramJTextField.setText( scrambled );

    } // end method generateAnagram

} // end class Anagram

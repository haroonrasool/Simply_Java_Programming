package tutorial_23;

// Exercise 23.16: PigLatin.java
// Converts text entered by user into Pig Latin.

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class PigLatin extends JFrame {
    // JTextFields
    private JTextField enterSentenceJTextField;
    private JTextField pigLatinJTextField;

    // no-argument constructor
    public PigLatin() {
        createUserInterface();
    }

    // main method
    public static void main(String[] args) {
        PigLatin application = new PigLatin();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } // end method main

    // create and position GUI components; register event handlers
    public void createUserInterface() {
        // get content pane for attaching GUI components
        Container contentPane = getContentPane();

        // enable explicit positioning of GUI components
        contentPane.setLayout(null);

        // set up enterSentenceJLabel
        // JLabel and JTextField for input in English
        JLabel enterSentenceJLabel = new JLabel();
        enterSentenceJLabel.setBounds(8, 16, 106, 23);
        enterSentenceJLabel.setText("Enter a sentence:");
        contentPane.add(enterSentenceJLabel);

        // set up enterSentenceJTextField
        enterSentenceJTextField = new JTextField();
        enterSentenceJTextField.setBounds(114, 16, 306, 20);
        contentPane.add(enterSentenceJTextField);

        // set up pigLatinJLabel
        // JLabel and JTextField for output in Pig Latin
        JLabel pigLatinJLabel = new JLabel();
        pigLatinJLabel.setBounds(8, 56, 88, 23);
        pigLatinJLabel.setText("Pig Latin:");
        contentPane.add(pigLatinJLabel);

        // set up pigLatinJTextField
        pigLatinJTextField = new JTextField();
        pigLatinJTextField.setBounds(114, 56, 306, 20);
        pigLatinJTextField.setEditable(false);
        contentPane.add(pigLatinJTextField);

        // set up translateJButton
        // JButton to translate from English to Pig Latin
        JButton translateJButton = new JButton();
        translateJButton.setBounds(325, 96, 95, 23);
        translateJButton.setText("Translate");
        contentPane.add(translateJButton);
        // anonymous inner class
        // method called when translateJButton is pressed
        translateJButton.addActionListener(

                this::translateJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set properties of application's window
        setTitle("Pig Latin"); // set title bar string
        setSize(444, 160);     // set window size
        setVisible(true);      // display window

    } // end method createUserInterface

    // receive sentence from user and send to translateToPigLatin
    private void translateJButtonActionPerformed(ActionEvent event) {
        // retrieve English phrase from user
        String phrase = enterSentenceJTextField.getText();

        // non-empty input
        if (phrase.equals("")) {
            // exit method
            return;
        }

        // display phrase converted to Pig Latin
        pigLatinJTextField.setText(translateToPigLatin(phrase));

    } // end method translateJButtonActionPerformed

    // translate String from English to Pig Latin
    private String translateToPigLatin(String englishPhrase) {
        String prefix; // stores first letter of each word
        String suffix; // stores a String added to the end of each word

        StringBuilder translatedText = new StringBuilder(); // stores translated sentence

        // split words into an array
        String[] words = englishPhrase.split(" ");

        // iterate through each word in array words
        for (int index = 0; index <= words.length - 1; index++) {
            // get first letter of each word
            prefix = words[index].substring(0, 1);
            prefix = prefix.toLowerCase();

            // if each word starts with a vowel
            if (prefix.equals("a") || prefix.equals("e") ||
                    prefix.equals("i") || prefix.equals("o") ||
                    prefix.equals("u")) {
                suffix = "y";
            } else // word does not start with a vowel
            {
                suffix = "ay";
            }

            // swap letters to create new word
            words[index] = words[index].substring(1) +
                    prefix + suffix;

            // String builder.
            translatedText.append(words[index]).append(" ");

        } // end for loop

        return translatedText.toString();

    } // end method translateToPigLatin

} // end class PigLatin

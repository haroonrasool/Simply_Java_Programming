package tutorial_17;

// Exercise 17.16: LotteryPicker.java
// This application picks randomly generated numbers for a lottery.

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Random;

public class LotteryPickerEnhanced extends JFrame {
    // JTextFields
    private JTextField oneJTextField, twoJTextField, threeJTextField, fourJTextField;

    // Random object to create random integers
    private final Random generator = new Random();

    // two-dimensional array to maintain unique random numbers
    private final boolean[][] uniqueNumber = new boolean[4][40];

    // one-dimensional array to store strings for output
    private final String[] output = new String[4];

    // no-argument constructor
    public LotteryPickerEnhanced() {
        createUserInterface();
    }

    // main method
    public static void main(String[] args) {
        LotteryPickerEnhanced application = new LotteryPickerEnhanced();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } // end method main

    // create and position GUI components; register event handlers
    private void createUserInterface() {
        // get content pane for attaching GUI components
        Container contentPane = getContentPane();

        // enable explicit positioning of GUI components
        contentPane.setLayout(null);

        // set up oneJLabel
        // JLabel and JTextField for first lottery
        JLabel oneJLabel = new JLabel();
        oneJLabel.setBounds(16, 18, 100, 16);
        oneJLabel.setText("First lottery:");
        contentPane.add(oneJLabel);

        // set up oneJTextField
        oneJTextField = new JTextField();
        oneJTextField.setBounds(120, 16, 124, 23);
        oneJTextField.setHorizontalAlignment(JTextField.CENTER);
        oneJTextField.setEditable(false);
        contentPane.add(oneJTextField);

        // set up twoJLabel
        // JLabel and JTextField for second lottery
        JLabel twoJLabel = new JLabel();
        twoJLabel.setBounds(16, 50, 100, 16);
        twoJLabel.setText("Second lottery:");
        contentPane.add(twoJLabel);

        // set up twoJTextField
        twoJTextField = new JTextField();
        twoJTextField.setBounds(120, 48, 124, 23);
        twoJTextField.setHorizontalAlignment(JTextField.CENTER);
        twoJTextField.setEditable(false);
        contentPane.add(twoJTextField);

        // set up threeJLabel
        // JLabel and JTextField for third lottery
        JLabel threeJLabel = new JLabel();
        threeJLabel.setBounds(16, 82, 100, 16);
        threeJLabel.setText("Third lottery:");
        contentPane.add(threeJLabel);

        // set up threeJTextField
        threeJTextField = new JTextField();
        threeJTextField.setBounds(120, 80, 124, 23);
        threeJTextField.setHorizontalAlignment(JTextField.CENTER);
        threeJTextField.setEditable(false);
        contentPane.add(threeJTextField);

        // set up fourJLabel
        // JLabel and JTextField for fourth lottery
        JLabel fourJLabel = new JLabel();
        fourJLabel.setBounds(16, 114, 100, 16);
        fourJLabel.setText("Fourth lottery:");
        contentPane.add(fourJLabel);

        // set up fourJTextField
        fourJTextField = new JTextField();
        fourJTextField.setBounds(120, 112, 124, 23);
        fourJTextField.setHorizontalAlignment(JTextField.CENTER);
        fourJTextField.setEditable(false);
        contentPane.add(fourJTextField);

        // set up generateJButton
        // JButton to generate lottery numbers
        JButton generateJButton = new JButton();
        generateJButton.setBounds(148, 150, 96, 24);
        generateJButton.setText("Generate");
        contentPane.add(generateJButton);
        // anonymous inner class
        // event handler called when generateJButton is clicked
        generateJButton.addActionListener(

                this::generateJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set properties of application's window
        setTitle("Lottery Picker"); // set title bar string
        setSize(264, 220);          // set window size
        setVisible(true);           // display window

    } // end method createUserInterface

    // generate four random five-number lottery combinations
    private void generateJButtonActionPerformed(ActionEvent event) {
        for (int lottery = 0; lottery < 4; lottery++) {
            // initialize boolean array for this lottery
            for (int numbers = 0; numbers < 40; numbers++) {
                uniqueNumber[lottery][numbers] = false;
            } // end inner for

            // initialize string for the selections
            output[lottery] = "";

            // select five numbers
            for (int picks = 0; picks < 5; picks++) {
                // instance variable to hold the selected lottery number
                int selection;
                do {
                    // select a random number
                    selection = generate();
                }
                while (uniqueNumber[lottery][selection]);

                // set the index for the number selected to true
                uniqueNumber[lottery][selection] = true;

                // add the selection to the output string
                output[lottery] += " " + selection;

            } // end inner for

        } // end outer for

        oneJTextField.setText(output[0]);
        twoJTextField.setText(output[1]);
        threeJTextField.setText(output[2]);
        fourJTextField.setText(output[3]);

    } // end method generateJButtonActionPerformed

    // generate random number in a given range
    private int generate() {
        // generate random number in range from low to high
        return generator.nextInt(39 + 1);

    } // end method generate

} // end class LotteryPicker

package tutorial_15;

// Exercise 15.12: DiceSimulator.java
// This application rolls dice and counts the frequency of each side.

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Random;

public class DiceSimulator extends JFrame {
    private JTextField output1JTextField;

    private JTextField output2JTextField;

    private JTextField output3JTextField;

    private JTextField output4JTextField;

    private JTextField output5JTextField;

    private JTextField output6JTextField;

    private JTextField totalJTextField;

    // JLabels to display dice
    private JLabel die1JLabel;
    private JLabel die2JLabel;

    // dice face constants
    private final int ONE = 1;
    private final int TWO = 2;
    private final int THREE = 3;
    private final int FOUR = 4;
    private final int FIVE = 5;
    private final int SIX = 6;

    // create a new random object
    private final Random randomGenerator = new Random();

    // no-argument constructor
    public DiceSimulator() {
        createUserInterface();
    }

    // main method
    public static void main(String[] args) {
        DiceSimulator application = new DiceSimulator();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } // end method main

    // create and position GUI components; register event handlers
    private void createUserInterface() {
        // get content pane for attaching GUI components
        Container contentPane = getContentPane();

        // enable explicit positioning of GUI components
        contentPane.setLayout(null);

        // set up side1JLabel
        // JLabel and JTextField to display number of 1s
        JLabel side1JLabel = new JLabel();
        side1JLabel.setBounds(16, 16, 48, 23);
        side1JLabel.setText("Side 1:");
        contentPane.add(side1JLabel);

        // set up output1JTextField
        output1JTextField = new JTextField();
        output1JTextField.setBounds(72, 16, 56, 23);
        output1JTextField.setText("0");
        output1JTextField.setEditable(false);
        output1JTextField.setHorizontalAlignment(JTextField.CENTER);
        contentPane.add(output1JTextField);

        // set up side2JLabel
        // JLabel and JTextField to display number of 2s
        JLabel side2JLabel = new JLabel();
        side2JLabel.setBounds(16, 48, 48, 23);
        side2JLabel.setText("Side 2:");
        contentPane.add(side2JLabel);

        // set up output2JTextField
        output2JTextField = new JTextField();
        output2JTextField.setBounds(72, 48, 56, 23);
        output2JTextField.setText("0");
        output2JTextField.setEditable(false);
        output2JTextField.setHorizontalAlignment(JTextField.CENTER);
        contentPane.add(output2JTextField);

        // set up side3JLabel
        // JLabel and JTextField to display number of 3s
        JLabel side3JLabel = new JLabel();
        side3JLabel.setBounds(16, 80, 48, 23);
        side3JLabel.setText("Side 3:");
        contentPane.add(side3JLabel);

        // set up output3JTextField
        output3JTextField = new JTextField();
        output3JTextField.setBounds(72, 80, 56, 23);
        output3JTextField.setText("0");
        output3JTextField.setEditable(false);
        output3JTextField.setHorizontalAlignment(JTextField.CENTER);
        contentPane.add(output3JTextField);

        // set up side4JLabel
        // JLabel and JTextField to display number of 4s
        JLabel side4JLabel = new JLabel();
        side4JLabel.setBounds(16, 112, 48, 23);
        side4JLabel.setText("Side 4:");
        contentPane.add(side4JLabel);

        // set up output4JTextField
        output4JTextField = new JTextField();
        output4JTextField.setBounds(72, 111, 56, 23);
        output4JTextField.setText("0");
        output4JTextField.setEditable(false);
        output4JTextField.setHorizontalAlignment(JTextField.CENTER);
        contentPane.add(output4JTextField);

        // set up side5JLabel
        // JLabel and JTextField to display number of 5s
        JLabel side5JLabel = new JLabel();
        side5JLabel.setBounds(16, 144, 48, 23);
        side5JLabel.setText("Side 5:");
        contentPane.add(side5JLabel);

        // set up output5JTextField
        output5JTextField = new JTextField();
        output5JTextField.setBounds(72, 144, 56, 23);
        output5JTextField.setText("0");
        output5JTextField.setEditable(false);
        output5JTextField.setHorizontalAlignment(JTextField.CENTER);
        contentPane.add(output5JTextField);

        // set up side6JLabel
        // JLabel and JTextField to display number of 6s
        JLabel side6JLabel = new JLabel();
        side6JLabel.setBounds(16, 176, 48, 23);
        side6JLabel.setText("Side 6:");
        contentPane.add(side6JLabel);

        // set up output6JTextField
        output6JTextField = new JTextField();
        output6JTextField.setBounds(72, 176, 56, 23);
        output6JTextField.setText("0");
        output6JTextField.setEditable(false);
        output6JTextField.setHorizontalAlignment(JTextField.CENTER);
        contentPane.add(output6JTextField);

        // set up totalJLabel
        // JLabel and JTextField to display total rolls
        JLabel totalJLabel = new JLabel();
        totalJLabel.setBounds(16, 208, 48, 23);
        totalJLabel.setText("Total:");
        contentPane.add(totalJLabel);

        // set up totalJTextField
        totalJTextField = new JTextField();
        totalJTextField.setBounds(72, 208, 56, 23);
        totalJTextField.setText("0");
        totalJTextField.setEditable(false);
        totalJTextField.setHorizontalAlignment(JTextField.CENTER);
        contentPane.add(totalJTextField);

        // set up die1JLabel
        die1JLabel = new JLabel();
        die1JLabel.setBounds(152, 32, 72, 64);
        contentPane.add(die1JLabel);

        // set up die2JLabel
        die2JLabel = new JLabel();
        die2JLabel.setBounds(208, 96, 72, 64);
        contentPane.add(die2JLabel);

        // set up rollJButton
        // JButton to roll dice
        JButton rollJButton = new JButton();
        rollJButton.setBounds(144, 208, 136, 24);
        rollJButton.setText("Roll");
        contentPane.add(rollJButton);
        // anonymous inner class
        // event handler called when rollJButton is clicked
        rollJButton.addActionListener(

                this::rollJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set properties of application's window
        setTitle("Dice Simulator"); // set title bar string
        setSize(300, 290);          // set window size
        setVisible(true);           // display window

    } // end method createUserInterface

    // roll dice; display frequency of each side
    private void rollJButtonActionPerformed(ActionEvent event) {
        displayDie(die1JLabel); // display first die
        displayDie(die2JLabel); // display second die

        totalJTextField.setText(String.valueOf(
                Integer.parseInt(totalJTextField.getText()) + 2));

    } // end method rollJButtonActionPerformed

    // display the die image
    private void displayDie(JLabel picDieJLabel) {
        // pick random die values
        int face = 1 + randomGenerator.nextInt(6);

        picDieJLabel.setIcon(new ImageIcon(
                "src/images/dice" + face + ".png")); // set icon

        displayFrequency(face); // display frequency of dice

    } // end method displayDie

    // display frequency of dice
    private void displayFrequency(int face) {
        switch (face) // add to dice counter
        {
            case ONE:
                output1JTextField.setText(String.valueOf(
                        Integer.parseInt(
                                output1JTextField.getText()) + 1));
                break;

            case TWO:
                output2JTextField.setText(String.valueOf(
                        Integer.parseInt(
                                output2JTextField.getText()) + 1));
                break;

            case THREE:
                output3JTextField.setText(String.valueOf(
                        Integer.parseInt(
                                output3JTextField.getText()) + 1));
                break;

            case FOUR:
                output4JTextField.setText(String.valueOf(
                        Integer.parseInt(
                                output4JTextField.getText()) + 1));
                break;

            case FIVE:
                output5JTextField.setText(String.valueOf(
                        Integer.parseInt(
                                output5JTextField.getText()) + 1));
                break;

            case SIX:
                output6JTextField.setText(String.valueOf(
                        Integer.parseInt(
                                output6JTextField.getText()) + 1));
                break;

        } // end switch

    } // end method displayFrequency

} // end class DiceSimulator

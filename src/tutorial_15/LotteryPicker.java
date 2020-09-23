package tutorial_15;

// Exercise 15.13: LotteryPicker.java
// This application picks randomly generated numbers for a lottery.

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Random;

public class LotteryPicker extends JFrame {
    private JTextField output3JTextField;
    private JTextField output4JTextField;
    private JTextField output5JTextField;
    private JTextField output5Plus1JTextField;
    private JTextField outputExtra1JTextField;

    // create a new Random object
    private final Random randomObject = new Random();

    // no-argument constructor
    public LotteryPicker() {
        createUserInterface();
    }

    // main method
    public static void main(String[] args) {
        LotteryPicker application = new LotteryPicker();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } // end method main

    // create and position GUI components; register event handlers
    private void createUserInterface() {
        // get content pane for attaching GUI components
        Container contentPane = getContentPane();

        // enable explicit positioning of GUI components
        contentPane.setLayout(null);

        // set up threeJLabel
        // JLabel and JTextField to display three number lottery
        JLabel threeJLabel = new JLabel();
        threeJLabel.setText("Three number lottery:");
        threeJLabel.setBounds(16, 18, 132, 16);
        contentPane.add(threeJLabel);

        // set up output3JTextField
        output3JTextField = new JTextField();
        output3JTextField.setBounds(170, 16, 124, 23);
        output3JTextField.setHorizontalAlignment(JTextField.CENTER);
        output3JTextField.setEditable(false);
        contentPane.add(output3JTextField);

        // set up fourJLabel
        // JLabel and JTextField to display four number lottery
        JLabel fourJLabel = new JLabel();
        fourJLabel.setText("Four number lottery:");
        fourJLabel.setBounds(16, 50, 132, 16);
        contentPane.add(fourJLabel);

        // set up output4JTextField
        output4JTextField = new JTextField();
        output4JTextField.setBounds(170, 48, 124, 23);
        output4JTextField.setHorizontalAlignment(JTextField.CENTER);
        output4JTextField.setEditable(false);
        contentPane.add(output4JTextField);

        // set up fiveJLabel
        // JLabel and JTextField to display five number lottery
        JLabel fiveJLabel = new JLabel();
        fiveJLabel.setText("Five number lottery:");
        fiveJLabel.setBounds(16, 82, 132, 16);
        contentPane.add(fiveJLabel);

        // set up output5JTextField
        output5JTextField = new JTextField();
        output5JTextField.setBounds(170, 80, 124, 23);
        output5JTextField.setHorizontalAlignment(JTextField.CENTER);
        output5JTextField.setEditable(false);
        contentPane.add(output5JTextField);

        // set up fivePlus1JLabel
        // JLabel and JTextField to display five number + one lottery
        JLabel fivePlus1JLabel = new JLabel();
        fivePlus1JLabel.setText("Five number + 1 lottery:");
        fivePlus1JLabel.setBounds(16, 114, 140, 16);
        contentPane.add(fivePlus1JLabel);

        // set up output5Plus1JTextField
        output5Plus1JTextField = new JTextField();
        output5Plus1JTextField.setBounds(170, 112, 92, 23);
        output5Plus1JTextField.setHorizontalAlignment(JTextField.CENTER);
        output5Plus1JTextField.setEditable(false);
        contentPane.add(output5Plus1JTextField);

        // set up outputExtra1JTextField
        outputExtra1JTextField = new JTextField();
        outputExtra1JTextField.setBounds(270, 112, 24, 23);
        outputExtra1JTextField.setHorizontalAlignment(JTextField.CENTER);
        outputExtra1JTextField.setEditable(false);
        contentPane.add(outputExtra1JTextField);

        // set up generateJButton
        // JButton to generate new lottery numbers
        JButton generateJButton = new JButton();
        generateJButton.setText("Generate");
        generateJButton.setBounds(180, 152, 96, 24);
        contentPane.add(generateJButton);
        // anonymous inner class
        // event handler called when generateJButton is pressed
        generateJButton.addActionListener(

                this::generateJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set properties of application's window
        setTitle("Lottery Picker"); // set title bar string
        setSize(300, 230);          // set window size
        setVisible(true);           // display window

    } // end method createUserInterface

    // method for generating random numbers.
    private String generateRandomNumbers(int low, int high) {
        // generate a random number in range from low to high
        return String.valueOf(low + randomObject.nextInt(high - low));
    }

    // generate random lottery numbers
    private void generateJButtonActionPerformed(ActionEvent event) {
        output3JTextField.setText(generateRandomNumbers(0, 9) + " " +
                generateRandomNumbers(0, 9) + " " +
                generateRandomNumbers(0, 9));

        output4JTextField.setText(generateRandomNumbers(0, 9) + " " +
                generateRandomNumbers(0, 9) + " " +
                generateRandomNumbers(0, 9) + " " +
                generateRandomNumbers(0, 9));

        output5JTextField.setText(generateRandomNumbers(1, 39) + " " +
                generateRandomNumbers(1, 39) + " " +
                generateRandomNumbers(1, 39) + " " +
                generateRandomNumbers(1, 39) + " " +
                generateRandomNumbers(1, 39));

        output5Plus1JTextField.setText(generateRandomNumbers(1, 49) + " " +
                generateRandomNumbers(1, 49) + " " +
                generateRandomNumbers(1, 49) + " " +
                generateRandomNumbers(1, 49) + " " +
                generateRandomNumbers(1, 49));

        outputExtra1JTextField.setText(generateRandomNumbers(1, 42));
    } // end method generateJButtonActionPerformed

} // end class LotteryPicker

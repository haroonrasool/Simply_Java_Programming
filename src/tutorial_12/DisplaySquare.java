package tutorial_12;

// Exercise 12.12: DisplaySquare.java
// Displays a square of characters where the size of the square
// and the characters used in the square are specified by the user.

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class DisplaySquare extends JFrame {
    private JTextField squareSizeJTextField;

    private JTextField fillCharacterJTextField;

    // JTextArea and JScrollPane for displaying square
    private JTextArea outputJTextArea;

    // no-argument constructor
    public DisplaySquare() {
        createUserInterface();
    }

    // main method
    public static void main(String[] args) {
        DisplaySquare application = new DisplaySquare();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } // end method main

    // create and position GUI components; register event handlers
    private void createUserInterface() {
        // get content pane for attaching GUI components
        Container contentPane = getContentPane();

        // enable explicit positioning of GUI components
        contentPane.setLayout(null);

        // set up squareSizeJLabel
        // JLabel and JTextField for size of square sides
        JLabel squareSizeJLabel = new JLabel();
        squareSizeJLabel.setBounds(16, 16, 80, 21);
        squareSizeJLabel.setText("Square size:");
        contentPane.add(squareSizeJLabel);

        // set up squareSizeJTextField
        squareSizeJTextField = new JTextField();
        squareSizeJTextField.setBounds(104, 16, 24, 21);
        squareSizeJTextField.setHorizontalAlignment(
                JTextField.RIGHT);
        contentPane.add(squareSizeJTextField);

        // set up fillCharacterJLabel
        // JLabel and JTextField for fill character
        JLabel fillCharacterJLabel = new JLabel();
        fillCharacterJLabel.setBounds(16, 56, 80, 21);
        fillCharacterJLabel.setText("Fill character:");
        contentPane.add(fillCharacterJLabel);

        // set up fillCharacterJTextField
        fillCharacterJTextField = new JTextField();
        fillCharacterJTextField.setBounds(104, 56, 24, 21);
        fillCharacterJTextField.setHorizontalAlignment(
                JTextField.RIGHT);
        contentPane.add(fillCharacterJTextField);

        // set up outputJTextArea
        outputJTextArea = new JTextArea();
        outputJTextArea.setBackground(Color.LIGHT_GRAY);
        outputJTextArea.setEditable(false);
        contentPane.add(outputJTextArea);

        // set up outputJScrollPane
        JScrollPane outputJScrollPane = new JScrollPane(outputJTextArea);
        outputJScrollPane.setBounds(16, 96, 248, 136);
        contentPane.add(outputJScrollPane);

        // set up displaySquareJButton
        // JButton initiates creation and display of square
        JButton displaySquareJButton = new JButton();
        displaySquareJButton.setBounds(144, 16, 120, 23);
        displaySquareJButton.setText("Display Square");
        contentPane.add(displaySquareJButton);
        // anonymous inner class
        // event handler called when
        // displaySquareJButton is clicked
        displaySquareJButton.addActionListener(

                this::displaySquareJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set properties of application's window
        setTitle("Display Square"); // set title bar string
        setSize(288, 276);          // set window size
        setVisible(true);           // display window

    } // end method createUserInterface

    // display a square of characters
    private void displaySquareJButtonActionPerformed(
            ActionEvent event) {
        // if valid input is entered
        if ((!squareSizeJTextField.getText().equals("")) &&
                (!fillCharacterJTextField.getText().equals(""))) {
            // retrieve user input
            int squareSize = Integer.parseInt(
                    squareSizeJTextField.getText());
            String fillCharacter = fillCharacterJTextField.getText();

            outputJTextArea.setText(""); // clear output

            // loop until row reaches value of first argument (size)
            for (int row = 1; row <= squareSize; row++) {
                // loop until column reaches value of size
                for (int column = 1; column <= squareSize; column++) {
                    outputJTextArea.append(fillCharacter + "   ");
                }

                outputJTextArea.append("\n"); // add line to output
            }
        } else {
            JOptionPane.showMessageDialog(null,
                    "Square size and fill character needed",
                    "Incorrect Input", JOptionPane.ERROR_MESSAGE);
        }

    } // end method displaySquareJButtonActionPerformed

} // end class DisplaySquare

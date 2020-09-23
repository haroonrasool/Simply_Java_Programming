package tutorial_6;

// Exercise 6.16: GradeConverter.java
// Input a numeric grade from the user and 
// display the corresponding letter grade.

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class GradeConverter extends JFrame {
    private JTextField numberGradeJTextField;

    private JTextField letterGradeJTextField;

    // no-argument constructor
    public GradeConverter() {
        createUserInterface();
    }

    // main method
    public static void main(String[] args) {
        GradeConverter application = new GradeConverter();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } // end method main

    // create and position GUI components; register event handlers
    public void createUserInterface() {
        // get content pane and set its layout to null
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        // set up numberGradeJLabel
        // JLabel and JTextField for numeric grade
        JLabel numberGradeJLabel = new JLabel();
        numberGradeJLabel.setBounds(16, 16, 130, 20);
        numberGradeJLabel.setText("Enter grade (0-100):");
        contentPane.add(numberGradeJLabel);

        // set up numberGradeJTextField
        numberGradeJTextField = new JTextField();
        numberGradeJTextField.setBounds(140, 16, 32, 20);
        numberGradeJTextField.setHorizontalAlignment(
                JTextField.CENTER);
        contentPane.add(numberGradeJTextField);

        // set up letterGradeJLabel
        // JLabel and JTextField for equivalent letter grade
        JLabel letterGradeJLabel = new JLabel();
        letterGradeJLabel.setBounds(16, 56, 130, 20);
        letterGradeJLabel.setText("Letter grade:");
        contentPane.add(letterGradeJLabel);

        // set up letterGradeJTextField
        letterGradeJTextField = new JTextField();
        letterGradeJTextField.setBounds(140, 56, 32, 20);
        letterGradeJTextField.setHorizontalAlignment(
                JTextField.CENTER);
        letterGradeJTextField.setEditable(false);
        contentPane.add(letterGradeJTextField);

        // set up convertJButton and register its event handler
        // JButton to initiate conversion
        JButton convertJButton = new JButton();
        convertJButton.setBounds(57, 96, 90, 24);
        convertJButton.setText("Convert");
        contentPane.add(convertJButton);
        // anonymous inner class
        // event handler called when convertJButton is pressed
        convertJButton.addActionListener(

                this::convertJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set properties of application's window
        setTitle("Grade Converter");  // set title bar text
        setSize(195, 165);            // set window size
        setVisible(true);             // display window

    } // end method createUserInterface

    // method called when user clicks convertJButton
    public void convertJButtonActionPerformed(ActionEvent event) {
        int grade = Integer.parseInt(
                numberGradeJTextField.getText());
        if (grade >= 90) {
            letterGradeJTextField.setText("A");
        } else if (grade >= 80) {
            letterGradeJTextField.setText("B");
        } else if (grade >= 70) {
            letterGradeJTextField.setText("C");
        } else if (grade >= 60) {
            letterGradeJTextField.setText("D");
        } else {
            letterGradeJTextField.setText("F");
        }
    } // end method convertJButtonActionPerformed

} // end class GradeConverter

package tutorial_18.TriangleCreator;

// Exercise 18.11: TriangleCreator.java
// This application determines the types of triangles, based on the user input.

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class TriangleCreator extends JFrame {
    // JTextFields for sides.
    private JTextField side1JTextField;
    private JTextField side2JTextField;
    private JTextField side3JTextField;

    // JTextField for displaying message
    private JTextField messageJTextField;

    // no-argument constructor
    public TriangleCreator() {
        createUserInterface();
    }

    // main method
    public static void main(String[] args) {
        TriangleCreator application = new TriangleCreator();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } // end method main

    // create and position GUI components; register event handlers
    private void createUserInterface() {
        // get content pane for attaching GUI components
        Container contentPane = getContentPane();

        // enable explicit positioning of GUI components
        contentPane.setLayout(null);

        // set up side1JLabel
        // JLabel and JTextArea for side1
        JLabel side1JLabel = new JLabel();
        side1JLabel.setBounds(16, 16, 40, 24);
        side1JLabel.setText("Side1:");
        contentPane.add(side1JLabel);

        // set up side1JTextField
        side1JTextField = new JTextField();
        side1JTextField.setBounds(72, 16, 90, 24);
        side1JTextField.setHorizontalAlignment(JTextField.CENTER);
        contentPane.add(side1JTextField);

        // set up side2JLabel
        // JLabel and JTextArea for side2
        JLabel side2JLabel = new JLabel();
        side2JLabel.setBounds(16, 56, 40, 24);
        side2JLabel.setText("Side2:");
        contentPane.add(side2JLabel);

        // set up side2JTextField
        side2JTextField = new JTextField();
        side2JTextField.setBounds(72, 56, 90, 24);
        side2JTextField.setHorizontalAlignment(JTextField.CENTER);
        contentPane.add(side2JTextField);

        // set up side3JLabel
        // JLabel and JTextArea for side3
        JLabel side3JLabel = new JLabel();
        side3JLabel.setBounds(16, 96, 40, 24);
        side3JLabel.setText("Side3:");
        contentPane.add(side3JLabel);

        // set up side3JTextField
        side3JTextField = new JTextField();
        side3JTextField.setBounds(72, 96, 90, 24);
        side3JTextField.setHorizontalAlignment(JTextField.CENTER);
        contentPane.add(side3JTextField);

        // set up messageJTextField
        messageJTextField = new JTextField();
        messageJTextField.setBounds(16, 140, 252, 24);
        messageJTextField.setHorizontalAlignment(JTextField.CENTER);
        messageJTextField.setEditable(false);
        contentPane.add(messageJTextField);

        // set up createJButton
        // JButton to create triangle
        JButton createJButton = new JButton();
        createJButton.setBounds(178, 96, 90, 24);
        createJButton.setText("Create");
        contentPane.add(createJButton);
        // anonymous inner class
        // event handler called when createJButton is pressed
        createJButton.addActionListener(

                this::createJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set properties of application's window
        setTitle("Triangle Creator");   // set title bar string
        setSize(300, 220); // set window size
        setVisible(true);               // display window

    } // end method createUserInterface

    // get user input and display correct text
    private void createJButtonActionPerformed(ActionEvent event) {
        // retrieving the values of side1, side2, side3 from JTextFields.
        int side1 = Integer.parseInt(side1JTextField.getText());
        int side2 = Integer.parseInt(side2JTextField.getText());
        int side3 = Integer.parseInt(side3JTextField.getText());

        // create a triangle using the user input.
        Triangle triangle = new Triangle(side1, side2, side3);
        triangle.setSide1(side1);
        triangle.setSide2(side2);
        triangle.setSide3(side3);

        // determine if the triangle created is a right angled triangle or an equilateral triangle.
        if (triangle.isRightTriangle()) {
            messageJTextField.setText("You created a Right triangle!");
        } else if (triangle.isEquilateralTriangle()) {
            messageJTextField.setText("You created an Equilateral triangle!");
        } else {
            messageJTextField.setText("Neither an Equilateral or a Right triangle!");
        }

    } // end method createJButtonActionPerformed

} // end class TriangleCreator

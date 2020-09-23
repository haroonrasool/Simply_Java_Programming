package tutorial_15;

// Exercise 15.16: MultiplicationTeacher.java
// This game asks the user to enter the product of two
// randomly generated numbers in the range 0-9.

        import javax.swing.*;
        import java.awt.*;
        import java.awt.event.ActionEvent;
        import java.util.Random;

public class AdditionTeacher extends JFrame {
    // JLabel and JTextField to question user and get answer
    private JLabel questionJLabel;
    private JTextField answerJTextField;
    private JTextField responseJTextField;

    // String type array to store the messages.
    private final String[] messages = {"Very Good!", "Excellent!", "Great Job!"};

    // create new Random object
    private final Random randomObject = new Random();

    // create two positive one digit integer numbers.
    private final int number1 = randomObject.nextInt(10);
    private final int number2 = randomObject.nextInt(10);

    // no-argument constructor
    public AdditionTeacher() {
        createUserInterface();
    }

    // main method
    public static void main(String[] args) {
        AdditionTeacher application = new AdditionTeacher();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } // end method main

    // create and position GUI components; register event handlers
    private void createUserInterface() {
        // get content pane for attaching GUI components
        Container contentPane = getContentPane();

        // enable explicit positioning of GUI components
        contentPane.setLayout(null);

        // set up questionJLabel
        questionJLabel = new JLabel();
        questionJLabel.setBounds(20, 16, 148, 23);
        contentPane.add(questionJLabel);

        // set up answerJTextField
        answerJTextField = new JTextField();
        answerJTextField.setBounds(170, 16, 52, 21);
        answerJTextField.setHorizontalAlignment(JTextField.CENTER);
        contentPane.add(answerJTextField);

        // set up submitJButton
        // JButton to submit answer
        JButton submitJButton = new JButton();
        submitJButton.setBounds(70, 48, 152, 23);
        submitJButton.setText("Submit Answer");
        contentPane.add(submitJButton);
        // anonymous inner class
        // event handler called when submitJButton is clicked
        submitJButton.addActionListener(

                this::submitJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set up resultJLabel
        // JLabel and JTextField to display if user is correct
        JLabel resultJLabel = new JLabel();
        resultJLabel.setBounds(8, 80, 60, 23);
        resultJLabel.setText("Result:");
        contentPane.add(resultJLabel);

        // set up responseJTextField
        responseJTextField = new JTextField();
        responseJTextField.setBounds(70, 80, 152, 23);
        responseJTextField.setHorizontalAlignment(JTextField.CENTER);
        responseJTextField.setEditable(false);
        contentPane.add(responseJTextField);

        // calling the generateQuestion method.
        generateQuestion();

        // set properties of application's window
        setTitle("Multiplication Teacher"); // set title bar string
        setSize(220, 160);     // set window size
        setVisible(true);                   // display window

    } // end method createUserInterface

    // generate question in questionJLabel.
    private void generateQuestion() {
        questionJLabel.setText("How much is " + number1 + " plus " + number2 + "?");
    }

    // display random messages in responseJTextField.
    private String generateOutput() {
        // multiply the randomObject with the length of the messages array.
        int randomMessage = randomObject.nextInt(messages.length);
        // return the value of the index of the messages array.
        return String.valueOf(messages[randomMessage]);
    }

    // determine if user's answer is right
    private void submitJButtonActionPerformed(ActionEvent event) {
        // retrieve the user's answer from answerJTextField.
        int response = Integer.parseInt(answerJTextField.getText());
        // multiplying the two numbers and storing the answer in a variable.
        // declare instance variables
        int correctAnswer = number1 + number2;
        // determine whether the user's answer is correct?
        if (response == correctAnswer) {
            responseJTextField.setText(generateOutput());
        } else {
            responseJTextField.setText("Wrong Answer! Try again.");
        }
    } // end method submitJButtonActionPerformed
    // calling the generateQuestion method.

} // end class MultiplicationTeacher

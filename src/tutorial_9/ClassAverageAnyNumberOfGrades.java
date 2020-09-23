package tutorial_9;

// Exercise 9.12: ClassAverage.java
// Application enables user to have the average of grades calculated.

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ClassAverageAnyNumberOfGrades extends JFrame {
    private JTextArea gradeListJTextArea;

    // JButton initiates retrieving grades
    private JButton getGradesJButton;

    // JButton initiates calculating average
    private JButton averageJButton;

    private JTextField classAverageJTextField;

    private int total = 0; // holds value of the grade total

    // no-argument constructor
    public ClassAverageAnyNumberOfGrades() {
        createUserInterface();
    }

    // main method
    public static void main(String[] args) {
        ClassAverage application = new ClassAverage();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } // end method main

    // create and position GUI components; register event handlers
    private void createUserInterface() {
        // get content pane for attaching GUI components
        Container contentPane = getContentPane();

        // enable explicit positioning of GUI components
        contentPane.setLayout(null);

        // set up gradeListJLabel
        // JLabel and JTextArea for list of grades;
        // JScrollPane adds scrollbars to JTextArea
        JLabel gradeListJLabel = new JLabel();
        gradeListJLabel.setBounds(16, 8, 70, 23);
        gradeListJLabel.setText("Grade list:");
        contentPane.add(gradeListJLabel);

        // set up gradeListJTextArea
        gradeListJTextArea = new JTextArea();
        contentPane.add(gradeListJTextArea);

        // set up gradeListJScrollPane
        JScrollPane gradeListJScrollPane = new JScrollPane(gradeListJTextArea);
        gradeListJScrollPane.setBounds(16, 32, 88, 180);
        contentPane.add(gradeListJScrollPane);

        // set up getGradesJButton
        getGradesJButton = new JButton();
        getGradesJButton.setBounds(128, 50, 100, 26);
        getGradesJButton.setText("Get Grades");
        contentPane.add(getGradesJButton);
        // anonymous inner class
        // event handler called when getGradesJButton is clicked
        getGradesJButton.addActionListener(

                this::getGradesJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set up averageJButton
        averageJButton = new JButton();
        averageJButton.setBounds(128, 90, 100, 26);
        averageJButton.setText("Average");
        averageJButton.setEnabled(false);
        contentPane.add(averageJButton);
        // anonymous inner class
        // event handler called when averageJButton is clicked
        averageJButton.addActionListener(

                this::averageJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set up classAverageJLabel
        // JLabel and JTextField used to display average
        JLabel classAverageJLabel = new JLabel();
        classAverageJLabel.setBounds(128, 132, 90, 23);
        classAverageJLabel.setText("Class average:");
        contentPane.add(classAverageJLabel);

        // set up classAverageJTextField
        classAverageJTextField = new JTextField();
        classAverageJTextField.setBounds(128, 156, 100, 21);
        classAverageJTextField.setEditable(false);
        classAverageJTextField.setHorizontalAlignment(
                JTextField.CENTER);
        contentPane.add(classAverageJTextField);

        // set properties of application's window
        setTitle("Class Average"); // set title bar text
        setSize(260, 270);         // set window size
        setVisible(true);          // display window

    } // end method createUserInterface

    // method retrieves, totals and displays grades from user
    private void getGradesJButtonActionPerformed(ActionEvent event) {
        total = 0;        // stores total of grades entered
        int counter = 1;  // counter controls do...while statement
        String input;     // stores data entered into input dialog
        int grade;        // stores int value converted from input

        // clear previous grades and calculation result
        gradeListJTextArea.setText("");
        classAverageJTextField.setText("");

        do {
            // get user input
            input = JOptionPane.showInputDialog(null, "Enter Grade");
            grade = Integer.parseInt(input);

            // add text to output
            gradeListJTextArea.append(grade + "\n");
            total += grade;                     // add input to total
            counter++;                          // increment counter
        }
        while (counter <= 10);            // end do...while

        averageJButton.setEnabled(true);     // enable averageJButton
        averageJButton.requestFocusInWindow(); // transfer focus

        // disable getGradesJButton
        getGradesJButton.setEnabled(false);

    } // end method getGradesJButtonActionPerformed

    // method calculates average of grades entered
    private void averageJButtonActionPerformed(ActionEvent event) {
        double average = (double) total / 10; // calculate average
        classAverageJTextField.setText(String.valueOf(average));

        // disable averageJButton
        averageJButton.setEnabled(false);

        // enable getGradesJButton
        getGradesJButton.setEnabled(true);

        // transfer focus to getGradesJButton
        getGradesJButton.requestFocusInWindow();

    } // end method averageJButtonActionPerformed

} // end class ClassAverage

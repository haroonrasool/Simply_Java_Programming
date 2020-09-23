package tutorial_14;

// Exercise 14.11: TaskList.java
// Creates a task list based on user input.

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class TaskList extends JFrame {
    private JTextField taskJTextField;
    private JTextArea taskListJTextArea;
    private JTextField numberJTextField;

    // declare instance variable to store number of tasks
    int counter = 0;

    // no-argument constructor
    public TaskList() {
        createUserInterface();
    }

    // main method
    public static void main(String[] args) {
        TaskList application = new TaskList();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } // end method main

    // create and position GUI components; register event handlers
    private void createUserInterface() {
        // get content pane for attaching GUI components
        Container contentPane = getContentPane();

        // enable explicit positioning of GUI components
        contentPane.setLayout(null);

        // set up taskJLabel
        // JLabel and JTextField to display task
        JLabel taskJLabel = new JLabel();
        taskJLabel.setBounds(16, 16, 32, 24);
        taskJLabel.setText("Task:");
        contentPane.add(taskJLabel);

        // set up taskJTextField
        taskJTextField = new JTextField();
        taskJTextField.setBounds(56, 16, 128, 24);
        taskJTextField.setHorizontalAlignment(JTextField.LEFT);
        contentPane.add(taskJTextField);

        // set up addTaskJButton
        // JButton to enter task
        JButton addTaskJButton = new JButton();
        addTaskJButton.setBounds(200, 16, 148, 24);
        addTaskJButton.setText("Add Task");
        contentPane.add(addTaskJButton);
        // anonymous inner class
        // event handler called when addTaskJButton is clicked
        addTaskJButton.addActionListener(

                this::addTaskJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set up taskListJLabel
        // JLabel and JTextArea to display entered tasks
        JLabel taskListJLabel = new JLabel();
        taskListJLabel.setBounds(16, 64, 100, 24);
        taskListJLabel.setText("Task list:");
        contentPane.add(taskListJLabel);

        // set up taskListJTextArea
        taskListJTextArea = new JTextArea();
        taskListJTextArea.setBounds(16, 90, 168, 108);
        taskListJTextArea.setEditable(false);
        contentPane.add(taskListJTextArea);

        // set up numberJLabel
        // JLabel and JTextField to display number of entered tasks
        JLabel numberJLabel = new JLabel();
        numberJLabel.setBounds(200, 104, 116, 24);
        numberJLabel.setText("Number of Tasks:");
        contentPane.add(numberJLabel);

        // set up numberJTextField
        numberJTextField = new JTextField();
        numberJTextField.setBounds(316, 104, 32, 24);
        numberJTextField.setEditable(false);
        numberJTextField.setHorizontalAlignment(JTextField.CENTER);
        contentPane.add(numberJTextField);

        // set properties of application's window
        setTitle("Task List"); // set title bar string
        setSize(375, 250);     // set window size
        setVisible(true);      // display window

    } // end method createUserInterface

    // display task list and task number
    public void addTaskJButtonActionPerformed(ActionEvent event) {

        // retrieving user inout from taskJTextField
        String input = taskJTextField.getText();

        // add task to taskListJTextArea
        taskListJTextArea.append(input + "\n");

        // increment task number
        counter++;

        // display number of tasks
        numberJTextField.setText(String.valueOf(counter));

        // display numberOfTasks
        taskJTextField.setText("");
    } // end method addJButtonActionPerformed

} // end class TaskList

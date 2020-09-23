package tutorial_8;

// Exercise 8.17: ToDoList.java
// Creates a To-Do List based on user input.

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ToDoList extends JFrame {
    private JTextField taskJTextField;

    // JTextArea to display the to-do list
    private JTextArea outputJTextArea;

    // no-argument constructor
    public ToDoList() {
        createUserInterface();
    }

    // main method
    public static void main(String[] args) {
        ToDoList application = new ToDoList();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } // end method main

    // create and position GUI components; register event handlers
    public void createUserInterface() {
        // get content pane for attaching GUI components
        Container contentPane = getContentPane();

        // enable explicit positioning of GUI components
        contentPane.setLayout(null);

        // set up taskJLabel
        // JLabel and JTextField to input a task
        JLabel taskJLabel = new JLabel();
        taskJLabel.setBounds(16, 8, 40, 26);
        taskJLabel.setText("Task:");
        contentPane.add(taskJLabel);

        // set up taskJTextField
        taskJTextField = new JTextField();
        taskJTextField.setBounds(65, 8, 100, 26);
        taskJTextField.setHorizontalAlignment(JTextField.LEFT);
        contentPane.add(taskJTextField);

        // set up addJButton
        // JButton to initiate adding a task to the to-do list
        JButton addJButton = new JButton("Add");
        addJButton.setBounds(183, 8, 75, 26);
        contentPane.add(addJButton);
        // anonymous inner class
        // event handler called when user clicks addJButton
        addJButton.addActionListener(

                this::addJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set up outputJTextArea
        outputJTextArea = new JTextArea();
        outputJTextArea.setEditable(false);

        // set up JScrollPane to allow JTextArea scrolling
        JScrollPane scrollJScrollPane = new JScrollPane(outputJTextArea);
        scrollJScrollPane.setBounds(16, 48, 242, 95);
        contentPane.add(scrollJScrollPane);

        // set properties of application's window
        setTitle("To Do List"); // set title bar text
        setSize(280, 188); // set window's size
        setVisible(true); // display window

    } // end method createUserInterface

    // called when user clicks addJButton
    public void addJButtonActionPerformed(ActionEvent event) {
        int counter = outputJTextArea.getLineCount();
        outputJTextArea.append(counter + ". " + taskJTextField.getText() + "\n");
        taskJTextField.setText("");
    } // end method addJButtonActionPerformed

} // end class ToDoList

package tutorial_18.ViewName;

// Exercise 18.16: ViewName.java
// User inputs are displayed in a JOptionPane.

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ViewName extends JFrame {
    private JTextField firstJTextField;

    private JTextField lastJTextField;

    // no-argument constructor
    public ViewName() {
        createUserInterface();
    }

    // main method
    public static void main(String[] args) {
        ViewName application = new ViewName();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } // end method main

    // create and position GUI components; register event handler
    private void createUserInterface() {
        // get content pane for attaching GUI components
        Container contentPane = getContentPane();

        // enable explicit positioning of GUI components
        contentPane.setLayout(null);

        // set up firstJLabel
        // JLabel and JTextField for first name
        JLabel firstJLabel = new JLabel();
        firstJLabel.setBounds(16, 16, 80, 21);
        firstJLabel.setText("First name:");
        contentPane.add(firstJLabel);

        // set up firstJTextField
        firstJTextField = new JTextField();
        firstJTextField.setBounds(112, 16, 140, 21);
        firstJTextField.setHorizontalAlignment(JTextField.LEFT);
        contentPane.add(firstJTextField);

        // set up lastJLabel
        // JLabel and JTextField for last name
        JLabel lastJLabel = new JLabel();
        lastJLabel.setBounds(16, 56, 80, 21);
        lastJLabel.setText("Last name:");
        contentPane.add(lastJLabel);

        // set up lastJTextField
        lastJTextField = new JTextField();
        lastJTextField.setBounds(112, 56, 140, 21);
        lastJTextField.setHorizontalAlignment(JTextField.LEFT);
        contentPane.add(lastJTextField);

        // set up viewJButton
        // JButton to view name
        JButton viewJButton = new JButton();
        viewJButton.setBounds(142, 96, 100, 24);
        viewJButton.setText("View Name");
        contentPane.add(viewJButton);
        // anonymous inner class
        // event handler called when viewJButton is pressed
        viewJButton.addActionListener(

                this::viewJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set properties of application's window
        setTitle("View Name"); // set title bar string
        setSize(280, 180);     // set window size
        setVisible(true);      // display window

    } // end method createUserInterface

    // create new Name object and output to a JOptionPane
    private void viewJButtonActionPerformed(ActionEvent event) {
        // create new Name
        Name name = new Name(firstJTextField.getText(), lastJTextField.getText());

        // assign user's name to output
        String output = ("Your name is: " + name.getFirst() + " " + name.getLast());

        // display user's name
        JOptionPane.showMessageDialog(this, output, "Name",
                JOptionPane.INFORMATION_MESSAGE);

    } // end method viewJButtonActionPerformed

} // end class ViewName

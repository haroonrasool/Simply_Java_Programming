package tutorial_8;

// Exercise 8.13: OfficeSupplies.java
// Creates a list of office supplies to buy.

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class OfficeSupplies extends JFrame {

    // main method
    public static void main(String[] args) {
        OfficeSupplies application = new OfficeSupplies();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } // end method main

    private JTextField itemJTextField;

    // JTextArea and JScrollPane for displaying items to purchase
    private JTextArea outputJTextArea;

    // no-argument constructor
    public OfficeSupplies() {
        createUserInterface();
    }

    // create and position GUI components; register event handlers
    private void createUserInterface() {
        // get content pane for attaching GUI components
        Container contentPane = getContentPane();

        // enable explicit positioning of GUI components
        contentPane.setLayout(null);

        // set up itemJLabel
        // JLabel and JTextField for inputting items
        JLabel itemJLabel = new JLabel();
        itemJLabel.setBounds(16, 24, 35, 21);
        itemJLabel.setText("Item:");
        contentPane.add(itemJLabel);

        // set up itemJTextField
        itemJTextField = new JTextField();
        itemJTextField.setBounds(55, 24, 137, 21);
        itemJTextField.setHorizontalAlignment(JTextField.LEFT);
        contentPane.add(itemJTextField);

        // set up outputJTextArea
        outputJTextArea = new JTextArea();
        outputJTextArea.setEditable(false);

        // set up outputJScrollPane
        JScrollPane outputJScrollPane = new JScrollPane(outputJTextArea);
        outputJScrollPane.setBounds(16, 64, 176, 95);
        contentPane.add(outputJScrollPane);

        // set up buyJButton
        // JButton to add item to list of items being purchased
        JButton buyJButton = new JButton();
        buyJButton.setBounds(16, 176, 80, 24);
        buyJButton.setText("Buy");
        contentPane.add(buyJButton);
        // anonymous inner class
        // event handler called when buyJButton is pressed
        buyJButton.addActionListener(

                this::buyJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set up clearJButton
        // JButton to clear list of items being purchased
        JButton clearJButton = new JButton();
        clearJButton.setBounds(112, 176, 80, 24);
        clearJButton.setText("Clear");
        contentPane.add(clearJButton);
        // anonymous inner class
        // event handler called when clearJButton is pressed
        clearJButton.addActionListener(

                this::clearJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set properties of application�s window
        setTitle("Office Supplies"); // set title bar text
        setSize(218, 245);           // set window's size
        setVisible(true);            // display window

    } // end method createUserInterface

    // called when user clicks buyJButton
    public void buyJButtonActionPerformed(ActionEvent event) {
        String input = itemJTextField.getText();
        outputJTextArea.append(input + "\n");
        itemJTextField.setText("");
    } // end method buyJButtonActionPerformed

    // called when user clicks clearJButton
    public void clearJButtonActionPerformed(ActionEvent event) {
        outputJTextArea.setText("");
    } // end method clearJButtonActionPerformed

} // end class OfficeSupplies

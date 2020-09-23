package tutorial_2;

// Exercise 2.15: VendingMachine.java
// Creates vending machine GUI.

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class VendingMachine extends JFrame {
    // no-argument constructor
    public VendingMachine() {
        createUserInterface();
    }

    // main method
    public static void main(String[] args) {
        VendingMachine application = new VendingMachine();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } // end method main

    // create and position GUI components
    private void createUserInterface() {
        // get content pane and set layout to null
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        // set up windowJPanel
        JPanel windowJPanel = new JPanel();
        windowJPanel.setBounds(10, 10, 190, 170);
        windowJPanel.setBorder(new LineBorder(Color.BLACK));
        windowJPanel.setLayout(null);
        contentPane.add(windowJPanel);

        // set up a1IconJLabel
        JLabel a1IconJLabel = new JLabel();
        a1IconJLabel.setIcon(new ImageIcon("src/images/cookie.png"));
        a1IconJLabel.setBounds(10, 10, 50, 50);
        windowJPanel.add(a1IconJLabel);

        // set up a1JLabel
        JLabel a1JLabel = new JLabel();
        a1JLabel.setText("A1");
        a1JLabel.setBounds(10, 60, 50, 20);
        a1JLabel.setHorizontalAlignment(JLabel.CENTER);
        windowJPanel.add(a1JLabel);

        // set up a2IconJLabel
        JLabel a2IconJLabel = new JLabel();
        a2IconJLabel.setIcon(new ImageIcon("src/images/gum.png"));
        a2IconJLabel.setBounds(70, 10, 50, 50);
        windowJPanel.add(a2IconJLabel);

        // set up a2JLabel
        JLabel a2JLabel = new JLabel();
        a2JLabel.setText("A2");
        a2JLabel.setBounds(70, 60, 50, 20);
        a2JLabel.setHorizontalAlignment(JLabel.CENTER);
        windowJPanel.add(a2JLabel);

        // set up a3IconJLabel
        JLabel a3IconJLabel = new JLabel();
        a3IconJLabel.setIcon(new ImageIcon("src/images/pretzel.png"));
        a3IconJLabel.setBounds(130, 10, 50, 50);
        windowJPanel.add(a3IconJLabel);

        // set up a3JLabel
        JLabel a3JLabel = new JLabel();
        a3JLabel.setText("A3");
        a3JLabel.setBounds(130, 60, 50, 20);
        a3JLabel.setHorizontalAlignment(JLabel.CENTER);
        windowJPanel.add(a3JLabel);

        // set up b1IconJLabel
        JLabel b1IconJLabel = new JLabel();
        b1IconJLabel.setIcon(new ImageIcon("src/images/pretzel.png"));
        b1IconJLabel.setBounds(10, 90, 50, 50);
        windowJPanel.add(b1IconJLabel);

        // set up b1JLabel
        JLabel b1JLabel = new JLabel();
        b1JLabel.setText("B1");
        b1JLabel.setBounds(10, 140, 50, 20);
        b1JLabel.setHorizontalAlignment(JLabel.CENTER);
        windowJPanel.add(b1JLabel);

        // set up b2IconJLabel
        JLabel b2IconJLabel = new JLabel();
        b2IconJLabel.setIcon(new ImageIcon("src/images/cookie.png"));
        b2IconJLabel.setBounds(70, 90, 50, 50);
        windowJPanel.add(b2IconJLabel);

        // set up b2JLabel
        JLabel b2JLabel = new JLabel();
        b2JLabel.setText("B2");
        b2JLabel.setBounds(70, 140, 50, 20);
        b2JLabel.setHorizontalAlignment(JLabel.CENTER);
        windowJPanel.add(b2JLabel);

        // set up b3IconJLabel
        JLabel b3IconJLabel = new JLabel();
        b3IconJLabel.setIcon(new ImageIcon("src/images/soda.png"));
        b3IconJLabel.setBounds(130, 90, 50, 50);
        windowJPanel.add(b3IconJLabel);

        // set up b3JLabel
        JLabel b3JLabel = new JLabel();
        b3JLabel.setText("B3");
        b3JLabel.setBounds(130, 140, 50, 20);
        b3JLabel.setHorizontalAlignment(JLabel.CENTER);
        windowJPanel.add(b3JLabel);

        // set up pushJButton
        JButton pushJButton = new JButton();
        pushJButton.setText("PUSH");
        pushJButton.setBounds(10, 190, 190, 30);
        contentPane.add(pushJButton);

        // set up displayJTextField
        JTextField displayJTextField = new JTextField();
        displayJTextField.setText("B2");
        displayJTextField.setBounds(210, 10, 170, 30);
        displayJTextField.setEditable(false);
        displayJTextField.setHorizontalAlignment(JLabel.CENTER);
        contentPane.add(displayJTextField);

        // set up selectionJPanel
        JPanel selectionJPanel = new JPanel();
        selectionJPanel.setBounds(210, 50, 170, 130);
        selectionJPanel.setBorder(new TitledBorder(new EtchedBorder(
                EtchedBorder.LOWERED), "Please make selection"));
        selectionJPanel.setLayout(null);
        contentPane.add(selectionJPanel);

        // set up aJButton
        JButton aJButton = new JButton();
        aJButton.setText("A");
        aJButton.setBounds(40, 20, 42, 42);
        selectionJPanel.add(aJButton);

        // set up bJButton
        JButton bJButton = new JButton();
        bJButton.setText("B");
        bJButton.setBounds(90, 20, 42, 42);
        selectionJPanel.add(bJButton);

        // set up oneJButton
        JButton oneJButton = new JButton();
        oneJButton.setText("1");
        oneJButton.setBounds(12, 72, 42, 42);
        selectionJPanel.add(oneJButton);

        // set up twoJButton
        JButton twoJButton = new JButton();
        twoJButton.setText("2");
        twoJButton.setBounds(64, 72, 42, 42);
        selectionJPanel.add(twoJButton);

        // set up threeJButton
        JButton threeJButton = new JButton();
        threeJButton.setText("3");
        threeJButton.setBounds(116, 72, 42, 42);
        selectionJPanel.add(threeJButton);

        // set properties of application's window
        setTitle("VendingMachine"); // set title bar text
        setSize(400, 270);          // set window size
        setVisible(true);           // display window

    } // end method createUserInterface

} // end class VendingMachine

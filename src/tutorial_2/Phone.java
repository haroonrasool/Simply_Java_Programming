package tutorial_2;

// Exercise 2.14: Phone.java
// Creates the cell phone GUI.

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class Phone extends JFrame {
    // no-argument constructor
    public Phone() {
        createUserInterface();
    }

    // main method
    public static void main(String[] args) {
        Phone application = new Phone();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } // end method main

    // create and position GUI components
    private void createUserInterface() {
        // get content pane and set its layout
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        // set up displayJLabel
        JLabel displayJLabel = new JLabel();
        displayJLabel.setText("Deitel Wireless");
        displayJLabel.setBounds(10, 10, 170, 100);
        displayJLabel.setBorder(new LineBorder(Color.BLACK));
        displayJLabel.setHorizontalAlignment(JLabel.CENTER);
        displayJLabel.setBackground(Color.CYAN);
        displayJLabel.setOpaque(true);
        contentPane.add(displayJLabel);

        // set up talkJButton
        JButton talkJButton = new JButton();
        talkJButton.setText("TALK");
        talkJButton.setBounds(10, 120, 80, 30);
        contentPane.add(talkJButton);

        // set up endJButton
        JButton endJButton = new JButton();
        endJButton.setText("END");
        endJButton.setBounds(100, 120, 80, 30);
        contentPane.add(endJButton);

        // set up numberJPanel
        JPanel numberJPanel = new JPanel();
        numberJPanel.setBounds(10, 160, 170, 145);
        numberJPanel.setBorder(new LineBorder(Color.BLACK));
        numberJPanel.setLayout(null);
        contentPane.add(numberJPanel);

        // set up oneJButton
        JButton oneJButton = new JButton();
        oneJButton.setText("1");
        oneJButton.setBounds(5, 5, 50, 30);
        numberJPanel.add(oneJButton);

        // set up twoJButton
        JButton twoJButton = new JButton();
        twoJButton.setText("2");
        twoJButton.setBounds(60, 5, 50, 30);
        numberJPanel.add(twoJButton);

        // set up threeJButton
        JButton threeJButton = new JButton();
        threeJButton.setText("3");
        threeJButton.setBounds(115, 5, 50, 30);
        numberJPanel.add(threeJButton);

        // set up fourJButton
        JButton fourJButton = new JButton();
        fourJButton.setText("4");
        fourJButton.setBounds(5, 40, 50, 30);
        numberJPanel.add(fourJButton);

        // set up fiveJButton
        JButton fiveJButton = new JButton();
        fiveJButton.setText("5");
        fiveJButton.setBounds(60, 40, 50, 30);
        numberJPanel.add(fiveJButton);

        // set up sixJButton
        JButton sixJButton = new JButton();
        sixJButton.setText("6");
        sixJButton.setBounds(115, 40, 50, 30);
        numberJPanel.add(sixJButton);

        // set up sevenJButton
        JButton sevenJButton = new JButton();
        sevenJButton.setText("7");
        sevenJButton.setBounds(5, 75, 50, 30);
        numberJPanel.add(sevenJButton);

        // set up eightJButton
        JButton eightJButton = new JButton();
        eightJButton.setText("8");
        eightJButton.setBounds(60, 75, 50, 30);
        numberJPanel.add(eightJButton);

        // set up nineJButton
        JButton nineJButton = new JButton();
        nineJButton.setText("9");
        nineJButton.setBounds(115, 75, 50, 30);
        numberJPanel.add(nineJButton);

        // set up starJButton
        JButton starJButton = new JButton();
        starJButton.setText("*");
        starJButton.setBounds(5, 110, 50, 30);
        numberJPanel.add(starJButton);

        // set up zeroJButton
        JButton zeroJButton = new JButton();
        zeroJButton.setText("0");
        zeroJButton.setBounds(60, 110, 50, 30);
        numberJPanel.add(zeroJButton);

        // set up poundJButton
        JButton poundJButton = new JButton();
        poundJButton.setText("#");
        poundJButton.setBounds(115, 110, 50, 30);
        numberJPanel.add(poundJButton);

        // set properties of application's window
        setTitle("Phone"); // set title bar text
        setSize(205, 355); // set window size
        setVisible(true);  // display window

    } // end method createUserInterface

} // end class Phone

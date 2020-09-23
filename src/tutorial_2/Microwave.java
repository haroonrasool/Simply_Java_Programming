package tutorial_2;

// Exercise 2.13
// Create GUI Microwave

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class Microwave extends JFrame {
    // no-argument constructor
    public Microwave() {
        createUserInterface();
    }

    // main method
    public static void main(String[] args) {
        Microwave application = new Microwave();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } // end method main

    // create and position GUI components; register event handlers
    private void createUserInterface() {
        // get content pane and set layout to null
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        // set up doorJPanel
        JPanel doorJPanel = new JPanel();
        doorJPanel.setBounds(16, 16, 328, 284);
        doorJPanel.setBackground(Color.GRAY);
        contentPane.add(doorJPanel);

        // set up controlJPanel
        JPanel controlJPanel = new JPanel();
        controlJPanel.setLayout(null);
        controlJPanel.setBounds(368, 16, 182, 284);
        controlJPanel.setBorder(new LineBorder(Color.BLACK));
        contentPane.add(controlJPanel);

        // set up displayJLabel
        JLabel displayJLabel = new JLabel();
        displayJLabel.setBounds(31, 13, 120, 30);
        displayJLabel.setText("12:00");
        displayJLabel.setBorder(new LineBorder(Color.BLACK));
        displayJLabel.setHorizontalAlignment(JLabel.CENTER);
        controlJPanel.add(displayJLabel);

        // set up oneJButton
        JButton oneJButton = new JButton();
        oneJButton.setBounds(23, 56, 45, 45);
        oneJButton.setText("1");
        controlJPanel.add(oneJButton);

        // set up twoJButton
        JButton twoJButton = new JButton();
        twoJButton.setBounds(68, 56, 45, 45);
        twoJButton.setText("2");
        controlJPanel.add(twoJButton);

        // set up threeJButton
        JButton threeJButton = new JButton();
        threeJButton.setBounds(113, 56, 45, 45);
        threeJButton.setText("3");
        controlJPanel.add(threeJButton);

        // set up fourJButton
        JButton fourJButton = new JButton();
        fourJButton.setBounds(23, 101, 45, 45);
        fourJButton.setText("4");
        controlJPanel.add(fourJButton);

        // set up fiveJButton
        JButton fiveJButton = new JButton();
        fiveJButton.setBounds(68, 101, 45, 45);
        fiveJButton.setText("5");
        controlJPanel.add(fiveJButton);

        // set up sixJButton
        JButton sixJButton = new JButton();
        sixJButton.setBounds(113, 101, 45, 45);
        sixJButton.setText("6");
        controlJPanel.add(sixJButton);

        // set up sevenJButton
        JButton sevenJButton = new JButton();
        sevenJButton.setBounds(23, 146, 45, 45);
        sevenJButton.setText("7");
        controlJPanel.add(sevenJButton);

        // set up eightJButton
        JButton eightJButton = new JButton();
        eightJButton.setBounds(68, 146, 45, 45);
        eightJButton.setText("8");
        controlJPanel.add(eightJButton);

        // set up nineJButton
        JButton nineJButton = new JButton();
        nineJButton.setBounds(113, 146, 45, 45);
        nineJButton.setText("9");
        controlJPanel.add(nineJButton);

        // set up zeroJButton
        JButton zeroJButton = new JButton();
        zeroJButton.setBounds(68, 191, 45, 45);
        zeroJButton.setText("0");
        controlJPanel.add(zeroJButton);

        // set up startJButton
        JButton startJButton = new JButton();
        startJButton.setBounds(13, 252, 74, 24);
        startJButton.setText("Start");
        controlJPanel.add(startJButton);

        // set up clearJButton
        JButton clearJButton = new JButton();
        clearJButton.setBounds(100, 252, 74, 24);
        clearJButton.setText("Clear");
        controlJPanel.add(clearJButton);

        // set properties of application's window
        setTitle("Microwave"); // set title bar text
        setSize(574, 346);     // set window size
        setVisible(true);      // display window

    } // end method createUserInterface

} // end class Microwave

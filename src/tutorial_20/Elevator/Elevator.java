package tutorial_20.Elevator;

// Exercise 20.13: Elevator.java
// Application simulates an elevator.

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Elevator extends JFrame {
    // JTextArea for displaying elevator location
    public JTextArea displayJTextArea;

    // DrawJPanel for displaying rectangles
    private DrawJPanel drawingJPanel;

    // no-argument constructor
    public Elevator() {
        createUserInterface();
    }

    // main method
    public static void main(String[] args) {
        Elevator application = new Elevator();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } // end method main

    // create and position GUI components; register event handlers
    private void createUserInterface() {
        // get content pane for attaching GUI components
        Container contentPane = getContentPane();

        // enable explicit positioning of GUI components
        contentPane.setLayout(null);

        // set up selectFloorJLabel
        // JLabel for elevator JButtons
        JLabel selectFloorJLabel = new JLabel();
        selectFloorJLabel.setBounds(15, 65, 100, 25);
        selectFloorJLabel.setText("Select Floor:");
        contentPane.add(selectFloorJLabel);

        // set up oneJButton
        // JButtons to select the floor
        JButton oneJButton = new JButton();
        oneJButton.setBounds(15, 100, 41, 41);
        oneJButton.setText("1");
        contentPane.add(oneJButton);
        // anonymous inner class
        // event handler called when oneJButton is pressed
        oneJButton.addActionListener(

                this::oneJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set up twoJButton
        JButton twoJButton = new JButton();
        twoJButton.setBounds(75, 100, 41, 41);
        twoJButton.setText("2");
        contentPane.add(twoJButton);
        // anonymous inner class
        // event handler called when twoJButton is pressed
        twoJButton.addActionListener(

                this::twoJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set up threeJButton
        JButton threeJButton = new JButton();
        threeJButton.setBounds(135, 100, 41, 41);
        threeJButton.setText("3");
        contentPane.add(threeJButton);
        // anonymous inner class
        // event handler called when threeJButton is pressed
        threeJButton.addActionListener(

                this::threeJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set up fourJButton
        JButton fourJButton = new JButton();
        fourJButton.setBounds(15, 160, 41, 41);
        fourJButton.setText("4");
        contentPane.add(fourJButton);
        // anonymous inner class
        // event handler called when fourJButton is pressed
        fourJButton.addActionListener(

                this::fourJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set up fiveJButton
        JButton fiveJButton = new JButton();
        fiveJButton.setBounds(75, 160, 41, 41);
        fiveJButton.setText("5");
        contentPane.add(fiveJButton);
        // anonymous inner class
        // event handler called when fiveJButton is pressed
        fiveJButton.addActionListener(

                this::fiveJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set up sixJButton
        JButton sixJButton = new JButton();
        sixJButton.setBounds(135, 160, 41, 41);
        sixJButton.setText("6");
        contentPane.add(sixJButton);
        // anonymous inner class
        // event handler called when sixJButton is pressed
        sixJButton.addActionListener(

                this::sixJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set up sevenJButton
        JButton sevenJButton = new JButton();
        sevenJButton.setBounds(15, 220, 41, 41);
        sevenJButton.setText("7");
        contentPane.add(sevenJButton);
        // anonymous inner class
        // event handler called when sevenJButton is pressed
        sevenJButton.addActionListener(

                this::sevenJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set up eightJButton
        JButton eightJButton = new JButton();
        eightJButton.setBounds(75, 220, 41, 41);
        eightJButton.setText("8");
        contentPane.add(eightJButton);
        // anonymous inner class
        // event handler called when eightJButton is pressed
        eightJButton.addActionListener(

                this::eightJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set up nineJButton
        JButton nineJButton = new JButton();
        nineJButton.setBounds(135, 220, 41, 41);
        nineJButton.setText("9");
        contentPane.add(nineJButton);
        // anonymous inner class
        // event handler called when nineJButton is pressed
        nineJButton.addActionListener(

                this::nineJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set up displayJTextArea
        displayJTextArea = new JTextArea();
        displayJTextArea.setBounds(16, 290, 170, 20);
        displayJTextArea.setEditable(false);
        displayJTextArea.setForeground(Color.RED);
        contentPane.add(displayJTextArea);

        // set up drawingJPanel
        drawingJPanel = new DrawJPanel();
        drawingJPanel.setBounds(215, 50, 150, 450);
        drawingJPanel.setBackground(Color.WHITE);
        contentPane.add(drawingJPanel);

        // set up floorJLabel
        // JLabel for displaying floor sign
        JLabel floorJLabel = new JLabel();
        floorJLabel.setBounds(375, 16, 50, 25);
        floorJLabel.setText("Floor:");
        contentPane.add(floorJLabel);

        // set up oneJLabel
        // JLabels for displaying the floor
        JLabel oneJLabel = new JLabel();
        oneJLabel.setBounds(385, 460, 25, 25);
        oneJLabel.setText("1");
        contentPane.add(oneJLabel);

        // set up twoJLabel
        JLabel twoJLabel = new JLabel();
        twoJLabel.setBounds(385, 410, 25, 25);
        twoJLabel.setText("2");
        contentPane.add(twoJLabel);

        // set up threeJLabel
        JLabel threeJLabel = new JLabel();
        threeJLabel.setBounds(385, 360, 25, 25);
        threeJLabel.setText("3");
        contentPane.add(threeJLabel);

        // set up fourJLabel
        JLabel fourJLabel = new JLabel();
        fourJLabel.setBounds(385, 310, 25, 25);
        fourJLabel.setText("4");
        contentPane.add(fourJLabel);

        // set up fiveJLabel
        JLabel fiveJLabel = new JLabel();
        fiveJLabel.setBounds(385, 260, 25, 25);
        fiveJLabel.setText("5");
        contentPane.add(fiveJLabel);

        // set up sixJLabel
        JLabel sixJLabel = new JLabel();
        sixJLabel.setBounds(385, 210, 25, 25);
        sixJLabel.setText("6");
        contentPane.add(sixJLabel);

        // set up sevenJLabel
        JLabel sevenJLabel = new JLabel();
        sevenJLabel.setBounds(385, 160, 25, 25);
        sevenJLabel.setText("7");
        contentPane.add(sevenJLabel);

        // set up eightJLabel
        JLabel eightJLabel = new JLabel();
        eightJLabel.setBounds(385, 110, 25, 25);
        eightJLabel.setText("8");
        contentPane.add(eightJLabel);

        // set up nineJLabel
        JLabel nineJLabel = new JLabel();
        nineJLabel.setBounds(385, 60, 25, 25);
        nineJLabel.setText("9");
        contentPane.add(nineJLabel);

        // set properties of application's window
        setTitle("Elevator"); // set title bar text
        setSize(430, 540);    // set window size
        setVisible(true);     // display window

    } // end method createUserInterface

    // move the elevator to the first floor
    private void oneJButtonActionPerformed(ActionEvent event) {
        drawingJPanel.moveElevatorToFloor(1); // move the elevator

        // display a message in the displayJTextArea
        displayJTextArea.setText("You are on the 1st floor");

    } // end method oneJButtonActionPerformed

    // move the elevator to the second floor
    private void twoJButtonActionPerformed(ActionEvent event) {
        drawingJPanel.moveElevatorToFloor(2); // move the elevator

        // display a message in the displayJTextArea
        displayJTextArea.setText("You are on the 2nd floor");

    } // end method twoJButtonActionPerformed

    // move the elevator to the third floor
    private void threeJButtonActionPerformed(ActionEvent event) {
        drawingJPanel.moveElevatorToFloor(3); // move the elevator

        // display a message in the displayJTextArea
        displayJTextArea.setText("You are on the 3rd floor");

    } // end method threeJButtonActionPerformed

    // move the elevator to the fourth floor
    private void fourJButtonActionPerformed(ActionEvent event) {
        drawingJPanel.moveElevatorToFloor(4); // move the elevator

        // display a message in the displayJTextArea
        displayJTextArea.setText("You are on the 4th floor");

    } // end method fourJButtonActionPerformed

    // move the elevator to the fifth floor
    private void fiveJButtonActionPerformed(ActionEvent event) {
        drawingJPanel.moveElevatorToFloor(5); // move the elevator

        // display a message in the displayJTextArea
        displayJTextArea.setText("You are on the 5th floor");

    } // end method fiveJButtonActionPerformed

    // move the elevator to the sixth floor
    private void sixJButtonActionPerformed(ActionEvent event) {
        drawingJPanel.moveElevatorToFloor(6); // move the elevator

        // display a message in the displayJTextArea
        displayJTextArea.setText("You are on the 6th floor");

    } // end method sixJButtonActionPerformed

    // move the elevator to the seventh floor
    private void sevenJButtonActionPerformed(ActionEvent event) {
        drawingJPanel.moveElevatorToFloor(7); // move the elevator

        // display a message in the displayJTextArea
        displayJTextArea.setText("You are on the 7th floor");

    } // end method sevenJButtonActionPerformed

    // move the elevator to the eighth floor
    private void eightJButtonActionPerformed(ActionEvent event) {
        drawingJPanel.moveElevatorToFloor(8); // move the elevator

        // display a message in the displayJTextArea
        displayJTextArea.setText("You are on the 8th floor");

    } // end method eightJButtonActionPerformed

    // move the elevator to the ninth floor
    private void nineJButtonActionPerformed(ActionEvent event) {
        drawingJPanel.moveElevatorToFloor(9); // move the elevator

        // display a message in the displayJTextArea
        displayJTextArea.setText("You are on the 9th floor");

    } // end method nineJButtonActionPerformed

} // end class Elevator

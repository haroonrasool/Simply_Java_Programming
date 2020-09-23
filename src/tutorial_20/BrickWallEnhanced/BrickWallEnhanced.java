package tutorial_20.BrickWallEnhanced;

// Tutorial 20: BrickWall.java
// Application builds a brick wall using rectangles.

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class BrickWallEnhanced extends JFrame {

    // DrawJPanel for displaying bricks
    private DrawJPanelEnhanced drawingJPanelEnhanced;

    private JTextField rowsJTextField;

    public JTextField columnsJTextField;

    // no-argument constructor
    public BrickWallEnhanced() {
        createUserInterface();
    }

    // main method
    public static void main(String[] args) {
        BrickWallEnhanced application = new BrickWallEnhanced();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } // end method main

    // create and position GUI components; register event handlers
    private void createUserInterface() {
        // get content pane for attaching GUI components
        Container contentPane = getContentPane();

        // enable explicit positioning of GUI components
        contentPane.setLayout(null);

        // set up drawJButton
        // JButton to draw the brick wall
        JButton drawJButton = new JButton();
        drawJButton.setBounds(100, 8, 100, 23);
        drawJButton.setText("Draw Wall");
        contentPane.add(drawJButton);
        // anonymous inner class
        // method called when clearJButton is pressed
        drawJButton.addActionListener(

                this::drawJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set up clearJButton
        // JButton to clear the JPanel
        JButton clearJButton = new JButton();
        clearJButton.setBounds(250, 8, 100, 23);
        clearJButton.setText("Clear");
        contentPane.add(clearJButton);
        // anonymous inner class
        // method called when clearJButton is pressed
        clearJButton.addActionListener(

                this::clearJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set up drawingJPanel
        drawingJPanelEnhanced = new DrawJPanelEnhanced();
        drawingJPanelEnhanced.setBounds(0, 40, 450, 250);
        drawingJPanelEnhanced.setBackground(Color.WHITE);
        contentPane.add(drawingJPanelEnhanced);

        // set up rowsJLabel
        // JLabel and JTextField for inputting rows
        JLabel rowsJLabel = new JLabel();
        rowsJLabel.setBounds(50, 325, 50, 25);
        rowsJLabel.setText("Rows:");
        contentPane.add(rowsJLabel);

        // set up rowsJTextField
        rowsJTextField = new JTextField();
        rowsJTextField.setBounds(100, 325, 50, 25);
        rowsJTextField.setHorizontalAlignment(JTextField.CENTER);
        contentPane.add(rowsJTextField);

        // set up columnsJLabel
        // JLabel and JTextField for inputting columns
        JLabel columnsJLabel = new JLabel();
        columnsJLabel.setBounds(225, 325, 75, 25);
        columnsJLabel.setText("Columns:");
        contentPane.add(columnsJLabel);

        // set up columnsJTextField
        columnsJTextField = new JTextField();
        columnsJTextField.setBounds(290, 325, 50, 25);
        columnsJTextField.setHorizontalAlignment(JTextField.CENTER);
        contentPane.add(columnsJTextField);

        // set properties of application's window
        setTitle("Brick Wall");   // set title bar text
        setSize(459, 400);        // set window size
        setVisible(true);         // display window

    } // end method createUserInterface

    // reset drawingJPanel
    private void clearJButtonActionPerformed(ActionEvent event) {
        drawingJPanelEnhanced.clearArray();
        drawingJPanelEnhanced.repaint();
    } // end method drawJButtonActionPerformed

    // draw the brick wall
    private void drawJButtonActionPerformed(ActionEvent event) {
        // get the user input for Rows from rowsJTextField.
        int numberOfRows = Integer.parseInt(rowsJTextField.getText());

        // get the user input for Columns from columnsJTextField.
        int numberOfColumns = Integer.parseInt(columnsJTextField.getText());

        // call the drawBricks method
        drawingJPanelEnhanced.drawBricks(numberOfRows, numberOfColumns);

    } // end method drawJButtonActionPerformed

} // end class BrickWall

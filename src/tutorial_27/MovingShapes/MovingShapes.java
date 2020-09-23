package tutorial_27.MovingShapes;

// Exercise 27.16: MovingShapes.java
// Application allows user to create shapes that move around screen.

import java.awt.*;
import java.awt.event.*;
import java.util.Objects;
import javax.swing.*;

public class MovingShapes extends JFrame {
    // JComboBox to choose a drawing shape
    private JComboBox<String> shapeJComboBox;

    // JButton to select a new color
    private JButton colorJButton;

    // PaintJPanel for drawing shapes
    private PaintJPanel painterPaintJPanel;

    // String array for storing the choices in shapeJComboBox
    private final String[] shapeTypes = {"Line", "Rectangle", "Oval"};

    // no-argument constructor
    public MovingShapes() {
        createUserInterface();
    }

    // main method
    public static void main(String[] args) {
        MovingShapes application = new MovingShapes();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } // end method main

    // create and position GUI components; register event handlers
    private void createUserInterface() {
        // get content pane for attaching GUI components
        Container contentPane = getContentPane();

        // enable explicit positioning of GUI components
        contentPane.setLayout(null);

        // set up controlsJPanel
        JPanel controlsJPanel = new JPanel();
        controlsJPanel.setBounds(0, 0, 400, 40);
        controlsJPanel.setLayout(null);
        contentPane.add(controlsJPanel);

        // set up painterPaintJPanel
        painterPaintJPanel = new PaintJPanel();
        painterPaintJPanel.setBounds(0, 40, 400, 340);
        painterPaintJPanel.setBackground(Color.WHITE);
        contentPane.add(painterPaintJPanel);

        // set up shapeJComboBox
        shapeJComboBox = new JComboBox<>(shapeTypes);
        shapeJComboBox.setBounds(100, 2, 90, 24);
        controlsJPanel.add(shapeJComboBox);
        // anonymous inner class
        // event handler called when shapeJComboBox is selected
        shapeJComboBox.addActionListener(

                this::shapeJComboBoxActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set up colorJButton
        colorJButton = new JButton();
        colorJButton.setText("Color");
        colorJButton.setBounds(210, 2, 80, 24);
        controlsJPanel.add(colorJButton);
        // anonymous inner class
        // event handler called when colorJButton is pressed
        colorJButton.addActionListener(

                this::colorJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set properties of application's window
        setTitle("Moving Shapes"); // set title bar string
        setSize(408, 407);         // set window size
        setVisible(true);          // display window

    } // end method createUserInterface

    // select a new color for the shape
    private void colorJButtonActionPerformed(ActionEvent event) {
        Color selection = JColorChooser.showDialog(null,
                "Select a Color", Color.BLACK);
        colorJButton.setBackground(selection);
        painterPaintJPanel.setCurrentColor(selection);

    } // end method colorJButtonActionPerformed

    // set the selected shape in the painting panel
    private void shapeJComboBoxActionPerformed(ActionEvent e) {
        painterPaintJPanel.setCurrentShapeType(
                Objects.requireNonNull(shapeJComboBox.getSelectedItem()).toString());

    } // end method shapeJComboBoxActionPerformed

} // end class MovingShapes

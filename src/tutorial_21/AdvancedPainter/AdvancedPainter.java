package tutorial_21.AdvancedPainter;

// Exercise 21.16: AdvancedPainter.java
// This application allows the user to draw with four different 
// colors and three different sized brushes.

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class AdvancedPainter extends JFrame {
    // PainterJPanel for drawing circles
    private PainterJPanel myPainterJPanel;

    // size constants for diameter of circle
    final int SMALL = 4;
    final int MEDIUM = 8;
    final int LARGE = 10;

    // no-argument constructor
    public AdvancedPainter() {
        createUserInterface();
    }

    // main method
    public static void main(String[] args) {
        AdvancedPainter application = new AdvancedPainter();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } // end method main

    // create and position GUI components; register event handlers
    public void createUserInterface() {
        // get content pane for attaching GUI components
        Container contentPane = getContentPane();

        // enable explicit positioning of GUI components
        contentPane.setLayout(null);

        // set up myPainterJPanel to paint small, black circles
        myPainterJPanel = new PainterJPanel(Color.BLACK, SMALL);
        myPainterJPanel.setBounds(112, 8, 336, 272);
        myPainterJPanel.setBackground(Color.WHITE);
        contentPane.add(myPainterJPanel);

        // set up colorJPanel
        // JPanel and ButtonGroup for color JRadioButtons
        JPanel colorJPanel = new JPanel();
        colorJPanel.setBounds(8, 8, 96, 152);
        colorJPanel.setBorder(new TitledBorder("Color"));
        colorJPanel.setOpaque(false);
        colorJPanel.setLayout(null);
        contentPane.add(colorJPanel);

        // set up colorButtonGroup
        ButtonGroup colorButtonGroup = new ButtonGroup();

        // set up redJRadioButton
        // JRadioButtons for color of circle
        JRadioButton redJRadioButton = new JRadioButton();
        redJRadioButton.setBounds(16, 16, 56, 24);
        redJRadioButton.setText("Red");
        colorButtonGroup.add(redJRadioButton);
        colorJPanel.add(redJRadioButton);
        // anonymous inner class
        // event handler called when redJRadioButton is selected
        redJRadioButton.addActionListener(

                event -> redJRadioButtonActionPerformed() // end anonymous inner class

        ); // end call to addActionListener

        // set up blueJRadioButton
        JRadioButton blueJRadioButton = new JRadioButton();
        blueJRadioButton.setBounds(16, 48, 56, 24);
        blueJRadioButton.setText("Blue");
        colorButtonGroup.add(blueJRadioButton);
        colorJPanel.add(blueJRadioButton);
        // anonymous inner class
        // event handler called when blueJRadioButton is selected
        blueJRadioButton.addActionListener(

                this::blueJRadioButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set up greenJRadioButton
        JRadioButton greenJRadioButton = new JRadioButton();
        greenJRadioButton.setBounds(16, 80, 62, 24);
        greenJRadioButton.setText("Green");
        colorButtonGroup.add(greenJRadioButton);
        colorJPanel.add(greenJRadioButton);
        // anonymous inner class
        // event handler called when greenJRadioButton is selected
        greenJRadioButton.addActionListener(

                this::greenJRadioButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set up blackJRadioButton
        JRadioButton blackJRadioButton = new JRadioButton();
        blackJRadioButton.setBounds(16, 112, 62, 24);
        blackJRadioButton.setText("Black");
        blackJRadioButton.setSelected(true);
        colorButtonGroup.add(blackJRadioButton);
        colorJPanel.add(blackJRadioButton);
        // anonymous inner class
        // event handler called when blackJRadioButton is selected
        blackJRadioButton.addActionListener(

                this::blackJRadioButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set up sizeJPanel
        // JPanel and ButtonGroup for size JRadioButtons
        JPanel sizeJPanel = new JPanel();
        sizeJPanel.setBounds(8, 168, 96, 112);
        sizeJPanel.setBorder(new TitledBorder("Size"));
        sizeJPanel.setOpaque(false);
        sizeJPanel.setLayout(null);
        contentPane.add(sizeJPanel);

        // set up sizeButtonGroup
        ButtonGroup sizeButtonGroup = new ButtonGroup();

        // set up smallJRadioButton
        // JRadioButtons for size of circle
        JRadioButton smallJRadioButton = new JRadioButton();
        smallJRadioButton.setBounds(16, 16, 64, 24);
        smallJRadioButton.setText("Small");
        smallJRadioButton.setSelected(true);
        sizeButtonGroup.add(smallJRadioButton);
        sizeJPanel.add(smallJRadioButton);
        // anonymous inner class
        // event handler called when smallJRadioButton is selected
        smallJRadioButton.addActionListener(

                this::smallJRadioButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set up mediumJRadioButton
        JRadioButton mediumJRadioButton = new JRadioButton();
        mediumJRadioButton.setBounds(16, 48, 70, 24);
        mediumJRadioButton.setText("Medium");
        sizeButtonGroup.add(mediumJRadioButton);
        sizeJPanel.add(mediumJRadioButton);
        // anonymous inner class
        // event handler called when mediumJRadioButton is selected
        mediumJRadioButton.addActionListener(

                this::mediumJRadioButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set up largeJRadioButton
        JRadioButton largeJRadioButton = new JRadioButton();
        largeJRadioButton.setBounds(16, 80, 64, 24);
        largeJRadioButton.setText("Large");
        sizeButtonGroup.add(largeJRadioButton);
        sizeJPanel.add(largeJRadioButton);
        // anonymous inner class
        // event handler called when largeJRadioButton is selected
        largeJRadioButton.addActionListener(

                this::largeJRadioButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set up properties of application's window
        setTitle("Advanced Painter"); // set title bar text
        setSize(462, 312);            // set window size
        setVisible(true);             // display window

    } // end method createUserInterface

    // set circle color to red
    private void redJRadioButtonActionPerformed() {
        myPainterJPanel.setColor(Color.RED);
    } // end method redJRadioButtonActionPerformed

    // set circle color to blue
    private void blueJRadioButtonActionPerformed(ActionEvent event) {
        myPainterJPanel.setColor(Color.BLUE);
    } // end method blueJRadioButtonActionPerformed

    // set circle color to green
    private void greenJRadioButtonActionPerformed(ActionEvent event) {
        myPainterJPanel.setColor(Color.GREEN);
    } // end method greenJRadioButtonActionPerformed

    // set circle color to black
    private void blackJRadioButtonActionPerformed(ActionEvent event) {
        myPainterJPanel.setColor(Color.BLACK);
    } // end method blackJRadioButtonActionPerformed

    // set circle size to small
    private void smallJRadioButtonActionPerformed(ActionEvent event) {
        myPainterJPanel.setDiameter(SMALL);
    } // end method smallJRadioButtonActionPerformed

    // set circle size to medium
    private void mediumJRadioButtonActionPerformed(ActionEvent event) {
        myPainterJPanel.setDiameter(MEDIUM);
    } // end method mediumJRadioButtonActionPerformed

    // set circle size to large
    private void largeJRadioButtonActionPerformed(ActionEvent event) {
        myPainterJPanel.setDiameter(LARGE);
    } // end method largeJRadioButtonActionPerformed

} // end class AdvancedPainter

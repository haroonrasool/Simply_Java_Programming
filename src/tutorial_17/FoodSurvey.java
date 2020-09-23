package tutorial_17;

// Exercise 17.11: FoodSurvey.java
// This program takes a survey of opinions on various foods.

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class FoodSurvey extends JFrame {
    private JComboBox<Object> foodJComboBox;
    private JTextArea displayJTextArea;
    private JRadioButton likeJRadioButton;
    private JRadioButton dislikeJRadioButton;

    // one directional String array for food choices
    private final String[] foodChoices = {"Pizza", "Hot Dog",
            "Fish Sticks", "Mystery Meat"};

    // declaring and initializing a two dimensional integer type array
    // to display four rows and two columns
    int[][] display = new int[4][2];

    // no-argument constructor
    public FoodSurvey() {
        createUserInterface();
    }

    // main method
    public static void main(String[] args) {
        FoodSurvey application = new FoodSurvey();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } // end method main

    // create and position GUI components; register event handlers
    private void createUserInterface() {
        // get content pane for attaching GUI components
        Container contentPane = getContentPane();

        // enable explicit positioning of GUI components
        contentPane.setLayout(null);

        // set up foodJComboBox
        // JComboBox to give choice of foods
        foodJComboBox = new JComboBox<>(foodChoices);
        foodJComboBox.setBounds(16, 16, 110, 23);
        contentPane.add(foodJComboBox);

        // set up choiceButtonGroup
        // ButtonGroup to control like and dislike JRadioButtons
        ButtonGroup choiceButtonGroup = new ButtonGroup();

        // set up likeJRadioButton
        // JRadioButtons to choose like or dislike of food
        likeJRadioButton = new JRadioButton();
        likeJRadioButton.setBounds(135, 16, 60, 23);
        likeJRadioButton.setText("Like");
        likeJRadioButton.setSelected(true);
        choiceButtonGroup.add(likeJRadioButton);
        contentPane.add(likeJRadioButton);

        // set up dislikeJRadioButton
        dislikeJRadioButton = new JRadioButton();
        dislikeJRadioButton.setBounds(195, 16, 70, 23);
        dislikeJRadioButton.setText("Dislike");
        choiceButtonGroup.add(dislikeJRadioButton);
        contentPane.add(dislikeJRadioButton);

        // set up addJButton
        // JButton to add choice to JTextArea
        JButton addJButton = new JButton();
        addJButton.setBounds(265, 16, 67, 23);
        addJButton.setText("Add");
        contentPane.add(addJButton);
        // anonymous inner class
        // event handler called when addJButton is clicked
        addJButton.addActionListener(

                this::addJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set up displayJTextArea
        // JTextArea to display results
        displayJTextArea = new JTextArea();
        displayJTextArea.setBounds(16, 55, 315, 93);
        displayJTextArea.setEditable(false);
        contentPane.add(displayJTextArea);

        // set properties of application's window
        setTitle("Food Survey"); // set title bar string
        setSize(355, 190);       // set window size
        setVisible(true);        // display window

    } // end method createUserInterface

    // calculate and display the student and class average
    private void addJButtonActionPerformed(ActionEvent event) {
        // add a header to the displayJTextArea
        displayJTextArea.setText("Food\tLikes\tDislikes");

        // index of selected food
        int index = foodJComboBox.getSelectedIndex();

        // outer for loop to display 2-dimensional array
        for (int j = 0; j < 4; j++) {
            // add food to output
            displayJTextArea.append("\n" + foodChoices[j] + "\t");

            // increment appropriate counter
            if (likeJRadioButton.isSelected() && index == j) {
                display[j][0]++;
            } else if (dislikeJRadioButton.isSelected() && index == j) {
                display[j][1]++;
            }

            // inner for loop
            // to add contents of array to output
            for (int k = 0; k < 2; k++) {
                displayJTextArea.append(display[j][k] + "\t");
            }

        } // end for

    } // end method addJButtonActionPerformed

} // end class FoodSurvey

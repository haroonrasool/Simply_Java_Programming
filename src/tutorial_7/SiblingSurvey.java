package tutorial_7;

// Exercise 7.16: SiblingSurvey.java
// This application gives the user three options regarding their
// siblings and displays the results in a pop up box.

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SiblingSurvey extends JFrame {
    // JCheckBoxes for user options
    private JCheckBox brotherJCheckBox;
    private JCheckBox sisterJCheckBox;
    private JCheckBox noSiblingsJCheckBox;

    // no-argument constructor
    public SiblingSurvey() {
        createUserInterface();
    }

    // main method
    public static void main(String[] args) {
        SiblingSurvey application = new SiblingSurvey();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // create and position GUI components; register event handlers
    private void createUserInterface() {
        // get content pane for attaching GUI components
        Container contentPane = getContentPane();

        // enable explicit positioning of GUI components
        contentPane.setLayout(null);

        // set up selectSiblingsJLabel
        // JLabel that displays prompt
        JLabel selectSiblingsJLabel = new JLabel();
        selectSiblingsJLabel.setText(
                "Please select the siblings you have:");
        selectSiblingsJLabel.setBounds(16, 16, 204, 23);
        contentPane.add(selectSiblingsJLabel);

        // set up brotherJCheckBox
        brotherJCheckBox = new JCheckBox();
        brotherJCheckBox.setText("Brother(s)");
        brotherJCheckBox.setBounds(16, 56, 88, 21);
        contentPane.add(brotherJCheckBox);

        // set up sisterJCheckBox
        sisterJCheckBox = new JCheckBox();
        sisterJCheckBox.setText("Sister(s)");
        sisterJCheckBox.setBounds(16, 96, 88, 21);
        contentPane.add(sisterJCheckBox);

        // set up noSiblingsJCheckBox
        noSiblingsJCheckBox = new JCheckBox();
        noSiblingsJCheckBox.setText("No Siblings");
        noSiblingsJCheckBox.setBounds(16, 136, 100, 21);
        contentPane.add(noSiblingsJCheckBox);

        // set up submitSurveyJButton
        // JButton for user to submit input
        JButton submitSurveyJButton = new JButton();
        submitSurveyJButton.setText("Submit Survey");
        submitSurveyJButton.setBounds(16, 176, 126, 23);
        contentPane.add(submitSurveyJButton);
        // anonymous inner class
        // event handler called when submitSurveyJButton is clicked
        submitSurveyJButton.addActionListener(

                this::submitSurveyJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set properties of application's window
        setTitle("Sibling Survey"); // set title bar string
        setSize(235, 250);          // set window size
        setVisible(true);           // display window

    } // end method createUserInterface

    // display message based on user selection
    public void submitSurveyJButtonActionPerformed(
            ActionEvent event) {
        // check if user selects brothers or sisters and no siblings
        if (noSiblingsJCheckBox.isSelected() &&
                (brotherJCheckBox.isSelected() ||
                        sisterJCheckBox.isSelected())) {
            JOptionPane.showMessageDialog(null,
                    "Selected combination is not possible.",
                    "Invalid Input", JOptionPane.WARNING_MESSAGE);
        } else if (!noSiblingsJCheckBox.isSelected() &&
                !brotherJCheckBox.isSelected() &&
                !sisterJCheckBox.isSelected()) {
            // if user has not selected a JCheckBox
            JOptionPane.showMessageDialog(null,
                    "Please select at least one option.", "Invalid Input",
                    JOptionPane.WARNING_MESSAGE);
        } else if (brotherJCheckBox.isSelected() &&
                sisterJCheckBox.isSelected()) {
            // if user has brothers and sisters
            JOptionPane.showMessageDialog(null,
                    "You have at least one brother and one sister.",
                    "Siblings", JOptionPane.INFORMATION_MESSAGE);
        } else if (brotherJCheckBox.isSelected()) {
            // if user has brothers
            JOptionPane.showMessageDialog(null,
                    "You have at least one brother.", "Siblings",
                    JOptionPane.INFORMATION_MESSAGE);
        } else if (sisterJCheckBox.isSelected()) {
            // if user has sisters
            JOptionPane.showMessageDialog(null,
                    "You have at least one sister.", "Siblings",
                    JOptionPane.INFORMATION_MESSAGE);
        } else // user has no siblings
        {
            JOptionPane.showMessageDialog(null,
                    "You have no siblings.", "Siblings",
                    JOptionPane.INFORMATION_MESSAGE);
        }

    } // end method submitSurveyJButtonActionPerformed

} // end class SiblingSurvey

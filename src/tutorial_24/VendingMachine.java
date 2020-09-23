package tutorial_24;

// Exercise 24.16: VendingMachine.java
// Creates vending machine using an array of food and beverages.

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;

public class VendingMachine extends JFrame {
    // String array to hold snacks
    String[] snacks = new String[]{"Chocolate Chip Cookie",
            "Bubble Gum", "Plain Pretzel", "Soda", "Salted Pretzel",
            "Oatmeal Cookie", "Diet Soda", "Sugar-free Gum"};
    // JTextField for displaying selection number
    private JTextField displayJTextField;
    private JTextField inputJTextField;

    // no-argument constructor
    public VendingMachine() {
        createUserInterface();
    }

    // main method
    public static void main(String[] args) {
        VendingMachine application = new VendingMachine();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } // end method main

    // create and position GUI components; register event handlers
    private void createUserInterface() {
        // get content pane for attaching GUI components
        Container contentPane = getContentPane();

        // enable explicit positioning of GUI components
        contentPane.setLayout(null);

        // set up windowJPanel
        // JPanel to hold all pictures
        JPanel windowJPanel = new JPanel();
        windowJPanel.setBounds(10, 10, 260, 170);
        windowJPanel.setBorder(new LineBorder(Color.BLACK));
        windowJPanel.setLayout(null);
        contentPane.add(windowJPanel);

        // set up zeroIconJLabel
        JLabel zeroIconJLabel = new JLabel();
        zeroIconJLabel.setIcon(new ImageIcon("src/images/cookie.png"));
        zeroIconJLabel.setBounds(10, 10, 50, 50);
        windowJPanel.add(zeroIconJLabel);

        // set up zeroJLabel
        // JLabels for first snack shown
        JLabel zeroJLabel = new JLabel();
        zeroJLabel.setText("0");
        zeroJLabel.setBounds(10, 60, 50, 20);
        zeroJLabel.setHorizontalAlignment(JLabel.CENTER);
        windowJPanel.add(zeroJLabel);

        // set up oneIconJLabel
        JLabel oneIconJLabel = new JLabel();
        oneIconJLabel.setIcon(new ImageIcon("src/images/gum.png"));
        oneIconJLabel.setBounds(70, 10, 50, 50);
        windowJPanel.add(oneIconJLabel);

        // set up oneJLabel
        // JLabels for second snack shown
        JLabel oneJLabel = new JLabel();
        oneJLabel.setText("1");
        oneJLabel.setBounds(70, 60, 50, 20);
        oneJLabel.setHorizontalAlignment(JLabel.CENTER);
        windowJPanel.add(oneJLabel);

        // set up twoIconJLabel
        JLabel twoIconJLabel = new JLabel();
        twoIconJLabel.setIcon(new ImageIcon("src/images/pretzel.png"));
        twoIconJLabel.setBounds(130, 10, 50, 50);
        windowJPanel.add(twoIconJLabel);

        // set up twoJLabel
        // JLabels for third snack shown
        JLabel twoJLabel = new JLabel();
        twoJLabel.setText("2");
        twoJLabel.setBounds(130, 60, 50, 20);
        twoJLabel.setHorizontalAlignment(JLabel.CENTER);
        windowJPanel.add(twoJLabel);

        // set up threeIconJLabel
        JLabel threeIconJLabel = new JLabel();
        threeIconJLabel.setIcon(new ImageIcon(
                "src/images/soda.png"));
        threeIconJLabel.setBounds(190, 10, 50, 50);
        windowJPanel.add(threeIconJLabel);

        // set up threeJLabel
        // JLabels for fourth snack shown
        JLabel threeJLabel = new JLabel();
        threeJLabel.setText("3");
        threeJLabel.setBounds(190, 60, 50, 20);
        threeJLabel.setHorizontalAlignment(JLabel.CENTER);
        windowJPanel.add(threeJLabel);

        // set up fourIconJLabel
        JLabel fourIconJLabel = new JLabel();
        fourIconJLabel.setIcon(new ImageIcon(
                "src/images/pretzel.png"));
        fourIconJLabel.setBounds(10, 90, 50, 50);
        windowJPanel.add(fourIconJLabel);

        // set up fourJLabel
        // JLabels for fifth snack shown
        JLabel fourJLabel = new JLabel();
        fourJLabel.setText("4");
        fourJLabel.setBounds(10, 140, 50, 20);
        fourJLabel.setHorizontalAlignment(JLabel.CENTER);
        windowJPanel.add(fourJLabel);

        // set up fiveIconJLabel
        JLabel fiveIconJLabel = new JLabel();
        fiveIconJLabel.setIcon(new ImageIcon("src/images/cookie.png"));
        fiveIconJLabel.setBounds(70, 90, 50, 50);
        windowJPanel.add(fiveIconJLabel);

        // set up fiveJLabel
        // JLabels for sixth snack shown
        JLabel fiveJLabel = new JLabel();
        fiveJLabel.setText("5");
        fiveJLabel.setBounds(70, 140, 50, 20);
        fiveJLabel.setHorizontalAlignment(JLabel.CENTER);
        windowJPanel.add(fiveJLabel);

        // set up sixIconJLabel
        JLabel sixIconJLabel = new JLabel();
        sixIconJLabel.setIcon(new ImageIcon("src/images/soda.png"));
        sixIconJLabel.setBounds(130, 90, 50, 50);
        windowJPanel.add(sixIconJLabel);

        // set up sixJLabel
        // JLabels for seventh snack shown
        JLabel sixJLabel = new JLabel();
        sixJLabel.setText("6");
        sixJLabel.setBounds(130, 140, 50, 20);
        sixJLabel.setHorizontalAlignment(JLabel.CENTER);
        windowJPanel.add(sixJLabel);

        // set up sevenIconJLabel
        JLabel sevenIconJLabel = new JLabel();
        sevenIconJLabel.setIcon(new ImageIcon("src/images/gum.png"));
        sevenIconJLabel.setBounds(190, 90, 50, 50);
        windowJPanel.add(sevenIconJLabel);

        // set up sevenJLabel
        // JLabels for eight snack shown
        JLabel sevenJLabel = new JLabel();
        sevenJLabel.setText("7");
        sevenJLabel.setBounds(190, 140, 50, 20);
        sevenJLabel.setHorizontalAlignment(JLabel.CENTER);
        windowJPanel.add(sevenJLabel);

        // set up dispenseJButton
        // JButton to dispense user's snack
        JButton dispenseJButton = new JButton();
        dispenseJButton.setBounds(280, 80, 135, 30);
        dispenseJButton.setText("Dispense Snack");
        contentPane.add(dispenseJButton);
        // anonymous inner class
        // event handler called when dispenseJButton is pressed
        dispenseJButton.addActionListener(

                this::dispenseJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set up inputJLabel
        // JLabel and JTextField for user input
        JLabel inputJLabel = new JLabel();
        inputJLabel.setBounds(280, 10, 135, 20);
        inputJLabel.setText("Please make selection:");
        contentPane.add(inputJLabel);

        // set up inputJTextField
        inputJTextField = new JTextField();
        inputJTextField.setBounds(280, 35, 135, 25);
        inputJTextField.setHorizontalAlignment(JTextField.CENTER);
        contentPane.add(inputJTextField);

        // set up displayJTextField
        displayJTextField = new JTextField();
        displayJTextField.setBounds(10, 190, 260, 50);
        displayJTextField.setEditable(false);
        displayJTextField.setHorizontalAlignment(JTextField.CENTER);
        contentPane.add(displayJTextField);

        // set properties of application's window
        setTitle("Vending Machine"); // set title bar String
        setSize(440, 290);           // set window size
        setVisible(true);            // display window

    } // end method createUserInterface

    // get user selection and dispense proper snack
    private void dispenseJButtonActionPerformed(ActionEvent event) {
        // try to get user input
        try {
            int selection = Integer.parseInt(
                    inputJTextField.getText());

            displayJTextField.setText(snacks[selection] +
                    " has been dispensed");
        } catch (NumberFormatException exception) {
            JOptionPane.showMessageDialog(this,
                    "Please enter an integer value", "Number Format Error",
                    JOptionPane.ERROR_MESSAGE);
        } catch (ArrayIndexOutOfBoundsException exception) {
            JOptionPane.showMessageDialog(this,
                    "Please enter a value between 0 and 7",
                    "Array Index Out Of Bounds Error",
                    JOptionPane.ERROR_MESSAGE);
        } // end of catch block

        // clear inputJTextField
        inputJTextField.setText("");

    } // end method dispenseJButtonActionPerformed

} // end class VendingMachine

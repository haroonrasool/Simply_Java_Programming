package tutorial_14;

// Exercise 14.13: VendingMachine.java
// Creates vending machine that will display price of entered item.

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;

public class VendingMachine extends JFrame {
    // JTextField for displaying snack price
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

        // set up oneIconJLabel
        JLabel oneIconJLabel = new JLabel();
        oneIconJLabel.setBounds(10, 10, 50, 50);
        oneIconJLabel.setIcon(new ImageIcon("src/images/cookie.png"));
        windowJPanel.add(oneIconJLabel);

        // set up oneJLabel
        // JLabels for first snack shown
        JLabel oneJLabel = new JLabel();
        oneJLabel.setBounds(10, 60, 50, 20);
        oneJLabel.setText("1");
        oneJLabel.setHorizontalAlignment(JLabel.CENTER);
        windowJPanel.add(oneJLabel);

        // set up twoIconJLabel
        JLabel twoIconJLabel = new JLabel();
        twoIconJLabel.setBounds(70, 10, 50, 50);
        twoIconJLabel.setIcon(new ImageIcon("src/images/gum.png"));
        windowJPanel.add(twoIconJLabel);

        // set up twoJLabel
        // JLabels for second snack shown
        JLabel twoJLabel = new JLabel();
        twoJLabel.setBounds(70, 60, 50, 20);
        twoJLabel.setText("2");
        twoJLabel.setHorizontalAlignment(JLabel.CENTER);
        windowJPanel.add(twoJLabel);

        // set up threeIconJLabel
        JLabel threeIconJLabel = new JLabel();
        threeIconJLabel.setBounds(130, 10, 50, 50);
        threeIconJLabel.setIcon(new ImageIcon("src/images/pretzel.png"));
        windowJPanel.add(threeIconJLabel);

        // set up threeJLabel
        // JLabels for third snack shown
        JLabel threeJLabel = new JLabel();
        threeJLabel.setBounds(130, 60, 50, 20);
        threeJLabel.setText("3");
        threeJLabel.setHorizontalAlignment(JLabel.CENTER);
        windowJPanel.add(threeJLabel);

        // set up fourIconJLabel
        JLabel fourIconJLabel = new JLabel();
        fourIconJLabel.setBounds(190, 10, 50, 50);
        fourIconJLabel.setIcon(new ImageIcon("src/images/soda.png"));
        windowJPanel.add(fourIconJLabel);

        // set up fourJLabel
        // JLabels for fourth snack shown
        JLabel fourJLabel = new JLabel();
        fourJLabel.setBounds(190, 60, 50, 20);
        fourJLabel.setText("4");
        fourJLabel.setHorizontalAlignment(JLabel.CENTER);
        windowJPanel.add(fourJLabel);

        // set up fiveIconJLabel
        JLabel fiveIconJLabel = new JLabel();
        fiveIconJLabel.setBounds(10, 90, 50, 50);
        fiveIconJLabel.setIcon(new ImageIcon("src/images/pretzel.png"));
        windowJPanel.add(fiveIconJLabel);

        // set up fiveJLabel
        // JLabels for fifth snack shown
        JLabel fiveJLabel = new JLabel();
        fiveJLabel.setBounds(10, 140, 50, 20);
        fiveJLabel.setText("5");
        fiveJLabel.setHorizontalAlignment(JLabel.CENTER);
        windowJPanel.add(fiveJLabel);

        // set up sixIconJLabel
        JLabel sixIconJLabel = new JLabel();
        sixIconJLabel.setBounds(70, 90, 50, 50);
        sixIconJLabel.setIcon(new ImageIcon("src/images/cookie.png"));
        windowJPanel.add(sixIconJLabel);

        // set up sixJLabel
        // JLabels for sixth snack shown
        JLabel sixJLabel = new JLabel();
        sixJLabel.setBounds(70, 140, 50, 20);
        sixJLabel.setText("6");
        sixJLabel.setHorizontalAlignment(JLabel.CENTER);
        windowJPanel.add(sixJLabel);

        // set up sevenIconJLabel
        JLabel sevenIconJLabel = new JLabel();
        sevenIconJLabel.setBounds(130, 90, 50, 50);
        sevenIconJLabel.setIcon(new ImageIcon("src/images/soda.png"));
        windowJPanel.add(sevenIconJLabel);

        // set up sevenJLabel
        // JLabels for seventh snack shown
        JLabel sevenJLabel = new JLabel();
        sevenJLabel.setBounds(130, 140, 50, 20);
        sevenJLabel.setText("7");
        sevenJLabel.setHorizontalAlignment(JLabel.CENTER);
        windowJPanel.add(sevenJLabel);

        // set up eightIconJLabel
        JLabel eightIconJLabel = new JLabel();
        eightIconJLabel.setBounds(190, 90, 50, 50);
        eightIconJLabel.setIcon(new ImageIcon("src/images/gum.png"));
        windowJPanel.add(eightIconJLabel);

        // set up eightJLabel
        // JLabels for eighth snack shown
        JLabel eightJLabel = new JLabel();
        eightJLabel.setBounds(190, 140, 50, 20);
        eightJLabel.setText("8");
        eightJLabel.setHorizontalAlignment(JLabel.CENTER);
        windowJPanel.add(eightJLabel);

        // set up enterJButton
        // JButton to enter user input
        JButton enterJButton = new JButton();
        enterJButton.setBounds(280, 80, 135, 30);
        enterJButton.setText("Enter");
        contentPane.add(enterJButton);
        // anonymous inner class
        // event handler called when enterJButton is clicked
        enterJButton.addActionListener(

                this::enterJButtonActionPerformed // end anonymous inner class

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
        setTitle("Vending Machine"); // set title bar string
        setSize(435, 285);           // set window size
        setVisible(true);            // display window

    } // end method createUserInterface

    // get user input and display price of specified snack
    private void enterJButtonActionPerformed(ActionEvent event) {
        // store the user input
        int selection = Integer.parseInt(inputJTextField.getText());

        // declare instance variables to store the prices
        String snackPrice1 = "$1.25";
        String snackPrice2 = "$0.50";
        String snackPrice3 = "$1.25";
        String snackPrice4 = "$1.00";
        String snackPrice5 = "$1.25";
        String snackPrice6 = "$1.25";
        String snackPrice7 = "$1.00";
        String snackPrice8 = "$0.50";

        // switch statement to display Price in displayJTextField
        switch (selection) {
            case 1: // user selected first snack
                displayJTextField.setText("Price: " + snackPrice1);
                break;
            case 2: // user selected second snack
                displayJTextField.setText("Price: " + snackPrice2);
                break;
            case 3: // user selected third snack
                displayJTextField.setText("Price: " + snackPrice3);
                break;
            case 4: // user selected fourth snack
                displayJTextField.setText("Price: " + snackPrice4);
                break;
            case 5: // user selected fifth snack
                displayJTextField.setText("Price: " + snackPrice5);
                break;
            case 6: // user selected sixth snack
                displayJTextField.setText("Price: " + snackPrice6);
                break;
            case 7: // user selected seventh snack
                displayJTextField.setText("Price: " + snackPrice7);
                break;
            case 8: // user selected eighth snack
                displayJTextField.setText("Price: " + snackPrice8);
                break;
            default: // user selected a value other than 1 to 8.
        } // end of switch case

    } // end method enterJButtonActionPerformed

} // end class VendingMachine

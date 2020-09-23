package tutorial_18.DVDInventory;

// Exercise 18.17: DVDInventory.java
// An application that inventories DVDs.

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;

public class DVDInventory extends JFrame {
    private JTextField movieJTextField;
    private JTextField minutes1JTextField;
    private JButton informationJButton;

    // JTextField for DVD creation message
    private JTextField bottomJTextField;
    private JTextField description1JTextField;
    private JTextField minutes2JTextField;
    private JTextField description2JTextField;
    private JTextField minutes3JTextField;
    private JTextField description3JTextField;
    private JTextField minutes4JTextField;

    // DVDInfo for storing DVD information
    private DVDInfo dvd;

    // no-argument constructor
    public DVDInventory() {
        createUserInterface();
    }

    // main method
    public static void main(String[] args) {
        DVDInventory application = new DVDInventory();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } // end method main

    // create and position GUI components; register event handlers
    private void createUserInterface() {
        // get content pane for attaching GUI components
        Container contentPane = getContentPane();

        // enable explicit positioning of GUI components
        contentPane.setLayout(null);

        // set up informationJPanel
        // JPanel for containing movie information
        JPanel informationJPanel = new JPanel();
        informationJPanel.setBounds(8, 8, 240, 112);
        informationJPanel.setBorder(new TitledBorder(
                "DVD Information"));
        informationJPanel.setLayout(null);
        contentPane.add(informationJPanel);

        // set up movieJLabel
        // JLabel and JTextField for movie title
        JLabel movieJLabel = new JLabel();
        movieJLabel.setBounds(8, 32, 72, 24);
        movieJLabel.setText("Movie title:");
        informationJPanel.add(movieJLabel);

        // set up movieJTextField
        movieJTextField = new JTextField();
        movieJTextField.setBounds(80, 32, 140, 24);
        informationJPanel.add(movieJTextField);

        // set up minutes1JLabel
        // JLabel and JTextField for minutes in movie
        JLabel minutes1JLabel = new JLabel();
        minutes1JLabel.setBounds(8, 66, 56, 24);
        minutes1JLabel.setText("Minutes:");
        informationJPanel.add(minutes1JLabel);

        // set up minutes1JTextField
        minutes1JTextField = new JTextField();
        minutes1JTextField.setBounds(168, 64, 50, 24);
        informationJPanel.add(minutes1JTextField);

        // set up createJButton
        // JButton to create and display a DVDObject
        JButton createJButton = new JButton();
        createJButton.setBounds(78, 136, 100, 24);
        createJButton.setText("Create");
        contentPane.add(createJButton);
        // anonymous inner class
        // event handler called when createJButton is pressed
        createJButton.addActionListener(

                this::createJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set up informationJButton
        informationJButton = new JButton();
        informationJButton.setBounds(78, 168, 100, 24);
        informationJButton.setText("Information");
        informationJButton.setEnabled(false);
        contentPane.add(informationJButton);
        // anonymous inner class
        // event handler called when
        // informationJButton is pressed
        informationJButton.addActionListener(

                this::informationJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set up bottomJTextField
        bottomJTextField = new JTextField();
        bottomJTextField.setBounds(8, 206, 240, 24);
        bottomJTextField.setHorizontalAlignment(JTextField.CENTER);
        bottomJTextField.setEditable(false);
        contentPane.add(bottomJTextField);

        // set up bonusJPanel
        // JPanel for containing bonus material information
        JPanel bonusJPanel = new JPanel();
        bonusJPanel.setBounds(264, 8, 248, 224);
        bonusJPanel.setBorder(new TitledBorder("Bonus Materials"));
        bonusJPanel.setLayout(null);
        contentPane.add(bonusJPanel);

        // set up description1JLabel
        // JLabels and JTextFields for bonus material
        // descriptions and minutes in bonus material
        JLabel description1JLabel = new JLabel();
        description1JLabel.setBounds(8, 24, 74, 24);
        description1JLabel.setText("Description:");
        bonusJPanel.add(description1JLabel);

        // set up description1JTextField
        description1JTextField = new JTextField();
        description1JTextField.setBounds(88, 24, 140, 24);
        bonusJPanel.add(description1JTextField);

        // set up minutes2JLabel
        JLabel minutes2JLabel = new JLabel();
        minutes2JLabel.setBounds(8, 56, 56, 24);
        minutes2JLabel.setText("Minutes:");
        bonusJPanel.add(minutes2JLabel);

        // set up minutes2JTextField
        minutes2JTextField = new JTextField();
        minutes2JTextField.setBounds(178, 56, 50, 24);
        bonusJPanel.add(minutes2JTextField);

        // set up description2JLabel
        JLabel description2JLabel = new JLabel();
        description2JLabel.setBounds(8, 88, 74, 24);
        description2JLabel.setText("Description:");
        bonusJPanel.add(description2JLabel);

        // set up description2JTextField
        description2JTextField = new JTextField();
        description2JTextField.setBounds(88, 88, 140, 24);
        bonusJPanel.add(description2JTextField);

        // set up minutes3JLabel
        JLabel minutes3JLabel = new JLabel();
        minutes3JLabel.setBounds(8, 120, 56, 24);
        minutes3JLabel.setText("Minutes:");
        bonusJPanel.add(minutes3JLabel);

        // set up minutes3JTextField
        minutes3JTextField = new JTextField();
        minutes3JTextField.setBounds(178, 120, 50, 24);
        bonusJPanel.add(minutes3JTextField);

        // set up description3JLabel
        JLabel description3JLabel = new JLabel();
        description3JLabel.setBounds(8, 152, 74, 24);
        description3JLabel.setText("Description:");
        bonusJPanel.add(description3JLabel);

        // set up description3JTextField
        description3JTextField = new JTextField();
        description3JTextField.setBounds(88, 152, 140, 24);
        bonusJPanel.add(description3JTextField);

        // set up minutes4JLabel
        JLabel minutes4JLabel = new JLabel();
        minutes4JLabel.setBounds(8, 184, 56, 24);
        minutes4JLabel.setText("Minutes:");
        bonusJPanel.add(minutes4JLabel);

        // set up minutes4JTextField
        minutes4JTextField = new JTextField();
        minutes4JTextField.setBounds(178, 184, 50, 24);
        bonusJPanel.add(minutes4JTextField);

        // set properties of application's window
        setTitle("DVD Inventory"); // set title bar string
        setSize(535, 280);      // set window size
        setVisible(true);       // display window

    } // end method createUserInterface

    // get user input and store in a new DVDObject
    private void createJButtonActionPerformed(ActionEvent event) {
        // adding bonus material information by creating
        // an array of BonusInfo objects to store bonus materials.
        BonusInfo[] bonusInfo = new BonusInfo[3];

        // retrieving movie name from movieJTextField.
        String movieTitle = movieJTextField.getText();

        // retrieving the movie length from minutes1JTextField
        int movieLength = Integer.parseInt(minutes1JTextField.getText());

        // bonus material description
        String bonus1 = description1JTextField.getText();
        String bonus2 = description2JTextField.getText();
        String bonus3 = description3JTextField.getText();

        // store bonus minutes from JTextFields
        int bonusLength1 = Integer.parseInt(
                minutes2JTextField.getText());
        int bonusLength2 = Integer.parseInt(
                minutes3JTextField.getText());
        int bonusLength3 = Integer.parseInt(
                minutes4JTextField.getText());

        // add bonus material name and time to the array
        bonusInfo[0] = new BonusInfo(bonus1, bonusLength1);
        bonusInfo[1] = new BonusInfo(bonus2, bonusLength2);
        bonusInfo[2] = new BonusInfo(bonus3, bonusLength3);

        // call constructor for new DVDObject
        dvd = new DVDInfo(movieTitle, bonusInfo, movieLength);

        // let the user know about the progress
        bottomJTextField.setText("Your DVD was created successfully!");

        // enable informationJButton
        informationJButton.setEnabled(true);

    } // end method createJButtonActionPerformed

    // display last created DVD in a JOptionPane
    private void informationJButtonActionPerformed(ActionEvent event) {
        // clear successful dvd creation message
        bottomJTextField.setText("");

        // String for storing movie information to be displayed
        String information = dvd.getMovieTitle() + ": " +
                dvd.getMovieLength() + " minutes(s)\nBonus Materials:\n" +
                dvd.getBonusMaterial();

        // display output in a JOptionPane
        JOptionPane.showMessageDialog(this, information,
                "DVD Description", JOptionPane.INFORMATION_MESSAGE);

    } // end method informationJButtonActionPerformed

} // end class DVDInventory

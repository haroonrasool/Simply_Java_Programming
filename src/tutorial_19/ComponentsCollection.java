package tutorial_19;

// Exercise 19.13 ComponentsCollection.java
// This application lists all components used in the application.

import java.awt.event.*;
import java.awt.*;
import java.util.*;
import javax.swing.*;

public class ComponentsCollection extends JFrame {
    // instance variables
    private final String[] bookList = {"Simply Series",
            "How To Program Series", "Developer Series"};

    private JList<Object> listComponentsJList;
    private final ArrayList<Object> componentsArrayList = new ArrayList<>();
    private final ArrayList<Object> outputArrayList = new ArrayList<>();

    // no-argument constructor
    public ComponentsCollection() {
        createUserInterface();
    }

    // main method
    public static void main(String[] args) {
        ComponentsCollection application = new ComponentsCollection();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } // end method main

    // create and position GUI components; register event handlers
    private void createUserInterface() {
        // get content pane for attaching GUI components
        Container contentPane = getContentPane();

        // enable explicit positioning of GUI components
        contentPane.setLayout(null);

        // set up nameJLabel
        // JLabel and JTextField for reading name from user
        JLabel nameJLabel = new JLabel();
        nameJLabel.setBounds(16, 15, 48, 21);
        nameJLabel.setText("Name:");
        nameJLabel.setName("nameJLabel");
        nameJLabel.setOpaque(true);
        contentPane.add(nameJLabel);

        // set up nameJTextField
        JTextField nameJTextField = new JTextField();
        nameJTextField.setBounds(64, 16, 172, 20);
        nameJTextField.setText("Please enter your name here");
        nameJTextField.setName("nameJTextField");
        contentPane.add(nameJTextField);
        // anonymous inner class
        // event handler called when submitJButton is pressed
        nameJTextField.addActionListener(
                event -> {
                    // nameJTextFieldActionPerformed(event);
                } // end anonymous inner class
        );

        // set up bookJLabel
        // JLabel and JComboBox for displaying series name
        JLabel bookJLabel = new JLabel();
        bookJLabel.setBounds(16, 48, 48, 21);
        bookJLabel.setText("Book:");
        bookJLabel.setName("bookJLabel");
        bookJLabel.setOpaque(true);
        contentPane.add(bookJLabel);

        // set up bookJComboBox
        JComboBox<String> bookJComboBox = new JComboBox<>(bookList);
        bookJComboBox.setBounds(64, 48, 172, 21);
        bookJComboBox.setName("bookJComboBox");
        contentPane.add(bookJComboBox);

        // set up pictureJLabel
        // two JLabels for displaying book cover
        JLabel pictureJLabel = new JLabel();
        pictureJLabel.setBounds(16, 80, 48, 21);
        pictureJLabel.setText("Picture:");
        pictureJLabel.setName("pictureJLabel");
        pictureJLabel.setOpaque(true);
        contentPane.add(pictureJLabel);

        // set up bookPictureJLabel
        JLabel bookPictureJLabel = new JLabel();
        bookPictureJLabel.setBounds(64, 80, 91, 119);
        bookPictureJLabel.setIcon(new ImageIcon(
                "vbnetFEP1_thumb.jpg"));
        bookPictureJLabel.setName("bookPictureJLabel");
        contentPane.add(bookPictureJLabel);

        // set up listComponentsJLabel
        // JLabel and JList for displaying list of components
        JLabel listComponentsJLabel = new JLabel();
        listComponentsJLabel.setBounds(252, 16, 112, 21);
        listComponentsJLabel.setText("List of components:");
        listComponentsJLabel.setName("listComponentsJLabel");
        listComponentsJLabel.setOpaque(true);
        contentPane.add(listComponentsJLabel);

        // set up listComponentsJList
        listComponentsJList = new JList<>();
        listComponentsJList.setBounds(252, 40, 130, 168);
        listComponentsJList.setName("listComponentsJList");
        contentPane.add(listComponentsJList);

        // set up submitJButton
        // JButton to allow user interaction
        JButton submitJButton = new JButton();
        submitJButton.setBounds(296, 224, 76, 23);
        submitJButton.setText("Submit");
        submitJButton.setName("submitJButton");
        contentPane.add(submitJButton);
        // anonymous inner class
        // event handler called when submitJButton is pressed
        submitJButton.addActionListener(

                this::submitJButtonActionPerformed // end anonymous inner class

        ); // end addActionListener

        // put all components in an array
        Component[] components = getContentPane().getComponents();

        // add all components to componentsArrayList
        componentsArrayList.addAll(Arrays.asList(components).subList(0, 9));

        // set properties of application's window
        setTitle("Components Collection"); // set title bar string
        setSize(406, 288);                 // set window size
        setVisible(true);                  // display window

    } // end method createUserInterface

    // method to display a list of components
    private void submitJButtonActionPerformed(ActionEvent event) {
        // clear ArrayList
        outputArrayList.clear();

        // set iterator

        // for every component in application
        for (Object object : componentsArrayList) {
            // set reference variable
            Component currentComponent = (Component) object;

            // set background color to magenta
            currentComponent.setBackground(Color.MAGENTA);

            // and add name to componentsArrayList
            outputArrayList.add(currentComponent.getName());

        } // end while loop

        // display componentsArrayList in JList
        listComponentsJList.setListData(outputArrayList.toArray());

    } // end submitJButtonActionPerformed

} // end class ComponentsCollection

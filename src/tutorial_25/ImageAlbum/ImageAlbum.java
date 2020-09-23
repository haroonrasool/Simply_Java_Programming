package tutorial_25.ImageAlbum;

// Exercise 25.12: ImageAlbum.java
// This application uses file processing to implement an image album
// with image having its own text description.

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class ImageAlbum extends JFrame {
    // JLabel to show current book
    private JLabel mainJLabel;

    // JTextArea and JScrollPane to display information on a book
    private JTextArea descriptionJTextArea;

    // JLabel and JButton to allow user to got to the previous book
    private JLabel previousJLabel;
    private JButton previousJButton;

    // JLabel and JButton to allow user to got to the next book
    private JLabel nextJLabel;
    private JButton nextJButton;

    // BufferedReader to read data from a file
    private BufferedReader input;

    // represents current image's index
    private int current = 0;

    private final String[] largeImage = new String[6];
    private final String[] smallImage = new String[6];
    private final String[] descriptions = new String[6];

    // no-argument constructor
    public ImageAlbum() {
        createUserInterface();
    }

    // create and position GUI components; register event handlers
    private void createUserInterface() {
        // get content pane for attaching GUI components
        Container contentPane = getContentPane();

        // enable explicit positioning of GUI components
        contentPane.setLayout(null);

        // set up mainJLabel
        mainJLabel = new JLabel();
        mainJLabel.setBounds(16, 16, 273, 357);
        mainJLabel.setEnabled(true);
        contentPane.add(mainJLabel);

        // set up descriptionJTextArea
        descriptionJTextArea = new JTextArea();
        JScrollPane descriptionJScrollPane = new JScrollPane(
                descriptionJTextArea);
        descriptionJScrollPane.setBounds(16, 392, 272, 48);
        descriptionJScrollPane.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        descriptionJTextArea.setLineWrap(true);
        descriptionJTextArea.setWrapStyleWord(true);
        descriptionJTextArea.setEditable(false);
        contentPane.add(descriptionJScrollPane);

        // set up previousJButton
        previousJButton = new JButton();
        previousJButton.setBounds(307, 144, 123, 23);
        previousJButton.setText("Previous Image");
        contentPane.add(previousJButton);
        // anonymous inner class
        // event handler called when previousJButton is clicked
        previousJButton.addActionListener(

                this::previousJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set up previousJLabel
        previousJLabel = new JLabel();
        previousJLabel.setBounds(323, 16, 91, 119);
        contentPane.add(previousJLabel);

        // set up nextJButton
        nextJButton = new JButton();
        nextJButton.setBounds(307, 352, 123, 23);
        nextJButton.setText("Next Image");
        contentPane.add(nextJButton);
        // anonymous inner class
        // event handler called when nextJButton is clicked
        nextJButton.addActionListener(

                this::nextJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set up nextJLabel
        nextJLabel = new JLabel();
        nextJLabel.setBounds(323, 224, 91, 119);
        contentPane.add(nextJLabel);

        // set properties of application's window
        setTitle("Image Album"); // set title bar string
        setSize(447, 480);       // set window size
        setVisible(true);        // display window

        retrieveData();

        displayImage(); // display first image at start

    } // end method createUserInterface

    // extract descriptions from file and images from the directory
    private void retrieveData() {
        // retrieve data from file
        try {
            // initialize FileReader to read lines from file
            File booksFile = new File("src/tutorial_25/ImageAlbum/books.txt");
            FileReader inputFile = new FileReader(booksFile);
            input = new BufferedReader(inputFile);

            // read first line before entering loop
            String imageName = input.readLine();

            int counter = 0;

            // loop through lines in file
            while (imageName != null) {
                largeImage[counter] = ("src/tutorial_25/ImageAlbum/images/large/" +
                        imageName + "_large.jpg");
                smallImage[counter] = ("src/tutorial_25/ImageAlbum/images/small/" +
                        imageName + "_thumb.jpg");
                descriptions[counter] = input.readLine();

                // read next line in file
                imageName = input.readLine();

                counter++;

            } // end while

        } // end try
        catch (IOException exception) {
            JOptionPane.showMessageDialog(this, "File error.",
                    "FILE ERROR", JOptionPane.ERROR_MESSAGE);
        } finally {
            // close input file
            try {
                input.close();
            } catch (IOException exception) {
                JOptionPane.showMessageDialog(this, "File error.",
                        "FILE ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }

    } // end method retrieveData

    // display images in JLabels
    private void displayImage() {
        // set main image
        mainJLabel.setIcon(new ImageIcon(largeImage[current]));

        // if index is 0 (first image), do not show previous image
        if (current == 0) {
            // disable previous image
            previousJLabel.setVisible(false);

            // preview next image
            nextJLabel.setIcon(new ImageIcon(
                    smallImage[current + 1]));

            // disable previousJButton
            previousJButton.setEnabled(false);
        }

        // if index corresponds to last item in array,
        // do not show next image
        else if (current == (largeImage.length - 1)) {
            previousJLabel.setIcon(new ImageIcon(
                    smallImage[current - 1]));

            nextJLabel.setVisible(false);  // disable next image
            nextJButton.setEnabled(false); // disable nextJButton
        }

        // show previous, current and next image
        else {
            previousJLabel.setVisible(true);
            previousJLabel.setIcon(new ImageIcon(
                    smallImage[current - 1]));

            nextJLabel.setVisible(true);
            nextJLabel.setIcon(new ImageIcon(
                    smallImage[current + 1]));

            // enable JButtons
            previousJButton.setEnabled(true);
            nextJButton.setEnabled(true);
        }

        // set description
        descriptionJTextArea.setText(descriptions[current]);

    } // end method displayImage

    // display previous image
    private void previousJButtonActionPerformed(ActionEvent event) {
        current--;
        displayImage(); // display new images

    } // end method previousJButtonActionPerformed

    // display next image
    private void nextJButtonActionPerformed(ActionEvent event) {
        current++;
        displayImage(); // display new images

    } // end method nextJButtonActionPerformed

    // main method
    public static void main(String[] args) {
        ImageAlbum application = new ImageAlbum();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    } // end method main

} // end class ImageAlbum

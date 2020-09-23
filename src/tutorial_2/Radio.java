package tutorial_2;

// Exercise 2.16: Radio.java
// Creates the radio GUI.

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class Radio extends JFrame {
    // no-argument constructor
    public Radio() {
        createUserInterface();
    }

    // main method
    public static void main(String[] args) {
        Radio application = new Radio();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } // end method main

    // create and position GUI components
    private void createUserInterface() {
        // get contentPane and set layout to null
        Container contentPane = getContentPane();
        contentPane.setBackground(Color.CYAN); // ORANGE to CYAN
        contentPane.setLayout(null);

        // set up presetJPanel
        JPanel presetJPanel = new JPanel();
        presetJPanel.setLayout(null);
        presetJPanel.setBorder(new TitledBorder(
                "Pre-set Stations"));
        presetJPanel.setBounds(10, 10, 355, 75);
        presetJPanel.setBackground(Color.LIGHT_GRAY); // PINK to LIGHT_GRAY
        contentPane.add(presetJPanel);

        // set up oneJButton
        JButton oneJButton = new JButton();
        oneJButton.setBounds(16, 22, 42, 42);
        oneJButton.setText("1");
        oneJButton.setBackground(Color.CYAN);
        presetJPanel.add(oneJButton);

        // set up twoJButton
        JButton twoJButton = new JButton();
        twoJButton.setBounds(72, 22, 42, 42);
        twoJButton.setText("2");
        twoJButton.setBackground(Color.CYAN);
        presetJPanel.add(twoJButton);

        // set up threeJButton
        JButton threeJButton = new JButton();
        threeJButton.setBounds(128, 22, 42, 42);
        threeJButton.setText("3");
        threeJButton.setBackground(Color.CYAN);
        presetJPanel.add(threeJButton);

        // set up fourJButton
        JButton fourJButton = new JButton();
        fourJButton.setBounds(184, 22, 42, 42);
        fourJButton.setText("4");
        fourJButton.setBackground(Color.CYAN);
        presetJPanel.add(fourJButton);

        // set up fiveJButton
        JButton fiveJButton = new JButton();
        fiveJButton.setBounds(240, 22, 42, 42);
        fiveJButton.setText("5");
        fiveJButton.setBackground(Color.CYAN);
        presetJPanel.add(fiveJButton);

        // set up sixJButton
        JButton sixJButton = new JButton();
        sixJButton.setBounds(296, 22, 42, 42);
        sixJButton.setText("6");
        sixJButton.setBackground(Color.CYAN);
        presetJPanel.add(sixJButton);

        // set up volumeControlJPanel
        JPanel volumeControlJPanel = new JPanel();
        volumeControlJPanel.setLayout(null);
        volumeControlJPanel.setBorder(new TitledBorder(
                "Volume Control"));
        volumeControlJPanel.setBounds(10, 95, 250, 90);
        volumeControlJPanel.setBackground(Color.LIGHT_GRAY);
        contentPane.add(volumeControlJPanel);

        // set up muteJCheckBox
        JCheckBox muteJCheckBox = new JCheckBox();
        muteJCheckBox.setBounds(16, 24, 60, 42);
        muteJCheckBox.setText("Mute");
        muteJCheckBox.setBackground(Color.LIGHT_GRAY);
        volumeControlJPanel.add(muteJCheckBox);

        // set up volumeJSlider
        JSlider volumeJSlider = new JSlider();
        volumeJSlider.setBounds(86, 24, 150, 50);
        volumeJSlider.setPaintTicks(true);
        volumeJSlider.setMajorTickSpacing(10);
        volumeJSlider.setBackground(Color.LIGHT_GRAY);
        volumeControlJPanel.add(volumeJSlider);

        // set up speakersJPanel
        JPanel speakersJPanel = new JPanel();
        speakersJPanel.setLayout(null);
        speakersJPanel.setBorder(new TitledBorder("Speakers"));
        speakersJPanel.setBounds(375, 10, 182, 75);
        speakersJPanel.setBackground(Color.LIGHT_GRAY);
        contentPane.add(speakersJPanel);

        // set up frontJCheckBox
        JCheckBox frontJCheckBox = new JCheckBox();
        frontJCheckBox.setBounds(16, 28, 70, 30);
        frontJCheckBox.setText("Front");
        frontJCheckBox.setBackground(Color.CYAN);
        speakersJPanel.add(frontJCheckBox);

        // set up rearJCheckBox
        JCheckBox rearJCheckBox = new JCheckBox();
        rearJCheckBox.setBounds(96, 28, 70, 30);
        rearJCheckBox.setText("Rear");
        rearJCheckBox.setBackground(Color.CYAN);
        speakersJPanel.add(rearJCheckBox);

        // set up tuningJPanel
        JPanel tuningJPanel = new JPanel();
        tuningJPanel.setLayout(null);
        tuningJPanel.setBorder(new TitledBorder("Tuning"));
        tuningJPanel.setBounds(270, 95, 166, 90);
        tuningJPanel.setBackground(Color.LIGHT_GRAY);
        contentPane.add(tuningJPanel);

        // set up stationJTextField
        JTextField stationJTextField = new JTextField();
        stationJTextField.setBounds(16, 20, 50, 55);
        stationJTextField.setText("92.9");
        stationJTextField.setEditable(false);
        stationJTextField.setHorizontalAlignment(JLabel.CENTER);
        stationJTextField.setBackground(Color.CYAN);
        tuningJPanel.add(stationJTextField);

        // set up amJRadioButton
        JRadioButton amJRadioButton = new JRadioButton();
        amJRadioButton.setBounds(80, 20, 70, 25);
        amJRadioButton.setText("AM");
        amJRadioButton.setBackground(Color.CYAN);
        tuningJPanel.add(amJRadioButton);

        // set up fmJRadioButton
        JRadioButton fmJRadioButton = new JRadioButton();
        fmJRadioButton.setBounds(80, 50, 70, 25);
        fmJRadioButton.setText("FM");
        fmJRadioButton.setBackground(Color.CYAN);
        tuningJPanel.add(fmJRadioButton);

        // set up powerJButton
        JButton powerJButton = new JButton();
        powerJButton.setBounds(446, 95, 111, 90);
        powerJButton.setText("Power On/Off");
        powerJButton.setBackground(Color.LIGHT_GRAY);
        contentPane.add(powerJButton);

        // set properties of application's window
        setTitle("Radio"); // set title bar text
        setSize(580, 230); // set window size
        setVisible(true);  // display window

    } // end method createUserInterface

} // end class Radio

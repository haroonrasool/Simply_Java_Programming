package tutorial_2;

// Tutorial 18: MicrowaveOven.java
// Mimics the behaviour of a microwave oven.

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class MicrowaveOvenRunning extends JFrame {
    // JPanel for microwave window
    private JPanel windowJPanel;

    // JTextField for cooking time
    private JTextField displayJTextField;

    // Timer to count down seconds
    private Timer clockTimer;

    // String for storing digits entered by user
    private String timeToDisplay = "";

    // Time instance for storing the current time
    private final CookingTime microwaveTime = new CookingTime(0, 0);

    // DecimalFormat to format time output
    private final DecimalFormat timeFormat = new DecimalFormat("00");

    // no-argument constructor
    public MicrowaveOvenRunning() {
        createUserInterface();
    }

    // main method
    public static void main(String[] args) {
        MicrowaveOvenRunning application = new MicrowaveOvenRunning();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } // end method main

    // create and position GUI components; register event handlers
    private void createUserInterface() {
        // get content pane for attaching GUI components
        Container contentPane = getContentPane();

        // enable explicit positioning of GUI components
        contentPane.setLayout(null);

        // set up windowJPanel
        windowJPanel = new JPanel();
        windowJPanel.setBounds(16, 16, 328, 205);
        windowJPanel.setBorder(new LineBorder(Color.BLACK));
        contentPane.add(windowJPanel);

        // set up controlJPanel
        // JPanel for microwave controls
        JPanel controlJPanel = new JPanel();
        controlJPanel.setBounds(368, 16, 149, 205);
        controlJPanel.setBorder(new LineBorder(Color.BLACK));
        controlJPanel.setLayout(null);
        contentPane.add(controlJPanel);

        // set up displayJTextField
        displayJTextField = new JTextField();
        displayJTextField.setBounds(7, 5, 135, 30);
        displayJTextField.setText("Microwave Oven");
        displayJTextField.setHorizontalAlignment(JTextField.CENTER);
        displayJTextField.setEditable(false);
        controlJPanel.add(displayJTextField);

        // set up oneJButton
        // JButtons to set cooking time
        JButton oneJButton = new JButton();
        oneJButton.setBounds(13, 59, 41, 24);
        oneJButton.setText("1");
        controlJPanel.add(oneJButton);
        // anonymous inner class
        // event handler called when oneJButton is pressed
        oneJButton.addActionListener(

                this::oneJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set up twoJButton
        JButton twoJButton = new JButton();
        twoJButton.setBounds(54, 59, 41, 24);
        twoJButton.setText("2");
        controlJPanel.add(twoJButton);
        // anonymous inner class
        // event handler called when twoJButton is pressed
        twoJButton.addActionListener(

                this::twoJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set up threeJButton
        JButton threeJButton = new JButton();
        threeJButton.setBounds(95, 59, 41, 24);
        threeJButton.setText("3");
        controlJPanel.add(threeJButton);
        // anonymous inner class
        // event handler called when threeJButton is pressed
        threeJButton.addActionListener(

                this::threeJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set up fourJButton
        JButton fourJButton = new JButton();
        fourJButton.setBounds(13, 83, 41, 24);
        fourJButton.setText("4");
        controlJPanel.add(fourJButton);
        // anonymous inner class
        // event handler called when fourJButton is pressed
        fourJButton.addActionListener(

                this::fourJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set up fiveJButton
        JButton fiveJButton = new JButton();
        fiveJButton.setBounds(54, 83, 41, 24);
        fiveJButton.setText("5");
        controlJPanel.add(fiveJButton);
        // anonymous inner class
        // event handler called when fiveJButton is pressed
        fiveJButton.addActionListener(

                this::fiveJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set up sixJButton
        JButton sixJButton = new JButton();
        sixJButton.setBounds(95, 83, 41, 24);
        sixJButton.setText("6");
        controlJPanel.add(sixJButton);
        // anonymous inner class
        // event handler called when sixJButton is pressed
        sixJButton.addActionListener(

                this::sixJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set up sevenJButton
        JButton sevenJButton = new JButton();
        sevenJButton.setBounds(13, 107, 41, 24);
        sevenJButton.setText("7");
        controlJPanel.add(sevenJButton);
        // anonymous inner class
        // event handler called when sevenJButton is pressed
        sevenJButton.addActionListener(

                this::sevenJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set up eightJButton
        JButton eightJButton = new JButton();
        eightJButton.setBounds(54, 107, 41, 24);
        eightJButton.setText("8");
        controlJPanel.add(eightJButton);
        // anonymous inner class
        // event handler called when eightJButton is pressed
        eightJButton.addActionListener(

                this::eightJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set up nineJButton
        JButton nineJButton = new JButton();
        nineJButton.setBounds(95, 107, 41, 24);
        nineJButton.setText("9");
        controlJPanel.add(nineJButton);
        // anonymous inner class
        // event handler called when nineJButton is pressed
        nineJButton.addActionListener(

                this::nineJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set up zeroJButton
        JButton zeroJButton = new JButton();
        zeroJButton.setBounds(54, 131, 41, 24);
        zeroJButton.setText("0");
        controlJPanel.add(zeroJButton);
        // anonymous inner class
        // event handler called when zeroJButton is pressed
        zeroJButton.addActionListener(

                this::zeroJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set up startJButton
        // JButtons to start and clear timer
        JButton startJButton = new JButton();
        startJButton.setBounds(7, 171, 64, 24);
        startJButton.setText("Start");
        controlJPanel.add(startJButton);
        // anonymous inner class
        // event handler called when startJButton is pressed
        startJButton.addActionListener(

                this::startJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set up clearJButton
        JButton clearJButton = new JButton();
        clearJButton.setBounds(79, 171, 64, 24);
        clearJButton.setText("Clear");
        controlJPanel.add(clearJButton);
        // anonymous inner class
        // event handler called when clearJButton is pressed
        clearJButton.addActionListener(

                this::clearJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set up timerActionListener
        // anonymous inner class
        // event handler called every 1000 milliseconds
        ActionListener timerActionListener =

                this::clockTimerActionPerformed; // end anonymous inner class

        // set up clockTimer
        clockTimer = new Timer(1000, timerActionListener);

        // set properties of application's window
        setTitle("Microwave Oven"); // set title bar string
        setSize(536, 270);          // set window size
        setVisible(true);           // display window

    } // end method createUserInterface

    // add digit 1 to timeToDisplay
    private void oneJButtonActionPerformed(ActionEvent event) {
        displayTime("1"); // display time input properly
    } // end method oneJButtonActionPerformed

    // add digit 2 to timeToDisplay
    private void twoJButtonActionPerformed(ActionEvent event) {
        displayTime("2"); // display time input properly
    } // end method twoJButtonActionPerformed

    // add digit 3 to timeToDisplay
    private void threeJButtonActionPerformed(ActionEvent event) {
        displayTime("3"); // display time input properly
    } // end method threeJButtonActionPerformed

    // add digit 4 to timeToDisplay
    private void fourJButtonActionPerformed(ActionEvent event) {
        displayTime("4"); // display time input properly
    } // end method fourJButtonActionPerformed

    // add digit 5 to timeToDisplay
    private void fiveJButtonActionPerformed(ActionEvent event) {
        displayTime("5"); // display time input properly
    } // end method fiveJButtonActionPerformed

    // add digit 6 to timeToDisplay
    private void sixJButtonActionPerformed(ActionEvent event) {
        displayTime("6"); // display time input properly
    } // end method sixJButtonActionPerformed

    // add digit 7 to timeToDisplay
    private void sevenJButtonActionPerformed(ActionEvent event) {
        displayTime("7"); // display time input properly
    } // end method sevenJButtonActionPerformed

    // add digit 8 to timeToDisplay
    private void eightJButtonActionPerformed(ActionEvent event) {
        displayTime("8"); // display time input properly
    } // end method eightJButtonActionPerformed

    // add digit 9 to timeToDisplay
    private void nineJButtonActionPerformed(ActionEvent event) {
        displayTime("9"); // display time input properly
    } // end method nineJButtonActionPerformed

    // add digit 0 to timeToDisplay
    private void zeroJButtonActionPerformed(ActionEvent event) {
        displayTime("0"); // display time input properly
    } // end method zeroJButtonActionPerformed

    // format the time so that it has exactly four digits
    private String formatTime() {
        // declare String currentTime to manipulate output
        StringBuilder currentTime = new StringBuilder(timeToDisplay);

        // add zeros until currentTime is at least 4 characters long
        for (int i = currentTime.length(); i < 4; i++) {
            currentTime.insert(0, "0");
        }

        // if the length of currentTime is greater than four
        if (currentTime.length() > 4) {
            // shorten currentTime to the first four characters
            currentTime = new StringBuilder(currentTime.substring(0, 4));
        }

        return currentTime.toString();

    } // end method formatTime

    // start the microwave oven
    private void startJButtonActionPerformed(ActionEvent event) {
        // get the time as four digits
        String fourDigitTime = formatTime();

        // extract minutes and seconds
        String minute = fourDigitTime.substring(0, 2);
        String second = fourDigitTime.substring(2);

        // initialize CookingTime object to time entered by user
        microwaveTime.setMinute(Integer.parseInt(minute));
        microwaveTime.setSecond(Integer.parseInt(second));

        // display formatted starting time in displayJTextField
        displayJTextField.setText(timeFormat.format(
                microwaveTime.getMinute()) + ":" + timeFormat.format(
                microwaveTime.getSecond()));

        timeToDisplay = ""; // clear timeToDisplay for future input

        clockTimer.start();                         // start timer
        windowJPanel.setBackground(Color.YELLOW); // turn "light" on

    } // end method startJButtonActionPerformed

    // clear the microwave oven
    private void clearJButtonActionPerformed(ActionEvent event) {
        // stop Timer and reset variables to their initial settings
        clockTimer.stop();
        displayJTextField.setText("Microwave Oven");
        timeToDisplay = "";
        windowJPanel.setBackground(new Color(204, 204, 204));
    } // end method clearJButtonActionPerformed

    // display formatted time in displayJTextField
    private void displayTime(String digit) {
        // append digit to timeToDisplay
        timeToDisplay += digit;

        // get the time as four digits
        String fourDigitTime = formatTime();

        // extract minutes and seconds
        String minute = fourDigitTime.substring(0, 2);
        String second = fourDigitTime.substring(2);

        // display number of minutes, ":", then number of seconds
        displayJTextField.setText(minute + ":" + second);

    } // end method displayTime

    // decrement displayJTextField by one second
    private void clockTimerActionPerformed(ActionEvent event) {
        // decrement microwaveTime by one second
        microwaveTime.tick();

        // if microwaveTime has not reached zero
        if (!microwaveTime.isDone()) {
            // display remaining cooking time in displayJTextField
            displayJTextField.setText(timeFormat.format(
                    microwaveTime.getMinute()) + ":" + timeFormat.format(
                    microwaveTime.getSecond()));

        } // end if
        else // microwaveTime has reached zero
        {
            clockTimer.stop(); // stop timer

            // inform user timer is finished
            displayJTextField.setText("Done!");
            windowJPanel.setBackground(new Color(204, 204, 204));

        } // end else

    } // end method clockTimerActionPerformed

} // end class MicrowaveOven

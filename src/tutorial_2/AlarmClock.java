package tutorial_2;

// Exercise 2.12
// Create GUI for an alarm clock

import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;

public class AlarmClock extends JFrame {

    // no-argument constructor
    public AlarmClock() {
        createUserInterface();
    }

    // create and position GUI components; register event handlers
    private void createUserInterface() {
        // get content pane and set layout to null
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        // set up hourJButton
        JButton hourJButton = new JButton();
        hourJButton.setText("HOUR");
        hourJButton.setBounds(0, 0, 84, 46);
        contentPane.add(hourJButton);

        // set up minuteJButton
        JButton minuteJButton = new JButton();
        minuteJButton.setBounds(84, 0, 84, 46);
        minuteJButton.setText("MINUTE");
        contentPane.add(minuteJButton);

        // set up secondJButton
        JButton secondJButton = new JButton();
        secondJButton.setBounds(168, 0, 90, 46);
        secondJButton.setText("SECOND");
        contentPane.add(secondJButton);

        //set up onJButton
        JButton onJButton = new JButton();
        onJButton.setBounds(258, 0, 56, 46);
        onJButton.setText("ON");
        contentPane.add(onJButton);

        // set up offJButton
        JButton offJButton = new JButton();
        offJButton.setBounds(314, 0, 60, 46);
        offJButton.setText("OFF");
        contentPane.add(offJButton);

        // set up timeJLabel
        JLabel timeJLabel = new JLabel();
        timeJLabel.setText("00:00:00");
        timeJLabel.setBounds(16, 80, 100, 46);
        timeJLabel.setForeground(Color.WHITE);
        timeJLabel.setBackground(Color.BLACK);
        timeJLabel.setOpaque(true);
        timeJLabel.setHorizontalAlignment(JLabel.CENTER);
        contentPane.add(timeJLabel);

        // set up the am/pm JLabel
        JPanel am_pmJPanel = new JPanel();
        am_pmJPanel.setLayout(null);
        am_pmJPanel.setBorder(new TitledBorder(
                new EtchedBorder(EtchedBorder.LOWERED), "AM/PM"));
        am_pmJPanel.setBounds(132, 56, 90, 80);
        contentPane.add(am_pmJPanel);

        // set up amJRadioButton
        JRadioButton amJRadioButton = new JRadioButton();
        amJRadioButton.setText("AM");
        amJRadioButton.setBounds(20, 18, 50, 30);
        am_pmJPanel.add(amJRadioButton);

        // set up pmJRadioButton
        JRadioButton pmJRadioButton = new JRadioButton();
        pmJRadioButton.setText("PM");
        pmJRadioButton.setBounds(20, 40, 50, 30);
        am_pmJPanel.add(pmJRadioButton);

        // set up timerJButton
        JButton timerJButton = new JButton();
        timerJButton.setBounds(256, 76, 80, 50);
        timerJButton.setText("Timer");
        contentPane.add(timerJButton);

        // set up snoozeJLabel
        JLabel snoozeJLabel = new JLabel("SNOOZE");
        snoozeJLabel.setBounds(5, 150, 364, 46);
        snoozeJLabel.setText("SNOOZE");
        snoozeJLabel.setBorder(new LineBorder(Color.BLACK));
        snoozeJLabel.setHorizontalAlignment(JLabel.CENTER);
        contentPane.add(snoozeJLabel);

        // set properties of application's window
        setTitle("Alarm Clock"); // set title bar text
        setSize(390, 240);       // set window size
        setVisible(true);        // display window

    } // end method createUserInterface

    // main method
    public static void main(String[] args) {
        AlarmClock application = new AlarmClock();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } // end method main

} // end class AlarmClock

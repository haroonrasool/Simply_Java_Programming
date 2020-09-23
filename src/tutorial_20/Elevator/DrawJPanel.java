package tutorial_20.Elevator;

// Exercise 20.13: DrawJPanel.java
// This class defines the DrawJPanel object.

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class DrawJPanel extends JPanel {
    // MyRectangle object to represent the elevator
    private final MyRectangle buildingElevator;

    // Timer for displaying elevator movement
    private final Timer delayTimer;

    // integer to store the current floor
    private int currentFloor = 1;

    // integer to store the current position of the elevator
    private int currentPosition = 400;

    // integer to store the position to me moved to
    private int moveToPosition = 400;

    // no-argument constructor
    public DrawJPanel() {
        super();

        // Timer object to move the elevator
        // anonymous inner class
        // timer has incremented
        delayTimer = new Timer(10,

                this::delayTimerActionPerformed // end anonymous inner class

        ); // end call to ActionListener

        // create a new MyRectangle object buildingElevator
        buildingElevator = new MyRectangle(57, 400, 36, 50, Color.BLACK);

    }  // end constructor

    // draw all elevator rectangles
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // draw elevator
        buildingElevator.drawMyRectangle(g);

    } // end method paintComponent

    // move elevator to the new floor
    public void moveElevatorToFloor(int floor) {
        // set the current position to the correct y-coordinate
        currentPosition = (9 - currentFloor) * 50;
        // integer to store the previous floor

        // set the new position to the correct y-coordinate
        moveToPosition = (9 - floor) * 50;
        currentFloor = floor;

        // if elevator needs to be moved
        if (currentPosition != moveToPosition) {
            // start the timer
            delayTimer.start();
        }

    } // end method moveElevatorToFloor

    // move the elevator
    public void moveElevator() {
        // determine if elevator should move up or down
        if (currentPosition < moveToPosition) {
            currentPosition += 1;
        } else {
            currentPosition -= 1;
        }

        // draw the buildingElevator object in its new position
        buildingElevator.setLocation(57, currentPosition);

        // calling the repaint method
        repaint();

    } // end method drawElevator

    // call method moveElevator when the delayTimer increments
    private void delayTimerActionPerformed(ActionEvent event) {
        moveElevator();

        // stop timer when elevator reaches correct floor
        if (currentPosition == moveToPosition) {
            delayTimer.stop();
        }

    } // end method delayTimerActionPerformed

} // end class drawJPanel

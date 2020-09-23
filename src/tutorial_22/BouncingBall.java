package tutorial_22;

// Exercise 21.12: BouncingBall.java
// Game whose goal is preventing ball from falling off the bottom.

import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

public class BouncingBall extends JFrame {
    // Random object to generate random integers
    private final Random randomGenerator = new Random();

    // determine random starting point for the ball
    private int x = 25 + randomGenerator.nextInt(201);
    private int y = 25 + randomGenerator.nextInt(201);

    // position and length of paddle
    private int rectX = 126;
    private final int rectWidth = 80;

    // distance ball travels each time ball is moved
    private int deltaX = 2 + randomGenerator.nextInt(6);
    private int deltaY = 2 + randomGenerator.nextInt(6);

    // Timer for ball
    private Timer ballTimer;

    // no-argument constructor
    public BouncingBall() {
        createUserInterface();
    }

    // main method
    public static void main(String[] args) {
        BouncingBall application = new BouncingBall();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } // end method main

    // create and position GUI components; register event handlers
    private void createUserInterface() {
        // register KeyListener
        addKeyListener(

                new KeyAdapter() // anonymous inner class
                {
                    // event handler called when a key is pressed
                    public void keyPressed(KeyEvent event) {
                        bouncingBallKeyPressed(event);
                    }

                } // end anonymous inner class

        ); // end call to addKeyListener

        // set up ballTimer
        // anonymous inner class
        // event handler called every 30 milliseconds
        ballTimer = new Timer(30,

                this::ballTimerActionPerformed // end anonymous inner class

        ); // end Timer constructor

        // set properties of application's window
        setTitle("Bouncing Ball"); // set title bar string
        setSize(415, 460);         // set window size
        setVisible(true);          // display window

    } // end method createUserInterface

    // draw the ball and the paddle
    public void paint(Graphics graphics) {
        super.paint(graphics);

        // draw the ball
        graphics.setColor(Color.BLUE);
        graphics.fillOval(x, y, 10, 10);

        // draw the paddle
        graphics.setColor(Color.RED);
        graphics.fillRect(rectX, 410, rectWidth, 10);

    } // end method paint

    // move the ball; handle bouncing
    private void ballTimerActionPerformed(ActionEvent event) {
        // update the position of the ball
        x += deltaX;
        y += deltaY;

        if (y <= 25) {
            // bounce the ball off the ceiling
            deltaY = 2 + randomGenerator.nextInt(6);
        } else if (y >= 400 && x >= rectX && x <=
                (rectX + rectWidth)) {
            // bounce the ball off the paddle
            deltaY = -2 - randomGenerator.nextInt(6);
        } else if (y >= 430) {
            // end the game
            ballTimer.stop();
        }

        if (x <= 5) {
            // bounce the ball off the left wall
            deltaX = 2 + randomGenerator.nextInt(6);
        } else if (x >= 400) {
            // bounce the ball off the right wall
            deltaX = -2 - randomGenerator.nextInt(6);
        }

        // call the repaint method
        repaint();

    } // end method ballTimerActionPerformed

    // start the game, move paddle left or right
    private void bouncingBallKeyPressed(KeyEvent event) {
        // determine if the S key has been pressed.
        if (event.getKeyCode() == KeyEvent.VK_S) {
            // start the game
            ballTimer.start();
        } else if (event.getKeyCode() == KeyEvent.VK_LEFT && rectX > 10) {
            // move the paddle to the left.
            rectX -= 10;
        } else if (event.getKeyCode() == KeyEvent.VK_RIGHT && rectX < 400 - rectWidth) {
            // move the paddle to the right.
            rectX += 10;
        }

    } // end method bouncingBallKeyPressed

} // end class BouncingBall

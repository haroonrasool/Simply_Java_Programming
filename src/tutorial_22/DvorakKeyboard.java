package tutorial_22;

// Example 22.16: DvorakKeyboard.java
// Application simulates the letters on a Dvorak Keyboard.

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DvorakKeyboard extends JFrame {

    // JTextArea to display output
    private JTextArea displayJTextArea;

    // JButton to store last key pressed
    private JButton lastJButton;

    // String to hold typed letters
    private String display = "";

    // array of JButtons
    private final JButton[] keyJButtons =
            new JButton[KeyEvent.KEY_LAST + 1];

    // no-argument constructor
    public DvorakKeyboard() {
        createUserInterface();
    }

    // create and position GUI components; register event handlers
    private void createUserInterface() {
        // get content pane for attaching GUI components
        Container contentPane = getContentPane();

        // enable explicit positioning of GUI components
        contentPane.setLayout(null);

        // set up prompt1JLabel
        // JLabels to display instructions
        JLabel prompt1JLabel = new JLabel("Type some text using your " +
                "keyboard. We will display your text and highlight " +
                "keys as");
        prompt1JLabel.setBounds(16, 5, 473, 20);
        contentPane.add(prompt1JLabel);

        // set up prompt2JLabel
        JLabel prompt2JLabel = new JLabel("you go. Note: Clicking the " +
                "JButtons with your mouse will not perform any action.");
        prompt2JLabel.setBounds(16, 20, 473, 20);
        contentPane.add(prompt2JLabel);

        // set up displayJTextArea
        displayJTextArea = new JTextArea();
        displayJTextArea.setBounds(16, 52, 473, 136);
        displayJTextArea.setEditable(false);
        displayJTextArea.setLineWrap(true);
        contentPane.add(displayJTextArea);
        displayJTextArea.addKeyListener(

                new KeyListener() // anonymous inner class
                {
                    // event handler called when a key is pressed
                    public void keyPressed(KeyEvent event) {
                        displayJTextAreaKeyPressed(event);
                    }

                    // event handler called when a key is released
                    public void keyReleased(KeyEvent event) {
                        displayJTextAreaKeyReleased();
                    }

                    // event handler called when a key is typed
                    public void keyTyped(KeyEvent event) {
                    }

                } // end anonymous inner class

        ); // end call to addKeyListener

        // set up pJButton
        // JButtons to represent first row of keys
        JButton pJButton = new JButton("P");
        pJButton.setBounds(145, 196, 45, 24);
        contentPane.add(pJButton);
        keyJButtons[KeyEvent.VK_R] = pJButton;

        // set up yJButton
        JButton yJButton = new JButton("Y");
        yJButton.setBounds(190, 196, 45, 24);
        contentPane.add(yJButton);
        keyJButtons[KeyEvent.VK_T] = yJButton;

        // set up fJButton
        JButton fJButton = new JButton("F");
        fJButton.setBounds(235, 196, 45, 24);
        contentPane.add(fJButton);
        keyJButtons[KeyEvent.VK_Y] = fJButton;

        // set up gJButton
        JButton gJButton = new JButton("G");
        gJButton.setBounds(280, 196, 45, 24);
        contentPane.add(gJButton);
        keyJButtons[KeyEvent.VK_U] = gJButton;

        // set up cJButton
        JButton cJButton = new JButton("C");
        cJButton.setBounds(325, 196, 45, 24);
        contentPane.add(cJButton);
        keyJButtons[KeyEvent.VK_I] = cJButton;

        // set up rJButton
        JButton rJButton = new JButton("R");
        rJButton.setBounds(370, 196, 45, 24);
        contentPane.add(rJButton);
        keyJButtons[KeyEvent.VK_O] = rJButton;

        // set up lJButton
        JButton lJButton = new JButton("L");
        lJButton.setBounds(415, 196, 45, 24);
        contentPane.add(lJButton);
        keyJButtons[KeyEvent.VK_P] = lJButton;

        // set up aJButton
        // JButtons to represent second row of keys
        JButton aJButton = new JButton("A");
        aJButton.setBounds(16, 220, 45, 24);
        contentPane.add(aJButton);
        keyJButtons[KeyEvent.VK_A] = aJButton;

        // set up oJButton
        JButton oJButton = new JButton("O");
        oJButton.setBounds(61, 220, 45, 24);
        contentPane.add(oJButton);
        keyJButtons[KeyEvent.VK_S] = oJButton;

        // set up eJButton
        JButton eJButton = new JButton("E");
        eJButton.setBounds(106, 220, 45, 24);
        contentPane.add(eJButton);
        keyJButtons[KeyEvent.VK_D] = eJButton;

        // set up uJButton
        JButton uJButton = new JButton("U");
        uJButton.setBounds(151, 220, 45, 24);
        contentPane.add(uJButton);
        keyJButtons[KeyEvent.VK_F] = uJButton;

        // set up iJButton
        JButton iJButton = new JButton("I");
        iJButton.setBounds(196, 220, 45, 24);
        contentPane.add(iJButton);
        keyJButtons[KeyEvent.VK_G] = iJButton;

        // set up dJButton
        JButton dJButton = new JButton("D");
        dJButton.setBounds(241, 220, 45, 24);
        contentPane.add(dJButton);
        keyJButtons[KeyEvent.VK_H] = dJButton;

        // set up hJButton
        JButton hJButton = new JButton("H");
        hJButton.setBounds(286, 220, 45, 24);
        contentPane.add(hJButton);
        keyJButtons[KeyEvent.VK_J] = hJButton;

        // set up tJButton
        JButton tJButton = new JButton("T");
        tJButton.setBounds(331, 220, 45, 24);
        contentPane.add(tJButton);
        keyJButtons[KeyEvent.VK_K] = tJButton;

        // set up nJButton
        JButton nJButton = new JButton("N");
        nJButton.setBounds(376, 220, 45, 24);
        contentPane.add(nJButton);
        keyJButtons[KeyEvent.VK_L] = nJButton;

        // set up sJButton
        JButton sJButton = new JButton("S");
        sJButton.setBounds(421, 220, 45, 24);
        contentPane.add(sJButton);
        keyJButtons[KeyEvent.VK_SEMICOLON] = sJButton;

        // set up qJButton
        // JButtons to represent third row of keys
        JButton qJButton = new JButton("Q");
        qJButton.setBounds(100, 244, 45, 24);
        contentPane.add(qJButton);
        keyJButtons[KeyEvent.VK_X] = qJButton;

        // set up jJButton
        JButton jJButton = new JButton("J");
        jJButton.setBounds(145, 244, 45, 24);
        contentPane.add(jJButton);
        keyJButtons[KeyEvent.VK_C] = jJButton;

        // set up kJButton
        JButton kJButton = new JButton("K");
        kJButton.setBounds(190, 244, 45, 24);
        contentPane.add(kJButton);
        keyJButtons[KeyEvent.VK_V] = kJButton;

        // set up xJButton
        JButton xJButton = new JButton("X");
        xJButton.setBounds(235, 244, 45, 24);
        contentPane.add(xJButton);
        keyJButtons[KeyEvent.VK_B] = xJButton;

        // set up bJButton
        JButton bJButton = new JButton("B");
        bJButton.setBounds(280, 244, 45, 24);
        contentPane.add(bJButton);
        keyJButtons[KeyEvent.VK_N] = bJButton;

        // set up mJButton
        JButton mJButton = new JButton("M");
        mJButton.setBounds(325, 244, 45, 24);
        contentPane.add(mJButton);
        keyJButtons[KeyEvent.VK_M] = mJButton;

        // set up wJButton
        JButton wJButton = new JButton("W");
        wJButton.setBounds(370, 244, 50, 24);
        contentPane.add(wJButton);
        keyJButtons[KeyEvent.VK_COMMA] = wJButton;

        // set up vJButton
        JButton vJButton = new JButton("V");
        vJButton.setBounds(420, 244, 45, 24);
        contentPane.add(vJButton);
        keyJButtons[KeyEvent.VK_PERIOD] = vJButton;

        // set up zJButton
        JButton zJButton = new JButton("Z");
        zJButton.setBounds(465, 244, 45, 24);
        contentPane.add(zJButton);
        keyJButtons[KeyEvent.VK_SLASH] = zJButton;

        // set properties of application's window
        setTitle("Dvorak Keyboard"); // set title bar string
        setSize(528, 305);           // set window size
        setVisible(true);            // display window

    } // end method createUserInterface

    // highlight JButton passed as argument
    private void changeColor(JButton highlightJButton) {
        resetColor();
        highlightJButton.setBackground(Color.YELLOW);
        lastJButton = highlightJButton;

    } // end method changeColor

    // changes lastJButton's color back to default
    private void resetColor() {
        if (lastJButton != null) {
            lastJButton.setBackground(this.getBackground());
        }

    } // end method resetColor

    // display letter in displayJTextArea
    private void displayJTextAreaKeyPressed(KeyEvent event) {
        // determine which key was pressed
        JButton pressedJButton = keyJButtons[event.getKeyCode()];

        if (pressedJButton != null) {
            // add the letter on the pressed key to displayJTextArea
            display += pressedJButton.getText();
            displayJTextArea.setText(display);

            // change the color of the pressed key
            changeColor(pressedJButton);
        }

    } // end method displayJTextAreaKeyPressed

    // reset the color of the JButton
    private void displayJTextAreaKeyReleased() {
        resetColor();
    } // end method displayJTextAreaKeyReleased

    // main method
    public static void main(String[] args) {
        DvorakKeyboard application = new DvorakKeyboard();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } // end method main

} // end class DvorakKeyboard

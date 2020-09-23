package tutorial_22;

// Tutorial 22: TypingApplication.java
// Application enables users to practice typing

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TypingApplication extends JFrame {

    private JCheckBoxMenuItem[] styleMenuItems;

    private JTextArea outputJTextArea;

    // JButton to store the last JButton typed
    private JButton lastJButton;

    // array of JButtons
    private final JButton[] keyJButtons =
            new JButton[KeyEvent.KEY_LAST + 1];

    // Font of outputJTextArea
    private Font outputFont;

    // String array of font sizes
    String[] sizeNames = {"12", "16", "20"};

    // String array of font styles
    String[] styleNames = {"Bold", "Italic"};

    // no-argument constructor
    public TypingApplication() {
        createUserInterface();
    }

    // set and position GUI components; register event handlers
    private void createUserInterface() {
        // get content pane for attaching GUI components
        Container contentPane = getContentPane();

        // enable explicit positioning of GUI components
        contentPane.setLayout(null);

        // set up typingJMenuBar
        // JMenuBar for display and format options
        JMenuBar typingJMenuBar = new JMenuBar();
        setJMenuBar(typingJMenuBar);

        // set up displayJMenu
        // JMenu to show display options clear, invert colors and color
        JMenu displayJMenu = new JMenu("Display");
        displayJMenu.setMnemonic(KeyEvent.VK_D);
        typingJMenuBar.add(displayJMenu);

        // set up clearJMenuItem
        // JMenuItems to clear the JTextArea and choose color
        JMenuItem clearJMenuItem = new JMenuItem("Clear Text");
        clearJMenuItem.setMnemonic(KeyEvent.VK_C);
        displayJMenu.add(clearJMenuItem);
        displayJMenu.addSeparator();
        // anonymous inner class
        // event handler called when clearJMenuItem is selected
        clearJMenuItem.addActionListener(

                event -> clearJMenuItemActionPerformed() // end anonymous inner class

        ); // end call to addActionListener

        // set up colorJMenuItem
        JMenuItem colorJMenuItem = new JMenuItem("Color...");
        colorJMenuItem.setMnemonic(KeyEvent.VK_O);
        displayJMenu.add(colorJMenuItem);
        // anonymous inner class
        // event handler called when colorJMenuItem is selected
        colorJMenuItem.addActionListener(

                event -> colorJMenuItemActionPerformed() // end anonymous inner class

        ); // end call to addActionListener

        // set up formatJMenu
        // JMenu to display format options style and size
        JMenu formatJMenu = new JMenu("Format");
        formatJMenu.setMnemonic(KeyEvent.VK_F);
        typingJMenuBar.add(formatJMenu);

        // set up styleJMenu
        // JMenu and array of JCheckBoxMenuItems to display style options
        JMenu styleJMenu = new JMenu("Style");
        styleJMenu.setMnemonic(KeyEvent.VK_S);
        formatJMenu.add(styleJMenu);

        styleMenuItems = new JCheckBoxMenuItem[styleNames.length];

        // set up styleMenuItems
        for (int count = 0; count < styleMenuItems.length; count++) {
            styleMenuItems[count] = new JCheckBoxMenuItem(
                    styleNames[count]);
            styleJMenu.add(styleMenuItems[count]);
            // anonymous inner class
            // event handler called when styleMenuItems selected
            styleMenuItems[count].addItemListener(

                    event -> styleMenuItemsStateChanged() // end anonymous inner class

            ); // end call to addItemListener

        } // end for

        // set up sizeJMenu
        // JMenu, array of JRadioButtonMenuItems and ButtonGroup to
        // display size options
        JMenu sizeJMenu = new JMenu("Size");
        sizeJMenu.setMnemonic(KeyEvent.VK_Z);
        formatJMenu.add(sizeJMenu);

        JRadioButtonMenuItem[] sizeMenuItems = new JRadioButtonMenuItem[sizeNames.length];
        ButtonGroup sizeButtonGroup = new ButtonGroup();

        // set up sizeMenuItems
        for (int count = 0; count < sizeMenuItems.length; count++) {
            sizeMenuItems[count] = new JRadioButtonMenuItem(
                    sizeNames[count]);
            sizeJMenu.add(sizeMenuItems[count]);
            sizeButtonGroup.add(sizeMenuItems[count]);
            // anonymous inner class
            // event handler called when sizeMenuItems is selected
            sizeMenuItems[count].addActionListener(

                    this::sizeMenuItemsActionPerformed // end anonymous inner class

            ); // end call to addActionListener

        } // end for

        // set up prompt1JLabel
        // JLabel and JTextArea to display text output
        JLabel prompt1JLabel = new JLabel("Type some text using your " +
                "keyboard.  The keys you press will be highlighted and " +
                "the text will be displayed.");
        prompt1JLabel.setBounds(15, 5, 725, 20);
        contentPane.add(prompt1JLabel);

        // set up prompt2JLabel
        JLabel prompt2JLabel = new JLabel("Note: Clicking the buttons " +
                "with your mouse will not perform any action.");
        prompt2JLabel.setBounds(15, 20, 725, 25);
        contentPane.add(prompt2JLabel);

        // set up outputJTextArea
        outputJTextArea = new JTextArea();
        outputJTextArea.setBounds(15, 50, 725, 175);
        outputJTextArea.setLineWrap(true);
        contentPane.add(outputJTextArea);
        outputFont = outputJTextArea.getFont();
        outputJTextArea.addKeyListener(

                new KeyListener() // anonymous inner class
                {
                    // event handler called when any key is pressed
                    public void keyPressed(KeyEvent event) {
                        outputJTextAreaKeyPressed(event);
                    }

                    // event handler called when any key is released
                    public void keyReleased(KeyEvent event) {
                        outputJTextAreaKeyReleased();
                    }

                    // event handler called when any key is typed
                    public void keyTyped(KeyEvent event) {
                    }

                } // end anonymous inner class

        ); // end call to addKeyListener

        outputJTextArea.addFocusListener(

                new FocusAdapter() // anonymous inner class
                {
                    // event handler called when outputJTextArea loses focus
                    public void focusLost(FocusEvent event) {
                        outputJTextAreaFocusLost();
                    }

                } // end anonymous inner class

        ); // end call to addFocusListener

        // set up tildeJButton
        // JButtons to represent first row of keys
        JButton tildeJButton = new JButton("~");
        tildeJButton.setBounds(15, 250, 48, 48);
        contentPane.add(tildeJButton);
        keyJButtons[KeyEvent.VK_BACK_QUOTE] = tildeJButton;

        // set up oneJButton
        JButton oneJButton = new JButton("1");
        oneJButton.setBounds(63, 250, 48, 48);
        contentPane.add(oneJButton);
        keyJButtons[KeyEvent.VK_1] = oneJButton;

        // set up twoJButton
        JButton twoJButton = new JButton("2");
        twoJButton.setBounds(111, 250, 48, 48);
        contentPane.add(twoJButton);
        keyJButtons[KeyEvent.VK_2] = twoJButton;

        // set up threeJButton
        JButton threeJButton = new JButton("3");
        threeJButton.setBounds(159, 250, 48, 48);
        contentPane.add(threeJButton);
        keyJButtons[KeyEvent.VK_3] = threeJButton;

        // set up fourJButton
        JButton fourJButton = new JButton("4");
        fourJButton.setBounds(207, 250, 48, 48);
        contentPane.add(fourJButton);
        keyJButtons[KeyEvent.VK_4] = fourJButton;

        // set up fiveJButton
        JButton fiveJButton = new JButton("5");
        fiveJButton.setBounds(255, 250, 48, 48);
        contentPane.add(fiveJButton);
        keyJButtons[KeyEvent.VK_5] = fiveJButton;

        // set up sixJButton
        JButton sixJButton = new JButton("6");
        sixJButton.setBounds(303, 250, 48, 48);
        contentPane.add(sixJButton);
        keyJButtons[KeyEvent.VK_6] = sixJButton;

        // set up sevenJButton
        JButton sevenJButton = new JButton("7");
        sevenJButton.setBounds(351, 250, 48, 48);
        contentPane.add(sevenJButton);
        keyJButtons[KeyEvent.VK_7] = sevenJButton;

        // set up eightJButton
        JButton eightJButton = new JButton("8");
        eightJButton.setBounds(399, 250, 48, 48);
        contentPane.add(eightJButton);
        keyJButtons[KeyEvent.VK_8] = eightJButton;

        // set up nineJButton
        JButton nineJButton = new JButton("9");
        nineJButton.setBounds(447, 250, 48, 48);
        contentPane.add(nineJButton);
        keyJButtons[KeyEvent.VK_9] = nineJButton;

        // set up zeroJButton
        JButton zeroJButton = new JButton("0");
        zeroJButton.setBounds(495, 250, 48, 48);
        contentPane.add(zeroJButton);
        keyJButtons[KeyEvent.VK_0] = zeroJButton;

        // set up hyphenJButton
        JButton hyphenJButton = new JButton("-");
        hyphenJButton.setBounds(543, 250, 48, 48);
        contentPane.add(hyphenJButton);
        keyJButtons[KeyEvent.VK_MINUS] = hyphenJButton;

        // set up plusJButton
        JButton plusJButton = new JButton("+");
        plusJButton.setBounds(591, 250, 48, 48);
        contentPane.add(plusJButton);
        keyJButtons[KeyEvent.VK_EQUALS] = plusJButton;

        // set up backspaceJButton
        JButton backspaceJButton = new JButton("Backspace");
        backspaceJButton.setBounds(639, 250, 100, 48);
        contentPane.add(backspaceJButton);
        keyJButtons[KeyEvent.VK_BACK_SPACE] = backspaceJButton;

        // set up tabJButton
        // JButtons to represent second row of keys
        JButton tabJButton = new JButton("Tab");
        tabJButton.setBounds(15, 298, 75, 48);
        contentPane.add(tabJButton);
        keyJButtons[KeyEvent.VK_TAB] = tabJButton;

        // set up qJButton
        JButton qJButton = new JButton("Q");
        qJButton.setBounds(90, 298, 48, 48);
        contentPane.add(qJButton);
        keyJButtons[KeyEvent.VK_Q] = qJButton;

        // set up wJButton
        JButton wJButton = new JButton("W");
        wJButton.setBounds(138, 298, 48, 48);
        contentPane.add(wJButton);
        keyJButtons[KeyEvent.VK_W] = wJButton;

        // set up eJButton
        JButton eJButton = new JButton("E");
        eJButton.setBounds(186, 298, 48, 48);
        contentPane.add(eJButton);
        keyJButtons[KeyEvent.VK_E] = eJButton;

        // set up rJButton
        JButton rJButton = new JButton("R");
        rJButton.setBounds(234, 298, 48, 48);
        contentPane.add(rJButton);
        keyJButtons[KeyEvent.VK_R] = rJButton;

        // set up tJButton
        JButton tJButton = new JButton("T");
        tJButton.setBounds(282, 298, 48, 48);
        contentPane.add(tJButton);
        keyJButtons[KeyEvent.VK_T] = tJButton;

        // set up yJButton
        JButton yJButton = new JButton("Y");
        yJButton.setBounds(330, 298, 48, 48);
        contentPane.add(yJButton);
        keyJButtons[KeyEvent.VK_Y] = yJButton;

        // set up uJButton
        JButton uJButton = new JButton("U");
        uJButton.setBounds(378, 298, 48, 48);
        contentPane.add(uJButton);
        keyJButtons[KeyEvent.VK_U] = uJButton;

        // set up iJButton
        JButton iJButton = new JButton("I");
        iJButton.setBounds(426, 298, 48, 48);
        contentPane.add(iJButton);
        keyJButtons[KeyEvent.VK_I] = iJButton;

        // set up oJButton
        JButton oJButton = new JButton("O");
        oJButton.setBounds(474, 298, 48, 48);
        contentPane.add(oJButton);
        keyJButtons[KeyEvent.VK_O] = oJButton;

        // set up pJButton
        JButton pJButton = new JButton("P");
        pJButton.setBounds(522, 298, 48, 48);
        contentPane.add(pJButton);
        keyJButtons[KeyEvent.VK_P] = pJButton;

        // set up leftBraceJButton
        JButton leftBraceJButton = new JButton("[");
        leftBraceJButton.setBounds(570, 298, 48, 48);
        contentPane.add(leftBraceJButton);
        keyJButtons[KeyEvent.VK_OPEN_BRACKET] = leftBraceJButton;

        // set up rightBraceJButton
        JButton rightBraceJButton = new JButton("]");
        rightBraceJButton.setBounds(618, 298, 48, 48);
        contentPane.add(rightBraceJButton);
        keyJButtons[KeyEvent.VK_CLOSE_BRACKET] = rightBraceJButton;

        // set up slashJButton
        JButton slashJButton = new JButton("\\");
        slashJButton.setBounds(666, 298, 48, 48);
        contentPane.add(slashJButton);
        keyJButtons[KeyEvent.VK_BACK_SLASH] = slashJButton;

        // set up capsJButton
        // JButtons to represent third row of keys
        JButton capsJButton = new JButton("Caps");
        capsJButton.setBounds(15, 346, 75, 48);
        contentPane.add(capsJButton);
        keyJButtons[KeyEvent.VK_CAPS_LOCK] = capsJButton;

        // set up aJButton
        JButton aJButton = new JButton("A");
        aJButton.setBounds(90, 346, 48, 48);
        contentPane.add(aJButton);
        keyJButtons[KeyEvent.VK_A] = aJButton;

        // set up sJButton
        JButton sJButton = new JButton("S");
        sJButton.setBounds(138, 346, 48, 48);
        contentPane.add(sJButton);
        keyJButtons[KeyEvent.VK_S] = sJButton;

        // set up dJButton
        JButton dJButton = new JButton("D");
        dJButton.setBounds(186, 346, 48, 48);
        contentPane.add(dJButton);
        keyJButtons[KeyEvent.VK_D] = dJButton;

        // set up fJButton
        JButton fJButton = new JButton("F");
        fJButton.setBounds(234, 346, 48, 48);
        contentPane.add(fJButton);
        keyJButtons[KeyEvent.VK_F] = fJButton;

        // set up gJButton
        JButton gJButton = new JButton("G");
        gJButton.setBounds(282, 346, 48, 48);
        contentPane.add(gJButton);
        keyJButtons[KeyEvent.VK_G] = gJButton;

        // set up hJButton
        JButton hJButton = new JButton("H");
        hJButton.setBounds(330, 346, 48, 48);
        contentPane.add(hJButton);
        keyJButtons[KeyEvent.VK_H] = hJButton;

        // set up jJButton
        JButton jJButton = new JButton("J");
        jJButton.setBounds(378, 346, 48, 48);
        contentPane.add(jJButton);
        keyJButtons[KeyEvent.VK_J] = jJButton;

        // set up kJButton
        JButton kJButton = new JButton("K");
        kJButton.setBounds(426, 346, 48, 48);
        contentPane.add(kJButton);
        keyJButtons[KeyEvent.VK_K] = kJButton;

        // set up lJButton
        JButton lJButton = new JButton("L");
        lJButton.setBounds(474, 346, 48, 48);
        contentPane.add(lJButton);
        keyJButtons[KeyEvent.VK_L] = lJButton;

        // set up colonJButton
        JButton colonJButton = new JButton(":");
        colonJButton.setBounds(522, 346, 48, 48);
        contentPane.add(colonJButton);
        keyJButtons[KeyEvent.VK_SEMICOLON] = colonJButton;

        // set up quoteJButton
        JButton quoteJButton = new JButton("\"");
        quoteJButton.setBounds(570, 346, 48, 48);
        contentPane.add(quoteJButton);
        keyJButtons[KeyEvent.VK_QUOTE] = quoteJButton;

        // set up enterJButton
        JButton enterJButton = new JButton("Enter");
        enterJButton.setBounds(618, 346, 96, 48);
        contentPane.add(enterJButton);
        keyJButtons[KeyEvent.VK_ENTER] = enterJButton;

        // set up shiftLeftJButton
        // JButtons to represent fourth row of keys
        JButton shiftLeftJButton = new JButton("Shift");
        shiftLeftJButton.setBounds(15, 394, 100, 48);
        contentPane.add(shiftLeftJButton);
        keyJButtons[KeyEvent.VK_SHIFT] = shiftLeftJButton;

        // set up zJButton
        JButton zJButton = new JButton("Z");
        zJButton.setBounds(115, 394, 48, 48);
        contentPane.add(zJButton);
        keyJButtons[KeyEvent.VK_Z] = zJButton;

        // set up xJButton
        JButton xJButton = new JButton("X");
        xJButton.setBounds(163, 394, 48, 48);
        contentPane.add(xJButton);
        keyJButtons[KeyEvent.VK_X] = xJButton;

        // set up cJButton
        JButton cJButton = new JButton("C");
        cJButton.setBounds(211, 394, 48, 48);
        contentPane.add(cJButton);
        keyJButtons[KeyEvent.VK_C] = cJButton;

        // set up vJButton
        JButton vJButton = new JButton("V");
        vJButton.setBounds(259, 394, 48, 48);
        contentPane.add(vJButton);
        keyJButtons[KeyEvent.VK_V] = vJButton;

        // set up bJButton
        JButton bJButton = new JButton("B");
        bJButton.setBounds(307, 394, 48, 48);
        contentPane.add(bJButton);
        keyJButtons[KeyEvent.VK_B] = bJButton;

        // set up nJButton
        JButton nJButton = new JButton("N");
        nJButton.setBounds(355, 394, 48, 48);
        contentPane.add(nJButton);
        keyJButtons[KeyEvent.VK_N] = nJButton;

        // set up mJButton
        JButton mJButton = new JButton("M");
        mJButton.setBounds(403, 394, 48, 48);
        contentPane.add(mJButton);
        keyJButtons[KeyEvent.VK_M] = mJButton;

        // set up commaJButton
        JButton commaJButton = new JButton(",");
        commaJButton.setBounds(451, 394, 48, 48);
        contentPane.add(commaJButton);
        keyJButtons[KeyEvent.VK_COMMA] = commaJButton;

        // set up periodJButton
        JButton periodJButton = new JButton(".");
        periodJButton.setBounds(499, 394, 48, 48);
        contentPane.add(periodJButton);
        keyJButtons[KeyEvent.VK_PERIOD] = periodJButton;

        // set up questionJButton
        JButton questionJButton = new JButton("?");
        questionJButton.setBounds(547, 394, 48, 48);
        contentPane.add(questionJButton);
        keyJButtons[KeyEvent.VK_SLASH] = questionJButton;

        // set up upJButton
        JButton upJButton = new JButton("^");
        upJButton.setBounds(618, 394, 48, 48);
        contentPane.add(upJButton);
        keyJButtons[KeyEvent.VK_UP] = upJButton;

        // set up spaceJButton
        // JButtons to represent fifth row of keys
        JButton spaceJButton = new JButton("");
        spaceJButton.setBounds(208, 442, 300, 48);
        contentPane.add(spaceJButton);
        keyJButtons[KeyEvent.VK_SPACE] = spaceJButton;

        // set up leftJButton
        JButton leftJButton = new JButton("<");
        leftJButton.setBounds(570, 442, 48, 48);
        contentPane.add(leftJButton);
        keyJButtons[KeyEvent.VK_LEFT] = leftJButton;

        // set up downJButton
        JButton downJButton = new JButton("v");
        downJButton.setBounds(618, 442, 48, 48);
        contentPane.add(downJButton);
        keyJButtons[KeyEvent.VK_DOWN] = downJButton;

        // set up rightJButton
        JButton rightJButton = new JButton(">");
        rightJButton.setBounds(666, 442, 48, 48);
        contentPane.add(rightJButton);
        keyJButtons[KeyEvent.VK_RIGHT] = rightJButton;

        // set properties of application's window
        setTitle("Typing Application"); // set title bar string
        setSize(760, 550);              // set window size
        setVisible(true);               // display window

    } // end method createUserInterface

    // reset the color of the lastJButton
    private void outputJTextAreaFocusLost() {
        resetColor();

    } // end method outputJTextAreaFocusLost

    // clear text
    private void clearJMenuItemActionPerformed() {
        outputJTextArea.setText("");

    } // end method clearJMenuItemActionPerformed

    // highlight JButton passed as argument
    private void changeColor(JButton changeJButton) {
        if (changeJButton != null) {
            resetColor();
            changeJButton.setBackground(Color.YELLOW);
            lastJButton = changeJButton;
        }

    } // end method changeColor

    // changes lastJButton's color back to default
    private void resetColor() {
        if (lastJButton != null) {
            lastJButton.setBackground(this.getBackground());
        }

    } // end method resetColor

    // change text color when user selects Colors... JMenuItem
    private void colorJMenuItemActionPerformed() {
        Color foregroundColor = JColorChooser.showDialog(
                this, "Choose a color", Color.BLACK);

        // if the user selected a color
        if (foregroundColor != null) {
            // set foreground color of outputJTextArea
            outputJTextArea.setForeground(foregroundColor);
        }

    } // end method colorMenuItemActionPerformed

    // change font when user selects an item from Style submenu
    private void styleMenuItemsStateChanged() {
        int style = Font.PLAIN;

        // check for bold selection
        if (styleMenuItems[0].isSelected()) {
            style += Font.BOLD;
        }

        // check for italic selection
        if (styleMenuItems[1].isSelected()) {
            style += Font.PLAIN;
        }

        // create a new Font with the specified style
        outputFont = new Font(outputFont.getName(), style,
                outputFont.getSize());

        outputJTextArea.setFont(outputFont); // set the font

    } // end method styleMenuItemsStateChanged

    // change font size when user selects an item from size submenu
    private void sizeMenuItemsActionPerformed(ActionEvent event) {
        JRadioButtonMenuItem sizeMenuItem =
                (JRadioButtonMenuItem) event.getSource();

        // create a new Font with the specified size
        outputFont = new Font(outputFont.getName(),
                outputFont.getStyle(),
                Integer.parseInt(sizeMenuItem.getText()));

        outputJTextArea.setFont(outputFont); // set the font

    } // end method sizeMenuItemsActionPerformed

    // highlight corresponding JButton when a key is pressed
    private void outputJTextAreaKeyPressed(KeyEvent event) {
        // get the key code for this event
        int buttonIndex = event.getKeyCode();

        // change the color of the associated JButton
        changeColor(keyJButtons[buttonIndex]);

    } // end method outputJTextAreaKeyPressed

    // reset the color of the pressed key's JButton
    private void outputJTextAreaKeyReleased() {
        resetColor();

    } // end method outputJTextAreaKeyReleased

    // main method
    public static void main(String[] args) {
        TypingApplication application = new TypingApplication();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    } // end method main

} // end class TypingApplication

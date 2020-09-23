package tutorial_22;

// Fig. 22.13 Painter.java
// Application enables user to paint objects and name them.

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Painter extends JFrame {

    // JRadioButtonMenuItems, ButtonGroup and JCheckBoxMenuItems
    // display style and size options
    private JCheckBoxMenuItem[] styleItems;

    // JTextArea for user to type in and Font of the JTextArea
    private JTextArea displayJTextArea;
    private Font displayFont;

    // PainterJPanel to allow user to paint with mouse
    private PainterJPanel myPainterJPanel;

    // String array to hold paint size options
    private final String[] paintSizes = {"4", "6", "8", "10"};

    // String array to hold font style options
    private final String[] styles = {"Bold", "Italic"};

    // String array to hold font size options
    private final String[] fontSizes = {"12", "16", "20"};

    // no-argument constructor
    public Painter() {
        createUserInterface();
    }

    // main method
    public static void main(String[] args) {
        Painter application = new Painter();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } // end method main

    // create and position GUI components; register event handlers
    private void createUserInterface() {
        // get content pane for attaching GUI components
        Container contentPane = getContentPane();

        // enable explicit positioning of GUI components
        contentPane.setLayout(null);

        // set up painterJMenuBar
        // JMenuBar to hold paint and text options
        JMenuBar painterJMenuBar = new JMenuBar();
        setJMenuBar(painterJMenuBar);

        // set up paintJMenu
        // JMenu to holds paint and text options
        JMenu paintJMenu = new JMenu();
        paintJMenu.setText("Paint");
        paintJMenu.setMnemonic(KeyEvent.VK_P);
        painterJMenuBar.add(paintJMenu);

        // set up paintColorJMenuItem
        // JMenuItems and JMenu allow user to change application colors
        JMenuItem paintColorJMenuItem = new JMenuItem();
        paintColorJMenuItem.setText("Paint Color...");
        paintColorJMenuItem.setMnemonic(KeyEvent.VK_C);
        paintJMenu.add(paintColorJMenuItem);
        // anonymous inner class
        // event handler called when paintColorJMenuItem is selected
        paintColorJMenuItem.addActionListener(

                this::paintColorJMenuItemActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set up paintSizeJMenu
        JMenu paintSizeJMenu = new JMenu();
        paintSizeJMenu.setText("Paint Size");
        paintSizeJMenu.setMnemonic(KeyEvent.VK_S);
        paintJMenu.add(paintSizeJMenu);

        // set up paintSizeItems
        // array of JRadioButtonMenuItems and ButtonGroup for different
        // paint size options
        JRadioButtonMenuItem[] paintSizeItems = new JRadioButtonMenuItem[paintSizes.length];
        ButtonGroup paintSizeButtonGroup = new ButtonGroup();

        for (int count = 0; count < paintSizes.length; count++) {
            paintSizeItems[count] =
                    new JRadioButtonMenuItem(paintSizes[count]);
            paintSizeJMenu.add(paintSizeItems[count]);
            paintSizeButtonGroup.add(paintSizeItems[count]);
            // anonymous inner class
            // event handler called when a sizeItem is selected
            paintSizeItems[count].addActionListener(

                    this::sizeJMenuActionPerformed // end anonymous inner class

            ); // end call to addActionListener

        } // end for

        // set up textJMenu
        JMenu textJMenu = new JMenu();
        textJMenu.setText("Text");
        textJMenu.setMnemonic(KeyEvent.VK_T);
        painterJMenuBar.add(textJMenu);

        // set up textColorJMenuItem
        // JMenuItems and JMenu allow user to change text properties
        JMenuItem textColorJMenuItem = new JMenuItem();
        textColorJMenuItem.setText("Text Color...");
        textColorJMenuItem.setMnemonic(KeyEvent.VK_C);
        textJMenu.add(textColorJMenuItem);
        // anonymous inner class
        // event handler called when textColorJMenuItem is selected
        textColorJMenuItem.addActionListener(

                this::textColorJMenuItemActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set up formatJMenu
        JMenu formatJMenu = new JMenu();
        formatJMenu.setText("Format");
        formatJMenu.setMnemonic(KeyEvent.VK_F);
        textJMenu.add(formatJMenu);

        // set up styleJMenu
        // JMenus allow user to format text
        JMenu styleJMenu = new JMenu();
        styleJMenu.setText("Style");
        styleJMenu.setMnemonic(KeyEvent.VK_S);
        formatJMenu.add(styleJMenu);

        // set up styleItems
        styleItems = new JCheckBoxMenuItem[styles.length];

        for (int count = 0; count < styleItems.length; count++) {
            styleItems[count] = new JCheckBoxMenuItem(
                    styles[count]);
            styleJMenu.add(styleItems[count]);
            // anonymous inner class
            // event handler called when a style item is selected
            styleItems[count].addItemListener(

                    this::styleItemsStateChanged // end anonymous inner class

            ); // end call to addItemListener

        } // end for

        // set up sizeJMenu
        JMenu sizeJMenu = new JMenu();
        sizeJMenu.setText("Size");
        sizeJMenu.setMnemonic(KeyEvent.VK_Z);
        formatJMenu.add(sizeJMenu);

        // set up sizeItems
        JRadioButtonMenuItem[] sizeItems = new JRadioButtonMenuItem[fontSizes.length];
        ButtonGroup sizeButtonGroup = new ButtonGroup();

        for (int count = 0; count < sizeItems.length; count++) {
            sizeItems[count] = new JRadioButtonMenuItem(
                    fontSizes[count]);
            sizeJMenu.add(sizeItems[count]);
            sizeButtonGroup.add(sizeItems[count]);
            // anonymous inner class
            // event handler called when a sizeItem is selected
            sizeItems[count].addActionListener(

                    this::fontSizeItemsActionPerformed // end anonymous inner class

            ); // end call to addActionListener

        } // end for

        // set up displayJTextArea
        displayJTextArea = new JTextArea();
        displayJTextArea.setBounds(16, 16, 300, 75);
        displayJTextArea.setLineWrap(true);
        displayFont = displayJTextArea.getFont();
        contentPane.add(displayJTextArea);

        // set up myPainterJPanel
        myPainterJPanel = new PainterJPanel(Color.BLACK, 8);
        myPainterJPanel.setBounds(16, 100, 300, 200);
        contentPane.add(myPainterJPanel);

        // set properties of application's window
        setTitle("Painter"); // set title bar string
        setSize(340, 350);   // set window size
        setVisible(true);    // display window

    } // end method createUserInterface

    // change the painting color
    private void paintColorJMenuItemActionPerformed(
            ActionEvent event) {
        Color paintColor = JColorChooser.showDialog(this,
                "Choose a color", myPainterJPanel.getColor());

        // set the draw color
        if (paintColor != null) {
            myPainterJPanel.setColor(paintColor);
        }

    } // end method paintColorJMenuItemActionPerformed

    // method to change the text color
    private void textColorJMenuItemActionPerformed(
            ActionEvent event) {
        Color textColor = JColorChooser.showDialog(
                this, "Choose a color", displayJTextArea.getForeground());

        // set text color
        if (textColor != null) {
            displayJTextArea.setForeground(textColor);
        }

    } //  end method textItemActionPerformed

    // update the font style
    private void styleItemsStateChanged(ItemEvent event) {

        // check for bold selection
        styleItems[0].isSelected();

        // check for italic selection
        styleItems[1].isSelected();

        // create a new Font with the specified style
        displayFont = new Font(displayFont.getName(), Font.ITALIC,
                displayFont.getSize());

        displayJTextArea.setFont(displayFont); // set the font

    } // end method styleItemsStateChanged

    // update the font size
    private void fontSizeItemsActionPerformed(ActionEvent event) {
        JRadioButtonMenuItem sizeMenuItem =
                (JRadioButtonMenuItem) event.getSource();

        // create a new Font with the specified size
        displayFont = new Font(displayFont.getName(),
                displayFont.getStyle(),
                Integer.parseInt(sizeMenuItem.getText()));

        displayJTextArea.setFont(displayFont); // set the font

    } // end method sizeItemsActionPerformed

    // change the painting size
    private void sizeJMenuActionPerformed(ActionEvent event) {
        JRadioButtonMenuItem sizeMenuItem =
                (JRadioButtonMenuItem) event.getSource();

        myPainterJPanel.setDiameter(Integer.parseInt(
                sizeMenuItem.getText()));

    } // end method sizeJMenuActionPerformed

} // end class Painter

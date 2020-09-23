package tutorial_2;

// Exercise 2.11
// Create GUI calculator

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;

public class Calculator extends JFrame {
    // no-argument constructor
    public Calculator() {
        createUserInterface();
    }

    // create and position GUI components; register event handlers
    private void createUserInterface() {
        // get content pane and set layout to null
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        // set up displayJTextField
        JTextField displayJTextField = new JTextField();
        displayJTextField.setText("0");
        displayJTextField.setBounds(16, 16, 480, 24); // w, y, width, height
        displayJTextField.setHorizontalAlignment(JTextField.RIGHT);
        contentPane.add(displayJTextField);

        // set up numberJPanel
        JPanel numberJPanel = new JPanel();
        numberJPanel.setLayout(null);
        numberJPanel.setBounds(16, 62, 176, 224);
        numberJPanel.setBorder(new BevelBorder(BevelBorder.LOWERED));
        contentPane.add(numberJPanel);

        // set up oneJButton
        JButton oneJButton = new JButton();
        oneJButton.setText("1");
        oneJButton.setBounds(16, 16, 48, 48);
        numberJPanel.add(oneJButton);

        // set up two JButton
        JButton twoJButton = new JButton();
        twoJButton.setText("2");
        twoJButton.setBounds(64, 16, 48, 48);
        numberJPanel.add(twoJButton);

        // set up threeJButton
        JButton threeJButton = new JButton();
        threeJButton.setText("3");
        threeJButton.setBounds(112, 16, 48, 48);
        numberJPanel.add(threeJButton);

        // set up fourJButton
        JButton fourJButton = new JButton();
        fourJButton.setText("4");
        fourJButton.setBounds(16, 64, 48, 48);
        numberJPanel.add(fourJButton);

        // set up fiveJButton
        JButton fiveJButton = new JButton();
        fiveJButton.setText("5");
        fiveJButton.setBounds(64, 64, 48, 48);
        numberJPanel.add(fiveJButton);

        // set up sixJButton
        JButton sixJButton = new JButton();
        sixJButton.setText("6");
        sixJButton.setBounds(112, 64, 48, 48);
        numberJPanel.add(sixJButton);

        // set up sevenJButton
        JButton sevenJButton = new JButton();
        sevenJButton.setText("7");
        sevenJButton.setBounds(16, 112, 48, 48);
        numberJPanel.add(sevenJButton);

        // set up eightJButton
        JButton eightJButton = new JButton();
        eightJButton.setText("8");
        eightJButton.setBounds(64, 112, 48, 48);
        numberJPanel.add(eightJButton);

        // set up nineJButton
        JButton nineJButton = new JButton();
        nineJButton.setText("9");
        nineJButton.setBounds(112, 112, 48, 48);
        numberJPanel.add(nineJButton);

        // set up zeroJButton
        JButton zeroJButton = new JButton();
        zeroJButton.setText("0");
        zeroJButton.setBounds(16, 160, 48, 48);
        numberJPanel.add(zeroJButton);

        // set up doubleZeroJButton
        JButton doubleZeroJButton = new JButton();
        doubleZeroJButton.setText("00");
        doubleZeroJButton.setBounds(64, 160, 96, 48);
        numberJPanel.add(doubleZeroJButton);

        // set up operationJPanel
        JPanel operationJPanel = new JPanel();
        operationJPanel.setLayout(null);
        operationJPanel.setBounds(224, 62, 144, 224);
        operationJPanel.setBorder(new BevelBorder(BevelBorder.LOWERED));
        contentPane.add(operationJPanel);

        // set up plusJButton
        JButton plusJButton = new JButton();
        plusJButton.setText("+");
        plusJButton.setBounds(16, 16, 48, 128);
        plusJButton.setFont(new Font("SansSerif", Font.PLAIN, 18));
        operationJPanel.add(plusJButton);

        // set up minusJButton
        JButton minusJButton = new JButton();
        minusJButton.setText("-");
        minusJButton.setBounds(80, 16, 48, 48);
        minusJButton.setFont(new Font("SansSerif", Font.PLAIN, 18));
        operationJPanel.add(minusJButton);

        // set up timesJButton
        JButton timesJButton = new JButton();
        timesJButton.setText("*");
        timesJButton.setBounds(80, 64, 48, 48);
        timesJButton.setFont(new Font("SansSerif", Font.PLAIN, 18));
        operationJPanel.add(timesJButton);

        // set up divideJButton
        JButton divideJButton = new JButton();
        divideJButton.setText("/");
        divideJButton.setBounds(80, 112, 48, 48);
        divideJButton.setFont(new Font("SansSerif", Font.PLAIN, 18));
        operationJPanel.add(divideJButton);

        // set up equalsJButton
        JButton equalsJButton = new JButton();
        equalsJButton.setText("=");
        equalsJButton.setBounds(80, 160, 48, 48);
        equalsJButton.setFont(new Font("SansSerif", Font.PLAIN, 18));
        operationJPanel.add(equalsJButton);

        // set up decimalJButton
        JButton decimalJButton = new JButton();
        decimalJButton.setText(".");
        decimalJButton.setBounds(16, 160, 48, 48);
        decimalJButton.setFont(new Font("SansSerif", Font.PLAIN, 18));
        operationJPanel.add(decimalJButton);

        // set up clearJPanel
        JPanel clearJPanel = new JPanel();
        clearJPanel.setLayout(null);
        clearJPanel.setBounds(400, 62, 96, 144);
        clearJPanel.setBorder(new BevelBorder(BevelBorder.LOWERED));
        contentPane.add(clearJPanel);

        // set up clearJButton
        JButton clearJButton = new JButton();
        clearJButton.setText("C");
        clearJButton.setBounds(16, 16, 64, 48);
        clearJPanel.add(clearJButton);

        // set up clearAllJButton
        JButton clearAllJButton = new JButton();
        clearAllJButton.setText("C/A");
        clearAllJButton.setBounds(16, 80, 64, 48);
        clearJPanel.add(clearAllJButton);

        // set up offJButton
        JButton offJButton = new JButton();
        offJButton.setText("OFF");
        offJButton.setBounds(400, 234, 96, 48); // w, y, width, height
        contentPane.add(offJButton);

        // set properties of application's window
        setTitle("Calculator"); // set title bar text
        setSize(520, 330); // set window size
        setVisible(true); // display window

    } // end method createUserInterface

    // main method
    public static void main(String[] args) {
        Calculator application = new Calculator();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } // end method main

} // end class Calculator

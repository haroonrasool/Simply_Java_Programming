package tutorial_3;

// Exercise 3.14: MonitorInvoice.java
// GUI for invoice application.

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class MonitorInvoice extends JFrame {
    // no-argument constructor
    public MonitorInvoice() {
        createUserInterface();
    }

    // main method
    public static void main(String[] args) {
        MonitorInvoice application = new MonitorInvoice();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } // end method main

    // create and position GUI components
    public void createUserInterface() {
        // get content pane and set its layout
        Container container = getContentPane();
        container.setLayout(null);

        // set up titleJLabel
        // JLabel that displays title in window
        JLabel titleJLabel = new JLabel();
        titleJLabel.setBounds(0, 16, 378, 32);
        titleJLabel.setText("Monitor Invoice");
        titleJLabel.setHorizontalAlignment(JLabel.CENTER);
        titleJLabel.setFont(new Font(
                titleJLabel.getFont().getName(),
                titleJLabel.getFont().getStyle(), 20));
        container.add(titleJLabel);

        // set up invoiceNumberJLabel
        // JLabel and JTextField for invoice number
        JLabel invoiceNumberJLabel = new JLabel();
        invoiceNumberJLabel.setBounds(16, 64, 92, 21);
        invoiceNumberJLabel.setText("Invoice number:");
        container.add(invoiceNumberJLabel);

        // set up invoiceDateJLabel
        // JLabel and JTextField for invoice date
        JLabel invoiceDateJLabel = new JLabel();
        invoiceDateJLabel.setBounds(176, 64, 72, 21);
        invoiceDateJLabel.setText("Invoice date:");
        container.add(invoiceDateJLabel);

        // set up companyNameJLabel
        // JLabel and JTextField for company name
        JLabel companyNameJLabel = new JLabel();
        companyNameJLabel.setBounds(16, 104, 92, 21);
        companyNameJLabel.setText("Company name:");
        container.add(companyNameJLabel);

        // set up addressJLabel
        // JLabel and JTextField for street address
        JLabel addressJLabel = new JLabel();
        addressJLabel.setBounds(16, 144, 92, 21);
        addressJLabel.setText("Address (line 1):");
        container.add(addressJLabel);

        // set up cityStateZipJLabel
        // JLabel and JTextField for city, state and zip code
        JLabel cityStateZipJLabel = new JLabel();
        cityStateZipJLabel.setBounds(16, 184, 92, 21);
        cityStateZipJLabel.setText("Address (line 2):");
        container.add(cityStateZipJLabel);

        // set up sizeJLabel
        // JLabels for column heads
        JLabel sizeJLabel = new JLabel();
        sizeJLabel.setBounds(20, 224, 80, 21);
        sizeJLabel.setText("Monitor size:");
        sizeJLabel.setHorizontalAlignment(JLabel.RIGHT);
        container.add(sizeJLabel);

        // set up quantityJLabel
        JLabel quantityJLabel = new JLabel();
        quantityJLabel.setBounds(112, 224, 56, 21);
        quantityJLabel.setText("Quantity:");
        container.add(quantityJLabel);

        // set up priceJLabel
        JLabel priceJLabel = new JLabel();
        priceJLabel.setBounds(192, 224, 42, 21);
        priceJLabel.setText("Price:");
        container.add(priceJLabel);

        // set up totalsJLabel
        JLabel totalsJLabel = new JLabel();
        totalsJLabel.setBounds(288, 224, 40, 21);
        totalsJLabel.setText("Totals:");
        container.add(totalsJLabel);

        // set up fifteenJLabel
        // JLabel and JTextFields for 15" monitors
        JLabel fifteenJLabel = new JLabel();
        fifteenJLabel.setBounds(20, 248, 80, 21);
        fifteenJLabel.setText("15\" :");
        fifteenJLabel.setHorizontalAlignment(JLabel.RIGHT);
        container.add(fifteenJLabel);

        // set up seventeenJLabel
        // JLabel and JTextFields for 17" monitors
        JLabel seventeenJLabel = new JLabel();
        seventeenJLabel.setBounds(20, 280, 80, 21);
        seventeenJLabel.setText("17\" :");
        seventeenJLabel.setHorizontalAlignment(JLabel.RIGHT);
        container.add(seventeenJLabel);

        // set up nineteenJLabel
        // JLabel and JTextFields for 19" monitors
        JLabel nineteenJLabel = new JLabel();
        nineteenJLabel.setBounds(20, 312, 80, 21);
        nineteenJLabel.setText("19\" :");
        nineteenJLabel.setHorizontalAlignment(JLabel.RIGHT);
        container.add(nineteenJLabel);

        // set up subtotalJLabel
        // JLabel and JTextField subtotal
        JLabel subtotalJLabel = new JLabel();
        subtotalJLabel.setBounds(224, 344, 56, 21);
        subtotalJLabel.setText("Subtotal:");
        container.add(subtotalJLabel);

        // set up taxJLabel
        // JLabel and JTextField for taxes
        JLabel taxJLabel = new JLabel();
        taxJLabel.setBounds(224, 376, 32, 21);
        taxJLabel.setText("Tax:");
        container.add(taxJLabel);

        // set up totalJLabel
        // JLabel and JTextField for total
        JLabel totalJLabel = new JLabel();
        totalJLabel.setBounds(224, 408, 40, 21);
        totalJLabel.setText("Total:");
        container.add(totalJLabel);

        // set up invoiceNumberJTextField
        JTextField invoiceNumberJTextField = new JTextField();
        invoiceNumberJTextField.setBounds(122, 64, 38, 21);
        invoiceNumberJTextField.setText("128");
        container.add(invoiceNumberJTextField);

        // set up invoiceDateJTextField
        JTextField invoiceDateJTextField = new JTextField();
        invoiceDateJTextField.setBounds(256, 64, 104, 21);
        invoiceDateJTextField.setText("04/01/2003");
        container.add(invoiceDateJTextField);

        // set up companyNameJTextField
        JTextField companyNameJTextField = new JTextField();
        companyNameJTextField.setBounds(122, 104, 238, 21);
        companyNameJTextField.setText("Deitel & Associates");
        container.add(companyNameJTextField);

        // set up addressJTextField
        JTextField addressJTextField = new JTextField();
        addressJTextField.setBounds(122, 144, 238, 21);
        addressJTextField.setText("100 Main Street");
        container.add(addressJTextField);

        // set up cityStateZipJTextField
        JTextField cityStateZipJTextField = new JTextField();
        cityStateZipJTextField.setBounds(122, 184, 238, 21);
        cityStateZipJTextField.setText("Some Town, MA 00000");
        container.add(cityStateZipJTextField);

        // set up quantity15JTextField
        JTextField quantity15JTextField = new JTextField();
        quantity15JTextField.setBounds(112, 248, 64, 21); // x, y, w, h
        quantity15JTextField.setText("10");
        quantity15JTextField.setHorizontalAlignment(
                JTextField.RIGHT);
        container.add(quantity15JTextField);

        // set up quantity17JTextField
        JTextField quantity17JTextField = new JTextField();
        quantity17JTextField.setBounds(112, 280, 64, 21); // x, y, w, h
        quantity17JTextField.setText("0");
        quantity17JTextField.setHorizontalAlignment(
                JTextField.RIGHT);
        container.add(quantity17JTextField);

        // set up quantity19JTextField
        JTextField quantity19JTextField = new JTextField();
        quantity19JTextField.setBounds(112, 312, 64, 21); // x, y, w, h
        quantity19JTextField.setText("0");
        quantity19JTextField.setHorizontalAlignment(
                JTextField.RIGHT);
        container.add(quantity19JTextField);

        // set up price15JTextField
        JTextField price15JTextField = new JTextField();
        price15JTextField.setBounds(192, 248, 80, 21);
        price15JTextField.setText("150");
        price15JTextField.setHorizontalAlignment(JTextField.RIGHT);
        container.add(price15JTextField);

        // set up price17JTextField
        JTextField price17JTextField = new JTextField();
        price17JTextField.setBounds(192, 280, 80, 21);
        price17JTextField.setText("0");
        price17JTextField.setHorizontalAlignment(JTextField.RIGHT);
        container.add(price17JTextField);

        // set up price19JTextField
        JTextField price19JTextField = new JTextField();
        price19JTextField.setBounds(192, 312, 80, 21);
        price19JTextField.setText("0");
        price19JTextField.setHorizontalAlignment(JTextField.RIGHT);
        container.add(price19JTextField);

        // set up totals15JTextField
        JTextField totals15JTextField = new JTextField();
        totals15JTextField.setBounds(288, 248, 72, 21);
        totals15JTextField.setHorizontalAlignment(JTextField.RIGHT);
        totals15JTextField.setEditable(false);
        totals15JTextField.setBorder(new BevelBorder(BevelBorder.LOWERED));
        container.add(totals15JTextField);

        // set up totals17JTextField
        JTextField totals17JTextField = new JTextField();
        totals17JTextField.setBounds(288, 280, 72, 21);
        totals17JTextField.setHorizontalAlignment(JTextField.RIGHT);
        totals17JTextField.setEditable(false);
        totals17JTextField.setBorder(new BevelBorder(BevelBorder.LOWERED));
        container.add(totals17JTextField);

        // set up totals19JTextField
        JTextField totals19JTextField = new JTextField();
        totals19JTextField.setBounds(288, 312, 72, 21);
        totals19JTextField.setHorizontalAlignment(JTextField.RIGHT);
        totals19JTextField.setEditable(false);
        totals19JTextField.setBorder(new BevelBorder(BevelBorder.LOWERED));
        container.add(totals19JTextField);

        // set up subtotalJTextField
        JTextField subtotalJTextField = new JTextField();
        subtotalJTextField.setBounds(288, 344, 72, 21);
        subtotalJTextField.setHorizontalAlignment(JTextField.RIGHT);
        subtotalJTextField.setEditable(false);
        subtotalJTextField.setBorder(new BevelBorder(BevelBorder.LOWERED));
        container.add(subtotalJTextField);

        // set up taxJTextField
        JTextField taxJTextField = new JTextField();
        taxJTextField.setBounds(288, 376, 72, 21);
        taxJTextField.setHorizontalAlignment(JTextField.RIGHT);
        taxJTextField.setEditable(false);
        taxJTextField.setBorder(new BevelBorder(BevelBorder.LOWERED));
        container.add(taxJTextField);

        // set up totalJTextField
        JTextField totalJTextField = new JTextField();
        totalJTextField.setBounds(288, 408, 72, 21);
        totalJTextField.setHorizontalAlignment(JTextField.RIGHT);
        totalJTextField.setEditable(false);
        totalJTextField.setBorder(new BevelBorder(BevelBorder.LOWERED));
        container.add(totalJTextField);

        // set up saveJButton
        // JButtons to save, calculate results and clear JTextFields
        JButton saveJButton = new JButton();
        saveJButton.setBounds(102, 442, 72, 23);
        saveJButton.setText("Save");
        container.add(saveJButton);

        // set up calculateJButton
        JButton calculateJButton = new JButton();
        calculateJButton.setBounds(187, 442, 88, 23);
        calculateJButton.setText("Calculate");
        container.add(calculateJButton);

        // set up clearJButton
        JButton clearJButton = new JButton();
        clearJButton.setBounds(288, 442, 72, 23);
        clearJButton.setText("Clear");
        container.add(clearJButton);

        // set properties of application�s window
        setTitle("Monitor Invoice"); // set title bar text
        setSize(384, 510);           // set window size
        setVisible(true);            // display window

    } // end method createUserInterface

} // end class MonitorInvoice

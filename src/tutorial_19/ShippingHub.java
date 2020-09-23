package tutorial_19;

// Tutorial 19: ShippingHub.java
// This application tracks Parcels that pass through a shipping hub.

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class ShippingHub extends JFrame {
    private JTextField arrivedAtJTextField;

    private JTextField parcelIDJTextField;

    private JTextField nameJTextField;

    private JTextField addressJTextField;

    private JTextField cityJTextField;

    private JComboBox<String> stateJComboBox;

    private JTextField zipJTextField;

    // JComboBox, JList and JScrollPane for Parcel number
    private JComboBox<String> parcelStateJComboBox;
    private JList<Object> parcelStateJList;

    // JButtons to manipulate Parcels
    private JButton scanNewJButton;
    private JButton addJButton;
    private JButton removeJButton;
    private JButton editJButton;
    private JButton updateJButton;
    private JButton backJButton;
    private JButton nextJButton;

    // array contains options for stateJComboBox
    private final String[] states = {"AL", "FL", "GA", "KY", "MS", "NC",
            "SC", "TN", "VA", "WV"};

    // Parcel object contains data for newly entered Parcels
    private Parcel newParcel;

    // ArrayList contains Parcels entered by user
    private final ArrayList<Parcel> parcelsArrayList = new ArrayList<>();

    // ArrayList used to modify and display the Parcel objects
    // for a specific state
    private final ArrayList<String> parcelStateArrayList = new ArrayList<>();

    private int parcelID = 0; // ID for new Parcels

    // position used to track location when the user is
    // browsing through the list of Parcels
    private int position = 0;

    // no-argument constructor
    public ShippingHub() {
        createUserInterface();
    }

    // main method
    public static void main(String[] args) {
        ShippingHub application = new ShippingHub();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } // end method main

    // create and position GUI components; register event handlers
    private void createUserInterface() {
        // get content pane for attaching GUI components
        Container contentPane = getContentPane();

        // enable explicit positioning of GUI components
        contentPane.setLayout(null);

        // set up arrivedAtJLabel
        // JLabel and JTextField to display time of arrival
        JLabel arrivedAtJLabel = new JLabel();
        arrivedAtJLabel.setBounds(19, 14, 74, 24);
        arrivedAtJLabel.setText("Arrived at:");
        contentPane.add(arrivedAtJLabel);

        // set up arrivedAtJTextField
        arrivedAtJTextField = new JTextField();
        arrivedAtJTextField.setBounds(89, 14, 207, 21);
        arrivedAtJTextField.setEditable(false);
        contentPane.add(arrivedAtJTextField);

        // set up parcelInformationJPanel
        // JPanel to contain Parcel information
        JPanel parcelInformationJPanel = new JPanel();
        parcelInformationJPanel.setBounds(9, 51, 490, 178);
        parcelInformationJPanel.setBorder(
                new TitledBorder("Parcel Information"));
        parcelInformationJPanel.setLayout(null);
        contentPane.add(parcelInformationJPanel);

        // set up parcelIDJLabel
        // JLabel and JTextField to display Parcel identification number
        JLabel parcelIDJLabel = new JLabel();
        parcelIDJLabel.setBounds(15, 27, 84, 24);
        parcelIDJLabel.setText("Parcel ID:");
        parcelInformationJPanel.add(parcelIDJLabel);

        // set up parcelIDJTextField
        parcelIDJTextField = new JTextField();
        parcelIDJTextField.setBounds(80, 27, 386, 21);
        parcelIDJTextField.setEditable(false);
        parcelInformationJPanel.add(parcelIDJTextField);

        // set up nameJLabel
        // JLabel and JTextField for name
        JLabel nameJLabel = new JLabel();
        nameJLabel.setBounds(15, 65, 66, 25);
        nameJLabel.setText("Name:");
        parcelInformationJPanel.add(nameJLabel);

        // set up nameJTextField
        nameJTextField = new JTextField();
        nameJTextField.setBounds(80, 65, 386, 21);
        nameJTextField.setEditable(false);
        parcelInformationJPanel.add(nameJTextField);

        // set up addressJLabel
        // JLabel and JTextField for address
        JLabel addressJLabel = new JLabel();
        addressJLabel.setBounds(15, 103, 66, 25);
        addressJLabel.setText("Address:");
        parcelInformationJPanel.add(addressJLabel);

        // set up addressJTextField
        addressJTextField = new JTextField();
        addressJTextField.setBounds(80, 103, 386, 21);
        addressJTextField.setEditable(false);
        parcelInformationJPanel.add(addressJTextField);

        // set up cityJLabel
        // JLabel and JTextField for city
        JLabel cityJLabel = new JLabel();
        cityJLabel.setBounds(15, 141, 37, 24);
        cityJLabel.setText("City:");
        parcelInformationJPanel.add(cityJLabel);

        // set up cityJTextField
        cityJTextField = new JTextField();
        cityJTextField.setBounds(80, 141, 117, 21);
        cityJTextField.setEditable(false);
        parcelInformationJPanel.add(cityJTextField);

        // set up stateJLabel
        // JLabel and JTextField for state
        JLabel stateJLabel = new JLabel();
        stateJLabel.setBounds(215, 141, 47, 24);
        stateJLabel.setText("State:");
        parcelInformationJPanel.add(stateJLabel);

        // set up stateJComboBox
        stateJComboBox = new JComboBox<>(states);
        stateJComboBox.setBounds(260, 141, 70, 21);
        stateJComboBox.setEnabled(false);
        parcelInformationJPanel.add(stateJComboBox);

        // set up zipJLabel
        // JLabel and JTextField for zip code
        JLabel zipJLabel = new JLabel();
        zipJLabel.setBounds(355, 141, 28, 24);
        zipJLabel.setText("Zip:");
        parcelInformationJPanel.add(zipJLabel);

        // set up zipJTextField
        zipJTextField = new JTextField();
        zipJTextField.setBounds(390, 141, 76, 21);
        zipJTextField.setEditable(false);
        parcelInformationJPanel.add(zipJTextField);

        // set up parcelStateJPanel
        // JPanel for Parcel number by state
        JPanel parcelStateJPanel = new JPanel();
        parcelStateJPanel.setBounds(508, 51, 136, 178);
        parcelStateJPanel.setBorder(
                new TitledBorder("Parcels by State"));
        parcelStateJPanel.setLayout(null);
        contentPane.add(parcelStateJPanel);

        // set up parcelStateJComboBox
        parcelStateJComboBox = new JComboBox<>(states);
        parcelStateJComboBox.setBounds(19, 29, 98, 21);
        parcelStateJPanel.add(parcelStateJComboBox);
        // anonymous inner class
        // event handler called when parcelStateJComboBox is selected
        parcelStateJComboBox.addActionListener(

                this::parcelStateJComboBoxActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set up parcelStateJList
        parcelStateJList = new JList<>();

        // set up parcelStateJScrollPane
        JScrollPane parcelStateJScrollPane = new JScrollPane(parcelStateJList);
        parcelStateJScrollPane.setBounds(19, 65, 98, 82);
        parcelStateJPanel.add(parcelStateJScrollPane);

        // set up scanNewJButton
        scanNewJButton = new JButton();
        scanNewJButton.setBounds(9, 248, 95, 26);
        scanNewJButton.setText("Scan New");
        scanNewJButton.setMnemonic(KeyEvent.VK_S);
        contentPane.add(scanNewJButton);
        // anonymous inner class
        // event handler called when scanNewJButton is pressed
        scanNewJButton.addActionListener(

                this::scanNewJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set up addJButton
        addJButton = new JButton();
        addJButton.setBounds(109, 248, 85, 26);
        addJButton.setText("Add");
        addJButton.setMnemonic(KeyEvent.VK_A);
        addJButton.setEnabled(false);
        contentPane.add(addJButton);
        // anonymous inner class
        // event handler called when addJButton is pressed
        addJButton.addActionListener(

                this::addJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set up removeJButton
        removeJButton = new JButton();
        removeJButton.setBounds(199, 248, 85, 26);
        removeJButton.setText("Remove");
        removeJButton.setMnemonic(KeyEvent.VK_R);
        removeJButton.setEnabled(false);
        contentPane.add(removeJButton);
        // anonymous inner class
        // event handler called when removeJButton is pressed
        removeJButton.addActionListener(

                this::removeJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set up editJButton
        editJButton = new JButton();
        editJButton.setBounds(289, 248, 85, 26);
        editJButton.setText("Edit");
        editJButton.setMnemonic(KeyEvent.VK_E);
        editJButton.setEnabled(false);
        contentPane.add(editJButton);
        // anonymous inner class
        // event handler called when editJButton is pressed
        editJButton.addActionListener(

                this::editJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set up updateJButton
        updateJButton = new JButton();
        updateJButton.setBounds(379, 248, 85, 26);
        updateJButton.setText("Update");
        updateJButton.setMnemonic(KeyEvent.VK_U);
        updateJButton.setEnabled(false);
        contentPane.add(updateJButton);
        // anonymous inner class
        // event handler called when updateJButton is pressed
        updateJButton.addActionListener(

                this::updateJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set up backJButton
        backJButton = new JButton();
        backJButton.setBounds(469, 248, 85, 26);
        backJButton.setText("< Back");
        backJButton.setMnemonic(KeyEvent.VK_B);
        backJButton.setEnabled(false);
        contentPane.add(backJButton);
        // anonymous inner class
        // event handler called when backJButton is pressed
        backJButton.addActionListener(

                this::backJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set up nextJButton
        nextJButton = new JButton();
        nextJButton.setBounds(559, 248, 85, 26);
        nextJButton.setText("Next >");
        nextJButton.setMnemonic(KeyEvent.VK_N);
        nextJButton.setEnabled(false);
        contentPane.add(nextJButton);
        // anonymous inner class
        // event handler called when nextJButton is pressed
        nextJButton.addActionListener(

                this::nextJButtonActionPerformed // end anonymous inner class

        ); // end call to addActionListener

        // set properties of application's window
        setTitle("Shipping Hub"); // set title bar string
        setSize(665, 320);        // set window size
        setVisible(true);         // display window

    } // end method createUserInterface

    // prepare to scan a new Parcel
    private void scanNewJButtonActionPerformed(ActionEvent event) {
        // clear JTextFields
        clearComponents();

        // set arrival time
        Date now = new Date();
        arrivedAtJTextField.setText(now.toString());

        // give Parcel unique ID number
        parcelID++;
        parcelIDJTextField.setText(String.valueOf(parcelID));

        // create new Parcel object
        newParcel = new Parcel(parcelID,
                arrivedAtJTextField.getText());

        // disable appropriate components
        setJButtons(false);

        // enable or make editable appropriate components
        addJButton.setEnabled(true);
        parcelInformationJPanelEditable(true);

        // grab focus
        nameJTextField.requestFocusInWindow();

    } // end method scanNewJButtonActionPerformed

    // add a new Parcel
    private void addJButtonActionPerformed(ActionEvent event) {
        // set information for new Parcel
        setParcelData();

        // add new Parcel to parcelsArrayList
        parcelsArrayList.add(newParcel);
        position = parcelsArrayList.size() - 1;

        // disable or make uneditable appropriate components
        addJButton.setEnabled(false);
        parcelInformationJPanelEditable(false);

        // enable appropriate components
        setJButtons(true);

        // change selected item in parcelStateJComboBox
        parcelStateJComboBox.setSelectedIndex(
                stateJComboBox.getSelectedIndex());

    } // end method addJButtonActionPerformed

    // remove a Parcel
    private void removeJButtonActionPerformed(ActionEvent event) {
        // retrieve the state of the current Parcel
        String stateSelected = newParcel.getState();

        // if same state is selected, remove ID number from
        // parcelStateJList
        if (stateSelected.equals(
                parcelStateJComboBox.getSelectedItem())) {
            // index of current Parcel
            parcelStateArrayList.remove(String.valueOf(newParcel.getParcelID()));

            // reset JList data
            parcelStateJList.setListData(
                    parcelStateArrayList.toArray());

        } // end if

        // remove current Parcel from ArrayList
        parcelsArrayList.remove(position);

        // load next Parcel in list if there is one
        if (parcelsArrayList.size() > 0) {
            if (position >= parcelsArrayList.size()) {
                position = 0; // go to beginning
            }

            loadParcel();
        } else {
            // if no other Parcels remain
            clearComponents();
        }

        setJButtons(true); // enabled appropriate JButtons

        // set focus to scanNewJButton
        scanNewJButton.requestFocusInWindow();

    } // end method removeJButtonActionPerformed

    // allow user to edit Parcel information
    private void editJButtonActionPerformed(ActionEvent event) {
        // disable appropriate components
        setJButtons(false);

        // make user able to update Parcel information
        updateJButton.setEnabled(true);
        parcelInformationJPanelEditable(true);

    } // end method editJButtonActionPerformed

    // move to next Parcel
    private void updateJButtonActionPerformed(ActionEvent event) {
        setParcelData(); // update information

        // enable or make editable appropriate components
        setJButtons(true);

        // disable or make uneditable appropriate components
        updateJButton.setEnabled(false);
        parcelInformationJPanelEditable(false);

        // change selected item in parcelStateJComboBox
        parcelStateJComboBox.setSelectedIndex(
                stateJComboBox.getSelectedIndex());

    } // end method updateJButtonActionPerformed

    // move to previous Parcel
    private void backJButtonActionPerformed(ActionEvent event) {
        if (position > 0) {
            position--; // move position back by 1
        } else // go to last element in list
        {
            position = parcelsArrayList.size() - 1;
        }

        // set and load Parcel
        loadParcel();

    } // end method backJButtonActionPerformed

    // move to next Parcel
    private void nextJButtonActionPerformed(ActionEvent event) {
        if (position < parcelsArrayList.size() - 1) {
            position++; // move position forward by 1
        } else {
            position = 0; // go to first element in list
        }

        // load information of Parcel
        loadParcel();

    } // end method nextJButtonActionPerformed

    // change the list of Parcels in the parcelStateJList
    private void parcelStateJComboBoxActionPerformed(
            ActionEvent event) {
        // create string to compare states
        String state =
                (String) parcelStateJComboBox.getSelectedItem();

        // create iterator
        Iterator<Parcel> parcelIterator = parcelsArrayList.iterator();

        // clear parcelStateArrayList
        parcelStateArrayList.clear();

        // create parcelStateArrayList with ID numbers of parcels
        // to be displayed
        while (parcelIterator.hasNext()) {
            // create temporary reference to Parcel object
            Parcel currentParcel = parcelIterator.next();

            // add Parcel ID to ArrayList
            assert state != null;
            if (state.equals(currentParcel.getState())) {
                parcelStateArrayList.add(String.valueOf(
                        currentParcel.getParcelID()));
            }

        } // end while

        // display ArrayList in parcelStateJList
        parcelStateJList.setListData(
                parcelStateArrayList.toArray());

    } // end method parcelStateJComboBoxActionPerformed

    // set all information about the Parcel
    private void setParcelData() {
        newParcel.setName(nameJTextField.getText());
        newParcel.setAddress(addressJTextField.getText());
        newParcel.setCity(cityJTextField.getText());
        newParcel.setState(states[
                stateJComboBox.getSelectedIndex()]);
        newParcel.setZip(Integer.parseInt(
                zipJTextField.getText()));

    } // end method setParcelData

    // display all information about the Parcel
    private void loadParcel() {
        // retrieve package from list
        newParcel = parcelsArrayList.get(position);

        // display package data
        arrivedAtJTextField.setText(newParcel.getArrivalTime());
        parcelIDJTextField.setText(
                String.valueOf(newParcel.getParcelID()));
        nameJTextField.setText(newParcel.getName());
        addressJTextField.setText(newParcel.getAddress());
        cityJTextField.setText(newParcel.getCity());
        stateJComboBox.setSelectedItem(newParcel.getState());
        zipJTextField.setText(String.valueOf(newParcel.getZip()));

    } // end method loadParcel

    // clear all information about the Parcel
    private void clearComponents() {
        nameJTextField.setText("");
        addressJTextField.setText("");
        cityJTextField.setText("");
        zipJTextField.setText("");
        arrivedAtJTextField.setText("");
        parcelIDJTextField.setText("");

    } // end method clearComponents

    // enabled/disable JButtons
    private void setJButtons(boolean state) {
        backJButton.setEnabled(state);
        scanNewJButton.setEnabled(state);
        removeJButton.setEnabled(state);
        editJButton.setEnabled(state);
        nextJButton.setEnabled(state);

        // disable navigation if not multiple packages
        if (parcelsArrayList.size() < 2) {
            nextJButton.setEnabled(false);
            backJButton.setEnabled(false);
        }

        // if no items, disable Remove, Edit and Update JButtons
        if (parcelsArrayList.size() == 0) {
            editJButton.setEnabled(false);
            updateJButton.setEnabled(false);
            removeJButton.setEnabled(false);
        }

    } // end method setJButtons

    // make editable or uneditable components
    // in parcelInformationJPanel
    private void parcelInformationJPanelEditable(boolean editable) {
        nameJTextField.setEditable(editable);
        addressJTextField.setEditable(editable);
        cityJTextField.setEditable(editable);
        stateJComboBox.setEnabled(editable);
        zipJTextField.setEditable(editable);

    } // end method parcelInformationJPanelEditable

} // end class ShippingHub

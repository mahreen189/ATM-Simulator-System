package ASimulatorSystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Transactions extends JFrame implements ActionListener {

    // Declare UI components
    private JLabel labelTitle;
    private JButton buttonDeposit, buttonCashWithdrawal, buttonFastCash, buttonMiniStatement, buttonPinChange, buttonBalanceEnquiry, buttonExit;
    private String pin;

    // Constructor
    public Transactions(String pin) {
        this.pin = pin; // Store the user's PIN
        
        // Load and scale the ATM background image
        ImageIcon iconATM = new ImageIcon(ClassLoader.getSystemResource("ASimulatorSystem/icons/atm.jpg"));
        Image scaledATM = iconATM.getImage().getScaledInstance(800, 600, Image.SCALE_DEFAULT); // Resize image
        ImageIcon iconScaledATM = new ImageIcon(scaledATM);
        JLabel labelBackground = new JLabel(iconScaledATM);
        labelBackground.setBounds(0, 0, 800, 600); // Adjust image bounds
        add(labelBackground);

        // Initialize and style the title label
        labelTitle = new JLabel("Please Select Your Transaction");
        labelTitle.setForeground(Color.WHITE);
        labelTitle.setFont(new Font("System", Font.BOLD, 18));

        // Initialize buttons with respective labels
        buttonDeposit = new JButton("DEPOSIT");
        buttonCashWithdrawal = new JButton("CASH WITHDRAWAL");
        buttonFastCash = new JButton("FAST CASH");
        buttonMiniStatement = new JButton("MINI STATEMENT");
        buttonPinChange = new JButton("PIN CHANGE");
        buttonBalanceEnquiry = new JButton("BALANCE ENQUIRY");
        buttonExit = new JButton("EXIT");

        // Set layout to null for absolute positioning
        setLayout(null);

        // Adjust label position and add to background
        labelTitle.setBounds(175, 145, 390, 35);
        labelBackground.add(labelTitle);

        // Adjust button positions and add to background
        buttonDeposit.setBounds(150, 200, 130, 30);
        labelBackground.add(buttonDeposit);

        buttonCashWithdrawal.setBounds(310, 200, 130, 30);
        labelBackground.add(buttonCashWithdrawal);

        buttonFastCash.setBounds(150, 240, 130, 30);
        labelBackground.add(buttonFastCash);

        buttonMiniStatement.setBounds(310, 240, 130, 30);
        labelBackground.add(buttonMiniStatement);

        buttonPinChange.setBounds(150, 280, 130, 30);
        labelBackground.add(buttonPinChange);

        buttonBalanceEnquiry.setBounds(310, 280, 130, 30);
        labelBackground.add(buttonBalanceEnquiry);

        buttonExit.setBounds(230, 320, 130, 30);
        labelBackground.add(buttonExit);

        // Add action listeners to the buttons
        buttonDeposit.addActionListener(this);
        buttonCashWithdrawal.addActionListener(this);
        buttonFastCash.addActionListener(this);
        buttonMiniStatement.addActionListener(this);
        buttonPinChange.addActionListener(this);
        buttonBalanceEnquiry.addActionListener(this);
        buttonExit.addActionListener(this);

        // Set frame properties
        setSize(800, 600); // Adjust frame size
        setLocation(300, 100); // Center the frame
        setVisible(true);
    }

    // Handle button click events
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == buttonDeposit) {
            setVisible(false);
            new Deposit(pin).setVisible(true);
        } else if (event.getSource() == buttonCashWithdrawal) {
            setVisible(false);
            new Withdrawl(pin).setVisible(true);
        } else if (event.getSource() == buttonFastCash) {
            setVisible(false);
            new FastCash(pin).setVisible(true);
        } else if (event.getSource() == buttonMiniStatement) {
            new MiniStatement(pin).setVisible(true);
        } else if (event.getSource() == buttonPinChange) {
            setVisible(false);
            new Pin(pin).setVisible(true);
        } else if (event.getSource() == buttonBalanceEnquiry) {
            setVisible(false);
            new BalanceEnquiry(pin).setVisible(true);
        } else if (event.getSource() == buttonExit) {
            System.exit(0); // Exit the application
        }
    }

    // Main method to run the application
    public static void main(String[] args) {
        new Transactions("").setVisible(true);
    }
}
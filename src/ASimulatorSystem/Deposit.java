package ASimulatorSystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Deposit extends JFrame implements ActionListener {

    JTextField amountTextField;
    JButton depositButton, backButton;
    JLabel promptLabel;
    String pin;

    Deposit(String pin) {
        this.pin = pin;

        // Load and resize the ATM background image
        ImageIcon originalIcon = new ImageIcon(ClassLoader.getSystemResource("ASimulatorSystem/icons/atm.jpg"));
        Image scaledImage = originalIcon.getImage().getScaledInstance(800, 600, Image.SCALE_DEFAULT);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        JLabel backgroundLabel = new JLabel(scaledIcon);
        backgroundLabel.setBounds(0, 0, 800, 600);
        add(backgroundLabel);

        // Initialize the prompt label
        promptLabel = new JLabel("ENTER AMOUNT YOU WANT TO DEPOSIT");
        promptLabel.setForeground(Color.WHITE);
        promptLabel.setFont(new Font("System", Font.BOLD, 18));

        // Initialize the text field for entering the amount
        amountTextField = new JTextField();
        amountTextField.setFont(new Font("Raleway", Font.BOLD, 18));

        // Initialize the buttons
        depositButton = new JButton("DEPOSIT");
        backButton = new JButton("BACK");

        setLayout(null);

        // Adjust label position
        promptLabel.setBounds(125, 145, 380, 35);
        backgroundLabel.add(promptLabel);

        // Adjust text field position
        amountTextField.setBounds(160, 230, 280, 25);
        backgroundLabel.add(amountTextField);

        // Adjust button positions
        depositButton.setBounds(160, 300, 130, 30);
        backgroundLabel.add(depositButton);

        backButton.setBounds(305, 300, 130, 30);
        backgroundLabel.add(backButton);

        // Add action listeners to buttons
        depositButton.addActionListener(this);
        backButton.addActionListener(this);

        setSize(800, 600); // Adjust frame size
        setLocation(300, 100); // Set frame location
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            String amount = amountTextField.getText();
            Date date = new Date();
            if (ae.getSource() == depositButton) {
                if (amountTextField.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter the Amount you want to Deposit");
                } else {
                    Conn connection = new Conn();
                    connection.s.executeUpdate("insert into bank values('" + pin + "', '" + date + "', 'Deposit', '" + amount + "')");
                    JOptionPane.showMessageDialog(null, "Rs. " + amount + " Deposited Successfully");
                    setVisible(false);
                    new Transactions(pin).setVisible(true);
                }
            } else if (ae.getSource() == backButton) {
                setVisible(false);
                new Transactions(pin).setVisible(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Deposit("").setVisible(true);
    }
}
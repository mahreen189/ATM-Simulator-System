package ASimulatorSystem;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;

class BalanceEnquiry extends JFrame implements ActionListener {

    JButton backButton;
    JLabel balanceLabel;
    String pin;

    BalanceEnquiry(String pin) {
        this.pin = pin;

        // Load and resize the ATM background image
        ImageIcon originalIcon = new ImageIcon(ClassLoader.getSystemResource("ASimulatorSystem/icons/atm.jpg"));
        Image scaledImage = originalIcon.getImage().getScaledInstance(800, 600, Image.SCALE_DEFAULT);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        JLabel backgroundLabel = new JLabel(scaledIcon);
        backgroundLabel.setBounds(0, 0, 800, 600); // Adjust image bounds
        add(backgroundLabel);

        // Initialize the balance label
        balanceLabel = new JLabel();
        balanceLabel.setForeground(Color.WHITE);
        balanceLabel.setFont(new Font("System", Font.BOLD, 16));

        // Initialize the back button
        backButton = new JButton("BACK");

        setLayout(null);

        // Adjust label position
        balanceLabel.setBounds(140, 210, 550, 35);
        backgroundLabel.add(balanceLabel);

        // Adjust button position
        backButton.setBounds(230, 300, 130, 30);
        backgroundLabel.add(backButton);

        int balance = 0;

        // Fetch the current balance from the database
        try {
            Conn connection = new Conn();
            ResultSet resultSet = connection.s.executeQuery("select * from bank where pin = '" + pin + "'");
            while (resultSet.next()) {
                if (resultSet.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(resultSet.getString("amount"));
                } else {
                    balance -= Integer.parseInt(resultSet.getString("amount"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Display the current balance
        balanceLabel.setText("Your Current Account Balance is Rs " + balance);

        // Add action listener to the back button
        backButton.addActionListener(this);

        setSize(800, 600); // Adjust frame size
        setLocation(300, 100); // Center the frame
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        // Hide the current window and open the Transactions window
        setVisible(false);
        new Transactions(pin).setVisible(true);
    }

    public static void main(String[] args) {
        new BalanceEnquiry("").setVisible(true);
    }
}
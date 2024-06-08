package ASimulatorSystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {

    JLabel selectAmountLabel;
    JButton amount100Button, amount500Button, amount1000Button, amount2000Button, amount5000Button, amount10000Button, backButton;
    String pin;

    FastCash(String pin) {
        this.pin = pin;
        
        // Load and resize the ATM background image
        ImageIcon originalIcon = new ImageIcon(ClassLoader.getSystemResource("ASimulatorSystem/icons/atm.jpg"));
        Image scaledImage = originalIcon.getImage().getScaledInstance(800, 600, Image.SCALE_DEFAULT);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        JLabel backgroundLabel = new JLabel(scaledIcon);
        backgroundLabel.setBounds(0, 0, 800, 600);
        add(backgroundLabel);

        // Initialize the label
        selectAmountLabel = new JLabel("SELECT WITHDRAWAL AMOUNT");
        selectAmountLabel.setForeground(Color.WHITE);
        selectAmountLabel.setFont(new Font("System", Font.BOLD, 18));

        // Initialize the buttons
        amount100Button = new JButton("Rs 100");
        amount500Button = new JButton("Rs 500");
        amount1000Button = new JButton("Rs 1000");
        amount2000Button = new JButton("Rs 2000");
        amount5000Button = new JButton("Rs 5000");
        amount10000Button = new JButton("Rs 10000");
        backButton = new JButton("BACK");

        setLayout(null);

        // Adjust label position
        selectAmountLabel.setBounds(150, 145, 300, 35);
        backgroundLabel.add(selectAmountLabel);

        // Adjust button positions
        amount100Button.setBounds(150, 200, 150, 35);
        backgroundLabel.add(amount100Button);

        amount500Button.setBounds(310, 200, 150, 35);
        backgroundLabel.add(amount500Button);

        amount1000Button.setBounds(150, 240, 150, 35);
        backgroundLabel.add(amount1000Button);

        amount2000Button.setBounds(310, 240, 150, 35);
        backgroundLabel.add(amount2000Button);

        amount5000Button.setBounds(150, 280, 150, 35);
        backgroundLabel.add(amount5000Button);

        amount10000Button.setBounds(310, 280, 150, 35);
        backgroundLabel.add(amount10000Button);

        backButton.setBounds(230, 325, 150, 35);
        backgroundLabel.add(backButton);

        // Add action listeners to buttons
        amount100Button.addActionListener(this);
        amount500Button.addActionListener(this);
        amount1000Button.addActionListener(this);
        amount2000Button.addActionListener(this);
        amount5000Button.addActionListener(this);
        amount10000Button.addActionListener(this);
        backButton.addActionListener(this);

        setSize(800, 600); // Adjust frame size
        setLocation(300, 100); // Set frame location
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            // Get the amount from the button text
            String amount = ((JButton)ae.getSource()).getText().substring(3);
            Conn connection = new Conn();
            ResultSet rs = connection.s.executeQuery("select * from bank where pin = '" + pin + "'");
            int balance = 0;

            // Calculate current balance
            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }

            // Check if balance is sufficient for withdrawal
            if (ae.getSource() != backButton && balance < Integer.parseInt(amount)) {
                JOptionPane.showMessageDialog(null, "Insufficient Balance");
                return;
            }

            // Handle BACK button action
            if (ae.getSource() == backButton) {
                this.setVisible(false);
                new Transactions(pin).setVisible(true);
            } else {
                // Handle withdrawal action
                Date date = new Date();
                connection.s.executeUpdate("insert into bank values('" + pin + "', '" + date + "', 'Withdrawal', '" + amount + "')");
                JOptionPane.showMessageDialog(null, "Rs. " + amount + " Debited Successfully");
                    
                setVisible(false);
                new Transactions(pin).setVisible(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new FastCash("").setVisible(true);
    }
}
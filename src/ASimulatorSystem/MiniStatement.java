package ASimulatorSystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class MiniStatement extends JFrame implements ActionListener {
 
    JButton exitButton;
    JLabel statementLabel, bankNameLabel, cardNumberLabel, balanceLabel;

    MiniStatement(String pin) {
        super("Mini Statement");
        getContentPane().setBackground(Color.WHITE); // Set background color to white
        setSize(400, 600); // Set frame size
        setLocation(20, 20); // Set frame location
        
        statementLabel = new JLabel(); // Label to display transaction details
        add(statementLabel);
        
        bankNameLabel = new JLabel("Pakistan Bank"); // Label to display bank name
        bankNameLabel.setBounds(150, 20, 100, 20);
        add(bankNameLabel);
        
        cardNumberLabel = new JLabel(); // Label to display card number
        cardNumberLabel.setBounds(20, 80, 300, 20);
        add(cardNumberLabel);
        
        balanceLabel = new JLabel(); // Label to display total balance
        balanceLabel.setBounds(20, 400, 300, 20);
        add(balanceLabel);
        
        try {
            // Fetch card number from the database
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from login where pin = '" + pin + "'");
            while (rs.next()) {
                cardNumberLabel.setText("Card Number:    " + rs.getString("cardnumber").substring(0, 4) + "XXXXXXXX" + rs.getString("cardnumber").substring(12));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        	 
        try {
            int balance = 0;
            // Fetch transactions from the database
            Conn conn1 = new Conn();
            ResultSet rs = conn1.s.executeQuery("SELECT * FROM bank where pin = '" + pin + "'");
            while (rs.next()) {
                statementLabel.setText(statementLabel.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
            balanceLabel.setText("Your total Balance is Rs " + balance);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        setLayout(null); // Set layout to null
        exitButton = new JButton("Exit"); // Button to exit the statement
        add(exitButton);
        
        exitButton.addActionListener(this); // Add action listener to exit button
        
        // Set bounds for components
        statementLabel.setBounds(20, 140, 400, 200);
        exitButton.setBounds(20, 500, 100, 25);
    }

    public void actionPerformed(ActionEvent ae) {
        this.setVisible(false); // Hide the frame when the exit button is pressed
    }
    
    public static void main(String[] args) {
        new MiniStatement("").setVisible(true); // Create and display the frame
    }
}
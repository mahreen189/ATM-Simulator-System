package ASimulatorSystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Pin extends JFrame implements ActionListener {

    // Declare password fields, buttons, labels, and pin string
    JPasswordField newPinField, reenterPinField;
    JButton changeButton, backButton;
    JLabel titleLabel, newPinLabel, reenterPinLabel;
    String currentPin;

    // Constructor
    Pin(String currentPin) {
        this.currentPin = currentPin;

        // Load and scale the background image
        ImageIcon originalIcon = new ImageIcon(ClassLoader.getSystemResource("ASimulatorSystem/icons/atm.jpg"));
        Image scaledImage = originalIcon.getImage().getScaledInstance(800, 600, Image.SCALE_DEFAULT);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        JLabel backgroundLabel = new JLabel(scaledIcon);
        backgroundLabel.setBounds(0, 0, 800, 600); // Set bounds for the image
        add(backgroundLabel);

        // Initialize and configure labels
        titleLabel = new JLabel("CHANGE YOUR PIN");
        titleLabel.setFont(new Font("System", Font.BOLD, 16));
        titleLabel.setForeground(Color.WHITE);

        newPinLabel = new JLabel("New PIN:");
        newPinLabel.setFont(new Font("System", Font.BOLD, 15));
        newPinLabel.setForeground(Color.WHITE);

        reenterPinLabel = new JLabel("Re-Enter New PIN:");
        reenterPinLabel.setFont(new Font("System", Font.BOLD, 15));
        reenterPinLabel.setForeground(Color.WHITE);

        // Initialize password fields
        newPinField = new JPasswordField();
        newPinField.setFont(new Font("Raleway", Font.BOLD, 25));

        reenterPinField = new JPasswordField();
        reenterPinField.setFont(new Font("Raleway", Font.BOLD, 25));

        // Initialize buttons
        changeButton = new JButton("CHANGE");
        backButton = new JButton("BACK");

        // Add action listeners to the buttons
        changeButton.addActionListener(this);
        backButton.addActionListener(this);

        // Set layout to null for absolute positioning
        setLayout(null);

        // Adjust positions of components to fit the layout
        titleLabel.setBounds(220, 145, 400, 35);
        backgroundLabel.add(titleLabel);

        newPinLabel.setBounds(150, 210, 150, 35);
        backgroundLabel.add(newPinLabel);

        reenterPinLabel.setBounds(150, 250, 200, 35);
        backgroundLabel.add(reenterPinLabel);

        newPinField.setBounds(300, 215, 150, 20);
        backgroundLabel.add(newPinField);

        reenterPinField.setBounds(300, 255, 150, 20);
        backgroundLabel.add(reenterPinField);

        changeButton.setBounds(150, 300, 140, 35);
        backgroundLabel.add(changeButton);

        backButton.setBounds(300, 300, 140, 35);
        backgroundLabel.add(backButton);

        // Configure the frame
        setSize(800, 600); // Set frame size
        setLocation(300, 100); // Center the frame
        setVisible(true);
    }

    // Handle button click events
    public void actionPerformed(ActionEvent ae) {
        try {
            // Get the new PIN and re-entered PIN values
            String newPin = new String(newPinField.getPassword());
            String reenterPin = new String(reenterPinField.getPassword());

            // Check if the new PIN and re-entered PIN match
            if (!newPin.equals(reenterPin)) {
                JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                return;
            }

            if (ae.getSource() == changeButton) {
                // Validate that the new PIN fields are not empty
                if (newPin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Enter New PIN");
                }
                if (reenterPin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Re-Enter new PIN");
                }

                // Update PIN in the database
                Conn dbConnection = new Conn();
                String query1 = "update bank set pin = '" + reenterPin + "' where pin = '" + currentPin + "' ";
                String query2 = "update login set pin = '" + reenterPin + "' where pin = '" + currentPin + "' ";
                String query3 = "update signup3 set pin = '" + reenterPin + "' where pin = '" + currentPin + "' ";

                dbConnection.s.executeUpdate(query1);
                dbConnection.s.executeUpdate(query2);
                dbConnection.s.executeUpdate(query3);

                // Notify the user and navigate to the Transactions page
                JOptionPane.showMessageDialog(null, "PIN changed successfully");
                setVisible(false);
                new Transactions(reenterPin).setVisible(true);

            } else if (ae.getSource() == backButton) {
                // Navigate to the Transactions page without changing the PIN
                new Transactions(currentPin).setVisible(true);
                setVisible(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Main method to run the application
    public static void main(String[] args) {
        new Pin("").setVisible(true);
    }
}

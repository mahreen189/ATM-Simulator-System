package ASimulatorSystem;

import java.awt.*; // Importing classes for handling image.
import java.awt.event.*; // Importing classes for handling events like button clicks.
import javax.swing.*; // Importing Swing components for GUI.
import java.sql.*; // Importing classes for handling SQL operations.

public class Login extends JFrame implements ActionListener { // Implementing ActionListener to handle button click events.
    JLabel labelWelcome, labelCardNumber, labelPin;
    JTextField textFieldCardNumber;
    JPasswordField passwordFieldPin;
    JButton buttonSignIn, buttonClear, buttonSignUp;
  
    Login() {
        setTitle("AUTOMATED TELLER MACHINE");

        // Loading the image from the system resources and scaling it.
        ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("ASimulatorSystem/icons/logo.jpg"));
        Image image = icon1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon icon2 = new ImageIcon(image); // Converting the image back to ImageIcon. b/c frame cant take image directly
        JLabel labelIcon = new JLabel(icon2); // Adding the icon to a JLabel.
        labelIcon.setBounds(70, 10, 100, 100); // Setting the position and size of the icon.
        add(labelIcon);
        
        labelWelcome = new JLabel("WELCOME TO ATM"); // Creating a welcome label.
        labelWelcome.setFont(new Font("Osward", Font.BOLD, 38)); // Setting font style and size.
        labelWelcome.setBounds(200, 40, 450, 40); // Setting position and size.
        add(labelWelcome);
        
        labelCardNumber = new JLabel("Card No:"); // Creating a label for card number.
        labelCardNumber.setFont(new Font("Raleway", Font.BOLD, 28)); // Setting font style and size.
        labelCardNumber.setBounds(125, 150, 375, 30); // Setting position and size.
        add(labelCardNumber);
        
        textFieldCardNumber = new JTextField(15); // Creating a text field for card number input.
        textFieldCardNumber.setBounds(300, 150, 230, 30); // Setting position and size.
        textFieldCardNumber.setFont(new Font("Arial", Font.BOLD, 14)); // Setting font style and size.
        add(textFieldCardNumber);
        
        labelPin = new JLabel("PIN:"); // Creating a label for PIN.
        labelPin.setFont(new Font("Raleway", Font.BOLD, 28)); // Setting font style and size.
        labelPin.setBounds(125, 220, 375, 30); // Setting position and size.
        add(labelPin);
        
        passwordFieldPin = new JPasswordField(15); // Creating a password field for PIN input.
        passwordFieldPin.setFont(new Font("Arial", Font.BOLD, 14)); // Setting font style and size.
        passwordFieldPin.setBounds(300, 220, 230, 30); // Setting position and size.
        add(passwordFieldPin);
                
        buttonSignIn = new JButton("SIGN IN"); // Creating a sign-in button.
        buttonSignIn.setBackground(Color.BLACK); // Setting background color.
        buttonSignIn.setForeground(Color.WHITE); // Setting foreground color.
        
        buttonClear = new JButton("CLEAR"); // Creating a clear button.
        buttonClear.setBackground(Color.BLACK); // Setting background color.
        buttonClear.setForeground(Color.WHITE); // Setting foreground color.
        
        buttonSignUp = new JButton("SIGN UP"); // Creating a sign-up button.
        buttonSignUp.setBackground(Color.BLACK); // Setting background color.
        buttonSignUp.setForeground(Color.WHITE); // Setting foreground color.
        
        setLayout(null); // Using no layout manager, absolute positioning.
        
        buttonSignIn.setFont(new Font("Arial", Font.BOLD, 14)); // Setting font style and size.
        buttonSignIn.setBounds(300, 300, 100, 30); // Setting position and size.
        add(buttonSignIn);
        
        buttonClear.setFont(new Font("Arial", Font.BOLD, 14)); // Setting font style and size.
        buttonClear.setBounds(430, 300, 100, 30); // Setting position and size.
        add(buttonClear);
        
        buttonSignUp.setFont(new Font("Arial", Font.BOLD, 14)); // Setting font style and size.
        buttonSignUp.setBounds(300, 350, 230, 30); // Setting position and size.
        add(buttonSignUp);
        
        // Adding action listeners to the buttons.
        buttonSignIn.addActionListener(this);
        buttonClear.addActionListener(this);
        buttonSignUp.addActionListener(this);
        
        getContentPane().setBackground(Color.WHITE); // Setting background color of the frame.
    
        // Frame properties:
        setSize(800, 480); // Setting size of the frame.
        setLocation(300, 150); // Setting the initial position of the frame.
        setVisible(true); // Making the frame visible.
    }
    
    public void actionPerformed(ActionEvent ae) { // Handling button click events.
        try {        
            if (ae.getSource() == buttonSignIn) {
                Conn connection = new Conn();
                String cardNumber = textFieldCardNumber.getText();
                String pin = passwordFieldPin.getText(); // Getting the PIN from the password field.
                String query = "select * from login where cardnumber = '" + cardNumber + "' and pin = '" + pin + "'";

                // Executing the query and storing the result.
                ResultSet resultSet = connection.s.executeQuery(query);
                if (resultSet.next()) {
                    setVisible(false);
                    new Transactions(pin).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN");
                }
            } else if (ae.getSource() == buttonClear) {
                textFieldCardNumber.setText(""); // Clearing the card number field.
                passwordFieldPin.setText(""); // Clearing the PIN field.
            } else if (ae.getSource() == buttonSignUp) {
                setVisible(false);
                new Signup().setVisible(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        new Login().setVisible(true); // Creating and displaying the login frame.
    }
}

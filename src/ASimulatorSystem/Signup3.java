package ASimulatorSystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;

public class Signup3 extends JFrame implements ActionListener {
    
    // Declare UI components
    private JLabel labelPageTitle, labelAccountType, labelCardNumber, labelCardNumberValue, labelCardNumberHint, labelCardNumberNote;
    private JLabel labelPin, labelPinValue, labelPinHint, labelServicesRequired, labelFormNo, labelFormNoValue;
    private JRadioButton radioSavingAccount, radioFixedDepositAccount, radioCurrentAccount, radioRecurringDepositAccount;
    private JButton buttonSubmit, buttonCancel;
    private JCheckBox checkBoxATM, checkBoxInternetBanking, checkBoxMobileBanking, checkBoxEmailAlerts, checkBoxChequeBook, checkBoxEStatement, checkBoxDeclaration;
    private String formNumber;
    
    // Constructor
    public Signup3(String formNumber) {
        this.formNumber = formNumber;
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 3");
    
        // Load and set the logo image
        ImageIcon iconLogo = new ImageIcon(ClassLoader.getSystemResource("ASimulatorSystem/icons/logo.jpg"));
        Image scaledLogo = iconLogo.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon iconScaledLogo = new ImageIcon(scaledLogo);
        JLabel labelLogo = new JLabel(iconScaledLogo);
        labelLogo.setBounds(150, 0, 100, 100);
        add(labelLogo);
        
        // Initialize labels
        labelPageTitle = new JLabel("Page 3: Account Details");
        labelPageTitle.setFont(new Font("Raleway", Font.BOLD, 22));
        
        labelAccountType = new JLabel("Account Type:");
        labelAccountType.setFont(new Font("Raleway", Font.BOLD, 18));
        
        labelCardNumber = new JLabel("Card Number:");
        labelCardNumber.setFont(new Font("Raleway", Font.BOLD, 18));
        
        labelCardNumberValue = new JLabel("XXXX-XXXX-XXXX-4184");
        labelCardNumberValue.setFont(new Font("Raleway", Font.BOLD, 18));
        
        labelCardNumberHint = new JLabel("(Your 16-digit Card number)");
        labelCardNumberHint.setFont(new Font("Raleway", Font.BOLD, 12));
        
        labelCardNumberNote = new JLabel("It would appear on ATM Card/Cheque Book and Statements");
        labelCardNumberNote.setFont(new Font("Raleway", Font.BOLD, 12));
        
        labelPin = new JLabel("PIN:");
        labelPin.setFont(new Font("Raleway", Font.BOLD, 18));
        
        labelPinValue = new JLabel("XXXX");
        labelPinValue.setFont(new Font("Raleway", Font.BOLD, 18));
    
        labelPinHint = new JLabel("(4-digit password)");
        labelPinHint.setFont(new Font("Raleway", Font.BOLD, 12));
    
        labelServicesRequired = new JLabel("Services Required:");
        labelServicesRequired.setFont(new Font("Raleway", Font.BOLD, 18));
        
        labelFormNo = new JLabel("Form No:");
        labelFormNo.setFont(new Font("Raleway", Font.BOLD, 14));
        
        labelFormNoValue = new JLabel(formNumber);
        labelFormNoValue.setFont(new Font("Raleway", Font.BOLD, 14));
        
        // Initialize buttons
        buttonSubmit = new JButton("Submit");
        buttonSubmit.setFont(new Font("Raleway", Font.BOLD, 14));
        buttonSubmit.setBackground(Color.BLACK);
        buttonSubmit.setForeground(Color.WHITE);
        
        buttonCancel = new JButton("Cancel");
        buttonCancel.setFont(new Font("Raleway", Font.BOLD, 14));
        buttonCancel.setBackground(Color.BLACK);
        buttonCancel.setForeground(Color.WHITE);
        
        // Initialize checkboxes
        checkBoxATM = new JCheckBox("ATM CARD");
        checkBoxATM.setBackground(Color.WHITE);
        checkBoxATM.setFont(new Font("Raleway", Font.BOLD, 16));
        
        checkBoxInternetBanking = new JCheckBox("Internet Banking");
        checkBoxInternetBanking.setBackground(Color.WHITE);
        checkBoxInternetBanking.setFont(new Font("Raleway", Font.BOLD, 16));
        
        checkBoxMobileBanking = new JCheckBox("Mobile Banking");
        checkBoxMobileBanking.setBackground(Color.WHITE);
        checkBoxMobileBanking.setFont(new Font("Raleway", Font.BOLD, 16));
        
        checkBoxEmailAlerts = new JCheckBox("EMAIL Alerts");
        checkBoxEmailAlerts.setBackground(Color.WHITE);
        checkBoxEmailAlerts.setFont(new Font("Raleway", Font.BOLD, 16));
        
        checkBoxChequeBook = new JCheckBox("Cheque Book");
        checkBoxChequeBook.setBackground(Color.WHITE);
        checkBoxChequeBook.setFont(new Font("Raleway", Font.BOLD, 16));
        
        checkBoxEStatement = new JCheckBox("E-Statement");
        checkBoxEStatement.setBackground(Color.WHITE);
        checkBoxEStatement.setFont(new Font("Raleway", Font.BOLD, 16));
        
        checkBoxDeclaration = new JCheckBox("I hereby declare that the above entered details are correct to the best of my knowledge.", true);
        checkBoxDeclaration.setBackground(Color.WHITE);
        checkBoxDeclaration.setFont(new Font("Raleway", Font.BOLD, 12));
        
        // Initialize radio buttons
        radioSavingAccount = new JRadioButton("Saving Account");
        radioSavingAccount.setFont(new Font("Raleway", Font.BOLD, 16));
        radioSavingAccount.setBackground(Color.WHITE);
        
        radioFixedDepositAccount = new JRadioButton("Fixed Deposit Account");
        radioFixedDepositAccount.setFont(new Font("Raleway", Font.BOLD, 16));
        radioFixedDepositAccount.setBackground(Color.WHITE);
        
        radioCurrentAccount = new JRadioButton("Current Account");
        radioCurrentAccount.setFont(new Font("Raleway", Font.BOLD, 16));
        radioCurrentAccount.setBackground(Color.WHITE);
        
        radioRecurringDepositAccount = new JRadioButton("Recurring Deposit Account");
        radioRecurringDepositAccount.setFont(new Font("Raleway", Font.BOLD, 16));
        radioRecurringDepositAccount.setBackground(Color.WHITE);
        
        // Group radio buttons
        ButtonGroup accountTypeGroup = new ButtonGroup();
        accountTypeGroup.add(radioSavingAccount);
        accountTypeGroup.add(radioFixedDepositAccount);
        accountTypeGroup.add(radioCurrentAccount);
        accountTypeGroup.add(radioRecurringDepositAccount);
        
        // Set layout to null for absolute positioning
        setLayout(null);
        
        // Set bounds and add components to the frame
        labelFormNo.setBounds(700, 10, 70, 30);
        add(labelFormNo);
        
        labelFormNoValue.setBounds(770, 10, 40, 30);
        add(labelFormNoValue);
        
        labelPageTitle.setBounds(280, 40, 400, 40);
        add(labelPageTitle);
        
        labelAccountType.setBounds(100, 140, 200, 30);
        add(labelAccountType);
        
        radioSavingAccount.setBounds(100, 180, 150, 30);
        add(radioSavingAccount);
        
        radioFixedDepositAccount.setBounds(350, 180, 300, 30);
        add(radioFixedDepositAccount);
        
        radioCurrentAccount.setBounds(100, 220, 250, 30);
        add(radioCurrentAccount);
        
        radioRecurringDepositAccount.setBounds(350, 220, 250, 30);
        add(radioRecurringDepositAccount);
        
        labelCardNumber.setBounds(100, 300, 200, 30);
        add(labelCardNumber);
        
        labelCardNumberValue.setBounds(330, 300, 250, 30);
        add(labelCardNumberValue);
        
        labelCardNumberHint.setBounds(100, 330, 200, 20);
        add(labelCardNumberHint);
        
        labelCardNumberNote.setBounds(330, 330, 500, 20);
        add(labelCardNumberNote);
        
        labelPin.setBounds(100, 370, 200, 30);
        add(labelPin);
        
        labelPinValue.setBounds(330, 370, 200, 30);
        add(labelPinValue);
        
        labelPinHint.setBounds(100, 400, 200, 20);
        add(labelPinHint);
        
        labelServicesRequired.setBounds(100, 450, 200, 30);
        add(labelServicesRequired);
        
        checkBoxATM.setBounds(100, 500, 200, 30);
        add(checkBoxATM);
        
        checkBoxInternetBanking.setBounds(350, 500, 200, 30);
        add(checkBoxInternetBanking);
        
        checkBoxMobileBanking.setBounds(100, 550, 200, 30);
        add(checkBoxMobileBanking);
        
        checkBoxEmailAlerts.setBounds(350, 550, 200, 30);
        add(checkBoxEmailAlerts);
        
        checkBoxChequeBook.setBounds(100, 600, 200, 30);
        add(checkBoxChequeBook);
        
        checkBoxEStatement.setBounds(350, 600, 200, 30);
        add(checkBoxEStatement);
        
        checkBoxDeclaration.setBounds(100, 630, 600, 20);
        add(checkBoxDeclaration);
        
        buttonSubmit.setBounds(250, 660, 100, 30);
        add(buttonSubmit);
        
        buttonCancel.setBounds(100, 660, 100, 30);
        add(buttonCancel);
        
        // Set background color and frame properties
        getContentPane().setBackground(Color.WHITE);
        
        setSize(850, 850);
        setLocation(250, 0);
        setVisible(true);
        
        // Add action listeners
        buttonSubmit.addActionListener(this);
        buttonCancel.addActionListener(this);
    }
    
    // Handle button click events
    public void actionPerformed(ActionEvent event) {
        String accountType = null;
        if (radioSavingAccount.isSelected()) { 
            accountType = "Saving Account";
        } else if (radioFixedDepositAccount.isSelected()) { 
            accountType = "Fixed Deposit Account";
        } else if (radioCurrentAccount.isSelected()) { 
            accountType = "Current Account";
        } else if (radioRecurringDepositAccount.isSelected()) { 
            accountType = "Recurring Deposit Account";
        }
        
        // Generate random card number and PIN
        Random random = new Random();
        long first7Digits = (random.nextLong() % 90000000L) + 5040936000000000L;
        String cardNumber = "" + Math.abs(first7Digits);
        
        long first3Digits = (random.nextLong() % 9000L) + 1000L;
        String pin = "" + Math.abs(first3Digits);
        
        // Collect selected facilities
        String facility = "";
        if (checkBoxATM.isSelected()) { 
            facility += " ATM Card";
        }
        if (checkBoxInternetBanking.isSelected()) { 
            facility += " Internet Banking";
        }
        if (checkBoxMobileBanking.isSelected()) { 
            facility += " Mobile Banking";
        }
        if (checkBoxEmailAlerts.isSelected()) { 
            facility += " EMAIL Alerts";
        }
        if (checkBoxChequeBook.isSelected()) { 
            facility += " Cheque Book";
        }
        if (checkBoxEStatement.isSelected()) { 
            facility += " E-Statement";
        }
        
        try {
            if (event.getSource() == buttonSubmit) {
                if (accountType == null) {
                    JOptionPane.showMessageDialog(null, "Fill all the required fields");
                } else {
                    Conn connection = new Conn();
                    String query1 = "insert into signup3 values('" + formNumber + "','" + accountType + "','" + cardNumber + "','" + pin + "','" + facility + "')";  
                    String query2 = "insert into login values('" + formNumber + "','" + cardNumber + "','" + pin + "')";
                    connection.s.executeUpdate(query1);
                    connection.s.executeUpdate(query2);
                    JOptionPane.showMessageDialog(null, "Card Number: " + cardNumber + "\n Pin: " + pin);
                    
                    new Deposit(pin).setVisible(true);
                    setVisible(false);
                }
            } else if (event.getSource() == buttonCancel) {
                System.exit(0);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    // Main method to run the application
    public static void main(String[] args) {
        new Signup3("").setVisible(true);
    }
}
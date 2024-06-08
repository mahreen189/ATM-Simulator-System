package ASimulatorSystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser; // Calendar import for date chooser
import java.util.*;

public class Signup extends JFrame implements ActionListener {

    // Declaring all the components as global variables
    JLabel labelFormNumber, labelPageTitle, labelName, labelFathersName, labelDob, labelGender, labelEmail, labelMaritalStatus, labelAddress, labelCity, labelPinCode, labelState, labelDate, labelMonth, labelYear;
    JTextField textName, textFathersName, textEmail, textAddress, textCity, textPinCode, textState;
    JRadioButton radioMale, radioFemale, radioMarried, radioUnmarried, radioOther;
    JButton buttonNext;
    JDateChooser dateChooser;
    
    Random random = new Random();
    long first4 = (random.nextLong() % 9000L) + 1000L; // Generating a random 4-digit number
    String formNumber = "" + Math.abs(first4); // Converting the random number to a positive string
    
    Signup() {
        setTitle("NEW ACCOUNT APPLICATION FORM");
        
        // Setting up the logo image
        ImageIcon iconLogo = new ImageIcon(ClassLoader.getSystemResource("ASimulatorSystem/icons/logo.jpg"));
        Image imageLogo = iconLogo.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon scaledIconLogo = new ImageIcon(imageLogo);
        JLabel labelLogo = new JLabel(scaledIconLogo);
        labelLogo.setBounds(20, 0, 100, 100);
        add(labelLogo);
        
        // Initializing the labels
        labelFormNumber = new JLabel("APPLICATION FORM NO. " + formNumber);
        labelFormNumber.setFont(new Font("Raleway", Font.BOLD, 38));
        
        labelPageTitle = new JLabel("Page 1: Personal Details");
        labelPageTitle.setFont(new Font("Raleway", Font.BOLD, 22));
        
        labelName = new JLabel("Name:");
        labelName.setFont(new Font("Raleway", Font.BOLD, 20));
        
        labelFathersName = new JLabel("Father's Name:");
        labelFathersName.setFont(new Font("Raleway", Font.BOLD, 20));
        
        labelDob = new JLabel("Date of Birth:");
        labelDob.setFont(new Font("Raleway", Font.BOLD, 20));
        
        labelGender = new JLabel("Gender:");
        labelGender.setFont(new Font("Raleway", Font.BOLD, 20));
        
        labelEmail = new JLabel("Email Address:");
        labelEmail.setFont(new Font("Raleway", Font.BOLD, 20));
        
        labelMaritalStatus = new JLabel("Marital Status:");
        labelMaritalStatus.setFont(new Font("Raleway", Font.BOLD, 20));
        
        labelAddress = new JLabel("Address:");
        labelAddress.setFont(new Font("Raleway", Font.BOLD, 20));
        
        labelCity = new JLabel("City:");
        labelCity.setFont(new Font("Raleway", Font.BOLD, 20));
        
        labelPinCode = new JLabel("Pin Code:");
        labelPinCode.setFont(new Font("Raleway", Font.BOLD, 20));
        
        labelState = new JLabel("State:");
        labelState.setFont(new Font("Raleway", Font.BOLD, 20));
        
        labelDate = new JLabel("Date");
        labelDate.setFont(new Font("Raleway", Font.BOLD, 14));
        
        labelMonth = new JLabel("Month");
        labelMonth.setFont(new Font("Raleway", Font.BOLD, 14));
        
        labelYear = new JLabel("Year");
        labelYear.setFont(new Font("Raleway", Font.BOLD, 14));
        
        // Initializing the text fields
        textName = new JTextField();
        textName.setFont(new Font("Raleway", Font.BOLD, 14));
        
        textFathersName = new JTextField();
        textFathersName.setFont(new Font("Raleway", Font.BOLD, 14));
        
        textEmail = new JTextField();
        textEmail.setFont(new Font("Raleway", Font.BOLD, 14));
        
        textAddress = new JTextField();
        textAddress.setFont(new Font("Raleway", Font.BOLD, 14));
        
        textCity = new JTextField();
        textCity.setFont(new Font("Raleway", Font.BOLD, 14));
        
        textPinCode = new JTextField();
        textPinCode.setFont(new Font("Raleway", Font.BOLD, 14));
        
        textState = new JTextField();
        textState.setFont(new Font("Raleway", Font.BOLD, 14));
        
        // Initializing the buttons
        buttonNext = new JButton("Next");
        buttonNext.setFont(new Font("Raleway", Font.BOLD, 14));
        buttonNext.setBackground(Color.BLACK);
        buttonNext.setForeground(Color.WHITE);
        
        // Initializing the radio buttons for gender
        radioMale = new JRadioButton("Male");
        radioMale.setFont(new Font("Raleway", Font.BOLD, 14));
        radioMale.setBackground(Color.WHITE);
        
        radioFemale = new JRadioButton("Female");
        radioFemale.setFont(new Font("Raleway", Font.BOLD, 14));
        radioFemale.setBackground(Color.WHITE);
        
        // Grouping gender radio buttons so only one can be selected at a time
        ButtonGroup groupGender = new ButtonGroup();
        groupGender.add(radioMale);
        groupGender.add(radioFemale);
        
        // Initializing the radio buttons for marital status
        radioMarried = new JRadioButton("Married");
        radioMarried.setFont(new Font("Raleway", Font.BOLD, 14));
        radioMarried.setBackground(Color.WHITE);
        
        radioUnmarried = new JRadioButton("Unmarried");
        radioUnmarried.setFont(new Font("Raleway", Font.BOLD, 14));
        radioUnmarried.setBackground(Color.WHITE);
        
        radioOther = new JRadioButton("Other");
        radioOther.setFont(new Font("Raleway", Font.BOLD, 14));
        radioOther.setBackground(Color.WHITE);
        
        // Grouping marital status radio buttons so only one can be selected at a time
        ButtonGroup groupMaritalStatus = new ButtonGroup();
        groupMaritalStatus.add(radioMarried);
        groupMaritalStatus.add(radioUnmarried);
        groupMaritalStatus.add(radioOther);
        
        // Initializing the date chooser for date of birth
        dateChooser = new JDateChooser();
        dateChooser.setForeground(new Color(105, 105, 105));
        dateChooser.setBounds(137, 337, 200, 29);
        add(dateChooser);
        
        // Setting layout to null for absolute positioning
        setLayout(null);
        
        // Setting bounds and adding components to the frame
        labelFormNumber.setBounds(140, 20, 600, 40);
        add(labelFormNumber);
        
        labelPageTitle.setBounds(290, 80, 600, 30);
        add(labelPageTitle);
        
        labelName.setBounds(100, 140, 100, 30);
        add(labelName);
        
        textName.setBounds(300, 140, 400, 30);
        add(textName);
        
        labelFathersName.setBounds(100, 190, 200, 30);
        add(labelFathersName);
        
        textFathersName.setBounds(300, 190, 400, 30);
        add(textFathersName);
        
        labelDob.setBounds(100, 240, 200, 30);
        add(labelDob);
        
        dateChooser.setBounds(300, 240, 400, 30);
        add(dateChooser);
        
        labelGender.setBounds(100, 290, 200, 30);
        add(labelGender);
        
        radioMale.setBounds(300, 290, 60, 30);
        add(radioMale);
        
        radioFemale.setBounds(450, 290, 90, 30);
        add(radioFemale);
        
        labelEmail.setBounds(100, 340, 200, 30);
        add(labelEmail);
        
        textEmail.setBounds(300, 340, 400, 30);
        add(textEmail);
        
        labelMaritalStatus.setBounds(100, 390, 200, 30);
        add(labelMaritalStatus);
        
        radioMarried.setBounds(300, 390, 100, 30);
        add(radioMarried);
        
        radioUnmarried.setBounds(450, 390, 100, 30);
        add(radioUnmarried);
        
        radioOther.setBounds(635, 390, 100, 30);
        add(radioOther);
        
        labelAddress.setBounds(100, 440, 200, 30);
        add(labelAddress);
        
        textAddress.setBounds(300, 440, 400, 30);
        add(textAddress);
        
        labelCity.setBounds(100, 490, 200, 30);
        add(labelCity);
        
        textCity.setBounds(300, 490, 400, 30);
        add(textCity);
        
        labelPinCode.setBounds(100, 540, 200, 30);
        add(labelPinCode);
        
        textPinCode.setBounds(300, 540, 400, 30);
        add(textPinCode);
        
        labelState.setBounds(100, 590, 200, 30);
        add(labelState);
        
        textState.setBounds(300, 590, 400, 30);
        add(textState);
        
        buttonNext.setBounds(620, 660, 80, 30);
        add(buttonNext);
        
        // Adding action listener to the button
        buttonNext.addActionListener(this);
        
        // Setting the background color of the content pane to white
        getContentPane().setBackground(Color.WHITE);
        
        // Setting the size, location, and visibility of the frame
        setSize(850, 800);
        setLocation(250, 0);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        // Fetching values from the input fields
        String formNo = formNumber;
        String name = textName.getText();
        String fathersName = textFathersName.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if (radioMale.isSelected()) { 
            gender = "Male";
        } else if (radioFemale.isSelected()) { 
            gender = "Female";
        }
        
        String email = textEmail.getText();
        String maritalStatus = null;
        if (radioMarried.isSelected()) { 
            maritalStatus = "Married";
        } else if (radioUnmarried.isSelected()) { 
            maritalStatus = "Unmarried";
        } else if (radioOther.isSelected()) { 
            maritalStatus = "Other";
        }
        
        String address = textAddress.getText();
        String city = textCity.getText();
        String pinCode = textPinCode.getText();
        String state = textState.getText();
        
        // Exception handling for input validation and database operations
        try {
            // Checking if any required field is empty
            if (name.isEmpty() || fathersName.isEmpty() || dob.isEmpty() || gender == null || email.isEmpty() || maritalStatus == null || address.isEmpty() || city.isEmpty() || pinCode.isEmpty() || state.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Fill all the required fields");
            } else {
                // Validating that name, fathersName, city, and state are not integers
                if (isInteger(name) || isInteger(fathersName) || isInteger(city) || isInteger(state)) {
                    JOptionPane.showMessageDialog(null, "Name, Father's Name, City, and State should not be integers");
                } else {
                    // Validating pin code as an integer
                    try {
                        Integer.parseInt(pinCode);
                        
                        // Establishing connection to the database and executing the insert query
                        Conn connection = new Conn();
                        String query = "insert into signup values('" + formNo + "','" + name + "','" + fathersName + "','" + dob + "','" + gender + "','" + email + "','" + maritalStatus + "','" + address + "','" + city + "','" + pinCode + "','" + state + "')";
                        connection.s.executeUpdate(query);
                        
                        // Navigating to the next signup page
                        new Signup2(formNumber).setVisible(true);
                        setVisible(false);
                    } catch (NumberFormatException e) {
                        // If pin code is not a valid integer, show a message dialog
                        JOptionPane.showMessageDialog(null, "Please enter a valid pin code");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "An error occurred while submitting the form");
        }
    }

    // Utility method to check if a string is an integer
    private boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    public static void main(String[] args) {
        new Signup().setVisible(true);
    }
}
package ASimulatorSystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Signup2 extends JFrame implements ActionListener {

    // Declare labels, buttons, radio buttons, text fields, and combo boxes
    JLabel labelPageTitle, labelReligion, labelCategory, labelIncome, labelEducational, labelQualification, labelOccupation, labelPanNumber, labelCnicNumber, labelSeniorCitizen, labelExistingAccount, labelFormNo, labelFormNoValue;
    JButton buttonNext;
    JRadioButton radioYesSenior, radioNoSenior, radioYesAccount, radioNoAccount;
    JTextField textPan, textCnic;
    JComboBox<String> comboReligion, comboCategory, comboIncome, comboEducation, comboOccupation;
    String formNumber;

    // Constructor
    Signup2(String formNumber) {
        // Load and set the logo
        ImageIcon iconLogo = new ImageIcon(ClassLoader.getSystemResource("ASimulatorSystem/icons/logo.jpg"));
        Image imageLogo = iconLogo.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon scaledIconLogo = new ImageIcon(imageLogo);
        JLabel labelLogo = new JLabel(scaledIconLogo);
        labelLogo.setBounds(150, 0, 100, 100);
        add(labelLogo);

        this.formNumber = formNumber;
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");

        // Initialize labels
        labelPageTitle = new JLabel("Page 2: Additional Details");
        labelPageTitle.setFont(new Font("Raleway", Font.BOLD, 22));

        labelReligion = new JLabel("Religion:");
        labelReligion.setFont(new Font("Raleway", Font.BOLD, 18));

        labelCategory = new JLabel("Category:");
        labelCategory.setFont(new Font("Raleway", Font.BOLD, 18));

        labelIncome = new JLabel("Income:");
        labelIncome.setFont(new Font("Raleway", Font.BOLD, 18));

        labelEducational = new JLabel("Educational");
        labelEducational.setFont(new Font("Raleway", Font.BOLD, 18));

        labelQualification = new JLabel("Qualification:");
        labelQualification.setFont(new Font("Raleway", Font.BOLD, 18));

        labelOccupation = new JLabel("Occupation:");
        labelOccupation.setFont(new Font("Raleway", Font.BOLD, 18));

        labelPanNumber = new JLabel("PAN Number:");
        labelPanNumber.setFont(new Font("Raleway", Font.BOLD, 18));

        labelCnicNumber = new JLabel("Cnic Number:");
        labelCnicNumber.setFont(new Font("Raleway", Font.BOLD, 18));

        labelSeniorCitizen = new JLabel("Senior Citizen:");
        labelSeniorCitizen.setFont(new Font("Raleway", Font.BOLD, 18));

        labelExistingAccount = new JLabel("Existing Account:");
        labelExistingAccount.setFont(new Font("Raleway", Font.BOLD, 18));

        labelFormNo = new JLabel("Form No:");
        labelFormNo.setFont(new Font("Raleway", Font.BOLD, 13));

        labelFormNoValue = new JLabel(formNumber);
        labelFormNoValue.setFont(new Font("Raleway", Font.BOLD, 13));

        // Initialize button
        buttonNext = new JButton("Next");
        buttonNext.setFont(new Font("Raleway", Font.BOLD, 14));
        buttonNext.setBackground(Color.BLACK);
        buttonNext.setForeground(Color.WHITE);

        // Initialize text fields
        textPan = new JTextField();
        textPan.setFont(new Font("Raleway", Font.BOLD, 14));

        textCnic = new JTextField();
        textCnic.setFont(new Font("Raleway", Font.BOLD, 14));

        // Initialize radio buttons for senior citizen status
        radioYesSenior = new JRadioButton("Yes");
        radioYesSenior.setFont(new Font("Raleway", Font.BOLD, 14));
        radioYesSenior.setBackground(Color.WHITE);

        radioNoSenior = new JRadioButton("No");
        radioNoSenior.setFont(new Font("Raleway", Font.BOLD, 14));
        radioNoSenior.setBackground(Color.WHITE);

        // Group radio buttons for senior citizen status
        ButtonGroup groupSeniorCitizen = new ButtonGroup();
        groupSeniorCitizen.add(radioYesSenior);
        groupSeniorCitizen.add(radioNoSenior);

        // Initialize radio buttons for existing account status
        radioYesAccount = new JRadioButton("Yes");
        radioYesAccount.setFont(new Font("Raleway", Font.BOLD, 14));
        radioYesAccount.setBackground(Color.WHITE);

        radioNoAccount = new JRadioButton("No");
        radioNoAccount.setFont(new Font("Raleway", Font.BOLD, 14));
        radioNoAccount.setBackground(Color.WHITE);

        // Group radio buttons for existing account status
        ButtonGroup groupExistingAccount = new ButtonGroup();
        groupExistingAccount.add(radioYesAccount);
        groupExistingAccount.add(radioNoAccount);

        // Initialize combo boxes
        String[] religion = {"Muslim", "Hindu", "Sikh", "Christian", "Other"};
        comboReligion = new JComboBox<>(religion);
        comboReligion.setBackground(Color.WHITE);
        comboReligion.setFont(new Font("Raleway", Font.BOLD, 14));

        String[] category = {"General", "OBC", "SC", "ST", "Other"};
        comboCategory = new JComboBox<>(category);
        comboCategory.setBackground(Color.WHITE);
        comboCategory.setFont(new Font("Raleway", Font.BOLD, 14));

        String[] income = {"Null", "<1,50,000", "<2,50,000", "<5,00,000", "Upto 10,00,000", "Above 10,00,000"};
        comboIncome = new JComboBox<>(income);
        comboIncome.setBackground(Color.WHITE);
        comboIncome.setFont(new Font("Raleway", Font.BOLD, 14));

        String[] education = {"Non-Graduate", "Graduate", "Post-Graduate", "Doctorate", "Others"};
        comboEducation = new JComboBox<>(education);
        comboEducation.setBackground(Color.WHITE);
        comboEducation.setFont(new Font("Raleway", Font.BOLD, 14));

        String[] occupation = {"Salaried", "Self-Employed", "Business", "Student", "Retired", "Others"};
        comboOccupation = new JComboBox<>(occupation);
        comboOccupation.setBackground(Color.WHITE);
        comboOccupation.setFont(new Font("Raleway", Font.BOLD, 14));

        // Set layout to null for absolute positioning
        setLayout(null);

        // Add and position components on the frame
        labelFormNo.setBounds(700, 10, 60, 30);
        add(labelFormNo);

        labelFormNoValue.setBounds(760, 10, 60, 30);
        add(labelFormNoValue);

        labelPageTitle.setBounds(280, 30, 600, 40);
        add(labelPageTitle);

        labelReligion.setBounds(100, 120, 100, 30);
        add(labelReligion);

        comboReligion.setBounds(350, 120, 320, 30);
        add(comboReligion);

        labelCategory.setBounds(100, 170, 100, 30);
        add(labelCategory);

        comboCategory.setBounds(350, 170, 320, 30);
        add(comboCategory);

        labelIncome.setBounds(100, 220, 100, 30);
        add(labelIncome);

        comboIncome.setBounds(350, 220, 320, 30);
        add(comboIncome);

        labelEducational.setBounds(100, 270, 150, 30);
        add(labelEducational);

        comboEducation.setBounds(350, 270, 320, 30);
        add(comboEducation);

        labelQualification.setBounds(100, 290, 150, 30);
        add(labelQualification);

        labelOccupation.setBounds(100, 340, 150, 30);
        add(labelOccupation);

        comboOccupation.setBounds(350, 340, 320, 30);
        add(comboOccupation);

        labelPanNumber.setBounds(100, 390, 150, 30);
        add(labelPanNumber);

        textPan.setBounds(350, 390, 320, 30);
        add(textPan);

        labelCnicNumber.setBounds(100, 440, 180, 30);
        add(labelCnicNumber);

        textCnic.setBounds(350, 440, 320, 30);
        add(textCnic);

        labelSeniorCitizen.setBounds(100, 490, 150, 30);
        add(labelSeniorCitizen);

        radioYesSenior.setBounds(350, 490, 100, 30);
        add(radioYesSenior);

        radioNoSenior.setBounds(460, 490, 100, 30);
        add(radioNoSenior);

        labelExistingAccount.setBounds(100, 540, 180, 30);
        add(labelExistingAccount);

        radioYesAccount.setBounds(350, 540, 100, 30);
        add(radioYesAccount);

        radioNoAccount.setBounds(460, 540, 100, 30);
        add(radioNoAccount);

        buttonNext.setBounds(570, 640, 100, 30);
        add(buttonNext);

        // Add action listener to the button
        buttonNext.addActionListener(this);

        // Set background color of the content pane to white
        getContentPane().setBackground(Color.WHITE);

        // Set size, location, and visibility of the frame
        setSize(850, 750);
        setLocation(250, 0);
        setVisible(true);
    }

    // Handle button click events
    public void actionPerformed(ActionEvent ae) {
        String religion = (String) comboReligion.getSelectedItem();
        String category = (String) comboCategory.getSelectedItem();
        String income = (String) comboIncome.getSelectedItem();
        String education = (String) comboEducation.getSelectedItem();
        String occupation = (String) comboOccupation.getSelectedItem();

        String pan = textPan.getText();
        String cnic = textCnic.getText();

        String seniorCitizen = "";
        if (radioYesSenior.isSelected()) {
            seniorCitizen = "Yes";
        } else if (radioNoSenior.isSelected()) {
            seniorCitizen = "No";
        }

        String existingAccount = "";
        if (radioYesAccount.isSelected()) {
            existingAccount = "Yes";
        } else if (radioNoAccount.isSelected()) {
            existingAccount = "No";
        }

        try {
            if (textCnic.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Fill all the required fields");
            } else {
                // Establish connection to the database and execute the insert query
                Conn connection = new Conn();
                String query = "insert into signup2 values('" + formNumber + "','" + religion + "','" + category + "','" + income + "','" + education + "','" + occupation + "','" + pan + "','" + cnic + "','" + seniorCitizen + "','" + existingAccount + "')";
                connection.s.executeUpdate(query);

                // Navigate to the next signup page
                new Signup3(formNumber).setVisible(true);
                setVisible(false);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Signup2("").setVisible(true);
    }
}

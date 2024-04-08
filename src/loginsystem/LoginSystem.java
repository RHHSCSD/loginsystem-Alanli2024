/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package loginsystem;
import javax.swing.*;
import java.awt.event.*;


/**
 * Author: Alan Li
 * Class: ICS4U
 * Program: Text File I/O Assignment
 * 
 */
public class LoginSystem {

    /**
     * Creates the register and login GUI interfaces
     * @param args
     */
    public static void main(String[] args) {
        
        //creates an instance of RegistrationSystem class with storage file
        RegistrationSystem registrationSystem = new RegistrationSystem("storageFile.txt");
        
        //creates and sets the size for the registration frame
        JFrame frame = new JFrame("Registration");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //creates panels for registration componenets
        JPanel panel = new JPanel();
        //allows for custom layout
        panel.setLayout(null);

        //adds username input field
        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(50, 30, 80, 25);
        panel.add(usernameLabel);
        JTextField usernameField = new JTextField();
        usernameField.setBounds(150, 30, 200, 25);
        panel.add(usernameField);

        //adds email input field
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(50, 70, 80, 25);
        panel.add(emailLabel);
        JTextField emailField = new JTextField();
        emailField.setBounds(150, 70, 200, 25);
        panel.add(emailField);

        //adds password input field
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(50, 110, 80, 25);
        panel.add(passwordLabel);
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(150, 110, 200, 25);
        panel.add(passwordField);

        //adds first name input field
        JLabel firstNameLabel = new JLabel("First Name:");
        firstNameLabel.setBounds(50, 150, 80, 25);
        panel.add(firstNameLabel);
        JTextField firstNameField = new JTextField();
        firstNameField.setBounds(150, 150, 200, 25);
        panel.add(firstNameField);

        //adds last name input field
        JLabel lastNameLabel = new JLabel("Last Name:");
        lastNameLabel.setBounds(50, 190, 80, 25);
        panel.add(lastNameLabel);
        JTextField lastNameField = new JTextField();
        lastNameField.setBounds(150, 190, 200, 25);
        panel.add(lastNameField);

        //adds register button
        JButton registerButton = new JButton("Register");
        registerButton.setBounds(150, 230, 100, 25);
        //ActionListener for the register button
        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //retrieve input values
                String username = usernameField.getText();
                String email = emailField.getText();
                String password = new String(passwordField.getPassword());
                String firstName = firstNameField.getText();
                String lastName = lastNameField.getText();
                //checks if the username is unique, it it's not prints out a message
                if (registrationSystem.isUniqueName(username)) {
                    //checks if the password is strong, if it's not prints out a message
                    if (registrationSystem.isStrongPassword(password)) {
                        //checks if the password is considered a bad password from a file, if the password is considered a bad password it prints out a message
                        if (registrationSystem.isBadPassword(password)) {
                            //save user information if they met all criteria
                        registrationSystem.saveUser(username, email, password, firstName, lastName);
                        JOptionPane.showMessageDialog(frame, "Registration successful!");
                        } else {
                            JOptionPane.showMessageDialog(frame, "Password is considered a bad password");
                        }
                    } else {
                        JOptionPane.showMessageDialog(frame, "Password is not strong enough");
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "Username already exists");
                }
            }
        });
        panel.add(registerButton);
        //adds the panels to the registration frame
        frame.add(panel);
        //makes the frame visible
        frame.setVisible(true);
        
        //creates and sets the size for the login frame
        JFrame loginFrame = new JFrame("Login");
            loginFrame.setSize(400, 200);
            loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            //creates panels for login componenets 
            JPanel loginPanel = new JPanel();
            //allows for custom layout
            loginPanel.setLayout(null);

            //adds username input field
            JLabel loginUsernameLabel = new JLabel("Username:");
            loginUsernameLabel.setBounds(50, 30, 80, 25);
            loginPanel.add(loginUsernameLabel);
            JTextField loginUsernameField = new JTextField();
            loginUsernameField.setBounds(150, 30, 200, 25);
            loginPanel.add(loginUsernameField);

            //adds password input field
            JLabel loginPasswordLabel = new JLabel("Password:");
            loginPasswordLabel.setBounds(50, 70, 80, 25);
            loginPanel.add(loginPasswordLabel);
            JPasswordField loginPasswordField = new JPasswordField();
            loginPasswordField.setBounds(150, 70, 200, 25);
            loginPanel.add(loginPasswordField);

            //adds login button
            JButton loginButton = new JButton("Login");
            loginButton.setBounds(150, 110, 100, 25);
            //ActionListener for the login button
            loginButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    //retrieve input values
                    String username = loginUsernameField.getText();
                    String password = new String(loginPasswordField.getPassword());
                    
                    //checks if user's username and password are valid for login
                    if (registrationSystem.isValidLogin(username, password)) {
                        //prints out message saying you signed in if valid input
                        JOptionPane.showMessageDialog(loginFrame, "Login successful!");
                    } else {
                        //prints out message saying your input is not valid
                        JOptionPane.showMessageDialog(loginFrame, "Invalid username or password!");
                    }
                }
            });
            loginPanel.add(loginButton);

            //adds the panels to the login frame
            loginFrame.add(loginPanel);
            //makes the frame visible
            loginFrame.setVisible(true);
    }
    
}
    


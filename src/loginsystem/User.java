/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package loginsystem;

/**
 * Author: Alan Li
 * Class: ICS4U
 * Program: Text File I/O Assignment
 * 
 */

//class that represents users
public class User {
    
        //instance variables for user's information
        private String firstName;
        private String username;
        private String password;
        private String email;
        private String lastName;
        
    /**
     * constructor to initialize a new user object
     * @param newUsername, the username of the user
     * @param newEmail, the email of the user
     * @param newPassword, the password of the user
     * @param newFirstName, the first name of the user
     * @param newLastName, the last name of the user
     */
    public User (String newUsername, String newEmail, String newPassword, String newFirstName, String newLastName){
            
        //the attributes of the user object
            firstName = newFirstName;
            lastName = newLastName;
            password = newPassword;
            email = newEmail;
            username = newUsername;
        }
        
    /**
     * gets the first name of the user
     * @return, returns the first name of the user
     */
    public String getFirstName(){
            return firstName;
        }
        
    /**
     * sets the first name of the user
     * @param newFirstName, the new first name of the user
     */
    public void setFirstName(String newFirstName){
            firstName = newFirstName;
        }
        
    /**
     * gets the last name of the user
     * @return, returns the last name of the user
     */
    public String getLastName(){
            return lastName;
        }
        
    /**
     * sets the last name of the user
     * @param newLastName, the new last name of the user
     */
    public void setLastName(String newLastName){
            lastName = newLastName;
        }
        
    /**
     * gets the password of the user
     * @return, returns the password of the user
     */
    public String getPassword(){
            return password;
        }
        
    /**
     * sets the password of the user
     * @param newPassword, the new password of the user
     */
    public void setPassword(String newPassword){
            password = newPassword;
        }
        
    /**
     * gets the email of the user
     * @return, returns the email of the user
     */
    public String getEmail(){
            return email;
        }
        
    /**
     * sets the email of the user
     * @param newEmail, the new email of the user
     */
    public void setEmail(String newEmail){
            email = newEmail;
        }
        
    /**
     * gets the username of the user
     * @return, returns the username of the user
     */
    public String getUsername(){
            return username;
        }
        
    /**
     * sets the username of the user
     * @param newUsername, the new username of the user
     */
    public void setUsername(String newUsername){
            username = newUsername;
        }
    }

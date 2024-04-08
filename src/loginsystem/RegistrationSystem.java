/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package loginsystem;
import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Scanner;
        
/**
 * Author: Alan Li
 * Class: ICS4U
 * Program: Text File I/O Assignment
 * 
 */

//represents a registration system for users
public class RegistrationSystem {
    
    //file used for storing user information
    private String storageFile;
    //file used for checking if the password is bad
    private String badPasswordFile = "dictbadpass.txt";
    
    /**
     * Constructor to initialize the RegistrationSystem with the storage file
     * @param newStorageFile, the storage file your using for storing user information
     */
    public RegistrationSystem(String newStorageFile){
        storageFile = newStorageFile;
    }

    /**
     * Registers a new user by adding their data to the storage file
     * @param username, the username of the new user
     * @param email, the email of the new user
     * @param password, the password of the new user
     * @param firstName, the first name of the new user
     * @param lastName, the last name of the new user
     */
    public void saveUser(String username, String email, String password, String firstName, String lastName){
        //create a new user object
        User newUser = new User(username, email, hashPassword(password), firstName, lastName);
        
    try {
   //opens the storage file for writing
    PrintWriter pw = new PrintWriter(new FileWriter(storageFile, true));
    //writes the user data into the file
    pw.print(newUser.getUsername() + "," + newUser.getEmail() + "," + newUser.getPassword() + "," + newUser.getFirstName() + "," + newUser.getLastName());
    //close printwriter
    pw.close();
    //prints out message if there's an error in newuser method
    } catch (IOException e) {
            System.out.println("error in registerUser method");
}
    }
    
    /**
     * Loads the user data from the storage file
     * @return, returns the array of all user objects containing all of user's information
     */
    public User[] loadUsers() {
        //array to store users
        User[] users = new User[100];
        //index to track array position
        int index = 0;
        
        try { 
            //opens the storage file for reading
            Scanner s = new Scanner(new File(storageFile));
            //checks if there is more text to read
            //loops through each line in the file
            while (s.hasNextLine()) {
                //makes the information on that line equal to variable line
                String line = s.nextLine();
                //splits the line into parts using comma as the delimiter
                String [] userData = line.split(",");
                //creates a new user object and adds it to the array for each user
                users[index] = new User(userData[0], userData[1], userData[2], userData[3], userData[4]);
                index++;
            }
            //close the scanner
            s.close();
            
} catch (IOException e) {
    //prints message if there's an error in loaduser method
            System.out.println("error in loaduser method");
        }
        return users;
    }
    
    /**
     * checks if a given username is unique
     * @param username, the username for checking
     * @return, returns true if username is unique, false otherwise
     */
    public boolean isUniqueName(String username){
        //load users from storage
        User[] users = loadUsers();
        //loop through user array
        for (int i = 0; i < users.length; i++){
            //check if user exists and if the username matches
            if (users[i] != null && users[i].getUsername().equals(username)) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * Hashes the given password using MD5 algorithm with salt
     * @param password, the password to hash
     * @return, returns the hashed password and null if hashing fails
     */
    private String hashPassword(String password){
        try {
            // generates a random salt
            SecureRandom random = new SecureRandom();
            byte[] salt = new byte[16];
            random.nextBytes(salt);
            
            // add salt to password
            String saltedPassword = password + new String(salt);
            
            
            // java helper class to perform encryption
            MessageDigest md = MessageDigest.getInstance("MD5");
            // give the helper function the password
            md.update(saltedPassword.getBytes());
            //perform the encryption
            byte[] byteData = md.digest();
            // to express the byte data as a hexadecimal number (the normal way)
            String encryptedPassword = "";
            for(int i = 0; i < byteData.length; ++i){
                encryptedPassword += (Integer.toHexString((byteData[i] & 0xFF) | 0x100).substring(1,3));
            }
            return encryptedPassword;
        } catch (NoSuchAlgorithmException e) {
            //if there's an algorithm error, prints message
            System.out.println("error in hashPassword method");
    }
        return null;
    }
    
    /**
     * checks if the given password is in the bad password file
     * @param password, the password to check
     * @return, returns true if the password is not in the bad password file, false otherwise
     */
    public boolean isBadPassword(String password) {
        try {
            //opens and reads the bad password file
            Scanner a = new Scanner(new File(badPasswordFile));
            //checks if there is more text to read
            //loops through each line in the file
            while(a.hasNextLine()){
                //makes the information on that line equal to variable line
                String line = a.nextLine();
                //sees if the user password matches with any of the bad passwords
                if (line.equals(password)){
                    //close scanner
                    a.close();
                    return false;
                }
            }
            a.close();
        } catch (FileNotFoundException e){
            //prints message if there's error in file not found
            System.out.println("error in isbadpassword method, file not found");
        }
        return true;
    }
    
    /**
     * checks if the password meets the conditions and is strong
     * @param password, the password to check
     * @return, returns true if the password is strong, false otherwise
     */
    public boolean isStrongPassword(String password){
        //returns true if all the conditions are met
        return password.length() >= 8 && containsUppercase(password) && containsLowercase(password) && containsDigit(password) && containsSpecialCharacter(password);
    }
    
    /**
     * check if the password contains uppercase letters
     * @param password, the password to be checked
     * @return, returns true if the password contains uppercase letter, false otherwise
     */
    public boolean containsUppercase(String password){
        //loops through each character in the password and checks if there's any uppercase
        for (int i = 0; i < password.length(); i++){
            char c = password.charAt(i);
            if (Character.isUpperCase(c)){
                return true;
            }
        }
        return false;
    }
    
    /**
     * checks if the password contains a lowercase letters
     * @param password, the password to beck
     * @return, returns true if the password contains lowercase letters, false otherwise
     */
    public boolean containsLowercase(String password){
        //loops through each character in the password and checks if there's any lowercase
        for (int i = 0; i < password.length(); i++){
            char c = password.charAt(i);
            if (Character.isLowerCase(c)){
                return true;
            }
        }
        return false;
    }
    
    /**
     * checks if the password contains digits
     * @param password, the password to check
     * @return, returns true if the password contains digits, false otherwise
     */
    public boolean containsDigit(String password){
        //loops through each character in the password and checks if there's any digits
        for (int i = 0; i < password.length(); i++){
            char c = password.charAt(i);
            if (Character.isDigit(c)){
                return true;
            }
        }
        return false;
    }
    
    /**
     * checks if the password contains special characters
     * @param password, the password to check
     * @return, returns true if the password contains special letter, false otherwise
     */
    public boolean containsSpecialCharacter(String password){
        //loops through each character in the password and checks if there's any special characters
        String specialCharacters = "!@#$%^&*()-_=+{[}]|:;'<,>.?/~`";
        for (int i = 0; i < password.length(); i++){
            char c = password.charAt(i);
            if (specialCharacters.contains(String.valueOf(c))){
                return true;
            }
        }
        return false;
    } 
    }


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package users;

import static main.Main.*;

/**
 *
 * @author enzomourany
 */
public class User {

    protected String username;
    protected String firstName;
    protected String lastName;
    protected String email;
    protected double walletBalance;

    // Setters
    public void setUsername(String _username) {
        this.username = _username;
    }

    public void setFirstName(String _firstname) {
        this.firstName = _firstname;
    }

    public void setLastName(String _lastName) {
        this.lastName = _lastName;
    }

    public void setEmail(String _email) {
        this.email = _email;
    }

    // Getters
    public String getUsername() {
        return username;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLasttName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public static void displayDashboard() {
        System.out.println(ANSI_GREEN + "1. See your account information" + ANSI_RESET);
        System.out.println(ANSI_GREEN + "2. Change Username" + ANSI_RESET);
        System.out.println(ANSI_GREEN + "3. Change First name" + ANSI_RESET);
        System.out.println(ANSI_GREEN + "4. Change Last name" + ANSI_RESET);
        System.out.println(ANSI_GREEN + "5. Change email" + ANSI_RESET);
    }

    /**
     * Replace current username by a new username
     *
     * @param username the user's username
     * @param newUsername the new username
     * @author enzomourany
     */
    public static void changeUsername(String username, String newUsername) {
        for (User user : users) {
            if (username.equals(user.getUsername())) {
                user.setUsername(newUsername);
            }
        }
    }

    /**
     * Replace current first name by a new first name
     *
     * @param username the user's username
     * @param newFirstName the new first name
     * @author enzomourany
     */
    public static void changeFirstName(String username, String newFirstName) {
        for (User user : users) {
            if (username.equals(user.getUsername())) {
                user.setFirstName(newFirstName);
            }
        }
    }

    /**
     * Replace current last name by a new last name
     *
     * @param username the user's username
     * @param newLastName the new last name
     * @author enzomourany
     */
    public static void changeLastName(String username, String newLastName) {
        for (User user : users) {
            if (username.equals(user.getUsername())) {
                user.setLastName(newLastName);
            }
        }
    }

    /**
     * Replace current email by a new email
     *
     * @param username the user's username
     * @param newEmail the new email
     * @author enzomourany
     */
    public static void changeEmail(String username, String newEmail) {
        for (User user : users) {
            if (username.equals(user.getUsername())) {
                user.setEmail(newEmail);
            }
        }
    }

}

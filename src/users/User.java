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

    public void setUsername(String _username) {
        this.username = _username;
    }
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
    }

    public static void changeUsername(String username, String newUsername) {
        for (User user : users) {
            if (username.equals(user.getUsername())) {
                user.setUsername(newUsername);
            }
        }
    }

}

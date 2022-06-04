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

    public void setUsername(String _username) {
        username = _username;
    }
    public String getUsername() {
        return this.username;
    }

    public static void displayDashboard() {
        System.out.println(ANSI_GREEN + "1. Change Username" + ANSI_RESET);
    }

    public static void changeUsername(String username, String newUsername) {
        for (User user : users) {
            if (username.equals(user.getUsername())) {
                user.setUsername(newUsername);
            }
        }
    }

}

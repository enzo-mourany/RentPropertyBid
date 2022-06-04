/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package users;


import static main.Main.ANSI_GREEN;
import static main.Main.ANSI_RESET;

/**
 *
 * @author enzomourany
 */
public class Administrator extends User {

    private final String USERNAME = "Administrator";
    public Administrator() {
        this.username = USERNAME;
    }

    public static void displayDashboard() {
        System.out.println(ANSI_GREEN + "1. Display all users" + ANSI_RESET);
    }
}

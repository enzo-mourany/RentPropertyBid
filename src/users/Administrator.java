/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package users;

import static main.Main.*;
//import static main.Main.ANSI_GREEN;
//import static main.Main.ANSI_RESET;
//import static main.Main.users;

/**
 *
 * @author enzomourany
 */
public class Administrator extends User {

    private final String USERNAME = "Administrator";
    public Administrator() {
        this.username = USERNAME;
    }


    public static void displayAdminDashboard() {
        System.out.println(ANSI_GREEN + "1. Display all users" + ANSI_RESET);
        System.out.println(ANSI_GREEN + "2. Delete an account" + ANSI_RESET);
        System.out.println(ANSI_GREEN + "3. Add new administrator" + ANSI_RESET);
        System.out.println(ANSI_GREEN + "4. Disconnect" + ANSI_RESET);
    }

    /**
     * Remove user from users arrayList
     *
     * @param username the username of user selected
     * @author enzomourany
     */
    public static void deleteUserAccount(String username) {
        for (User user : users) {
            if (username.equals(user.getUsername())) {
                users.remove(user);
            }
        }
    }

    public static void addNewAdministrator() {
        users.add(new Administrator());
    }


}

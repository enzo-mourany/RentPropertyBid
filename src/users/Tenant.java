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
public class Tenant extends User {

    public Tenant(String _username, String _firstName, String _lastName, String _email) {
        this.username = _username;
        this.firstName = _firstName;
        this.lastName = _lastName;
        this.email = _email;
    }

    /**
     * Display all tenant commands on console
     *
     * @author enzomourany
     */
    public static void displayTenantDashboard() {
        System.out.println(ANSI_GREEN + "1. See your account information" + "\n"
                + "2. Change Username" + "\n"
                + "3. Change First name" + "\n"
                + "4. Change Last name" + "\n"
                + "5. Change email" + "\n"
                + "6. Disconnect" + "\n"
                + "7. See all properties" + "\n" + ANSI_RESET
        );
    }
}

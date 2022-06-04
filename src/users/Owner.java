/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package users;

import property.Property;
import property.PropertyType;

import java.util.ArrayList;

import static main.Main.ANSI_GREEN;
import static main.Main.ANSI_RESET;

/**
 *
 * @author enzomourany
 */
public class Owner extends User {

    public static ArrayList<Property> portfolio;

    public Owner(String _username, String _firstName, String _lastName, String _email) {
        this.username = _username;
        this.firstName = _firstName;
        this.lastName = _lastName;
        this.email = _email;
        this.portfolio = new ArrayList<>();
    }

    public static void addProperty(PropertyType type, String propertyName, String adress, String city, String description, int maxNumberOfOccupants, int rateForOneNight) {
        portfolio.add(new Property(type, propertyName, adress, city, description, maxNumberOfOccupants, rateForOneNight));
    }


    public static void displayOwnerDashboard() {
        System.out.println(ANSI_GREEN + "1. See your account information" + ANSI_RESET);
        System.out.println(ANSI_GREEN + "2. Change Username" + ANSI_RESET);
        System.out.println(ANSI_GREEN + "3. Change First name" + ANSI_RESET);
        System.out.println(ANSI_GREEN + "4. Change Last name" + ANSI_RESET);
        System.out.println(ANSI_GREEN + "5. Change email" + ANSI_RESET);
        System.out.println(ANSI_GREEN + "6. Disconnect" + ANSI_RESET);
        System.out.println(ANSI_GREEN + "7. Add new property" + ANSI_RESET);
    }
}

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
        portfolio = new ArrayList<>();
        isOwner = true;
    }

    /**
     * Add a new property to owner's portfolio
     *
     * @param owner the name of the owner
     * @param type the type of property
     * @param propertyName the name of the property
     * @param address the address of the property
     * @param city the city of the property
     * @param description the description of the property
     * @param maxNumberOfOccupants the maximum number of people of the property
     * @param rateForOneNight the price for one night and one person
     * @author enzomourany
     */
    public static void addProperty(String owner, PropertyType type, String propertyName, String address, String city,
                                   String description, int maxNumberOfOccupants, int rateForOneNight) {
        portfolio.add(new Property(owner, type, propertyName, address, city, description, maxNumberOfOccupants,
                rateForOneNight));
    }


    /**
     * Get all the properties name
     *
     * @return a list of all owner's properties name
     * @author enzomourany
     */
    public static ArrayList<String> getPropertiesName() {
        ArrayList<String> propertiesName = new ArrayList<>();
        for (Property p : portfolio) {
            propertiesName.add(p.getPropertyName());
        }
        return propertiesName;
    }

    /**
     * Display all actions on the console
     *
     * @author enzomourany
     */
    public static void displayOwnerDashboard() {
        System.out.println(ANSI_GREEN + "1. See your account information" + "\n"
                + "2. Change Username" + "\n"
                + "3. Change First name" + "\n"
                + "4. Change Last name" + "\n"
                + "5. Change email" + "\n"
                + "6. Disconnect" + "\n"
                + "7. Add new property" + "\n"
                + "8. See portfolio" + "\n"
                + "9. Edit property information" + ANSI_RESET + "\n"
            );
    }
}

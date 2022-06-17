/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package users;

import management.Bid;
import property.Property;
import property.PropertyType;

import java.util.ArrayList;

import static main.Main.*;

/**
 *
 * @author enzomourany
 */
public class Owner extends User {

    private ArrayList<Property> portfolio;

    public Owner(String _username, String _firstName, String _lastName, String _email) {
        this.username = _username;
        this.firstName = _firstName;
        this.lastName = _lastName;
        this.email = _email;
        this.portfolio = new ArrayList<>();
        isOwner = true;
    }

    /**
     * Add a new property to owner's portfolio
     *
     * @param type the type of property
     * @param propertyName the name of the property
     * @param address the address of the property
     * @param city the city of the property
     * @param description the description of the property
     * @param maxNumberOfOccupants the maximum number of people of the property
     * @param rateForOneNight the price for one night and one person
     * @author enzomourany
     */
    public void addProperty(PropertyType type, String propertyName, String address, String city,
                                   String description, int maxNumberOfOccupants, int rateForOneNight) {
        portfolio.add(new Property(this.username , type, propertyName, address, city, description, maxNumberOfOccupants,
                rateForOneNight));
    }

    public ArrayList<Property> getPortfolio() {
        return portfolio;
    }


    /**
     * Get all the properties name
     *
     * @return a list of all owner's properties name
     * @author enzomourany
     */
    public ArrayList<String> getPropertiesName() {
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
                + "9. Edit property information" + "\n"
                + "10. Display bids on own properties" + ANSI_RESET + "\n"
            );
    }

    /**
     * Display all the bids on own properties
     */
    public static void displayBidsOnOwnProperty(String username) {
        for (Bid bid : bids) {
            if (username.equals(bid.getOwner())) {
                System.out.println("Property's name : " + ANSI_CYAN + bid.getPropertyName() + ANSI_RESET
                        + "\n" + "Tenant's name : " + ANSI_CYAN + bid.getTenant() + ANSI_RESET + "\n"
                        + "Offer amount : " + ANSI_CYAN + bid.getOfferAmount() + ANSI_RESET + "\n"
                        + "-------------------------------------------------------" + "\n"
                );
            }
        }
    }
}

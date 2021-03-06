/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import management.Bid;
import management.Months;
import property.Property;
import property.PropertyType;
import users.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import static management.Months.getMonths;
import static property.Property.displayEditingPropertyInfos;
import static users.Administrator.*;
import static users.Owner.*;
import static users.Tenant.*;


/**
 *
 * @author enzomourany
 */
public class Main {

    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_YELLOW = "\u001B[33m";

    public static ArrayList<User> users = new ArrayList<>(); // All the users
    public static HashMap<String, Months> rentals = new HashMap<>();
    public static ArrayList<Bid> bids = new ArrayList<>();
    public static ArrayList<Property> properties = new ArrayList<>(); // All the properties

    /**
     * Add all owner's properties on properties arrayList
     */
    public static void regroupAllOwnersProperties() {
        Owner currentOwner = null;
        for (User user : users) {
            if (user.getIsOwner()) {
                currentOwner = (Owner) user;
                for (Property property : currentOwner.getPortfolio()) {
                    properties.add(property);
                }
            }
        }
    }

    /**
     * Get all the users
     * @return an arrayList of usernames
     * @author enzomourany
     */
    public static ArrayList<String> getAllUsers() {
        ArrayList<String> usernames = new ArrayList<>();
        for (User user : users) {
            usernames.add(user.getUsername());
        }
        return usernames;
    }

    /**
     * Get all the owners
     * @return an arrayList of owner's name
     * @author enzomourany
     */
    public static ArrayList<String> getAllOwners() {
        ArrayList<String> ownerNames = new ArrayList<>();
        for (User user : users) {
            if (user.getIsOwner()) {
                ownerNames.add(user.getUsername());
            }
        }
        return ownerNames;
    }

    /**
     * Get all the tenants
     * @return an arrayList of tenant's name
     * @author enzomourany
     */
    public static ArrayList<String> getAllTenants() {
        ArrayList<String> tenantNames = new ArrayList<>();
        for (User user : users) {
            if (!user.getIsOwner() && !user.getIsAdmin()) {
                tenantNames.add(user.getUsername());
            }
        }
        return tenantNames;
    }

    /**
     * Get all the admins
     * @return an arrayList of admin's name
     * @author enzomourany
     */
    public static ArrayList<String> getAllAdmins() {
        ArrayList<String> admins = new ArrayList<>();
        for (User user : users) {
            if (user.getIsAdmin()) {
                admins.add(user.getUsername());
            }
        }
        return admins;
    }


    /**
     * Get the owner object by his username
     * @param username the username of the owner
     * @return a owner object
     * @author enzomourany
     */
    public static Owner getOwnerByUsername(String username) {
        Owner owner = null;
        for (User user : users) {
            if (username.equals(user.getUsername()) && user.getIsOwner()) {
                owner = (Owner) user;
            }
        }
        return owner;
    }

    /**
     * Get a property with the property name
     *
     * @param owner the property's owner
     * @param name the property's name
     * @return an object property
     */
    public static Property getPropertyByName(String owner, String name) {
        Property property = null;
        for (Property p : getOwnerByUsername(owner).getPortfolio()) {
            if (p.getPropertyName().equals(name)) {
                property = p;
            }
        }
        return property;
    }

    /**
     * Get the names of all the properties of all owners
     *
     * @return an arraylist of string
     * @author enzomourany
     */
    public static ArrayList<String> getAllPropertiesNames() {
        ArrayList<String> propertiesNames = new ArrayList<>();
        for (User u : users) {
            if (u.getIsOwner()) {
                Owner owner = (Owner) u;
                for (String property : owner.getPropertiesName()) {
                    propertiesNames.add(property + " (Owner : " + owner.getUsername() + ")");
                }
            }
        }
        return propertiesNames;
    }

    public static boolean isConnected;

    /**
     * change connection value to disconnect current user
     */
    public static void setIsConnected() {
        isConnected = false;
    }

    /**
     * Owner Dashboard support : manage owner account
     *
     * @param username the owner's username
     * @author enzomourany
     */
    public static void ownerDashboard(String username) {
        displayOwnerDashboard();
        Owner currentOwner = getOwnerByUsername(username);
        Scanner commandChoice = new Scanner(System.in);
        int command = commandChoice.nextInt();
        switch(command){
            case 1:
                for (User user : users) {
                    if (username.equals(user.getUsername())) {
                        System.out.println("Username : " + ANSI_CYAN + user.getUsername() + ANSI_RESET + "\n"
                                + "First name : " + ANSI_CYAN + user.getFirstName() + ANSI_RESET + "\n"
                                + "Last name : " + ANSI_CYAN + user.getLastName() + ANSI_RESET + "\n"
                                + "Email : " + ANSI_CYAN + user.getEmail() + ANSI_RESET + "\n"
                        );
                    }
                }
                break;
            case 2:
                Scanner inputNewUsername = new Scanner(System.in);
                System.out.println("Enter your new username : ");
                String newUsername = inputNewUsername.nextLine();
                changeUsername(username, newUsername);
                username = newUsername;
                //TODO : fix bug
                break;
            case 3:
                Scanner inputNewFirstName = new Scanner(System.in);
                System.out.println("Enter your new first name : ");
                String newFirstName = inputNewFirstName.nextLine();
                changeFirstName(username, newFirstName);
                break;
            case 4:
                Scanner inputNewLastName = new Scanner(System.in);
                System.out.println("Enter your new last name : ");
                String newLastName = inputNewLastName.nextLine();
                changeLastName(username, newLastName);
                break;
            case 5:
                Scanner inputNewEmail = new Scanner(System.in);
                System.out.println("Enter your new email : ");
                String newEmail = inputNewEmail.nextLine();
                changeEmail(username, newEmail);
                break;
            case 6:
                setIsConnected();
                break;
            case 7:
                // type
                Scanner inputPropertyType = new Scanner(System.in);
                System.out.println("Choose type of your property : " + "\n" + ANSI_PURPLE
                        + PropertyType.HOUSE.getName() + " " + PropertyType.APARTMENT.getName()
                        + " " + PropertyType.DOMAIN.getName() + " " + ANSI_RESET);
                String propertyType = inputPropertyType.nextLine();



                PropertyType finalType = null;
                PropertyType[] propertyTypes = PropertyType.values();
                for (PropertyType p : propertyTypes) {
                    if (p.name().equals(propertyType)) {
                        finalType = p;
                    }
                }
                //propertyName
                Scanner inputPropertyName = new Scanner(System.in);
                System.out.println("Enter the name of your " + propertyType);
                String propertyName = inputPropertyName.nextLine();
                //address
                Scanner inputAdress = new Scanner(System.in);
                System.out.println("Enter the address of your " + propertyType);
                String address = inputAdress.nextLine();
                //city
                Scanner inputCity = new Scanner(System.in);
                System.out.println("Enter the city of your " + propertyType);
                String city = inputCity.nextLine();
                //description
                Scanner inputDescription = new Scanner(System.in);
                System.out.println("Enter the description of your " + propertyType);
                String description = inputDescription.nextLine();
                //max number of occupants
                Scanner inputMaxNumber = new Scanner(System.in);
                System.out.println("Enter the maximum number of occupants of your " + propertyType);
                int maxNumber = inputMaxNumber.nextInt();
                //price for one night
                Scanner inputRateForOneNight = new Scanner(System.in);
                System.out.println("Enter the price for one night and one person of your " + propertyType);
                int rateForOneNight = inputRateForOneNight.nextInt();


                //Creation of property
                currentOwner.addProperty(finalType, propertyName, address, city, description,
                        maxNumber, rateForOneNight);
                for (Property p : currentOwner.getPortfolio()) {
                    if (propertyName.equals(p.getPropertyName())) {
                        p.displayPropertyInfos();
                    }
                }
                break;
            case 8:
                System.out.println(currentOwner.getPropertiesName());
                break;
            case 9:
                boolean isExistingProperty = true;
                while (isExistingProperty) {
                    Scanner inputChoosenProperty = new Scanner(System.in);
                    System.out.println("Choose a property to edit");
                    String chosenProperty = inputChoosenProperty.nextLine();
                    for (Property property : currentOwner.getPortfolio()) {
                        if (chosenProperty.equals(property.getPropertyName())) {
                            Property currentProperty = null;
                            displayEditingPropertyInfos();
                            for (Property p : currentOwner.getPortfolio()) {
                                if (chosenProperty.equals(p.getPropertyName())) {
                                    currentProperty = p;
                                }
                            }
                            currentProperty.editingPropertyInfos();
                            currentProperty.displayPropertyInfos();
                            isExistingProperty = false;
                        } else {
                            System.out.println("Unknown property !");
                        }
                    }
                }
                break;
            case 10:
                System.out.println("Bids on own properties : " + "\n");
                displayBidsOnOwnProperty(username);
                break;
            default:
                System.out.println("Incorrect choice");
                break;
        }
    }

    /**
     * Tenant Dashboard support : manage tenant account
     *
     * @param username the tenant's username
     * @author enzomourany
     */
    public static void tenantDashboard(String username) {
        displayTenantDashboard();
        Tenant currentTenant = null;
        for (User u : users) {
            if (!u.getIsOwner()) {
                if (username.equals(u.getUsername())) {
                    currentTenant = (Tenant) u;
                }
            }

        }
        Scanner commandChoice = new Scanner(System.in);
        int command = commandChoice.nextInt();
        switch(command){
            case 1:
                for (User user : users) {
                    if (username.equals(user.getUsername())) {
                        System.out.println("Username : " + ANSI_CYAN + user.getUsername() + ANSI_RESET + "\n"
                                + "First name : " + ANSI_CYAN + user.getFirstName() + ANSI_RESET + "\n"
                                + "Last name : " + ANSI_CYAN + user.getLastName() + ANSI_RESET + "\n"
                                + "Email : " + ANSI_CYAN + user.getEmail() + ANSI_RESET + "\n"
                        );
                    }
                }
                break;
            case 2:
                Scanner inputNewUsername = new Scanner(System.in);
                System.out.println("Enter your new username : ");
                String newUsername = inputNewUsername.nextLine();
                changeUsername(username, newUsername);
                //username = newUsername;
                //TODO : fix bug
                break;
            case 3:
                Scanner inputNewFirstName = new Scanner(System.in);
                System.out.println("Enter your new first name : ");
                String newFirstName = inputNewFirstName.nextLine();
                changeFirstName(username, newFirstName);
                break;
            case 4:
                Scanner inputNewLastName = new Scanner(System.in);
                System.out.println("Enter your new last name : ");
                String newLastName = inputNewLastName.nextLine();
                changeLastName(username, newLastName);
                break;
            case 5:
                Scanner inputNewEmail = new Scanner(System.in);
                System.out.println("Enter your new email : ");
                String newEmail = inputNewEmail.nextLine();
                changeEmail(username, newEmail);
                break;
            case 6:
                setIsConnected();
                break;
            case 7:
                ArrayList<String> propertiesInfo = new ArrayList<>();
                for (Property p : properties) {
                    propertiesInfo.add(ANSI_YELLOW + p.getPropertyName() + ANSI_RESET + " (Owner : " + ANSI_PURPLE
                            + p.getOwner() + ANSI_RESET + ")");
                }
                System.out.println(propertiesInfo);
                break;
            case 8:
                assert currentTenant != null;
                currentTenant.addMoneyOnWallet();
                System.out.println("Your wallet : " + currentTenant.getWalletBalance());
                break;
            case 9:
                System.out.println(getAllOwners());
                // Owner's name
                boolean isBadOwnersName = true;
                String owner = null;
                while (isBadOwnersName) {
                    Scanner inputOwner = new Scanner(System.in);
                    System.out.println("Enter the owner's name : ");
                    owner = inputOwner.nextLine();
                    for (User user : users) {
                        if (owner.equals(user.getUsername())) {
                            isBadOwnersName = false;
                        }
                    }
                }
                ArrayList<String> ownersProperties = new ArrayList<>();
                for (Property p : getOwnerByUsername(owner).getPortfolio()) {
                    ownersProperties.add(p.getPropertyName());
                }
                System.out.println(ownersProperties);
                // Property's name
                boolean isBadProperty = true;
                String property = null;
                while (isBadProperty) {
                    Scanner inputProperty = new Scanner(System.in);
                    System.out.println("Enter the property's name : ");
                    property = inputProperty.nextLine();
                    for (Property p : getOwnerByUsername(owner).getPortfolio()) {
                        if (property.equals(p.getPropertyName())) {
                            isBadProperty = false;
                        }
                    }
                }

                // Month
                boolean isBadMonth = true;
                String month = null;
                while (isBadMonth) {
                    Scanner inputMonth = new Scanner(System.in);
                    System.out.println("Enter the month of your reservation : ");
                    month = inputMonth.nextLine();
                    for (String m : getMonths()) {
                        if (month.equalsIgnoreCase(m)) {
                            isBadMonth = false;
                        }
                    }
                }

                // Number of occupants
                Scanner inputNbOfOccupants = new Scanner(System.in);
                System.out.println("Enter the number of occupants : ");
                int nbOfOccupants = inputNbOfOccupants.nextInt();
                // Number of nights
                Scanner inputNbOfNights = new Scanner(System.in);
                System.out.println("Enter the number of nights : ");
                int nbOfNights = inputNbOfNights.nextInt();
                // Offer amount
                Scanner inputOfferAmount = new Scanner(System.in);
                // TODO : display the minimum amount
                System.out.println("Enter the amount : ");
                int offerAmount = inputOfferAmount.nextInt();
                // Bid display
                System.out.println("Owner " + ANSI_CYAN + owner + ANSI_RESET + "\n"
                        + "Property name : " + ANSI_CYAN + property + ANSI_RESET + "\n"
                        + "Month : " + ANSI_CYAN + month + ANSI_RESET + "\n"
                        + "Number of occupants : " + ANSI_CYAN + nbOfOccupants + ANSI_RESET + "\n"
                        + "Number of nights : " + ANSI_CYAN + nbOfNights + ANSI_RESET + "\n"
                        + "Offer amount : " + ANSI_CYAN + offerAmount + ANSI_RESET + "\n" + ANSI_RESET
                );
                // Creation of the bid
                bids.add(new Bid(username, owner, property, month, nbOfOccupants, nbOfNights, offerAmount));
                break;
            case 10:
                boolean isBadPropertyName = true;
                String propertyName = null;
                while (isBadPropertyName) {
                    Scanner inputPropertyName = new Scanner(System.in);
                    System.out.println("Enter the property's name : ");
                    propertyName = inputPropertyName.nextLine();
                    for (Bid bid : bids) {
                        if (propertyName.equals(bid.getPropertyName())) {
                            isBadPropertyName = false;
                        }
                    }
                }
                displayBidsPerProperties(propertyName);
                break;
            case 11:
                boolean isBadMonth2 = true;
                String propertyMonth = null;
                while (isBadMonth2) {
                    Scanner inputPropertyMonth = new Scanner(System.in);
                    System.out.println("Enter the property's name : ");
                    propertyMonth = inputPropertyMonth.nextLine();
                    for (Bid bid : bids) {
                        if (propertyMonth.equals(bid.getPropertyName())) {
                            isBadMonth2 = false;
                        }
                    }
                }
                displayBidsPerMonth(propertyMonth);
                break;
            default:
                System.out.println("Incorrect choice");
                break;
        }
    }

    /**
     * Admin Dashboard support : manage admin account
     *
     * @author enzomourany
     */
    public static void adminDashboard() {
        displayAdminDashboard();
        Scanner commandChoice = new Scanner(System.in);
        int command = commandChoice.nextInt();
        switch (command) {
            case 1 -> System.out.println(getAllUsers());
            case 2 -> {
                Scanner inputUserToDelete = new Scanner(System.in);
                System.out.println("Enter the username of the user to be deleted");
                String userToDelete = inputUserToDelete.nextLine();
                deleteUserAccount(userToDelete);
            }
            case 3 -> addNewAdministrator();
            case 4 -> {
                Scanner inputUser = new Scanner(System.in);
                System.out.println("Enter name of the user");
                String user = inputUser.nextLine();
                editUserInfoAccount(user);
            }
            case 5 -> setIsConnected();
            case 6 -> {
                Scanner inputOwnerName = new Scanner(System.in);
                ArrayList<String> allOwners = new ArrayList<>();
                for (User u : users) {
                    if (u.getIsOwner()) {
                        allOwners.add(u.getUsername());
                    }
                }


                String ownerName = null;
                boolean isGoodOwnersName = true;
                while (isGoodOwnersName) {
                    System.out.println("Owners " + allOwners);
                    System.out.println("Enter the name of the owner : ");
                    ownerName = inputOwnerName.nextLine();
                    for (User user : users) {
                        if (user.getIsOwner()) {
                            if (ownerName.equals(user.getUsername())) {
                                isGoodOwnersName = false;
                            }
                        }
                    }

                }


                Scanner inputPropertyName = new Scanner(System.in);
                String propertyName = null;
                boolean isGoodPropertyName = true;
                while (isGoodPropertyName) {
                    System.out.println(getAllPropertiesNames()); // Display all the properties name
                    System.out.println("Enter the name of the property : ");
                    propertyName = inputPropertyName.nextLine();
                    for (Property property : getOwnerByUsername(ownerName).getPortfolio()) {
                        if (propertyName.equals(property.getPropertyName())) {
                            isGoodPropertyName = false;
                        }
                    }
                }

                Scanner inputNewDescription = new Scanner(System.in);
                System.out.println("Property's description : " + ANSI_BLUE +
                        getPropertyByName(ownerName, propertyName).getDescription() + ANSI_RESET); // Display property's description
                System.out.println("Enter the new Description : ");
                String newDescription = inputNewDescription.nextLine();
                changeOwnersPropertyDescription(ownerName, propertyName, newDescription);
                System.out.println("New property's description : " + ANSI_BLUE +
                        getPropertyByName(ownerName, propertyName).getDescription() + ANSI_RESET); // Display new property's description
            }
            case 7 -> {
                System.out.println("All the bids" + "\n");
                displayAllBids();
            }
            default -> System.out.println("Incorrect choice");
        }
    }



    /**
     * @param args the command line arguments
     * @author enzomourany
     */
    public static void main(String[] args) {
        // Defaults users
        users.add(new Administrator());
        users.add(new Tenant("Chris", "Christian", "Bumstead", "chris.bumstead@gmail.com"));
        users.add(new Tenant("Patrick", "Patrick", "Gustin", "patrick.gustin@gmail.com"));
        users.add(new Owner("Sabine", "Sabine", "Young", "sabine.young@outlook.com"));
        users.add(new Owner("Alex", "Alex", "Mousseau", "alex.mousseau@gmail.com"));

        getOwnerByUsername(getAllOwners().get(1)).addProperty(PropertyType.APARTMENT, "Apartment1",
                "address1", "Bordeaux", "description", 7, 100);
        getOwnerByUsername(getAllOwners().get(1)).addProperty(PropertyType.HOUSE, "House1",
                "address2", "Perpignan", "description", 11, 170);
        getOwnerByUsername(getAllOwners().get(1)).addProperty(PropertyType.DOMAIN, "Domain1",
                "address3", "Paris", "description", 18, 490);
        getOwnerByUsername(getAllOwners().get(0)).addProperty(PropertyType.HOUSE, "House2",
                "address4", "Lyon", "description", 6, 390);
        getOwnerByUsername(getAllOwners().get(0)).addProperty(PropertyType.HOUSE, "House3",
                "address5", "Cenon", "description", 7, 210);


        // Filling of properties with all owner's properties
        for (User user : users) {
            if (user.getIsOwner()) {
                Owner owner = (Owner) user;
                for (Property property : owner.getPortfolio()) {
                    properties.add(property);
                }
            }
        }



        bids.add(new Bid(users.get(1).getUsername(), users.get(3).getUsername(), properties.get(0).getPropertyName(),
                "April", 7, 19, 10));
        bids.add(new Bid(users.get(2).getUsername(), users.get(3).getUsername(), properties.get(0).getPropertyName(),
                "November", 6, 7, 20));




        regroupAllOwnersProperties();
        isConnected = false;
        String type = null; // type of account : can be Owner or Tenant
        System.out.println("LOGIN");
        while (!isConnected) {
            Scanner enteredUsername = new Scanner(System.in);
            System.out.println("Enter your username : ");
            String userName = enteredUsername.nextLine();

            if (getAllUsers().contains(userName)) {
                System.out.println("Welcome back " + userName);
                for (User u : users) {
                    if (userName.equals(u.getUsername())) {
                        isConnected = true;
                        while (isConnected) {
                            if (u.getIsOwner()) {
                                ownerDashboard(userName);
                            } else {
                                tenantDashboard(userName);
                            }
                        }
                    }
                }
            } else if (userName.equalsIgnoreCase("Admin") || userName.equalsIgnoreCase("Administrator")) {
                System.out.println("Welcome back, you are now connected as " + ANSI_RED + "Administrator" + ANSI_RESET);
                isConnected = true;
                while (isConnected) {
                    adminDashboard();
                }
            } else {
                System.out.println("Unknown username");
                Scanner retry = new Scanner(System.in);
                System.out.println("You have an account ? : y/n ");
                String sRetry = retry.nextLine();
                if (sRetry.equals("n") || sRetry.equals("no")) {
                    System.out.println("REGISTER");
                    // selected what type of profile
                    while (type == null) {
                        Scanner inputProfileType = new Scanner(System.in);
                        System.out.println("What do you want to be ? : Owner(o) | Tenant(t) ");
                        String profileType = inputProfileType.nextLine();
                        if (profileType.equals("Owner") || profileType.equals("o")) {
                            type = "Owner";
                            break;
                        } else if (profileType.equals("Tenant") || profileType.equals("t")) {
                            type = "Tenant";
                            break;
                        } else {
                            System.out.println(profileType + " is not a correct answer");
                        }
                    }

                    // new Username
                    Scanner inputUsername = new Scanner(System.in);
                    System.out.println("Enter an username : ");
                    String username = inputUsername.nextLine();

                    // firstname
                    Scanner inputFirstname = new Scanner(System.in);
                    System.out.println("Enter your first name : ");
                    String firstname = inputFirstname.nextLine();

                    // lastname
                    Scanner inputLastname = new Scanner(System.in);
                    System.out.println("Enter your last name : ");
                    String lastname = inputLastname.nextLine();

                    // email
                    Scanner inputEmail = new Scanner(System.in);
                    System.out.println("Enter your email : ");
                    String email = inputEmail.nextLine();

                    if (type.equals("Owner")) {
                        users.add(new Owner(username, firstname, lastname, email));
                    } else {
                        users.add(new Tenant(username, firstname, lastname, email));
                    }

                    System.out.println("Welcome " + username + " ! " + "You are now a " + ANSI_BLUE + type + ANSI_RESET);

                    isConnected = true;
                    while (isConnected) {

                        if (type.equals("Owner")) {
                            ownerDashboard(username);
                        } else {
                            tenantDashboard(username);
                        }
                    }
                }
            }
        }
    }
}

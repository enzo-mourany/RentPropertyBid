/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import property.Property;
import property.PropertyType;
import users.*;

import java.util.ArrayList;
import java.util.Scanner;

import static property.Property.displayEditingPropertyInfos;
import static users.Administrator.*;
import static users.Owner.*;
import static users.Tenant.displayTenantDashboard;


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

    public static ArrayList<User> users = new ArrayList<>();

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
        Scanner commandChoice = new Scanner(System.in);  // Create a Scanner object
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
                addProperty(username, finalType, propertyName, address, city, description, maxNumber, rateForOneNight);
                for (Property p : portfolio) {
                    if (propertyName.equals(p.getPropertyName())) {
                        p.displayPropertyInfos();
                    }
                }
                break;
            case 8:
                System.out.println(getPropertiesName());
                break;
            case 9:
                boolean isExistingProperty = true;
                while (isExistingProperty) {
                    Scanner inputChoosenProperty = new Scanner(System.in);
                    System.out.println("Choose a property to edit");
                    String chosenProperty = inputChoosenProperty.nextLine();
                    for (Property property : portfolio) {
                        if (chosenProperty.equals(property.getPropertyName())) {
                            Property currentProperty = null;
                            displayEditingPropertyInfos();
                            for (Property p : portfolio) {
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
        Scanner commandChoice = new Scanner(System.in);  // Create a Scanner object
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
                ArrayList<String> allProperties = new ArrayList<>();
                for (User u : users) {
                    if (u.getIsOwner()) {
                        allProperties.add(getPropertiesName().toString());
                    }
                }
                System.out.println(allProperties);
                break;
            case 8:
                assert currentTenant != null;
                currentTenant.addMoneyOnWallet();
                System.out.println("Your wallet : " + currentTenant.getWalletBalance());
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
        Scanner commandChoice = new Scanner(System.in);  // Create a Scanner object
        int command = commandChoice.nextInt();
        switch(command){
            case 1:
                System.out.println(getAllUsers());
                break;
            case 2:
                Scanner inputUserToDelete = new Scanner(System.in);
                System.out.println("Enter the username of the user to be deleted");
                String userToDelete = inputUserToDelete.nextLine();
                deleteUserAccount(userToDelete);
                break;
            case 3:
                addNewAdministrator();
                break;
            case 4:
                Scanner inputUser = new Scanner(System.in);
                System.out.println("Enter name of the user");
                String user = inputUser.nextLine();
                editUserInfoAccount(user);
            case 5:
                setIsConnected();
                break;
            case 6:
                Scanner inputOwnerName = new Scanner(System.in);
                // TODO: Display all the owner's name
                System.out.println("Enter the name of the owner : ");
                String ownerName = inputOwnerName.nextLine();
                Scanner inputPropertyName = new Scanner(System.in);
                // TODO: Display all the propertes
                System.out.println("Enter the name of the property : ");
                String propertyName = inputPropertyName.nextLine();
                Scanner inputNewDescription = new Scanner(System.in);
                // TODO: Display all the current description
                System.out.println("Enter the new Description : ");
                String newDescription = inputNewDescription.nextLine();
                changeOwnersPropertyDescription(ownerName, propertyName, newDescription);
            default:
                System.out.println("Incorrect choice");
                break;
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



        isConnected = false;
        boolean isAdmin = false;
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
                // TODO: Display dashboard
                isConnected = true;
            } else if (userName.equalsIgnoreCase("Admin") || userName.equalsIgnoreCase("Administrator")) {
                System.out.println("Welcome back, you are now connected as " + ANSI_RED + "Administrator" + ANSI_RESET);
                isConnected = true;
                isAdmin = true;
            } else {
                System.out.println("Unknown username");
                Scanner retry = new Scanner(System.in);
                System.out.println("You have an account ? : y/n ");
                String sRetry = retry.nextLine();
                if (sRetry.equals("n") || sRetry.equals("no")) {
                    System.out.println("REGISTER");
                    // selected what type of profile
                    while (type == null) {
                        Scanner inputProfileType = new Scanner(System.in);  // Create a Scanner object
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
        if (isAdmin) {
            isConnected = true;
            while (isConnected) {
                adminDashboard();
            }

        }

    }
    
}

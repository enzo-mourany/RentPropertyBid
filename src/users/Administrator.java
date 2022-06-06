/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package users;

import management.Bid;
import property.Property;

import java.util.Scanner;

import static main.Main.*;
import static users.Owner.*;

/**
 *
 * @author enzomourany
 */
public class Administrator extends User {

    private final String USERNAME = "Administrator";
    public Administrator() {
        this.username = USERNAME;
        isAdmin = true;
    }

    /**
     * Display all admin commands on the console
     */
    public static void displayAdminDashboard() {
        System.out.println(ANSI_GREEN + "1. Display all users" + "\n"
                + "2. Delete an account" + "\n"
                + "3. Add new administrator" + "\n"
                + "4. Edit user's account information" + "\n"
                + "5. Disconnect" + "\n"
                + "6. Change property description" + "\n"
                + "7. Display all bids" + ANSI_RESET + "\n"
            );
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

    /**
     * Add a new administrator account
     */
    public static void addNewAdministrator() {
        users.add(new Administrator());
    }




    /* ===============================================================================================================
    *           Edit user information
    =============================================================================================================== */


    //TODO : change by setter users
    public static void changeUsersUsername(User user, String newUsername) {
        user.setUsername(newUsername);
    }

    public static void changeUsersFirstName(User user, String newFirstName) {
        user.setFirstName(newFirstName);
    }

    public static void changeUsersLastName(User user, String newLastName) {
        user.setLastName(newLastName);
    }

    public static void changeUsersEmail(User user, String newEmail) {
        user.setEmail(newEmail);
    }

    /**
     * Change infos of a user
     * @param user the selected user
     */
    public static void editUserInfoAccount(String user) {
        for (User u : users) {
            if (user.equals(u.getUsername())) {
                Boolean quit = true;
                while (quit) {
                    System.out.println(ANSI_GREEN + "1. Display user's account information" + "\n"
                            + "2. Change user's username" + "\n"
                            + "3. Change user's first name" + "\n"
                            + "4. Change user's last name" + "\n"
                            + "5. Change user's email" + "\n"
                            + "6. Quit" + ANSI_RESET + "\n"
                        );
                    Scanner commandChoice = new Scanner(System.in);
                    int command = commandChoice.nextInt();
                    switch(command){
                        case 1:
                            System.out.println("Username : " + ANSI_CYAN + u.getUsername() + ANSI_RESET + "\n"
                                    + "First name : " + ANSI_CYAN + u.getFirstName() + ANSI_RESET + "\n"
                                    + "Last name : " + ANSI_CYAN + u.getLastName() + ANSI_RESET + "\n"
                                    + "Email : " + ANSI_CYAN + u.getEmail() + ANSI_RESET + "\n"
                            );
                            break;
                        case 2:
                            Scanner inputNewUsername = new Scanner(System.in);
                            System.out.println("Enter new user's username : ");
                            String newUsername = inputNewUsername.nextLine();
                            changeUsersUsername(u, newUsername);
                            break;
                        case 3:
                            Scanner inputNewFirstName = new Scanner(System.in);
                            System.out.println("Enter new user's first name : ");
                            String newFirstName = inputNewFirstName.nextLine();
                            changeUsersFirstName(u, newFirstName);
                            break;
                        case 4:
                            Scanner inputNewLastName = new Scanner(System.in);
                            System.out.println("Enter new user's last name : ");
                            String newLastName = inputNewLastName.nextLine();
                            changeUsersLastName(u, newLastName);
                            break;
                        case 5:
                            Scanner inputNewEmail = new Scanner(System.in);
                            System.out.println("Enter new user's email : ");
                            String newEmail = inputNewEmail.nextLine();
                            changeUsersEmail(u, newEmail);
                            break;
                        case 6:
                            quit = false;
                            break;
                        default:
                            System.out.println("Incorrect choice");
                            break;
                    }
                }
            }
        }
    }

    /* ===============================================================================================================
    *           Edit owner's property information
    =============================================================================================================== */

    public static void changeOwnersPropertyDescription(String ownerName, String propertyName, String newDescription) {
        boolean isDone = true;
        boolean isGoodOwnersName = true;
        while (isGoodOwnersName) {
            for (User user : users) {
                if (ownerName.equals(user.getUsername())) {
                    while (isDone) {
                        for (Property property : getOwnerByUsername(user.getUsername()).getPortfolio()) {
                            if (propertyName.equals(property.getPropertyName())) {
                                property.setDescription(newDescription);
                                isDone = false;
                            }
                        }
                    }
                    isGoodOwnersName = false;
                }
            }
        }
    }

    /**
     * Display all the bids
     */
    public static void displayAllBids() {
        for (Bid bid : bids) {
            System.out.println("Tenant : " + ANSI_CYAN + bid.getTenant() + ANSI_RESET + "\n"
                    + "Owner : " + ANSI_CYAN + bid.getOwner() + ANSI_RESET + "\n"
                    + "Property's name : " + ANSI_CYAN + bid.getPropertyName() + ANSI_RESET + "\n"
                    + "Amount : " + ANSI_CYAN + bid.getOfferAmount() + ANSI_RESET + "\n"
                    + "-------------------------------------------------------" + "\n"
            );
        }
    }
}

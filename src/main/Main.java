/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import users.*;

import java.util.ArrayList;
import java.util.Scanner;

import static users.Administrator.*;
import static users.User.*;


/**
 *
 * @author enzomourany
 */
public class Main {

    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RESET = "\u001B[0m";

    public static ArrayList<User> users = new ArrayList<>();

    public static ArrayList<String> getAllUsers() {
        ArrayList<String> usernames = new ArrayList<>();
        for (User user : users) {
            usernames.add(user.getUsername());
        }
        return usernames;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Defaults users
        users.add(new Administrator());
        users.add(new Tenant("Chris", "Christian", "Bumstead", "chris.bumstead@gmail.com"));
        users.add(new Tenant("Patrick", "Patrick", "Gustin", "patrick.gustin@gmail.com"));
        users.add(new Owner("Sabine", "Sabine", "Young", "sabine.young@outlook.com"));
        users.add(new Owner("Alex", "Alex", "Mousseau", "alex.mousseau@gmail.com"));


        Boolean connected = false;
        Boolean isAdmin = false;
        String type = null; // type of account : can be Owner or Tenant
        System.out.println("LOGIN");
        while (connected == false) {
            Scanner enteredUsername = new Scanner(System.in);  // Create a Scanner object
            System.out.println("Enter your username : ");
            String userName = enteredUsername.nextLine();  // Read user input

            if (userName.equals(users.get(0))) {
                System.out.println("Welcome back " + userName);
                connected = true;
            } else if (userName.equalsIgnoreCase("Admin") || userName.equalsIgnoreCase("Administrator")) {
                System.out.println("Welcome back, you are now connected as " + ANSI_RED + "Administrator" + ANSI_RESET);
                connected = true;
                isAdmin = true;
            } else {
                System.out.println("Unknown username");
                Scanner retry = new Scanner(System.in);  // Create a Scanner object
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
                            System.out.println(profileType + " is not a correct awnser");
                        }
                    }

                    // new Username
                    Scanner inputUsername = new Scanner(System.in);  // Create a Scanner object
                    System.out.println("Enter an username : ");
                    String username = inputUsername.nextLine();

                    // firstname
                    Scanner inputFirstname = new Scanner(System.in);  // Create a Scanner object
                    System.out.println("Enter your firstname : ");
                    String firstname = inputUsername.nextLine();

                    // lastname
                    Scanner inputLastname = new Scanner(System.in);  // Create a Scanner object
                    System.out.println("Enter your lastname : ");
                    String lastname = inputUsername.nextLine();

                    // email
                    Scanner inputEmail = new Scanner(System.in);  // Create a Scanner object
                    System.out.println("Enter your email : ");
                    String email = inputUsername.nextLine();

                    if (type.equals("Owner")) {
                        users.add(new Owner(username, firstname, lastname, email));
                    } else {
                        users.add(new Tenant(username, firstname, lastname, email));
                    }

                    System.out.println("Welcome " + username + " ! " + "You are now a " + ANSI_BLUE + type + ANSI_RESET);
                    connected = true;
                    displayDashboard();
                    Scanner commandChoice = new Scanner(System.in);  // Create a Scanner object
                    int command = commandChoice.nextInt();
                    switch(command){
                        case 1:

                            break;
                        case 2:
                            Scanner InputNewUsername = new Scanner(System.in);
                            System.out.println("Enter your new username : ");
                            String newUsername = InputNewUsername.nextLine();
                            changeUsername(username, newUsername);
                            break;
                        default:
                            System.out.println("Incorrect choice");
                            break;
                    }
                }
            }
        }
        if (isAdmin) {
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
                default:
                    System.out.println("Incorrect choice");
                    break;
            }
        }

    }
    
}

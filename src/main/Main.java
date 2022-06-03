/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import users.*;

import java.util.ArrayList;
import java.util.Scanner;


/**
 *
 * @author enzomourany
 */
public class Main {

    ArrayList<User> users;



    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<User> users = new ArrayList<>();
        users.add(new Tenant("Chris"));
        users.add(new Tenant("Alex"));
        users.add(new Owner("Patrick"));
        users.add(new Owner("Sabine"));
        users.add(new Administrator());


        Boolean connected = false;
        String type = null;
        System.out.println("LOGIN");
        while (connected == false) {
            Scanner enteredUsername = new Scanner(System.in);  // Create a Scanner object
            System.out.println("Enter your username : ");
            String userName = enteredUsername.nextLine();  // Read user input
            if (userName.equals(Logins.USER1.username)) {
                System.out.println("Welcome back " + userName);
                connected = true;
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
                    Scanner inputNewUsername = new Scanner(System.in);  // Create a Scanner object
                    System.out.println("Enter an username : ");
                    String newUsername = inputNewUsername.nextLine();


                    if (type.equals("Owner")) {
                        users.add(new Owner(newUsername));
                    } else {
                        users.add(new Tenant(newUsername));
                    }

                    System.out.println("Welcome " + newUsername + " ! " + "You are now a " + type);
                    connected = true;
                }
            }
        }

    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import users.Logins;

import java.util.Scanner;


/**
 *
 * @author enzomourany
 */
public class Main {
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Boolean connected = false;
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
                    // new Username
                    Scanner inputNewUsername = new Scanner(System.in);  // Create a Scanner object
                    System.out.println("Enter an username : ");
                    String newUsername = inputNewUsername.nextLine();

                    // new Password
                    Scanner inputNewPassword = new Scanner(System.in); // Create a Scanner object
                    System.out.println("Enter a password : ");
                    String newPassword = inputNewPassword.nextLine();
                    System.out.println("Welcome " + newUsername + " !");
                    connected = true;
                }
            }
        }

    }
    
}

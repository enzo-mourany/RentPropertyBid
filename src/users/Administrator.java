/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package users;

import java.util.Scanner;

import static main.Main.*;
//import static main.Main.ANSI_GREEN;
//import static main.Main.ANSI_RESET;
//import static main.Main.users;

/**
 *
 * @author enzomourany
 */
public class Administrator extends User {

    private final String USERNAME = "Administrator";
    public Administrator() {
        this.username = USERNAME;
    }


    public static void displayAdminDashboard() {
        System.out.println(ANSI_GREEN + "1. Display all users" + ANSI_RESET);
        System.out.println(ANSI_GREEN + "2. Delete an account" + ANSI_RESET);
        System.out.println(ANSI_GREEN + "3. Add new administrator" + ANSI_RESET);
        System.out.println(ANSI_GREEN + "4. Edit user's account information" + ANSI_RESET);
        System.out.println(ANSI_GREEN + "5. Disconnect" + ANSI_RESET);
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

    public static void addNewAdministrator() {
        users.add(new Administrator());
    }

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

    public static void editUserInfoAccount(String user) {
        for (User u : users) {
            if (user.equals(u.getUsername())) {
                Boolean quit = true;
                while (quit) {
                    System.out.println(ANSI_GREEN + "1. Display user's account information" + ANSI_RESET);
                    System.out.println(ANSI_GREEN + "2. Change user's username" + ANSI_RESET);
                    System.out.println(ANSI_GREEN + "3. Change user's first name" + ANSI_RESET);
                    System.out.println(ANSI_GREEN + "4. Change user's last name" + ANSI_RESET);
                    System.out.println(ANSI_GREEN + "5. Change user's email" + ANSI_RESET);
                    System.out.println(ANSI_GREEN + "6. Quit" + ANSI_RESET);
                    Scanner commandChoice = new Scanner(System.in);  // Create a Scanner object
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
                            Scanner InputNewUsername = new Scanner(System.in);
                            System.out.println("Enter new user's username : ");
                            String newUsername = InputNewUsername.nextLine();
                            changeUsersUsername(u, newUsername);
                            break;
                        case 3:
                            Scanner InputNewFirstName = new Scanner(System.in);
                            System.out.println("Enter new user's first name : ");
                            String newFirstName = InputNewFirstName.nextLine();
                            changeUsersFirstName(u, newFirstName);
                            break;
                        case 4:
                            Scanner InputNewLastName = new Scanner(System.in);
                            System.out.println("Enter new user's last name : ");
                            String newLastName = InputNewLastName.nextLine();
                            changeUsersLastName(u, newLastName);
                            break;
                        case 5:
                            Scanner InputNewEmail = new Scanner(System.in);
                            System.out.println("Enter new user's email : ");
                            String newEmail = InputNewEmail.nextLine();
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


}

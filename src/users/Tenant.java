/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package users;

import management.Bid;

import java.util.Scanner;

import static main.Main.*;
import static main.Main.ANSI_CYAN;

/**
 *
 * @author enzomourany
 */
public class Tenant extends User {

    private int walletBalance;

    public Tenant(String _username, String _firstName, String _lastName, String _email) {
        this.username = _username;
        this.firstName = _firstName;
        this.lastName = _lastName;
        this.email = _email;
        this.walletBalance = 0;
    }

    /**
     * Display all tenant commands on console
     *
     * @author enzomourany
     */
    public static void displayTenantDashboard() {
        System.out.println(ANSI_GREEN + "1. See your account information" + "\n"
                + "2. Change Username" + "\n"
                + "3. Change First name" + "\n"
                + "4. Change Last name" + "\n"
                + "5. Change email" + "\n"
                + "6. Disconnect" + "\n"
                + "7. See all properties" + "\n"
                + "8. Add money on wallet" + "\n"
                + "9. Make a bid on a property" + "\n" + ANSI_RESET
        );
    }

    public void setWalletBalance(int walletBalance) {
        this.walletBalance = walletBalance;
    }

    public int getWalletBalance() {
        return walletBalance;
    }

    /**
     * Add money on tenant wallet
     *
     * @author enzomourany
     */
    public void addMoneyOnWallet() {
        boolean isGoodAmount = true;
        int amount = 0;
        while (isGoodAmount) {
            Scanner inputAmount = new Scanner(System.in);
            System.out.println("Enter a positive integer and a multiple of 5 : ");
            amount = inputAmount.nextInt();
            if (amount > 0 && (amount % 5 == 0)) {
                isGoodAmount = false;
            }
        }
        setWalletBalance(walletBalance + amount);
    }

    /**
     * Display all bids with the same property's name
     *
     * @param propertyName the property's name
     * @author enzomourany
     */
    public static void displayBidsPerProperties(String propertyName) {
        for (Bid bid : bids) {
            if (propertyName.equals(bid.getPropertyName())) {
                System.out.println("Property's name : " + ANSI_CYAN + bid.getPropertyName() + ANSI_RESET + "\n"
                        + "Tenant : " + ANSI_CYAN + bid.getTenant() + ANSI_RESET + "\n"
                        + "Owner : " + ANSI_CYAN + bid.getOwner() + ANSI_RESET + "\n"
                        + "Month : " + ANSI_CYAN + bid.getMonth() + ANSI_RESET + "\n"
                        + "Amount : " + ANSI_CYAN + bid.getOfferAmount() + ANSI_RESET + "\n"
                        + "-------------------------------------------------------" + "\n"
                );
            }

        }
    }

    /**
     * Display all bids with the same month
     *
     * @param month the month
     * @author enzomourany
     */
    public static void displayBidsPerMonth(String month) {
        for (Bid bid : bids) {
            if (month.equals(bid.getMonth())) {
                System.out.println("Property's name : " + ANSI_CYAN + bid.getPropertyName() + ANSI_RESET + "\n"
                        + "Tenant : " + ANSI_CYAN + bid.getTenant() + ANSI_RESET + "\n"
                        + "Owner : " + ANSI_CYAN + bid.getOwner() + ANSI_RESET + "\n"
                        + "Month : " + ANSI_CYAN + bid.getMonth() + ANSI_RESET + "\n"
                        + "Amount : " + ANSI_CYAN + bid.getOfferAmount() + ANSI_RESET + "\n"
                        + "-------------------------------------------------------" + "\n"
                );
            }
        }
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package property;

import java.util.Scanner;

import static main.Main.*;
/**
 *
 * @author enzomourany
 */
public class Property {

    private final String OWNER;
    private PropertyType type;
    private String propertyName;
    private String address;
    private String city;
    private String description;
    private int maxNumberOfOccupants;
    private int rateForOneNight; // for one person

    public Property(String _owner, PropertyType _type, String _propertyName, String _address, String _city,
                    String _description, int _maxNumberOfOccupants, int _rateForOneNight) {
        this.OWNER = _owner;
        this.type = _type;
        this.propertyName = _propertyName;
        this.address = _address;
        this.city = _city;
        this.description = _description;
        this.maxNumberOfOccupants = _maxNumberOfOccupants;
        this.rateForOneNight = _rateForOneNight;
    }

    /* ===============================================================================================================
    *           Setters
    =============================================================================================================== */

    public void setType(PropertyType _type) {
        this.type = _type;
    }

    public void setPropertyName(String _propertyName) {
        this.propertyName = _propertyName;
    }

    public void setAddress(String _address) {
        this.address = _address;
    }

    public void setCity(String _city) {
        this.city = _city;
    }

    public void setDescription(String _description) {
        this.description = _description;
    }

    public void setMaxNumberOfOccupants(int _maxNumberOfOccupants) {
        this.maxNumberOfOccupants = _maxNumberOfOccupants;
    }

    public void setRateForOneNight(int _rateForOneNight) {
        this.rateForOneNight = _rateForOneNight;
    }

    /* ===============================================================================================================
    *           Methods
    =============================================================================================================== */

    public String getPropertyName() {
        return propertyName;
    }

    public String getOwner() {
        return OWNER;
    }

    /**
     * Display all the information for one property
     *
     * @author enzomourany
     */
    public void displayPropertyInfos() {
        System.out.println("Type : " + ANSI_CYAN + this.type + ANSI_RESET + "\n"
                + "Name : " + ANSI_CYAN + this.propertyName + ANSI_RESET + "\n"
                + "Address : " + ANSI_CYAN + this.address + ANSI_RESET + "\n"
                + "City : " + ANSI_CYAN + this.city + ANSI_RESET + "\n"
                + "Description : " + ANSI_CYAN + this.description + ANSI_RESET + "\n"
                + "Maximum number of occupants : " + ANSI_CYAN + this.maxNumberOfOccupants + ANSI_RESET + "\n"
                + "Price for one night : " + ANSI_CYAN + this.rateForOneNight + ANSI_RESET + "\n"
        );
    }

    /**
     * Display all the information able to edit for one property
     *
     * @author enzomourany
     */
    public static void displayEditingPropertyInfos() {
        System.out.println(ANSI_CYAN + "1. Edit type " + "\n"
                + "2. Edit Name" + "\n"
                + "3. Edit Address" + "\n"
                + "4. Edit City" + "\n"
                + "5. Edit Description" + "\n"
                + "6. Edit Maximum number of occupants" + "\n"
                + "7. Edit Price for one night" + ANSI_RESET + "\n"
        );
    }

    /**
     * Property Dashboard support : edit property information
     *
     * @author enzomourany
     */
    public void editingPropertyInfos() {
        Scanner commandChoice = new Scanner(System.in);
        int command = commandChoice.nextInt();
        switch(command) {
            case 1:
                boolean isDone = true;
                while (isDone) {
                    System.out.println("Current type : " + ANSI_CYAN + type.toString() + ANSI_RESET);
                    Scanner inputNewStringType = new Scanner(System.in);
                    System.out.println("Choose a new type of your property : " + "\n" + ANSI_PURPLE
                            + PropertyType.HOUSE.getName() + " " + PropertyType.APARTMENT.getName()
                            + " " + PropertyType.DOMAIN.getName() + " " + ANSI_RESET);
                    String newStringType = inputNewStringType.nextLine();
                    if (newStringType.equalsIgnoreCase("House")) {
                        setType(PropertyType.HOUSE);
                        isDone = false;
                    } else if (newStringType.equalsIgnoreCase("Apartment")) {
                        setType(PropertyType.APARTMENT);
                        isDone = false;
                    } else if (newStringType.equalsIgnoreCase("Domain")) {
                        setType(PropertyType.DOMAIN);
                        isDone = false;
                    } else {
                        System.out.println("Unknown type");
                    }
                }
                break;
            case 2:
                System.out.println("Current property name : " + ANSI_CYAN + propertyName + ANSI_RESET);
                Scanner inputNewPropertyName = new Scanner(System.in);
                System.out.println("Enter a new property name : ");
                String newPropertyName = inputNewPropertyName.nextLine();
                setPropertyName(newPropertyName);
                break;
            case 3:
                System.out.println("Current address : " + ANSI_CYAN + address + ANSI_RESET);
                Scanner inputNewAddress = new Scanner(System.in);
                System.out.println("Enter a new address : ");
                String newAddress = inputNewAddress.nextLine();
                setAddress(newAddress);
                break;
            case 4:
                System.out.println("Current city : " + ANSI_CYAN + city + ANSI_RESET);
                Scanner inputNewCity = new Scanner(System.in);
                System.out.println("Enter a new city : ");
                String newCity = inputNewCity.nextLine();
                setCity(newCity);
                break;
            case 5:
                System.out.println("Current description : " + ANSI_CYAN + description + ANSI_RESET);
                Scanner inputNewDescription = new Scanner(System.in);
                System.out.println("Enter a new description : ");
                String newDescription = inputNewDescription.nextLine();
                setDescription(newDescription);
                break;
            case 6:
                System.out.println("Current maximum number of occupants : " + ANSI_CYAN
                        + maxNumberOfOccupants + ANSI_RESET);
                Scanner inputNewMaxNumberOfOccupants = new Scanner(System.in);
                System.out.println("Enter a new description : ");
                int newMaxNumberOfOccupants = inputNewMaxNumberOfOccupants.nextInt();
                setMaxNumberOfOccupants(newMaxNumberOfOccupants);
                break;
            case 7:
                System.out.println("Current price for one night : " + ANSI_CYAN + rateForOneNight + ANSI_RESET);
                Scanner inputNewRateForOneNight = new Scanner(System.in);
                System.out.println("Enter a new description : ");
                int newRateForOneNight = inputNewRateForOneNight.nextInt();
                setRateForOneNight(newRateForOneNight);
                break;
            default:
                System.out.println("Incorrect choice");
                break;
        }
    }
}

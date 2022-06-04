/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package property;

import static main.Main.*;
/**
 *
 * @author enzomourany
 */
public class Property {
    PropertyType type;
    String propertyName;
    String adress;
    String city;
    String description;
    int maxNumberOfOccupants;
    int rateForOneNight; // for one person

    public Property(PropertyType _type, String _propertyName, String _address, String _city, String _description, int _maxNumberOfOccupants, int _rateForOneNight) {
        this.type = _type;
        this.propertyName = _propertyName;
        this.adress = _address;
        this.city = _city;
        this.description = _description;
        this.maxNumberOfOccupants = _maxNumberOfOccupants;
        this.rateForOneNight = _rateForOneNight;
    }

    public String getPropertyName() {
        return propertyName;
    }
    public void displayPropertyInfos() {
        System.out.println("Type : " + ANSI_CYAN + this.type + ANSI_RESET + "\n"
                + "Name : " + ANSI_CYAN + this.propertyName + ANSI_RESET + "\n"
                + "Adress : " + ANSI_CYAN + this.adress + ANSI_RESET + "\n"
                + "City : " + ANSI_CYAN + this.city + ANSI_RESET + "\n"
                + "Description : " + ANSI_CYAN + this.description + ANSI_RESET + "\n"
                + "Maximum number of occupants : " + ANSI_CYAN + this.maxNumberOfOccupants + ANSI_RESET + "\n"
                + "Price for one night : " + ANSI_CYAN + this.rateForOneNight + ANSI_RESET + "\n"
        );
    }
}

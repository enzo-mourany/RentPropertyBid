/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package property;

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
}

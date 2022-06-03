/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package users;

import property.Property;

import java.util.ArrayList;

/**
 *
 * @author enzomourany
 */
public class Owner extends User {

    ArrayList<Property> properties;
    public Owner(String _username) {
        this.username = _username;
        this.properties = new ArrayList<>();
    }
}

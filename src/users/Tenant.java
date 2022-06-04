/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package users;

/**
 *
 * @author enzomourany
 */
public class Tenant extends User {



    public Tenant(String _username, String _firstName, String _lastName, String _email) {
        this.username = _username;
        this.firstName = _firstName;
        this.lastName = _lastName;
        this.email = _email;
    }
}

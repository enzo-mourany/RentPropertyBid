/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package management;

/**
 *
 * @author enzomourany
 */
public class Bid {

    private String tenant; // name of the tenant
    private String owner; // name of the owner
    private String propertyName; // Name of the property
    private String month; // Month of lease
    private int nbOfOccupants;
    private int nbOfNights;
    private int offerAmount; // by tenant
    private int minOfferAmount; // The minimum of offer amount for the bid (by owner)
    private int priceForOneNight; // Price for one night and one person for the property

    public Bid(String _tenant, String _owner, String _name, String _month, int _nbOfOccupants, int _nbOfNights,
               int _offerAmount) {
        this.tenant = _tenant;
        this.owner = _owner;
        this.propertyName = _name;
        this.month = _month;
        this.nbOfOccupants = _nbOfOccupants;
        this.nbOfNights = _nbOfNights;
        this.offerAmount = _offerAmount;
        //this.priceForOneNight = getPropertyByName(_owner, _name).getRateForOneNight();
        //this.minOfferAmount = _nbOfOccupants * _nbOfNights * priceForOneNight; // TODO : arondir au multiple suivant de 10
    }

    public String getTenant() {
        return tenant;
    }

    public String getOwner() {
        return owner;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public int getOfferAmount() {
        return offerAmount;
    }

    public String getMonth() {
        return month;
    }

}

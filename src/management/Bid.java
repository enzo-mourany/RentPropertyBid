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

    private String name;
    private String month;
    private int nbOfOccupants;
    private int nbOfNights;
    private int offerAmount;
    private int minOfferAmount; // The minimum of offer amount for the bid
    private int priceForOneNight; // Price for one night and one person for the property

    public Bid(String _name, String _month, int _nbOfOccupants, int _nbOfNights, int _offerAmount) {
        this.name = _name;
        this.month = _month;
        this.nbOfOccupants = _nbOfOccupants;
        this.nbOfNights = _nbOfNights;
        this.offerAmount = _offerAmount;
        this.minOfferAmount = _nbOfOccupants * _nbOfNights * priceForOneNight; // TODO : arondir au multiple suivant de 10
    }
}
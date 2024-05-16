/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dealornodeal;

import java.util.ArrayList;

/**
 * Banker class creates and saves offers
 * @author group69
 */
public class Banker {

    private int prizeMultiplier;
    ArrayList<Integer> pastOffers;

    //Banker constructor sets the prizeMultiplier to the roundNum and creates an pastOffers arraylist
    //takes a roundnum as a parameter
    public Banker(int roundNum) {
        this.prizeMultiplier = roundNum;
        this.pastOffers = new ArrayList<>();

    }
    
    //creates an offer by finding the average of the total prizes in the pool and multiplying it by the prize multiplier
    //takes prizes arraylist as a parameter and returns the offer
    public int makeOffer(ArrayList<Integer> prizes) {
        int value = 0;
        
        for (int p : prizes) {
            value += p;
        }
        int offer = (value / prizes.size()) * this.prizeMultiplier/5;
        
        this.prizeMultiplier++;
        this.pastOffers.add(offer);
        return offer;
    }

    //returns the list of past offers
    public ArrayList<Integer> getPastOffers() {
        return pastOffers;
    }
    
    

}

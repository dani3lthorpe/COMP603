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
    private int[] pastOffers;
    private int totalOffers;

    //Banker constructor sets the prizeMultiplier to the roundNum, creates a pastOffers arraylist and creates a totalOffers variable
    //takes a roundnum as a parameter
    public Banker(int roundNum) {
        this.prizeMultiplier = roundNum;
        this.pastOffers = new int[7];
        this.totalOffers = 0;

    }
    
    //creates an offer by finding the average of the total prizes in the pool and multiplying it by the prize multiplier
    //takes prizes arraylist as a parameter and returns the offer
    public int makeOffer(ArrayList<Integer> prizes) {
        int value = 0;
        
        for (int p : prizes) {
            value += p;
        }
        int offer = (value / prizes.size()) * this.prizeMultiplier/3;
        
        this.prizeMultiplier++;
        this.pastOffers[totalOffers] = offer;
        this.totalOffers++;
        return offer;
    }

    //returns the list of past offers
    public  int[] getPastOffers() {
        return pastOffers;
    }
    
    

}

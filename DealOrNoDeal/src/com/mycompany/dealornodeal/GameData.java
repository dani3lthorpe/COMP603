/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dealornodeal;

import java.util.ArrayList;

/**
 * GameData class stores all the core gameData to be sent to the views
 *
 * @author group69
 */
public class GameData {

    private int numCasesToPick;
    private int round;
    private int currentOffer;
    private boolean userCasePicked;
    private Case currentCase;
    private Case playerCase;
    private boolean dealAccepted;
    private int[] pastOffers;

    // Constructor for game data and takes cases to pick as a parameter. 
    // sets round to 1, sets num cases to pick to the amount of cases to be picked, sets userCasePicked to false, player case to null and deal accepted to false
    public GameData(int numCasesToPick) {
        this.round = 1;
        this.numCasesToPick = numCasesToPick;
        this.userCasePicked = false;
        this.playerCase = null;
        this.dealAccepted = false;
    }
    
    // Gets cases to pick
    public int getNumCasesToPick() {
        return numCasesToPick;
    }
    
    // Sets cases to pick
    public void setNumCasesToPick(int casesToPick) {
        this.numCasesToPick = casesToPick;
    }
    
    // Sets current case to the case the user opened and removes 1 from the number of cases to pick
    public void caseOpened(Case currentCase) {
        this.currentCase = currentCase;
        this.numCasesToPick--;
    }

    // Gets the round number
    public int getRound() {
        return round;
    }

    // Increases round by 1
    public void increaseRound() {
        this.round = round + 1;
    }

    // Checks if the user has selected their case
    public boolean isUserCasePicked() {
        return userCasePicked;
    }

    // Takes the boolean userCasePicked as a parameter, sets UserCasePicked to the input boolean 
    public void setUserCasePicked(boolean userCasePicked) {
        this.userCasePicked = userCasePicked;
    }

    // Gets current case
    public Case getCurrentCase() {
        return currentCase;
    }

    // Gets player case
    public Case getPlayerCase() {
        return playerCase;
    }

    // Takes playerCase as a parameter, sets both the player case and current case to the input player case
    public void setPlayerCase(Case playerCase) {
        this.playerCase = playerCase;
        this.currentCase = playerCase;
    }

    // Gets current bank offer
    public int getCurrentOffer() {
        return currentOffer;
    }

    // Takes currentOffer as a parameter, sets the current offer to the input current offer
    public void setCurrentOffer(int currentOffer) {
        this.currentOffer = currentOffer;
    }

    // Takes the round number as an input parameter, sets the current round to the input round number 
    public void setRound(int round) {
        this.round = round;
    }

    // Sets the current case to null
    public void openedCase() {
        this.currentCase = null;
    }

    // Returns the boolean dealAccepted
    public boolean isDealAccepted() {
        return dealAccepted;
    }

    // Takes the boolean dealAccepted as a parameter, sets dealAccepted to the input boolean
    public void setDealAccepted(boolean dealAccepted) {
        this.dealAccepted = dealAccepted;
    }

    // Takes the pastOffers array as a parameter, sets the past offers to the input array
    public void setPastOffers(int[] pastOffers) {
        this.pastOffers = pastOffers;
    }

    // Gets past offers
    public int[] getPastOffers() {
        return pastOffers;
    }
   
}

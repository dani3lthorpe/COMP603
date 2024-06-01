/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dealornodeal;

import java.util.ArrayList;

/**
 *
 * @author hidan
 */
public class GameInfo {

    private int casesToPick;
    private int round;
    private int currentOffer;
    private boolean userCasePicked;
    private Case currentCase;
    private Case playerCase;
    private boolean dealAccepted;
    private int[] pastOffers;

    public GameInfo(int casesToPick) {
        this.round = 1;
        this.casesToPick = casesToPick;
        this.userCasePicked = false;
        this.playerCase = null;
        this.dealAccepted = false;
    }

    public int getCasesToPick() {
        return casesToPick;
    }

    public void setCasesToPick(int casesToPick) {
        this.casesToPick = casesToPick;
    }

    public void casePicked(Case currentCase) {
        this.currentCase = currentCase;
        this.casesToPick--;
    }

    public int getRound() {
        return round;
    }

    public void increaseRound() {
        this.round = round + 1;
    }

    public boolean isUserCasePicked() {
        return userCasePicked;
    }

    public void setUserCasePicked(boolean userCasePicked) {
        this.userCasePicked = userCasePicked;
    }

    public Case getCurrentCase() {
        return currentCase;
    }

    public Case getPlayerCase() {
        return playerCase;
    }

    public void setPlayerCase(Case playerCase) {
        this.playerCase = playerCase;
        this.currentCase = playerCase;
    }

    public int getCurrentOffer() {
        return currentOffer;
    }

    public void setCurrentOffer(int currentOffer) {
        this.currentOffer = currentOffer;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public void openedCase() {
        this.currentCase = null;
    }

    public boolean isDealAccepted() {
        return dealAccepted;
    }

    public void setDealAccepted(boolean dealAccepted) {
        this.dealAccepted = dealAccepted;
    }

    public void setPastOffers(int[] pastOffers) {
        this.pastOffers = pastOffers;
    }

    public int[] getPastOffers() {
        return pastOffers;
    }
   
}

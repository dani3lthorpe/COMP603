/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dealornodeal;

/**
 *
 * @author hidan
 */
public class GameInfo {

    private int casesToPick;
    private int round;
    private boolean userCasePicked;
    private Case currentCase;

    public GameInfo(int casesToPick) {
        this.round = 1;
        this.casesToPick = casesToPick;
        this.userCasePicked = false;
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

    public void setRound(int round) {
        this.round = round;
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

    
    
    
}

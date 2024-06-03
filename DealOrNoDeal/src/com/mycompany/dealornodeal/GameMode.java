/*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
     * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dealornodeal;

import java.util.ArrayList;
import static java.util.Collections.shuffle;

/**
 * GameMode Abstract class creates a template for each of the GameMode
 * subclasses
 *
 * @author group69
 */
public abstract class GameMode implements Game{

    private ArrayList<Integer> prizes;
    private Player player;
    private ArrayList<Case> cases;
    private int totalGames;
    private int totalPrizes;
    private GameData gameData;
    private Banker banker;

    //GameMode constructor creates the prizes and cases arraylist
    // adds the value from the prizes array to the prizes arraylist and sets the player to the player parameter
    public GameMode(Player player, int[] prizes, GameData gameData) {
        this.player = player;
        this.prizes = new ArrayList<>();
        this.cases = new ArrayList<>();
        this.gameData = gameData;
        this.banker = new Banker(gameData.getRound());
        for (int m : prizes) {
            this.prizes.add(m);
        }
        setCases();
    }

    //shuffles the prizes arraylist before creating cases and adding them to the case arrayList
    //using the shuffle prize values
    public final void setCases() {
        ArrayList<Integer> shuffledPrizes = new ArrayList<>(this.prizes);
        shuffle(shuffledPrizes);

        for (int i = 0; i < shuffledPrizes.size(); i++) {
            this.cases.add(new Case(i + 1, shuffledPrizes.get(i)));
        }
    }

   
    public void removePrize(int caseNum) {
        this.prizes.removeIf(prize -> prize.equals(cases.get(caseNum).getPrize()));
    }

    //displays an offer from a banker for the user to choose to accept or decline
    //takes a banker and scanner as parameter
    public void displayOffer() {
        this.gameData.setCurrentOffer(banker.makeOffer(prizes));
        this.gameData.setPastOffers(banker.getPastOffers());
    }

    public void acceptOffer() {
        int offer = gameData.getCurrentOffer();
        this.totalPrizes += offer;
        if (offer > this.player.getHighestPrize()) {
            this.player.setHighestPrize(offer);
        }
        this.player.addTotalPrizes(offer);
        this.player.addNewRecentPrizes(offer);
        this.player.addNewHighPrizes(offer);
        this.gameData.setDealAccepted(true);
        this.totalGames++;
    }

    public void openYourCase() {
        Case yourCase = gameData.getPlayerCase();
        if (yourCase.getPrize() > getPlayer().getHighestPrize()) {
            getPlayer().setHighestPrize(yourCase.getPrize());
        }
        this.totalPrizes += yourCase.getPrize();
        getPlayer().addTotalPrizes(yourCase.getPrize());
        getPlayer().addNewRecentPrizes(yourCase.getPrize());
        getPlayer().addNewHighPrizes(yourCase.getPrize());
        this.totalGames++;
    }

    //returns the player
    public Player getPlayer() {
        return player;
    }

    //returns the case arraylist
    public ArrayList<Case> getCases() {
        return cases;
    }

    //returns total games
    public int getTotalGames() {
        return totalGames;
    }

    //returns the totalPrizes
    public int getTotalPrizes() {
        return totalPrizes;
    }

    //sets total games to a total games parameter
    public void setTotalGames(int totalGames) {
        this.totalGames = totalGames;
    }

    //sets total prizes to a total prizes parameter
    public void setTotalPrizes(int totalPrizes) {
        this.totalPrizes = totalPrizes;
    }
    
    public GameData getGameData() {
        return gameData;
    }

    public ArrayList<Integer> getPrizes() {
        return prizes;
    }
    

    //abstract methods for subclasses to override
    @Override
    public abstract void newRound();

}

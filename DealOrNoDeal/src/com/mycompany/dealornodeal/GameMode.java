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
    private int globalTotalPrizes;
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

   
    public void removePrize(int index) {
        this.prizes.removeIf(prize -> prize.equals(cases.get(index).getPrize()));
    }

    //Sets the offer in the game data
    //takes a banker and scanner as parameter
    public void setOffer() {
        this.gameData.setCurrentOffer(banker.makeOffer(prizes));
        this.gameData.setPastOffers(banker.getPastOffers());
    }

    // Instantiates offer with the current offer from gameData, adds offer to global total prizes, if the offer is higher than the players highest prize in the database it their highest prize to the current offer
    // Adds offer to the players total prizes, calls add new high prizes with the parameter offer, sets deal accepted to true and adds 1 to total games.
    public void acceptOffer() {
        int offer = gameData.getCurrentOffer();
        this.globalTotalPrizes += offer;
        if (offer > this.player.getHighestPrize()) {
            this.player.setHighestPrize(offer);
        }
        this.player.addTotalPrizes(offer);
        this.player.addNewRecentPrizes(offer);
        this.player.addNewHighPrizes(offer);
        this.gameData.setDealAccepted(true);
        this.totalGames++;
    }

    // Initialises yourCase with the player case from gameData, if the amount in the case is higher than the players highest prize it sets the players highest prize to the case amount
    // Adds the case prize to the global total prizes, adds the case prize to the players total prizes, adds the case prize to the players recent prizes, calls add new high prize with case prize as a parameter
    // Increases total games by 1
    public void openYourCase() {
        Case yourCase = gameData.getPlayerCase();
        if (yourCase.getPrize() > this.player.getHighestPrize()) {
            this.player.setHighestPrize(yourCase.getPrize());
        }
        this.globalTotalPrizes += yourCase.getPrize();
        this.player.addTotalPrizes(yourCase.getPrize());
        this.player.addNewRecentPrizes(yourCase.getPrize());
        this.player.addNewHighPrizes(yourCase.getPrize());
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
        return globalTotalPrizes;
    }

    //sets total games to a total games parameter
    public void setTotalGames(int totalGames) {
        this.totalGames = totalGames;
    }

    //sets total prizes to a total prizes parameter
    public void setTotalPrizes(int totalPrizes) {
        this.globalTotalPrizes = totalPrizes;
    }
    
    // Returns game data
    public GameData getGameData() {
        return gameData;
    }

    // Returns prizes
    public ArrayList<Integer> getPrizes() {
        return prizes;
    }
    

    //abstract methods for subclasses to override
    @Override
    public abstract void newRound();

}

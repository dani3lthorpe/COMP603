/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dealornodeal;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

/**
 * Score controller class controls the logic for the score display This involves
 *
 * @author group69
 */
public class ScoreManager extends Observable {

    private HashMap<String, int[]> recentPrizes;
    private HashMap<String, int[]> highestPrizes;
    private HashMap<String, Integer> globalTotalPrizes;
    private HashMap<String, Integer> globalHighPrizes;
    private int[] totalStats;
    private Scores scores;

    //ScoreController constructor takeing file controller as a parameter
    public ScoreManager(DBManager dataBase) {
        this.recentPrizes = dataBase.loadRecentPrizes();
        this.highestPrizes = dataBase.loadHighPrizes();
        this.globalTotalPrizes = dataBase.loadGlobalTotalPrizes();
        this.globalHighPrizes = dataBase.loadGlobalHighPrizes();
        this.totalStats = dataBase.loadTotalStats();
        
    }

    //refreshs the scores saved in the score controller
    public void refreshScores(DBManager dataBase) {
        dataBase.getConnection();
        this.recentPrizes = dataBase.loadRecentPrizes();
        this.highestPrizes = dataBase.loadHighPrizes();
        this.globalTotalPrizes = dataBase.loadGlobalTotalPrizes();
        this.globalHighPrizes = dataBase.loadGlobalHighPrizes();
        this.totalStats = dataBase.loadTotalStats();
        dataBase.closeConnection();
    }
    //Checks to see if a player has any recent prizes saved before saving them in the player class
    //takes a player as a parameter
    public void checkRecentPrizes(Player player) {
        if (recentPrizes.containsKey(player.getName())) {
            player.setRecentPrizes(recentPrizes.get(player.getName()));
        } else {
            recentPrizes.put(player.getName(), player.getRecentPrizes());
        }
    }

    //Checks to see if a player has any Highest Prizes saved before saving them in the player class
    //takes a player as a parameter
    public void checkHighestPrizes(Player player) {
        if (highestPrizes.containsKey(player.getName())) {
            int[] highestPrizesValues = this.highestPrizes.get(player.getName());

            for (int i = 0; i < highestPrizesValues.length; i++) {
                player.addHighPrizes(highestPrizesValues[i], i);
            }
        } else {
            highestPrizes.put(player.getName(), player.getHighPrizes());
        }
    }

    //returns total scores array
    public int[] getTotals() {
        return totalStats;
    }

    //returns recent scores hashmap
    public HashMap<String, int[]> getRecentPrizes() {
        return recentPrizes;
    }

    //returns highestprizes hashmapp
    public HashMap<String, int[]> getHighestPrizes() {
        return highestPrizes;
    }

    //returns globaltotalprizes hashmap
    public HashMap<String, Integer> getGlobalTotalPrizes() {
        return globalTotalPrizes;
    }

    //returns globalhighprizes
    public HashMap<String, Integer> getGlobalHighPrizes() {
        return globalHighPrizes;
    }

    public void setScores(Player player) {
        this.scores = new Scores(recentPrizes, highestPrizes, globalTotalPrizes, globalHighPrizes, totalStats);
        this.scores.setPlayerInfo(player.getName(), player.getTotalPrizes());
        this.setChanged();
        this.notifyObservers(this.scores);
    }

}

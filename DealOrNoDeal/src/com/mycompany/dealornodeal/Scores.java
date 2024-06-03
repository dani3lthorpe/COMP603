/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dealornodeal;

import java.util.HashMap;

/**
 * Scores class stores all the core scores to be sent to the  scores view
 *
 * @author group69
 */
public class Scores {

    private HashMap<String, int[]> recentPrizes;
    private HashMap<String, int[]> highestPrizes;
    private HashMap<String, Integer> globalTotalPrizes;
    private HashMap<String, Integer> globalHighPrizes;
    private int[] totalStats;
    private int totalPlayerPrizes = 0;
    private String playerName;

    //Scores constructor, sets scores hashmaps to input hashmaps, also sets totalstats to input int array
    public Scores(HashMap recentPrizes, HashMap highestPrizes, HashMap globalTotalPrizes, HashMap globalHighPrizes, int[] totalStats) {
        this.recentPrizes = recentPrizes;
        this.highestPrizes = highestPrizes;
        this.globalTotalPrizes = globalTotalPrizes;
        this.globalHighPrizes = globalHighPrizes;
        this.totalStats = totalStats;
    }
    
    //sets the playerName and totalprizes to the input playername and total prizes
    public void setPlayerInfo(String playerName, int totalPlayerPrizes) {
        this.playerName = playerName;
        this.totalPlayerPrizes = totalPlayerPrizes;
    }

    //returns the recentprizes hashmap
    public HashMap<String, int[]> getRecentPrizes() {
        return recentPrizes;
    }

    //returns the highest prizes hashmap
    public HashMap<String, int[]> getHighestPrizes() {
        return highestPrizes;
    }

    //returns the global total prizes hashmap
    public HashMap getGlobalTotalPrizes() {
        return globalTotalPrizes;
    }

    //returns the global high prizes hashmap
    public HashMap getGlobalHighPrizes() {
        return globalHighPrizes;
    }

    //returns the total stats int array
    public int[] getTotalStats() {
        return totalStats;
    }

    //returns the total player prizes
    public int getTotalPlayerPrizes() {
        return totalPlayerPrizes;
    }

    //returns the player name
    public String getPlayerName() {
        return playerName;
    }
    
    
    
}


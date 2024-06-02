/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dealornodeal;

import java.util.HashMap;

/**
 *
 * @author hidan
 */
public class Scores {

    private HashMap<String, int[]> recentPrizes;
    private HashMap<String, int[]> highestPrizes;
    private HashMap<String, Integer> globalTotalPrizes;
    private HashMap<String, Integer> globalHighPrizes;
    private int[] totalStats;
    private int totalPlayerPrizes = 0;
    private String playerName;

    public Scores(HashMap recentPrizes, HashMap highestPrizes, HashMap globalTotalPrizes, HashMap globalHighPrizes, int[] totalStats) {
        this.recentPrizes = recentPrizes;
        this.highestPrizes = highestPrizes;
        this.globalTotalPrizes = globalTotalPrizes;
        this.globalHighPrizes = globalHighPrizes;
        this.totalStats = totalStats;
        this.totalPlayerPrizes = totalPlayerPrizes;
    }
    public void setPlayerInfo(String playerName, int totalPlayerPrizes) {
        this.playerName = playerName;
        this.totalPlayerPrizes = totalPlayerPrizes;
    }

    public HashMap<String, int[]> getRecentPrizes() {
        return recentPrizes;
    }

    public HashMap<String, int[]> getHighestPrizes() {
        return highestPrizes;
    }

    public HashMap getGlobalTotalPrizes() {
        return globalTotalPrizes;
    }

    public HashMap getGlobalHighPrizes() {
        return globalHighPrizes;
    }

    public int[] getTotalStats() {
        return totalStats;
    }

    public int getTotalPlayerPrizes() {
        return totalPlayerPrizes;
    }

    public String getPlayerName() {
        return playerName;
    }
    
    
    
}


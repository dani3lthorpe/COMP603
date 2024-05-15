/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dealornodeal;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Player class stores and changes all the player information
 *
 * @author group69
 */
public class Player {

    private String name;
    private int totalPrizes = 0;
    private int highestPrize = 0;
    private int[] recentPrizes;
    private int[] highPrizes;

    //player constructer creates a recentPrizes and HighPrizes int array
    //sets name, totalPrizes and highestPrizes to the input parameters
    public Player(String name, int score, int highScore) {
        this.name = name;
        this.totalPrizes = score;
        this.highestPrize = highScore;
        this.recentPrizes = new int[5];
        this.highPrizes = new int[5];
    }

    //adds the input prize to the totalPrizes
    public void addTotalPrizes(int prize) {
        this.totalPrizes += prize;
    }

    //uses a deque to add a new score t the recent Scores array while removing the oldest score
    //takes the prize amount as a parameter
    public void addNewRecentPrizes(int prize) {
        Deque<Integer> tempScores = new ArrayDeque<>(5);

        for (int i : recentPrizes) {
            tempScores.addLast(i);
        }
        tempScores.removeLast();
        tempScores.addFirst(prize);

        int index = 0;
        for (int num : tempScores) {
            recentPrizes[index] = num;
            index++;
        }
    }

    //adds a new prize to the highest prizes if it is high enough removing the lowest prize
    //takes the prize amount as a parameter
    public void addNewHighPrizes(int prize) {
        int index = 0;

        while (index < this.highPrizes.length && prize < this.highPrizes[index]) {
            index++;
        }

        if (index < this.highPrizes.length) {
            for (int i = this.highPrizes.length - 1; i > index; i--) {
                this.highPrizes[i] = this.highPrizes[i - 1];
            }
            this.highPrizes[index] = prize;
        }
    }

    //add a prize to the highprizes array at a given index
    //takes prize amount and index number as parameters
    public void addHighPrizes(int prize, int index) {
        this.highPrizes[index] = prize;
    }

    //returns the players name
    public String getName() {
        return name;
    }

    //returns totalprizes amount
    public int getTotalPrizes() {
        return totalPrizes;
    }

    //returns the highestprize amount
    public int getHighestPrize() {
        return highestPrize;
    }

    //returns the recentPrizes array
    public int[] getRecentPrizes() {
        return recentPrizes;
    }

    //returns the highprizes array
    public int[] getHighPrizes() {
        return highPrizes;
    }

    //sets the recentPrizes array to the input array
    public void setRecentPrizes(int[] prize) {
        this.recentPrizes = prize;
    }

    //sets the highestPrize to the input amount
    public void setHighestPrize(int highestPrize) {
        this.highestPrize = highestPrize;
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dealornodeal;

import java.util.Arrays;
import java.util.Random;

/**
 * RandomMode class that extends the abstract class gameMode creates a Random
 * gameMode of deal or no deal where it follows the standard deal or no deal
 * format but all the prizes are randomized
 *
 * @author group69
 */
public class RandomMode extends GameMode {

    //Random constructor supers the prizes int array created by the create prizes method
    //as well as the inputed player parameter

    public RandomMode(Player player) {
        super(player, createPrizes(), new GameData(6));
    }

    //sets the 26 prizes to random numbers between 1 and 500000
    public final static int[] createPrizes() {
        int[] prizes = new int[26];
        Random random = new Random();

        for (int i = 0; i < 26; i++) {
            prizes[i] = random.nextInt(500000);
        }

        Arrays.sort(prizes);
        return prizes;
    }

    @Override
    public void newRound() {
        GameData gameData = getGameData();
        gameData.increaseRound();
        switch (gameData.getRound()) {
            case 2:
                gameData.setCasesToPick(6);
                break;
            case 3:
                gameData.setCasesToPick(5);
                break;
            case 4:
                gameData.setCasesToPick(4);
                break;
            case 5:
                gameData.setCasesToPick(2);
                break;
            case 6:
                gameData.setCasesToPick(1);
                break;
            default:
                gameData.setRound(-1);
                break;
        }
    }

}

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

    //Random constructor supers the prizes int array created by the create prizes method,
    //a new GameData object with 6 as its number of cases to pick parameter as well as the inputed player parameter

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

    //overrides newRound so that sets the gameData to the correct amount of casesToPick for each round
    @Override
    public void newRound() {
        GameData gameData = getGameData();
        gameData.increaseRound();
        switch (gameData.getRound()) {
            case 2:
                gameData.setNumCasesToPick(6);
                break;
            case 3:
                gameData.setNumCasesToPick(5);
                break;
            case 4:
                gameData.setNumCasesToPick(4);
                break;
            case 5:
                gameData.setNumCasesToPick(2);
                break;
            case 6:
                gameData.setNumCasesToPick(1);
                break;
            default:
                gameData.setRound(-1);
                break;
        }
    }

}

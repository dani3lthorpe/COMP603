/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dealornodeal;

import java.util.Scanner;

/**
 * Tutorial class that extends the abstract class gameMode creates a tutorial
 * gameMode of deal or no deal where it explains to the user how to play deal or
 * no deal
 *
 * @author group69
 */
public class Tutorial extends GameMode {

    private static final int[] prizes = {1, 5, 10, 50, 100, 200};

    //tutorial constructor supers the prizes int array, a new GameData object with 3 as its number of cases to pick parameter
    //as well as the inputed player parameter
    public Tutorial(Player player) {
        super(player, prizes, new GameData(3));
    }

    //overrides newRound so that sets the gameData to the correct amount of casesToPick for each round
    @Override
    public void newRound() {
        GameData gameData = getGameData();
        gameData.increaseRound();
        switch (gameData.getRound()) {
            case 2:
                gameData.setNumCasesToPick(1);
                break;
            default:
                gameData.setRound(-1);
                break;
        }

    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dealornodeal;

import java.util.Scanner;

/**
 * QuickPlay class that extends the abstract class gameMode creates a QuickPlay
 * gameMode of deal or no deal where it follows a shorter deal or no deal format
 *
 * @author group69
 */
public class QuickPlay extends GameMode {

    private static final int[] money = {1, 5, 10, 50, 100, 250, 500, 1000, 5000, 10000, 50000, 100000, 200000};
    private GameData quickPlayData = new GameData(5);

    //Quickplay constructor supers the prizes int array as well as the inputed player parameter
    public QuickPlay(Player player) {
        super(player, money, new GameData(5));
    } 

    @Override
    public void newRound() {
        GameData gameData = getGameData();
        gameData.increaseRound();
        switch (gameData.getRound()) {
            case 2:
                gameData.setCasesToPick(4);
                break;
            case 3:
                gameData.setCasesToPick(2);
                break;
            default:
                gameData.setRound(-1);
                break;
        }

    }

}

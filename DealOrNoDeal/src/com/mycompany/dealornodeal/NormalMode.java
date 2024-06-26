/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dealornodeal;

/**
 * Normal class that extends the abstract class gameMode creates a normal
 * gameMode of deal or no deal where it follows the standard deal or no deal
 * format
 *
 * @author group69
 */
public class NormalMode extends GameMode {

    private static final int[] prizes = {1, 2, 5, 10, 20, 50, 100, 150, 200, 250, 500, 750, 1000, 2000, 3000, 4000, 5000, 10000, 15000, 20000, 30000, 50000, 75000, 100000, 200000, 500000};

    //normal constructor supers the prizes int array, a new GameData object with 6 as its number of cases parameter
    //as well as the inputed player parameter
    public NormalMode(Player player) {
        super(player, prizes, new GameData(6));
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

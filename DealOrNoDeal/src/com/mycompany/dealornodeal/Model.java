/*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
     * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dealornodeal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;

/**
 * Game controller class controls all the core game logic such as the main menu
 * and creating the fileController, scoreController and player objects
 *
 * @author group69
 */
public class Model extends Observable {

    private HashMap<String, Player> playersList;
    private DBManager dataBaseManager;
    private ScoreManager scoreManager;
    private Player player;
    private GameMode gameMode;
    private GameModeFactory gameModeFactory;

    //Gamecontroller constructer creates a new scanner, filecontroller, scorecontroller.
    //Also gets the players hash map from the files using the fileController
    public Model() {
        this.dataBaseManager = new DBManager();
        this.scoreManager = new ScoreManager(dataBaseManager);
        this.playersList = dataBaseManager.loadPlayers();
        this.dataBaseManager.closeConnection();
    }

    //checks if user is in the players hashmap and creates a new player object with their stats
    //if user is not in the hashmap creates a new player and saves them to the hashmap
    //returns player and takes the users name as a parameter
    public void checkPlayers(String name) {
        if (this.playersList.containsKey(name)) {
            this.player = this.playersList.get(name);
        } else {
            this.player = new Player(name, 0, 0);
            for (int i = 0; i <= 5; i++) {
                this.player.addNewRecentPrizes(0);
            }
            for (int i = 0; i <= 5; i++) {
                this.player.addNewHighPrizes(0);
            }
            this.playersList.put(name, player);
        }
        this.scoreManager.checkRecentPrizes(player);
        this.scoreManager.checkHighestPrizes(player);
    }

    //Prompts user to select a gameMode and gets user input
    //returns GameMode and take player as a parameter
    public void selectGameMode(String modeName) {
        this.gameMode = gameModeFactory.getGameMode(modeName, player);
    }

    //Saves all of the data to the files
    public void saveGameData() {
        this.dataBaseManager.getConnection();
        this.dataBaseManager.updateTotalStats(scoreManager.getTotals(), gameMode);
        this.dataBaseManager.updateScore(playersList, player);
        this.dataBaseManager.updateRecentPrizes(scoreManager.getRecentPrizes(), player);
        this.dataBaseManager.updateHighPrizes(scoreManager.getHighestPrizes(), player);
        this.scoreManager.refreshScores(dataBaseManager);
        this.dataBaseManager.closeConnection();
        this.scoreManager.setScores(player);
    }

   

    public GameMode getGameMode() {
        return gameMode;
    }

    public void getOffer() {
        this.gameMode.displayOffer();
        this.notifyView();
    }

    public void openCase(int caseNum) {
        ArrayList<Case> cases = gameMode.getCases();
        if (this.gameMode.getGameData().getPlayerCase() != null) {
            this.gameMode.getGameData().caseOpened(cases.get(caseNum - 1));
        } else {
            this.gameMode.getGameData().setPlayerCase(cases.get(caseNum - 1));
        }
        this.notifyView();
        this.gameMode.removePrize(caseNum - 1);
    }

    public void newRound() {
        this.gameMode.newRound();
        this.notifyView();
    }

    public void notifyView() {
        this.setChanged();
        this.notifyObservers(this.gameMode.getGameData());
    }
    
    public ScoreManager getScores() {
        return scoreManager;
    }

    public Player getPlayer() {
        return player;
    }
    
  

}

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

    //Model constructer creates a database manager, score manager.
    //Also gets the players hash map from the database using the database manager
    public Model() {
        this.dataBaseManager = new DBManager();
        this.scoreManager = new ScoreManager(dataBaseManager);
        this.playersList = dataBaseManager.loadPlayers();
        this.dataBaseManager.closeConnection();
    }

    //checks if user is in the players hashmap and creates a new player object with their stats
    //if user is not in the hashmap creates a new player and saves them to the hashmap
    //takes the users name as a parameter
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

   //creates gameMode using gameMode factory inputting the modeName and the player
   //takes the modes name as an input parameter
    public void selectGameMode(String modeName) {
        this.gameMode = gameModeFactory.getGameMode(modeName, player);
    }

   //Saves all of the data to the database before refreshing scores
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

    //updates the offer in gameMode and notifies the observors that the offer has been updated
    public void updateOffer() {
        this.gameMode.displayOffer();
        this.notifyView();
    }

    //opens case change all the revelant game Data before notifying the view and removing the prize
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

    //uses gameMode to start a newRound before notifying view
    public void newRound() {
        this.gameMode.newRound();
        this.notifyView();
    }

    //notfies all observers that gameData has been changed
    public void notifyView() {
        this.setChanged();
        this.notifyObservers(this.gameMode.getGameData());
    }
    
    //returns the scoreManager
    public ScoreManager getScoreManager() {
        return scoreManager;
    }

    //returns player
    public Player getPlayer() {
        return player;
    }
    
    //returns gameMode object
    public GameMode getGameMode() {
        return gameMode;
    }

}

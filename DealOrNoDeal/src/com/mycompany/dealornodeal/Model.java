/*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
     * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dealornodeal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;
import java.util.Scanner;

/**
 * Game controller class controls all the core game logic such as the main menu
 * and creating the fileController, scoreController and player objects
 *
 * @author group69
 */
public class Model extends Observable {

    private HashMap<String, Player> players;
    private static Scanner scan;
    private DBManager dataBase;
    private ScoreController scores;
    private Player player;
    private GameMode gameMode;

    //Gamecontroller constructer creates a new scanner, filecontroller, scorecontroller.
    //Also gets the players hash map from the files using the fileController
    public Model() {
        scan = new Scanner(System.in);
        dataBase = new DBManager();
        scores = new ScoreController(dataBase);
        players = dataBase.loadPlayers();
        dataBase.closeConnection();
    }

    //checks if user is in the players hashmap and creates a new player object with their stats
    //if user is not in the hashmap creates a new player and saves them to the hashmap
    //returns player and takes the users name as a parameter
    public void checkPlayers(String name) {
        if (players.containsKey(name)) {
            this.player = players.get(name);
        } else {
            this.player = new Player(name, 0, 0);
            for (int i = 0; i <= 5; i++) {
                player.addNewRecentPrizes(0);
            }
            for (int i = 0; i <= 5; i++) {
                player.addNewHighPrizes(0);
            }
            players.put(name, player);
        }
        scores.checkRecentPrizes(player);
        scores.checkHighestPrizes(player);
    }

    //Prompts user to select a gameMode and gets user input
    //returns GameMode and take player as a parameter
    public void selectGameMode(String modeName) {
        if (modeName.equals("Tutorial")) {
            gameMode = new Tutorial(player);
        } else if (modeName.equals("Normal")) {
            gameMode = new NormalMode(player);
        } else if (modeName.equals("QuickPlay")) {
            gameMode = new QuickPlay(player);
        } else if (modeName.equals("Random Mode")) {
            gameMode = new RandomMode(player);
        }
    }

    //Saves all of the data to the files
    public void saveGameData() {
        dataBase.getConnection();
        dataBase.updateTotalStats(scores.getTotals(), gameMode);
        dataBase.updateScore(players, player);
        dataBase.updateRecentPrizes(scores.getRecentPrizes(), player);
        dataBase.updateHighPrizes(scores.getHighestPrizes(), player);
        scores.refreshScores(dataBase);
        dataBase.closeConnection();
        scores.setScores(player);
    }

   

    public GameMode getGameMode() {
        return gameMode;
    }

    public void getOffer() {
        gameMode.displayOffer();
        this.notifyView();
    }

    public void openCase(int caseNum) {
        ArrayList<Case> cases = gameMode.getCases();
        if (this.gameMode.getGameData().getPlayerCase() != null) {
            this.gameMode.getGameData().casePicked(cases.get(caseNum - 1));
        } else {
            this.gameMode.getGameData().setPlayerCase(cases.get(caseNum - 1));
        }
        this.notifyView();
        this.gameMode.removePrize(caseNum - 1);
    }

    public void newRound() {
        gameMode.newRound();
        this.notifyView();
    }

    public void notifyView() {
        this.setChanged();
        this.notifyObservers(this.gameMode.getGameData());
    }
    
    public ScoreController getScores() {
        return scores;
    }

    public Player getPlayer() {
        return player;
    }

}

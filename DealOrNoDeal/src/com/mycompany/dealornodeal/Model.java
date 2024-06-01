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

    //controlls main game by displaying main menu, starting the gamemode and saving the scores
    //then asks if player would like to play again
    public void displayMainMenu() {
        System.out.println("Welcome to Deal or no Deal (Input x at any time to quit)");

        boolean playing = true;
        while (playing == true) {
            scores.showScoresMenu(player);
            gameMode.setTotalGames(scores.getTotals()[0]);
            gameMode.setTotalPrizes(scores.getTotals()[1]);
            saveGameData(gameMode, player);
            playAgainPrompt(player);
        }
    }

    //checks if user is in the players hashmap and creates a new player object with their stats
    //if user is not in the hashmap creates a new player and saves them to the hashmap
    //returns player and takes the users name as a parameter
    public Player checkPlayers(String name) {
        Player player;
        if (players.containsKey(name)) {
            player = players.get(name);
            String capitalizedName = player.getName().substring(0, 1).toUpperCase() + player.getName().substring(1);

            System.out.println("-----------------------------------------------------------------------");
            System.out.println("Welcome back " + capitalizedName);
            System.out.println("your Total score is " + player.getTotalPrizes());
            System.out.println("your Highest prize is $" + player.getHighestPrize());

            scores.checkRecentPrizes(player);
            scores.checkHighestPrizes(player);
        } else {
            player = new Player(name, 0, 0);
            for (int i = 0; i <= 5; i++) {
                player.addNewRecentPrizes(0);
            }
            for (int i = 0; i <= 5; i++) {
                player.addNewHighPrizes(0);
            }
            players.put(name, player);
        }
        return player;
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

    //prompts user to see if they would like to play again
    public void playAgainPrompt(Player player) {
        boolean answerIsValid = false;
        while (!answerIsValid) {
            System.out.println("-----------------------------------------------------------------------");
            System.out.println("Would you like to play again?");
            System.out.println("(1) Yes");
            System.out.println("(2) No");

            String playAgainAnswer = scan.nextLine().trim().toLowerCase();

            if (playAgainAnswer.equals("x")) {
                quittingCheck();
            } else if (playAgainAnswer.equals("2") || playAgainAnswer.equals("two") || playAgainAnswer.equals("x") || playAgainAnswer.equals("no") || playAgainAnswer.equals("n")) {
                scores.showScoresMenu(player);
                System.out.println("-----------------------------------------------------------------------");
                System.out.println("Thanks for playing");
                System.out.println("Scores saved, Game Exiting");
                System.exit(0);
            } else if (playAgainAnswer.equals("1") || playAgainAnswer.equals("one") || playAgainAnswer.equals("yes") || playAgainAnswer.equals("y") || playAgainAnswer.equals("ye")) {
                answerIsValid = true;
            } else {
                System.out.println("-----------------------------------------------------------------------");
                System.out.println("Invalid Input");
            }
        }
    }

    //Saves all of the data to the files
    public void saveGameData(GameMode gameMode, Player player) {
        gameMode.addTotalGame();
        dataBase.getConnection();
        dataBase.updateTotalStats(scores.getTotals(), gameMode);
        dataBase.updateScore(players, player);
        dataBase.updateRecentPrizes(scores.getRecentPrizes(), player);
        dataBase.updateHighPrizes(scores.getHighestPrizes(), player);
        scores.refreshScores(dataBase);
        dataBase.closeConnection();
    }

    //checks if the user has input x to quit
    public static void quittingCheck() {
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("Are you sure you would like to quit the game?");
        System.out.println("(1) Yes");
        System.out.println("(2) No");

        boolean inputIsValid = false;

        while (!inputIsValid) {
            String answer = scan.nextLine().trim().toLowerCase();
            if (answer.equals("1") || answer.equals("one") || answer.equals("x") || answer.equals("yes") || answer.equals("y") || answer.equals("ye")) {
                System.out.println("-----------------------------------------------------------------------");
                System.out.println("Thanks for playing");
                System.out.println("Game Exiting");
                System.exit(0);
            } else if (answer.equals("2") || answer.equals("two") || answer.equals("no") || answer.equals("n")) {
                inputIsValid = true;
            } else {
                System.out.println("-----------------------------------------------------------------------");
                System.out.println("Invalid Answer, please select either:");
                System.out.println("(1) Yes");
                System.out.println("(2) No");

            }
        }
    }

    //checks if the name input is valid before returning the input
    public String checkNameInput() {
        boolean isValid = false;
        String input = "";
        while (!isValid) {
            System.out.println("-----------------------------------------------------------------------");
            System.out.println("Please input your name:");

            input = scan.nextLine().trim().toLowerCase();

            if (input.equals("x")) {
                quittingCheck();
            } else if (input.contains("/")) {
                System.out.println("-----------------------------------------------------------------------");
                System.out.println("Invalid character (/) in name");
            } else if (input.equals("")) {
                System.out.println("-----------------------------------------------------------------------");
                System.out.println("Invalid Name");
            } else {
                return input;
            }
        }
        return input;
    }

    public void setPlayer(String username) {
        player = checkPlayers(username);
    }

    public String getGlobalTotalPrizes() {
        String score = scores.showGlobalTotalPrizes();
        return score;
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
    }

    public void newRound() {
        gameMode.newRound();
        this.notifyView();
    }

    public void notifyView() {
        this.setChanged();
        this.notifyObservers(this.gameMode.getGameData());
    }

    public void endGame() {
        saveGameData(gameMode, player);
        this.notifyView();
    }

}

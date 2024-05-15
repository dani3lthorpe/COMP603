/*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
     * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dealornodeal;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Game controller class controls all the core game logic such as the main menu
 * and creating the fileController, scoreController and player objects
 *
 * @author group69
 */
public class GameController {

    private HashMap<String, Player> players;
    private static Scanner scan;
    private FileController files;
    private ScoreController scores;

    //Gamecontroller constructer creates a new scanner, filecontroller, scorecontroller.
    //Also gets the players hash map from the files using the fileController
    public GameController() {
        scan = new Scanner(System.in);
        files = new FileController();
        scores = new ScoreController(files);
        players = files.loadPlayers();
    }

    //controlls main game by displaying main menu, starting the gamemode and saving the scores
    //then asks if player would like to play again
    public void displayMainMenu() {
        System.out.println("Welcome to Deal or no Deal (Input x at any time to quit)");
        String name = checkNameInput();
        Player player = checkPlayers(name);
        
        boolean playing = true;
        while (playing == true) {
            scores.showScoresMenu(player);
            GameMode gameMode = selectGameMode(player);
            
            gameMode.setTotalGames(scores.getTotals()[0]);
            gameMode.setTotalPrizes(scores.getTotals()[1]);
            gameMode.startMode();

            saveGameData(files, scores, gameMode, player);
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
    public GameMode selectGameMode(Player player) {
        boolean validInput = false;
        while (!validInput) {
            System.out.println("-----------------------------------------------------------------------");
            System.out.println("Which Gamemode would you like to play?");
            System.out.println("(1) Tutorial (Reccomended for new players)");
            System.out.println("(2) Normal");
            System.out.println("(3) QuickPlay");
            System.out.println("(4) Random Mode");
            
            String input = scan.nextLine().trim().toLowerCase();
            
            if (input.equals("x")) {
                quittingCheck();
            } else if (input.equals("1") || input.equals("tutorial") || input.equals("one") || input.equals("t")) {
                return new Tutorial(player);
            } else if (input.equals("2") || input.equals("normal") || input.equals("two") || input.equals("n")) {
                return new NormalMode(player);
            } else if (input.equals("3") || input.equals("quickplay") || input.equals("three") || input.equals("q")) {
                return new QuickPlay(player);
            } else if (input.equals("4") || input.equals("random mode") || input.equals("random") || input.equals("randommode") || input.equals("four") || input.equals("r")) {
                return new RandomMode(player);
            } else {
                System.out.println("-----------------------------------------------------------------------");
                System.out.println("Invalid Input");
            }
        }
        return null;
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
    public void saveGameData(FileController files, ScoreController scores, GameMode gameMode, Player player) {
        gameMode.addTotalGame();
        files.updateTotalStats(scores.getTotals(), gameMode);
        files.updateScore(players, player);
        files.updateRecentPrizes(scores.getRecentPrizes(), player);
        files.updateHighPrizes(scores.getHighestPrizes(), player);
        scores.refreshScores(files);
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
}

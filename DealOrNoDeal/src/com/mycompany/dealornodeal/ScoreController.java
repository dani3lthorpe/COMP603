/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dealornodeal;

import static com.mycompany.dealornodeal.GameController.quittingCheck;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Score controller class controls the logic for the score display This involves
 *
 * @author group69
 */
public class ScoreController {

    private HashMap<String, int[]> recentPrizes;
    private HashMap<String, int[]> highestPrizes;
    private HashMap<String, Integer> globalTotalPrizes;
    private HashMap<String, Integer> globalHighPrizes;
    private int[] totalStats;

    //ScoreController constructor takeing file controller as a parameter
    public ScoreController(DBManager dataBase) {
        dataBase.getConnection();
        this.recentPrizes = dataBase.loadRecentPrizes();
        this.highestPrizes = dataBase.loadHighPrizes();
        this.globalTotalPrizes = dataBase.loadGlobalTotalPrizes();
        this.globalHighPrizes = dataBase.loadGlobalHighPrizes();
        this.totalStats = dataBase.loadTotalStats();
        dataBase.closeConnection();
    }

    //refreshs the scores saved in the score controller
    public void refreshScores(DBManager dataBase) {
        dataBase.getConnection();
        this.recentPrizes = dataBase.loadRecentPrizes();
        this.highestPrizes = dataBase.loadHighPrizes();
        this.globalTotalPrizes = dataBase.loadGlobalTotalPrizes();
        this.globalHighPrizes = dataBase.loadGlobalHighPrizes();
        this.totalStats = dataBase.loadTotalStats();
        dataBase.closeConnection();
    }

    //displays a score menu and displays which score a player wants to see based on two inputs,
    //takes player as a parameter
    public void showScoresMenu(Player player) {
        Scanner scan = new Scanner(System.in);
        boolean seeScores = true;

        while (seeScores) {
            System.out.println("-----------------------------------------------------------------------");
            System.out.println("Would you like to view the scores?");
            System.out.println("(1) Yes");
            System.out.println("(2) No");

            String seeScoresInput = scan.nextLine().trim().toLowerCase();

            if (seeScoresInput.equals("x")) {
                quittingCheck();
            } else if (seeScoresInput.equals("1") || seeScoresInput.equals("one") || seeScoresInput.equals("yes") || seeScoresInput.equals("y") || seeScoresInput.equals("ye")) {
                boolean validScoreTypeInput = false;

                while (!validScoreTypeInput) {
                    System.out.println("-----------------------------------------------------------------------");
                    System.out.println("Which score would you like to see");
                    System.out.println("(1) Global Total Prizes");
                    System.out.println("(2) Global Highest Prizes");
                    System.out.println("(3) Your Recent Prizes");
                    System.out.println("(4) Your Highest Prizes");
                    System.out.println("(5) Total Games Played and Total Prizes Won by All Players");

                    String scoreInput = scan.nextLine().trim().toLowerCase();

                    if (scoreInput.equals("x")) {
                        quittingCheck();
                    } else if (scoreInput.equals("1") || scoreInput.equals("global total prizes") || scoreInput.equals("global total")) {
                        showGlobalTotalPrizes();
                        validScoreTypeInput = true;
                    } else if (scoreInput.equals("2") || scoreInput.equals("global highest prizes") || scoreInput.equals("global highest") || scoreInput.equals("global high")) {
                        showGlobalHighestPrizes();
                        validScoreTypeInput = true;
                    } else if (scoreInput.equals("3") || scoreInput.equals("your recent prizes") || scoreInput.equals("recent prizes") || scoreInput.equals("your scores") || scoreInput.equals("recent") || scoreInput.equals("your recent")) {
                        showRecentPrizes(player);
                        validScoreTypeInput = true;
                    } else if (scoreInput.equals("4") || scoreInput.equals("your highest prizes") || scoreInput.equals("your highest") || scoreInput.equals("your prizes")) {
                        showHighestPrizes(player);
                        validScoreTypeInput = true;
                    } else if (scoreInput.equals("5") || scoreInput.equals("total games and total prizes") || scoreInput.equals("total games") || scoreInput.equals("total games played and total prizes won by all players") || scoreInput.equals("total games played") || scoreInput.equals("total prizes won") || scoreInput.equals("total games played by all players") || scoreInput.equals("total prizes won by all players") || scoreInput.equals("all players")) {
                        System.out.println("-----------------------------------------------------------------------");
                        System.out.println("There have been " + totalStats[0] + " games of deal or no deal played");
                        System.out.println("The total of all the prizes won is $" + totalStats[1]);
                        validScoreTypeInput = true;
                    } else {
                        System.out.println("-----------------------------------------------------------------------");
                        System.out.println("Invalid Input:");
                    }
                }
            } else if (seeScoresInput.equals("2") || seeScoresInput.equals("two") || seeScoresInput.equals("no") || seeScoresInput.equals("n")) {
                seeScores = false;
            } else {
                System.out.println("-----------------------------------------------------------------------");
                System.out.println("Invalid Answer");
            }

        }
    }

    //displays the global total prizes
    public void showGlobalTotalPrizes() {
        int place = 1;

        System.out.println("-----------------------------------------------------------------------");
        System.out.println("Global Total Scores: ");

        for (Map.Entry<String, Integer> entry : globalTotalPrizes.entrySet()) {
            System.out.println(place + ". " + entry.getKey().substring(0, 1).toUpperCase() + entry.getKey().substring(1) + ": " + entry.getValue());
            place++;
        }
    }

    //displays the global highest prizes
    public void showGlobalHighestPrizes() {
        int place = 1;

        System.out.println("-----------------------------------------------------------------------");
        System.out.println("Global Highest Prizes: ");

        for (Map.Entry<String, Integer> entry : globalHighPrizes.entrySet()) {
            System.out.println(place + ". " + entry.getKey().substring(0, 1).toUpperCase() + entry.getKey().substring(1) + ": " + entry.getValue());
            place++;
        }
    }

    //displays a players recent prizes, takes a player as a parameter
    public void showRecentPrizes(Player player) {
        int[] recentPrizes = player.getRecentPrizes();

        System.out.println("-----------------------------------------------------------------------");
        System.out.println("Your Recent Scores: ");

        for (int i = 0; i < 5; i++) {
            System.out.println((i + 1) + ": " + recentPrizes[i]);
        }
    }

    //displays a players highest prizes, takes a player as a parameter
    public void showHighestPrizes(Player player) {
        int[] highPrizes = player.getHighPrizes();

        System.out.println("-----------------------------------------------------------------------");
        System.out.println("Your Highest Prizes: ");

        for (int i = 0; i < 5; i++) {
            System.out.println((i + 1) + ": " + highPrizes[i]);
        }
    }

    //Checks to see if a player has any recent prizes saved before saving them in the player class
    //takes a player as a parameter
    public void checkRecentPrizes(Player player) {
        if (recentPrizes.containsKey(player.getName())) {
            player.setRecentPrizes(recentPrizes.get(player.getName()));
        }
    }

    //Checks to see if a player has any Highest Prizes saved before saving them in the player class
    //takes a player as a parameter
    public void checkHighestPrizes(Player player) {
        if (highestPrizes.containsKey(player.getName())) {
            int[] highestPrizesValues = this.highestPrizes.get(player.getName());

            for (int i = 0; i < highestPrizesValues.length; i++) {
                player.addHighPrizes(highestPrizesValues[i], i);
            }
        }
    }

    //returns total scores array
    public int[] getTotals() {
        return totalStats;
    }

    //returns recent scores hashmap
    public HashMap<String, int[]> getRecentPrizes() {
        return recentPrizes;
    }

    //returns highestprizes hashmapp
    public HashMap<String, int[]> getHighestPrizes() {
        return highestPrizes;
    }

    //returns globaltotalprizes hashmap
    public HashMap<String, Integer> getGlobalTotalPrizes() {
        return globalTotalPrizes;
    }

    //returns globalhighprizes
    public HashMap<String, Integer> getGlobalHighPrizes() {
        return globalHighPrizes;
    }

}

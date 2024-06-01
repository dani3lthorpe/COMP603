/*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
     * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dealornodeal;

import java.util.ArrayList;
import static java.util.Collections.shuffle;
import java.util.Scanner;

/**
 * GameMode Abstract class creates a template for each of the GameMode
 * subclasses
 *
 * @author group69
 */
public abstract class GameMode implements Game {

    private ArrayList<Integer> prizes;
    private Player player;
    private ArrayList<Case> cases;
    private int totalGames;
    private int totalPrizes;
    private GameInfo gameData;
    private int[] prize;

    //GameMode constructor creates the prizes and cases arraylist
    // adds the value from the prizes array to the prizes arraylist and sets the player to the player parameter
    public GameMode(Player player, int[] prizes, GameInfo gameData) {
        this.player = player;
        this.prizes = new ArrayList<>();
        this.cases = new ArrayList<>();
        this.prize = prizes;
        this.gameData = gameData;
        for (int m : prizes) {
            this.prizes.add(m);
        }
        setCases();
    }

    //shuffles the prizes arraylist before creating cases and adding them to the case arrayList
    //using the shuffle prize values
    public final void setCases() {
        ArrayList<Integer> shuffledPrizes = new ArrayList<>(this.prizes);
        shuffle(shuffledPrizes);

        for (int i = 0; i < shuffledPrizes.size(); i++) {
            this.cases.add(new Case(i + 1, shuffledPrizes.get(i)));
        }
    }

    //displays the prizes arraylist
    public void displayPrizes() {
        String output = "";

        for (int i = 0; i < this.prizes.size(); i++) {
            output += "$" + this.prizes.get(i);
            if (i != this.prizes.size() - 1) {
                output += ", ";
            }
        }
        System.out.println("Prizes Remaining: ");
        System.out.println(output);
    }

    //sets the selected userCase's playercase to true and retuns the caseNum
    //takes a scanner and total number of cases a parameter
    public int selectUserCase(Scanner scan, int total) {
        int caseNum = checkCaseInput(scan, total);

        for (Case c : cases) {
            if (c.getNumber() == caseNum) {
                c.setPlayerCase(true);
            }
        }
        return caseNum;
    }

    //displays the casePicking screen, getting the user to select a case to open
    //takes a scanner, the number of cases to pick and the total cases as a parameter
    public Case displayCasePicking(int caseNum) {
        for (Case c : cases) {
            if (c.getNumber() == caseNum) {
                if (c.isOpen() == true) {
                    return c;
                } else if (c.isPlayerCase() == true) {
                    return c;
                } else {
                    return c;
                }
            }
        }
        return null;
    }

    //displays an offer from a banker for the user to choose to accept or decline
    //takes a banker and scanner as parameter
    public void displayOffer() {
        Banker banker = new Banker(gameData.getRound());
        gameData.setCurrentOffer(banker.makeOffer(prizes));
    }

    public void acceptOffer() {
        int offer = gameData.getCurrentOffer();
        this.player.addTotalPrizes(offer);
        this.totalPrizes += offer;
        if (offer > this.player.getHighestPrize()) {
            this.player.setHighestPrize(offer);
        }
        this.player.addTotalPrizes(offer);
        this.player.addNewRecentPrizes(offer);
        this.player.addNewHighPrizes(offer);
        this.gameData.setDealAccepted(true);
        this.player.setCurrentPrize(offer);
    }

    //displays the past offers
    //takes a banker as a parameter
    public void displayPastOffers(Banker banker) {
        if (!banker.getPastOffers().isEmpty()) {
            System.out.println("Past Offers:");
            for (int p : banker.getPastOffers()) {
                System.out.println("$" + p);
            }
        }
    }

    //checks if the case input is valid
    //takes a scanner and the total number of cases as a parameter
    public int checkCaseInput(Scanner scan, int total) {
        boolean isValid = false;
        int number = 0;
        while (!isValid) {
            try {
                String input = scan.nextLine().trim().toLowerCase();
                if (input.equals("x")) {
                    System.out.println("-----------------------------------------------------------------------");
                    stopMode();
                    System.out.println("-----------------------------------------------------------------------");
                    displayCases();
                    System.out.println("Please pick a case:");
                } else {
                    if (input.startsWith("case ")) {
                        number = Integer.parseInt(input.substring(5));
                    } else if (input.startsWith("case")) {
                        number = Integer.parseInt(input.substring(4));
                    } else {
                        number = Integer.parseInt(input);
                    }
                    if (number > total || number < 1) {
                        System.out.println("-----------------------------------------------------------------------");
                        displayCases();
                        System.out.println("Please enter a case number between 1 and " + total);
                    } else {
                        isValid = true;
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("-----------------------------------------------------------------------");
                displayCases();
                System.out.println("Invalid input, please input a case number between 1 and " + total);
            }
        }
        return number;
    }

    //checks if the offer input is valid
    //takes a scanner as parameter
    public int checkOfferInput(Scanner scan) {
        boolean isValid = false;

        while (!isValid) {
            String input = scan.nextLine().trim().toLowerCase();
            if (input.trim().equals("x")) {
                System.out.println("-----------------------------------------------------------------------");
                stopMode();
                System.out.println("-----------------------------------------------------------------------");
                System.out.println("Please input your answer to the offer:");
                System.out.println("(1) Deal");
                System.out.println("(2) No Deal");
            } else {
                if (input.equals("1") || input.equals("deal") || input.equals("d") || input.equals("one")) {
                    return 1;
                } else if (input.equals("2") || input.equals("two") || input.equals("no deal") || input.equals("n") || input.equals("nd") || input.equalsIgnoreCase("n d")) {
                    return 2;
                } else {
                    System.out.println("-----------------------------------------------------------------------");
                    System.out.println("Invalid input, please select either:)");
                    System.out.println("(1) Deal");
                    System.out.println("(2) No Deal");
                }

            }
        }
        return 1;
    }

    //confirms the user wants to quit before stopping the game
    public void stopMode() {
        Case c = gameData.getPlayerCase();
        if (!gameData.isDealAccepted()) {
            System.out.println("Now to open your case: ");
            int currentScore = c.getPrize();
            if (currentScore > player.getHighestPrize()) {
                player.setHighestPrize(currentScore);
            }
            addTotalPrizes(currentScore);
            player.addTotalPrizes(currentScore);
            player.addNewRecentPrizes(currentScore);
            player.addNewHighPrizes(currentScore);
            c.open();
        } else {
            System.out.println("Now to see what was in your case: ");
            c.open();
        }
    }
    //returns the player

    public Player getPlayer() {
        return player;
    }

    //returns the case arraylist
    public ArrayList<Case> getCases() {
        return cases;
    }

    //returns total games
    public int getTotalGames() {
        return totalGames;
    }

    //returns the totalPrizes
    public int getTotalPrizes() {
        return totalPrizes;
    }

    //returns the prizes arraylist
    public ArrayList<Integer> getPrizes() {
        return prizes;
    }


    //adds a prize to the totalprizes
    //takes a prize parameter
    public void addTotalPrizes(int prize) {
        this.totalPrizes += prize;
    }

    //sets total games to a total games parameter
    public void setTotalGames(int totalGames) {
        this.totalGames = totalGames;
    }

    //sets total prizes to a total prizes parameter
    public void setTotalPrizes(int totalPrizes) {
        this.totalPrizes = totalPrizes;
    }

    //adds a game to totalgames
    public void addTotalGame() {
        this.totalGames++;
    }

    public GameInfo getGameData() {
        return gameData;
    }

    public int[] getPrize() {
        return prize;
    }

    //abstract methods for subclasses to override
    @Override
    public abstract void startMode();

    public abstract void displayCases();

    public abstract void newRound();

}

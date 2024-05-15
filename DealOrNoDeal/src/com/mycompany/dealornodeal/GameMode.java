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
    private boolean dealAccepted;
    private int totalGames;
    private int totalPrizes;

    //GameMode constructor creates the prizes and cases arraylist
    // adds the value from the prizes array to the prizes arraylist and sets the player to the player parameter
    public GameMode(Player player, int[] prizes) {
        this.player = player;
        this.prizes = new ArrayList<>();
        this.cases = new ArrayList<>();
        this.dealAccepted = false;
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
    public void displayCasePicking(Scanner scan, int casesToPick, int total) {
        int caseNum;
        
        System.out.println("Pick " +casesToPick + " cases to open");
        displayCases();
        displayPrizes();

        while (casesToPick != 0) {
            boolean isValid = false;
            System.out.println("Please Pick a Case to open (" + casesToPick + " left to pick)");
            while (!isValid) {
                caseNum = checkCaseInput(scan, total);

                for (Case c : cases) {
                    if (c.getNumber() == caseNum) {
                        if (c.isOpen() == true) {
                            System.out.println("-----------------------------------------------------------------------");
                            System.out.println("Please select a case that has not been opened");
                        } else if (c.isPlayerCase() == true) {
                            System.out.println("-----------------------------------------------------------------------");
                            System.out.println("Please select a case that is not your own");
                        } else {
                            c.open();
                            displayCases();
                            this.prizes.removeIf(prize -> prize.equals(c.getPrize()));
                            displayPrizes();
                            System.out.println("-----------------------------------------------------------------------");
                            casesToPick--;
                            isValid = true;
                        }
                    }
                }
            }
        }
    }

    //displays an offer from a banker for the user to choose to accept or decline
    //takes a banker and scanner as parameter
    public void displayOffer(Banker banker, Scanner scan) {
        System.out.println("The banker has a new offer for you");
        displayPastOffers(banker);
        int offer = banker.makeOffer(prizes);

        System.out.println("The banker has given you an offer of: $" + offer);
        System.out.println("(1) Deal");
        System.out.println("(2) No Deal");
        int answer = checkOfferInput(scan);

        if (answer == 1) {
            System.out.println("-----------------------------------------------------------------------");
            System.out.println("You have accepted the offer");
            System.out.println("Well done you won: $" + offer);
            this.player.addTotalPrizes(offer);
            this.totalPrizes += offer;
            if (offer > this.player.getHighestPrize()) {
                this.player.setHighestPrize(offer);
            }
            this.player.addTotalPrizes(offer);
            this.player.addNewRecentPrizes(offer);
            this.player.addNewHighPrizes(offer);
            this.dealAccepted = true;
        } else {
            System.out.println("-----------------------------------------------------------------------");
            System.out.println("No Deal, the game shall continue");
        }
        System.out.println("-----------------------------------------------------------------------");
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
    @Override
    public void stopMode() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Are you sure you would like to quit the game?");
        System.out.println("(1) Yes");
        System.out.println("(2) No");

        boolean inputIsValid = false;
        while (!inputIsValid) {
            String answer = scan.nextLine().trim().toLowerCase();
            if (answer.equals("1") || answer.equals("yes") || answer.equals("y") || answer.equals("x") || answer.equals("ye") || answer.equals("one")) {
                System.out.println("-----------------------------------------------------------------------");
                System.out.println("Thanks for playing");
                System.out.println("Game Exiting");
                System.exit(0);
            } else if (answer.equals("2") || answer.equals("no") || answer.equals("n") || answer.equals("two")) {
                inputIsValid = true;
            } else {
                System.out.println("-----------------------------------------------------------------------");
                System.out.println("Invalid Answer, please select either: ");
                System.out.println("(1) Yes");
                System.out.println("(2) No");
            }
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

    //returns the dealAccepted value
    public boolean isDealAccepted() {
        return dealAccepted;
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

    //abstract methods for subclasses to override
    @Override
    public abstract void startMode();

    public abstract void displayCases();

}

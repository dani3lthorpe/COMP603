/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dealornodeal;

import java.util.Scanner;

/**
 * Tutorial class that extends the abstract class gameMode creates a tutorial
 * gameMode of deal or no deal where it explains to the user how to play deal or
 * no deal
 *
 * @author group69
 */
public class Tutorial extends GameMode {

    private static final int[] prizes = {1, 5, 10, 50, 100, 200};

    //tutorial constructor supers the prizes int array as well as the inputed player parameter
    public Tutorial(Player player) {
        super(player, prizes, 3);
    }

    //overrides abstract method displayCases so that it correctly displays all the cases
    @Override
    public void displayCases() {
        StringBuilder string = new StringBuilder();
        
        for (int i = 0; i < getCases().size(); i++) {
            string.append(getCases().get(i));
        }
        
        System.out.println(string);
    }

    //overrides startMode abstract method so that the game follows the tutorial mode game format
    @Override
    public void startMode() {
        Scanner scan = new Scanner(System.in);
        Banker banker = new Banker(5);

        System.out.println("-----------------------------------------------------------------------");
        System.out.println("Welcome to the tutorial for Deal or No Deal");
        System.out.println("Deal or no deal is a gameshow where players try and win as much money as possible");
        System.out.println("The first step of deal or no deal is to select a case to keep until the end");
        System.out.println("Please select your case from the following cases: ");
        displayCases();

        int caseNum = selectUserCase(scan, 6);

        System.out.println("Your case is " + caseNum);
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("Each round you will have a set number of cases to open");
        System.out.println("Once you pick a case to open you will see how much money that case contained and it will be removed from the pool, therefore, this amount is not in your selected case");
        System.out.println("Your aim is to select the cases with the smallest amount as you want to keep as much money as you can until the end");
        //displayCasePicking(scan, 3, 6);

        System.out.println("Once all the cases have been picked for the round the banker will offer you a amount of money depending on the money that could still be in the case you kept");
        System.out.println("You can choose to either accept the money and leave with the offered amount as your prize (deal)");
        System.out.println("Or you can continue playing if you believe your case has more money in it than the offer (no deal)");
        displayOffer(banker, scan);
        
        if (!isDealAccepted()) {
            //displayCasePicking(scan, 1, 6);
            System.out.println("This is the final offer as once there is only one case left on the board it will be time to open your case and see how much you won");
            displayOffer(banker, scan);
        }

        for (Case c : getCases()) {
            if (c.getNumber() == caseNum) {
                if (!isDealAccepted()) {
                    System.out.println("Now to open your case");
                    int currentScore = c.getPrize();

                    if (currentScore > getPlayer().getHighestPrize()) {
                        getPlayer().setHighestPrize(currentScore);
                    }
                    addTotalPrizes(currentScore);
                    getPlayer().addTotalPrizes(currentScore);
                    getPlayer().addNewRecentPrizes(currentScore);
                    getPlayer().addNewHighPrizes(currentScore);
                    c.open();
                } else {
                    System.out.println("Now to see what was in your case");
                    c.open();
                }
            }

        }
        System.out.println("Congratulations for completeing the deal or no deal tutorial");
    }
}


     

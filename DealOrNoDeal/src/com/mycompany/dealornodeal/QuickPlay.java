/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dealornodeal;

import java.util.Scanner;

/**
 * QuickPlay class that extends the abstract class gameMode
 * creates a QuickPlay gameMode of deal or no deal where it follows a shorter
 * deal or no deal format
 * @author group69
 */
public class QuickPlay extends GameMode {

    private static final int[] money = {1, 5, 10, 50, 100, 250, 500, 1000, 5000, 10000, 50000, 100000, 200000};

    //Quickplay constructor supers the prizes int array as well as the inputed player parameter
    public QuickPlay(Player player) {
        super(player, money, 5);
    }

    //overrides abstract method displayCases so that it correctly displays all the cases
    @Override
    public void displayCases() {
        StringBuilder string = new StringBuilder();
        
        for (int i = 0; i <= 5; i++) {
            string.append(getCases().get(i));
        }
        string.append("\n");
        
        for (int i = 6; i < getCases().size(); i++) {
            string.append(getCases().get(i));
        }
        System.out.println(string);
    }

    //overrides startMode abstract method so that the game follows the quick mode game format
    @Override
    public void startMode() {
        Scanner scan = new Scanner(System.in);
        Banker banker = new Banker(4);
        
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("Welcome to QuickPlay Deal or No Deal");
        System.out.println("Please select your case from the following cases: ");
        displayCases();
        int caseNum = selectUserCase(scan, 13);
       
        System.out.println("Your case is " + caseNum);
        
        System.out.println("-----------------------------------------------------------------------");
        //displayCasePicking(scan, 5, 13);
        //displayOffer(banker, scan);
        
        if (!isDealAccepted()) {
            //displayCasePicking(scan , 4, 13);
            //displayOffer(banker, scan);
        }
        if (!isDealAccepted()) {
            //displayCasePicking(scan, 2, 13);
            //displayOffer(banker, scan);
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
    }

}

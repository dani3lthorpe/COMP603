/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dealornodeal;

import java.util.Scanner;

/**
 * Normal class that extends the abstract class gameMode
 * creates a normal gameMode of deal or no deal where it follows the standard
 * deal or no deal format
 * @author group69
 */
public class NormalMode extends GameMode {

    private static final int[] prizes = {1, 2, 5, 10, 20, 50, 100, 150, 200, 250, 500, 750, 1000, 2000, 3000, 4000, 5000, 10000, 15000, 20000, 30000, 50000, 75000, 100000, 200000, 500000};

    //normal constructor supers the prizes int array as well as the inputed player parameter
    public NormalMode(Player player) {
        super(player, prizes);
    }

    //overrides abstract method displayCases so that it correctly displays all the cases
    @Override
    public void displayCases() {
        StringBuilder string = new StringBuilder();
        
        for (int i = 0; i <= 5; i++) {
            string.append(getCases().get(i));
        }
        string.append("\n");
        
        for (int i = 6; i <= 10; i++) {
            string.append(getCases().get(i));
        }
        string.append("\n");
        
        for (int i = 11; i <= 15; i++) {
            string.append(getCases().get(i));
        }
        string.append("\n");
        
        for (int i = 16; i <= 20; i++) {
            string.append(getCases().get(i));
        }
        string.append("\n");
        
        for (int i = 21; i < getCases().size(); i++) {
            string.append(getCases().get(i));
        }

        System.out.println(string);
    }

    //overrides startMode abstract method so that the game follows the normal mode game format
    @Override
    public void startMode() {
        Scanner scan = new Scanner(System.in);
        Banker banker = new Banker(1);
        
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("Welcome to Normal Deal or No Deal");
        System.out.println("Please select your case from the following cases: ");
        displayCases();
        int caseNum = selectUserCase(scan, 26);
        
        System.out.println("Your case is " + caseNum);
        
        System.out.println("-----------------------------------------------------------------------");
       // displayCasePicking(scan, 6, 26);
        displayOffer(banker, scan);
        
        if (!isDealAccepted()) {
            //displayCasePicking(scan, 6, 26);
            displayOffer(banker, scan);
        }
        
        if (!isDealAccepted()) {
            //displayCasePicking(scan, 5, 26);
            displayOffer(banker, scan);
        }
        
        if (!isDealAccepted()) {
            //displayCasePicking(scan, 4, 26);
            displayOffer(banker, scan);
        }
        
        if (!isDealAccepted()) {
           // displayCasePicking(scan, 2, 26);
            displayOffer(banker, scan);
        }
        
        if (!isDealAccepted()) {
           // displayCasePicking(scan, 1, 26);
            displayOffer(banker, scan);
        }
        
        for (Case c : getCases()) {
            if (c.getNumber() == caseNum) {
                if (!isDealAccepted()) {
                    System.out.println("Now to open your case: ");
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
                    System.out.println("Now to see what was in your case: ");
                    c.open();
                }
            }

        }
    }

}

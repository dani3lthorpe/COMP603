/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dealornodeal;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

/**
 * RandomMode class that extends the abstract class gameMode
 * creates a Random gameMode of deal or no deal where it follows the standard
 * deal or no deal format but all the prizes are randomized
 * @author group69
 */
public class RandomMode extends GameMode {

    //Random constructor supers the prizes int array created by the create prizes method
    //as well as the inputed player parameter
    public RandomMode(Player player) {
        super(player, createPrizes());
    }

    //sets the 26 prizes to random numbers between 1 and 500000
    public final static int[] createPrizes() {
        int[] prizes = new int[26];
        Random random = new Random();
        
        for (int i = 0; i < 26; i++) {
            prizes[i] = random.nextInt(500000);
        }
        
        Arrays.sort(prizes);
        return prizes;
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
        System.out.println("Welcome to Random Deal or No Deal");
        System.out.println("Please select your case from the following cases: ");
        displayCases();
        int caseNum = selectUserCase(scan, 26);
        
        System.out.println("Your case is " + caseNum);
        
        System.out.println("-----------------------------------------------------------------------");
        displayOffer(banker, scan);
        
        if (!isDealAccepted()) {
            displayOffer(banker, scan);
        }
        
        if (!isDealAccepted()) {
            displayOffer(banker, scan);
        }
        
        if (!isDealAccepted()) {
            displayOffer(banker, scan);
        }
        
        if (!isDealAccepted()) {
            displayOffer(banker, scan);
        }
        
        if (!isDealAccepted()) {
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
    }

}

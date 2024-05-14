/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dealornodeal;

/**
 * Case class controls all the case information
 *
 * @author group69
 */
public class Case {

    private int number;
    private int prize;
    private boolean playerCase;
    private boolean open;

    //Case constructer sets the case number and prize to a two given numbers and sets playercase and open to false
    //takes a case number and prize amount as parameters
    public Case(int number, int prize) {
        this.number = number;
        this.prize = prize;
        this.playerCase = false;
        this.open = false;
    }

    //sets case open to true and displays the amount the case contained
    public void open() {
        if (!this.playerCase) {
            System.out.println("-----------------------------------------------------------------------");
            System.out.println("Case " + getNumber() + " contained: $" + prize);
            open = true;
        } else {
            System.out.println("Your case " + getNumber() + " contained: $" + prize);
        }
    }

    //returns the case number
    public int getNumber() {
        return number;
    }

    //returns the prize amount
    public int getPrize() {
        return prize;
    }

    //returns the cases open value
    public boolean isOpen() {
        return open;
    }

    //returns playercase value
    public boolean isPlayerCase() {
        return playerCase;
    }

    //sets playercase to true
    public void setPlayerCase(boolean isPlayerCase) {
        this.playerCase = isPlayerCase;
    }

    //overrides to string to display cases properly
    @Override
    public String toString() {
        if (!this.playerCase) {
            if (!this.open) {
                return "  [" + getNumber() + "]  ";
            } else {
                return " [x] ";
            }
        } else {
            return "";
        }
    }

}

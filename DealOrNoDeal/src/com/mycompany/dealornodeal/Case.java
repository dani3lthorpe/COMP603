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

    //Case constructer sets the case number and prize to a two given numbers and sets playercase and open to false
    //takes a case number and prize amount as parameters
    public Case(int number, int prize) {
        this.number = number;
        this.prize = prize;
    }

    //returns the case number
    public int getNumber() {
        return number;
    }

    //returns the prize amount
    public int getPrize() {
        return prize;
    }


}

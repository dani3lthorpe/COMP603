/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.dealornodeal;
/**
 * 
 * @author group69
 */
public class DealOrNoDeal {

    //main method creates a game controller and starts the game
    public static void main(String[] args) {
        GameController game = new GameController();
        LoginView login = new LoginView();
        Controller controller = new Controller(login, game);
        game.displayMainMenu();
    }
}

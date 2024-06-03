/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dealornodeal;

/**
 *
 * @author hidan
 */
public class GameModeFactory {
    
    //creates a gameMode object baseed on the input gamemodeName, returns gameMode object
    public static GameMode getGameMode(String gameModeName, Player player) {
        GameMode gameMode = null;
        if ("normal".equalsIgnoreCase(gameModeName)) {
            gameMode = new NormalMode(player);
        }
        if ("quickplay".equalsIgnoreCase(gameModeName)) {
            gameMode = new QuickPlay(player);
        }
        if ("random mode".equalsIgnoreCase(gameModeName)) {
            gameMode = new RandomMode(player);
        }
        if ("tutorial".equalsIgnoreCase(gameModeName)) {
            gameMode = new Tutorial(player);
        }
        return gameMode;
    }
}

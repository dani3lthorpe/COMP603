/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.dealornodeal;

/**
 * Main class
 *
 * @author group69
 */
public class DealOrNoDeal {

    //main method creates a menu controller, model object, login gui and makes the login gui visible
    public static void main(String[] args) {
        Model game = new Model();
        LoginGUI login = new LoginGUI();
        MenuController controller = new MenuController(login, game);
        login.setVisible(true);
    }
}

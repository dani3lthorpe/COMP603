/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dealornodeal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * MenuController class controls interactions between the menu views and the model
 *
 * @author group69
 */
class MenuController implements ActionListener {

    private LoginGUI login;
    private MainMenuGUI mode;
    private GameModeSelectGUI gameMode;
    private ScoresGUI scores;
    private Model model;
    private GameOverGUI gameOver;

    // Constructor for menu controller, Takes login and model as parameters
    // Sets model and login to the input parameters, adds an ovserver to model with the parameter game over, adds an observer to getSores with the parameters scores
    public MenuController(LoginGUI login, Model model) {
        this.login = login;
        this.mode = new MainMenuGUI();
        this.gameMode = new GameModeSelectGUI();
        this.scores = new ScoresGUI();
        this.gameOver = new GameOverGUI();
        this.model = model;
        addActionListeners();
        this.model.addObserver(gameOver);
        this.model.getScoreManager().addObserver(scores);
    }

    // Overrides the action performed method
    // Checks what button was pressed by the user and performs the appropriate action depending on the button
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "Confirm":
                String username = this.login.getUsernameField().getText();
                this.model.checkPlayers(username);
                this.login.setVisible(false);
                this.mode.setVisible(true);
                this.mode.setUsername(username);
                break;
            case "Exit":
                if (this.login.isVisible()) {
                    this.login.exit();
                } else if (this.mode.isVisible()) {
                    this.mode.exit();
                } else if (this.scores.isVisible()) {
                    this.scores.exit();
                } else if (this.gameMode.isVisible()) {
                    this.gameMode.exit();
                } else if (this.scores.isVisible()) {
                    this.scores.exit();
                }
                break;
            case "Play Deal Or No Deal":
                this.mode.setVisible(false);
                this.gameMode.setVisible(true);
                break;
            case "See Scores":
                this.mode.setVisible(false);
                this.model.getScoreManager().setScores(this.model.getPlayer());
                this.scores.setVisible(true);
                break;
            case "Yes":
                this.gameOver.setVisible(false);
                this.mode.setVisible(true);
                this.model.getGameMode().getGameData().setDealAccepted(false);
                break;
            case "No":
                this.gameOver.exit();
                break;
            case "Go Back":
                if (this.scores.isVisible()) {
                    this.scores.setVisible(false);
                } else if (this.gameMode.isVisible()) {
                    this.gameMode.setVisible(false);
                }
                this.mode.setVisible(true);
                break;
            case "Log Out":
                boolean logout = this.mode.logOut();
                if (logout) {
                    this.mode.setVisible(false);
                    this.login.setVisible(true);
                }
                break;
            default:
                break;
        }
        if (command.equals("Normal") || command.equals("Tutorial") || command.equals("QuickPlay") || command.equals("Random Mode")) {
            this.gameMode.setVisible(false);
            this.model.selectGameMode(command);
            GameModeController gameModeController = new GameModeController(this.model, this.gameOver, this.mode);
            gameModeController.selectGameMode(command);

        }
    }

    // Adds action listeners to the login, mode, gmaemode, over and scores GUIs
    public final void addActionListeners() {
        this.login.addActionListener(this);
        this.mode.addActionListener(this);
        this.gameMode.addActionListener(this);
        this.gameOver.addActionListener(this);
        this.scores.addActionListener(this);
    }
}

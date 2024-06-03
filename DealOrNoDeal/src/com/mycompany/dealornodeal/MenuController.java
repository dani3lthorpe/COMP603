/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dealornodeal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author rny5546
 */
class MenuController implements ActionListener {

    private LoginGUI login;
    private MainMenu mode;
    private GameModeSelect gameMode;
    private ScoresGUI scores;
    private Model model;
    private GameOverGUI gameOver;

    public MenuController(LoginGUI login, Model model) {
        this.login = login;
        this.mode = new MainMenu();
        this.gameMode = new GameModeSelect();
        this.scores = new ScoresGUI();
        this.gameOver = new GameOverGUI();
        this.model = model;
        addActionListeners();
        this.model.addObserver(gameOver);
        this.model.getScoreManager().addObserver(scores);
    }

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

    public final void addActionListeners() {
        this.login.addActionListener(this);
        this.mode.addActionListener(this);
        this.gameMode.addActionListener(this);
        this.gameOver.addActionListener(this);
        this.scores.addActionListener(this);
    }
}

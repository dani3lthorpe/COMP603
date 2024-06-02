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

    private LoginView login;
    private ModeSelect mode;
    private GameModeSelect gameMode;
    private ScoresGUI scores;
    private Model model;
    private EndGameGUI endGame;

    public MenuController(LoginView view, Model model) {
        this.login = view;
        this.mode = new ModeSelect();
        this.gameMode = new GameModeSelect();
        this.scores = new ScoresGUI();
        this.endGame = new EndGameGUI();
        this.model = model;
        this.login.addActionListener(this);
        this.mode.addActionListener(this);
        this.gameMode.addActionListener(this);
        this.endGame.addActionListener(this);
        this.scores.addActionListener(this);
        this.model.addObserver(endGame);
        this.model.getScores().addObserver(scores);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "Confirm":
                String username = this.login.getUsernameField().getText();
                this.model.checkPlayers(username);
                login.setVisible(false);
                mode.setVisible(true);
                mode.setUsername(username);
                break;
            case "Exit":
                if (login.isVisible()) {
                    login.exit();
                } else if (mode.isVisible()) {
                    mode.exit();
                } else if (scores.isVisible()) {
                    scores.exit();
                } else if (gameMode.isVisible()) {
                    gameMode.exit();
                } else if (scores.isVisible()) {
                    scores.exit();
                }
                break;
            case "Play Deal Or No Deal":
                mode.setVisible(false);
                gameMode.setVisible(true);
                break;
            case "See Scores":
                mode.setVisible(false);
                model.getScores().setScores(model.getPlayer());
                scores.setVisible(true);
                break;
            case "Yes":
                endGame.setVisible(false);
                mode.setVisible(true);
                model.getGameMode().getGameData().setDealAccepted(false);
                break;
            case "No":
                endGame.exit();
                break;
            case "Go Back":
                if (scores.isVisible()) {
                    scores.setVisible(false);
                } else if (gameMode.isVisible()) {
                    gameMode.setVisible(false);
                }
                mode.setVisible(true);
                break;
            case "Log Out":
                boolean logout = mode.logOut();
                if (logout) {
                    mode.setVisible(false);
                    login.setVisible(true);
                }
                break;
            default:
                break;
        }
        if (command.equals("Normal") || command.equals("Tutorial") || command.equals("QuickPlay") || command.equals("Random Mode")) {
            gameMode.setVisible(false);
            model.selectGameMode(command);
            GameModeController gameModeController = new GameModeController(command, model, endGame, mode);
        }

    }
}

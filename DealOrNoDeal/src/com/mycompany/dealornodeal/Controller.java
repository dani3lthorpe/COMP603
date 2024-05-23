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
class Controller implements ActionListener {

    private LoginView login;
    private ModeSelect mode;
    private GameModeSelect gameMode;
    private NormalGUI normal;
    private QuickplayGUI quickplay;
    private TutorialGUI tutorial;
    private ScoresGUI scores;
    private GameController model;

    public Controller(LoginView view, GameController model) {
        this.login = view;
        this.mode = new ModeSelect();
        this.gameMode = new GameModeSelect();
        this.normal = new NormalGUI();
        this.quickplay = new QuickplayGUI();
        this.tutorial = new TutorialGUI();
        this.scores = new ScoresGUI();
        this.model = model;
        this.login.addActionListener(this);
        this.mode.addActionListener(this);
        this.gameMode.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "Confirm":
                String username = this.login.getUsernameField().getText();
                this.model.setPlayer(username);
                login.setVisible(false);
                mode.setVisible(true);
                mode.setText(username);
                break;
            case "Exit":
                if (login.isVisible()) {
                    login.exit();
                } else if (mode.isVisible()) {
                    mode.exit();
                }
                break;
            case "Play Deal Or No Deal":
                mode.setVisible(false);
                gameMode.setVisible(true);
                break;
            case "See Scores":
                mode.setVisible(false);
                scores.setScores(model.getGlobalTotalPrizes());
                scores.setVisible(true);
                break;
            case "Normal":
                mode.setVisible(false);
                model.selectGameMode("Normal");
                normal.setVisible(true);
                break;
            case "Tutorial":
                mode.setVisible(false);
                model.selectGameMode("Tutorial");
                tutorial.setVisible(true);
                break;
            case "QuickPlay":
                mode.setVisible(false);
                model.selectGameMode("QuickPlay");
                quickplay.setVisible(true);
                break;
            case "Random Mode":
                mode.setVisible(false);
                model.selectGameMode("Random");
                normal.setVisible(true);
                break;
            default:
                break;

        }

    }
}

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
    private NormalGUI normal;
    private QuickplayGUI quickplay;
    private TutorialGUI tutorial;
    private ScoresGUI scores;
    private GameController model;

    public Controller(LoginView view, ModeSelect modeSelect, NormalGUI normalGui, QuickplayGUI quickPlay, TutorialGUI tutorial, ScoresGUI scores, GameController model) {
        this.login = view;
        this.mode = modeSelect;
        this.normal = normalGui;
        this.quickplay = quickPlay;
        this.tutorial = tutorial;
        this.scores = scores;
        this.model = model;
        this.login.addActionListener(this);
        this.mode.addActionListener(this);

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
            case " ":
                
            default:
                break;

        }

    }
}
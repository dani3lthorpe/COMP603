/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dealornodeal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author hidan
 */
public class GameModeController implements ActionListener {

    private NormalGUI normal;
    private QuickplayGUI quickplay;
    private TutorialGUI tutorial;
    private Model model;
    private BankOfferGUI bankOffer;
    private endGameGUI endGame;
    private String gameType;

    GameModeController(String command, Model model, endGameGUI endGame) {
        this.model = model;
        this.bankOffer = new BankOfferGUI();
        this.model.addObserver(bankOffer);
        bankOffer.addActionListener(this);
        if (command.equals("Normal") || command.equals("Random Mode")) {
            this.normal = new NormalGUI(bankOffer);
            normal.setPrizes(model.getGameMode().getPrize());
            this.model.addObserver(normal);
            this.normal.addActionListener(this);
            normal.setVisible(true);
        } else if (command.equals("QuickPlay")) {
            this.quickplay = new QuickplayGUI();
            this.quickplay.addActionListener(this);
            quickplay.setVisible(true);
        } else if (command.equals("Tutorial")) {
            this.tutorial = new TutorialGUI();
            this.tutorial.addActionListener(this);
            tutorial.setVisible(true);
        }
        this.gameType = command;
        this.endGame = endGame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        try {
            int caseNumber = Integer.parseInt(command);
            if (caseNumber > 0 && caseNumber < 27) {
                if (normal.isVisible()) {
                    model.openCase(caseNumber);
                    normal.caseOpened((JButton) e.getSource(), model.getGameMode().getGameData());
                    model.getGameMode().getGameData().openedCase();
                }
                if (this.model.getGameMode().getGameData().getCasesToPick() == 0) {
                    this.model.deleteObserver(normal);
                    this.normal.setVisible(false);
                    this.model.getOffer();
                    this.model.newRound();
                    if (model.getGameMode().getGameData().getRound() != -1) {
                        this.bankOffer.setVisible(true);
                    } else {
                        this.model.addObserver(endGame);
                        this.model.endGame();
                        this.endGame.setVisible(true);
                    }
                }
            }
        } catch (NumberFormatException ex) {
            if (command.equals("Exit")) {
                if (normal.isVisible()) {
                    normal.exit();
                } else if (quickplay.isVisible()) {
                    quickplay.exit();
                } else if (tutorial.isVisible()) {
                    tutorial.exit();
                } else if (bankOffer.isVisible()) {
                    bankOffer.exit();
                } else if (endGame.isVisible()) {
                    endGame.exit();
                }
            } else if (command.equals("No Deal!")) {
                this.bankOffer.setVisible(false);
                if (gameType.equals("Normal") || gameType.equals("Random Mode")) {
                    this.model.addObserver(normal);
                    this.normal.setVisible(true);
                } else if (gameType.equals("QuickPlay")) {
                    this.model.addObserver(quickplay);
                    this.quickplay.setVisible(true);
                } else if (gameType.equals("Tutorial")) {
                    this.model.addObserver(tutorial);
                    this.tutorial.setVisible(true);
                }
            } else if (command.equals("Deal")) {

                this.model.getGameMode().acceptOffer();
                this.bankOffer.setVisible(false);
                this.model.addObserver(endGame);
                this.endGame.setVisible(true);

            } 
        }
    }
}

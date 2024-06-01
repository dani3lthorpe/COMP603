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

    GameModeController(String command, Model model, endGameGUI endGame) {
        this.model = model;
        this.bankOffer = new BankOfferGUI();
        this.model.addObserver(bankOffer);
        bankOffer.addActionListener(this);
        if (command.equals("Normal") || command.equals("Random Mode")) {
            this.normal = new NormalGUI();
            normal.setPrizes(model.getGameMode().getPrize());
            this.model.addObserver(normal);
            this.normal.addActionListener(this);
            normal.setVisible(true);
        } else if (command.equals("QuickPlay")) {
            this.quickplay = new QuickplayGUI();
            quickplay.setPrizes(model.getGameMode().getPrize());
            this.model.addObserver(quickplay);
            this.quickplay.addActionListener(this);
            quickplay.setVisible(true);
        } else if (command.equals("Tutorial")) {
            this.tutorial = new TutorialGUI();
            tutorial.setPrizes(model.getGameMode().getPrize());
            this.model.addObserver(tutorial);
            this.tutorial.addActionListener(this);
            tutorial.setVisible(true);
            tutorial.start();
        }
        this.endGame = endGame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        try {
            int caseNumber = Integer.parseInt(command);
            if (caseNumber > 0 && caseNumber < 27) {
                model.openCase(caseNumber);
                if (normal != null) {
                    normal.caseOpened((JButton) e.getSource(), model.getGameMode().getGameData());
                } else if (quickplay != null) {
                    quickplay.caseOpened((JButton) e.getSource(), model.getGameMode().getGameData());
                } else if (tutorial != null) {
                    tutorial.caseOpened((JButton) e.getSource(), model.getGameMode().getGameData());
                }
                model.getGameMode().getGameData().openedCase();

                if (this.model.getGameMode().getGameData().getCasesToPick() == 0) {
                    if (normal != null) {
                        this.normal.setVisible(false);
                    } else if (quickplay != null) {
                        this.quickplay.setVisible(false);
                    } else if (tutorial != null) {
                        if (this.model.getGameMode().getGameData().getRound() == 1) {
                            this.tutorial.bankOfferExplanation();
                        }
                        if (this.model.getGameMode().getGameData().getRound() == 2) {
                            this.tutorial.finalOfferExplanation();
                        }
                        this.tutorial.setVisible(false);
                    }
                    this.model.getOffer();
                    this.bankOffer.setVisible(true);
                }
            }
        } catch (NumberFormatException ex) {
            switch (command) {
                case "Exit":
                    if (normal != null && normal.isVisible()) {
                        normal.exit();
                    } else if (quickplay != null && quickplay.isVisible()) {
                        quickplay.exit();
                    } else if (tutorial != null && tutorial.isVisible()) {
                        tutorial.exit();
                    } else if (bankOffer.isVisible()) {
                        bankOffer.exit();
                    } else if (endGame.isVisible()) {
                        endGame.exit();
                    }
                    break;
                case "No Deal!":
                    this.model.newRound();
                    if (model.getGameMode().getGameData().getRound() != -1) {
                        this.bankOffer.setVisible(false);
                        if (normal != null) {
                            this.model.notifyView();
                            this.normal.setVisible(true);
                        } else if (quickplay != null) {
                            this.model.notifyView();
                            this.quickplay.setVisible(true);
                        } else if (tutorial != null) {
                            this.model.notifyView();
                            this.tutorial.setVisible(true);
                        }
                    } else {
                        this.model.endGame();
                        this.endGame.setVisible(true);
                    }
                    break;
                case "Deal!":
                    this.model.getGameMode().acceptOffer();
                    this.bankOffer.setVisible(false);
                    this.endGame.setVisible(true);
                    break;
                default:
                    break;
            }
        }
    }
}

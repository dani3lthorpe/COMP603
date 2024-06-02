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
    private EndGameGUI endGame;
    private ModeSelect mode;
    private GameMode gameMode;

    GameModeController(Model model, EndGameGUI endGame, ModeSelect mode) {
        this.model = model;
        this.bankOffer = new BankOfferGUI();
        this.model.addObserver(bankOffer);
        this.bankOffer.addActionListener(this);
        this.mode = mode;
        this.endGame = endGame;
        this.gameMode = model.getGameMode();
    }

    public void selectGameMode(String gameModeName) {
        if (gameModeName.equals("Normal") || gameModeName.equals("Random Mode")) {
            this.normal = new NormalGUI();
            this.normal.setPrizes(this.gameMode.getPrize());
            this.model.addObserver(this.normal);
            this.normal.addActionListener(this);
            this.normal.setVisible(true);
        } else if (gameModeName.equals("QuickPlay")) {
            this.quickplay = new QuickplayGUI();
            this.quickplay.setPrizes(this.gameMode.getPrize());
            this.model.addObserver(this.quickplay);
            this.quickplay.addActionListener(this);
            this.quickplay.setVisible(true);
        } else if (gameModeName.equals("Tutorial")) {
            this.tutorial = new TutorialGUI();
            this.tutorial.setPrizes(this.gameMode.getPrize());
            this.model.addObserver(this.tutorial);
            this.tutorial.addActionListener(this);
            this.tutorial.setVisible(true);
            this.tutorial.start();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "Exit":
                exitCheck();
                break;
            case "No Deal!":
                noDeal();
                break;
            case "Deal!":
                deal();
                break;
            case "Main Menu":
                openMainMenu();
                break;
            default:
                try {
                int caseNumber = Integer.parseInt(command);
                pickCase(caseNumber, e);
            } catch (NumberFormatException ex) {
            }
            break;
        }
    }

    public void pickCase(int caseNumber, ActionEvent e) {
        if (caseNumber > 0 && caseNumber < 27) {
            this.model.openCase(caseNumber);
            if (normal != null) {
                normal.caseOpened((JButton) e.getSource(), gameMode.getGameData());
            } else if (quickplay != null) {
                quickplay.caseOpened((JButton) e.getSource(), gameMode.getGameData());
            } else if (tutorial != null) {
                tutorial.caseOpened((JButton) e.getSource(), gameMode.getGameData());
            }
            gameMode.getGameData().openedCase();
            casePickedCheck();
        }
    }

    public void casePickedCheck() {
        if (this.gameMode.getGameData().getCasesToPick() == 0) {
            if (normal != null) {
                this.normal.setVisible(false);
            } else if (quickplay != null) {
                this.quickplay.setVisible(false);
            } else if (tutorial != null) {
                if (this.gameMode.getGameData().getRound() == 1) {
                    this.tutorial.bankOfferExplanation();
                }
                if (this.gameMode.getGameData().getRound() == 2) {
                    this.tutorial.finalOfferExplanation();
                }
                this.tutorial.setVisible(false);
            }
            this.model.getOffer();
            this.bankOffer.setVisible(true);
        }

    }

    public void exitCheck() {
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
    }

    public void openMainMenu() {
        if (bankOffer.isVisible()) {
            if (bankOffer.goBack()) {
                bankOffer.setVisible(false);
                mode.setVisible(true);
                if (normal != null) {
                    this.model.deleteObserver(normal);
                    this.normal = null;
                } else if (quickplay != null) {
                    this.model.deleteObserver(quickplay);
                    this.quickplay = null;
                } else if (tutorial != null) {
                    this.model.deleteObserver(tutorial);
                    this.tutorial = null;
                }
            }
        } else if (normal != null) {
            if (normal.goBack()) {
                normal.setVisible(false);
                mode.setVisible(true);
                this.model.deleteObserver(normal);
                this.normal = null;
            }
        } else if (quickplay != null) {
            if (quickplay.goBack()) {
                quickplay.setVisible(false);
                mode.setVisible(true);
                this.model.deleteObserver(quickplay);
                this.quickplay = null;
            }
        } else if (tutorial != null) {
            if (tutorial.goBack()) {
                tutorial.setVisible(false);
                mode.setVisible(true);
                this.model.deleteObserver(tutorial);
                this.tutorial = null;
            }
        }
    }

    public void deal() {
        this.gameMode.acceptOffer();
        this.model.notifyView();
        this.bankOffer.setVisible(false);
        this.model.saveGameData();
        this.endGame.setVisible(true);
        if (normal != null) {
            this.model.deleteObserver(normal);
            this.normal = null;
        } else if (quickplay != null) {
            this.model.deleteObserver(quickplay);
            this.quickplay = null;
        } else if (tutorial != null) {
            this.model.deleteObserver(tutorial);
            this.tutorial = null;
        }
    }

    public void noDeal() {
        this.bankOffer.setVisible(false);
        if (normal != null) {
            this.normal.setVisible(true);
            this.model.newRound();
            if (gameMode.getGameData().getRound() == -1) {
                this.gameMode.openYourCase();
                this.normal.setVisible(false);
                this.model.saveGameData();
                this.endGame.setVisible(true);
                this.model.deleteObserver(normal);
                this.normal = null;
            }
        } else if (quickplay != null) {
            this.quickplay.setVisible(true);
            this.model.newRound();
            if (gameMode.getGameData().getRound() == -1) {
                this.gameMode.openYourCase();
                this.quickplay.setVisible(false);
                this.model.saveGameData();
                this.endGame.setVisible(true);
                this.model.deleteObserver(quickplay);
                this.quickplay = null;
            }
        } else if (tutorial != null) {
            this.tutorial.setVisible(true);
            this.model.newRound();
            if (gameMode.getGameData().getRound() == -1) {
                this.gameMode.openYourCase();
                this.tutorial.setVisible(false);
                this.model.saveGameData();
                this.endGame.setVisible(true);
                this.model.deleteObserver(tutorial);
                this.tutorial = null;
            }
        }
    }
}

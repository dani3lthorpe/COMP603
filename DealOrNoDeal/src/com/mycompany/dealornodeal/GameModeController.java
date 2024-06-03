/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dealornodeal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 * GameModeController class connects the gameMode views with the model and
 * gameModes controls all interactions between the views and model
 *
 * @author group69
 */
public class GameModeController implements ActionListener {

    private NormalGUI normal;
    private QuickPlayGUI quickPlay;
    private TutorialGUI tutorial;
    private Model model;
    private BankOfferGUI bankOffer;
    private GameOverGUI gameOver;
    private MainMenuGUI mainMenu;
    private GameMode gameMode;

    // Constructor for game mode controller, takes model, endgame and mainmenu as  parameters. 
    // Sets the model to the input model, creates a bank offer gui, adds an observer to the bank offer gui, adds an action listener to the bank off gui
    // Sets the main menu to the input main menu, sets game over to the input endGame and sets the models game mode
    GameModeController(Model model, GameOverGUI endGame, MainMenuGUI mainMenu) {
        this.model = model;
        this.bankOffer = new BankOfferGUI();
        this.model.addObserver(bankOffer);
        this.bankOffer.addActionListener(this);
        this.mainMenu = mainMenu;
        this.gameOver = endGame;
        this.gameMode = model.getGameMode();
    }

    // Takes gameModeName as a parameter
    // Checks with mode name GameModeName is equal to, then creates the respective gui, sets the respective prices, adds an obderver to the model with the appropriate gamemode as a parameter, 
    // Adds an action listener to the respective mode and sets the gui to visible
    public void selectGameMode(String gameModeName) {
        if (gameModeName.equals("Normal") || gameModeName.equals("Random Mode")) {
            this.normal = new NormalGUI();
            this.normal.setPrizes(this.gameMode.getPrizes());
            this.model.addObserver(this.normal);
            this.normal.addActionListener(this);
            this.normal.setVisible(true);
        } else if (gameModeName.equals("QuickPlay")) {
            this.quickPlay = new QuickPlayGUI();
            this.quickPlay.setPrizes(this.gameMode.getPrizes());
            this.model.addObserver(this.quickPlay);
            this.quickPlay.addActionListener(this);
            this.quickPlay.setVisible(true);
        } else if (gameModeName.equals("Tutorial")) {
            this.tutorial = new TutorialGUI();
            this.tutorial.setPrizes(this.gameMode.getPrizes());
            this.model.addObserver(this.tutorial);
            this.tutorial.addActionListener(this);
            this.tutorial.setVisible(true);
            this.tutorial.startExplanation();
        }
    }

    // Overrides the action performed method
    // Checks what button was pressed by the user and performs the appropriate action depending on the button
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

    // Takes case number and action event as parameters
    // Checks what gamemode is currently being played, then opens the picked case
    // calls opened case from game data and checks if all the cases for the round have been picked
    public void pickCase(int caseNumber, ActionEvent e) {
        if (caseNumber > 0 && caseNumber < 27) {
            this.model.openCase(caseNumber);
            if (normal != null) {
                normal.caseSelected((JButton) e.getSource(), gameMode.getGameData());
            } else if (quickPlay != null) {
                quickPlay.caseSelected((JButton) e.getSource(), gameMode.getGameData());
            } else if (tutorial != null) {
                tutorial.caseSelected((JButton) e.getSource(), gameMode.getGameData());
            }
            gameMode.getGameData().openedCase();
            casePickedCheck();
        }
    }

    // Checks if all the cases for the round have been picked
    public void casePickedCheck() {
        if (this.gameMode.getGameData().getNumCasesToPick() == 0) {
            if (normal != null) {
                this.normal.setVisible(false);
            } else if (quickPlay != null) {
                this.quickPlay.setVisible(false);
            } else if (tutorial != null) {
                if (this.gameMode.getGameData().getRound() == 1) {
                    this.tutorial.bankOfferExplanation();
                }
                if (this.gameMode.getGameData().getRound() == 2) {
                    this.tutorial.finalOfferExplanation();
                }
                this.tutorial.setVisible(false);
            }
            this.model.updateOffer();
            this.bankOffer.setVisible(true);
        }

    }

    // Checks which GUI is visible and runs the gui's exit method
    public void exitCheck() {
        if (normal != null && normal.isVisible()) {
            normal.exit();
        } else if (quickPlay != null && quickPlay.isVisible()) {
            quickPlay.exit();
        } else if (tutorial != null && tutorial.isVisible()) {
            tutorial.exit();
        } else if (bankOffer.isVisible()) {
            bankOffer.exit();
        }
    }

    // Checks which gui is visible and which gamemode is being played before shutting them and returning to the main menu
    public void openMainMenu() {
        if (bankOffer.isVisible()) {
            if (bankOffer.goBack()) {
                bankOffer.setVisible(false);
                mainMenu.setVisible(true);
                if (normal != null) {
                    this.model.deleteObserver(normal);
                    this.normal = null;
                } else if (quickPlay != null) {
                    this.model.deleteObserver(quickPlay);
                    this.quickPlay = null;
                } else if (tutorial != null) {
                    this.model.deleteObserver(tutorial);
                    this.tutorial = null;
                }
            }
        } else if (normal != null) {
            if (normal.goBack()) {
                normal.setVisible(false);
                mainMenu.setVisible(true);
                this.model.deleteObserver(normal);
                this.normal = null;
            }
        } else if (quickPlay != null) {
            if (quickPlay.goBack()) {
                quickPlay.setVisible(false);
                mainMenu.setVisible(true);
                this.model.deleteObserver(quickPlay);
                this.quickPlay = null;
            }
        } else if (tutorial != null) {
            if (tutorial.goBack()) {
                tutorial.setVisible(false);
                mainMenu.setVisible(true);
                this.model.deleteObserver(tutorial);
                this.tutorial = null;
            }
        }
    }

    // Accepts offer, shuts the current GUI and opens the end game GUI
    public void deal() {
        this.gameMode.acceptOffer();
        this.model.notifyView();
        this.bankOffer.setVisible(false);
        this.model.saveGameData();
        this.gameOver.setVisible(true);
        if (normal != null) {
            this.model.deleteObserver(normal);
            this.normal = null;
        } else if (quickPlay != null) {
            this.model.deleteObserver(quickPlay);
            this.quickPlay = null;
        } else if (tutorial != null) {
            this.model.deleteObserver(tutorial);
            this.tutorial = null;
        }
    }

    // Declines offer and reopens the gamemode GUI
    public void noDeal() {
        this.bankOffer.setVisible(false);
        if (normal != null) {
            this.normal.setVisible(true);
            this.model.newRound();
            if (gameMode.getGameData().getRound() == -1) {
                this.gameMode.openYourCase();
                this.normal.setVisible(false);
                this.model.saveGameData();
                this.gameOver.setVisible(true);
                this.model.deleteObserver(normal);
                this.normal = null;
            }
        } else if (quickPlay != null) {
            this.quickPlay.setVisible(true);
            this.model.newRound();
            if (gameMode.getGameData().getRound() == -1) {
                this.gameMode.openYourCase();
                this.quickPlay.setVisible(false);
                this.model.saveGameData();
                this.gameOver.setVisible(true);
                this.model.deleteObserver(quickPlay);
                this.quickPlay = null;
            }
        } else if (tutorial != null) {
            this.tutorial.setVisible(true);
            this.model.newRound();
            if (gameMode.getGameData().getRound() == -1) {
                this.gameMode.openYourCase();
                this.tutorial.setVisible(false);
                this.model.saveGameData();
                this.gameOver.setVisible(true);
                this.model.deleteObserver(tutorial);
                this.tutorial = null;
            }
        }
    }
}

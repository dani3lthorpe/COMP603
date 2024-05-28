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

    GameModeController(String command, Model model) {
        this.model = model;
        this.bankOffer = new BankOfferGUI();
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
                }
            }
        } catch (NumberFormatException ex) {
            if (command.equals("Exit")) {
                if (normal.isVisible()) {
                    normal.exit();
                }
            }
        }
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dealornodeal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author hidan
 */
public class GameModeController implements ActionListener{

    private NormalGUI normal;
    private QuickplayGUI quickplay;
    private TutorialGUI tutorial;

    GameModeController(String command) {
        if (command.equals("Normal") || command.equals("Random Mode")) {
            this.normal = new NormalGUI();
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

    }
}

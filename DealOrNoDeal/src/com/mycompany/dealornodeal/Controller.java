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

    public LoginView login;
    public GameController model;

    public Controller(LoginView view, GameController model) {
        this.login = view;
        this.model = model;
        this.login.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "Confirm":
                String username = this.login.getUsernameField().getText();
                this.model.setPlayer(username);
                login.setVisible(false);
                break;
            case "Exit":
                login.exit();
            default:
                break;

        }

    }
}

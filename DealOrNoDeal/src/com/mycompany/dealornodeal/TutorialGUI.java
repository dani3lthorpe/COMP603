/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.dealornodeal;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JOptionPane;

/**
 *
 * @author droun
 */
public class TutorialGUI extends javax.swing.JFrame implements Observer {

    javax.swing.JLabel[] prizeArray;

    /**
     * Creates new form TutorialGUI
     */
    public TutorialGUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        exitButton = new javax.swing.JButton();
        prize1 = new javax.swing.JLabel();
        prize2 = new javax.swing.JLabel();
        prize3 = new javax.swing.JLabel();
        prize4 = new javax.swing.JLabel();
        prize5 = new javax.swing.JLabel();
        prize6 = new javax.swing.JLabel();
        case1 = new javax.swing.JButton();
        case2 = new javax.swing.JButton();
        case3 = new javax.swing.JButton();
        case4 = new javax.swing.JButton();
        case5 = new javax.swing.JButton();
        case6 = new javax.swing.JButton();
        title = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        exitButton.setText("Exit");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        prize1.setBackground(new java.awt.Color(204, 153, 0));
        prize1.setText("prize1");
        prize1.setOpaque(true);

        prize2.setBackground(new java.awt.Color(204, 153, 0));
        prize2.setText("prize2");
        prize2.setOpaque(true);

        prize3.setBackground(new java.awt.Color(204, 153, 0));
        prize3.setText("prize3");
        prize3.setOpaque(true);

        prize4.setBackground(new java.awt.Color(204, 153, 0));
        prize4.setText("prize4");
        prize4.setOpaque(true);

        prize5.setBackground(new java.awt.Color(204, 153, 0));
        prize5.setText("prize5");
        prize5.setOpaque(true);

        prize6.setBackground(new java.awt.Color(204, 153, 0));
        prize6.setText("prize6");
        prize6.setOpaque(true);

        case1.setText("1");
        case1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                case1ActionPerformed(evt);
            }
        });

        case2.setText("2");
        case2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                case2ActionPerformed(evt);
            }
        });

        case3.setText("3");
        case3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                case3ActionPerformed(evt);
            }
        });

        case4.setText("4");
        case4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                case4ActionPerformed(evt);
            }
        });

        case5.setText("5");
        case5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                case5ActionPerformed(evt);
            }
        });

        case6.setText("6");
        case6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                case6ActionPerformed(evt);
            }
        });

        title.setText("Pick Your Case");

        backButton.setText("Main Menu");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(title)
                .addGap(328, 328, 328)
                .addComponent(exitButton))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(prize1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(prize4, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(prize2, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(prize5, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(prize3, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(case1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 129, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(case6, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(case2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(111, 111, 111)
                                .addComponent(case3, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(prize6, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(281, 281, 281)
                .addComponent(case4, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(129, 129, 129)
                .addComponent(case5, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(exitButton)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(title)))
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(prize1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(prize4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(prize2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(prize5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(prize3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(prize6, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(case1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(case2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(case3, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(case4, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(case5, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(case6, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_exitButtonActionPerformed

    private void case1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_case1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_case1ActionPerformed

    private void case2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_case2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_case2ActionPerformed

    private void case3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_case3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_case3ActionPerformed

    private void case4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_case4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_case4ActionPerformed

    private void case5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_case5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_case5ActionPerformed

    private void case6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_case6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_case6ActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_backButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TutorialGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TutorialGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TutorialGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TutorialGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TutorialGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JButton case1;
    private javax.swing.JButton case2;
    private javax.swing.JButton case3;
    private javax.swing.JButton case4;
    private javax.swing.JButton case5;
    private javax.swing.JButton case6;
    private javax.swing.JButton exitButton;
    private javax.swing.JLabel prize1;
    private javax.swing.JLabel prize2;
    private javax.swing.JLabel prize3;
    private javax.swing.JLabel prize4;
    private javax.swing.JLabel prize5;
    private javax.swing.JLabel prize6;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
  public void addActionListener(ActionListener listener) {
        this.case1.addActionListener(listener);
        this.case2.addActionListener(listener);
        this.case3.addActionListener(listener);
        this.case4.addActionListener(listener);
        this.case5.addActionListener(listener);
        this.case6.addActionListener(listener);
        this.exitButton.addActionListener(listener);
        this.backButton.addActionListener(listener);
    }

    public void setPrizes(int[] prizes) {
        this.prizeArray = new javax.swing.JLabel[6];
        prizeArray[0] = this.prize1;
        prizeArray[1] = this.prize2;
        prizeArray[2] = this.prize3;
        prizeArray[3] = this.prize4;
        prizeArray[4] = this.prize5;
        prizeArray[5] = this.prize6;

        for (int i = 0; i < prizes.length && i < prizeArray.length; i++) {
            prizeArray[i].setText("$" + prizes[i]);
        }
    }

    public void exit() {
        if (JOptionPane.showConfirmDialog(this, "Do you want to quit?", "Deal Or No Deal", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    public boolean goBack() {
        if (JOptionPane.showConfirmDialog(this, "Are you sure you want to go back to the main menu (You will lose all your current progress)", "Deal Or No Deal", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            return true;
        }
        return false;
    }

    public void caseOpened(javax.swing.JButton source, GameData gameData) {
        if (gameData.getPlayerCase() != gameData.getCurrentCase()) {
            source.setEnabled(false);
            source.setText("");
        } else {
            source.setText("Your Case");
            Font font = new Font("Segoe UI", 0, 10);
            source.setFont(font);
            source.setBackground(new java.awt.Color(204, 255, 204));
            JOptionPane.showMessageDialog(this, "Each round you will have a set number of cases to open");
            JOptionPane.showMessageDialog(this, "Once you pick a case to open you will see how much money that case contained and it will be removed from the pool, therefore, this amount is not in your selected case");
            JOptionPane.showMessageDialog(this, "Your aim is to select the cases with the smallest amount as you want to keep as much money as you can until the end");
        }
    }

    public void start() {
        JOptionPane.showMessageDialog(this, "Welcome to the tutorial for Deal or No Deal");
        JOptionPane.showMessageDialog(this, "Deal or no deal is a gameshow where players try and win as much money as possible");
        JOptionPane.showMessageDialog(this, "The first step of deal or no deal is to select a case to keep until the end");
    }

    public void bankOfferExplanation() {
        JOptionPane.showMessageDialog(this, "Once all the cases have been picked for the round the banker will offer you a amount of money depending on the money that could still be in the case you kept");
        JOptionPane.showMessageDialog(this, "You can choose to either accept the money and leave with the offered amount as your prize (deal)");
        JOptionPane.showMessageDialog(this, "Or you can continue playing if you believe your case has more money in it than the offer (no deal)");
    }

    public void finalOfferExplanation() {
        JOptionPane.showMessageDialog(this, "This is the final offer as once there is only one case left on the board it will be time to open your case and see how much you won");
    }

    @Override
    public void update(Observable o, Object arg) {
        GameData gameData = (GameData) arg;
        title.setText(gameData.getCasesToPick() + " Cases To Pick");
        if (gameData.getCurrentCase() != null) {
            if (gameData.getPlayerCase() != gameData.getCurrentCase()) {
                int caseNum = gameData.getCurrentCase().getNumber();
                JOptionPane.showMessageDialog(this, "Case " + caseNum + " contained: $" + gameData.getCurrentCase().getPrize());
                for (int i = 0; i < prizeArray.length; i++) {
                    if (prizeArray[i].getText().equals("$" + gameData.getCurrentCase().getPrize())) {
                        prizeArray[i].setText("");
                    }
                }
            }
        }
    }
}

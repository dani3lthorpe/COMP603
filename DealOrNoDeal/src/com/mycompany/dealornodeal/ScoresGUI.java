/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.dealornodeal;

import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JOptionPane;

/**
 *
 * @author droun
 */
public class ScoresGUI extends javax.swing.JFrame implements Observer {

    /**
     * Creates new form Scores
     */
    public ScoresGUI() {
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

        title = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        yourHighestPrizes = new javax.swing.JLabel();
        personalLabel = new javax.swing.JLabel();
        exitButton = new javax.swing.JButton();
        yourHighestPrize1 = new javax.swing.JLabel();
        yourHighestPrize2 = new javax.swing.JLabel();
        yourHighestPrize3 = new javax.swing.JLabel();
        yourHighestPrize4 = new javax.swing.JLabel();
        yourHighestPrize5 = new javax.swing.JLabel();
        yourRecentPrizes = new javax.swing.JLabel();
        yourRecentPrize1 = new javax.swing.JLabel();
        yourRecentPrize2 = new javax.swing.JLabel();
        yourRecentPrize3 = new javax.swing.JLabel();
        yourRecentPrize4 = new javax.swing.JLabel();
        yourRecentPrize5 = new javax.swing.JLabel();
        yourTotalPrizes = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        globalScores = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();
        globalTotalPrizes = new javax.swing.JLabel();
        globalTotalPrize1 = new javax.swing.JLabel();
        globalTotalPrize2 = new javax.swing.JLabel();
        globalTotalPrize3 = new javax.swing.JLabel();
        globalTotalPrize4 = new javax.swing.JLabel();
        globalTotalPrize5 = new javax.swing.JLabel();
        globalHighestPrizes = new javax.swing.JLabel();
        globalHighestPrize1 = new javax.swing.JLabel();
        globalHighestPrize2 = new javax.swing.JLabel();
        globalHighestPrize3 = new javax.swing.JLabel();
        globalHighestPrize4 = new javax.swing.JLabel();
        globalHighestPrize5 = new javax.swing.JLabel();
        gameStats = new javax.swing.JLabel();
        globalLabel4 = new javax.swing.JLabel();
        games = new javax.swing.JLabel();
        totalPrizesWon = new javax.swing.JLabel();
        prizes = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        title.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("Scores");
        title.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        yourHighestPrizes.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        yourHighestPrizes.setText("Highest Prizes");
        yourHighestPrizes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        personalLabel.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        personalLabel.setText("Your Scores");
        personalLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        exitButton.setText("Exit");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        yourHighestPrize1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        yourHighestPrize1.setText("Prize1");

        yourHighestPrize2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        yourHighestPrize2.setText("Prize2");

        yourHighestPrize3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        yourHighestPrize3.setText("Prize3");

        yourHighestPrize4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        yourHighestPrize4.setText("Prize4");

        yourHighestPrize5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        yourHighestPrize5.setText("Prize5");

        yourRecentPrizes.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        yourRecentPrizes.setText("Recent Prizes");
        yourRecentPrizes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        yourRecentPrize1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        yourRecentPrize1.setText("Prize1");

        yourRecentPrize2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        yourRecentPrize2.setText("Prize2");

        yourRecentPrize3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        yourRecentPrize3.setText("Prize3");

        yourRecentPrize4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        yourRecentPrize4.setText("Prize4");

        yourRecentPrize5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        yourRecentPrize5.setText("Prize5");

        yourTotalPrizes.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        yourTotalPrizes.setText("Total Prizes: ");
        yourTotalPrizes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 136, Short.MAX_VALUE)
                .addComponent(personalLabel)
                .addGap(59, 59, 59)
                .addComponent(exitButton))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(yourHighestPrizes)
                    .addComponent(yourRecentPrizes)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(yourHighestPrize2)
                            .addComponent(yourHighestPrize1)
                            .addComponent(yourHighestPrize3)
                            .addComponent(yourHighestPrize4)
                            .addComponent(yourHighestPrize5)
                            .addComponent(yourRecentPrize2)
                            .addComponent(yourRecentPrize1)
                            .addComponent(yourRecentPrize3)
                            .addComponent(yourRecentPrize4)
                            .addComponent(yourRecentPrize5)))
                    .addComponent(yourTotalPrizes))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(exitButton)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(personalLabel)))
                .addGap(22, 22, 22)
                .addComponent(yourHighestPrizes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(yourHighestPrize1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(yourHighestPrize2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(yourHighestPrize3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(yourHighestPrize4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(yourHighestPrize5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(yourRecentPrizes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(yourRecentPrize1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(yourRecentPrize2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(yourRecentPrize3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(yourRecentPrize4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(yourRecentPrize5)
                .addGap(18, 18, 18)
                .addComponent(yourTotalPrizes)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        globalScores.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        globalScores.setText("Global Scores");
        globalScores.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        backButton.setText("Go Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        globalTotalPrizes.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        globalTotalPrizes.setText("Total Prizes");
        globalTotalPrizes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        globalTotalPrize1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        globalTotalPrize1.setText("Prize1");

        globalTotalPrize2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        globalTotalPrize2.setText("Prize2");

        globalTotalPrize3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        globalTotalPrize3.setText("Prize3");

        globalTotalPrize4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        globalTotalPrize4.setText("Prize4");

        globalTotalPrize5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        globalTotalPrize5.setText("Prize5");

        globalHighestPrizes.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        globalHighestPrizes.setText("Highest Prizes");
        globalHighestPrizes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        globalHighestPrize1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        globalHighestPrize1.setText("Prize1");

        globalHighestPrize2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        globalHighestPrize2.setText("Prize2");

        globalHighestPrize3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        globalHighestPrize3.setText("Prize3");

        globalHighestPrize4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        globalHighestPrize4.setText("Prize4");

        globalHighestPrize5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        globalHighestPrize5.setText("Prize5");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(globalScores))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(globalTotalPrizes)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(globalTotalPrize2)
                                    .addComponent(globalTotalPrize1)
                                    .addComponent(globalTotalPrize3)
                                    .addComponent(globalTotalPrize4)
                                    .addComponent(globalTotalPrize5)))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(globalHighestPrizes)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(globalHighestPrize2)
                                    .addComponent(globalHighestPrize1)
                                    .addComponent(globalHighestPrize3)
                                    .addComponent(globalHighestPrize4)
                                    .addComponent(globalHighestPrize5))))))
                .addContainerGap(105, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(globalScores)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(globalTotalPrizes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(globalTotalPrize1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(globalTotalPrize2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(globalTotalPrize3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(globalTotalPrize4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(globalTotalPrize5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(globalHighestPrizes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(globalHighestPrize1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(globalHighestPrize2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(globalHighestPrize3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(globalHighestPrize4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(globalHighestPrize5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        gameStats.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        gameStats.setText("Game Stats");
        gameStats.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        globalLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        globalLabel4.setText("Total Games Played");
        globalLabel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        games.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        games.setText("Games");

        totalPrizesWon.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        totalPrizesWon.setText("Total Prizes Won");
        totalPrizesWon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        prizes.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        prizes.setText("Prizes");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(gameStats))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(globalLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(games))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(totalPrizesWon))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(prizes)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(gameStats)
                        .addGap(45, 45, 45)
                        .addComponent(globalLabel4)
                        .addGap(34, 34, 34)
                        .addComponent(games)
                        .addGap(37, 37, 37)
                        .addComponent(totalPrizesWon)
                        .addGap(44, 44, 44)
                        .addComponent(prizes)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_exitButtonActionPerformed

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
            java.util.logging.Logger.getLogger(ScoresGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ScoresGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ScoresGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ScoresGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ScoresGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JButton exitButton;
    private javax.swing.JLabel gameStats;
    private javax.swing.JLabel games;
    private javax.swing.JLabel globalHighestPrize1;
    private javax.swing.JLabel globalHighestPrize2;
    private javax.swing.JLabel globalHighestPrize3;
    private javax.swing.JLabel globalHighestPrize4;
    private javax.swing.JLabel globalHighestPrize5;
    private javax.swing.JLabel globalHighestPrizes;
    private javax.swing.JLabel globalLabel4;
    private javax.swing.JLabel globalScores;
    private javax.swing.JLabel globalTotalPrize1;
    private javax.swing.JLabel globalTotalPrize2;
    private javax.swing.JLabel globalTotalPrize3;
    private javax.swing.JLabel globalTotalPrize4;
    private javax.swing.JLabel globalTotalPrize5;
    private javax.swing.JLabel globalTotalPrizes;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel personalLabel;
    private javax.swing.JLabel prizes;
    private javax.swing.JLabel title;
    private javax.swing.JLabel totalPrizesWon;
    private javax.swing.JLabel yourHighestPrize1;
    private javax.swing.JLabel yourHighestPrize2;
    private javax.swing.JLabel yourHighestPrize3;
    private javax.swing.JLabel yourHighestPrize4;
    private javax.swing.JLabel yourHighestPrize5;
    private javax.swing.JLabel yourHighestPrizes;
    private javax.swing.JLabel yourRecentPrize1;
    private javax.swing.JLabel yourRecentPrize2;
    private javax.swing.JLabel yourRecentPrize3;
    private javax.swing.JLabel yourRecentPrize4;
    private javax.swing.JLabel yourRecentPrize5;
    private javax.swing.JLabel yourRecentPrizes;
    private javax.swing.JLabel yourTotalPrizes;
    // End of variables declaration//GEN-END:variables

    public void addActionListener(ActionListener listener) {
        this.exitButton.addActionListener(listener);
        this.backButton.addActionListener(listener);
    }

    public void setGlobalTotalPrizes(HashMap<String, Integer> globalTotalPrizes) {
        int count = 1;
        for (Map.Entry<String, Integer> entry : globalTotalPrizes.entrySet()) {
            String text = entry.getKey().substring(0, 1).toUpperCase() + entry.getKey().substring(1) + ": $" + entry.getValue();
            switch (count) {
                case 1:
                    globalTotalPrize1.setText("1. " + text);
                    break;
                case 2:
                    globalTotalPrize2.setText("2. " + text);
                    break;
                case 3:
                    globalTotalPrize3.setText("3. " + text);
                    break;
                case 4:
                    globalTotalPrize4.setText("4. " + text);
                    break;
                case 5:
                    globalTotalPrize5.setText("5. " + text);
                    break;
            }
            count++;
        }
    }

    public void setGlobalHighPrizes(HashMap<String, Integer> globalHighPrizes) {
        int count = 1;
        for (Map.Entry<String, Integer> entry : globalHighPrizes.entrySet()) {
            String text = entry.getKey().substring(0, 1).toUpperCase() + entry.getKey().substring(1) + ": $" + entry.getValue();
            switch (count) {
                case 1:
                    globalHighestPrize1.setText("1. " + text);
                    break;
                case 2:
                    globalHighestPrize2.setText("2. " + text);
                    break;
                case 3:
                    globalHighestPrize3.setText("3. " + text);
                    break;
                case 4:
                    globalHighestPrize4.setText("4. " + text);
                    break;
                case 5:
                    globalHighestPrize5.setText("5. " + text);
                    break;
            }
            count++;
        }
    }

    public void setTotalStats(int[] totalStats) {
        games.setText(totalStats[0] + " games played");
        prizes.setText("$" + totalStats[1] + "  won");
    }

    public void setYourTotalPrizes(int totalPrizes) {
        yourTotalPrizes.setText("$" + totalPrizes);
    }

    public void setYourHighestPrizes(int[] highestPrizes) {
        yourHighestPrize1.setText("1. $" + highestPrizes[0]);
        yourHighestPrize2.setText("2. $" + highestPrizes[1]);
        yourHighestPrize3.setText("3. $" + highestPrizes[2]);
        yourHighestPrize4.setText("4. $" + highestPrizes[3]);
        yourHighestPrize5.setText("5. $" + highestPrizes[4]);
    }

    public void setYourRecentPrizes(int[] recentPrizes) {
        yourRecentPrize1.setText("1. $" + recentPrizes[0]);
        yourRecentPrize2.setText("2. $" + recentPrizes[1]);
        yourRecentPrize3.setText("3. $" + recentPrizes[2]);
        yourRecentPrize4.setText("4. $" + recentPrizes[3]);
        yourRecentPrize5.setText("5. $" + recentPrizes[4]);
    }

    public void exit() {
        if (JOptionPane.showConfirmDialog(this, "Do you want to quit?", "Deal Or No Deal", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        Scores scores = (Scores) arg;
        String playerName = scores.getPlayerName();
        setGlobalTotalPrizes(scores.getGlobalTotalPrizes());
        setGlobalHighPrizes(scores.getGlobalHighPrizes());
        setTotalStats(scores.getTotalStats());
        setYourRecentPrizes(scores.getRecentPrizes().get(playerName));
        setYourHighestPrizes(scores.getHighestPrizes().get(playerName));
        setYourTotalPrizes(scores.getTotalPlayerPrizes());
    }
}

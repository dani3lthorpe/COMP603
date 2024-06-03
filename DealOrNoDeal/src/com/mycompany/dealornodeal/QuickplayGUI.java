/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.dealornodeal;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JOptionPane;

/**
 *
 * @author droun
 */
public class QuickPlayGUI extends javax.swing.JFrame implements Observer {

    javax.swing.JLabel[] prizeArray;

    /**
     * Creates new form QuickplayGUI
     */
    public QuickPlayGUI() {
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
        prize1 = new javax.swing.JLabel();
        prize2 = new javax.swing.JLabel();
        prize3 = new javax.swing.JLabel();
        prize4 = new javax.swing.JLabel();
        prize5 = new javax.swing.JLabel();
        prize6 = new javax.swing.JLabel();
        prize7 = new javax.swing.JLabel();
        prize8 = new javax.swing.JLabel();
        prize9 = new javax.swing.JLabel();
        prize10 = new javax.swing.JLabel();
        prize11 = new javax.swing.JLabel();
        prize12 = new javax.swing.JLabel();
        prize13 = new javax.swing.JLabel();
        case1 = new javax.swing.JButton();
        case2 = new javax.swing.JButton();
        case3 = new javax.swing.JButton();
        case4 = new javax.swing.JButton();
        case5 = new javax.swing.JButton();
        case6 = new javax.swing.JButton();
        case7 = new javax.swing.JButton();
        case8 = new javax.swing.JButton();
        case9 = new javax.swing.JButton();
        case10 = new javax.swing.JButton();
        case11 = new javax.swing.JButton();
        case12 = new javax.swing.JButton();
        case13 = new javax.swing.JButton();
        exit = new javax.swing.JButton();
        backButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        title.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("Pick Your Case");

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

        prize7.setBackground(new java.awt.Color(204, 153, 0));
        prize7.setText("prize7");
        prize7.setOpaque(true);

        prize8.setBackground(new java.awt.Color(204, 153, 0));
        prize8.setText("prize8");
        prize8.setOpaque(true);

        prize9.setBackground(new java.awt.Color(204, 153, 0));
        prize9.setText("prize9");
        prize9.setOpaque(true);

        prize10.setBackground(new java.awt.Color(204, 153, 0));
        prize10.setText("prize10");
        prize10.setOpaque(true);

        prize11.setBackground(new java.awt.Color(204, 153, 0));
        prize11.setText("prize11");
        prize11.setOpaque(true);

        prize12.setBackground(new java.awt.Color(204, 153, 0));
        prize12.setText("prize12");
        prize12.setOpaque(true);

        prize13.setBackground(new java.awt.Color(204, 153, 0));
        prize13.setText("prize13");
        prize13.setOpaque(true);

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
        case6.setToolTipText("");
        case6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                case6ActionPerformed(evt);
            }
        });

        case7.setText("7");
        case7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                case7ActionPerformed(evt);
            }
        });

        case8.setText("8");
        case8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                case8ActionPerformed(evt);
            }
        });

        case9.setText("9");
        case9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                case9ActionPerformed(evt);
            }
        });

        case10.setText("10");
        case10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                case10ActionPerformed(evt);
            }
        });

        case11.setText("11");
        case11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                case11ActionPerformed(evt);
            }
        });

        case12.setText("12");
        case12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                case12ActionPerformed(evt);
            }
        });

        case13.setText("13");
        case13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                case13ActionPerformed(evt);
            }
        });

        exit.setText("Exit");

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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(prize3, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(prize4, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(117, 117, 117)
                        .addComponent(case5, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59)
                        .addComponent(case6, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addComponent(case7, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(prize10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(prize11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(prize1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(prize2, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(prize5, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(prize6, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(case8, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(59, 59, 59)
                                .addComponent(case9, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(55, 55, 55)
                                .addComponent(case10, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                                .addComponent(case11, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(case1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(54, 54, 54)
                                .addComponent(case2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(case3, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45)
                                .addComponent(case4, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(62, 62, 62)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(prize8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(prize9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(prize12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(prize13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(204, 204, 204)
                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(exit))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(prize7, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(117, 117, 117)
                        .addComponent(case12, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(197, 197, 197)
                        .addComponent(case13, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(exit))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(prize1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(prize8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(prize2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(prize9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(case1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(case2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(case3, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(case4, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(prize3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(prize10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(prize4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(prize11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(case6, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(case7, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(case5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(prize5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(prize12, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(prize6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(prize13, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(case8, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(case9, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(case10, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(case11, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(prize7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(case12, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(case13, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(78, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void case7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_case7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_case7ActionPerformed

    private void case8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_case8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_case8ActionPerformed

    private void case9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_case9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_case9ActionPerformed

    private void case10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_case10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_case10ActionPerformed

    private void case11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_case11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_case11ActionPerformed

    private void case12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_case12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_case12ActionPerformed

    private void case13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_case13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_case13ActionPerformed

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
            java.util.logging.Logger.getLogger(QuickPlayGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuickPlayGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuickPlayGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuickPlayGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuickPlayGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JButton case1;
    private javax.swing.JButton case10;
    private javax.swing.JButton case11;
    private javax.swing.JButton case12;
    private javax.swing.JButton case13;
    private javax.swing.JButton case2;
    private javax.swing.JButton case3;
    private javax.swing.JButton case4;
    private javax.swing.JButton case5;
    private javax.swing.JButton case6;
    private javax.swing.JButton case7;
    private javax.swing.JButton case8;
    private javax.swing.JButton case9;
    private javax.swing.JButton exit;
    private javax.swing.JLabel prize1;
    private javax.swing.JLabel prize10;
    private javax.swing.JLabel prize11;
    private javax.swing.JLabel prize12;
    private javax.swing.JLabel prize13;
    private javax.swing.JLabel prize2;
    private javax.swing.JLabel prize3;
    private javax.swing.JLabel prize4;
    private javax.swing.JLabel prize5;
    private javax.swing.JLabel prize6;
    private javax.swing.JLabel prize7;
    private javax.swing.JLabel prize8;
    private javax.swing.JLabel prize9;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
    public void addActionListener(ActionListener listener) {
        this.case1.addActionListener(listener);
        this.case2.addActionListener(listener);
        this.case3.addActionListener(listener);
        this.case4.addActionListener(listener);
        this.case5.addActionListener(listener);
        this.case6.addActionListener(listener);
        this.case7.addActionListener(listener);
        this.case8.addActionListener(listener);
        this.case9.addActionListener(listener);
        this.case10.addActionListener(listener);
        this.case11.addActionListener(listener);
        this.case12.addActionListener(listener);
        this.case13.addActionListener(listener);
        this.exit.addActionListener(listener);
        this.backButton.addActionListener(listener);
    }

    public void setPrizes(ArrayList<Integer> prizes) {
        this.prizeArray = new javax.swing.JLabel[13];
        this.prizeArray[0] = this.prize1;
        this.prizeArray[1] = this.prize2;
        this.prizeArray[2] = this.prize3;
        this.prizeArray[3] = this.prize4;
        this.prizeArray[4] = this.prize5;
        this.prizeArray[5] = this.prize6;
        this.prizeArray[6] = this.prize7;
        this.prizeArray[7] = this.prize8;
        this.prizeArray[8] = this.prize9;
        this.prizeArray[9] = this.prize10;
        this.prizeArray[10] = this.prize11;
        this.prizeArray[11] = this.prize12;
        this.prizeArray[12] = this.prize13;

        for (int i = 0; i < prizes.size() && i < this.prizeArray.length; i++) {
            this.prizeArray[i].setText("$" + prizes.get(i));
        }
    }

    public void exit() {
        if (JOptionPane.showConfirmDialog(this, "Do you want to quit?", "Deal Or No Deal", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
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
        }
    }

    public boolean goBack() {
        if (JOptionPane.showConfirmDialog(this, "Are you sure you want to go back to the main menu (You will lose all your current progress)", "Deal Or No Deal", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            return true;
        }
        return false;
    }

    @Override
    public void update(Observable o, Object arg) {
        GameData gameData = (GameData) arg;
        if (gameData.getRound() != -1) {
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
        } else {
            title.setText("Time to open your case!");
            JOptionPane.showMessageDialog(this, "Time to Open Your Case");
            JOptionPane.showMessageDialog(this, "Your Case contained: $" + gameData.getPlayerCase().getPrize());

        }
    }
}

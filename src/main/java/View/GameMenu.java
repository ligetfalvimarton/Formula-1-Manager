/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Marton
 */
public class GameMenu extends javax.swing.JPanel {
    private final MainWindow window; 
    /**
     * Creates new form GameMenu
     */
    public GameMenu(final MainWindow window) {
        this.window = window;
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

        titleLabel = new javax.swing.JLabel();
        resumeGameButton = new javax.swing.JButton();
        leaveToMenuButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();
        achievementsButton = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(1280, 720));
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setPreferredSize(new java.awt.Dimension(1280, 720));

        titleLabel.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setText("Menu");

        resumeGameButton.setText("Continue");
        resumeGameButton.setPreferredSize(new java.awt.Dimension(100, 50));
        resumeGameButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resumeGameButtonActionPerformed(evt);
            }
        });

        leaveToMenuButton.setText("Leave Game");
        leaveToMenuButton.setPreferredSize(new java.awt.Dimension(100, 50));
        leaveToMenuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leaveToMenuButtonActionPerformed(evt);
            }
        });

        exitButton.setText("Exit");
        exitButton.setPreferredSize(new java.awt.Dimension(100, 50));
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        achievementsButton.setText("Achievements");
        achievementsButton.setPreferredSize(new java.awt.Dimension(100, 50));
        achievementsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                achievementsButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(titleLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(572, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(resumeGameButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(leaveToMenuButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(achievementsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(568, 568, 568))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addComponent(titleLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                .addComponent(resumeGameButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73)
                .addComponent(achievementsButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(79, 79, 79)
                .addComponent(leaveToMenuButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69)
                .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void resumeGameButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resumeGameButtonActionPerformed
        window.getGameModel().getTimeSimulation().NormalTime();
        window.switchToGameField(this);
    }//GEN-LAST:event_resumeGameButtonActionPerformed

    private void leaveToMenuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_leaveToMenuButtonActionPerformed
        try {
            window.saveGame();
            window.switchToMenu(this);
            window.reset();
        } catch (IOException | SQLException ex) {
            Logger.getLogger(GameMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_leaveToMenuButtonActionPerformed

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        try {
            window.saveGame();
            window.switchToExit(this);
        } catch (IOException | SQLException ex) {
            Logger.getLogger(GameMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_exitButtonActionPerformed

    private void achievementsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_achievementsButtonActionPerformed
        try {
            window.saveGame();
            window.switchToAchi(this);
        } catch (IOException | SQLException ex) {
            Logger.getLogger(GameMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_achievementsButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton achievementsButton;
    private javax.swing.JButton exitButton;
    private javax.swing.JButton leaveToMenuButton;
    private javax.swing.JButton resumeGameButton;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}

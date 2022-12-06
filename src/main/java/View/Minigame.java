/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View;

import ViewModel.MinigameVM;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.WindowConstants;
import static rxjava_mvvm.RxSwingView2ViewModelBinder.bindSwingView;

/**
 *
 * @author Marton
 */
public class Minigame extends javax.swing.JPanel {
    private boolean started;
    public static ArrayList<JButton> randomize;
    private Timer timer;
    private int buttonCounter;
    private int clicks;
    private final MainWindow window;
    /**
     * Creates new form Minigame
     */
    public Minigame(MainWindow window) {
        this.window = window;
        started = false;
        randomize = new ArrayList<>();
        buttonCounter = 0;
        clicks=0;
        initComponents();
        MinigameVM viewModel = new MinigameVM(window.getGameModel());
        bind(viewModel);
    }
    public void bind(final MinigameVM viewModel) {
        bindSwingView(startLights).toViewModel(viewModel.v2vm_startButtonEvents);
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
        infoLabel = new javax.swing.JLabel();
        light1 = new javax.swing.JButton();
        light2 = new javax.swing.JButton();
        light3 = new javax.swing.JButton();
        light4 = new javax.swing.JButton();
        light5 = new javax.swing.JButton();
        light6 = new javax.swing.JButton();
        instructionLabel = new javax.swing.JLabel();
        backToRW = new javax.swing.JButton();
        startLights = new javax.swing.JButton();

        titleLabel.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setText("Memory ");

        infoLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        infoLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        infoLabel.setText("Complete the following memory game to increase your development");

        light1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                light1ActionPerformed(evt);
            }
        });

        light2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                light2ActionPerformed(evt);
            }
        });

        light3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                light3ActionPerformed(evt);
            }
        });

        light4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                light4ActionPerformed(evt);
            }
        });

        light5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                light5ActionPerformed(evt);
            }
        });

        light6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                light6ActionPerformed(evt);
            }
        });

        instructionLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        instructionLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        instructionLabel.setText("Watch the lights and click on the buttons in order");

        backToRW.setText("Back");
        backToRW.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backToRWActionPerformed(evt);
            }
        });

        startLights.setText("Start");
        startLights.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startLightsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(372, 372, 372)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(light4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(light1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(91, 91, 91)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(light2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(light5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(94, 94, 94)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(light6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(light3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(363, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(startLights, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(422, 422, 422)
                        .addComponent(backToRW, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(titleLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(infoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(instructionLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(infoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(instructionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(light2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(light3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                    .addComponent(light1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(light6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(light5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(light4, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(backToRW, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(startLights, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void light2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_light2ActionPerformed
        if(started)
        {
            if(clicks == randomize.indexOf(light2))
            {
                light2.setBackground(Color.GREEN);
                light2.setEnabled(false);
                clicks++;
                win(light2);
            }
            else
            {
                light2.setBackground(Color.RED);
                defeat();
            }
        }
    }//GEN-LAST:event_light2ActionPerformed

    private void backToRWActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backToRWActionPerformed
        try {
            window.getGameModel().setUpgradeChanceVisibility(false);
            if(clicks == 6)
                window.getGameModel().setUpgradeChance(true);
            window.switchToRaceWeekend(this);
        } catch (IOException ex) {
            Logger.getLogger(Minigame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_backToRWActionPerformed

    private void startLightsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startLightsActionPerformed
        started=true;
        randomize.add(light1);
        randomize.add(light2);
        randomize.add(light3);
        randomize.add(light4);
        randomize.add(light5);
        randomize.add(light6);
        Minigame.backToRW.setVisible(false);
        Minigame.startLights.setVisible(false);
        Minigame.light1.setEnabled(false);
        Minigame.light2.setEnabled(false);
        Minigame.light3.setEnabled(false);
        Minigame.light4.setEnabled(false);
        Minigame.light5.setEnabled(false);
        Minigame.light6.setEnabled(false);
    }//GEN-LAST:event_startLightsActionPerformed

    private void light1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_light1ActionPerformed
        if(started)
        {
            if(clicks == randomize.indexOf(light1))
            {
                light1.setBackground(Color.GREEN);
                light1.setEnabled(false);
                clicks++;
                win(light1);
            }
            else
            {
                light1.setBackground(Color.RED);
                defeat();
            }
        }
    }//GEN-LAST:event_light1ActionPerformed

    private void light3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_light3ActionPerformed
        if(started)
        {
            if(clicks == randomize.indexOf(light3))
            {
                light3.setBackground(Color.GREEN);
                light3.setEnabled(false);
                clicks++;
                win(light3);
            }
            else
            {
                light3.setBackground(Color.RED);
                defeat();
            }
        }
    }//GEN-LAST:event_light3ActionPerformed

    private void light4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_light4ActionPerformed
        if(started)
        {
            if(clicks == randomize.indexOf(light4))
            {
                light4.setBackground(Color.GREEN);
                light4.setEnabled(false);
                clicks++;
                win(light4);
            }
            else
            {
                light4.setBackground(Color.RED);
                defeat();
            }
        }
    }//GEN-LAST:event_light4ActionPerformed

    private void light5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_light5ActionPerformed
        if(started)
        {
            if(clicks == randomize.indexOf(light5))
            {
                light5.setBackground(Color.GREEN);
                light5.setEnabled(false);
                clicks++;
                win(light5);
            }
            else
            {
                light5.setBackground(Color.RED);
                defeat();
            }
        }
    }//GEN-LAST:event_light5ActionPerformed

    private void light6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_light6ActionPerformed
        if(started)
        {
            if(clicks == randomize.indexOf(light6))
            {
                light6.setBackground(Color.GREEN);
                light6.setEnabled(false);
                clicks++;
                win(light6);
            }
            else
            {
                light6.setBackground(Color.RED);
                defeat();
            }
        }
    }//GEN-LAST:event_light6ActionPerformed

    
    public void win(JButton button)
    {
        if(randomize.indexOf(button) == 5)
        {
            String[] buttons = { "Ok" };
            int choice = JOptionPane.showOptionDialog(null, "Congratulations, you win!",
            "Back to Raceweek",
            JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, buttons, buttons[0]);
            switch(choice)
            {
                case 0: 
                {
                    try 
                    {
                        window.getGameModel().setUpgradeChanceVisibility(false);
                        window.getGameModel().setUpgradeChance(true);
                        window.switchToRaceWeekend(this);
                    } 
                    catch (IOException ex) 
                    {
                        Logger.getLogger(GameField.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                    break;
                default:
            }
            light1.setEnabled(false);
            light2.setEnabled(false);
            light3.setEnabled(false);
            light4.setEnabled(false);
            light5.setEnabled(false);
            light6.setEnabled(false);
            backToRW.setVisible(true);
        }
    }
    
    public void defeat()
    {
        light1.setEnabled(false);
        light2.setEnabled(false);
        light3.setEnabled(false);
        light4.setEnabled(false);
        light5.setEnabled(false);
        light6.setEnabled(false);
        backToRW.setVisible(true);
        String[] buttons = { "Ok" };
        int choice = JOptionPane.showOptionDialog(null, "Fail, good luck next time!",
        "Back to Raceweek",
        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, buttons, buttons[0]);
        switch(choice)
        {
            case 0: 
            {
                try 
                {
                    window.getGameModel().setUpgradeChanceVisibility(false);
                    window.switchToRaceWeekend(this);
                } 
                catch (IOException ex) 
                {
                    Logger.getLogger(GameField.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                break;
            default:
        }
    }
 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton backToRW;
    private javax.swing.JLabel infoLabel;
    private javax.swing.JLabel instructionLabel;
    public static javax.swing.JButton light1;
    public static javax.swing.JButton light2;
    public static javax.swing.JButton light3;
    public static javax.swing.JButton light4;
    public static javax.swing.JButton light5;
    public static javax.swing.JButton light6;
    public static javax.swing.JButton startLights;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}

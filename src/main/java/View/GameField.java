/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View;

import Model.Buildings;
import Model.GameModel;
import Model.Unit;
import Source.Constructor;
import Source.Images;
import java.awt.Point;
import java.io.IOException;
import static java.lang.String.valueOf;
import java.time.LocalTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Marton
 */
public class GameField extends JPanel {
    private final MainWindow window;
    private GameModel gameModel;
    private int value;

    public MainWindow getWindow() {
        return window;
    }
    /**
     * Creates new form GameField
     */
    public GameField(final MainWindow window) {
    this.window = window;
    initComponents();
    valuePrinter();
    cancelPurchaseButton.setVisible(false);
    playerNameLabel.setText("Name: " + window.getPlayerName());
    constructorLabel.setText("Constructor: " + window.getConstructor());
    }
    
    public void setGameModel(GameModel gameModel){
        this.gameModel = gameModel;
        value = gameModel.getMoney();
    }
    
    public void valuePrinter(){
        moneyLabel.setText("Money: " + value + "$");
    }
    
    public void setValue(int value) {
        this.value = value;
    }
    
    public void winPrinter()
    {
        winCounterLabel.setText("Wins: " + gameModel.getWins());
    }
    
    public void dailyIncomeFromBuildings(){
        int commission = 0;
        for(Buildings b : gameModel.getAlreadyBuiltList())
        {
            if("path".equals(b.getType()))
            {
                commission = commission + 50;
            }
            else
            {
                commission = commission + 500;
            }
        }
        value = gameModel.getWins()*5000 + gameModel.getGpCounter()*500 + 10000 - commission;
        gameModel.setMoney(value);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gameArea1 = new View.GameArea();
        shopButton = new javax.swing.JButton();
        simulationButton = new javax.swing.JButton();
        cancelPurchaseButton = new javax.swing.JButton();
        pauseGameButton = new javax.swing.JButton();
        playerNameLabel = new javax.swing.JLabel();
        moneyLabel = new javax.swing.JLabel();
        constructorLabel = new javax.swing.JLabel();
        timeLabel = new javax.swing.JLabel();
        winCounterLabel = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1280, 720));

        gameArea1.refresh(window.getGameModel());

        javax.swing.GroupLayout gameArea1Layout = new javax.swing.GroupLayout(gameArea1);
        gameArea1.setLayout(gameArea1Layout);
        gameArea1Layout.setHorizontalGroup(
            gameArea1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1280, Short.MAX_VALUE)
        );
        gameArea1Layout.setVerticalGroup(
            gameArea1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 640, Short.MAX_VALUE)
        );

        shopButton.setText("R&D");
        shopButton.setPreferredSize(new java.awt.Dimension(100, 50));
        shopButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shopButtonActionPerformed(evt);
            }
        });

        simulationButton.setText("RaceWeek");
        simulationButton.setMaximumSize(new java.awt.Dimension(100, 50));
        simulationButton.setPreferredSize(new java.awt.Dimension(100, 50));
        simulationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simulationButtonActionPerformed(evt);
            }
        });

        cancelPurchaseButton.setText("Cancel");
        cancelPurchaseButton.setPreferredSize(new java.awt.Dimension(100, 50));
        cancelPurchaseButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cancelPurchaseButtonMousePressed(evt);
            }
        });
        cancelPurchaseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelPurchaseButtonActionPerformed(evt);
            }
        });

        pauseGameButton.setText("Pause");
        pauseGameButton.setPreferredSize(new java.awt.Dimension(100, 50));
        pauseGameButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pauseGameButtonActionPerformed(evt);
            }
        });

        playerNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        playerNameLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        moneyLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        moneyLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        constructorLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        winCounterLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        winCounterLabel.setText("Wins: 0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(gameArea1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(shopButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addComponent(simulationButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(cancelPurchaseButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(115, 115, 115)
                .addComponent(timeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(playerNameLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(moneyLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(constructorLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                    .addComponent(winCounterLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(pauseGameButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(gameArea1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(timeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(shopButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(simulationButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(pauseGameButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cancelPurchaseButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(playerNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(constructorLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(moneyLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                            .addComponent(winCounterLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void shopButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_shopButtonActionPerformed
        try {
            gameModel.getTimeSimulation().StopTime();
            window.switchToRandD(this);
        } catch (IOException ex) {
            Logger.getLogger(GameField.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_shopButtonActionPerformed

    private void simulationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simulationButtonActionPerformed
    String[] buttons = { "Back", "Start" };
        int choice = JOptionPane.showOptionDialog(null, "Do you want to start the race week now?\n 3 more days will be added to your time.",
        "Skip to race week",
        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, buttons, buttons[0]);
        switch(choice)
        {
            case 0: 
            {}
                break;
            case 1:
            {
                try {
                    gameModel.getTimeSimulation().StopTime();
                    window.switchToInter(this);
                    gameModel.getTimeSimulation().setDateTime(LocalTime.of(0, 0, 0));
                } catch (IOException ex) {
                    Logger.getLogger(GameField.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                break;
            default:
        }
    }//GEN-LAST:event_simulationButtonActionPerformed

    private void cancelPurchaseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelPurchaseButtonActionPerformed

    }//GEN-LAST:event_cancelPurchaseButtonActionPerformed

    private void pauseGameButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pauseGameButtonActionPerformed
        try {
            gameModel.getTimeSimulation().StopTime();
            window.switchToPause(this);
        } catch (IOException ex) {
            Logger.getLogger(GameField.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_pauseGameButtonActionPerformed

    private void cancelPurchaseButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelPurchaseButtonMousePressed
        gameModel.setNewBuildingCancel();
    }//GEN-LAST:event_cancelPurchaseButtonMousePressed

    public void setBuyingCancelBtn(boolean b) {
        cancelPurchaseButton.setVisible(b);
    }
    
    public void dateEventsAndPrinter(String date) throws IOException{
        if("05:00".equals(date.split("nap, ")[1])){
            gameModel.changeTexture("morning");
        }
        if("15:00".equals(date.split("nap, ")[1])){
            gameModel.changeTexture("sunset");
        }
        if("22:00".equals(date.split("nap, ")[1])){
            gameModel.changeTexture("midnight");
            dailyIncomeFromBuildings();
        }
        if(Integer.valueOf(date.split(". nap,")[0]) % 3 == 0 && "00:00".equals(date.split("nap, ")[1]))
        {
        String[] buttons = { "Start" };
            int choice = JOptionPane.showOptionDialog(null, "You are going to be transfered to the Race Week.",
            "Time To Race",
            JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, buttons, buttons[0]);
            switch(choice)
            {
                case 0: 
                {
                    try 
                    {
                        gameModel.getTimeSimulation().StopTime();
                        gameModel.getTimeSimulation().setDateTime(LocalTime.of(0, 0, 0));
                        gameModel.getTimeSimulation().setDaysPassed((gameModel.getGpCounter()*3)+1);
                        window.switchToInter(this);
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
        timeLabel.setText(date);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelPurchaseButton;
    private javax.swing.JLabel constructorLabel;
    private View.GameArea gameArea1;
    private javax.swing.JLabel moneyLabel;
    private javax.swing.JButton pauseGameButton;
    private javax.swing.JLabel playerNameLabel;
    private javax.swing.JButton shopButton;
    private javax.swing.JButton simulationButton;
    private javax.swing.JLabel timeLabel;
    private javax.swing.JLabel winCounterLabel;
    // End of variables declaration//GEN-END:variables
}

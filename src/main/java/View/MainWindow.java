/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Model.GameModel;
import Source.Constructor;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedWriter;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author Marton
 */
public class MainWindow extends JFrame{
        private final JFrame mainWindow;
        private Menu menuPanel;
        private NewGame newGamePanel;
        private Dashboard dashboardPanel;
        private Tutorial tutorialPanel;
        private ResourceAndDevelopment randDPanel;
        private Paddock paddockPanel;
        private RaceWeekend raceWeekendPanel;
        private String playerName;
        private GameField gamefieldPanel;
        private Constructor constructor;
        private GameModel gameModel; 
        
    

public MainWindow()
{
        mainWindow = new JFrame("FormulaOne - Manager");
        mainWindow.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        mainWindow.setSize(800,600);
        mainWindow.setResizable(false);
        mainWindow.setLocationRelativeTo(null);
        menuPanel = new Menu(this);
        mainWindow.getContentPane().add(menuPanel);
        mainWindow.pack();
        mainWindow.setVisible(true);
        
        WindowListener exitListener = new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int confirm = JOptionPane.showOptionDialog(
                     null, "Are You Sure to Close Application?", 
                     "Exit Confirmation", JOptionPane.YES_NO_OPTION, 
                     JOptionPane.QUESTION_MESSAGE, null, null, null);
                if (confirm == 0) {
                    JPanel p = new JPanel();
                    try {
                        switchToExit(p);
                    } catch (IOException ex) {
                        Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        };
        mainWindow.addWindowListener(exitListener);
        gameModel = new GameModel(64, 32);
    };

    public void switchToExit(JPanel p) throws IOException
        {
            System.exit(0);
        }
    
    public void switchToNewGame(JPanel p) throws IOException
        {
            mainWindow.remove(p);
            newGamePanel = new NewGame(this);
            mainWindow.getContentPane().add(newGamePanel);
            mainWindow.pack();
            mainWindow.setVisible(true);
        }
    
    
    public void switchToTutorial(JPanel p) throws IOException
        {
            mainWindow.remove(p);
            tutorialPanel = new Tutorial(this);
            mainWindow.getContentPane().add(tutorialPanel);
            mainWindow.pack();
            mainWindow.setVisible(true);
        }
    
    public void switchToDashboard(JPanel p) throws IOException
        {
            mainWindow.remove(p);
            dashboardPanel = new Dashboard(this);
            mainWindow.getContentPane().add(dashboardPanel);
            mainWindow.pack();
            mainWindow.setVisible(true);
        }

    public void switchToRandD(JPanel p) throws IOException
        {
            mainWindow.remove(p);
            randDPanel = new ResourceAndDevelopment(this);
            mainWindow.getContentPane().add(randDPanel);
            mainWindow.pack();
            mainWindow.setVisible(true);
        }
    public void switchToPaddock(JPanel p) throws IOException
        {
            mainWindow.remove(p);
            paddockPanel = new Paddock(this);
            mainWindow.getContentPane().add(paddockPanel);
            mainWindow.pack();
            mainWindow.setVisible(true);
        }
    public void switchToRaceWeekend(JPanel p) throws IOException
        {
            mainWindow.remove(p);
            raceWeekendPanel = new RaceWeekend(this);
            mainWindow.getContentPane().add(raceWeekendPanel);
            mainWindow.pack();
            mainWindow.setVisible(true);
        }
    
    public void switchToGameField(JPanel p){
        mainWindow.remove(p);
        gamefieldPanel = new GameField(this);
        gameModel.setGameField(gamefieldPanel);
        mainWindow.getContentPane().add(gamefieldPanel);
        mainWindow.pack();
        mainWindow.setVisible(true);
    }
    
    public GameModel getGameModel() {
        return gameModel;
    }
    
    public Constructor getConstructor() {
        return constructor;
    }

    public void setConstructor(Constructor constructor) {
        this.constructor = constructor;
    }
    
    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
}
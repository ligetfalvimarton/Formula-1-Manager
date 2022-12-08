/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Model.DatabaseConnection;
import Model.GameModel;
import Model.Constructor;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.io.IOException;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
/**
 *
 * @author Marton
 */
public class MainWindow extends JFrame{
        private final JFrame mainWindow;
        private Menu menuPanel;
        private NewGame newGamePanel;
        private Tutorial tutorialPanel;
        private ResourceAndDevelopment randDPanel;
        private RaceWeekend raceWeekendPanel;
        private String playerName;
        private GameField gamefieldPanel;
        private Constructor constructor;
        private GameModel gameModel;
        private GameMenu gameMenu;
        private Achievements achiPanel;
        private Interview interPanel;
        private Minigame miniGamePanel;
        private LoadGame loadGamePanel;
        private DatabaseConnection database;
        private int highscore;

public MainWindow() throws SQLException
{
        mainWindow = new JFrame("Formula- 1 -Manager");
        mainWindow.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        ImageIcon iM = new ImageIcon(Paths.get("").toAbsolutePath().toString() + "/src/main/java/Images/Logo.png");
        mainWindow.setIconImage(iM.getImage());
        mainWindow.setSize(1280,720);
        mainWindow.setResizable(true);
        database = new DatabaseConnection();
        mainWindow.setLocationRelativeTo(null);
        menuPanel = new Menu(this);
        mainWindow.getContentPane().add(menuPanel);
        mainWindow.pack();
        mainWindow.setVisible(true);
        highscore = 0;
        
        WindowListener exitListener = new WindowAdapter() 
        {
            @Override
            public void windowClosing(WindowEvent e) 
            {
                int confirm = JOptionPane.showOptionDialog(
                     null, "Colse the game?", 
                     "Exit", JOptionPane.YES_NO_OPTION, 
                     JOptionPane.QUESTION_MESSAGE, null, null, null);
                if(confirm == 0) 
                {
                    JPanel p = new JPanel();
                    try {
                            if(playerName != null)
                            {
                                saveGame();
                            }
                        switchToExit(p);
                    } catch (IOException | SQLException ex) {
                        Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        };
        
        
        mainWindow.addWindowListener(exitListener);  
        gameModel = new GameModel(75000,64, 32);
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

    public void switchToPause(JPanel p) throws IOException
    {
        mainWindow.remove(p);
        gameMenu = new GameMenu(this);
        mainWindow.getContentPane().add(gameMenu);
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
 
    public void switchToRandD(JPanel p) throws IOException
    {
        mainWindow.remove(p);
        randDPanel = new ResourceAndDevelopment(this);
        mainWindow.getContentPane().add(randDPanel);
        mainWindow.pack();
        mainWindow.setVisible(true);
    }
    public void switchToAchi(JPanel p) throws IOException
    {
        mainWindow.remove(p);
        achiPanel = new Achievements(this);
        mainWindow.getContentPane().add(achiPanel);
        mainWindow.pack();
        mainWindow.setVisible(true);
    }
    public void switchToMiniGame(JPanel p) throws IOException
    {
        mainWindow.remove(p);
        miniGamePanel = new Minigame(this);
        mainWindow.getContentPane().add(miniGamePanel);
        mainWindow.pack();
        mainWindow.setVisible(true);
    }
    public void switchToLoadGame(JPanel p) throws IOException, SQLException
    {
        mainWindow.remove(p);
        loadGamePanel = new LoadGame(this);
        mainWindow.getContentPane().add(loadGamePanel);
        mainWindow.pack();
        mainWindow.setVisible(true);
    }
    public void switchToInter(JPanel p) throws IOException
    {
        mainWindow.remove(p);
        interPanel = new Interview(this);
        mainWindow.getContentPane().add(interPanel);
        mainWindow.pack();
        mainWindow.setVisible(true);
    }
    public void switchToRaceWeekend(JPanel p) throws IOException
    {
        mainWindow.remove(p);
        raceWeekendPanel = new RaceWeekend(this);
        raceWeekendPanel.setGameModel(gameModel);
        mainWindow.getContentPane().add(raceWeekendPanel);
        mainWindow.pack();
        mainWindow.setVisible(true);
    }
    public void switchToMenu(JPanel p) throws IOException
    {
        mainWindow.remove(p);
        menuPanel = new Menu(this);
        mainWindow.getContentPane().add(menuPanel);
        mainWindow.pack();
        mainWindow.setVisible(true);
    }
    public void switchToGameField(JPanel p)
    {
        mainWindow.remove(p);
        gamefieldPanel = new GameField(this);
        gameModel.getTimeSimulation().setGameField(gamefieldPanel);
        gamefieldPanel.setGameModel(gameModel);
        gameModel.setGameField(gamefieldPanel);
        mainWindow.getContentPane().add(gamefieldPanel);
        mainWindow.pack();
        mainWindow.setVisible(true);
    }

    public void reset(){
        gameModel = new GameModel(75000, 64, 32);
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

    public DatabaseConnection getDatabase() {
        return database;
    }

    public void setDatabase(DatabaseConnection database) {
        this.database = database;
    }
    
    public void saveGame() throws SQLException
    {
        if(gameModel.getWins() == 0)
        {
            highscore = gameModel.getMoney()+gameModel.getGpCounter()*gameModel.getTimeSimulation().getDaysPassed();
        }
        else
        {
            highscore = gameModel.getMoney()+gameModel.getGpCounter()*gameModel.getTimeSimulation().getDaysPassed()*gameModel.getWins();
        }
        String tmp = "[]".equals(gameModel.getValues().toString()) ? "[10,10,10,10,10,10]" : gameModel.getValues().toString();
        String board = "";
        for(int i =0;i<gameModel.getAlreadyBuiltList().size();i++)
        {
            board = board + gameModel.getAlreadyBuiltList().get(i).getPosition().x +"," 
                    + gameModel.getAlreadyBuiltList().get(i).getPosition().y +"," 
                    + gameModel.getAlreadyBuiltList().get(i).getType()+"," 
                    + gameModel.getAlreadyBuiltList().get(i).getSizeX()+","
                    + gameModel.getAlreadyBuiltList().get(i).getSizeY()+","
                    + " ";
        }
        database.saveDatas(playerName, highscore,gameModel.getWins(),gameModel.getMoney(),constructor.toString(),gameModel.getTimeSimulation().getDaysPassed(),tmp,board);
    }
}
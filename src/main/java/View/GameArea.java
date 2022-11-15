/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Model.Buildings;
import Model.GameModel;
import Model.Unit;
import Source.Images;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * @author Marton
 */
public class GameArea extends JPanel{
    public Unit[][] board;
    private GameModel gameModel;
    private List<Unit> selected;
    
    public GameArea() {
        selected = new ArrayList<>();
        MouseAdapter adapter = new MouseAdapter() {
            public void mouseMoved(MouseEvent e) {
                boolean usable = true;
                boolean connected = false;
                selected.clear();
                gameModel.setSelectedAreaClear(true);
                if(gameModel.getNewBuilding() != null)
                {
                    gameModel.getGameField().setBuyingCancelBtn(true);
                    int sizeX = gameModel.getNewBuilding().getItem().getSizeX();
                    int sizeY = gameModel.getNewBuilding().getItem().getSizeY();
                    int MouseCoordX = e.getX() / 20;
                    int MouseCoordY = e.getY() / 20;

                    if(MouseCoordY+sizeY>32 || MouseCoordX+sizeX>64)
                    {
                        usable = false;
                    }
                    
                    for(int i=MouseCoordY; i<MouseCoordY+sizeY && i<board.length;i++){
                        for(int j=MouseCoordX; j<MouseCoordX+sizeX && j<board[0].length; j++){
                            if(connectedToRoad(i, j)){
                                connected = true;
                            }
                            if(!board[i][j].isUsable()){
                                usable = false;
                            }
                        }
                    }
                    
                    if(connected && usable)
                    {
                            if(gameModel.getNewBuilding().getItem().getType() != "grass")
                            {
                                for(int i=MouseCoordY; i<MouseCoordY+sizeY && i<board.length;i++){
                                    for(int j=MouseCoordX; j<MouseCoordX+sizeX && j<board[0].length; j++){
                                        selected.add(new Unit(new Point(j,i),true,"selected", Images.CORRECTPLACE));
                                    }
                                }
                            }else{
                                for(int i=MouseCoordY; i<MouseCoordY+sizeY && i<board.length;i++){
                                    for(int j=MouseCoordX; j<MouseCoordX+sizeX && j<board[0].length; j++){
                                        selected.add(new Unit(new Point(j,i),true,"selected", Images.INCORRECTPLACE));
                                        gameModel.setSelectedAreaClear(false);
                                    }
                                }
                            }
                        } 
                    else {
                            for(int i=MouseCoordY; i<MouseCoordY+sizeY && i<board.length;i++){
                                for(int j=MouseCoordX; j<MouseCoordX+sizeX && j<board[0].length; j++){
                                    selected.add(new Unit(new Point(j,i),true,"selected", Images.INCORRECTPLACE));
                                    gameModel.setSelectedAreaClear(false);
                                }
                            }
                        }
                }
                else
                {
                    gameModel.getGameField().setBuyingCancelBtn(false);
                }
            }
            
          @Override
            public void mouseClicked(MouseEvent e) {
                int x = e.getX() / 20;
                int y = e.getY() / 20;
                System.out.println(x + " " + y);
                System.out.println(board[y][x].getType());
                gameModel.setChosenPoint(new Point(x, y));
                if(gameModel.getNewBuilding() != null)
                {
                    gameModel.placeNewBuilding();
                }
                if(selected.isEmpty())
                {
                    ArrayList<Buildings> built = gameModel.getAlreadyBuiltList();
                    for(int i=0; i<built.size(); i++){
                        Buildings building = built.get(i);
                        if(building.getPosition().y <= x && building.getPosition().y+building.getSizeX() > x && building.getPosition().x <= y && building.getPosition().x+building.getSizeY() > y)
                        {
                            String[] buttons = { "Upgrade", "Destroy" };
                            if(gameModel.getBuildingStatus()){
                                int choice = JOptionPane.showOptionDialog(null, "Name: " + building.getType() + "\n" + "Level: " + building.getLevel() + "\n",
                                "Details",
                                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, buttons, buttons[0]);
                                switch(choice)
                                {
                                    case 0: 
                                        gameModel.upgradeBuilding(building);
                                        break;
                                    case 1:
                                        gameModel.destroyBuilding(building);
                                        break;
                                    default:
                                }
                            }
                            else{
                                JOptionPane.showOptionDialog(null, "Level: " + building.getLevel() + "\n",
                                "Details", JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE, null, new Object[]{}, null);
                            }
                        }
                    }
                }
                selected.clear();
            }
        };
        addMouseMotionListener(adapter);
        addMouseListener(adapter);
    }
    
    public GameArea(Unit[][] board){
        setPreferredSize(new java.awt.Dimension(1280,720));
        this.board = board;
    }
    public void refresh(GameModel gameModel){
        this.gameModel = gameModel;
        this.board = gameModel.getBoard();
    }
    
    private boolean connectedToRoad(int i, int j) 
    {
        boolean connect = false;
        if (i + 1 < 32 && board[i + 1][j].getType() != "grass"
            || i - 1 >= 0 && board[i - 1][j].getType() != "grass"
            || j + 1 < 64 && board[i][j + 1].getType() != "grass"
            || j - 1 >= 0 && board[i][j - 1].getType() != "grass") 
        {
            connect = true;
        }
        return connect;
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                g.drawImage(board[i][j].getImage().getImage(), board[i][j].getPosition().y*20, board[i][j].getPosition().x*20, null);
            }
        }
        for(Unit u:selected){
            g.drawImage(u.getImage().getImage(), u.getPosition().x*20, u.getPosition().y*20, null);
        }
        repaint();
    }
}

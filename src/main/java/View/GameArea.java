/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

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
 *
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
                selected.clear();
                gameModel.setSelectedAreaClear(true);
                if(gameModel.getNewBuilding() != null)
                {
                    int sizeX = gameModel.getNewBuilding().getItem().getSizeX();
                    int sizeY = gameModel.getNewBuilding().getItem().getSizeY();
                    int MouseCoordX = e.getX() / 20;
                    int MouseCoordY = e.getY() / 20;

                    if(MouseCoordY+sizeY>32 || MouseCoordX+sizeX>64){
                            usable = false;
                        }
                    if(usable){
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
            }
            
          @Override
            public void mouseClicked(MouseEvent e) {
                int x = e.getX() / 20;
                int y = e.getY() / 20;
                System.out.println(x + " " + y);
                gameModel.setChosenPoint(new Point(x, y));
                gameModel.drawNewBuilding();
                refresh(gameModel);
                selected.clear();
            }
        };
        addMouseMotionListener(adapter);
        addMouseListener(adapter);
    }
    
    public GameArea(Unit[][] board){
            setPreferredSize(new java.awt.Dimension(800,600));
        this.board = board;
    }
    public void refresh(GameModel gameModel){
        this.gameModel = gameModel;
        this.board = gameModel.getBoard();
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

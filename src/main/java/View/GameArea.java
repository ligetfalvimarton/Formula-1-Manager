/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Model.GameModel;
import Model.Unit;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
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
          @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println(e.getX() + " " + e.getY() + "\n");
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
        repaint();
    }
}

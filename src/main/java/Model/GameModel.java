/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Source.Images;
import Source.UnitType;
import View.GameField;
import java.awt.Image;
import java.awt.Point;
import javax.swing.ImageIcon;

/**
 *
 * @author Marton
 */
public class GameModel {
    private Unit[][] board;
    private UnitType newBuilding;
    private Point chosenPoint;
    private GameField gameField;
    private boolean selectedAreaClear = true;
    
    public GameModel(int boardRow,int boardColumn) {
        board = new Unit[boardColumn][boardRow];
        startingboard();
        board[10][30] = new Unit(new Point(10,30), true, "grass", Images.INCORRECTPLACE);
    }

    private void startingboard() {
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                board[i][j] = new Unit(new Point(i,j), true, "grass", Images.GRASS);
            }
        }
    }
    
    public void drawNewBuilding(){
        if(newBuilding != null && selectedAreaClear){
            Buildings temp;
            int tempSizeX;
            int tempSizeY;
            temp = new Buildings(newBuilding.getItem().getBuildPrice(), newBuilding.getItem().getUpgradeCost(),
                    newBuilding.getItem().getSizeX(), newBuilding.getItem().getSizeY(), chosenPoint,
                    newBuilding.getItem().isUsable(), newBuilding.getItem().getType(), newBuilding.getItem().getImage());
            tempSizeX = temp.getSizeX();
            tempSizeY = temp.getSizeY();
            Point tempP = new Point(chosenPoint.y,chosenPoint.x);
            chosenPoint = tempP;
            temp.setPosition(chosenPoint);
            if(chosenPoint.x+tempSizeY <= board.length && chosenPoint.y+tempSizeX <= board[0].length){
                for(int i=chosenPoint.x; i<chosenPoint.x+tempSizeY; i++){
                    for(int j=chosenPoint.y; j<chosenPoint.y+tempSizeX; j++){
                        board[i][j].setImage(temp.getImage());
                        board[i][j].setPosition(temp.getPosition());
                        board[i][j].setType(temp.getType());
                        board[i][j].setUsable(temp.isUsable());
                    }
                }
            }
        }
    }
    
    public UnitType getNewBuilding() {
        return newBuilding;
    }

    public void setNewBuilding(UnitType newBuilding) {
        this.newBuilding = newBuilding;
    }

    public Point getChosenPoint() {
        return chosenPoint;
    }

    public void setChosenPoint(Point chosenPoint) {
        this.chosenPoint = chosenPoint;
    }

    public Unit[][] getBoard() {
        return board;
    }
    
    public void setBoard(Unit[][] board) {
        this.board = board;
    }
    
     public void setGameField(GameField gameField) {
        this.gameField = gameField;
    }
     
    public GameField getGameField() {
        return gameField;
    }
    
    public boolean isSelectedAreaClear() {
        return selectedAreaClear;
    }

    public void setSelectedAreaClear(boolean selectedAreaClear) {
        this.selectedAreaClear = selectedAreaClear;
    }
}

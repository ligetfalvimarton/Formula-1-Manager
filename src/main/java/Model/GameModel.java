/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import View.GameField;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Marton
 */
public class GameModel 
{
    private Unit[][] board;
    private UnitType newBuilding;
    private Point chosenPoint;
    private GameField gameField;
    private int money;
    private int developmentPoints;
    private int workerPoints;
    private ArrayList<Integer> values;
    private boolean selectedAreaClear = true;
    private boolean upgradeChance = false;
    private boolean upgradeChanceVisibility = true;
    private TimeSimulation timeSimulation;
    private boolean buildingStatus = true;
    private ArrayList<Buildings> alreadyBuiltList;
    private int wins;
    private int gpCounter;
    
    public GameModel(int money,int boardRow,int boardColumn){
        board = new Unit[boardColumn][boardRow];
        this.money = money;
        timeSimulation = new TimeSimulation();
        alreadyBuiltList = new ArrayList<>();
        values = new ArrayList<>();
        developmentPoints = 4;
        workerPoints = 4;
        wins = 0;
        gpCounter = 0;
        startingBoard();
    }
    
    public void placeNewBuilding(){
        if(newBuilding != null && selectedAreaClear){
            if(newBuilding.getItem().getBuildPrice() <= money)
            {
                Buildings temp;
                int tempSizeX;
                int tempSizeY;
                temp = new Buildings(newBuilding.getItem().getBuildPrice(), newBuilding.getItem().getUpgradeCost(),
                        newBuilding.getItem().getDevelopment(), newBuilding.getItem().getWorkers(),
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
                            board[i][j] = new Unit(new Point(temp.getPosition()), temp.isUsable(), temp.getType(), temp.getImage());
                        }
                    }
                }
                money = money - temp.getBuildPrice();
                gameField.setValue(money);
                developmentPoints = developmentPoints + temp.getDevelopment();
                workerPoints = workerPoints + temp.getWorkers();
                alreadyBuiltList.add(temp);
            }
        }
        if(!(newBuilding.equals(UnitType.PATH)))
        {
            setNewBuildingCancel();
        }
    }
    
    public void destroyBuilding(Buildings current)
    {
        if(buildingStatus)
        {
            int x = current.getPosition().x;
            int y = current.getPosition().y;
            int sizeX = current.getSizeX();
            int sizeY = current.getSizeY();
            for(int i= x; i< x+sizeY; i++){
                for(int j = y; j< y+sizeX; j++){
                    board[i][j] = new Unit(new Point(i,j), true, "grass", Images.GRASS);
                }
            }

            Buildings temp = null;
            for(Buildings building : alreadyBuiltList){
                if(building.getPosition().x <= x && building.getPosition().x+building.getSizeX() > x && 
                        building.getPosition().y <= y && building.getPosition().y+building.getSizeY() > y){
                    temp = building;
                }
            }
            if(temp != null)
            {
                money = money + temp.getBuildPrice()/2;
                if(gameField != null)
                    gameField.setValue(money);
                alreadyBuiltList.remove(temp);
            }
        }
    }
    
    public void upgradeBuilding(Buildings building)
    {
        if(buildingStatus)
        {
            if(building.getLevel()<3)
            {
                if(money - building.getUpgradeCost()>0)
                {
                    money = money - building.getUpgradeCost();
                    if(gameField != null)
                        gameField.setValue(money);
                    building.setUpgradeCost(building.getUpgradeCost()*2);
                    building.setLevel(building.getLevel()+1);
                }
            }
        }
    }
    
    private void startingBoard  () {
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if (j == 29 && i>=17 || j ==30 && i>=17)
                    board[i][j] = new Unit(new Point(i,j), false, "path", Images.PATH);
                else
                    board[i][j] = new Unit(new Point(i,j), true, "grass", Images.GRASS);
            }
        }
        Buildings temp;
        int tempSizeX;
        int tempSizeY;
        temp = new Buildings(0, 8500, 0, 0, 8, 8, new Point(0,0), false, "hq", Images.HQ);
        tempSizeX = temp.getSizeX();
        tempSizeY = temp.getSizeY();
        Point p = new Point(10,26);
        temp.setPosition(p);
        if(p.x+tempSizeX <= board.length && p.y+tempSizeY <= board[0].length){
            for(int i=p.x; i<p.x+tempSizeX; i++){
                for(int j=p.y; j<p.y+tempSizeY; j++){
                    board[i][j].setImage(temp.getImage());
                    board[i][j].setPosition(new Point(temp.getPosition()));
                    board[i][j].setType(temp.getType());
                    board[i][j].setUsable(temp.isUsable());
                }
            }
            alreadyBuiltList.add(temp);
        }
        temp = new Buildings(0, 0, 0, 0, 8, 8, new Point(0,0), false, "Track1", Images.TRACK1);
        tempSizeX = temp.getSizeX();
        tempSizeY = temp.getSizeY();
        p = new Point(24,0);
        temp.setPosition(p);
        if(p.x+tempSizeX <= board.length && p.y+tempSizeY <= board[0].length){
            for(int i=p.x; i<p.x+tempSizeX; i++){
                for(int j=p.y; j<p.y+tempSizeY; j++){
                    board[i][j].setImage(temp.getImage());
                    board[i][j].setPosition(new Point(temp.getPosition()));
                    board[i][j].setType(temp.getType());
                    board[i][j].setUsable(temp.isUsable());
                }
            }
            alreadyBuiltList.add(temp);
        }
    }

    public ArrayList<Integer> getValues() {
        return values;
    }

    public void setValues(ArrayList<Integer> values) {
        this.values = values;
    }
    
    public void changeTexture(String time)
    {
        if(time == "sunset")
        {
            for(int i=0; i<board.length; i++)
            {
                for(int j=0; j<board[0].length; j++){
                    if(board[i][j].isUsable() || board[i][j].getType() == "Bush" || board[i][j].getType() == "Tree")
                    {
                        if(board[i][j].getType() == "Bush")
                        {
                            board[i][j] = new Unit(new Point(i,j), false, "Bush", Images.BUSHSUNSET);
                        }
                        else if(board[i][j].getType() == "Tree")
                        {
                            board[i][j] = new Unit(new Point(i,j), false, "Tree", Images.TREESUNSET);
                        }
                        else
                        {
                            board[i][j] = new Unit(new Point(i,j), true, "grass", Images.GRASSSUNSET);
                        }
                    }
                }
            }
        }
        
        if(time == "midnight")
        {
            for(int i=0; i<board.length; i++)
            {
                for(int j=0; j<board[0].length; j++){
                    if(board[i][j].isUsable() || board[i][j].getType() == "Bush" || board[i][j].getType() == "Tree") 
                    {
                        if(board[i][j].getType() == "Bush")
                        {
                            board[i][j] = new Unit(new Point(i,j), false, "Bush", Images.BUSHMIDNIGHT);
                        }
                        else if(board[i][j].getType() == "Tree")
                        {
                            board[i][j] = new Unit(new Point(i,j), false, "Tree", Images.TREEMIDNIGHT);
                        }
                        else
                        {
                            board[i][j] = new Unit(new Point(i,j), true, "grass", Images.GRASSMIDNIGHT);
                        }
                    }
                }
            }
        }
        
        if(time == "morning")
        {
            for(int i=0; i<board.length; i++)
            {
                for(int j=0; j<board[0].length; j++){
                    if(board[i][j].isUsable() || board[i][j].getType() == "Bush" || board[i][j].getType() == "Tree")
                    {
                    
                        if(board[i][j].getType() == "Bush")
                        {
                            board[i][j] = new Unit(new Point(i,j), false, "Bush", Images.BUSH);
                        }
                        else if(board[i][j].getType() == "Tree")
                        {
                            board[i][j] = new Unit(new Point(i,j), false, "Tree", Images.TREE);
                        }
                        else
                        {
                            board[i][j] = new Unit(new Point(i,j), true, "grass", Images.GRASS);
                        }
                    }
                }
            }
        }
    }
    
    public ArrayList<Integer> startingStats(Constructor contructor)
    {
        if(values.isEmpty())
        {
            if(Constructor.FERRARI == contructor)
            {
                values.add(25);
                values.add(5);
                values.add(5);
                values.add(10);
                values.add(10);
                values.add(10);
            }
            if(Constructor.MERCEDES == contructor)
            {
                values.add(6);
                values.add(7);
                values.add(9);
                values.add(8);
                values.add(10);
                values.add(10);
            }
            if(Constructor.REDBULL == contructor)
            {
                values.add(15);
                values.add(5);
                values.add(15);
                values.add(5);
                values.add(10);
                values.add(10);
            }
        }
        return values;
    }

    public String raceWinnerCalculator()
    {
        Random rand = new Random();
        int numberOne = rand.nextInt(100);
        Random rand2 = new Random();
        int number2 = rand2.nextInt(7);
        int chance = 0;
        for(int i=0;i<values.size()-2;i++)
        {
            chance = chance + (values.get(i)/2);
        }
        chance = (100-chance)/10 == 0 ? 1 : (100-chance)/10;
        boolean win = numberOne%chance == 0;
        if(win)
        {
            return "finish_" + gameField.getWindow().getConstructor().toString().toLowerCase();
        }
        else
        {
            switch(number2)
            {
                case 0:
                    if("finish_ferrari".equals("finish_" + gameField.getWindow().getConstructor().toString().toLowerCase()))
                        return "finish_redbull";
                    else
                        return "finish_ferrari";
                case 1:
                    if("finish_redbull".equals("finish_" + gameField.getWindow().getConstructor().toString().toLowerCase()))
                        return "finish_mercedes";
                    else
                        return "finish_redbull";
                case 2:
                    if("finish_mercedes".equals("finish_" + gameField.getWindow().getConstructor().toString().toLowerCase()))
                        return "finish_ferrari";
                    else
                        return "finish_mercedes";
                case 3:
                    return "finish_alpin";
                case 4:
                    return "finish_aston";
                case 5:
                    return "finish_haas";
                case 6:
                    return "finish_mclaren";
                case 7:
                    return "finish_alfaTauri";
                case 8:
                    return "finish_alfa";
                default:
                    return "finish_mclaren";
            }
        }
    }

    public boolean isUpgradeChance() {
        return upgradeChance;
    }

    public void setUpgradeChance(boolean upgradeChance) {
        this.upgradeChance = upgradeChance;
    }
    
    public boolean isUpgradeChanceVisibility() {
        return upgradeChanceVisibility;
    }

    public void setUpgradeChanceVisibility(boolean upgradeChanceVisibility) {
        this.upgradeChanceVisibility = upgradeChanceVisibility;
    } 
    
    public int getGpCounter() {
        return gpCounter;
    }

    public void setGpCounter(int gpCounter) {
        this.gpCounter = gpCounter;
    } 
    
    public UnitType getNewBuilding() {
        return newBuilding;
    }
     
    public int getDevelopmentPoints() {
        return developmentPoints;
    }

    public void setDevelopmentPoints(int developmentPoints) {
        this.developmentPoints = developmentPoints;
    }

    public int getWorkerPoints() {
        return workerPoints;
    }

    public void setWorkerPoints(int workerPoints) {
        this.workerPoints = workerPoints;
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

    public TimeSimulation getTimeSimulation() {
        return timeSimulation;
    }

    public void setTimeSimulation(TimeSimulation timeSimulation) {
        this.timeSimulation = timeSimulation;
    }
    
    public Unit[][] getBoard() {
        return board;
    }
    
    public void setBoard(Unit[][] board) {
        this.board = board;
    }

    public boolean getBuildingStatus() {
        return buildingStatus;
    }

    public void setBuildingStatus(boolean buildingStatus) {
        this.buildingStatus = buildingStatus;
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
    public void setNewBuildingCancel()
    {
        newBuilding = null;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public ArrayList<Buildings> getAlreadyBuiltList() {
        return alreadyBuiltList;
    }

    public void setAlreadyBuiltList(ArrayList<Buildings> alreadyBuiltList) {
        this.alreadyBuiltList = alreadyBuiltList;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }
}

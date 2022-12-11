/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import View.GameField;
import static junit.framework.Assert.assertEquals;
import org.junit.Test;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marton
 */
public class GameModelTest 
{
    GameModel gameModelTest = new GameModel(75000, 64, 32);
    GameField gameFieldTest = new GameField();
    
    
    @Test   
    public void placeNewBuilding_SettingToFactory_Test()
    {
        gameModelTest.setGameField(gameFieldTest);
        UnitType building = UnitType.FACTORY;
        Point chosenPoint = new Point(0,0);
        gameModelTest.setNewBuilding(building);
        gameModelTest.setChosenPoint(chosenPoint);
        
        gameModelTest.placeNewBuilding();
        int counterOfUsedUnits = 0;
        for(int i = 0; i < gameModelTest.getBoard().length; i++)
        {
            for(int j = 0; j < gameModelTest.getBoard()[0].length; j++)
            {
                if(gameModelTest.getBoard()[i][j].getImage() != Images.GRASS)
                {
                    counterOfUsedUnits++;
                }
            }
        }
        int counterOfBuildings = gameModelTest.getAlreadyBuiltList().size();
        //-------------------------------//
        assertEquals(3, counterOfBuildings);
        assertEquals(192, counterOfUsedUnits);
    }

    @Test
    public void upgradeBuilding_AddLevel_Test()
    {
        Buildings tmp = new Buildings(10000, 2500, 4, 4, 8, 8, new Point(10,10), false, "Track1", Images.TRACK1);
        int firstLevel = tmp.getLevel();
        gameModelTest.upgradeBuilding(tmp);
        int secondLevel = tmp.getLevel();
        gameModelTest.upgradeBuilding(tmp);
        int thirdLevel = tmp.getLevel();
        //-------------------------------//
        assertEquals(1, firstLevel);
        assertEquals(2, secondLevel);
        assertEquals(3, thirdLevel);
    }
    
    @Test
    public void destroyBuilding_SettingBackToEmpty_Test(){
        
        Buildings tmp1 = new Buildings(20000, 10000, 5, 1, 6, 6, new Point(24,0), false, "Factory", Images.FACTORY);
        Buildings tmp2 = new Buildings(20000, 10000, 5, 1, 8, 8, new Point(10,26), false, "HQ", Images.HQ);
        ArrayList<Buildings> lst = gameModelTest.getAlreadyBuiltList();
        lst.add(tmp1);
        lst.add(tmp2);
        gameModelTest.setAlreadyBuiltList(lst);
        gameModelTest.destroyBuilding(tmp1);
        gameModelTest.destroyBuilding(tmp2);
        
        int counterOfGrassUnit = 0;
        int counterOfUsedUnits = 0;
        Unit board[][] = gameModelTest.getBoard();
        for(int i = 0; i < gameModelTest.getBoard().length; i++)
        {
            for(int j = 0; j < gameModelTest.getBoard()[0].length; j++)
            {
                if(board[i][j].getImage() == Images.GRASS)
                {
                    counterOfGrassUnit++;
                }
                if(!board[i][j].isUsable())
                {
                    counterOfUsedUnits++;
                }
            }
        }
        int money = gameModelTest.getMoney();
        List<Buildings> built = gameModelTest.getAlreadyBuiltList();
        int numOfBuildings = built.size();
        //-------------------------------//
        assertEquals(2, numOfBuildings);
        assertEquals(1992, counterOfGrassUnit);
        assertEquals(56, counterOfUsedUnits);
        assertEquals(95000, money);
    }  
    
    @Test
    public void changeTexture_SettingToSunset_Test()
    {
        gameModelTest.changeTexture("sunset");
        int counter = 0;
        for(int i =0;i<gameModelTest.getBoard().length;i++)
        {
            for(int j =0;j<gameModelTest.getBoard()[0].length;j++)
            {
                if(gameModelTest.getBoard()[i][j].getImage() == Images.GRASSSUNSET)
                {
                    counter++;
                }
            }
        }
        //-------------------------------//
        assertEquals(1892, counter);
    }
            
    @Test   
    public void startingStats_SettingToFerrari_Test()
    {
        ArrayList<Integer> result = gameModelTest.startingStats(Constructor.FERRARI);
        int idx_0 = result.get(0);
        int idx_1 = result.get(1);
        int idx_2 = result.get(2);
        int idx_3 = result.get(3);
        int idx_4 = result.get(4);
        int idx_5 = result.get(5);
        //-------------------------------//
        assertEquals(25,idx_0);
        assertEquals(5, idx_1);
        assertEquals(5, idx_2);
        assertEquals(10, idx_3);
        assertEquals(10, idx_4);
        assertEquals(10, idx_5);
    }
    
    @Test
    public void startingUnits_CreatingAll_Test(){
        int counter = 0;
        for(int i = 0; i < gameModelTest.getBoard().length ; i++)
        {
            for(int j = 0; j < gameModelTest.getBoard()[0].length; j++)
            {
                counter++;
            }
        }
        //-------------------------------//
        assertEquals(2048, counter);
    }

    @Test
    public void generatingStarterUnits_Validating_Test(){
        int counterOfUsedUnits = 0;
        int counterOfBuildings = 0;
        Unit board[][] = gameModelTest.getBoard();
        for(int i = 0; i < gameModelTest.getBoard().length ; i++)
        {
            for(int j = 0; j < gameModelTest.getBoard()[0].length; j++)
            {
                if(!board[i][j].isUsable())
                {
                    counterOfUsedUnits++;
                }
            }
        }
        List<Buildings> built = gameModelTest.getAlreadyBuiltList();
        counterOfBuildings = built.size();
        //-------------------------------//
        assertEquals(2, counterOfBuildings);
        assertEquals(156, counterOfUsedUnits);            
    }
}

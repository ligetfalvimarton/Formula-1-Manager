/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import Source.Images;
import Source.UnitType;
import View.GameField;
import View.MainWindow;
import java.awt.Point;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Marton
 */
public class GameModelTest {
    GameModel gm = new GameModel(75000, 64, 32);

    @Test
    public void startingUnits_CreatingAll_Test(){
        int counter = 0;
        for(int i = 0; i < gm.getBoard().length ; i++)
        {
            for(int j = 0; j < gm.getBoard()[0].length; j++)
            {
                counter++;
            }
        }
        //-------------------------------//
        assertEquals(2048, counter);
    }

    @Test
    public void generatingStarterUnits_Validating_Test(){
        int units_used_counter = 0;
        int buildings_counter = 0;
        Unit board[][] = gm.getBoard();
        for(int i = 0 ; i < 32; i++)
        {
            for(int j = 0; j < 64 ; j++)
            {
                if(!board[i][j].isUsable())
                {
                    units_used_counter++;
                }
            }
        }
        List<Buildings> built = gm.getAlreadyBuiltList();
        buildings_counter = built.size();
        //-------------------------------//
        assertEquals(2, buildings_counter);
        assertEquals(34, units_used_counter);            
    }

    @Test
    public void upgradeBuilding_AddLevel_Test(){
        Buildings tmp = new Buildings(10000, 2500, 4, 4, 8, 8, new Point(10,10), false, "Track1", Images.TRACK1);

        int lvl1 = tmp.getLevel();
        assertEquals(1, lvl1);
        
        gm.upgradeBuilding(tmp);
        int lvl2 = tmp.getLevel();
        assertEquals(2, lvl2);
        
        gm.upgradeBuilding(tmp);
        int lvl3 = tmp.getLevel();
        assertEquals(3, lvl3);  
    }
    
    @Test
    public void destroyBuilding_SettingBackToEmpty_Test(){
        
        Buildings tmp = new Buildings(1000, 600, 0, 0, 3, 3, new Point(10,10), false, "Factory", Images.FACTORY);
        gm.destroyBuilding(tmp);
        
        int grassCnt = 0;
        int usedUnitsCnt = 0;
        int emptyUnitsCnt = 0;
        Unit board[][] = gm.getBoard();
        for(int i = 0; i < 32; i++)
        {
            for(int j = 0; j < 64; j++)
            {
                if(board[i][j].getImage() == Images.GRASS)
                {
                    grassCnt++;
                }
                if(!board[i][j].isUsable())
                {
                    usedUnitsCnt++;
                }
                if("empty".equals(board[i][j].getType()))
                {
                    emptyUnitsCnt++;
                }
            }
        }
        int money = gm.getMoney();
        List<Buildings> built = gm.getAlreadyBuiltList();
        int numOfBuildings = built.size();
        //-------------------------------//
        assertEquals(25, usedUnitsCnt);
        assertEquals(1, numOfBuildings);
        assertEquals(2023, emptyUnitsCnt);
        assertEquals(2023, grassCnt);
        assertEquals(10500, money);
    }
    
}

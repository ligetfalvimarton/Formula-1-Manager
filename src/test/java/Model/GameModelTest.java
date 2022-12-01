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
    MainWindow w;
    GameField gf = new GameField(w);

    public GameModelTest() throws SQLException {
        this.w = new MainWindow();
    }
    
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
    public void destroyBuilding_SettingBackToEmpty_Test(){
        
        Buildings b = new Buildings(1000, 600, 0, 0, 3, 3, new Point(10,10), false, "Factory", Images.FACTORY);
        gm.setGameField(gf);
        gm.destroyBuilding(b);
        
        int numOfUsedUnits = 0;
        int numOfBuildings = 0;
        int numOfEmptyUnits = 0;
        int numOfGrass = 0;
        Unit board[][] = gm.getBoard();
        List<Buildings> built = gm.getAlreadyBuiltList();
        numOfBuildings = built.size();
        int money = gm.getMoney();
        for(int i = 0 ; i < 32; i++){
            for(int j = 0; j < 64 ; j++){
                if(!board[i][j].isUsable()){
                    numOfUsedUnits++;
                }
                if(board[i][j].getType() == "empty"){
                    numOfEmptyUnits++;
                }
                if(board[i][j].getImage() == Images.GRASS){
                    numOfGrass++;
                }
            }
        }
        
        assertEquals(25, numOfUsedUnits);
        assertEquals(1, numOfBuildings);
        assertEquals(2023, numOfEmptyUnits);
        assertEquals(2023, numOfGrass);
        assertEquals(10500, money);
    }
    
    @Test
    public void upgradeBuilding_AddLevel_Test(){
        Buildings b = new Buildings(10000, 2500, 4, 4, 8, 8, new Point(10,10), false, "Track1", Images.TRACK1);
        gm.setGameField(gf);
        
        int lvl1 = b.getLevel();
        assertEquals(1, lvl1);
        
        gm.upgradeBuilding(b);
        int lvl2 = b.getLevel();
        assertEquals(2, lvl2);
        
        gm.upgradeBuilding(b);
        int lvl3 = b.getLevel();
        assertEquals(3, lvl3);
        
        gm.upgradeBuilding(b);
        int lvl4 = b.getLevel();
        assertEquals(3, lvl4);
        
    }
}

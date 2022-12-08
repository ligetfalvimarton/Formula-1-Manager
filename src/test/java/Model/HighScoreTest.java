/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
/**
 *
 * @author Marton
 */
public class HighScoreTest {
    HighScore highScore = new HighScore("Tester", 100, 0,10000, "ferrari", 4, "[25, 5, 5, 10, 12, 10]", "10,26,hq,8,8, 24,0,Track1,8,8,");
    
    @Test
    public void highScore_Validation_Test(){
        String type = highScore.getName();
        int score = highScore.getScore();
        int wins = highScore.getWin();
        int money = highScore.getMoney();
        String constructor = highScore.getConstructor();
        int days = highScore.getDay();
        String values = highScore.getValues();
        String board = highScore.getBoard();
        //-------------------------------//
        assertEquals("Tester", type);
        assertEquals(100,score);
        assertEquals(0,wins);
        assertEquals(10000,money);
        assertEquals("ferrari",constructor);
        assertEquals(4,days);
        assertEquals("[25, 5, 5, 10, 12, 10]",values);
        assertEquals("10,26,hq,8,8, 24,0,Track1,8,8,",board);
    }
}

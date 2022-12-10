/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import static junit.framework.Assert.assertEquals;
import org.junit.Test;
/**
 *
 * @author Marton
 */
public class ReactiveGameModelTest 
{
    ReactiveGameModel reactiveGameModelTest = new ReactiveGameModel();
    
    @Test   
    public void raceweekUpgradePlus_GettingTheNumber_Test()
    {
        ArrayList<Integer> tmp = new ArrayList<>();
        reactiveGameModelTest.raceweekUpgradePlus().subscribe(tmp::add);
        int res = tmp.get(0);
        //-------------------------------//
        assertEquals(1,res);
    }
    
    @Test //Takes time because of emitting them every second
    public void minigameLightCord_EmittingAllNumber_Test() throws InterruptedException
    {
        
        ArrayList<Integer> tmp = new ArrayList<>();
        reactiveGameModelTest.minigameLightCord().subscribe(v -> tmp.add(v));
        Thread.sleep(8000);
        int res = tmp.size();
        //-------------------------------//
        assertEquals(7,res);
    }
    
    @Test //Takes time because of emitting them every second
    public void raceweekSimulation_WorkingProgress_Test() throws InterruptedException
    {
        ArrayList<ImageIcon> tmp = new ArrayList<>();
        reactiveGameModelTest.raceweekSimulation().subscribe(v -> tmp.add(v));
        Thread.sleep(13500);
        int res = tmp.size();
        //-------------------------------//
        assertEquals(13,res);
    }
}

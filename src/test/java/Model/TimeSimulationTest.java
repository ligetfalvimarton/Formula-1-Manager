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
public class TimeSimulationTest {
    TimeSimulation timeSim = new TimeSimulation();

    @Test
    public void normalTime_WorkingNormally_Test(){
        timeSim.NormalTime();
        //-------------------------------//
        assertEquals(1, timeSim.getToAdd());
        assertEquals(50, timeSim.getTimeGap());
    }
    
    @Test
    public void stopTime_WorkingNormally_Test(){
        timeSim.StopTime();
        //-------------------------------//
        assertEquals(0, timeSim.getToAdd());
    }
}

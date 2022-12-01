/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import Source.Images;
import java.awt.Point;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
/**
 *
 * @author Marton
 */
public class UnitTest {
    Unit test_unit = new Unit(new Point(0,0),true, "empty", Images.GRASS);
    
    @Test
    public void unit_ChangeToBush_Test(){
        test_unit.setType("Bush");
        test_unit.setUsable(false);
        test_unit.setImage(Images.BUSH);
        String type = test_unit.getType();
        Boolean usable = test_unit.isUsable();
        Images imageID = test_unit.getImage();
        //-------------------------------//
        assertEquals("bush1", type);
        assertEquals(false, usable);
        assertEquals(Images.BUSH, imageID);
    } 
}

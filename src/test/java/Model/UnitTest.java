/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import java.awt.Point;

import static junit.framework.Assert.assertEquals;
import org.junit.Test;
/**
 *
 * @author Marton
 */
public class UnitTest {
    Unit test_unit1 = new Unit(new Point(0,0),true, "empty", Images.GRASS);
    Unit test_unit2 = new Unit(new Point(0,0),true, "empty", Images.GRASS);
    Unit test_unit3 = new Unit(new Point(0,0),true, "empty", Images.GRASS);
    
    @Test
    public void unit_ChangeToBush_Test(){
        test_unit1.setType("Bush");
        test_unit1.setUsable(false);
        test_unit1.setImage(Images.BUSH);
        String type = test_unit1.getType();
        Boolean usable = test_unit1.isUsable();
        Images imageID = test_unit1.getImage();
        //-------------------------------//
        assertEquals("Bush", type);
        assertEquals(Boolean.FALSE, usable);
        assertEquals(Images.BUSH, imageID);
    } 
    
    @Test
    public void unit_ChangeToTrack_Test(){
        test_unit2.setType("Track1");
        test_unit2.setUsable(false);
        test_unit2.setImage(Images.TRACK1);
        String type = test_unit2.getType();
        Boolean usable = test_unit2.isUsable();
        Images imageID = test_unit2.getImage();
        //-------------------------------//
        assertEquals("Track1", type);
        assertEquals(Boolean.FALSE, usable);
        assertEquals(Images.TRACK1, imageID);
    } 
    
    @Test
    public void unit_ChangeToDepartment_Test(){
        test_unit3.setType("ChasingDepartment");
        test_unit3.setUsable(false);
        test_unit3.setImage(Images.CHASINGDEPARTMENT);
        String type = test_unit3.getType();
        Boolean usable = test_unit3.isUsable();
        Images imageID = test_unit3.getImage();
        //-------------------------------//
        assertEquals("ChasingDepartment", type);
        assertEquals(Boolean.FALSE, usable);
        assertEquals(Images.CHASINGDEPARTMENT, imageID);
    } 
}

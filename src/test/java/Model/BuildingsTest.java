/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.awt.Point;
import static junit.framework.Assert.assertEquals;
import org.junit.Test;
public class BuildingsTest {
    
    Buildings empty1 = new Buildings(1000,1000,0,0,1,1,new Point(0,0), true, "empty", Images.GRASS);
    Buildings empty2 = new Buildings(1000,1000,0,0,1,1,new Point(0,0), true, "empty", Images.GRASS);
    Buildings empty3 = new Buildings(1000,1000,0,0,1,1,new Point(0,0), true, "empty", Images.GRASS);
    @Test
    public void buildings_ChangeToTree_Test()
    {
        empty1.setType("Tree");
        empty1.setImage(Images.TREE);
        String type = empty1.getType();
        Images imageID = empty1.getImage();
        //-------------------------------//
        assertEquals("Tree", type);
        assertEquals(Images.TREE, imageID);
    }
    
    @Test
    public void buildings_ChangeToTrack_Test()
    {
        empty2.setType("Track1");
        empty2.setImage(Images.TRACK1);
        String type = empty2.getType();
        Images imageID = empty2.getImage();
        //-------------------------------//
        assertEquals("Track1", type);
        assertEquals(Images.TRACK1, imageID);
    }
    
    @Test
    public void buildings_ChangeToDepartment_Test()
    {
        empty3.setType("ChasingDepartment");
        empty3.setImage(Images.CHASINGDEPARTMENT);
        String type = empty3.getType();
        Images imageID = empty3.getImage();
        //-------------------------------//
        assertEquals("ChasingDepartment", type);
        assertEquals(Images.CHASINGDEPARTMENT, imageID);
    }
}

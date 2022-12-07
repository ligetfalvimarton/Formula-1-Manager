/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Source.Images;
import java.awt.Point;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
public class BuildingsTest {
    
    Buildings empty = new Buildings(1000,1000,0,0,1,1,new Point(0,0), true, "empty", Images.GRASS);
    
    @Test
    public void buildings_ChangeToTree_Test(){
        empty.setType("Tree");
        empty.setImage(Images.TREE);
        empty.setUsable(false);
        String type = empty.getType();
        Images imageID = empty.getImage();
        Boolean usable = empty.isUsable();
        //-------------------------------//
        assertEquals("Tree", type);
        assertEquals(Images.TREE, imageID);
        assertEquals(false, usable);
    }
}

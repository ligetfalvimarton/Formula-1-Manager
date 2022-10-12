/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Source;

import Model.Buildings;
import java.awt.Point;

/**
 *
 * @author Marton
 */
public enum UnitType {
    PATH("path"), EMPTY("empty"), GRASS("grass"),PADDOCK("paddock");
    
    private Buildings Item;
    private String type;
    
    private UnitType(String type)
    {
        this.type = type;
        switch(type)
        {
            case "grass":
                Item = new Buildings(5000, 2000, 1, 1, new Point(0,0), false, "Item", Images.GRASS);
            case "incorrect_place":
                Item = new Buildings(5000, 2000, 1, 1, new Point(0,0), false, "Item", Images.INCORRECTPLACE);
            case "paddock":
                Item = new Buildings(5000, 2000, 3, 2, new Point(0,0), false, "Item", Images.PADDOCK);
        }
    }
    public Buildings getItem(){
        return Item;
    }
    
    public void setBuildingsPosition(Point p){
        Item.setPosition(p);
    }
}

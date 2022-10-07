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
    PATH("path"), EMPTY("empty"), GRASS("grass");
    
    private Buildings Item;
    private String type;
    
    private UnitType(String type)
    {
        this.type = type;
        switch(type)
        {
            case "grass":
                Item = new Buildings(5000, 2000, 5, 5, new Point(0,0), false, "Item", Images.GRASS);
            case "incorrect_place":
        }
    }
}

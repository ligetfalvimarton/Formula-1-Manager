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
    PATH("path"), EMPTY("empty"), GRASS("grass"),TREE("Tree"),PADDOCK("paddock"),
    PLACEHOLDER("placeholder"),BUSH("Bush"),HQ("HQ"),HOUSE("House"),
    HOTEL("Hotel"),STORE("Store"),CHASINGDEPARTMENT("Chasing Department"),DOWNFORCEDEPARTMENT("Downforce Department"),
    AERODEPARTMENT("Aero Department"),DURABILITYDEPARTMENT("Durability Department"),
    PRACTICE_TRACK1("Practice Track 1"),PRACTICE_TRACK2("Practice Track 2"),PRACTICE_TRACK3("Practice Track 3"),
    POWERUNITDEPARTMENT("Powerunit Department"),FACTORY("Factory");
    
    private Buildings Item;
    private String type;
    
    private UnitType(String type)
    {
        this.type = type;
        switch(type)
        {
            case "grass":
                Item = new Buildings(0, 0, 0, 0, 1, 1, new Point(0,0), true, "grass", Images.GRASS);
                break;
            case "path":
                Item = new Buildings(200, 0, 0, 0, 1, 1, new Point(0,0), false, "path", Images.PATH);
                break;
            case "Bush":
                Item = new Buildings(350, 0, 0, 0, 1, 1, new Point(0,0), false, "Bush", Images.BUSH);
                break;
            case "Tree":
                Item = new Buildings(500, 0, 0, 0, 1, 1, new Point(0,0), false, "Tree", Images.TREE);
                break;
            case "HQ":
                Item = new Buildings(0, 25000, 0, 0, 7, 8, new Point(0,0), false, "HQ", Images.HQ);
                break;
            case "House":
                Item = new Buildings(3000, 2000, 0, 2, 6, 5, new Point(0,0), false, "House", Images.HOUSE);
                break;
            case "Hotel":
                Item = new Buildings(4500, 2000, 0, 5, 6, 6, new Point(0,0), false, "Hotel", Images.HOTEL);
                break;
            case "Store":
                Item = new Buildings(4000, 2000, 0, 4, 7, 5, new Point(0,0), false, "Store", Images.STORE);
                break;
            case "Chasing Department":
                Item = new Buildings(15000, 5000, 1, 1, 6, 3, new Point(0,0), false, "Chasing Department", Images.CHASINGDEPARTMENT);
                break; 
            case "Downforce Department":
                Item = new Buildings(15000, 5000, 3, 0, 5, 3, new Point(0,0), false, "Downforce Departmen", Images.DOWNFORCEDEPARTMENT);
                break;
            case "Aero Department":
                Item = new Buildings(15000, 5000, 5, 0, 6, 5, new Point(0,0), false, "Aero Department", Images.AERODEPARTMENT);
                break;  
            case "Powerunit Department":
                Item = new Buildings(15000, 5000, 5, 0, 6, 6, new Point(0,0), false, "Powerunit Department", Images.POWERUNITDEPARTMENT);
                break; 
            case "Durability Department":
                Item = new Buildings(15000, 5000, 1, 1, 6, 6, new Point(0,0), false, "Durability Department", Images.DURABILITYDEPARTMENT);
                break;
            case "Factory":
                Item = new Buildings(20000, 10000, 3, 3, 6, 6, new Point(0,0), false, "Factory", Images.FACTORY);
                break;
            case "Practice Track 1":
                Item = new Buildings(20000, 10000, 0, 0, 10, 8, new Point(0,0), false, "Practice Track 1", Images.TRACK1);
                break;
            case "Practice Track 2":
                Item = new Buildings(20000, 10000, 5, 5, 10, 8, new Point(0,0), false, "Practice Track 2", Images.TRACK2);
                break;
            case "Practice Track 3":
                Item = new Buildings(20000, 10000, 7, 7, 10, 8, new Point(0,0), false, "Practice Track 3", Images.TRACK3);
                break;
            case "incorrect_place":
                Item = new Buildings(0, 0, 0, 0, 1, 1, new Point(0,0), false, "incorrect_place", Images.INCORRECTPLACE);
                break;
            default :
                Item = new Buildings(0, 0, 0, 0, 1, 1, new Point(0,0), true, "grass", Images.GRASS);
                break; 
        }
    }
    public Buildings getItem(){
        return Item;
    }
    
    public void setBuildingsPosition(Point p){
        Item.setPosition(p);
    }
}

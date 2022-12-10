/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.awt.Point;

/**
 *
 * @author Marton
 */
public enum UnitType {
    PATH("path"), EMPTY("empty"), GRASS("grass"),TREE("Tree"),PADDOCK("paddock"),
    PLACEHOLDER("placeholder"),BUSH("Bush"),HQ("HQ"),HOUSE("House"),
    HOTEL("Hotel"),STORE("Store"),CHASINGDEPARTMENT("ChasingDepartment"),DOWNFORCEDEPARTMENT("DownforceDepartment"),
    AERODEPARTMENT("AeroDepartment"),DURABILITYDEPARTMENT("DurabilityDepartment"),
    TRACK1("Track1"),TRACK2("Track2"),TRACK3("Track3"),
    FLAG1("Flag1"),FLAG2("Flag2"),FLAG3("Flag3"),FLAG4("Flag4"),
    POWERUNITDEPARTMENT("PowerunitDepartment"),FACTORY("Factory");
    
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
                Item = new Buildings(0, 25000, 0, 0, 8, 8, new Point(0,0), false, "HQ", Images.HQ);
                break;
            case "House":
                Item = new Buildings(3000, 2000, 0, 2, 6, 6, new Point(0,0), false, "House", Images.HOUSE);
                break;
            case "Hotel":
                Item = new Buildings(4500, 2000, 0, 5, 6, 6, new Point(0,0), false, "Hotel", Images.HOTEL);
                break;
            case "Store":
                Item = new Buildings(4000, 2000, 0, 4, 6, 6, new Point(0,0), false, "Store", Images.STORE);
                break;
            case "Flag1":
                Item = new Buildings(4000, 2000, 0, 0, 3, 3, new Point(0,0), false, "Flag1", Images.FLAG1);
                break;
            case "Flag2":
                Item = new Buildings(4000, 2000, 0, 0, 3, 3, new Point(0,0), false, "Flag1", Images.FLAG2);
                break;
            case "Flag3":
                Item = new Buildings(4000, 2000, 0, 0, 3, 3, new Point(0,0), false, "Flag3", Images.FLAG3);
                break;
            case "Flag4":
                Item = new Buildings(4000, 2000, 0, 0, 3, 3, new Point(0,0), false, "Flag4", Images.FLAG4);
                break;
            case "ChasingDepartment":
                Item = new Buildings(15000, 5000, 4, 1, 5, 5, new Point(0,0), false, "ChasingDepartment", Images.CHASINGDEPARTMENT);
                break; 
            case "DownforceDepartment":
                Item = new Buildings(15000, 5000, 3, 3, 5, 5, new Point(0,0), false, "DownforceDepartment", Images.DOWNFORCEDEPARTMENT);
                break;
            case "AeroDepartment":
                Item = new Buildings(15000, 5000, 5, 0, 5, 5, new Point(0,0), false, "AeroDepartment", Images.AERODEPARTMENT);
                break;  
            case "PowerunitDepartment":
                Item = new Buildings(15000, 5000, 5, 0, 6, 6, new Point(0,0), false, "PowerunitDepartment", Images.POWERUNITDEPARTMENT);
                break; 
            case "DurabilityDepartment":
                Item = new Buildings(15000, 5000, 3, 2, 6, 6, new Point(0,0), false, "DurabilityDepartment", Images.DURABILITYDEPARTMENT);
                break;
            case "Factory":
                Item = new Buildings(20000, 10000, 5, 1, 6, 6, new Point(0,0), false, "Factory", Images.FACTORY);
                break;
            case "Track1":
                Item = new Buildings(30000, 10000, 3, 3, 8, 8, new Point(0,0), false, "Track1", Images.TRACK1);
                break;
            case "Track2":
                Item = new Buildings(50000, 10000, 5, 5, 8, 8, new Point(0,0), false, "Track2", Images.TRACK2);
                break;
            case "Track3":
                Item = new Buildings(70000, 10000, 7, 7, 8, 8, new Point(0,0), false, "Track3", Images.TRACK3);
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

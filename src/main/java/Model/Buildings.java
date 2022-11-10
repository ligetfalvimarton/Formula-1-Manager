/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Source.Images;
import java.awt.Point;
import javax.swing.ImageIcon;

/**
 *
 * @author Marton
 */
public class Buildings extends Unit {
    private static int ID;
    private int level;
    private int buildPrice;
    private int cost;
    private int development;
    private int workers;
    private int sizeX;
    private int sizeY;
    private int upgradeCost;
    
    public Buildings(int buildPrice, int upgradeCost,int development,int workers, int sizeX, int sizeY, Point position, boolean usable, String type, Images icon) {
        super(position, usable, type, icon);
        this.buildPrice = buildPrice;
        this.upgradeCost = upgradeCost;
        this.development = development;
        this.workers = workers;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        level = 1;
        
        ID = ++ID;
    }
    
    public Buildings(Point position, boolean usable, String type, Images icon,int sizeX,int sizeY) {
        super(position, usable, type, icon);
        this.sizeX=sizeX;
        this.sizeY=sizeY;
        
        ID = ++ID;
    }

    public static int getID() {
        return ID;
    }

    public static void setID(int ID) {
        Buildings.ID = ID;
    }

    public int getBuildPrice() {
        return buildPrice;
    }

    public void setBuildPrice(int buildPrice) {
        this.buildPrice = buildPrice;
    }

    public int getSizeX() {
        return sizeX;
    }

    public void setSizeX(int sizeX) {
        this.sizeX = sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }

    public void setSizeY(int sizeY) {
        this.sizeY = sizeY;
    }

    public int getUpgradeCost() {
        return upgradeCost;
    }

    public void setUpgradeCost(int upgradeCost) {
        this.upgradeCost = upgradeCost;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getDevelopment() {
        return development;
    }

    public void setDevelopment(int development) {
        this.development = development;
    }

    public int getWorkers() {
        return workers;
    }

    public void setWorkers(int workers) {
        this.workers = workers;
    }
}

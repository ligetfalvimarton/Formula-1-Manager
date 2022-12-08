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
public class Buildings extends Unit
{
    private int buildPrice;
    private int upgradeCost;
    private int development;
    private int workers;
    private int sizeX;
    private int sizeY;    
    private int level;
    
    public Buildings(int buildPrice, int upgradeCost,int development,int workers, int sizeX, int sizeY, Point position, boolean usable, String type, Images icon) {
        super(position, usable, type, icon);
        this.buildPrice = buildPrice;
        this.upgradeCost = upgradeCost;
        this.development = development;
        this.workers = workers;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        level = 1;
    }
    
    public int getBuildPrice() {
        return buildPrice;
    }

    public void setBuildPrice(int buildPrice) {
        this.buildPrice = buildPrice;
    }

    public int getUpgradeCost() {
        return upgradeCost;
    }

    public void setUpgradeCost(int upgradeCost) {
        this.upgradeCost = upgradeCost;
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
    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}

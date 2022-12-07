/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Source.Images;
import java.awt.Point;

/**
 *
 * @author Marton
 */
public class Unit {
    private Point position;
    private boolean usable;
    private String type;
    private Images icon;

    
    public Unit(Point position, boolean usable, String type, Images icon) {
        this.position = position;
        this.usable = usable;
        this.type = type;
        this.icon = icon;
    }
    
    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public boolean isUsable() {
        return usable;
    }

    public void setUsable(boolean usable) {
        this.usable = usable;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Images getImage() {
        return icon;
    }

    public void setImage(Images icon) {
        this.icon = icon;
    }
}

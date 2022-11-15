/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Source;

/**
 *
 * @author Marton
 */

import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.file.Paths;
import javax.imageio.ImageIO;

public enum Images {
    PATH(Paths.get("").toAbsolutePath().toString() + "/src/main/java/Images/path.png"),
    GRASS(Paths.get("").toAbsolutePath().toString() + "/src/main/java/Images/grass.jpg"),
    GRASSSUNSET(Paths.get("").toAbsolutePath().toString() + "/src/main/java/Images/grass_sunset.jpg"),
    GRASSMIDNIGHT(Paths.get("").toAbsolutePath().toString() + "/src/main/java/Images/grass_midnight.jpg"),
    TREE(Paths.get("").toAbsolutePath().toString() + "/src/main/java/Images/tree.jpg"),
    TREESUNSET(Paths.get("").toAbsolutePath().toString() + "/src/main/java/Images/tree_sunset.jpg"),
    TREEMIDNIGHT(Paths.get("").toAbsolutePath().toString() + "/src/main/java/Images/tree_midnight.jpg"),
    BUSH(Paths.get("").toAbsolutePath().toString() + "/src/main/java/Images/bush.jpg"),
    BUSHSUNSET(Paths.get("").toAbsolutePath().toString() + "/src/main/java/Images/bush_sunset.jpg"),
    BUSHMIDNIGHT(Paths.get("").toAbsolutePath().toString() + "/src/main/java/Images/bush_midnight.jpg"),
    HOUSE(Paths.get("").toAbsolutePath().toString() + "/src/main/java/Images/house_1.png"),
    HOTEL(Paths.get("").toAbsolutePath().toString() + "/src/main/java/Images/house_2.jpg"),
    STORE(Paths.get("").toAbsolutePath().toString() + "/src/main/java/Images/house_3.png"),
    AERODEPARTMENT(Paths.get("").toAbsolutePath().toString() + "/src/main/java/Images/aero_3.png"),
    DOWNFORCEDEPARTMENT(Paths.get("").toAbsolutePath().toString() + "/src/main/java/Images/aero_2.png"),
    CHASINGDEPARTMENT(Paths.get("").toAbsolutePath().toString() + "/src/main/java/Images/aero_1.png"),
    POWERUNITDEPARTMENT(Paths.get("").toAbsolutePath().toString() + "/src/main/java/Images/powerunit_2.jpg"),
    DURABILITYDEPARTMENT(Paths.get("").toAbsolutePath().toString() + "/src/main/java/Images/powerunit_1.png"),
    FACTORY(Paths.get("").toAbsolutePath().toString() + "/src/main/java/Images/powerunit_3.png"),
    HQ(Paths.get("").toAbsolutePath().toString() + "/src/main/java/Images/HQ.jpg"),
    TRACK1(Paths.get("").toAbsolutePath().toString() + "/src/main/java/Images/Practice_track_1.png"),
    TRACK2(Paths.get("").toAbsolutePath().toString() + "/src/main/java/Images/Practice_track_2.gif"),
    TRACK3(Paths.get("").toAbsolutePath().toString() + "/src/main/java/Images/Practice_track_3.png"),
    CORRECTPLACE(Paths.get("").toAbsolutePath().toString() + "/src/main/java/Images/correct_place.jpg"),
    INCORRECTPLACE(Paths.get("").toAbsolutePath().toString() + "/src/main/java/Images/incorrect_place.jpeg");
    
    private BufferedImage image;
    private final String path;
    
    private Images(String path){
        this.path = path;
        BufferedImage tempImage = null;
        try {
            tempImage = ImageIO.read(new File(path));
        } catch (Exception e) {
            tempImage = null;
            System.err.println(e.getStackTrace());
        }
        image = tempImage;
    }
    
    public BufferedImage getImage(){
        return image;
    }
    
    public String getPath(){
        return path;
    }
}
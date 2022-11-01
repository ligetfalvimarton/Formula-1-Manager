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
    TREE(Paths.get("").toAbsolutePath().toString() + "/src/main/java/Images/tree.jpg"),
    BUSH(Paths.get("").toAbsolutePath().toString() + "/src/main/java/Images/bush.jpg"),
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
    PADDOCK(Paths.get("").toAbsolutePath().toString() + "/src/main/java/Images/paddock.jpg"),
    CORRECTPLACE(Paths.get("").toAbsolutePath().toString() + "/src/main/java/Images/correct_place.jpg"),
    INCORRECTPLACE(Paths.get("").toAbsolutePath().toString() + "/src/main/java/Images/incorrect_place.jpeg"),
    PLACEHOLDER(Paths.get("").toAbsolutePath().toString() + "/src/main/java/Images/placeholder.jpg");
    
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
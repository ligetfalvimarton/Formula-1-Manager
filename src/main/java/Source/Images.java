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
    PATH(Paths.get("").toAbsolutePath().toString() + "/src/main/java/Images/path.jpg"),
    GRASS(Paths.get("").toAbsolutePath().toString() + "/src/main/java/Images/grass.jpg"),
    CAR(Paths.get("").toAbsolutePath().toString() + "/src/main/java/Images/car.jpg"),
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
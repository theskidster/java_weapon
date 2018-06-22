package theskidster.java.main;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * @author J Hoffman
 * Created: Jun 22, 2018
 */

public class MainResource {
    
    final int spWidth = 6;
    final int spHeight = 5;
    
    public BufferedImage bi;
    public BufferedImage[] bi2 = new BufferedImage[16];
    
    public MainResource() {
        try {
            bi = ImageIO.read(getClass().getResource("/theskidster/java/assets/img_java_gun.png"));
        } catch(IOException e) {
            e.printStackTrace();
        }
        
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                bi2[(i * 4) + j] = bi.getSubimage(j * spWidth, i * spHeight, spWidth, spHeight);
            }
        }
    }
    
}
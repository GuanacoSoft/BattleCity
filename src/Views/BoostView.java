package Views;
import java.awt.*;

import Models.Boost;

public class BoostView {

    
    private static Image[] boostImage = null;

    public BoostView() {
    }   


    public static void setBoostImage(Image[] boostImage) {
        BoostView.boostImage = boostImage;
    }


    public void draw(Graphics g, int x, int y, int width, int height) {
        Image[] imgs = Boost.getBoostImage();
        if (imgs != null && imgs[0] != null) {
            g.drawImage(imgs[0], x, y, width, height, null);
        } else {
            System.out.println("Imagen de boost es null al dibujar.");
        }
    }
    
}

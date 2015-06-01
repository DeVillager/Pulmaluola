package elementit;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Seina extends JPanel implements Elementti {

    private int x;
    private int y;
    private int koko;
     private String imgFileName = "images/wall.png";
    private Image img = luoKuva(imgFileName);

    public Seina(int x, int y, int koko) {
        this.x = x;
        this.y = y;
        this.koko = koko;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getKoko() {
        return koko;
    }

    public String getId() {
        return "seina";
    }

    public void piirra(Graphics graphics) {
        graphics.drawImage(img, x, y, this);
    }
    
    private Image luoKuva(String imgFileName) {
        ImageIcon icon = null;
        java.net.URL imgURL = getClass().getClassLoader().getResource(imgFileName);
        if (imgURL != null) {
            icon = new ImageIcon(imgURL);
        } else {
            System.err.println("Ei löytynyt kuvaa  " + imgFileName);
        }
        Image img = icon.getImage();
        return img;
    }
}

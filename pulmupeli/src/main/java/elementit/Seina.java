package elementit;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Seina extends JPanel implements Elementti {

    private int x;
    private int y;
    private int koko;
    private BufferedImage wall;

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
//        graphics.setColor(Color.BLACK);
//        graphics.fillRect(x, y, koko, koko);
        try {
            wall = ImageIO.read(new File("C:\\wall.png"));
        } catch (IOException ex) {
            System.out.println("ei onnittu");
        }
        graphics.drawImage(wall, x, y, this);
    }
}

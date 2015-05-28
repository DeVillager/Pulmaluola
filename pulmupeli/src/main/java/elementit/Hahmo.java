package elementit;


import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Hahmo extends JPanel implements Elementti {

    private int x;
    private int y;
    private int koko;
    private BufferedImage man;

    public Hahmo(int x, int y, int koko) {
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
        return "hahmo";
    }

    public void siirry(int xmuutos, int ymuutos) {
        this.x += xmuutos;
        this.y += ymuutos;
    }

    public void piirra(Graphics graphics) {
        try {
            man = ImageIO.read(new File("C:\\Pulmaluola\\pulmupeli\\src\\main\\java\\Tiedostot\\slimeb.png"));
        } catch (IOException ex) {
            System.out.println("ei onnittu");
        }
        graphics.drawImage(man, x, y, this);
    }
}

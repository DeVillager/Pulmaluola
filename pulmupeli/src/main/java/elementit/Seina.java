package elementit;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * Luokka määrittelee seinä-olion
 */
public class Seina extends JPanel implements Elementti {

    private int x;
    private int y;
    private int koko;
     private String imgFileName = "omaseina2.png";
    private Image img = luoKuva(imgFileName);
    
    /**
     * Luo seinän, jolla on x- ja y-suuntaiset pituudet sekä koko
     * @param x Seinän pituus x-suunnassa
     * @param y Seinän pituus y-suunnassa
     * @param koko Seinän koko
     */
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
    
    /**
     * Metodi pyytää graphics oliota piirtämään seinään liittyvän kuvan img
     * @param graphics Olio, joka piirtää kuvan
     */
    public void piirra(Graphics graphics) {
        graphics.drawImage(img, x, y, this);
    }
    
    /**
     * Metodi hakee tiedoston tekstistä, joka kertoo pathin tiedostoon. Palauttaa tiedoston image-oliona.
     * @param imgFileName Haettava kuvatiedosto
     * @return kuva, joka liittyy seinä-olioon
     */
    public Image luoKuva(String imgFileName) {
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

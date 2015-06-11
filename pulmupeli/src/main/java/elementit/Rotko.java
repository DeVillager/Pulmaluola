package elementit;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * Luokka määrittelee laatikko-olion
 */
public class Rotko extends JPanel implements Elementti {

    private int x;
    private int y;
    private int koko;
    private String id;
    private String imgFileName = "omarotko.png";
    private boolean tyhja;
    private Image img = luoKuva(imgFileName);

    /**
     * Luo laatikon, jolla on x- ja y-suuntaiset pituudet sekä koko
     *
     * @param x laatikon pituus x-suunnassa
     * @param y laatikon pituus y-suunnassa
     * @param koko laatikon koko
     */
    public Rotko(int x, int y, int koko) {
        this.x = x;
        this.y = y;
        this.koko = koko;
        this.id = "rotko";
        this.tyhja = true;
    }

    /**
     * Metodi pyytää graphics oliota piirtämään seinään liittyvän kuvan img
     *
     * @param graphics Olio, joka piirtää kuvan
     */
    public void piirra(Graphics graphics) {
        graphics.drawImage(img, x, y, null);
    }

    /**
     * Metodi hakee tiedoston tekstistä, joka kertoo pathin tiedostoon.
     * Palauttaa tiedoston image-oliona.
     *
     * @param imgFileName Haettava kuvatiedosto
     * @return kuva, joka liittyy rotko-olioon
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
    
    // Tästä eteenpäin loput metodit ovat gettereitä ja settereitä
    
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getKoko() {
        return koko;
    }

    public String getId() {
        return id;
    }

    public String getImage() {
        return imgFileName;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setId(String uusiId) {
        this.id = uusiId;
    }

    public void setImage(String uusikuva) {
        this.imgFileName = uusikuva;
        img = luoKuva(imgFileName);
    }

}

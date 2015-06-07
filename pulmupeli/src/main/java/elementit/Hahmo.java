package elementit;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * Luokka määrittelee hahmo-olion
 */
public class Hahmo extends JPanel implements Elementti {

    private int x;
    private int y;
    private int koko;
    private String imgFileName = "slimeb.png";
    private Image img = luoKuva(imgFileName);

    /**
     * Luo hahmon, jolla on x- ja y-suuntaiset pituudet sekä koko
     *
     * @param x hahmon pituus x-suunnassa
     * @param y hahmon pituus y-suunnassa
     * @param koko hahmon koko
     */
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
    
    /**
     * Metodi siirtää hahmon koordinaatteja
     * @param xmuutos siirron x-suuntainen muutos
     * @param ymuutos siirron y-suuntainen muutos
     */
    public void siirry(int xmuutos, int ymuutos) {
        this.x += xmuutos;
        this.y += ymuutos;
    }

    /**
     * Metodi pyytää graphics oliota piirtämään hahmoon liittyvän kuvan img
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
     * @return kuva, joka liittyy hahmo-olioon
     */
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

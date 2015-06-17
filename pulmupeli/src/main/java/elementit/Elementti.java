package elementit;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * Luokka määrittelee elementti-olion
 */
public class Elementti extends JPanel {

    private int x;
    private int y;
    private final int koko;
    private String id;
    private String imgFile;
    protected Image img;
    
    /**
     * Luo elementin, jolla on x- ja y-koordinaatit, koko, tunnus ja polku kuvatiedostoon.
     *
     * @param x elementin koordinaatti x-suunnassa
     * @param y elementin koordinaatti y-suunnassa
     * @param koko elementin koko
     * @param id elementin tunnus
     * @param imgFile polku elementin kuvatiedostoon
     */
    public Elementti(int x, int y, int koko, String id, String imgFile) {
        this.x = x;
        this.y = y;
        this.koko = koko;
        this.id = id;
        this.imgFile = imgFile;
        this.img = luoKuva(imgFile);
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
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
        return imgFile;
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
        this.imgFile = uusikuva;
        this.img = luoKuva(imgFile);
    }

    /**
     * Metodi hakee tiedoston tekstistä, joka kertoo pathin tiedostoon.
     * Palauttaa tiedoston image-oliona.
     *
     * @param imgFileName Haettava kuvatiedosto
     * @return kuva, joka liittyy hahmo-olioon
     */
    public final Image luoKuva(String imgFileName) {
        ImageIcon icon = null;
        java.net.URL imgURL = getClass().getClassLoader().getResource(imgFileName);
        if (imgURL != null) {
            icon = new ImageIcon(imgURL);
        } else {
            System.err.println("Ei löytynyt kuvaa  " + imgFileName);
        }
        Image kuva = icon.getImage();
        return kuva;
    }

    /**
     * Metodi pyytää graphics oliota piirtämään hahmoon liittyvän kuvan img
     *
     * @param graphics Olio, joka piirtää kuvan
     */
    public void piirra(Graphics graphics) {
        graphics.drawImage(img, getX(), getY(), null);
    }

}

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
    private String id;
    private String imgFileName = "omahahmoD.png";
    private Image img = luoKuva(imgFileName);

    /**
     * Luo hahmon, jolla on x- ja y-suuntaiset pituudet, koko ja identiteetti.
     *
     * @param x hahmon pituus x-suunnassa
     * @param y hahmon pituus y-suunnassa
     * @param koko hahmon koko
     */
    public Hahmo(int x, int y, int koko) {
        this.x = x;
        this.y = y;
        this.koko = koko;
        this.id = "hahmo";
    }

    /**
     * Metodi siirtää hahmon koordinaatteja
     *
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

    /**
     *Metodi asettaa hahmolle uuden kuvan kun painetaan jotakin suuntanäppäintä.
     * @param keyCode näppäimistöltä painetun näppäimen numerokoodi
     */
    public void asetaUusikuva(int keyCode) {

        if (keyCode == 37) {
            this.setImage("omahahmoL.png");
            this.img = luoKuva(this.getImage());
        } else if (keyCode == 39) {
            this.setImage("omahahmoR.png");
            this.img = luoKuva(this.getImage());
        } else if (keyCode == 38) {
            this.setImage("omahahmoU.png");
            this.img = luoKuva(this.getImage());
        } else if (keyCode == 40) {
            this.setImage("omahahmoD.png");
            this.img = luoKuva(this.getImage());
        } else if (keyCode == 82) {
            this.setImage("omahahmoD.png");
            this.img = luoKuva(this.getImage());
        }
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
    }

}

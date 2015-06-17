package elementit;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 * Luokka määrittelee rotko-olion
 */
public class Rotko extends Elementti {

    /**
     * Luo rotkon, jolla on x- ja y-koordinaatit, koko, tunnus ja polku kuvatiedostoon.
     *
     * @param x rotkon koordinaatti x-suunnassa
     * @param y rotkon koordinaatti y-suunnassa
     * @param koko rotkon koko
     * @param id rotkon tunnus
     * @param imgFile polku rotkon kuvatiedostoon
     */
    public Rotko(int x, int y, int koko, String id, String imgFile) {
        super(x, y, koko, id, imgFile);
        super.img = luoKuva(getImage());
    }
}
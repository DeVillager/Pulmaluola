package elementit;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 * Luokka määrittelee maali-olion
 */
public class Maali extends Elementti {

    /**
     * Luo maalin, jolla on x- ja y-koordinaatit, koko, tunnus ja polku kuvatiedostoon.
     *
     * @param x maalin koordinaatti x-suunnassa
     * @param y maalin koordinaatti y-suunnassa
     * @param koko maalin koko
     * @param id maalin tunnus
     * @param imgFile polku maalin kuvatiedostoon
     */
    public Maali(int x, int y, int koko, String id, String imgFile) {
        super(x, y, koko, id, imgFile);
        super.img = luoKuva(getImage());
    }
}

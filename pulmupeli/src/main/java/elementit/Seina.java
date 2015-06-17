package elementit;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 * Luokka määrittelee seina-olion
 */
public class Seina extends Elementti {

    /**
     * Luo seinan, jolla on x- ja y-koordinaatit, koko, tunnus ja polku kuvatiedostoon.
     *
     * @param x seinan koordinaatti x-suunnassa
     * @param y seinan koordinaatti y-suunnassa
     * @param koko seinan koko
     * @param id seinan tunnus
     * @param imgFile polku seinan kuvatiedostoon
     */
    public Seina(int x, int y, int koko, String id, String imgFile) {
        super(x, y, koko, id, imgFile);
        super.img = luoKuva(getImage());
    }
}

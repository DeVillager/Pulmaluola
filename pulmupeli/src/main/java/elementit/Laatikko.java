package elementit;

/**
 * Luokka määrittelee laatikko-olion
 */
public class Laatikko extends Elementti {

    /**
     * Luo kiven, jolla on x- ja y-koordinaatit, koko, tunnus ja polku kuvatiedostoon.
     *
     * @param x kiven koordinaatti x-suunnassa
     * @param y kiven koordinaatti y-suunnassa
     * @param koko kiven koko
     * @param id kiven tunnus
     * @param imgFile polku kiven kuvatiedostoon
     */
    public Laatikko(int x, int y, int koko, String id, String imgFile) {
        super(x, y, koko, id, imgFile);
        super.img = luoKuva(getImage());
    }
}

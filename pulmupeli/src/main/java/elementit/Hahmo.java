package elementit;

/**
 * Luokka määrittelee hahmo-olion
 */
public class Hahmo extends Elementti {

    /**
     * Luo hahmon, jolla on x- ja y-koordinaatit, koko, tunnus ja polku kuvatiedostoon.
     *
     * @param x hahmon koordinaatti x-suunnassa
     * @param y hahmon koordinaatti y-suunnassa
     * @param koko hahmon koko
     * @param id hahmon tunnus
     * @param imgFile polku hahmon kuvatiedostoon
     */
    public Hahmo(int x, int y, int koko, String id, String imgFile) {
        super(x, y, koko, id, imgFile);
        super.img = luoKuva(getImage());
    }

    /**
     * Metodi siirtää hahmon koordinaatteja
     *
     * @param xmuutos siirron x-suuntainen muutos
     * @param ymuutos siirron y-suuntainen muutos
     */
    public void siirry(int xmuutos, int ymuutos) {
        setX(getX() + xmuutos);
        setY(getY() + ymuutos);
    }

    /**
     * Metodi asettaa hahmolle uuden kuvan kun painetaan jotakin
     * suuntanäppäintä.
     *
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
}

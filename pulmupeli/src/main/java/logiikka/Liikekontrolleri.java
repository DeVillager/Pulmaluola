package logiikka;

import elementit.Elementti;
import elementit.Hahmo;
import elementit.Maali;
import gui.Peli;
import java.util.ArrayList;
import javafx.scene.input.KeyCode;

/**
 * Luokka tarkistaa voiko hahmoa siirtää annettuun suuntaan
 */
public class Liikekontrolleri {

    private Hahmo hahmo;
    private ArrayList<Elementti> kenttaelementit;
    private Maali maali;

    /**
     * Luo liikekontrollerin, joka tuntee hahmon, maalin sekä kenttäelementit
     *
     * @param hahmo Pelaajan hahmo
     * @param maali Ruutu, johon hahmo pitää saada
     * @param kelementit Lista kentällä olevista elementeistä
     */
    public Liikekontrolleri(Hahmo hahmo, Maali maali, ArrayList<Elementti> kelementit) {
        this.hahmo = hahmo;
        this.kenttaelementit = kelementit;
        this.maali = maali;
    }

    /**
     * Metodi tarkastaa onko hahmo samassa koordinaatissa kuin maali.
     *
     * @param peli Kaynnissa oleva peli
     * @return true, jos hahmo pääsi maaliin; muuten false
     */
    public boolean tarkastaOnkoMaalissa(Peli peli) {
        if (hahmo.getX() == peli.getRakentaja().getMaali().getX() && hahmo.getY() == peli.getRakentaja().getMaali().getY()) {
            return true;
        }
        return false;
    }

    /**
     * Metodi tarkastaa onko hahmo samassa koordinaatissa kuin joku rotko, joka
     * ei ole taysi
     *
     * @return true, jos hahmo on tyhjan rotkon päällä
     */
    public boolean tarkastaPutoaakoRotkoon() {
        for (Elementti elem : kenttaelementit) {
            if ("rotko".equals(elem.getId()) && elem.getX() == hahmo.getX() && elem.getY() == hahmo.getY()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Tarkastaa liikkeen näppäimistöltä annetun syötteen perusteella
     *
     * @param keyCode Painettuun näppäimeen liittyvä numerokoodi
     * @return true, jos liike on mahdollinen; muuten false
     */
    public boolean tarkastaLiike(int keyCode) {
        if (keyCode == 37 || keyCode == 38 || keyCode == 39 || keyCode == 40) {
            return tarkastaEihanTormaa(keyCode);
        }
        if (keyCode == 82) {
            return true;
        }
        return false;
    }

    /**
     * Tarkastaa törmääkö hahmo jos se siirtyisi. Jos vieressä on laatikko,
     * jonka takana on tyhjä ruutu, hahmo siirtyy ja työntää laatikkoa.
     *
     * @param keyCode Painettuun näppäimeen liittyvä numerokoodi
     * @return true, jos hahmo ei törmää tai liike on sallittu; muuten false
     */
    boolean tarkastaEihanTormaa(int keyCode) {

        /**
         * Luodaan tarkastelua varten tarkastelukoordinaatit
         */
        int x = hahmo.getX();
        int y = hahmo.getY();

        /**
         * Jos näppäin on jokin suuntanäppäimistä, niin tarkastelukoordinaatiksi
         * tulee ruutu, johon hahmo olisi siirtymässä
         */
        if (keyCode == 37) {
            x -= hahmo.getKoko();
        }
        if (keyCode == 39) {
            x += hahmo.getKoko();
        }
        if (keyCode == 38) {
            y -= hahmo.getKoko();
        }
        if (keyCode == 40) {
            y += hahmo.getKoko();
        }
        if (!tarkastaOnkoEdessaElementtia(x, y, keyCode)) {
            return true;
        }
        return false;
    }

    public ArrayList<Elementti> getKenttaobjektit() {
        return kenttaelementit;
    }

    /**
     * Jos tarkastelukoordinaatissa on jokin elementti niin siirrytään
     * seuraavaan vaiheeseen
     */
    private boolean tarkastaOnkoEdessaElementtia(int x, int y, int keycode) {
        for (Elementti elem : kenttaelementit) {        // siistitään myöhemmin tarkastaEihanTormaa-kutsuvaksi metodiksi
            if (elem.getX() == x && elem.getY() == y) { // tarkastellaan onko edes elementtiä edessä
                boolean totuus = suoritaTarkasteluElementille(elem, keycode);
                return totuus;
            }
        }
        return false;
    }

    /**
     * Metodi suorittaa tarkastelun hahmon liikkeelle, mikä riippuu elementistä.
     *
     * @param elem tarkasteltava elementti hahmon liikkeen suunnassa
     * @param keyCode hahmolle syötetyn suunnan numeroarvo
     * @return false, jos liike on validi
     */
    private boolean suoritaTarkasteluElementille(Elementti elem, int keyCode) {
        String id = elem.getId();
        if ("seina".equals(id)) {
            return true;
        } else if ("laatikko".equals(id)) {

            /**
             * Määritellään nyt uusi tarkastelukoordinaatti
             */
            int x = elem.getX();
            int y = elem.getY();

            /**
             * Tarkastellaan hahmolle annetun liikkeen suunta ja asetetaan
             * tarkastelukoordinaatti laatikon viereen kyseiseen suuntaan
             */
            if (keyCode == 37) {
                x -= hahmo.getKoko();
            }
            if (keyCode == 39) {
                x += hahmo.getKoko();
            }
            if (keyCode == 38) {
                y -= hahmo.getKoko();
            }
            if (keyCode == 40) {
                y += hahmo.getKoko();
            }

            /**
             * Tarkastellaan nyt kyseisessa suunnassa olevaa elementtiä. Jos sen
             * identiteetti on taysirotko, niin liike onnistuu. Jos taas sen
             * identiteetti on mikä tahansa muu kuin rotko tai taysirotko, niin
             * liike epäonnistuu. Jos ei kumpikaan aiemmista, niin sen
             * identiteetti on rotko, jolloin muutetaan elementin identiteetti
             * taysirotkoksi, annetaan sille uusi kuva, poistetaan laatikko-olio
             * kentaelementeista ja liike onnistuu.
             */
            for (Elementti elem2 : kenttaelementit) {
                if (elem2.getX() == x && elem2.getY() == y) {
                    if ("taysirotko".equals(elem2.getId())) {
                        continue;
                    }
                    if (!"rotko".equals(elem2.getId())) {
                        return true;
                    } else {
                        elem2.setId("taysirotko");
                        elem2.setImage("omataysirotko.png");
                        kenttaelementit.remove(elem);
                        return false;
                    }
                }
            }
            elem.setX(x);
            elem.setY(y);
            return false;
        }
        return false;
    }
}

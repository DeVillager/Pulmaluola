package logiikka;

import elementit.Elementti;
import elementit.Seina;
import elementit.Hahmo;
import elementit.Maali;
import java.util.ArrayList;

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
        int x = hahmo.getX();
        int y = hahmo.getY();

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
        for (Elementti elem : kenttaelementit) {        // siistitään myöhemmin tarkastaEihanTormaa-kutsuvaksi metodiksi
            if (elem.getX() == x && elem.getY() == y) { // tarkastellaan onko edes elementtiä edessä
                String id = elem.getId();   // jos on niin katsotaan mikä elementti
                if ("seina".equals(id)) {
                    return false;
                } else if ("laatikko".equals(id)) {
                    int x2 = elem.getX();
                    int y2 = elem.getY();
                    if (keyCode == 37) {
                        x2 -= hahmo.getKoko();
                    }
                    if (keyCode == 39) {
                        x2 += hahmo.getKoko();
                    }
                    if (keyCode == 38) {
                        y2 -= hahmo.getKoko();
                    }
                    if (keyCode == 40) {
                        y2 += hahmo.getKoko();
                    }
                    for (Elementti elem2 : kenttaelementit) {
                        if (elem2.getX() == x2 && elem2.getY() == y2) {
                            return false;
                        }
                    }
                    elem.setX(x2);
                    elem.setY(y2);
                    return true;
                }
            }
        }
        return true;
    }

    public ArrayList<Elementti> getKenttaobjektit() {
        return kenttaelementit;
    }

}

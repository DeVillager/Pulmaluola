package logiikka;

import elementit.Elementti;
import elementit.Hahmo;
import elementit.Laatikko;
import elementit.Maali;
import elementit.Seina;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class LiikekontrolleriTest {

    Hahmo hahmo;
    ArrayList<Elementti> kenttaelementit = new ArrayList<Elementti>();
    Liikekontrolleri kontrolleri;
    Maali maali;

    @Before
    public void setUp() {
        hahmo = new Hahmo(1, 1, 1);
        maali = new Maali(2, 2, 1);
        kenttaelementit = new ArrayList<>();
        kenttaelementit.add(new Seina(2, 1, 9));
        kenttaelementit.add(new Seina(1, 2, 9));
        kenttaelementit.add(new Seina(0, 1, 9));
        kenttaelementit.add(new Seina(1, 0, 9));
        kontrolleri = new Liikekontrolleri(hahmo, maali, kenttaelementit);
    }

    @Test
    public void eiOtaMuitaKomentoja() {
        assertEquals(false, kontrolleri.tarkastaLiike(1));
    }

    @Test
    public void tormaysTarkastusToimiiKunPainetaanVaarin() {
        assertEquals(kontrolleri.tarkastaEihanTormaa(1), true);
    }

    @Test
    public void tormaysTarkastusToimiiKunLiikuttuXSuunnassaOikealle() {
        assertEquals(kontrolleri.tarkastaEihanTormaa(39), false);
    }

    @Test
    public void tormaysTarkastusToimiiKunLiikuttuXSuunnassaVasemmalle() {
        assertEquals(kontrolleri.tarkastaEihanTormaa(37), false);
    }

    @Test
    public void tormaysTarkastusToimiiKunLiikuttuYSuunnassaYlos() {
        assertEquals(kontrolleri.tarkastaEihanTormaa(38), false);
    }

    @Test
    public void tormaysTarkastusToimiiKunLiikuttuYSuunnassaAlas() {
        assertEquals(kontrolleri.tarkastaEihanTormaa(40), false);
    }

    @Test
    public void tormaysTarkastusToimiiKunLiikuttuXSuunnassaOikealleHahmonKoonVerran() {
        kenttaelementit.add(new Seina(hahmo.getX() + hahmo.getKoko(), hahmo.getY(), 9));
        assertEquals(kontrolleri.tarkastaEihanTormaa(39), false);
    }

    @Test
    public void tormaysTarkastusToimiiKunLiikuttuYSuunnassaAlasHahmonKoonVerran() {
        kenttaelementit.add(new Seina(hahmo.getX(), hahmo.getY() + hahmo.getKoko(), 9));
        assertEquals(kontrolleri.tarkastaEihanTormaa(40), false);
    }

    @Test
    public void hahmonKokoOikein() {
        assertEquals(hahmo.getKoko(), 1);
    }

    @Test
    public void getteriKenttaobjekteilleToimii() {
        assertEquals(kenttaelementit, kontrolleri.getKenttaobjektit());
    }

    @Test
    public void hahmoSiirtyyKunVieressaLaatikko() {
        kenttaelementit.clear();
        kenttaelementit.add(new Laatikko(2, 1, 1));
        Liikekontrolleri uusikontrolleri = new Liikekontrolleri(hahmo, maali, kenttaelementit);
        if (uusikontrolleri.tarkastaLiike(39)) {
            hahmo.siirry(1, 0);
        }
        assertEquals(hahmo.getX(), 2);
    }

    @Test
    public void hahmoSiirtyyKunVieressaLaatikkoJaLaatikkoSiirtyyX() {
        kenttaelementit.clear();
        Laatikko box = new Laatikko(2, 1, 1);
        kenttaelementit.add(box);
        Liikekontrolleri uusikontrolleri = new Liikekontrolleri(hahmo, maali, kenttaelementit);
        uusikontrolleri.tarkastaLiike(39);
        assertEquals(3, box.getX());
    }
    
    @Test
    public void hahmoSiirtyyKunVieressaLaatikkoJaLaatikkoSiirtyyX2() {
        kenttaelementit.clear();
        Laatikko box = new Laatikko(0, 1, 1);
        kenttaelementit.add(box);
        Liikekontrolleri uusikontrolleri = new Liikekontrolleri(hahmo, maali, kenttaelementit);
        uusikontrolleri.tarkastaLiike(37);
        assertEquals(-1, box.getX());
    }
    
    @Test
    public void hahmoSiirtyyKunVieressaLaatikkoJaLaatikkoSiirtyyY() {
        kenttaelementit.clear();
        Laatikko box = new Laatikko(1, 2, 1);
        kenttaelementit.add(box);
        Liikekontrolleri uusikontrolleri = new Liikekontrolleri(hahmo, maali, kenttaelementit);
        uusikontrolleri.tarkastaLiike(40);
        assertEquals(3, box.getY());
    }
    
    @Test
    public void hahmoSiirtyyKunVieressaLaatikkoJaLaatikkoSiirtyyY2() {
        kenttaelementit.clear();
        Laatikko box = new Laatikko(1, 0, 1);
        kenttaelementit.add(box);
        Liikekontrolleri uusikontrolleri = new Liikekontrolleri(hahmo, maali, kenttaelementit);
        uusikontrolleri.tarkastaLiike(38);
        assertEquals(-1, box.getY());
    }
    
    @Test
    public void hahmoEiVoiSiirtyaKunVieressaUseampiLaatikkoVierekkain() {
        kenttaelementit.clear();
        Laatikko box = new Laatikko(2, 1, 1);
        Laatikko box2 = new Laatikko(3, 1, 1);
        kenttaelementit.add(box);
        kenttaelementit.add(box2);
        Liikekontrolleri uusikontrolleri = new Liikekontrolleri(hahmo, maali, kenttaelementit);
        uusikontrolleri.tarkastaLiike(39);
        assertEquals(1, hahmo.getX());
    }

//    @Test
//    public void hahmonVieressaLaatikkoTunnistetaanLaatikoksiSenIdentiteetilla() {
//        kenttaelementit.clear();
//        Laatikko box = new Laatikko(2, 1, 1);
//        box.setId("eiMitaan");
//        kenttaelementit.add(box);
//        Liikekontrolleri uusikontrolleri = new Liikekontrolleri(hahmo, maali, kenttaelementit);
//        if (uusikontrolleri.tarkastaLiike(39)) {
//            hahmo.siirry(1, 0);
//        }
//        assertEquals(hahmo.getX(), 1);
//    }

}

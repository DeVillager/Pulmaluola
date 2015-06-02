package logiikka;

import elementit.Elementti;
import elementit.Hahmo;
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
        maali = new Maali(1, 1, 1);
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

}

package logiikka;

import elementit.Elementti;
import elementit.Maali;
import elementit.Seina;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class KentanrakentajaTest {

    ArrayList<Elementti> seinat;
    int koko = 40;
    Kentanrakentaja kr;
    Maali maali;

    @Before
    public void setUp() {
        seinat = new ArrayList<Elementti>();
        seinat.add(new Seina(40, 80, koko));
        seinat.add(new Seina(80, 80, koko));
        seinat.add(new Seina(120, 360, koko));
        kr = new Kentanrakentaja(seinat, koko);
    }

    @Test
    public void valmiitSeinatLisaytyy() { // konstruktorissa luodaan listan valmiit seinat: lisaaSeina(...)
        int laskuri = 0;
        for (Elementti seina : seinat) {
            if (seina.getX() == 80 && seina.getY() == 80 && seina.getKoko() == koko) {
                laskuri++;
            } else if (seina.getX() == 40 && seina.getY() == 80 && seina.getKoko() == koko) {
                laskuri++;
            } else if (seina.getX() == 120 && seina.getY() == 360 && seina.getKoko() == koko) {
                laskuri++;
            }
        }
        assertEquals(3, laskuri);
    }

    @Test
    public void seinienKokoAinaSama() {
        boolean totuus = true;
        for (Elementti seina : seinat) {
            if (seina.getKoko() != 40) {
                totuus = false;
            }
        }
        assertEquals(true, totuus);
    }

//    @Test
//    public void eiVoiOllaNegatiivisiaKoordinaatteja() {
//        boolean totuus = true;
//        for (Elementti seina : seinat) {
//            if (seina.getX() < 0 || seina.getY() < 0) {
//                totuus = false;
//            }
//        }
//        assertEquals(true, totuus);
//    }
    @Test
    public void seinanLisaysToimii() {
        kr.lisaaSeina(7, 6, koko);
        boolean totuus = false;
        for (Elementti seina : seinat) {
            if (seina.getX() == 7 * koko && seina.getY() == 6 * koko && seina.getKoko() == koko) {
                totuus = true;
            }
        }
        assertEquals(true, totuus);
    }

    @Test
    public void seinalistanGetteriToimii() {
        assertEquals(seinat, kr.getLista());
    }

    @Test
    public void seinanLisaaminenToimii() {
        kr.lisaaSeina(7, 8, 10);
        boolean totuus = false;
        for (Elementti seina : seinat) {
            if (seina.getX() == 70 && seina.getY() == 80 && seina.getKoko() == 10) {
                totuus = true;
            }
        }
        assertEquals(true, totuus);
    }

    @Test
    public void laatikonLisaaminenToimii() {
        kr.lisaaLaatikko(3, 5, 10);
        boolean totuus = false;
        for (Elementti seina : seinat) {
            if (seina.getX() == 30 && seina.getY() == 50 && seina.getKoko() == 10) {
                totuus = true;
            }
        }
        assertEquals(true, totuus);
    }

    @Test
    public void lisaaKentalleSeinatLisaaOikeanMaaranSeinia() {
        kr.lisaaKentalleSeinat();
        assertEquals(seinat.size(), 63);
    }

    @Test
    public void lisaaKentalleLaatikotLisaaOikeanMaaranLaatikoita() {
        kr.lisaaKentalleLaatikot();
        assertEquals(seinat.size(), 31);
    }

    @Test
    public void lisaaMaaliToimii() {
        kr.lisaaMaali();
        boolean totuus = false;
        for (Elementti elem : seinat) {
            if (elem.getId() == "maali" && elem.getX() == koko && elem.getY() == 12*koko && elem.getKoko() == koko) {
                totuus = true;
            }
        }
        assertEquals(true, totuus);
    }

}

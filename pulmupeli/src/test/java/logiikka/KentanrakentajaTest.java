package logiikka;

import elementit.Elementti;
import elementit.Maali;
import elementit.Seina;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class KentanrakentajaTest {

    ArrayList<Elementti> kenttaelementit;
    int koko = 40;
    Kentanrakentaja kr;
    Maali maali;

    @Before
    public void setUp() {
        kenttaelementit = new ArrayList<Elementti>();
        kenttaelementit.add(new Seina(40, 80, koko));
        kenttaelementit.add(new Seina(80, 80, koko));
        kenttaelementit.add(new Seina(120, 360, koko));
        kr = new Kentanrakentaja(kenttaelementit, koko);
    }

    @Test
    public void valmiitSeinatLisaytyy() { // konstruktorissa luodaan listan valmiit seinat: lisaaSeina(...)
        int laskuri = 0;
        for (Elementti seina : kenttaelementit) {
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
        for (Elementti seina : kenttaelementit) {
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
        for (Elementti seina : kenttaelementit) {
            if (seina.getX() == 7 * koko && seina.getY() == 6 * koko && seina.getKoko() == koko) {
                totuus = true;
            }
        }
        assertEquals(true, totuus);
    }

    @Test
    public void seinalistanGetteriToimii() {
        assertEquals(kenttaelementit, kr.getLista());
    }

    @Test
    public void seinanLisaaminenToimii() {
        kr.lisaaSeina(7, 8, 10);
        boolean totuus = false;
        for (Elementti seina : kenttaelementit) {
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
        for (Elementti seina : kenttaelementit) {
            if (seina.getX() == 30 && seina.getY() == 50 && seina.getKoko() == 10) {
                totuus = true;
            }
        }
        assertEquals(true, totuus);
    }

    @Test
    public void luoKenttaLisaaOikeanMaaranElementteja() {
        kr.getLista().clear();
        Kentanrakentaja kr2 = new Kentanrakentaja(kenttaelementit, koko);
        kr.luoKentta(koko);
        kr2.luoReunat(koko);
        kr2.lisaaKentalleLaatikot();
        kr2.lisaaKentalleSeinat();
        kr2.lisaaMaali(1, 2, 3);
        assertEquals(kenttaelementit.size(), kr2.getLista().size());
    }

    @Test
    public void luoKenttaKutsuuNeljaaMuutaMetodiaJotkaLisaaEriElementteja() {
        int laskuri = 0;
        kr.getLista().clear();
        kr.luoKentta(koko);
        for (Elementti elem : kenttaelementit) {
            if (elem.getX() == 0 * koko && elem.getY() == 7 * koko && elem.getId() == "seina") {
                laskuri++;
            } else if (elem.getX() == 9 * koko && elem.getY() == 3 * koko && elem.getId() == "seina") {
                laskuri++;
            } else if (elem.getX() == 10 * koko && elem.getY() == 5 * koko && elem.getId() == "laatikko") {
                laskuri++;
            } else if (elem.getX() == 1 * koko && elem.getY() == 12 * koko && elem.getId() == "maali") {
                laskuri++;
            }
        }
        assertEquals(laskuri, 4);
    }

    @Test
    public void luoReunatLisaaReunojenVerranSeinia() {
        kr.getLista().clear();
        kr.luoReunat(koko);
        assertEquals(kenttaelementit.size(), 56);
    }

    @Test
    public void lisaaKentalleSeinatLisaaOikeanMaaranSeinia() {
        kr.lisaaKentalleSeinat();
        assertEquals(kenttaelementit.size(), 63);
    }

    @Test
    public void lisaaKentalleLaatikotLisaaOikeanMaaranLaatikoita() {
        kr.lisaaKentalleLaatikot();
        assertEquals(kenttaelementit.size(), 31);
    }

    @Test
    public void lisaaMaaliToimii() {
        kr.lisaaMaali(1, 2, 3);
        boolean totuus = false;
        for (Elementti elem : kenttaelementit) {
            if (elem.getId() == "maali" && elem.getX() == koko && elem.getY() == 12 * koko && elem.getKoko() == koko) {
                totuus = true;
            }
        }
        assertEquals(true, totuus);
    }

    @Test
    public void kentallaEiOleElementtejaRajojenUlkopuolella() {
        boolean totuus = true;
        for (Elementti elem : kenttaelementit) {
            if (elem.getX() > 15 * koko || elem.getY() > 15 * koko) {
                totuus = false;
            }
        }
        assertEquals(true, totuus);
    }

}

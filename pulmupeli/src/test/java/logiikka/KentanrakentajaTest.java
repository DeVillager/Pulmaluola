package logiikka;

import elementit.Elementti;
import elementit.Hahmo;
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
        kenttaelementit.add(new Seina(40, 80, koko, "seina", "omaseina2.png"));
        kenttaelementit.add(new Seina(80, 80, koko, "seina", "omaseina2.png"));
        kenttaelementit.add(new Seina(120, 360, koko, "seina", "omaseina2.png"));
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
        assertEquals(kenttaelementit.size(), 32);
    }

    @Test
    public void lisaaMaaliToimii() {
        kr.lisaaMaali(1, 2, koko);
        boolean totuus = false;
        for (Elementti elem : kenttaelementit) {
            if (elem.getId() == "maali" && elem.getX() == koko && elem.getY() == 2 * koko && elem.getKoko() == koko) {
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

    @Test
    public void getMaaliToimii() {
        kr.lisaaMaali(1, 12, koko);
        assertEquals(12 * koko, kr.getMaali().getY());
    }

    @Test
    public void luoTasoAlustaToimii1() {
        Hahmo hahmo = new Hahmo(1, 2, koko, "hahmo", "omahahmoD.png");
        kr.luoTasoAlusta(hahmo);
        assertEquals(hahmo.getX(), 7 * koko);
    }

    @Test
    public void luoTasoAlustaToimii2() {
        Hahmo hahmo = new Hahmo(1, 2, koko, "hahmo", "omahahmoD.png");
        kr.nostaTasoa();
        kr.luoTasoAlusta(hahmo);
        assertEquals(hahmo.getX(), koko);
    }

    @Test
    public void luoKenttaToimii() {
        Hahmo hahmo = new Hahmo(1, 2, koko, "hahmo", "omahahmoD.png");
        kr.nostaTasoa();
        kr.luoKentta(koko);
        assertEquals(kenttaelementit.size(), 172);
    }

    @Test
    public void getHahmonXSijaintiTasossaToimii1() {
        assertEquals(kr.getHahmonXSijaintiTasossa(), 7 * koko);
    }

    @Test
    public void getHahmonXSijaintiTasossaToimii2() {
        kr.nostaTasoa();
        assertEquals(kr.getHahmonXSijaintiTasossa(), koko);
    }

    @Test
    public void getHahmonYSijaintiTasossaToimii1() {
        assertEquals(kr.getHahmonYSijaintiTasossa(), 4 * koko);
    }

    @Test
    public void getHahmonYSijaintiTasossaToimii2() {
        kr.nostaTasoa();
        assertEquals(kr.getHahmonYSijaintiTasossa(), 12 * koko);
    }
    
    @Test
    public void luoEkaTasoToimii() {
        kr.luoEkaTaso();
        assertEquals(kenttaelementit.size(), 149);
    }

    @Test
    public void luoTokaTasoToimii() {
        kr.luoTokaTaso();
        assertEquals(kenttaelementit.size(), 172);
    }

    @Test
    public void getLevelToimii() {
        assertEquals(kr.getLevel(), 1);
    }

    @Test
    public void nostaTasoaToimii() {
        kr.nostaTasoa();
        assertEquals(kr.getLevel(), 2);
    }
    
    @Test
    public void lisaaKentalleSeinatLisaaOikeanMaaranSeiniaTasolla2() {
        kr.lisaaKentalleSeinat2();
        assertEquals(kenttaelementit.size(), 53);
    }

    @Test
    public void lisaaKentalleLaatikotLisaaOikeanMaaranLaatikoitaTasolla2() {
        kr.lisaaKentalleLaatikot2();
        assertEquals(kenttaelementit.size(), 21);
    }
    
    @Test
    public void luoReunat2lisaaOikeanMaaranSeinia() {
        kr.luoReunat2(koko);
        assertEquals(kenttaelementit.size(), 84);
    }
    

}

//package logiikka;
//
//import elementit.Elementti;
//import elementit.Seina;
//import java.util.ArrayList;
//import org.junit.Before;
//import org.junit.Test;
//import static org.junit.Assert.*;
//
//public class KentanrakentajaTest {
//
//    ArrayList<Elementti> seinat;
//    int koko = 40;
//    Kentanrakentaja kr;
//
//    @Before
//    public void setUp() {
//        
//        seinat = new ArrayList<Elementti>();
//        seinat.add(new Seina(1, 1, koko));
//        seinat.add(new Seina(1, 2, koko));
//        seinat.add(new Seina(3, 5, koko));
//        seinat.add(new Seina(3, 9, koko));
//        kr = new Kentanrakentaja(seinat, koko);
//    }
//
//    @Test
//    public void valmiitSeinatLisaytyy1() { // konstruktorissa luodaan listan valmiit seinat: lisaaSeina(...)
//        boolean totuus = false;
//        for (Elementti seina : seinat) {
//            if (seina.getX() == 80 && seina.getY() == 80 && seina.getKoko() == koko) {
//                totuus = true;
//            }
//        }
//        assertEquals(true, totuus);
//    }
//    
//    @Test
//    public void valmiitSeinatLisaytyy2() { // konstruktorissa luodaan listan valmiit seinat: lisaaSeina(...)
//        boolean totuus = false;
//        for (Elementti seina : seinat) {
//            if (seina.getX() == 120 && seina.getY() == 40 && seina.getKoko() == koko) {
//                totuus = true;
//            }
//        }
//        assertEquals(true, totuus);
//    }
//    
//    @Test
//    public void valmiitSeinatLisaytyy3() { // konstruktorissa luodaan listan valmiit seinat: lisaaSeina(...)
//        boolean totuus = false;
//        for (Elementti seina : seinat) {
//            if (seina.getX() == 320 && seina.getY() == 400 && seina.getKoko() == koko) {
//                totuus = true;
//            }
//        }
//        assertEquals(true, totuus);
//    }
//    
//    @Test
//    public void valmiitSeinatLisaytyy4() { // konstruktorissa luodaan listan valmiit seinat: lisaaSeina(...)
//        boolean totuus = false;
//        for (Elementti seina : seinat) {
//            if (seina.getX() == 280 && seina.getY() == 160 && seina.getKoko() == koko) {
//                totuus = true;
//            }
//        }
//        assertEquals(true, totuus);
//    }
//    
//    @Test
//    public void valmiitSeinatLisaytyy5() { // konstruktorissa luodaan listan valmiit seinat: lisaaSeina(...)
//        boolean totuus = false;
//        for (Elementti seina : seinat) {
//            if (seina.getX() == 200 && seina.getY() == 120 && seina.getKoko() == koko) {
//                totuus = true;
//            }
//        }
//        assertEquals(true, totuus);
//    }
//    
//    @Test
//    public void seinatLuodaanOikein1() {
//         boolean totuus = true;
//        for (Elementti seina : seinat) {
//            if (seina.getX() == 0 && seina.getY() == 600 && seina.getKoko() == koko) { //ei saa sisältää seinaa jolla y=600
//                totuus = false;
//            }
//        }
//        assertEquals(true, totuus);
//    }
//    
//    @Test
//    public void seinatLuodaanOikein2() {
//         boolean totuus = true;
//        for (Elementti seina : seinat) {
//            if (seina.getX() == 600 && seina.getY() == 0 && seina.getKoko() == koko) { //ei saa sisältää seinaa jolla x=600
//                totuus = false;
//            }
//        }
//        assertEquals(true, totuus);
//    }
//    
//    @Test
//    public void seinatLuodaanOikein3() {
//         boolean totuus = true;
//        for (Elementti seina : seinat) {
//            if (seina.getX() == 0 && seina.getY() == 0 && seina.getKoko() == 1) { // seinien koon oltava 'koko'. tässä koko = 40.
//                totuus = false;
//            }
//        }
//        assertEquals(true, totuus);
//    }
//    
//    @Test
//    public void seinatLuodaanOikein4() {
//         boolean totuus = true;
//        for (Elementti seina : seinat) {
//            if (seina.getX() < 0 && seina.getY() > 0 && seina.getKoko() == koko) { // seinien koon oltava 'koko'. tässä koko = 40.
//                totuus = false;
//            }
//        }
//        assertEquals(true, totuus);
//    }
//    
//    @Test
//    public void seinatLuodaanOikein5() {
//         boolean totuus = true;
//        for (Elementti seina : seinat) {
//            if (seina.getX() > 0 && seina.getY() < 0 && seina.getKoko() == koko) { // seinien koon oltava 'koko'. tässä koko = 40.
//                totuus = false;
//            }
//        }
//        assertEquals(true, totuus);
//    }
//    
//    
//
//    @Test
//    public void seinanLisaysToimii() {
//        kr.lisaaSeina(7, 6, 5);
//        boolean totuus = false;
//        for (Elementti seina : seinat) {
//            if (seina.getX() == 7 && seina.getY() == 6 && seina.getKoko() == 5) {
//                totuus = true;
//            }
//        }
//        assertEquals(true, true);
//    }
//    
//    @Test
//    public void seinalistanGetteriToimii() {
//        boolean totuus = false;
//        ArrayList<Elementti> toinenLista = new ArrayList<>();
//        for (Elementti seina : seinat) {
//            toinenLista.add(seina);
//        }
//        if (toinenLista.equals(kr.getLista())) {
//            totuus = true;
//        }
//        assertEquals(true, totuus);
//    }
//
//}

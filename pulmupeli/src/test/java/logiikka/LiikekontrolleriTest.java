//package logiikka;
//
//import elementit.Elementti;
//import elementit.Hahmo;
//import elementit.Maali;
//import elementit.Seina;
//import java.util.ArrayList;
//import org.junit.Before;
//import org.junit.Test;
//import static org.junit.Assert.*;
//
//public class LiikekontrolleriTest {
//
//    Hahmo hahmo;
//    ArrayList<Elementti> elementit = new ArrayList<Elementti>();
//    Liikekontrolleri k;
//    Maali maali;
//
//    @Before
//    public void setUp() {
//        hahmo = new Hahmo(1, 1, 1);
//        maali = new Maali(1,1,1);
//        elementit = new ArrayList<>();
//        elementit.add(new Seina(2, 1, 9));
//        elementit.add(new Seina(1, 2, 9));
//        k = new Liikekontrolleri(hahmo, maali, elementit);
//    }
//
//    @Test
//    public void eiOtaMuitaKomentoja() {
//        assertEquals(true, k.tarkastaLiike(1));
//    }
//
//    @Test
//    public void tormaysTarkastusToimiiAlussa() {
//        assertEquals(k.tarkastaEihanTormaa(1), true);
//    }
//
//    @Test
//    public void tormaysTarkastusToimiiKunLiikuttuXSuunnassa() {
//        assertEquals(k.tarkastaEihanTormaa(39), false);
//    }
//
//    @Test
//    public void tormaysTarkastusToimiiKunLiikuttuYSuunnassa() {
//        assertEquals(k.tarkastaEihanTormaa(40), false);
//    }
//
//    @Test
//    public void tormaysTarkastusToimiiKunLiikuttuXSuunnassaHahmonKoonVerran() {
//        elementit.add(new Seina(hahmo.getX() + hahmo.getKoko(), hahmo.getY(), 9));
//        assertEquals(k.tarkastaEihanTormaa(39), false);
//    }
//
//    @Test
//    public void tormaysTarkastusToimiiKunLiikuttuYSuunnassaHahmonKoonVerran() {
//        elementit.add(new Seina(hahmo.getX(), hahmo.getY() + hahmo.getKoko(), 9));
//        assertEquals(k.tarkastaEihanTormaa(40), false);
//    }
//
//    @Test
//    public void hahmonKokoOikein() {
//        assertEquals(hahmo.getKoko(), 1);
//    }
//
//    @Test
//    public void hahmonKokoOikein1() {
//        assertEquals(true, true);
//    }
//
//}

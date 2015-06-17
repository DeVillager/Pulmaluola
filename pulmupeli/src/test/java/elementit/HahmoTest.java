package elementit;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class HahmoTest {
    
    Hahmo hahmo;
    
    @Before
    public void setUp() {
        hahmo = new Hahmo(120, 80, 40, "hahmo", "omahahmoD.png");
    }
    
    @Test
    public void getteriXToimii() {
        assertEquals(120, hahmo.getX());
    }
    
    @Test
    public void getteriYToimii() {
        assertEquals(80, hahmo.getY());
    }
    
    @Test
    public void getteriKokoToimii() {
        assertEquals(40, hahmo.getKoko());
    }
    
        @Test
    public void setteriXToimii() {
        hahmo.setX(4);
        assertEquals(4, hahmo.getX());
    }
    
    @Test
    public void setteriYToimii() {
        hahmo.setY(5);
        assertEquals(5, hahmo.getY());
    }
    
    @Test
    public void identiteettiOikein() {
        assertEquals(hahmo.getId(), "hahmo");
    }
    
    @Test
    public void siirtyminenXToimii() {
        hahmo.siirry(-80,0);
        assertEquals(40, hahmo.getX());
    }
    
    @Test
    public void siirtyminenYToimii() {
        hahmo.siirry(0, 80);
        assertEquals(160, hahmo.getY());
    }
    
    @Test
    public void setIdToimii() {
        hahmo.setId("uusiId");
        assertEquals(hahmo.getId(), "uusiId");
    }
    
    
    @Test
    public void setImageToimii() {
        hahmo.setImage("omahahmoU.png");
        assertEquals(hahmo.getImage(), "omahahmoU.png");
    }
    
    @Test
    public void asetaKuvaEiMuutaKuvaaJosVaaraNappain() {
        hahmo.asetaUusikuva(36);
        assertEquals(hahmo.getImage(), "omahahmoD.png");
    }
    
    @Test
    public void asetaKuvaVaihtaaOikeaanKuvaan1() {
        hahmo.asetaUusikuva(37);
        assertEquals(hahmo.getImage(), "omahahmoL.png");
    }
    
    @Test
    public void asetaKuvaVaihtaaOikeaanKuvaan2() {
        hahmo.asetaUusikuva(38);
        assertEquals(hahmo.getImage(), "omahahmoU.png");
    }
    
    @Test
    public void asetaKuvaVaihtaaOikeaanKuvaan3() {
        hahmo.asetaUusikuva(39);
        assertEquals(hahmo.getImage(), "omahahmoR.png");
    }
    
    @Test
    public void asetaKuvaVaihtaaOikeaanKuvaan4() {
        hahmo.asetaUusikuva(39);        
        hahmo.asetaUusikuva(40);
        assertEquals(hahmo.getImage(), "omahahmoD.png");
    }
    
    @Test
    public void asetaKuvaVaihtaaOikeaanKuvaan5() {
        hahmo.asetaUusikuva(82);        
        assertEquals(hahmo.getImage(), "omahahmoD.png");
    }
}

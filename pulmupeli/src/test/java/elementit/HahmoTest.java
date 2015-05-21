package elementit;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class HahmoTest {
    
    Hahmo hahmo;
    
    @Before
    public void setUp() {
        hahmo = new Hahmo(120, 80, 40);
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
    public void siirtyminenXToimii() {
        hahmo.siirry(-80,0);
        assertEquals(40, hahmo.getX());
    }
    
    @Test
    public void siirtyminenYToimii() {
        hahmo.siirry(0, 80);
        assertEquals(160, hahmo.getY());
    }
    
}

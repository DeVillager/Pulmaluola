package pulmupele;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import elementit.Hahmo;


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
    public void siirtyminenToimii() {
        hahmo.siirry(-80,0);
        assertEquals(40, hahmo.getX());
    }


}

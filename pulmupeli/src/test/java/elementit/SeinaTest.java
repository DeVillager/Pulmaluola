
package elementit;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class SeinaTest {

    private Seina seina;
    
    @Before
    public void setUp() {
        seina = new Seina(1,2,3);
    }
    
        @Test
    public void getteriXToimii() {
        assertEquals(1, seina.getX());
    }
    
    @Test
    public void getteriYToimii() {
        assertEquals(2, seina.getY());
    }
    
    @Test
    public void getteriKokoToimii() {
        assertEquals(3, seina.getKoko());
    }
    
    @Test
    public void setteriXToimii() {
        seina.setX(4);
        assertEquals(4, seina.getX());
    }
    
    @Test
    public void setteriYToimii() {
        seina.setY(5);
        assertEquals(5, seina.getY());
    }
    
        @Test
    public void identiteettiOikein() {
        assertEquals(seina.getId(), "seina");
    }
    

}

package elementit;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class LaatikkoTest {

    Laatikko laatikko;

    @Before
    public void setUp() {
        laatikko = new Laatikko(10, 20, 30);
    }

    @Test
    public void getteriXToimii() {
        assertEquals(10, laatikko.getX());
    }

    @Test
    public void getteriYToimii() {
        assertEquals(20, laatikko.getY());
    }

    @Test
    public void getteriKokoToimii() {
        assertEquals(30, laatikko.getKoko());
    }
    
    @Test
    public void identiteettiOikein() {
        assertEquals(laatikko.getId(), "laatikko");
    }
    
    
}

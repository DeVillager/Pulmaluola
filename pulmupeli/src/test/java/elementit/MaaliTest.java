package elementit;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class MaaliTest {

    Maali maali;

    @Before
    public void setUp() {
        maali = new Maali(40, 50, 60);
    }

    @Test
    public void getteriXToimii() {
        assertEquals(40, maali.getX());
    }

    @Test
    public void getteriYToimii() {
        assertEquals(50, maali.getY());
    }

    @Test
    public void getteriKokoToimii() {
        assertEquals(60, maali.getKoko());
    }

    @Test
    public void identiteettiOikein() {
        assertEquals(maali.getId(), "maali");
    }

}

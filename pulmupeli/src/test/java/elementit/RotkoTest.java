package elementit;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class RotkoTest {

    Rotko rotko;

    @Before
    public void setUp() {
        rotko = new Rotko(76, 93, 4);
    }

    @Test
    public void getteriXToimii() {
        assertEquals(76, rotko.getX());
    }

    @Test
    public void getteriYToimii() {
        assertEquals(93, rotko.getY());
    }

    @Test
    public void getteriKokoToimii() {
        assertEquals(4, rotko.getKoko());
    }

    @Test
    public void setteriXToimii() {
        rotko.setX(4);
        assertEquals(4, rotko.getX());
    }

    @Test
    public void setteriYToimii() {
        rotko.setY(5);
        assertEquals(5, rotko.getY());
    }

    @Test
    public void identiteettiOikein() {
        assertEquals(rotko.getId(), "rotko");
    }
    
    @Test
    public void setIdToimii() {
        rotko.setId("uusiId");
        assertEquals(rotko.getId(), "uusiId");
    }
    
    @Test
    public void getImageToimii() {
//        rotko.setImage("");
        assertEquals(rotko.getImage(), "omarotko.png");
    }
    
    @Test
    public void setImageToimii() {
        rotko.setImage("omahahmoD.png");
        assertEquals(rotko.getImage(), "omahahmoD.png");
    }


    
    
    
    

}
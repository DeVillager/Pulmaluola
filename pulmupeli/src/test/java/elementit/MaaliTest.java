package elementit;

import java.util.Scanner;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class MaaliTest {

    Maali maali;

    @Before
    public void setUp() {
        maali = new Maali(40, 50, 60, "maali", "omatportaat2.png");
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
    public void setteriXToimii() {
        maali.setX(4);
        assertEquals(4, maali.getX());
    }

    @Test
    public void setteriYToimii() {
        maali.setY(5);
        assertEquals(5, maali.getY());
    }

    @Test
    public void identiteettiOikein() {
        assertEquals(maali.getId(), "maali");
    }

    @Test
    public void setIdToimii() {
        maali.setId("uusiId");
        assertEquals(maali.getId(), "uusiId");
    }

    @Test
    public void setImageToimii() {
        maali.setImage("omatportaat.png");
        assertEquals(maali.getImage(), "omatportaat.png");
    }

}

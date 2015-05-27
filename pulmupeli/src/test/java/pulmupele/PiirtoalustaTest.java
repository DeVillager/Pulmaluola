package pulmupele;

import elementit.Elementti;
import elementit.Hahmo;
import elementit.Seina;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PiirtoalustaTest extends JPanel {

    Hahmo hahmo;
    ArrayList<Elementti> elementit;
    Piirtoalusta pa;
    Graphics g;

    @Before
    public void setUp() {
        super.setBackground(Color.WHITE);
        hahmo = new Hahmo(1, 1, 1);
        elementit = new ArrayList<>();
        elementit.add(new Seina(2, 1, 9));
        elementit.add(new Seina(1, 2, 9));
        pa = new Piirtoalusta(hahmo, elementit);
        
    }

//    @Test
//    public void paintToimii() {
//        super.paintComponent(g);
//        
//
//    }

}

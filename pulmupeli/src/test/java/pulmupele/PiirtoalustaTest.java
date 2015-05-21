package pulmupele;

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
    ArrayList<Seina> seinat;
    Piirtoalusta pa;
    Graphics g;

    @Before
    public void setUp() {
        super.setBackground(Color.WHITE);
        hahmo = new Hahmo(1, 1, 1);
        seinat = new ArrayList<>();
        seinat.add(new Seina(2, 1, 9));
        seinat.add(new Seina(1, 2, 9));
        pa = new Piirtoalusta(hahmo, seinat);
        
    }

//    @Test
//    public void paintToimii() {
//        super.paintComponent(g);
//        
//
//    }

}

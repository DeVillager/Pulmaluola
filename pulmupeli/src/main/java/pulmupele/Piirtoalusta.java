package pulmupele;

import elementit.Elementti;
import elementit.Seina;
import elementit.Hahmo;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;

public class Piirtoalusta extends JPanel {
    
    private Hahmo hahmo;
    private ArrayList<Elementti> kenttalista;

    public Piirtoalusta(Hahmo hahmo, ArrayList<Elementti> lista) {
        super.setBackground(Color.BLACK);
        this.hahmo = hahmo;
        this.kenttalista = lista;
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        
        for (Elementti kenttaelementti : kenttalista) { // paranna niin etta seinat piirretaan vain kerran!!
//            if (kenttaelementti.getId() == "seina") {
                kenttaelementti.piirra(graphics);
////                kenttalista.remove(kenttaelementti);
//            }
            
        }
        hahmo.piirra(graphics);
    }

}

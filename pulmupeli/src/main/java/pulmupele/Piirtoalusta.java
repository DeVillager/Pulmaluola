package pulmupele;

import elementit.Elementti;
import elementit.Seina;
import elementit.Hahmo;
import elementit.Maali;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;

public class Piirtoalusta extends JPanel {
    
    private Hahmo hahmo;
    private Maali maali;
    private ArrayList<Elementti> kenttalista;

    public Piirtoalusta(Hahmo hahmo, Maali maali, ArrayList<Elementti> lista) {
        super.setBackground(Color.BLACK);
        this.hahmo = hahmo;
        this.maali = maali;
        this.kenttalista = lista;
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);     
        for (Elementti kenttaelementti : kenttalista) { // paranna niin etta seinat piirretaan vain kerran!!
                kenttaelementti.piirra(graphics);
        }
//        maali.piirra(graphics);
        hahmo.piirra(graphics);
    }
    
    public ArrayList<Elementti> getLista() {
        return this.kenttalista;
    }

}

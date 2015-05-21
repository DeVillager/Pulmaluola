package pulmupele;

import elementit.Seina;
import elementit.Hahmo;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;

public class Piirtoalusta extends JPanel {
    
    private Hahmo hahmo;
    private ArrayList<Seina> lista;

    public Piirtoalusta(Hahmo hahmo, ArrayList<Seina> lista) {
        super.setBackground(Color.WHITE);
        this.hahmo = hahmo;
        this.lista = lista;
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        
        for (Seina seina : lista) {
            seina.piirra(graphics);
        }
         graphics.setColor(Color.RED);
        hahmo.piirra(graphics);
    }

}

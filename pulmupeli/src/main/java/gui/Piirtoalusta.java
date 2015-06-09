package gui;

import elementit.Elementti;
import elementit.Hahmo;
import elementit.Maali;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 * Piirtää pelin elementit
 */
public class Piirtoalusta extends JPanel {

    private Hahmo hahmo;
    private Maali maali;
    private ArrayList<Elementti> kenttalista;

    /**
     * Luo Piirtoalusta-olion, joka tuntee pelin hahmon, maalin sekä
     * kenttälistan
     *
     * @param hahmo Pelaajan liikuteltava hahmo
     * @param maali Ruutu, johon hahmo pitää saada
     * @param lista Lista kentällä olevista elementeistä
     */
    public Piirtoalusta(Hahmo hahmo, Maali maali, ArrayList<Elementti> lista) {
        super.setBackground(Color.BLACK);
        this.hahmo = hahmo;
        this.maali = maali;
        this.kenttalista = lista;
    }

    /**
     * Piirtää JFramen komponentteja
     *
     * @param graphics Olio, joka piirtää grafiikat
     */
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
//        for (Elementti kenttaelementti : kenttalista) {
//            if (kenttaelementti.getId().equals("ruoho")) {
//                kenttaelementti.piirra(graphics);
//            }
//        }
        for (Elementti kenttaelementti : kenttalista) {
            if (!kenttaelementti.getId().equals("laatikko")) {
                kenttaelementti.piirra(graphics);
            }
        }
        for (Elementti kenttaelementti : kenttalista) {
            if (kenttaelementti.getId().equals("laatikko")) {
                kenttaelementti.piirra(graphics);
            }
        }
        maali.piirra(graphics);
        hahmo.piirra(graphics);
    }

    public ArrayList<Elementti> getLista() {
        return this.kenttalista;
    }

    public void setMaali(Maali maali) {
        this.maali = maali;
    }

}

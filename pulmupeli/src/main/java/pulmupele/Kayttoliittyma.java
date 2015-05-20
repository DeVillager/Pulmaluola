package pulmupele;

import logiikka.Seinienrakentaja;
import logiikka.Nappaimistonkuuntelija;
import logiikka.Liikekontrolleri;
import logiikka.Piirtoalusta;
import elementit.Seina;
import elementit.Hahmo;
import java.awt.Container;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import logiikka.Peli;

public class Kayttoliittyma implements Runnable {

    private JFrame frame;
    private Hahmo hahmo;
    private ArrayList<Seina> lista;
    private Peli peli;

    public Kayttoliittyma(Hahmo hahmo, ArrayList<Seina> lista) {
        this.hahmo = hahmo;
        this.lista = lista;
    }


    @Override
    public void run() {
        frame = new JFrame("Pulmapeli");
        frame.setPreferredSize(new Dimension (640, 640));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        luoKomponentit(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        Seinienrakentaja rakentaja = new Seinienrakentaja(lista, hahmo.getKoko());   
        this.lista = rakentaja.getSeinat(); //luodaan lista, jossa on Seinaolioita
        Piirtoalusta piirtoalusta = new Piirtoalusta(hahmo, lista);
        Liikekontrolleri tarkastaja = new Liikekontrolleri(hahmo, lista);
        container.add(piirtoalusta);
        frame.addKeyListener(new Nappaimistonkuuntelija(hahmo, piirtoalusta, tarkastaja));
    }

    public JFrame getFrame() {
        return frame;
    }
}

package pulmupele;

import elementit.Elementti;
import logiikka.Kentanrakentaja;
import logiikka.Liikekontrolleri;
import elementit.Hahmo;
import elementit.Maali;
import grafiikka.Kuva;
import java.awt.Container;
import java.awt.Dimension;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.WindowConstants;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Kayttoliittyma implements Runnable {

    private JFrame frame;
    private Hahmo hahmo;
    private ArrayList<Elementti> kenttalista;
    private int koko;

    public Kayttoliittyma() {
        this.koko = 40;
        this.hahmo = new Hahmo(7*koko, 4*koko, koko);
        this.kenttalista = new ArrayList<Elementti>();
    }

    @Override
    public void run() {
        Soitin soitin = new Soitin("C:\\sky.wav");
        frame = new JFrame("Pulmapeli");
        frame.setPreferredSize(new Dimension(616, 638));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        luoKomponentit(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {

        Kentanrakentaja rakentaja = new Kentanrakentaja(kenttalista, koko);
        rakentaja.luoKentta(koko); // tÃ¤ssÃ¤ luodaan kaikki objektit kentÃ¤lle
        this.kenttalista = rakentaja.getSeinat();
        this.kenttalista.add(new Maali(40, 12*40, koko));

        Piirtoalusta piirtoalusta = new Piirtoalusta(hahmo, kenttalista);
        Liikekontrolleri tarkastaja = new Liikekontrolleri(hahmo, kenttalista);
        container.add(piirtoalusta);

        frame.addKeyListener(new Nappaimistonkuuntelija(hahmo, piirtoalusta, tarkastaja));
    }

    public JFrame getFrame() {
        return frame;
    }
}

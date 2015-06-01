package logiikka;

import elementit.Elementti;
import elementit.Hahmo;
import elementit.Maali;
import java.awt.Container;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import gui.Nappaimistonkuuntelija;
import gui.Piirtoalusta;
import gui.Valikkokuuntelija;
import java.awt.Adjustable;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
//import pulmupele.Soitin;

public class Peli {

    private JFrame pelinFrame;
    private Hahmo hahmo;
    private ArrayList<Elementti> kenttalista;
    private int skaala;
    private Kentanrakentaja rakentaja;
    private Maali maali;
    private JFrame valikko;

    public Peli(int koko) {
        this.skaala = koko;
        this.hahmo = new Hahmo(7 * koko, 4 * koko, koko);
        this.maali = new Maali(koko, 12 * koko, koko);
        this.kenttalista = new ArrayList<Elementti>();
        this.rakentaja = new Kentanrakentaja(kenttalista, koko);
    }

    public void kaynnistaValikko() {
        valikko = new JFrame("Valikko");
        valikko.setPreferredSize(new Dimension(10 * skaala, 15 * skaala));
        valikko.setLocation(480, 80);
        valikko.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        luoValikkoKomponentit(valikko.getContentPane());
        valikko.pack();
        valikko.setVisible(true);
    }

    public void luoIkkuna() {
        pelinFrame = new JFrame("Pulmapeli");
        pelinFrame.setPreferredSize(new Dimension(616, 638));
        pelinFrame.setLocation(400, 40);
        pelinFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        luoKomponentit(pelinFrame.getContentPane());
        luoGrafiikat(pelinFrame.getContentPane());
        pelinFrame.pack();
        pelinFrame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        rakentaja.luoKentta(skaala);
    }

    public void luoGrafiikat(Container container) {
        Piirtoalusta piirtoalusta = new Piirtoalusta(hahmo, maali, kenttalista);
        Liikekontrolleri tarkastaja = new Liikekontrolleri(hahmo, maali, kenttalista);
        container.add(piirtoalusta);
        pelinFrame.addKeyListener(new Nappaimistonkuuntelija(hahmo, piirtoalusta, tarkastaja, this));
    }

    public JFrame getPelinFrame() {
        return this.pelinFrame;
    }

    public JFrame getValikonFrame() {
        return this.valikko;
    }

    public ArrayList<Elementti> getLista() {
        return this.kenttalista;
    }

    public Kentanrakentaja getRakentaja() {
        return this.rakentaja;
    }

    public Maali getMaali() {
        return this.maali;
    }

    public void luoValikkoKomponentit(Container container) {
        container.setLayout(new GridLayout(2, 1));
        JButton aloitaPeli = new JButton("Aloita peli");
        JButton lopetaPeli = new JButton("Lopeta");
        Valikkokuuntelija valikonKuuntelija = new Valikkokuuntelija(this, aloitaPeli, lopetaPeli);
        aloitaPeli.addActionListener(valikonKuuntelija);
        lopetaPeli.addActionListener(valikonKuuntelija);
//        container.add(new JLabel("Löydä tie maaliin.\nLiikuta hahmoa nuolinäppäimillä ja aloita alusta R-näppäimellä.\nKiviä voi työntää liikkumalla niitä kohti."));
        container.add(aloitaPeli);
        container.add(lopetaPeli);
    }

    public void luoVoittoIkkuna() {
        JFrame voittoIkkuna = new JFrame("Taso läpäisty");
        voittoIkkuna.setPreferredSize(new Dimension(616, 638));
        voittoIkkuna.setLocation(400, 40);
        voittoIkkuna.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        voittoIkkuna.getContentPane().setLayout(new GridBagLayout());
        voittoIkkuna.getContentPane().add(new JLabel("Voitit pelin!!!"));
        voittoIkkuna.pack();
        voittoIkkuna.setVisible(true);
    }

}

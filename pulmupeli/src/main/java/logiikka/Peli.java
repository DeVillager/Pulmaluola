package logiikka;

import elementit.Elementti;
import elementit.Hahmo;
import elementit.Maali;
import java.awt.Container;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
//import pulmupele.Kayttoliittyma;
import pulmupele.Nappaimistonkuuntelija;
import pulmupele.Piirtoalusta;
//import pulmupele.Soitin;

public class Peli {

    private JFrame frame;
    private Hahmo hahmo;
    private ArrayList<Elementti> kenttalista;
    private int koko;
    private Kentanrakentaja rakentaja;
    private Maali maali;
//    private Kayttoliittyma kl;

    public Peli() {
//        this.kl = kl;
        this.koko = 40;
        this.hahmo = new Hahmo(7 * koko, 4 * koko, koko);
        this.maali = new Maali(koko, 12*koko, koko);
        this.kenttalista = new ArrayList<Elementti>();
        this.rakentaja = new Kentanrakentaja(kenttalista, koko);
    }
    
//    public Kayttoliittyma getKL() {
//        return kl;
//    }

    public void luoIkkuna() {
        
//        Soitin soitin = new Soitin("C:\\Pulmaluola\\pulmupeli\\src\\main\\java\\Tiedostot\\sky.wav");
        System.out.println("Löydä tie vihreään maaliin.\nLiikuta punaista hahmoa nuolinäppäimillä ja aloita alusta R-näppäimellä.\nSinisiä palloja voi työntää liikkumalla niitä kohti.");
        frame = new JFrame("Pulmapeli");
        frame.setPreferredSize(new Dimension(616, 638));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        luoKomponentit(frame.getContentPane());
        luoGrafiikat(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        
        rakentaja.luoKentta(koko); // tÃ¤ssÃ¤ luodaan kaikki objektit kentÃ¤lle
//        this.kenttalista = rakentaja.getLista();
//        this.kenttalista.add(this.maali);
    }

    public void luoGrafiikat(Container container) {
        Piirtoalusta piirtoalusta = new Piirtoalusta(hahmo, maali, kenttalista);
        Liikekontrolleri tarkastaja = new Liikekontrolleri(hahmo, maali, kenttalista);
        container.add(piirtoalusta);
        frame.addKeyListener(new Nappaimistonkuuntelija(hahmo, piirtoalusta, tarkastaja, this));
    }

    public JFrame getJframe() {
        return this.frame;
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

}

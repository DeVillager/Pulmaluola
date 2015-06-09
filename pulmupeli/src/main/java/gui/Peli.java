package gui;

import elementit.Elementti;
import elementit.Hahmo;
import elementit.Maali;
import gui.IkkunanPiirtaja;
import java.awt.Container;
import java.util.ArrayList;
import javax.swing.JFrame;
import gui.Nappaimistonkuuntelija;
import gui.Piirtoalusta;
import logiikka.Kentanrakentaja;
import logiikka.Liikekontrolleri;
//import pulmupele.Soitin;

public class Peli {

    private JFrame pelinFrame;
    private Hahmo hahmo;
    private ArrayList<Elementti> kenttalista;
    private int skaala;
    private Kentanrakentaja rakentaja;
    private Maali maali;
    private JFrame valikko;
    private IkkunanPiirtaja ip;
    private Piirtoalusta pa;
//    private Soitin soitin;
    
    /**
     * Luo Peli-olion, jolla on skaala. Luo attribuuteiksi hahmon, maalin, kenttalistan, kentanrakentajan ja ikkunanpiirtäjän.
     * @param koko Pelin yhden ruudun koko pikseleinä
     */
    public Peli(int koko) {
        this.skaala = koko;
        this.hahmo = new Hahmo(0, 0, koko);
//        this.maali = new Maali(koko, 12 * koko, koko);
        this.kenttalista = new ArrayList<Elementti>();
        this.rakentaja = new Kentanrakentaja(kenttalista, koko);
        this.hahmo.setX(rakentaja.getHahmonXSijaintiTasossa());
        this.hahmo.setY(rakentaja.getHahmonYSijaintiTasossa());
        
        this.ip = new IkkunanPiirtaja(this, skaala);
//        soitin.
    }
    
    /**
     * Käynnistää pelin ja kutsuu ikkunanpiirtajan kaynnistaValikko()-metodia
     */
    public void kaynnista() {
        
        this.ip.kaynnistaValikko();
    }
    
    /**
     * Kutsuu kentanrakentajan luoKentta oliota, jossa on parametrina skaala
     */
    public void luoKentalleKaikkiKomponentit() {
        rakentaja.luoKentta(skaala);
    }
    
    /**
     * Luo pelin grafiikoiden piirtamiseen vaadittavat oliot, jotka piirtävät pelin grafiikat.
     * @param container Sisältää JFramen komponentteja
     */
    public void luoGrafiikat(Container container) {
        this.pa = new Piirtoalusta(hahmo, rakentaja.getMaali(), kenttalista);
        Liikekontrolleri tarkastaja = new Liikekontrolleri(hahmo, rakentaja.getMaali(), kenttalista);
        container.add(pa);
        this.ip.getPelinFrame().addKeyListener(new Nappaimistonkuuntelija(hahmo, pa, tarkastaja, this));
    }

    public IkkunanPiirtaja getIkkunanPiirtaja() {
        return this.ip;
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
    
    public Piirtoalusta getPA() {
        return this.pa;
    }

}

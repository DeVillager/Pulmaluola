/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import elementit.Elementti;
import elementit.Hahmo;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import logiikka.Liikekontrolleri;

/**
 * Luokka kuuntelee näppäimistöltä tulevia syötteitä ja toimii niiden mukaan.
 */
public class Nappaimistonkuuntelija implements KeyListener {

    private Hahmo hahmo;
    private Piirtoalusta component;
    private Liikekontrolleri tarkastaja;
    private Peli peli;

    /**
     * Luo Nappaimistokuuntelija-olion, joka tuntee pelin, hahmon, piirtoalustan
     * ja liikekontrollerin
     *
     * @param hahmo Pelaajan hahmo
     * @param piirtoalusta Komponentti, joka suorittaa elementtien piirtämiset
     * @param tarkastaja Olio, joka tarkastaa onko liike sallittu
     * @param peli Olio, joka suorittaa pelin tapahtumia
     */
    public Nappaimistonkuuntelija(Hahmo hahmo, Piirtoalusta piirtoalusta, Liikekontrolleri tarkastaja, Peli peli) {
        this.hahmo = hahmo;
        this.component = piirtoalusta;
        this.tarkastaja = tarkastaja;
        this.peli = peli;
    }

    /**
     * Metodi pyytää liikekontrolleria tarkastamaan liikkeen, jonka jälkeen voi
     * pyytää hahmoa siirtymään. Tarkastaa myös onko hahmo jo maalissa.
     *
     * @param e Näppäimistöltä painetun napin tapahtuma
     */
    @Override
    public void keyPressed(KeyEvent e) {
//        System.out.println(e.getKeyCode());
        hahmo.asetaUusikuva(e.getKeyCode());
        siirraHahmoaJosVoi(e);

        component.repaint();
        
        if (tarkastaja.tarkastaOnkoMaalissa(peli)) {
            hahmo.asetaUusikuva(40);
            peli.getRakentaja().luoSeuraavaTaso(peli);
        }

        if (tarkastaja.tarkastaPutoaakoRotkoon()) {
            hahmo.asetaUusikuva(40);
            peli.getRakentaja().luoTasoAlusta(peli.getHahmo());
        }
    }


    private void siirraHahmoaJosVoi(KeyEvent e) {
        if (tarkastaja.tarkastaLiike(e.getKeyCode())) {
            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                hahmo.siirry(-1 * hahmo.getKoko(), 0);
            } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                hahmo.siirry(hahmo.getKoko(), 0);
            } else if (e.getKeyCode() == KeyEvent.VK_UP) {
                hahmo.siirry(0, -1 * hahmo.getKoko());
            } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                hahmo.siirry(0, hahmo.getKoko());
            } else if (e.getKeyCode() == KeyEvent.VK_R) {
                this.peli.getLista().clear();
                peli.getRakentaja().luoKentta(hahmo.getKoko());
                hahmo.setX(peli.getRakentaja().getHahmonXSijaintiTasossa());
                hahmo.setY(peli.getRakentaja().getHahmonYSijaintiTasossa());
            }
        }
    }
    
    
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}

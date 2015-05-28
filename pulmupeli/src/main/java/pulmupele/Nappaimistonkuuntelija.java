/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pulmupele;

import logiikka.Liikekontrolleri;
import elementit.Hahmo;
import elementit.Maali;
import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import logiikka.Liikekontrolleri;
import logiikka.Peli;

public class Nappaimistonkuuntelija implements KeyListener {
    

    private Hahmo hahmo;
    private Piirtoalusta component;
    private Liikekontrolleri tarkastaja;
    private Maali maali;
//    private Peli peli;

    public Nappaimistonkuuntelija(Hahmo hahmo, Piirtoalusta piirtoalusta, Liikekontrolleri tarkastaja, Peli peli) {
        this.hahmo = hahmo;
        this.component = piirtoalusta;
        this.tarkastaja = tarkastaja;
//        this.peli = peli;
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println(e.getKeyCode());
        if (tarkastaja.tarkastaLiike(e.getKeyCode())) {
            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                hahmo.siirry(-1 * hahmo.getKoko(), 0);
            } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                hahmo.siirry(hahmo.getKoko(), 0);
            } else if (e.getKeyCode() == KeyEvent.VK_UP) {
                hahmo.siirry(0, -1 * hahmo.getKoko());
            } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                hahmo.siirry(0, hahmo.getKoko());
//            } else if (e.getKeyCode() == KeyEvent.VK_R) {
////                this.component.getLista();
////                Peli peli2 = new Peli();
////                peli2.luoIkkuna();
////                peli.getLista().clear();
////                peli.getRakentaja().luoKentta(hahmo.getKoko());
////                hahmo.setX(7*hahmo.getKoko());
////                hahmo.setY(4*hahmo.getKoko());
//                
            }
        }
        component.repaint();
        if (hahmo.getX() == maali.getX() && hahmo.getY() == maali.getY()) {
            System.out.println("VOITIT!");
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}

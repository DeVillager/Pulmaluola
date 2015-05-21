/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pulmupele;

import logiikka.Liikekontrolleri;
import elementit.Hahmo;
import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import logiikka.Liikekontrolleri;

public class Nappaimistonkuuntelija implements KeyListener {

    private Hahmo hahmo;
    private Component component;
    private Liikekontrolleri tarkastaja;

    public Nappaimistonkuuntelija(Hahmo hahmo, Component component, Liikekontrolleri tarkastaja) {
        this.hahmo = hahmo;
        this.component = component;
        this.tarkastaja = tarkastaja;
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
            }
        }
        component.repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}
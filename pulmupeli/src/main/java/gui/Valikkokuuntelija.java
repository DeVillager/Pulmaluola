package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import logiikka.Peli;

public class Valikkokuuntelija implements ActionListener {

    private Peli peli;
    private final JButton aloitusNappi;
    private final JButton lopetusNappi;

    public Valikkokuuntelija(Peli peli, JButton aloitusNappi, JButton lopetusNappi) {
        this.peli = peli;
        this.aloitusNappi = aloitusNappi;
        this.lopetusNappi = lopetusNappi;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == aloitusNappi) {
            peli.luoIkkuna();
            peli.getValikonFrame().dispose();
        }
        if (e.getSource() == lopetusNappi) {
            peli.getValikonFrame().dispose();
        }
    }

}

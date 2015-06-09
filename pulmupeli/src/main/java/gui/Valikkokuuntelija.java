package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 * Luokka kuuntelee aloitusNappi ja lopetusNappi -JButton-olioita ja toimii annetusti
 */
public class Valikkokuuntelija implements ActionListener {

    private IkkunanPiirtaja ip;
    private JButton aloitusNappi;
    private JButton lopetusNappi;
    private JButton ohjeet;
//    private JButton ok;
    
    /**
     * Luo Valikkokuuntelija-olion, joka saa parametreinään Ikkunanpiirtajan, ja kaksi JButtonia
     * @param ip Pelin ikkunanpiirtaja, joka luo JFrame-olioita
     * @param aloitusNappi Ikkunanpiirtajan luoman JFramen "Valikko" sisältämä JButton
     * @param lopetusNappi Ikkunanpiirtajan luoman JFramen "Valikko" sisältämä JButton
     * @param ohjeet
     */
    public Valikkokuuntelija(IkkunanPiirtaja ip, JButton aloitusNappi, JButton lopetusNappi, JButton ohjeet) {
        this.ip = ip;
        this.aloitusNappi = aloitusNappi;
        this.lopetusNappi = lopetusNappi;
        this.ohjeet = ohjeet;
    }

    /**
     * Avaa peli-ikkunan, jos pelaaja painoi aloitusNappia. Sulkee ohjelman, jos pelaaja painoi lopetusNappia.
     * @param e Painalluksen tapahtuma
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == aloitusNappi) {
           ip.getValikonFrame().dispose();
            ip.luoPeliIkkuna();
        }
        if (e.getSource() == lopetusNappi) {
            ip.getValikonFrame().dispose();
        }
        if (e.getSource() == ohjeet) {
            ip.luoOhjeIkkuna();
        }
        
    }

}

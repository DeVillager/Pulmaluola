package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class OkKuuntelija implements ActionListener {

    private IkkunanPiirtaja ip;
    private JButton ok;
    
    /**
     * Luo Valikkokuuntelija-olion, joka saa parametreinään Ikkunanpiirtajan, ja kaksi JButtonia
     * @param ip Pelin ikkunanpiirtaja, joka luo JFrame-olioita
     * @param ok Ikkunanpiirtajan luoman JFramen "Ohjeet" sisältämä JButton
     */
    public OkKuuntelija(IkkunanPiirtaja ip, JButton ok) {
        this.ip = ip;
        this.ok = ok;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == ok) {
            ip.getOhjeIkkuna().dispose();
        }
    }
}

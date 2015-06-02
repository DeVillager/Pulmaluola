package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;

public class Valikkokuuntelija implements ActionListener {

    private IkkunanPiirtaja ip;
    private final JButton aloitusNappi;
    private final JButton lopetusNappi;

    public Valikkokuuntelija(IkkunanPiirtaja ip, JButton aloitusNappi, JButton lopetusNappi) {
        this.ip = ip;
        this.aloitusNappi = aloitusNappi;
        this.lopetusNappi = lopetusNappi;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == aloitusNappi) {
           ip.getValikonFrame().dispose();
            ip.luoPeliIkkuna();
        }
        if (e.getSource() == lopetusNappi) {
            ip.getValikonFrame().dispose();
        }
    }

}

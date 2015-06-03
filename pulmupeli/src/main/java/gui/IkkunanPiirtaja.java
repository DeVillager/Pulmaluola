package gui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

/**
 * Luokka luo JFrame-olioita erilaisiin tilanteisiin
 */
public class IkkunanPiirtaja {

    private Peli peli;
    private int skaala;
    private JFrame valikko;
    private JFrame pelinFrame;
    
    /**
     * Luo ikkunanpiirtäjän, joka tuntee pelin sekä skaalan.
     * @param peli
     * @param skaala 
     */
    public IkkunanPiirtaja(Peli peli, int skaala) {
        this.peli = peli;
        this.skaala = skaala;
    }
    
    /**
     * Metodi luo Valikko-ikkunan
     */
    public void kaynnistaValikko() {
        valikko = new JFrame("Valikko");
        valikko.setPreferredSize(new Dimension(10 * skaala, 15 * skaala));
        valikko.setLocation(480, 80);
        valikko.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        luoValikkoKomponentit(valikko.getContentPane());
        valikko.pack();
        valikko.setVisible(true);
    }
    
    /**
     * Metodi luo kaksi JButtonia JFramen säiliöön
     * @param container annettu JFramen säiliö
     */
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
    
    public JFrame getValikonFrame() {
        return this.valikko;
    }
    
    /**
     * Metodi luo Peli-ikkunan
     */
    public void luoPeliIkkuna() {
        pelinFrame = new JFrame("Peli");
        pelinFrame = new JFrame("Pulmapeli");
        pelinFrame.setPreferredSize(new Dimension(616, 638));
        pelinFrame.setLocation(400, 40);
        pelinFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        peli.luoKentalleKaikkiKomponentit();
        peli.luoGrafiikat(pelinFrame.getContentPane());
        pelinFrame.pack();
        pelinFrame.setVisible(true);
    }

    public JFrame getPelinFrame() {
        return this.pelinFrame;
    }
    
    /**
     * Metodi luo Voitto-ikkunan
     */
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

package gui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 * Luokka luo JFrame-olioita erilaisiin tilanteisiin
 */
public class IkkunanPiirtaja {

    private Peli peli;
    private int skaala;
    private JFrame valikko;
    private JFrame pelinFrame;
    private JFrame ohjeet;

    /**
     * Luo ikkunanpiirtäjän, joka tuntee pelin sekä skaalan.
     *
     * @param peli tuntee pelin osaset
     * @param skaala pelin koko
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
        valikko.setLocation(750, 80);
        valikko.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        luoValikkoKomponentit(valikko.getContentPane());
        valikko.pack();
        valikko.setVisible(true);
    }

    /**
     * Metodi luo kaksi JButtonia JFramen säiliöön
     *
     * @param container annettu JFramen säiliö
     */
    public void luoValikkoKomponentit(Container container) {
        container.setLayout(new GridLayout(3, 1));
        JButton aloitaPeli = new JButton("Pelaa");
        JButton annaOhjeet = new JButton("Ohjeet");
        JButton lopetaPeli = new JButton("Lopeta");
        Valikkokuuntelija valikonKuuntelija = new Valikkokuuntelija(this, aloitaPeli, lopetaPeli, annaOhjeet);
        aloitaPeli.addActionListener(valikonKuuntelija);
        lopetaPeli.addActionListener(valikonKuuntelija);
        annaOhjeet.addActionListener(valikonKuuntelija);
//        container.add(new JLabel("Löydä tie maaliin.\nLiikuta hahmoa nuolinäppäimillä ja aloita alusta R-näppäimellä.\nKiviä voi työntää liikkumalla niitä kohti."));
        container.add(aloitaPeli);
        container.add(annaOhjeet);
        container.add(lopetaPeli);
    }

    /**
     * Metodi luo Peli-ikkunan
     */
    public void luoPeliIkkuna() {

        pelinFrame = new JFrame("Peli");
        pelinFrame = new JFrame("Luolapeli");
        pelinFrame.setPreferredSize(new Dimension(616, 638));
        pelinFrame.setLocation(700, 40);
        pelinFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        peli.luoKentalleKaikkiKomponentit();
        peli.luoGrafiikat(pelinFrame.getContentPane());
        pelinFrame.pack();
        pelinFrame.setVisible(true);
    }

    /**
     * Metodi luo Voitto-ikkunan
     */
    public void luoVoittoIkkuna() {
        JFrame voittoIkkuna = new JFrame("Taso läpäisty");
        voittoIkkuna.setPreferredSize(new Dimension(616, 638));
        voittoIkkuna.setLocation(700, 40);
        voittoIkkuna.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        voittoIkkuna.getContentPane().setLayout(new GridBagLayout());
        voittoIkkuna.getContentPane().add(new JLabel("Voitit pelin!!!"));
        voittoIkkuna.pack();
        voittoIkkuna.setVisible(true);
    }

    /**
     * Metodi luo Ohje-ikkunan
     */
    public void luoOhjeIkkuna() {
        this.ohjeet = new JFrame("Ohjeet");
        ohjeet.setPreferredSize(new Dimension(400, 638));
        ohjeet.setLocation(750, 80);
        ohjeet.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        ohjeet.getContentPane().setLayout(new GridLayout(9, 1, 5, 50));
        JPanel panel = new JPanel();
        ohjeet.getContentPane().add(new JLabel("Löydä tie ulos luolastosta."));
        ohjeet.getContentPane().add(new JLabel("Liikuta hahmoa nuolinäppäimillä."));
        ohjeet.getContentPane().add(new JLabel("Voit työntää kiviä edestäsi liikkumalla niitä kohti."));
        ohjeet.getContentPane().add(new JLabel("Jos putoat kuoppaan, taso alkaa alusta."));
        ohjeet.getContentPane().add(new JLabel("Voit kuitenkin työntää kiven kuoppaan ja kulkea kuopan yli."));
        ohjeet.getContentPane().add(new JLabel("Portaista pääsee seuraavalle tasolle."));
        ohjeet.getContentPane().add(new JLabel("Jos jäät jumiin, aloita taso alusta R-näppäimellä."));
        ohjeet.getContentPane().add(new JLabel("Onnea matkaan!"));
        JButton ok = new JButton("OK");
        ok.addActionListener(new OkKuuntelija(this, ok));
        ohjeet.getContentPane().add(ok);
        ohjeet.pack();
        ohjeet.setVisible(true);
    }

    public JFrame getValikonFrame() {
        return this.valikko;
    }

    public JFrame getPelinFrame() {
        return this.pelinFrame;
    }

    public JFrame getOhjeIkkuna() {
        return this.ohjeet;
    }
}

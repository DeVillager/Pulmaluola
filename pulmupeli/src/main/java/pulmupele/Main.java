package pulmupele;

import gui.Kayttoliittyma;
import javax.swing.SwingUtilities;

/**
 * Ohjelma alkaa tästä luokasta
 */
public class Main {
    
    public static void main(String[] args) {
        
        /**
         * Luodaan uusi käyttöliittymä
         */
        Kayttoliittyma kayttoliittyma = new Kayttoliittyma();
        SwingUtilities.invokeLater(kayttoliittyma);
    }
}

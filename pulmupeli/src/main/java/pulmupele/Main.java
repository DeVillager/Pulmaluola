package pulmupele;

import gui.Kayttoliittyma;
import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {
        

        Kayttoliittyma kayttoliittyma = new Kayttoliittyma();
        SwingUtilities.invokeLater(kayttoliittyma);
    }
}

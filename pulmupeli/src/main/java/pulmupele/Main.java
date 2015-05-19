package pulmupele;

import java.util.ArrayList;
import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {

       int koko = 40;
        Kayttoliittyma kayttoliittyma = new Kayttoliittyma(new Hahmo(koko, koko, koko), new ArrayList<Seina>());
        SwingUtilities.invokeLater(kayttoliittyma);
    }
}

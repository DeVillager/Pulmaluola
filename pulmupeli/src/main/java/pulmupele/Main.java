package pulmupele;

import java.util.ArrayList;
import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {

//      Ohjain ohjain = new Ohjain();
//      ohjain.run();
       int koko = 40;
        Kayttoliittyma kayttoliittyma = new Kayttoliittyma(new Hahmo(koko, koko, koko), new ArrayList<Seina>());
        SwingUtilities.invokeLater(kayttoliittyma);
    }
}

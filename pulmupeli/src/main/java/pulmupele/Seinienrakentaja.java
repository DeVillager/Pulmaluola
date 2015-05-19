
package pulmupele;

import java.util.ArrayList;


public class Seinienrakentaja {
    
    private ArrayList<Seina> seinat;
    private int koko;

    public Seinienrakentaja(ArrayList<Seina> seinat, int koko) {
        this.seinat = seinat;
        this.koko = koko;
        luoSeinat(koko);
    }
    
    public ArrayList<Seina> getSeinat() {
        return seinat;
    }

    private void luoSeinat(int koko) {
        int maxraja = 600;
       for (int i = 0; i < maxraja; i += koko) {
            for (int j = 0; j < maxraja; j += koko) {
                if ( i == 0 || j == 0) {
                    lisaaSeina(i, j, koko);
                }
                else if (i == maxraja - koko || j == maxraja - koko) {
                    lisaaSeina(i, j, koko);
                }
            }
       }
        lisaaSeina(80, 80, koko);
        lisaaSeina(120, 40, koko);
        lisaaSeina(320, 400, koko);
        lisaaSeina(280, 160, koko);
        lisaaSeina(200, 120, koko);
        
    }
    
    private void lisaaSeina(int x, int y, int koko) {
        seinat.add(new Seina(x, y, koko));
    }
    
      
    
}

package logiikka;

import elementit.Seina;
import elementit.Hahmo;
import java.util.ArrayList;

public class Liikekontrolleri {

    private Hahmo hahmo;
    private ArrayList<Seina> seinat;

    public Liikekontrolleri(Hahmo hahmo, ArrayList<Seina> seinat) {
        this.hahmo = hahmo;
        this.seinat = seinat;
    }

    public boolean tarkastaLiike(int keyCode) {
        if (keyCode == 37 || keyCode == 38 || keyCode == 39 || keyCode == 40) {
            return tarkastaEihanTormaa(keyCode);
        }
        return true;
    }

    boolean tarkastaEihanTormaa(int keyCode) {
        int x = hahmo.getX();
        int y = hahmo.getY();

        if (keyCode == 37) {
            x -= hahmo.getKoko();
        }
        if (keyCode == 39) {
            x += hahmo.getKoko();
        }
        if (keyCode == 38) {
            y -= hahmo.getKoko();
        }
        if (keyCode == 40) {
            y += hahmo.getKoko();
        }
        for (Seina seina : seinat) {
            if (seina.getX() == x && seina.getY() == y) {
                return false;
            }
        }
        return true;
    }
    
    public ArrayList<Seina> getSeinat() {
        return seinat;
    }

}

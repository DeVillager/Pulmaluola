
package elementit;

import java.awt.Graphics;

public class Seina {
    
    private int x;
    private int y;
    private int koko;

    public Seina(int x, int y, int koko) {
        this.x = x;
        this.y = y;
        this.koko = koko;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    public int getKoko() {
        return koko;
    }

    public void piirra(Graphics graphics) {
        graphics.fillRect(x, y, koko, koko);
    }
    
    
}

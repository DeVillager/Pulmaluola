
package elementit;

import java.awt.Graphics;

/**
 * Rajapinta, joka vaatii metodeja toteutettavaksi
 */
public interface Elementti {
    
    
    int getX();
    int getY();
    int getKoko();
    String getId();
    void setX(int x);
    void setY(int y);
    
    void piirra(Graphics graphics);
    
}

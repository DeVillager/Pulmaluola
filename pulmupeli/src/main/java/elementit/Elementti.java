
package elementit;

import java.awt.Graphics;
import java.awt.Image;

/**
 * Rajapinta, joka vaatii metodeja toteutettavaksi
 */
public interface Elementti {
       
    int getX();
    int getY();
    int getKoko();
    String getId();
    String getImage();
    void setX(int x);
    void setY(int y);
    void setId(String s);
    void setImage(String reitti);
    void piirra(Graphics graphics);
    Image luoKuva(String kuvanPolku);

}

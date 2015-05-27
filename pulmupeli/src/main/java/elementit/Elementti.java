
package elementit;

import java.awt.Graphics;

public interface Elementti {
    
    
    int getX();
    int getY();
    int getKoko();
    String getId();
    void setX(int x);
    void setY(int y);
    
    void piirra(Graphics graphics);
    
}

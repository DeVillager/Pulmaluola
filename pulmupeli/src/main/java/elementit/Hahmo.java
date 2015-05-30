package elementit;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Hahmo extends JPanel implements Elementti {

    private int x;
    private int y;
    private int koko;
    private BufferedImage man;
    private File kuva;

    public Hahmo(int x, int y, int koko) {
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

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getKoko() {
        return koko;
    }

    public String getId() {
        return "hahmo";
    }

    public void siirry(int xmuutos, int ymuutos) {
        this.x += xmuutos;
        this.y += ymuutos;
    }
//C:\\Users\\Anja\\varjorepo\\pulmupeli\\src\\main\\java\\Tiedostot\\
//C:\\Users\\Anja\\varjorepo\\pulmupeli\\src\\main\\java\\elementit\\slime.png

 
    public void piirra(Graphics graphics)  {
      
////            Path reitti = Paths.get(":/pulmupeli/src/main/java/Tiedostot/slime.png");
////            Path p5 = Paths.get("/slime.png");
////            man = ImageIO.read(kuva);
//            URL path = Hahmo.class.getResource("slime.png");
//            File f = new File(path.getFile());
////            reader = new BufferedReader(new FileReader(f));
//            man = ImageIO.read(new File("slime.png"));
//            URL path = Hahmo.class.getResource("slime.png");
//            File f = new File(path.getFile());
//            reader = new BufferedReader(new FileReader(f));
//            InputStream input = getClass().getResourceAsStream("slime.png");
//            URL url = getClass().getResource("slime.png");
//            File file = new File(url.getPath());
//            File file = new File(input);
//            man = ImageIO.read(input);
////  
//            
////        try {
////            image = ImageIO.read(new File("/slime.png"));
//        
//             
//        try {
//            //        } catch (IOException ex) {
//            
////        }
//            BufferedImage image = null;
//            Path p4 = FileSystems.getDefault().getPath("/slime.png");
//            File f = p4.toFile();
//            image = ImageIO.read(f);
//            graphics.drawImage(image , x, y, this);
//            
////            System.out.println("ei onnittu");
//            
//            
//
//        } catch (IOException ex) {
//            
//        }
                graphics.setColor(Color.red);
        graphics.fillOval(x, y, koko, koko);
    }
}

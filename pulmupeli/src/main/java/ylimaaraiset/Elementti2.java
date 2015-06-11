//
//package elementit;
//
//
//import elementit.Seina;
//import java.awt.Graphics;
//import java.awt.Image;
//import javax.swing.ImageIcon;
//import javax.swing.JPanel;
//
//
//public class Elementti2 extends JPanel {
//    
//    public int x;
//    public int y;
//    public int koko;
//    public String id;
//    public String imgFileName;
//    public Image img;
//    
//    public Elementti2(int x, int y, int koko) {
//        this.x = x;
//        this.y = y;
//        this.koko = koko;
//        Object obj = this;
//        if (obj instanceof Vesi) {
//            this.imgFileName = "vesi.png";
//        }
//        this.img = luoKuva(imgFileName);
//    }
//    
//    
//    public int getX() {
//     return x;   
//    }
//    public int getY() {
//        return y;
//    }
//    public int getKoko() {
//        return koko;
//    }
//    public String getId() {
//        return id;
//    }
//    public String getImage() {
//        return imgFileName;
//    }
//    public void setX(int x) {
//        this.x = x;
//    }
//    public void setY(int y) {
//        this.y = y;
//    }
//    public void setId(String s) {
//        this.id = s;
//    }
//    public void setImage(String uusikuva) {
//        this.imgFileName = uusikuva;
//    }
//    public void piirra(Graphics graphics) {
//        graphics.drawImage(img, x, y, null);
//    }
//    
//    public Image luoKuva(String imgFileName) {
//        ImageIcon icon = null;
//        java.net.URL imgURL = getClass().getClassLoader().getResource(imgFileName);
//        if (imgURL != null) {
//            icon = new ImageIcon(imgURL);
//        } else {
//            System.err.println("Ei löytynyt kuvaa  " + imgFileName);
//        }
//        Image img = icon.getImage();
//        return img;
//    }
//}

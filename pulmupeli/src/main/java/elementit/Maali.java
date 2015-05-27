/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elementit;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Maali extends JPanel implements Elementti {

    private int x;
    private int y;
    private int koko;
    private BufferedImage goal;

    public Maali(int x, int y, int koko) {
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
        return "maali";
    }

    public void piirra(Graphics graphics) {
        try {
            goal = ImageIO.read(new File("C:\\goal.png"));
        } catch (IOException ex) {
            System.out.println("ei onnittu");
        }
        graphics.drawImage(goal, x, y, this);
    }
}

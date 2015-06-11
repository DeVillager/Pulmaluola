/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elementit;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * Luokka määrittelee maali-olion
 */
public class Maali extends JPanel implements Elementti {

    private int x;
    private int y;
    private int koko;
    private String imgFileName = "omatportaat2.png";
    private Image img = luoKuva(imgFileName);
    private String id;

    /**
     * Luo maalin, jolla on x- ja y-suuntaiset pituudet sekä koko
     *
     * @param x maalin pituus x-suunnassa
     * @param y maalin pituus y-suunnassa
     * @param koko maalin koko
     */
    public Maali(int x, int y, int koko) {
        this.x = x;
        this.y = y;
        this.koko = koko;
        this.id = "maali";
    }

    /**
     * Metodi pyytää graphics oliota piirtämään seinään liittyvän kuvan img
     *
     * @param graphics Olio, joka piirtää kuvan
     */
    public void piirra(Graphics graphics) {
        graphics.drawImage(img, x, y, null);
    }

    /**
     * Metodi hakee tiedoston tekstistä, joka kertoo pathin tiedostoon.
     * Palauttaa tiedoston image-oliona.
     *
     * @param imgFileName Haettava kuvatiedosto
     * @return kuva, joka liittyy maali-olioon
     */
    public Image luoKuva(String imgFileName) {
        ImageIcon icon = null;
        java.net.URL imgURL = getClass().getClassLoader().getResource(imgFileName);
        if (imgURL != null) {
            icon = new ImageIcon(imgURL);
        } else {
            System.err.println("Ei löytynyt kuvaa  " + imgFileName);
        }
        Image img = icon.getImage();
        return img;
    }

    // Tästä eteenpäin loput metodit ovat gettereitä ja settereitä
    
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getKoko() {
        return koko;
    }

    public String getId() {
        return id;
    }

    @Override
    public String getImage() {
        return imgFileName;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setId(String uusiId) {
        this.id = uusiId;
    }

    @Override
    public void setImage(String uusikuva) {
        this.imgFileName = uusikuva;
    }

}

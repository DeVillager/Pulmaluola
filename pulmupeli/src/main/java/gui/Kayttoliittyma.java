package gui;

public class Kayttoliittyma implements Runnable {

    private Peli peli;
    
    /**
     * Metodi luo käyttöliittymän, joka taas luo pelin, jolla on koko 40
     */
    public Kayttoliittyma() {
        this.peli = new Peli(40);
    }
    
    /**
     * Metodi kutsuu pelin kaynnista()-metodia ja ohjelma jää juoksemaan
     */
    @Override
    public void run() {
        peli.kaynnista();
    }

}

package gui;

public class Kayttoliittyma implements Runnable {

    private Peli peli;

    public Kayttoliittyma() {
        this.peli = new Peli(40);
    }

    @Override
    public void run() {
        peli.kaynnista();
    }

}

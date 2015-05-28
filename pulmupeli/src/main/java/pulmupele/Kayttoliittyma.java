package pulmupele;

import logiikka.Peli;

public class Kayttoliittyma implements Runnable {

    private Peli peli;

    public Kayttoliittyma() {
        this.peli = new Peli();
    }

    @Override
    public void run() {
        peli.luoIkkuna();
    }

}

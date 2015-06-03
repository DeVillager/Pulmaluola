package logiikka;

import elementit.Elementti;
import elementit.Laatikko;
import elementit.Maali;
import elementit.Seina;
import java.util.ArrayList;

/**
 * Luokka, joka luo elementtejä kentälle
 */
public class Kentanrakentaja {

    private ArrayList<Elementti> kenttaelementit;
    private int koko;
    private Maali maali;

    /**
     * Luo kentänrakentajan joka tuntee listan pelin elementeistä ja pelin koon
     *
     * @param kelementit Lista, jossa säilytetään kenttäelementtejä
     * @param koko Pelin koko
     */
    public Kentanrakentaja(ArrayList<Elementti> kelementit, int koko) {
        this.kenttaelementit = kelementit;
        this.koko = koko;
    }

    public ArrayList<Elementti> getLista() {
        return kenttaelementit;
    }

    /**
     * Metodi kutsuu osametodeja, jotka lisäävät elementtejä
     * kenttaelementit-listaan
     *
     * @param koko Pelin koko
     */
    public void luoKentta(int koko) {
        luoReunat(koko);
        lisaaKentalleSeinat();
        lisaaKentalleLaatikot();
        lisaaMaali();
    }

    /**
     * Metodi lisää kenttäelementit-listaan seiniä, jotka rajaavat pelialueen
     *
     * @param koko Pelin koko
     */
    public void luoReunat(int koko) {
        int maxraja = 15;
        for (int i = 0; i < maxraja; i++) {
            for (int j = 0; j < maxraja; j++) {
                if ((i == 0 || j == 0) && koko > 0) {
                    lisaaSeina(i, j, koko);
                } else if (i >= maxraja - 1 || j >= maxraja - 1) {
                    lisaaSeina(i, j, koko);
                }
            }
        }
    }

    /**
     * Metodi lisää seinän annettuun sijaintiin
     *
     * @param x Sijainnin x-koordinaatti
     * @param y Sijainnin y-koordinaatti
     * @param koko Pelin koko
     */
    public void lisaaSeina(int x, int y, int koko) {
        kenttaelementit.add(new Seina(koko * x, koko * y, koko));
    }

    /**
     * Metodi lisää laatikon annettuun sijaintiin
     *
     * @param x Sijainnin x-koordinaatti
     * @param y Sijainnin y-koordinaatti
     * @param koko Pelin koko
     */
    public void lisaaLaatikko(int x, int y, int koko) {
        kenttaelementit.add(new Laatikko(koko * x, koko * y, koko));
    }

    /**
     * Metodi kutsuu osametodia, joka lisää seiniä kenttaelementit-listalle
     */
    public void lisaaKentalleSeinat() {
//        level1S();
        level2S();
    }
    
    /**
     * Metodi kutsuu osametodia, joka lisää laatikoita kenttaelementit-listalle
     */
    public void lisaaKentalleLaatikot() {
//        level1L();
        level2L();
    }

//    private void level1S() {
//        lisaaSeina(4, 4, koko);
//        lisaaSeina(3, 1, koko);
//        lisaaSeina(8, 11, koko);
//        lisaaSeina(7, 4, koko);
//        lisaaSeina(5, 3, koko);
//    }
//
//    private void level1L() {
//        lisaaLaatikko(3, 2, koko);
//        lisaaLaatikko(4, 1, koko);
//        lisaaLaatikko(5, 6, koko);
//        lisaaLaatikko(8, 10, koko);
//        lisaaLaatikko(13, 12, koko);
//        lisaaLaatikko(10, 9, koko);
//    }
    
    /**
     * Metodi lisää kenttaelementit-listaan ennaltamääritellyt laatikot lisaaLaatikko-metodeilla
     */
    public void level2L() {
//        lisaaLaatikko(6, 1, koko);
        lisaaLaatikko(10, 1, koko);
        lisaaLaatikko(10, 2, koko);
        lisaaLaatikko(11, 2, koko);
        lisaaLaatikko(12, 2, koko);
        lisaaLaatikko(6, 3, koko);
        lisaaLaatikko(7, 3, koko);
        lisaaLaatikko(8, 3, koko);
        lisaaLaatikko(12, 3, koko);
        lisaaLaatikko(13, 3, koko);
        lisaaLaatikko(10, 4, koko);
        lisaaLaatikko(11, 4, koko);
        lisaaLaatikko(13, 4, koko);
        lisaaLaatikko(2, 5, koko);
        lisaaLaatikko(10, 5, koko);
        lisaaLaatikko(12, 5, koko);
        lisaaLaatikko(12, 5, koko);
        lisaaLaatikko(1, 6, koko);
        lisaaLaatikko(2, 7, koko);
        lisaaLaatikko(2, 8, koko);
        lisaaLaatikko(6, 8, koko);
        lisaaLaatikko(8, 8, koko);
        lisaaLaatikko(10, 8, koko);
        lisaaLaatikko(11, 9, koko);
        lisaaLaatikko(6, 10, koko);
        lisaaLaatikko(11, 10, koko);
        lisaaLaatikko(12, 10, koko);
        lisaaLaatikko(8, 11, koko);
        lisaaLaatikko(6, 12, koko);
    }
    
     /**
     * Metodi lisää kenttaelementit-listaan ennaltamääritellyt seinät lisaaSeina-metodeilla
     */
    public void level2S() {
        lisaaSeina(1, 1, koko);
        lisaaSeina(13, 1, koko);
        lisaaSeina(1, 2, koko);
        lisaaSeina(3, 2, koko);
        lisaaSeina(5, 2, koko);
        lisaaSeina(9, 2, koko);
        lisaaSeina(1, 2, koko);
        lisaaSeina(1, 3, koko);
        lisaaSeina(3, 3, koko);
        lisaaSeina(5, 3, koko);
        lisaaSeina(9, 3, koko);
        lisaaSeina(1, 4, koko);
        lisaaSeina(3, 4, koko);
        lisaaSeina(5, 4, koko);
        lisaaSeina(9, 4, koko);
        lisaaSeina(3, 5, koko);
        lisaaSeina(5, 5, koko);
        lisaaSeina(6, 5, koko);
        lisaaSeina(7, 5, koko);
        lisaaSeina(8, 5, koko);
        lisaaSeina(9, 5, koko);
        lisaaSeina(3, 6, koko);
        lisaaSeina(7, 6, koko);
        lisaaSeina(8, 6, koko);
        lisaaSeina(9, 6, koko);
        lisaaSeina(10, 6, koko);
        lisaaSeina(12, 6, koko);
        lisaaSeina(13, 6, koko);
        lisaaSeina(4, 7, koko);
        lisaaSeina(5, 7, koko);
        lisaaSeina(7, 7, koko);
        lisaaSeina(9, 7, koko);
        lisaaSeina(12, 7, koko);
        lisaaSeina(3, 8, koko);
        lisaaSeina(3, 8, koko);
        lisaaSeina(1, 9, koko);
        lisaaSeina(3, 9, koko);
        lisaaSeina(5, 9, koko);
        lisaaSeina(7, 9, koko);
        lisaaSeina(9, 9, koko);
        lisaaSeina(1, 10, koko);
        lisaaSeina(3, 10, koko);
        lisaaSeina(7, 10, koko);
        lisaaSeina(9, 10, koko);
        lisaaSeina(1, 11, koko);
        lisaaSeina(3, 11, koko);
        lisaaSeina(5, 11, koko);
        lisaaSeina(7, 11, koko);
        lisaaSeina(9, 11, koko);
        lisaaSeina(10, 11, koko);
        lisaaSeina(3, 12, koko);
        lisaaSeina(10, 12, koko);
        lisaaSeina(11, 12, koko);
        lisaaSeina(13, 12, koko);
        lisaaSeina(1, 13, koko);
        lisaaSeina(3, 13, koko);
        lisaaSeina(5, 13, koko);
        lisaaSeina(6, 13, koko);
        lisaaSeina(7, 13, koko);
        lisaaSeina(8, 13, koko);
    }
    
     /**
     * Metodi lisää kenttaelementit-listaan maalin
     */
    public void lisaaMaali() {
        this.maali = new Maali(koko, 12 * koko, koko);
        kenttaelementit.add(maali);
    }

}

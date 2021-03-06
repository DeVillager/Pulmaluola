package logiikka;

import elementit.Elementti;
import elementit.Hahmo;
import elementit.Laatikko;
import elementit.Maali;
import elementit.Rotko;
import elementit.Seina;
import gui.Peli;
import java.util.ArrayList;

/**
 * Luokka, joka luo elementtejä kentälle
 */
public class Kentanrakentaja {

    private ArrayList<Elementti> kenttaelementit;
    private int koko;
    private Maali maali;
    private int level;

    /**
     * Luo kentänrakentajan joka tuntee listan pelin elementeistä ja pelin koon
     *
     * @param kelementit Lista, jossa säilytetään kenttäelementtejä
     * @param koko Pelin koko
     */
    public Kentanrakentaja(ArrayList<Elementti> kelementit, int koko) {
        this.kenttaelementit = kelementit;
        this.koko = koko;
        this.level = 1;
    }

    public ArrayList<Elementti> getLista() {
        return kenttaelementit;
    }

    public Maali getMaali() {
        return maali;
    }

    public int getLevel() {
        return this.level;
    }

    /**
     * Nostaa pelin tasoa.
     */
    public void nostaTasoa() {
        this.level++;
    }

    /**
     * Metodi kutsuu useampaa metodia, jotka yhdessä konstruoivat pelin
     * ensimmäisen tason
     */
    public void luoEkaTaso() {
        luoReunat(koko);
        lisaaKentalleSeinat();
        lisaaKentalleLaatikot();
        lisaaMaali(1, 12, koko);
    }

    /**
     * Metodi kutsuu useampaa metodia, jotka yhdessä konstruoivat pelin toisen
     * tason
     */
    public void luoTokaTaso() {
        luoReunat2(koko);
        lisaaKentalleSeinat2();
        lisaaKentalleLaatikot2();
        lisaaKentalleRotkot();
        lisaaMaali(8, 1, koko);
    }

    /**
     * Meodi palauttaa hahmon x-koordinaatin, joka sillä on pelin alussa.
     * Koordinaatti riippuu sen hetkisestä tasosta.
     *
     * @return hahmon x-koordinaatti kyseisen tason alussa
     */
    public int getHahmonXSijaintiTasossa() {
        if (level == 1) {
            return 7 * koko;
        } else if (level == 2) {
            return 1 * koko;
        }
        return 0;
    }

    /**
     * Meodi palauttaa hahmon y-koordinaatin, joka sillä on pelin alussa.
     * Koordinaatti riippuu sen hetkisestä tasosta.
     *
     * @return hahmon y-koordinaatti kyseisen tason alussa
     */
    public int getHahmonYSijaintiTasossa() {
        if (level == 1) {
            return 4 * koko;
        } else if (level == 2) {
            return 12 * koko;
        }
        return 0;
    }

    /**
     * Metodi lisää kenttaelementit-listaan maalin
     */
    public void lisaaMaali(int x, int y, int koko) {
        this.maali = new Maali(x * koko, y * koko, koko, "maali", "omatportaat.png");
        kenttaelementit.add(maali);
    }

    /**
     * Metodi nostaa pelin tasoa ja näyttää voittoikkunan, jos taso on 3. Muuten
     * kutsutaan metodia, jolla luodaan seuraava taso.
     *
     * @param peli käynnissä oleva peli
     */
    public void luoSeuraavaTaso(Peli peli) {
        nostaTasoa();
        if (this.level == 3) {
            peli.getIkkunanPiirtaja().getPelinFrame().dispose();
            peli.getIkkunanPiirtaja().luoVoittoIkkuna();
        }
        luoTasoAlusta(peli.getHahmo());
        peli.getPA().setMaali(maali);
    }

    /**
     * Metodi luo sen hetkisen tason alkuasettelun. Tyhjentää listan
     * elementeistä, luo uuden kentän ja asettaa hahmon tason mukaiseen
     * koordinaattiin
     *
     * @param hahmo pelaajan hahmo
     */
    public void luoTasoAlusta(Hahmo hahmo) {
        kenttaelementit.clear();
        luoKentta(hahmo.getKoko());
        hahmo.setX(this.getHahmonXSijaintiTasossa());
        hahmo.setY(this.getHahmonYSijaintiTasossa());
    }

    /**
     * Metodi kutsuu osametodeja, jotka lisäävät elementtejä
     * kenttaelementit-listaan
     *
     * @param koko Pelin koko
     */
    public void luoKentta(int koko) {
        if (level == 1) {
            luoEkaTaso();
        } else if (level == 2) {
            luoTokaTaso();
//        } else if (level == 3) {
//            luoKolmosTaso();
        }
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
        kenttaelementit.add(new Seina(koko * x, koko * y, koko, "seina", "omaseina2.png"));
    }

    /**
     * Metodi lisää laatikon annettuun sijaintiin
     *
     * @param x Sijainnin x-koordinaatti
     * @param y Sijainnin y-koordinaatti
     * @param koko Pelin koko
     */
    public void lisaaLaatikko(int x, int y, int koko) {
        kenttaelementit.add(new Laatikko(koko * x, koko * y, koko, "laatikko", "omakivi2.png"));
    }

    /**
     * Metodi lisää rotkon annettuun sijaintiin
     *
     * @param x Sijainnin x-koordinaatti
     * @param y Sijainnin y-koordinaatti
     * @param koko Pelin koko
     */
    public void lisaaRotko(int x, int y, int koko) {
        kenttaelementit.add(new Rotko(koko * x, koko * y, koko, "rotko", "omarotko.png"));
    }

    /**
     * Metodi lisää kenttaelementit-listaan ennaltamääritellyt laatikot
     * lisaaLaatikko-metodeilla
     */
    public void lisaaKentalleLaatikot() {
        lisaaLaatikko(6, 1, koko);
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
     * Metodi lisää kenttaelementit-listaan ennaltamääritellyt seinät
     * lisaaSeina-metodeilla
     */
    public void lisaaKentalleSeinat() {
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
     * Metodi lisää kenttäelementit-listaan seiniä, jotka rajaavat pelialueen
     *
     * @param koko Pelin koko
     */
    public void luoReunat2(int koko) {
        int maxraja = 15;
        for (int i = 0; i < maxraja; i++) {
            for (int j = 0; j < maxraja; j++) {
                if ((i == 0 || j == 0) && koko > 0) {
                    lisaaSeina(i, j, koko);
                } else if (i >= maxraja - 2 || j >= maxraja - 2) {
                    lisaaSeina(i, j, koko);
                }
            }
        }
    }

    /**
     * Metodi lisää kenttaelementit-listaan ennaltamääritellyt seinät
     * lisaaSeina-metodeilla
     */
    public void lisaaKentalleSeinat2() {
        lisaaSeina(1, 1, koko);
        lisaaSeina(1, 2, koko);
        lisaaSeina(1, 3, koko);
        lisaaSeina(1, 9, koko);
        lisaaSeina(2, 1, koko);
        lisaaSeina(2, 5, koko);
        lisaaSeina(2, 6, koko);
        lisaaSeina(2, 7, koko);
        lisaaSeina(2, 9, koko);
        lisaaSeina(2, 12, koko);
        lisaaSeina(3, 1, koko);
        lisaaSeina(3, 9, koko);
        lisaaSeina(3, 12, koko);
        lisaaSeina(4, 1, koko);
        lisaaSeina(4, 7, koko);
        lisaaSeina(4, 9, koko);
        lisaaSeina(4, 12, koko);
        lisaaSeina(4, 12, koko);
        lisaaSeina(5, 1, koko);
        lisaaSeina(5, 2, koko);
        lisaaSeina(5, 3, koko);
        lisaaSeina(5, 4, koko);
        lisaaSeina(5, 7, koko);
        lisaaSeina(6, 7, koko);
        lisaaSeina(6, 10, koko);
        lisaaSeina(6, 11, koko);
        lisaaSeina(7, 2, koko);
        lisaaSeina(7, 4, koko);
        lisaaSeina(7, 5, koko);
        lisaaSeina(7, 6, koko);
        lisaaSeina(7, 7, koko);
        lisaaSeina(7, 11, koko);
        lisaaSeina(8, 2, koko);
        lisaaSeina(8, 4, koko);
        lisaaSeina(8, 11, koko);
        lisaaSeina(9, 1, koko);
        lisaaSeina(9, 2, koko);
        lisaaSeina(9, 4, koko);
        lisaaSeina(9, 6, koko);
        lisaaSeina(9, 7, koko);
        lisaaSeina(10, 1, koko);
        lisaaSeina(10, 4, koko);
        lisaaSeina(10, 6, koko);
        lisaaSeina(11, 1, koko);
        lisaaSeina(11, 4, koko);
        lisaaSeina(11, 10, koko);
        lisaaSeina(11, 11, koko);
        lisaaSeina(12, 1, koko);
        lisaaSeina(12, 6, koko);
        lisaaSeina(12, 6, koko);
    }

    /**
     * Metodi lisää kenttaelementit-listaan ennaltamääritellyt laatikot
     * lisaaLaatikko-metodeilla
     */
    public void lisaaKentalleLaatikot2() {
        lisaaLaatikko(1, 6, koko);
        lisaaLaatikko(1, 10, koko);
        lisaaLaatikko(2, 4, koko);
        lisaaLaatikko(2, 10, koko);
        lisaaLaatikko(3, 10, koko);
        lisaaLaatikko(3, 11, koko);
        lisaaLaatikko(4, 5, koko);
        lisaaLaatikko(4, 10, koko);
        lisaaLaatikko(5, 9, koko);
        lisaaLaatikko(7, 8, koko);
        lisaaLaatikko(7, 9, koko);
        lisaaLaatikko(8, 3, koko);
        lisaaLaatikko(9, 5, koko);
        lisaaLaatikko(9, 10, koko);
        lisaaLaatikko(10, 11, koko);
        lisaaLaatikko(11, 3, koko);
        lisaaLaatikko(11, 8, koko);
        lisaaLaatikko(12, 9, koko);
    }

    /**
     * Metodi lisää kenttaelementit-listaan ennaltamääritellyt rotkot
     * lisaaRotko-metodeilla
     */
    public void lisaaKentalleRotkot() {
        lisaaRotko(1, 4, koko);
        lisaaRotko(1, 8, koko);
        lisaaRotko(3, 3, koko);
        lisaaRotko(4, 6, koko);
        lisaaRotko(5, 8, koko);
        lisaaRotko(5, 11, koko);
        lisaaRotko(6, 1, koko);
        lisaaRotko(6, 2, koko);
        lisaaRotko(6, 3, koko);
        lisaaRotko(8, 8, koko);
        lisaaRotko(9, 8, koko);
        lisaaRotko(10, 7, koko);
        lisaaRotko(10, 9, koko);
        lisaaRotko(11, 5, koko);
        lisaaRotko(11, 9, koko);
        lisaaRotko(11, 12, koko);
        lisaaRotko(12, 5, koko);
        lisaaRotko(12, 7, koko);
        lisaaRotko(12, 11, koko);
    }
}

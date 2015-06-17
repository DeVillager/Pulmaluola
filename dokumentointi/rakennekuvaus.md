##Rakennekuvaus

**Alkuvalmistelut**
Ohjelma luo käynnistyessään uuden Kayttöliittyman, joka luo uuden Peli-olion.
Kayttoliittyma toteuttaa Runnable-rajapinnan, jolloin ohjelma jää juoksemaan.
Peli luo alussa pelin komponentit ja siltä voidaan yleensä kysyä tarvittavaa komponenttia gettereillä.
Ikkunanpiirtaja piirtää uusia JFrameja tilanteen vaatiessa.
Valikkokuuntelija kuuntelee Ikkunanpiirtajan luoman valikkoIkkunan nappeja.
OkKuuntelija kuuntelee puolestaan ohjeIkkunan OK-painiketta.

**Logiikka**
Pelin logiikan muodostavat pääosin Kentanrakentaja ja Liikekontrolleri ja ne tarkastelevat aina Hahmon tilannetta.
Hahmo on olio, jota pelaaja liikuttaa suuntanäppäimillä.
Kentanrakentaja muokkaa elementtien listaa tai pyytää elementtejä muokkaamaan omaa tilaansa, kuten sijaintiaan.
Tason eilaisia elementtejä ovat Maali, Laatikko, Seina ja Rotko.
Liikekontolleri taas tarkastaa onko hahmolle syötetty liike mahdollinen siinä tilanteessa.
Piirtoalusta hallitsee peli-ikkunan elementtien grafiikoita ja pyytää elementtejä piirtämään itsensä jokaisen näppäimistöpainalluksen lopuksi.
Näppäimistökuuntelija kuuntelee näppäimistöltä painauksia, ja antaa painaukset Liikekontrollerille jatkokäsittelyyn, jos painallus on tietyiystä napeista.



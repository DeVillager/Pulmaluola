##Rakennekuvaus

**Alkuvalmistelut**
Ohjelma luo k�ynnistyess��n uuden Kaytt�liittyman, joka luo uuden Peli-olion.
Kayttoliittyma toteuttaa Runnable-rajapinnan, jolloin ohjelma j�� juoksemaan.
Peli luo alussa pelin komponentit ja silt� voidaan yleens� kysy� tarvittavaa komponenttia gettereill�.
Ikkunanpiirtaja piirt�� uusia JFrameja tilanteen vaatiessa.
Valikkokuuntelija kuuntelee Ikkunanpiirtajan luoman valikkoIkkunan nappeja.
OkKuuntelija kuuntelee puolestaan ohjeIkkunan OK-painiketta.

**Logiikka**
Pelin logiikan muodostavat p��osin Kentanrakentaja ja Liikekontrolleri ja ne tarkastelevat aina Hahmon tilannetta.
Hahmo on olio, jota pelaaja liikuttaa suuntan�pp�imill�.
Kentanrakentaja muokkaa elementtien listaa tai pyyt�� elementtej� muokkaamaan omaa tilaansa, kuten sijaintiaan.
Tason eilaisia elementtej� ovat Maali, Laatikko, Seina ja Rotko.
Liikekontolleri taas tarkastaa onko hahmolle sy�tetty liike mahdollinen siin� tilanteessa.
Piirtoalusta hallitsee peli-ikkunan elementtien grafiikoita ja pyyt�� elementtej� piirt�m��n itsens� jokaisen n�pp�imist�painalluksen lopuksi.
N�pp�imist�kuuntelija kuuntelee n�pp�imist�lt� painauksia, ja antaa painaukset Liikekontrollerille jatkok�sittelyyn, jos painallus on tietyiyst� napeista.



/**
 * SkatlaZaElektroniko.java
 *
 * Opis:
 * Razred za delo s škatlo za elektroniko.
 * 
 * @autor Nikola Dimitriev
 * @version Vaja 36 
 */

/**
 * Javni razred SkatlaZaElektroniko za opis škatle za elektroniko.
 */
public class SkatlaZaElektroniko extends Skatla {
    
    // Deklaracija privatne lastnosti
    private int napetost;

    /**
     * Konstruktor razreda SkatlaZaElektroniko.
     * 
     * @param volumen prostornina škatle
     * @param barva barva škatle
     * @param vsebina vsebina škatle
     * @param napetost napetost škatle
     */
    public SkatlaZaElektroniko(int volumen, String barva, String vsebina, int napetost) {
        super(volumen, barva, vsebina);
        this.napetost = napetost;
    }

    /**
     * Metoda za pridobitev napetosti škatle.
     * 
     * @return napetost škatle
     */
    public int getNapetost() {
        return napetost;
    }

    /**
     * Metoda za prikaz vsebine škatle.
     * 
     * @return String, ki predstavlja vsebino škatle
     */
    @Override
    public String prikaziVsebino() {
        return getVsebina();
    }
}

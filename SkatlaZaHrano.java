/**
 * SkatlaZaHrano.java
 *
 * Opis:
 * Razred za delo s škatlo za hrano.
 * 
 * @autor Nikola Dimitriev
 * @version Vaja 36 
 */

/**
 * Javni razred SkatlaZaHrano za opis škatle za hrano.
 */
public class SkatlaZaHrano extends Skatla {
    
    // Deklaracija privatne lastnosti
    private boolean hladilnik;

    /**
     * Konstruktor razreda SkatlaZaHrano.
     * 
     * @param volumen prostornina škatle
     * @param barva barva škatle
     * @param vsebina vsebina škatle
     * @param hladilnik ali je potrebna hramba v hladilniku
     */
    public SkatlaZaHrano(int volumen, String barva, String vsebina, boolean hladilnik) {
        super(volumen, barva, vsebina);
        this.hladilnik = hladilnik;
    }

    /**
     * Metoda za preverjanje ali škatla potrebuje hrambo v hladilniku.
     * 
     * @return true, če škatla potrebuje hrambo v hladilniku, drugače false
     */
    public boolean isHladilnik() {
        return hladilnik;
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

/**
 * Skatla.java
 *
 * Opis:
 * Abstraktni razred za delo s škatlo.
 * 
 * @author Nikola Dimitriev
 * @version Vaja 36 
 */

/**
 * Javni razred Skatla za opis škatle.
 */
public abstract class Skatla {
    
    // Deklaracija privatnih lastnosti škatle
    private int volumen;
    private String barva;
    private String vsebina;
    
    /**
     * Konstruktor razreda Skatla.
     * 
     * @param volumen prostornina škatle
     * @param barva barva škatle
     * @param vsebina vsebina škatle
     */
    public Skatla(int volumen, String barva, String vsebina) {
        this.volumen = volumen;
        this.barva = barva;
        this.vsebina = vsebina;
    }

    /**
     * Metoda za pridobitev volumena škatle.
     * 
     * @return volumen škatle
     */
    public int getVolumen() {
        return volumen;
    }

    /**
     * Metoda za pridobitev barve škatle.
     * 
     * @return barva škatle
     */
    public String getBarva() {
        return barva;
    }

    /**
     * Metoda za pridobitev vsebine škatle.
     * 
     * @return vsebina škatle
     */
    public String getVsebina() {
        return vsebina;
    }

    /**
     * Abstraktna metoda za prikaz vsebine škatle.
     * 
     * @return String, ki predstavlja vsebino škatle
     */
    public abstract String prikaziVsebino();
}

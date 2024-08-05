/**
 * SkatlaZaHrano.java
 *
 * Opis:
 * Delo s škatlo za hrano
 * 
 * @author Nikola Dimitriev
 * @version Vaja 35
 */

/**
* Javni razred za škatlo za hrano, ki je podrazred razreda Skatla.
 * Ta razred dodaja dodatno lastnost, ali škatla vključuje hladilnik za ohranjanje nizke temperature.
 */
public class SkatlaZaHrano extends Skatla {
	
	// Pokaže, ali škatla za hrano vključuje hladilnik
   private boolean hladilnik;
	
	/**
     * Konstruktor za ustvarjanje objekta SkatlaZaHrano.
     * 
     * @param v    Volumen škatle v cm^3
     * @param b    Barva škatle
     * @param vseb Vsebina škatle
     * @param h    Ali škatla vključuje hladilnik (true ali false)
     */
    public SkatlaZaHrano(int v, String b, String vseb, boolean h) {
        super(v, b, vseb);
        hladilnik = h;
    }
	
	 /**
     * Izpiše informacijo o tem, ali škatla ohranja nizko temperaturo.
     */
    public void pokaziTemperaturo() {
        if (hladilnik) {
            System.out.println("Škatla za hrano ohranja nizko temperaturo.");
        } else {
            System.out.println("Škatla za hrano ne ohranja nizke temperature.");
        }
    }
	
	 /**
     * Preveri, ali škatla vsebuje hladilnik.
     * 
     * @return true, če škatla vsebuje hladilnik; false, če ne
     */
    public boolean isHladilnik() {
        return hladilnik;
    }
}

/**
 * SkatlaZaElektroniko.java
 *
 * Opis:
 * Delo s škatlo za elektroniko
 * 
 * @author Nikola Dimitriev
 * @version Vaja 35
 
 */

/**
 * Javni razred za škatlo za elektroniko, ki je podrazred razreda Skatla.
 * Ta razred dodaja dodatno lastnost za napetost, ki je pomembna za elektroniko.
 */
public class SkatlaZaElektroniko extends Skatla {
    
	// Napetost, ki jo zahteva elektronika v škatli
	private int napetost;

	
    /**
     * Konstruktor za ustvarjanje objekta SkatlaZaElektroniko.
     * 
     * @param v    Volumen škatle v cm^3
     * @param b    Barva škatle
     * @param vseb Vsebina škatle
     * @param n    Napetost, ki jo zahteva elektronika v škatli (v voltih)
     */
    public SkatlaZaElektroniko(int v, String b, String vseb, int n) {
        super(v, b, vseb);
        napetost = n;
    }

	 /**
     * Metoda za izpis napetosti, ki jo zahteva elektronika v škatli.
     */
    public void pokaziNapetost() {
        System.out.println("Elektronika v škatli zahteva napetost: " + napetost + "V");
    }

	 /**
     * Metoda za pridobivanje napetosti, ki jo zahteva elektronika v škatli.
     * 
     * @return Napetost v voltih
     */
    public int getNapetost() {
        return napetost;
    }
	
}

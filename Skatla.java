/**
 * Skatla.java
 *
 * Opis:
 * Abstraktni razred za delo s škatlo.
 * 
 * @author Nikola Dimitriev
 * @version Vaja 35
 */

/**
 * Javni razred Skatla, ki predstavlja splošni model škatle z določenimi atributi.
 */
public class Skatla {
    private int volumen;
    private String barva;
    private String vsebina;

	 /**
     * Konstruktor za ustvarjanje objekta Skatla.
     * 
     * @param v      Volumen škatle v cm^3
     * @param b      Barva škatle
     * @param vseb   Vsebina škatle
     */
    public Skatla(int v, String b, String vseb) {
        volumen = v;
        barva = b;
        vsebina = vseb;
        System.out.println("Ustvarjam objekt tipa Skatla z volumnom " + v + " cm^3, barvo " + b + " in vsebino " + vseb);
    }
	 /**
     * Metoda za pridobivanje volumna škatle.
     * 
     * @return Volumen škatle v cm^3
     */
    public int getVolumen() {
        return volumen;
    }
	
	/**
     * Metoda za pridobivanje barve škatle.
     * 
     * @return Barva škatle kot niz
     */
    public String getBarva() {
        return barva;
    }

	/**
     * Metoda za prikazovanje vsebine škatle.
     * 
     * @return Vsebina škatle kot niz
     */
    public String prikaziVsebino() {
        return vsebina;
    }
}

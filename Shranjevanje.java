/**
 * Shranjevanje.java
 *
 * Opis: 
 * Vmesnik za objekte, ki omogočajo shranjevanje predmetov.
 * 
 * @author Nikola Dimitriev
 * @version Vaja 35
 */

public interface Shranjevanje {
    /**
     * Metoda za dodajanje predmeta v objekt.
     * @param predmet Predmet, ki ga želimo dodati.
     */
    void dodajPredmet(String predmet);

    /**
     * Metoda za odstranjevanje predmeta iz objekta.
     * @param predmet Predmet, ki ga želimo odstraniti.
     * @return true, če je bil predmet uspešno odstranjen, false sicer.
     */
    boolean odstraniPredmet(String predmet);

    /**
     * Metoda za prikaz vsebine objekta.
     * @return Vsebina objekta.
     */
    String prikaziVsebino();
}
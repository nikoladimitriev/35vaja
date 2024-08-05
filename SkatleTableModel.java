/**
 * ŠkatleTableModel.java
 *
 * Opis:
 * Razred za model tabele, ki prikazuje seznam škatel v grafičnem uporabniškem vmesniku.
 * 
 * @author Nikola Dimitriev
 * @version Vaja 35
 */

import javax.swing.table.DefaultTableModel;

/**
 * Javni razred za model tabele škatel.
 * Ta razred razširja DefaultTableModel in omogoča dodajanje vrstic, ki predstavljajo različne vrste škatel.
 */

public class SkatleTableModel extends DefaultTableModel {
    
	
    /**
     * Konstruktor za inicializacijo modela tabele.
     * Definira stolpce tabele: "Volumen", "Barva", "Vsebina" in "Dodatno".
     */
	public SkatleTableModel() {
        
		// Definicija stolpcev tabele
		super(new String[]{"Volumen", "Barva", "Vsebina", "Dodatno"}, 0);
    }
	
	 /**
     * Dodaja nov predmet (škatlo) v tabelo.
     *
     * @param skatla Predmet tipa Skatla, ki se doda v tabelo.
     *        Upoštevajo se podrazredi SkatlaZaHrano in SkatlaZaElektroniko, da se izpolnijo ustrezne informacije.
     */
    public void addŠkatla(Skatla skatla) {
        Object[] vrstica = null;
        if (skatla instanceof SkatlaZaHrano) {
            SkatlaZaHrano sh = (SkatlaZaHrano) skatla;
            vrstica = new Object[]{sh.getVolumen(), sh.getVsebina(), sh.getBarva(), sh.isHladilnik()};
        } else if (skatla instanceof SkatlaZaElektroniko) {
            SkatlaZaElektroniko se = (SkatlaZaElektroniko) skatla;
            vrstica = new Object[]{se.getVolumen(), se.getVsebina(), se.getBarva(), se.getNapetost()};
        }
		
		// Dodaja vrstico v model tabele
        addRow(vrstica);
    }
}

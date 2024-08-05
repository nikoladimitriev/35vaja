/**
 * GlavniProgram.java
 *
 * Opis:
 * Program z grafičnim uporabniškim vmesnikom za delo s škatlami. 
 * Omogoča dodajanje in odstranjevanje škatel ter prikazovanje vsebine.
 * @autor Nikola Dimitriev
 * @version Vaja 35
 */

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

/**
 * Javni razred za zagon uporabniškega vmesnika s tabelo škatel.
 */

public class GlavniProgramGUI extends JFrame implements ActionListener {
  
  // Deklaracija zasebnih lastnosti za GUI
	
	/** Model tabele za prikaz škatel. */
    private SkatlaTableModel modelTabele;
    /** Komponenta JTable za prikaz tabele škatel. */
	private JTable tabela;
    /** Vnosno polje za volumen škatle. */
	private JTextField volumenVnos;
    /** Vnosno polje za barvo škatle. */
	private JTextField barvaVnos;
    /** Vnosno polje za vsebino škatle. */
	private JTextField vsebinaVnos;

     /**
     * Javni konstruktor za ustvarjanje novega uporabniškega okna.
     */
	
	public GlavniProgramGUI() {
        
		// Inicializacija GUI komponent
        modelTabele = new SkatlaTableModel();
        tabela = new JTable(modelTabele);
        JScrollPane scrollPane = new JScrollPane(tabela);

        // Nastavitev osnovnih lastnosti okna
        setTitle("Skatla GUI");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        // Vnosna polja
        volumenVnos = new JTextField(10);
        barvaVnos = new JTextField(10);
        vsebinaVnos = new JTextField(10);

        // Gumbi
        JButton dodajButton = new JButton("Dodaj Skatlo");
        dodajButton.addActionListener(this);

        // Dodajanje komponent v okno
        add(new JLabel("Volumen:"));
        add(volumenVnos);
        add(new JLabel("Barva:"));
        add(barvaVnos);
        add(new JLabel("Vsebina:"));
        add(vsebinaVnos);
        add(dodajButton);
        add(scrollPane);

        // Prikaz okna
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Obdelava dogodkov za dodajanje skodelice
        int volumen = Integer.parseInt(volumenVnos.getText());
        String barva = barvaVnos.getText();
        String vsebina = vsebinaVnos.getText();

        Skatla novaSkatla = new Skatla(volumen, barva, vsebina);
        modelTabele.addSkatla(novaSkatla);
    }
	/**
     * Model tabele za prikaz škatel.
     */
    public static class SkatlaTableModel extends DefaultTableModel {
         /**
         * Konstruktor za inicializacijo modela tabele.
         * Definira stolpce tabele: "Tip", "Volumen", "Barva", "Vsebina".
         */
		public SkatlaTableModel() {
            addColumn("Tip");
            addColumn("Volumen");
            addColumn("Barva");
            addColumn("Vsebina");
        }
		
		 /**
         * Dodaja nov predmet (škatlo) v tabelo.
         * @param skatla Objekt tipa Skatla, ki se bo dodal v tabelo
         */
        public void addSkatla(Skatla skatla) {
            Object[] vrstica = {skatla.getClass().getSimpleName(), skatla.getVolumen(), skatla.getBarva(), skatla.prikaziVsebino()};
            addRow(vrstica);
        }
    }
 /**
     * Glavni razred za zagon GUI.
     * @param args Argumenti ukazne vrstice
     */
    public static void main(String[] args) {
        new GlavniProgramGUI();
    }
}

/**
 * GlavniProgramGUI.java
 *
 * Opis:
 * Program z grafičnim uporabniškim vmesnikom za delo s škatlami. 
 * Omogoča dodajanje, odstranjevanje in spreminjanje lastnosti škatel ter prikazovanje vsebine.
 * @autor Nikola Dimitriev
 * @version Vaja 36 
 */

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
    /** Vnosno polje za dodatne lastnosti škatle. */
    private JTextField dodatnoVnos;
    /** Gumb za dodajanje nove škatle. */
    private JButton dodajButton;
    /** Gumb za shranjevanje sprememb izbrane škatle. */
    private JButton shraniButton;
    /** Gumb za odstranjevanje izbrane škatle. */
    private JButton odstraniButton;
    /** Indeks izbrane vrstice v tabeli. */
    private int izbranaVrstica = -1;

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
        dodatnoVnos = new JTextField(10);

        // Gumbi
        dodajButton = new JButton("Dodaj Skatlo");
        dodajButton.addActionListener(this);

        shraniButton = new JButton("Shrani Spremembe");
        shraniButton.addActionListener(this);

        odstraniButton = new JButton("Odstrani Izbrano Skatlo");
        odstraniButton.addActionListener(this);

        // Dodajanje komponent v okno
        add(new JLabel("Volumen:"));
        add(volumenVnos);
        add(new JLabel("Barva:"));
        add(barvaVnos);
        add(new JLabel("Vsebina:"));
        add(vsebinaVnos);
        add(new JLabel("Dodatno:"));
        add(dodatnoVnos);
        add(dodajButton);
        add(shraniButton);
        add(odstraniButton);
        add(scrollPane);

        // Prikaz okna
        setVisible(true);

        // Dodajanje poslušalca za izbiro vrstice v tabeli
        tabela.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                izbranaVrstica = tabela.getSelectedRow();
                if (izbranaVrstica != -1) {
                    volumenVnos.setText(modelTabele.getValueAt(izbranaVrstica, 0).toString());
                    barvaVnos.setText(modelTabele.getValueAt(izbranaVrstica, 1).toString());
                    vsebinaVnos.setText(modelTabele.getValueAt(izbranaVrstica, 2).toString());
                    dodatnoVnos.setText(modelTabele.getValueAt(izbranaVrstica, 3).toString());
                }
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == dodajButton) {
            int volumen = Integer.parseInt(volumenVnos.getText());
            String barva = barvaVnos.getText();
            String vsebina = vsebinaVnos.getText();
            String dodatno = dodatnoVnos.getText();

            // Dodajanje nove škatle
            Skatla novaSkatla;
            if (dodatno.matches("\\d+")) {
                int napetost = Integer.parseInt(dodatno);
                novaSkatla = new SkatlaZaElektroniko(volumen, barva, vsebina, napetost);
            } else {
                boolean hladilnik = Boolean.parseBoolean(dodatno);
                novaSkatla = new SkatlaZaHrano(volumen, barva, vsebina, hladilnik);
            }

            modelTabele.addSkatla(novaSkatla);
        } else if (e.getSource() == shraniButton) {
            if (izbranaVrstica != -1) {
                // Shranjevanje sprememb izbrane škatle
                int volumen = Integer.parseInt(volumenVnos.getText());
                String barva = barvaVnos.getText();
                String vsebina = vsebinaVnos.getText();
                String dodatno = dodatnoVnos.getText();

                Skatla skatla;
                if (dodatno.matches("\\d+")) {
                    int napetost = Integer.parseInt(dodatno);
                    skatla = new SkatlaZaElektroniko(volumen, barva, vsebina, napetost);
                } else {
                    boolean hladilnik = Boolean.parseBoolean(dodatno);
                    skatla = new SkatlaZaHrano(volumen, barva, vsebina, hladilnik);
                }

                modelTabele.setValueAt(skatla.getVolumen(), izbranaVrstica, 0);
                modelTabele.setValueAt(skatla.getBarva(), izbranaVrstica, 1);
                modelTabele.setValueAt(skatla.prikaziVsebino(), izbranaVrstica, 2);
                modelTabele.setValueAt(dodatno, izbranaVrstica, 3);
            }
        } else if (e.getSource() == odstraniButton) {
            if (izbranaVrstica != -1) {
                // Odstranjevanje izbrane škatle
                modelTabele.removeRow(izbranaVrstica);
                izbranaVrstica = -1;
                volumenVnos.setText("");
                barvaVnos.setText("");
                vsebinaVnos.setText("");
                dodatnoVnos.setText("");
            }
        }
    }

    /**
     * Model tabele za prikaz škatel.
     */
    public static class SkatlaTableModel extends DefaultTableModel {
        /**
         * Konstruktor za inicializacijo modela tabele.
         * Definira stolpce tabele: "Volumen", "Barva", "Vsebina", "Dodatno".
         */
        public SkatlaTableModel() {
            addColumn("Volumen");
            addColumn("Barva");
            addColumn("Vsebina");
            addColumn("Dodatno");
        }

        /**
         * Dodaja nov predmet (škatlo) v tabelo.
         * @param skatla Objekt tipa Skatla, ki se bo dodal v tabelo
         */
        public void addSkatla(Skatla skatla) {
            Object[] vrstica = null;
            if (skatla instanceof SkatlaZaHrano) {
                SkatlaZaHrano sh = (SkatlaZaHrano) skatla;
                vrstica = new Object[]{sh.getVolumen(), sh.getBarva(), sh.prikaziVsebino(), sh.isHladilnik()};
            } else if (skatla instanceof SkatlaZaElektroniko) {
                SkatlaZaElektroniko se = (SkatlaZaElektroniko) skatla;
                vrstica = new Object[]{se.getVolumen(), se.getBarva(), se.prikaziVsebino(), se.getNapetost()};
            }
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

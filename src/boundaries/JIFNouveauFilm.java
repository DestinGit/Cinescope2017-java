/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boundaries;

import daos.ArtisteDAO;
import daos.GenreDAO;
import daos.Globale;
import daos.PaysDAO;
import daos.RubriqueDAO;
import entities.Artiste;
import entities.Genre;
import entities.Pays;
import entities.Rubrique;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author formation
 */
public class JIFNouveauFilm extends javax.swing.JInternalFrame {

    private final Connection icnx;
    private DefaultComboBoxModel genreCbx;
    private DefaultComboBoxModel rubricCbx;
    private DefaultTableModel paysTbl;
    private DefaultTableModel listchoiceTable;
    private boolean listchoiceTable_was_touched = false;
    private String[] lsTab = {"acteurs", "realisateurs", "pays", "projections"};

    /**
     * Creates new form JIFNouveauFilm
     */
    public JIFNouveauFilm() {
        initComponents();
        // Récupérer la connexion
        icnx = Globale.getCnx();
        // Afficher, dans le jComboBox, la liste de tous les genres
        loadGenre();
        // Afficher, dans le jComboBox, la liste de toutes les rubriques
        loadRubric();
        // Afficher, dans le jTable, la liste des pays
        loadListCountries();

//        Date nowDate = new Date();
//        SpinnerModel spMdlYears = new SpinnerDateModel(nowDate, null, null, Calendar.DATE);
//        jSpinnerAnneeProduction.setModel(spMdlYears);
        Date nowDate = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String laDateDuJour = sdf.format(nowDate);
        jTextFieldDateSortie.setText(laDateDuJour);

        SpinnerModel spMdlYears = new SpinnerNumberModel(2000, 2000, 2020, 1);
        jSpinnerAnneeProduction.setModel(spMdlYears);

        SpinnerModel spMdlHours = new SpinnerNumberModel(0, 0, 23, 1);
        jSpinnerDureeHeure.setModel(spMdlHours);

        SpinnerModel spMdlMinutes = new SpinnerNumberModel(0, 0, 59, 1);
        jSpinnerDureeMinute.setModel(spMdlMinutes);

        loadListChoice();

        setVisible(true);
    }

    private void loadListChoice() {
        if (listchoiceTable_was_touched) {
            for (int i = listchoiceTable.getRowCount() - 1; i >= 0; i--) {
                listchoiceTable.removeRow(i);
            }
        }

        // System.out.println(listchoiceTable.getRowCount());
        switch (getSelectedTab()) {
            case 0:
            case 1:
                listArtist();
                break;
            case 2:
                listChoiceCounties();
                break;
            default:
                break;
        }

    }

    private void listArtist() {
        ArtisteDAO dao = new ArtisteDAO(icnx);

        Object[] tLigne = new Object[2];
        listchoiceTable = (DefaultTableModel) jTableListChoice.getModel();
        listchoiceTable_was_touched = true;
        
        List<Artiste> result = dao.selectAll();

        for (Artiste rs : result) {
            tLigne[0] = rs.getIdArtiste();
            tLigne[1] = rs.getNomArtiste();

            listchoiceTable.addRow(tLigne);
        }
    }

    private void listChoiceCounties() {
        PaysDAO dao = new PaysDAO(icnx);
        Object[] tLigne = new Object[2];

        listchoiceTable = (DefaultTableModel) jTableListChoice.getModel();
        listchoiceTable_was_touched = true;
        
        List<Pays> result = dao.selectAll();
        for (Pays rs : result) {
            tLigne[0] = rs.getIdPays();
            tLigne[1] = rs.getNomPays();

            listchoiceTable.addRow(tLigne);
        }

    }

    /**
     * Afficher, dans le comboBox, la liste de tous les genres
     */
    private void loadGenre() {
        GenreDAO dao;
        genreCbx = new DefaultComboBoxModel();

        dao = new GenreDAO(icnx);
        List<Genre> result = dao.selectAll();
        for (Genre rs : result) {
            genreCbx.addElement(rs.getLibelleGenre());
        }
        jComboBoxGenre.setModel(genreCbx);
    }

    private void loadRubric() {
        rubricCbx = new DefaultComboBoxModel();

        RubriqueDAO dao = new RubriqueDAO(icnx);
        List<Rubrique> result = dao.selectAll();
        for (Rubrique rs : result) {
            rubricCbx.addElement(rs.getCodeRubrique());
        }
        jComboBoxRubrique.setModel(rubricCbx);
    }

    /**
     * Afficher, dans le jTable, la liste des pays
     */
    private void loadListCountries() {
        PaysDAO dao;
        Object[] tLigne = new Object[5];

        paysTbl = (DefaultTableModel) jTablePays.getModel();

        dao = new PaysDAO(icnx);
        List<Pays> result = dao.selectAll();
        for (Pays rs : result) {
            tLigne[0] = rs.getIdPays();
            tLigne[1] = rs.getNomPays();
            tLigne[2] = rs.getMasculin();
            tLigne[3] = rs.getFeminin();
            tLigne[4] = rs.getNeutre();

            paysTbl.addRow(tLigne);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldTitre = new javax.swing.JTextField();
        jTextFieldTitreOriginal = new javax.swing.JTextField();
        jTextFieldEntreeSemaine = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldEntreeTotale = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaSynopsis = new javax.swing.JTextArea();
        jSpinnerAnneeProduction = new javax.swing.JSpinner();
        jSpinnerDureeHeure = new javax.swing.JSpinner();
        jLabel8 = new javax.swing.JLabel();
        jSpinnerDureeMinute = new javax.swing.JSpinner();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jSpinnerNombreSemaine = new javax.swing.JSpinner();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jSpinnerCouleurs = new javax.swing.JSpinner();
        jSpinnerInerdiction = new javax.swing.JSpinner();
        jSpinnerPublic = new javax.swing.JSpinner();
        jComboBoxGenre = new javax.swing.JComboBox();
        jComboBoxRubrique = new javax.swing.JComboBox();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableActeurs = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableRealisateurs = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTablePays = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTableProjections = new javax.swing.JTable();
        jButtonAjouter = new javax.swing.JButton();
        jButtonPlus = new javax.swing.JButton();
        jButtonMoins = new javax.swing.JButton();
        jButtonNouveau = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jTextFieldDateSortie = new javax.swing.JTextField();
        jLabelList = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTableListChoice = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Nouveau film");

        jLabel1.setText("Titre");

        jLabel2.setText("Titre original");

        jLabel3.setText("Entrées de la semaine");

        jLabel4.setText("Année de production");

        jLabel5.setText("Durée");

        jLabel6.setText("Synopsis");

        jTextFieldEntreeSemaine.setEditable(false);
        jTextFieldEntreeSemaine.setText("0");

        jLabel7.setText("Total des entrées");

        jTextFieldEntreeTotale.setEditable(false);
        jTextFieldEntreeTotale.setText("0");

        jTextAreaSynopsis.setColumns(20);
        jTextAreaSynopsis.setRows(5);
        jScrollPane1.setViewportView(jTextAreaSynopsis);

        jLabel8.setText("Heure(s)");

        jLabel9.setText("Minute(s)");

        jLabel10.setText("Nombre de semaines");

        jSpinnerNombreSemaine.setEnabled(false);

        jLabel11.setText("Couleurs");

        jLabel12.setText("Interdiction");

        jLabel13.setText("Public");

        jLabel14.setText("Genre");

        jLabel15.setText("Rubrique");

        jComboBoxRubrique.setEnabled(false);

        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        jTableActeurs.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTableActeurs);

        jTabbedPane1.addTab("Acteurs", jScrollPane2);

        jTableRealisateurs.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jTableRealisateurs);

        jTabbedPane1.addTab("Réalisateurs", jScrollPane3);

        jTablePays.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Pays", "Nom Pays", "Masculin", "Feminin", "Neutre"
            }
        ));
        jScrollPane4.setViewportView(jTablePays);

        jTabbedPane1.addTab("Pays", jScrollPane4);

        jTableProjections.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane5.setViewportView(jTableProjections);

        jTabbedPane1.addTab("Projections", jScrollPane5);

        jButtonAjouter.setText("Ajouter");

        jButtonPlus.setText("<<");
        jButtonPlus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPlusActionPerformed(evt);
            }
        });

        jButtonMoins.setText(">>");

        jButtonNouveau.setText("Nouveau");

        jLabel16.setText("Date de sortie");

        jTextFieldDateSortie.setText("2014-8-6");

        jLabelList.setText("Liste des ...");

        jTableListChoice.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "libelle"
            }
        ));
        jScrollPane7.setViewportView(jTableListChoice);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jSpinnerDureeHeure, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
                                        .addComponent(jSpinnerAnneeProduction, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel8)
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jSpinnerDureeMinute, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jTextFieldDateSortie, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jTextFieldEntreeSemaine, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTextFieldEntreeTotale, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jSpinnerNombreSemaine, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jTextFieldTitreOriginal)
                                .addComponent(jTextFieldTitre))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 665, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButtonAjouter, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(38, 38, 38)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel11))
                                        .addGap(72, 72, 72)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jComboBoxGenre, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jSpinnerInerdiction, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jSpinnerPublic, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(116, 116, 116)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jSpinnerCouleurs, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                .addComponent(jButtonNouveau)
                                                                .addComponent(jButtonMoins, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jButtonPlus, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                            .addComponent(jComboBoxRubrique, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(16, 16, 16)
                                        .addComponent(jLabelList, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(37, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldTitre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldTitreOriginal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldEntreeSemaine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jTextFieldEntreeTotale, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jSpinnerNombreSemaine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jSpinnerAnneeProduction, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(jTextFieldDateSortie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jSpinnerDureeHeure, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jSpinnerDureeMinute, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(jSpinnerInerdiction, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSpinnerPublic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(jSpinnerCouleurs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(jComboBoxRubrique, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(4, 4, 4)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBoxGenre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelList)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonPlus)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonMoins)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonNouveau)
                                .addGap(40, 40, 40)))))
                .addGap(29, 29, 29)
                .addComponent(jButtonAjouter, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jTabbedPane1.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
        // TODO add your handling code here:
        System.out.println(jTabbedPane1.getSelectedIndex());
        loadListChoice();
    }//GEN-LAST:event_jTabbedPane1MouseClicked

    private int getSelectedTab() {
        return jTabbedPane1.getSelectedIndex();
    }

    private void jButtonPlusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPlusActionPerformed
        // TODO add your handling code here:
//        switch (getSelectedTab()) {
//            case 0:             
//                break;
//            case 1:
//                break;
//            case 2:
//                break;
//            case 3:
//                break;
//            default:
//                break;
//        }
        System.out.println(lsTab[getSelectedTab()]);
    }//GEN-LAST:event_jButtonPlusActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAjouter;
    private javax.swing.JButton jButtonMoins;
    private javax.swing.JButton jButtonNouveau;
    private javax.swing.JButton jButtonPlus;
    private javax.swing.JComboBox jComboBoxGenre;
    private javax.swing.JComboBox jComboBoxRubrique;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelList;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JSpinner jSpinnerAnneeProduction;
    private javax.swing.JSpinner jSpinnerCouleurs;
    private javax.swing.JSpinner jSpinnerDureeHeure;
    private javax.swing.JSpinner jSpinnerDureeMinute;
    private javax.swing.JSpinner jSpinnerInerdiction;
    private javax.swing.JSpinner jSpinnerNombreSemaine;
    private javax.swing.JSpinner jSpinnerPublic;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTableActeurs;
    private javax.swing.JTable jTableListChoice;
    private javax.swing.JTable jTablePays;
    private javax.swing.JTable jTableProjections;
    private javax.swing.JTable jTableRealisateurs;
    private javax.swing.JTextArea jTextAreaSynopsis;
    private javax.swing.JTextField jTextFieldDateSortie;
    private javax.swing.JTextField jTextFieldEntreeSemaine;
    private javax.swing.JTextField jTextFieldEntreeTotale;
    private javax.swing.JTextField jTextFieldTitre;
    private javax.swing.JTextField jTextFieldTitreOriginal;
    // End of variables declaration//GEN-END:variables
}

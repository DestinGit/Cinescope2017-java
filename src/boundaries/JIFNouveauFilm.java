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
import daos.ProduireDAO;
import daos.RubriqueDAO;
import daos.SalleDAO;
import entities.Artiste;
import entities.Genre;
import entities.Pays;
import entities.Produire;
import entities.Rubrique;
import entities.Salle;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SpinnerListModel;
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
    private DefaultTableModel paysTbl, acteursTbl, realisateursTbl, projectionsTbl;
    private DefaultTableModel listChoiceTable;
    private boolean listChoiceTable_was_touched = false;
    private String[] lsColors = {"Couleurs", "Noi et blanc"};
    private String[] publicAllow = {
        "Tous public", "Public adulte", "Jeune public"
    };
    private String[] publicForbidden = {"Aucune", "-18", "-16", "- 12 ans"};

    /**
     * Creates new form JIFNouveauFilm
     */
    public JIFNouveauFilm() {
        initComponents();
        
        initTableModelVars();
        // Récupérer la connexion
        icnx = Globale.getCnx();

        // Afficher, dans le jComboBox, la liste couleurs
        loadColorsList();
        // Afficher, dans le jComboBox, la liste de tous les genres
        loadGenre();
        // Afficher, dans le jComboBox, la liste de toutes les rubriques
        loadRubric();
        // Afficher, dans le jTable, la liste des pays
//        loadListCountries();

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

        // Afficher, dans le SpinnerListModel, la liste du public autorisé
        SpinnerListModel spMdlAllow = new SpinnerListModel(publicAllow);
        jSpinnerPublic.setModel(spMdlAllow);

        // Afficher, dans le SpinnerListModel, la liste du public autorisé
        SpinnerListModel spMdlForbidden = new SpinnerListModel(publicForbidden);
        jSpinnerInterdiction.setModel(spMdlForbidden);

        // Charger la liste des choix en fonction de la selection de l'onglet
        loadListChoice();
//initialiseGenreList();
        setVisible(true);
    }

    private void initTableModelVars() {
        acteursTbl = (DefaultTableModel) jTableActeurs.getModel();
        realisateursTbl = (DefaultTableModel) jTableRealisateurs.getModel();
        paysTbl = (DefaultTableModel) jTablePays.getModel();
        projectionsTbl = (DefaultTableModel) jTableProjections.getModel();        
    }
//    private void initialiseGenreList() {
//        GenreDAO dao = new GenreDAO(icnx);
//        genreCbx = new DefaultComboBoxModel();
//
//        List<Genre> result = dao.selectAll();
//        for (Genre rs : result) {
//            genreCbx.addElement(rs.getLibelleGenre());
//        }
//
//        jComboBoxGenre.setModel(genreCbx);
//    }
    /**
     * Affiche la liste de choix correspondante
     */
    private void loadListChoice() {
        // tester si la variable "listChoiceTable" a déjà été initialisée
        if (listChoiceTable_was_touched) { // si oui, on vide le tableau
            for (int i = listChoiceTable.getRowCount() - 1; i >= 0; i--) {
                listChoiceTable.removeRow(i);
            }
        }

        // Selon l'onglet selectionné dans jTabbepane
        // on affiche la liste de choix correspondante
        int choice = getSelectedTab();
        switch (choice) {
            case 0:
            case 1:
                jLabelList.setText("Liste des Artistes");
                listChoiceArtist();
                break;
            case 2:
                jLabelList.setText("Liste des Pays");
                listChoiceCounties();
//                listChoiceProduire();
                break;
            case 3:
                jLabelList.setText("Liste des Projections");
                listChoiceSalle();
                break;
            default:
                break;
        }
    }

    /**
     *
     */
    private void listChoiceSalle() {
        SalleDAO dao = new SalleDAO(icnx);
        Object[] tLigne = new Object[2];
        listChoiceTable = (DefaultTableModel) jTableListChoice.getModel();
        listChoiceTable_was_touched = true;

        List<Salle> result = dao.selectAll();
        for (Salle rs : result) {
            tLigne[0] = rs.getIdSalle();
            tLigne[1] = rs.getNomSalle();

            listChoiceTable.addRow(tLigne);
        }
    }

    /**
     * Afficher la liste des Artistes
     */
    private void listChoiceArtist() {
        ArtisteDAO dao = new ArtisteDAO(icnx);

        Object[] tLigne = new Object[2];
        listChoiceTable = (DefaultTableModel) jTableListChoice.getModel();
        listChoiceTable_was_touched = true;

        List<Artiste> result = dao.selectAll();

        for (Artiste rs : result) {
            tLigne[0] = rs.getIdArtiste();
            tLigne[1] = rs.getNomArtiste();

            listChoiceTable.addRow(tLigne);
        }
    }

    private void listChoiceProduire() {
        ProduireDAO dao = new ProduireDAO(icnx);
        Object[] tLigne = new Object[2];

        listChoiceTable = (DefaultTableModel) jTableListChoice.getModel();
        listChoiceTable_was_touched = true;

        List<Produire> result = dao.selectAll();
        for (Produire rs : result) {
            tLigne[0] = rs.getIdPays();
            tLigne[1] = rs.getRangProduction();
            listChoiceTable.addRow(tLigne);
        }
    }

    /**
     * Afficher la liste des choix de Pqys
     */
    private void listChoiceCounties() {
        PaysDAO dao = new PaysDAO(icnx);
        Object[] tLigne = new Object[2];

        listChoiceTable = (DefaultTableModel) jTableListChoice.getModel();
        listChoiceTable_was_touched = true;

        List<Pays> result = dao.selectAll();
        for (Pays rs : result) {
            tLigne[0] = rs.getIdPays();
            tLigne[1] = rs.getNomPays();

            listChoiceTable.addRow(tLigne);
        }

    }

    private void loadColorsList() {
        for (int i = 0; i < lsColors.length; i++) {
            jComboBoxCouleurs.addItem(lsColors[i]);
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
        jSpinnerInterdiction = new javax.swing.JSpinner();
        jSpinnerPublic = new javax.swing.JSpinner();
        jComboBoxCouleurs = new javax.swing.JComboBox();
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
        jComboBoxGenre = new javax.swing.JComboBox<>();

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
                "ID Film", "Acteur", "Rang acteur", "Voix"
            }
        ));
        jScrollPane2.setViewportView(jTableActeurs);

        jTabbedPane1.addTab("Acteurs", jScrollPane2);

        jTableRealisateurs.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Film", "Réalisateur", "Rang réalisateur"
            }
        ));
        jScrollPane3.setViewportView(jTableRealisateurs);

        jTabbedPane1.addTab("Réalisateurs", jScrollPane3);

        jTablePays.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Film", "Pays", "Rang Production"
            }
        ));
        jScrollPane4.setViewportView(jTablePays);

        jTabbedPane1.addTab("Pays", jScrollPane4);

        jTableProjections.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Film", "Salle", "Version projection", "Horaire projection"
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
        jButtonMoins.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMoinsActionPerformed(evt);
            }
        });

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
                                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                                        .addGap(32, 32, 32)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel11)
                                                .addGap(72, 72, 72)
                                                .addComponent(jComboBoxCouleurs, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(72, 72, 72)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(jSpinnerPublic)
                                                    .addComponent(jComboBoxGenre, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGap(122, 122, 122)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jSpinnerInterdiction, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(jButtonNouveau)
                                                        .addComponent(jButtonMoins, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jButtonPlus, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addComponent(jComboBoxRubrique, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))))
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
                    .addComponent(jLabel6)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(jSpinnerInterdiction, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(jComboBoxRubrique, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(42, 42, 42))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel11))
                            .addComponent(jComboBoxCouleurs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(jSpinnerPublic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(jComboBoxGenre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)))
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        int liRow = jTableListChoice.getSelectedRow();

        if (liRow > -1) {
            Object[] tLigne = new Object[getTableNbColumn()];
            for (int i = 0; i < tLigne.length; i++) {
                if (i == 1) {
                    tLigne[i] = jTableListChoice.getValueAt(liRow, 0);
                }
            }

            addRowInTableModel(tLigne);
        }
    }//GEN-LAST:event_jButtonPlusActionPerformed

    private void jButtonMoinsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMoinsActionPerformed
        // TODO add your handling code here:
        int liRow;
        switch (getSelectedTab()) {
            case 0:
                liRow = jTableActeurs.getSelectedRow();
                if(liRow > -1){
                    acteursTbl.removeRow(liRow);
                }
                break;
            case 1:
                liRow = jTableRealisateurs.getSelectedRow();
                if(liRow > -1){
                    realisateursTbl.removeRow(liRow);
                }
                break;
            case 2:
                liRow = jTablePays.getSelectedRow();
                if(liRow > -1){
                    paysTbl.removeRow(liRow);
                }
                break;
            case 3:
                liRow = jTableProjections.getSelectedRow();
                if(liRow > -1){
                    projectionsTbl.removeRow(liRow);
                }
                break;
            default:
                break;
        }
    }//GEN-LAST:event_jButtonMoinsActionPerformed

    /**
     *
     * @param tLigne
     */
    private void addRowInTableModel(Object[] tLigne) {
        
        switch (getSelectedTab()) {
            case 0:
                acteursTbl.addRow(tLigne);
                break;
            case 1:
                realisateursTbl.addRow(tLigne);
                break;
            case 2:
                paysTbl.addRow(tLigne);
                break;
            case 3:
                projectionsTbl.addRow(tLigne);
                break;
            default:
                break;
        }
    }

    /**
     *
     * @return
     */
    private int getTableNbColumn() {
        int nbColumn = 0;
        switch (getSelectedTab()) {
            case 0:
                nbColumn = jTableActeurs.getColumnCount();
                break;
            case 1:
                nbColumn = jTableRealisateurs.getColumnCount();
                break;
            case 2:
                nbColumn = jTablePays.getColumnCount();
                break;
            case 3:
                nbColumn = jTableProjections.getColumnCount();
                break;
            default:
                break;
        }
        return nbColumn;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAjouter;
    private javax.swing.JButton jButtonMoins;
    private javax.swing.JButton jButtonNouveau;
    private javax.swing.JButton jButtonPlus;
    private javax.swing.JComboBox jComboBoxCouleurs;
    private javax.swing.JComboBox<String> jComboBoxGenre;
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
    private javax.swing.JSpinner jSpinnerDureeHeure;
    private javax.swing.JSpinner jSpinnerDureeMinute;
    private javax.swing.JSpinner jSpinnerInterdiction;
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

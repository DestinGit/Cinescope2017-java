package boundaries;

import daos.DepartementDAO;
import daos.Global;
import daos.VilleDAO;
import daos.VilleDepartementDAO;
import entities.Departement;
import entities.Ville;
import entities.VilleDepartement;
import java.awt.Color;
import java.awt.Rectangle;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Timothé
 */
public class JIFCRUDVille extends javax.swing.JInternalFrame {

    //déclaration des variables d'instance
    private DefaultComboBoxModel idcbm = new DefaultComboBoxModel();
    private List<VilleDepartement> lVilleDepartement = new ArrayList<>();
    private List<Departement> lDepartement = new ArrayList<>();
    private DefaultTableModel ldtm;
    private Connection icnx = Global.getCnx();
    // fin des déclaration des variables d'instance

    /**
     * met à jour la liste des villes
     *
     */
    private void resetJtable() {
        try {

            ldtm = (DefaultTableModel) jTable1.getModel();
            VilleDepartementDAO daoVD = new VilleDepartementDAO(icnx);

            for (int j = ldtm.getRowCount() - 1; j >= 0; j--) {
                ldtm.removeRow(j);

            }

            lVilleDepartement = daoVD.selectAll();

            for (int i = 0; i < lVilleDepartement.size(); i++) {
                Object[] tDpt;
                tDpt = lVilleDepartement.get(i).tableauVD(lVilleDepartement.get(i));
                ldtm.addRow(tDpt);
            }

            jTable1.setModel(ldtm);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    /**
     * met a jour la liste des departement dans la jcombobox
     */
    private void JcbReset() {
        DepartementDAO Ddao = new DepartementDAO(icnx);
        lDepartement = Ddao.selectAll();

        for (int i = 0; i < lDepartement.size(); i++) {
            Object[] td = new Object[3];
            for (int j = 0; j < td.length; j++) {
                td = lDepartement.get(i).tableauDepartement(lDepartement.get(i));
            }
            idcbm.addElement(td[2].toString());
        }
        jComboBoxDepartement.setModel(idcbm);
    }

    /**
     *
     * @param str
     * @return
     */
    private boolean ControleCP(String str) {
        boolean out = false;
        String motif = "[0-9]{5}";

        if (!str.matches(motif)) {
            out = false;
        } else {
            out = true;
        }
        return out;
    }

    /**
     * controle la saisie du code de département
     *
     * @param str
     * @return
     */
    private boolean ControleNomV(String str) {
        boolean out = false;

        String wMotif = "[a-zA-Z|[/| |-]]{3,40}";
        if (str.matches(wMotif)) {
            out = true;
        } else {
            out = false;
        }

        return out;
    }

    /**
     * controle si les 2 premier characteres du code postal correspondent au
     * code departement
     *
     * @param jTFNom
     * @param cbDptm
     * @return
     */
    private boolean ControleCPCodeDepartement(String jTFNom, String cbDptm) {
        boolean out = false;
        Departement d = new Departement();
        String cdV2D = jTFNom.substring(0, 2);
        for (int i = 0; i < lDepartement.size() - 1; i++) {
            d = lDepartement.get(i);
            if (cbDptm.equals(d.getNomDepartement().toString())) {
                if (cdV2D.equals(d.getCodeDepartement())) {
                    out = true;
                } else {
                    out = false;
                }
            } else {
            }

        }
        return out;
    }

    /**
     * constructeur
     */
    public JIFCRUDVille() {
        initComponents();
        setVisible(true);

        jLabelMessageEnvoi.setForeground(Color.blue);
        jLabelMessage.setForeground(Color.blue);
        jButtonAnnuler.setEnabled(false);
        jButtonModifier.setEnabled(false);
        jButtonSupprimer.setEnabled(false);
        jButtonValider.setEnabled(false);
        resetJtable();
        JcbReset();

    }/// fin constructeur

    /**
     * controle si les saisie existe déjà
     *
     * @param CP
     * @param nomV
     * @return
     */
    private boolean CDoublon(String CP, String nomV) {
        boolean out = false;

        for (int i = 0; i < ldtm.getRowCount() - 1; i++) {
            if (CP.equals(ldtm.getValueAt(i, 2).toString()) || nomV.equals(ldtm.getValueAt(i, 3).toString())) {
                out = true;
            }
        }

        return out;
    }// Cdoublon

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabelID = new javax.swing.JLabel();
        jLabelCP = new javax.swing.JLabel();
        jLabelNomVille = new javax.swing.JLabel();
        jLabelDepartement = new javax.swing.JLabel();
        jLabelIDSelect = new javax.swing.JLabel();
        jTextFieldCP = new javax.swing.JTextField();
        jTextFieldNVille = new javax.swing.JTextField();
        jComboBoxDepartement = new javax.swing.JComboBox<>();
        jLabelMessage = new javax.swing.JLabel();
        jButtonAjouter = new javax.swing.JButton();
        jButtonSupprimer = new javax.swing.JButton();
        jButtonModifier = new javax.swing.JButton();
        jButtonValider = new javax.swing.JButton();
        jButtonAnnuler = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabelFSaisie = new javax.swing.JLabel();
        jLabelMessageEnvoi = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "FLAG", "ID", "Code Postal", "Nom", "Département"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTable1KeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabelID.setText("ID");

        jLabelCP.setText("Code Postal");

        jLabelNomVille.setText("Nom");

        jLabelDepartement.setText("Département");

        jTextFieldNVille.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNVilleActionPerformed(evt);
            }
        });

        jComboBoxDepartement.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButtonAjouter.setText("Ajouter");
        jButtonAjouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAjouterActionPerformed(evt);
            }
        });

        jButtonSupprimer.setText("Supprimer");
        jButtonSupprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSupprimerActionPerformed(evt);
            }
        });

        jButtonModifier.setText("Modifier");
        jButtonModifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModifierActionPerformed(evt);
            }
        });

        jButtonValider.setText("Valider");
        jButtonValider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonValiderActionPerformed(evt);
            }
        });

        jButtonAnnuler.setText("Annuler");
        jButtonAnnuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAnnulerActionPerformed(evt);
            }
        });

        jLabelFSaisie.setText("Annuler / Valider Toutes les Saisies");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelMessageEnvoi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addComponent(jLabelMessage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelCP, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jTextFieldCP, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelID, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelIDSelect, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelNomVille, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jTextFieldNVille, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelDepartement, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBoxDepartement, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabelFSaisie)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonAnnuler)
                                .addGap(104, 104, 104)
                                .addComponent(jButtonValider)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonAjouter)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonModifier)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonSupprimer))
                    .addComponent(jSeparator1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelIDSelect, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldCP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelCP))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldNVille, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelNomVille))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDepartement)
                    .addComponent(jComboBoxDepartement, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(jLabelMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAjouter)
                    .addComponent(jButtonModifier)
                    .addComponent(jButtonSupprimer))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelFSaisie)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAnnuler)
                    .addComponent(jButtonValider))
                .addGap(18, 18, 18)
                .addComponent(jLabelMessageEnvoi, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        jLabelIDSelect.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString());
        jTextFieldCP.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 2).toString());
        jTextFieldNVille.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 3).toString());
        jComboBoxDepartement.setSelectedItem(jTable1.getValueAt(jTable1.getSelectedRow(), 4).toString());
        jTextFieldCP.setBackground(Color.WHITE);
        jTextFieldNVille.setBackground(Color.WHITE);
        jButtonModifier.setEnabled(true);
        jButtonSupprimer.setEnabled(true);
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTable1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyReleased
        jTable1MouseClicked(null);

    }//GEN-LAST:event_jTable1KeyReleased

    private void jButtonAjouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAjouterActionPerformed
        boolean requestCP = false;
        boolean requestNomV = false;
        boolean requestCPCdD = false;
        boolean requestDouble = false;

        jTextFieldCP.setBackground(Color.WHITE);
        if (jTextFieldCP.getText().trim().equals("") || jTextFieldNVille.getText().trim().equals("")) {
            jLabelMessage.setText("Saisies obligatoires");
        } else {
            requestCP = ControleCP(jTextFieldCP.getText().trim());
            requestNomV = ControleNomV(jTextFieldNVille.getText().trim());
            requestCPCdD = ControleCPCodeDepartement(jTextFieldCP.getText().trim(), jComboBoxDepartement.getSelectedItem().toString());
            requestDouble = CDoublon(jTextFieldCP.getText().trim(), jTextFieldNVille.getText().trim());
            
            if (requestCP == false) {
                jLabelMessage.setText("La Saisie n'est pas un Code postal");
                jTextFieldCP.setBackground(Color.red);
            } else if (requestNomV == false) {
                jLabelMessage.setText("La Saisie n'est pas un nom");
                jTextFieldNVille.setBackground(Color.red);
            } else if (requestCPCdD == false) {
                jLabelMessage.setText("La Saisie ne correspont pas au code du Département");
                jTextFieldCP.setBackground(Color.red);

            } else if (requestDouble == true) {
                jLabelMessage.setText("Le nom de ville ou le code postal existe déjà");
                jTextFieldCP.setBackground(Color.red);
                jTextFieldNVille.setBackground(Color.red);
                
            } else {
                String[] ligne = new String[5];
                ligne[0] = "+"; //flag
                ligne[1] = "";  // id
                ligne[2] = jTextFieldCP.getText(); //code postal
                ligne[3] = jTextFieldNVille.getText(); // nom de la ville
                ligne[4] = jComboBoxDepartement.getSelectedItem().toString(); //departement selectionner dans la ville
                ldtm.addRow(ligne);
                int liMax = jTable1.getRowCount() - 1;
                jTable1.getSelectionModel().setSelectionInterval(liMax, liMax);
                jTable1.scrollRectToVisible(new Rectangle(jTable1.getCellRect(liMax, 0, true)));
                jLabelMessage.setText("La ville \"" + jTextFieldNVille.getText() + "\" a été ajoutée");
                jButtonAnnuler.setEnabled(true);
                jButtonValider.setEnabled(true);

            }
        }
    }//GEN-LAST:event_jButtonAjouterActionPerformed

    private void jButtonModifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModifierActionPerformed
        int liLigneSelectionnee = jTable1.getSelectedRow();

        if (liLigneSelectionnee == -1) {
            jLabelMessage.setText("Veuillez Sélectionner une ligne!");
        } else {
            if (jTextFieldNVille.getText().trim().equals("") || jTextFieldCP.getText().trim().equals("")) {
                jLabelMessage.setText("Saisies obligatoires");
            } else {
                String lsFlag = jTable1.getValueAt(liLigneSelectionnee, 0).toString();
                if (lsFlag.equals("+")) {
                    jTable1.setValueAt(jTextFieldCP.getText(), liLigneSelectionnee, 2);
                    jTable1.setValueAt(jTextFieldNVille.getText(), liLigneSelectionnee, 3);
                    jTable1.setValueAt(jComboBoxDepartement.getSelectedItem().toString(), liLigneSelectionnee, 4);
                    jButtonAnnuler.setEnabled(true);
                    jButtonValider.setEnabled(true);
                } else {
                    jTable1.setValueAt("v", liLigneSelectionnee, 0);
                    jTable1.setValueAt(jTextFieldCP.getText(), liLigneSelectionnee, 2);
                    jTable1.setValueAt(jTextFieldNVille.getText(), liLigneSelectionnee, 3);
                    jTable1.setValueAt(jComboBoxDepartement.getSelectedItem().toString(), liLigneSelectionnee, 4);
                    jButtonAnnuler.setEnabled(true);
                    jButtonValider.setEnabled(true);
                }

            }
        }
    }//GEN-LAST:event_jButtonModifierActionPerformed

    private void jButtonSupprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSupprimerActionPerformed
        int liLigneSelectionnee = jTable1.getSelectedRow();

        if (liLigneSelectionnee != -1) {
            String lsFlag = jTable1.getValueAt(liLigneSelectionnee, 0).toString();
            if (lsFlag.equals("+")) {
                ldtm.removeRow(liLigneSelectionnee);

            } else {
                jTable1.setValueAt("-", liLigneSelectionnee, 0);
                jButtonAnnuler.setEnabled(true);
                jButtonValider.setEnabled(true);
            }
        } else {
            jLabelMessage.setText("Sélectionnez une ligne !!!");
        }
    }//GEN-LAST:event_jButtonSupprimerActionPerformed

    private void jButtonAnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAnnulerActionPerformed
        resetJtable();
        jLabelMessageEnvoi.setText("Vos saisies ont été annulées");
        jButtonAnnuler.setEnabled(false);
        jButtonModifier.setEnabled(false);
        jButtonSupprimer.setEnabled(false);
        jButtonValider.setEnabled(false);
        jLabelMessage.setText(null);
        jLabelIDSelect.setText(null);
        jTextFieldCP.setText(null);
        jTextFieldNVille.setText(null);
    }//GEN-LAST:event_jButtonAnnulerActionPerformed

    private void jButtonValiderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonValiderActionPerformed
        VilleDAO daov = new VilleDAO(icnx);
        DepartementDAO daod = new DepartementDAO(icnx);
        Ville v = new Ville();
        Departement d = new Departement();

        try {
            String lsFlag;
            for (int i = jTable1.getRowCount() - 1; i >= 0; i--) {
                lsFlag = jTable1.getValueAt(i, 0).toString();

                if (lsFlag.equals("+")) {
                    d = daod.selectOne(jTable1.getValueAt(i, 4).toString());
                    v.setCP(jTable1.getValueAt(i, 2).toString());
                    v.setNomVille(jTable1.getValueAt(i, 3).toString());
                    v.setIDDepartement(d.getIdDepartement());
                    System.out.println(v.toString());
                    daov.insert(v);
                }
                if (lsFlag.equals("-")) {
                    v.setIDVille((int) jTable1.getValueAt(i, 1));
                    v.setCP(jTable1.getValueAt(i, 2).toString());
                    v.setNomVille(jTable1.getValueAt(i, 3).toString());
                    System.out.println(v.toString());
                    daov.delete(v);
                }
                if (lsFlag.equals("v")) {
                    d = daod.selectOne(jTable1.getValueAt(i, 4).toString());
                    v.setIDVille((int) jTable1.getValueAt(i, 1));
                    v.setCP(jTable1.getValueAt(i, 2).toString());
                    v.setNomVille(jTable1.getValueAt(i, 3).toString());
                    v.setIDDepartement(d.getIdDepartement());
                    System.out.println(v.toString());
                    daov.update(v);
                }

            }

            icnx.commit();
            jLabelMessageEnvoi.setText("Validations exécutées");
            jButtonAnnuler.setEnabled(false);
            jButtonModifier.setEnabled(false);
            jButtonSupprimer.setEnabled(false);
            jButtonValider.setEnabled(false);
            jLabelMessage.setText(null);
            resetJtable();
            JcbReset();

        } catch (SQLException e) {
            jLabelMessageEnvoi.setText(e.getMessage());
            try {
                icnx.rollback();
            } catch (SQLException ex) {
//                Logger.getLogger(JIFMediaCRUD.class.getName()).log(Level.SEVERE, null, ex);
                jLabelMessageEnvoi.setText(e.getMessage());
            }
        }
    }//GEN-LAST:event_jButtonValiderActionPerformed

    private void jTextFieldNVilleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNVilleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNVilleActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAjouter;
    private javax.swing.JButton jButtonAnnuler;
    private javax.swing.JButton jButtonModifier;
    private javax.swing.JButton jButtonSupprimer;
    private javax.swing.JButton jButtonValider;
    private javax.swing.JComboBox<String> jComboBoxDepartement;
    private javax.swing.JLabel jLabelCP;
    private javax.swing.JLabel jLabelDepartement;
    private javax.swing.JLabel jLabelFSaisie;
    private javax.swing.JLabel jLabelID;
    private javax.swing.JLabel jLabelIDSelect;
    private javax.swing.JLabel jLabelMessage;
    private javax.swing.JLabel jLabelMessageEnvoi;
    private javax.swing.JLabel jLabelNomVille;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextFieldCP;
    private javax.swing.JTextField jTextFieldNVille;
    // End of variables declaration//GEN-END:variables
}

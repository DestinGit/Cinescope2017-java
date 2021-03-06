/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boundaries;

import daos.Globale;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Administrateur
 */
public class JIFGeneriqueNouveauStyle extends javax.swing.JInternalFrame {

    private Connection icnx;
    private DefaultTableModel idtmTable;
    private DefaultTableModel idtmEnr;
//    private JLabel[] tLabels;
//    private JTextField[] tJTexts;
    private String[] tEntetes;
    private String isTable;

    /**
     *
     * @param psTable
     */
    public JIFGeneriqueNouveauStyle(String psTable) {
        initComponents();

        icnx = Globale.getCnx();

        Object[][] tDataTable;
        Object[] tDataLigne;
        PreparedStatement lpst;
        ResultSet lrs;

        isTable = psTable;

        try {
            // --- Connexion a la BD

            lpst = icnx.prepareStatement("SELECT * FROM " + psTable, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            lrs = lpst.executeQuery();

            // --- Recuperation de la structure du curseur
            ResultSetMetaData lrsmd = lrs.getMetaData();

            // --- Nombre de colonnes du curseur
            int liColonnes = lrsmd.getColumnCount();

            // --- Noms des colonnes
            tEntetes = new String[liColonnes];
            for (int i = 0; i < liColonnes; i++) {
                tEntetes[i] = lrsmd.getColumnName(i + 1);
            }

            // --- Pour les donnees de la JTable
            // --- Pour obtenir le nombre de lignes du curseur
            lrs.last();
            int liLignes = lrs.getRow();
            tDataTable = new Object[liLignes][liColonnes];

            lrs.beforeFirst();
            int i = 0;
            // --- Balayage des lignes
            while (lrs.next()) {
                // --- Balayage des colonnes pour construire une ligne
                tDataLigne = new Object[liColonnes];
                for (int j = 0; j < liColonnes; j++) {
                    if (lrs.getObject(j + 1) == null) {
                        tDataLigne[j] = "NUL";
                    } else {
                        tDataLigne[j] = lrs.getObject(j + 1).toString();
                    }
                }
                tDataTable[i] = tDataLigne;
                i++;
            }

            // --- Affectation des tableaux d'objets a la JTable
            idtmTable = new DefaultTableModel(tDataTable, tEntetes);
            jTableTable.setModel(idtmTable);

            // Fermetures
            lrs.close();
            lpst.close();

            idtmEnr = (DefaultTableModel) jTableEnr.getModel();

            for (int j = 0; j < tEntetes.length; j++) {
                //Object object = tDataLigne[j];
                String[] tLigne = new String[2];
                String lsChamp = tEntetes[j];
                tLigne[0] = lsChamp;
                tLigne[1] = "";
                idtmEnr.addRow(tLigne);
            }

        } /// du try
        catch (SQLException e) {
            jLabelMessage.setText(e.getMessage());
        }

        setTitle("CRUD sur la table [" + isTable + "]");
        setVisible(true);

        jLabelMessage.setText("");
    } /// Constructeur

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableTable = new javax.swing.JTable();
        jLabelMessage = new javax.swing.JLabel();
        jButtonCLS = new javax.swing.JButton();
        jButtonInsert = new javax.swing.JButton();
        jButtonDelete = new javax.swing.JButton();
        jButtonUpdate = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableEnr = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jTableTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTableTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableTable);

        jLabelMessage.setText("Message");

        jButtonCLS.setText("CLS");
        jButtonCLS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCLSActionPerformed(evt);
            }
        });

        jButtonInsert.setText("Insert");
        jButtonInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInsertActionPerformed(evt);
            }
        });

        jButtonDelete.setText("Delete");
        jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteActionPerformed(evt);
            }
        });

        jButtonUpdate.setText("Update");
        jButtonUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdateActionPerformed(evt);
            }
        });

        jTableEnr.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Clé", "Valeur"
            }
        ));
        jScrollPane3.setViewportView(jTableEnr);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(jLabelMessage)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonCLS)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonInsert)
                        .addGap(54, 54, 54)
                        .addComponent(jButtonDelete)
                        .addGap(67, 67, 67)
                        .addComponent(jButtonUpdate))
                    .addComponent(jScrollPane3))
                .addContainerGap(430, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(116, 116, 116)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCLS)
                    .addComponent(jButtonInsert)
                    .addComponent(jButtonDelete)
                    .addComponent(jButtonUpdate))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 157, Short.MAX_VALUE)
                .addComponent(jLabelMessage)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTableTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableTableMouseClicked
        // 
        int liRow = jTableTable.getSelectedRow();
        for (int i = 0; i < jTableTable.getColumnCount(); i++) {
            //tJTexts[i].setText(jTableTable.getValueAt(liRow, i).toString());
            idtmEnr.setValueAt(jTableTable.getValueAt(liRow, i), i, 1);
        }
    }//GEN-LAST:event_jTableTableMouseClicked

    private void jButtonCLSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCLSActionPerformed
        // 
//        for (int i = 0; i < tJTexts.length; i++) {
//            tJTexts[i].setText("");
//        }
//        tJTexts[0].requestFocus();
        for (int i = 0; i < jTableEnr.getRowCount(); i++) {
            idtmEnr.setValueAt("", i, 1);
        }
    }//GEN-LAST:event_jButtonCLSActionPerformed

    private void jButtonInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInsertActionPerformed
        // 
        System.out.println(tEntetes.length);
        String[] tNew = new String[tEntetes.length];
        for (int i = 0; i < tEntetes.length; i++) {
            tNew[i] = jTableEnr.getValueAt(i, 1).toString();
        }
        idtmTable.addRow(tNew);

        String lsSQL = "INSERT INTO " + isTable + "(";
//        String lsColonnes = "";
//        for (int i = 0; i < tEntetes.length; i++) {
//            lsColonnes += tEntetes[i] + ",";
//        }
//        lsColonnes = lsColonnes.substring(0, lsColonnes.length() - 1);

        String lsColonnes;
        lsColonnes = String.join(",", tEntetes);
        System.out.println("Colonnes : " + lsColonnes);

        lsSQL += lsColonnes + ") VALUES(";
        String lsValeurs = "";
        for (int i = 0; i < tEntetes.length; i++) {
            lsValeurs += "?,";
        }
        lsValeurs = lsValeurs.substring(0, lsValeurs.length() - 1);

        lsSQL += lsValeurs;
        lsSQL += ")";

        System.out.println(lsSQL);

        try {
            PreparedStatement lpst = icnx.prepareStatement(lsSQL);
            lpst.setInt(1, Types.NULL);
            for (int i = 1; i < tNew.length; i++) {
                lpst.setString(i + 1, tNew[i]);
            }
            lpst.executeUpdate();
            icnx.commit();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        jButtonCLSActionPerformed(null);
    }//GEN-LAST:event_jButtonInsertActionPerformed

    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
        // 
        int liRow = jTableTable.getSelectedRow();
        String lsID = jTableTable.getValueAt(liRow, 0).toString();
        if (liRow >= 0) {
            System.out.println(tEntetes.length);
//            String[] tNew = new String[tEntetes.length];
//            for (int i = 0; i < tEntetes.length; i++) {
//                tNew[i] = jTableEnr.getValueAt(i, 1).toString();
//            }
            idtmTable.removeRow(liRow);

            String lsSQL = "DELETE FROM " + isTable + " WHERE " + tEntetes[0] + " = ?";

            System.out.println(lsSQL);

            try {
                PreparedStatement lpst = icnx.prepareStatement(lsSQL);
                lpst.setString(1, lsID);
                lpst.executeUpdate();
                icnx.commit();
                jButtonCLSActionPerformed(null);

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        } else {
            jLabelMessage.setText("Abruti, sélectionne au moins une ligne !!!");
        }
    }//GEN-LAST:event_jButtonDeleteActionPerformed

    private void jButtonUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdateActionPerformed
        int liRow = jTableTable.getSelectedRow();
        if (liRow >= 0) {
            System.out.println(tEntetes.length);
            String[] tValeurs = new String[tEntetes.length];
            for (int i = 0; i < tEntetes.length; i++) {
                tValeurs[i] = jTableEnr.getValueAt(i, 1).toString();
            }
            String lsSET = " SET ";
            for (int i = 1; i < tEntetes.length; i++) {
                lsSET += tEntetes[i] + "=?,";
            }
            lsSET = lsSET.substring(0, lsSET.length() - 1);

            String lsSQL = "UPDATE " + isTable + " " + lsSET + " WHERE " + tEntetes[0] + " = ?";

            System.out.println(lsSQL);

            try {
                PreparedStatement lpst = icnx.prepareStatement(lsSQL);
                for (int i = 1; i < tValeurs.length; i++) {
                    lpst.setString(i, tValeurs[i]);
                }
                lpst.setString(tValeurs.length, tValeurs[0]);
                lpst.executeUpdate();
                icnx.commit();
//                jButtonCLSActionPerformed(null);

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        } else {
            jLabelMessage.setText("Abruti, sélectionne au moins une ligne !!!");
        }
    }//GEN-LAST:event_jButtonUpdateActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCLS;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonInsert;
    private javax.swing.JButton jButtonUpdate;
    private javax.swing.JLabel jLabelMessage;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTableEnr;
    private javax.swing.JTable jTableTable;
    // End of variables declaration//GEN-END:variables
}

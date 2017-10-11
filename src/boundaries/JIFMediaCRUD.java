package boundaries;
/*
 JTable
 Flags"SQl embarqué"
 */

import java.awt.Rectangle;
import daos.Globale;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author pascal
 */
public class JIFMediaCRUD extends javax.swing.JInternalFrame {

    private Connection icn;
    private DefaultTableModel idtm;

    /**
     * Creates new form JIFMediaCRUD
     */
    public JIFMediaCRUD() {
        initComponents();

        setTitle("CRUD Media");

        remplirJTable();

        setVisible(true);
    } /// constructeur

    /**
     *
     */
    private void remplirJTable() {

        idtm = (DefaultTableModel) jTableMedia.getModel();

        for (int i = idtm.getRowCount() - 1; i >= 0; i--) {
            idtm.removeRow(i);
        }

        try {
            // --- Connexion
//            Class.forName("org.gjt.mm.mysql.Driver");
//            String lsDSN = "jdbc:mysql://127.0.0.1:3306/cinescope2014";
//            icn = DriverManager.getConnection(lsDSN, "root", "");

            icn = Globale.getCnx();

            String lsSQL;
            PreparedStatement lpst;
            ResultSet lrs;

            lsSQL = "SELECT * FROM media ORDER BY 2";
            lsSQL = "{CALL media_select_all()}";
            lpst = icn.prepareStatement(lsSQL);
            lrs = lpst.executeQuery();

            Object[] tLigne;

            while (lrs.next()) {
                tLigne = new Object[3];

                tLigne[0] = "";
                tLigne[1] = lrs.getString(1);
                tLigne[2] = lrs.getString(2);

                idtm.addRow(tLigne);
            }

            lrs.close();
            lpst.close();

            jLabelMessage.setText("Okay !!!");

        } catch (SQLException ex) {
            jLabelMessage.setText(ex.getMessage());
        }
    } /// remplirJTable

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableMedia = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabelMessage = new javax.swing.JLabel();
        jTextFieldNom = new javax.swing.JTextField();
        jButtonAjouter = new javax.swing.JButton();
        jButtonSupprimer = new javax.swing.JButton();
        jButtonModifier = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabelID = new javax.swing.JLabel();
        jButtonAnnuler = new javax.swing.JButton();
        jButtonValider = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosing(evt);
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        jTableMedia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Flag", "ID", "Nom"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableMedia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableMediaMouseClicked(evt);
            }
        });
        jTableMedia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTableMediaKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTableMedia);

        jLabel2.setText("Nom");

        jLabelMessage.setText("Message");

        jTextFieldNom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNomActionPerformed(evt);
            }
        });

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

        jLabel5.setText("ID");

        jLabelID.setForeground(new java.awt.Color(255, 0, 51));
        jLabelID.setText("ID");

        jButtonAnnuler.setText("Annuler");
        jButtonAnnuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAnnulerActionPerformed(evt);
            }
        });

        jButtonValider.setText("Valider");
        jButtonValider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonValiderActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 616, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel2))
                                .addGap(58, 58, 58)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldNom, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelID, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButtonModifier)
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jButtonValider, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jButtonSupprimer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                            .addComponent(jButtonAjouter)
                            .addComponent(jButtonAnnuler))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabelID))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAjouter)
                    .addComponent(jButtonModifier)
                    .addComponent(jButtonSupprimer))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAnnuler)
                    .addComponent(jButtonValider))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(jLabelMessage)
                .addGap(10, 10, 10))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        //

//        try {
//            icn.close();
//        } catch (SQLException e) {
//            System.err.println(e.getMessage());
//        }
    }//GEN-LAST:event_formInternalFrameClosing

    private void jButtonAjouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAjouterActionPerformed
        //
        if (jTextFieldNom.getText().trim().equals("")) {
            jLabelMessage.setText("Saisies obligatoires");
        } else {
//            try {
//                String lsSQL;
//                lsSQL = "INSERT INTO media(id_media, nom_media) VALUES(?,?)";
//                lsSQL = "{CALL media_insert(?,?)}";
//                PreparedStatement lpst = icn.prepareStatement(lsSQL);
//                
//                lpst.setInt(1, Types.NULL);
//                lpst.setString(2, jTextFieldNom.getText());
//                
//                lpst.executeUpdate();
//                
//                icn.commit();
//                lpst.close();
//                // Maj jtable
//                String[] tLigne = new String[2];
//                tLigne[0] = "";
//                tLigne[1] = jTextFieldNom.getText();
//                idtm.addRow(tLigne);
//                jLabelMessage.setText("Okay !!!");
//            } catch (SQLException e) {
//                jLabelMessage.setText(e.getMessage());
//                System.err.println(e.getMessage());
//            }
            String[] ligne = new String[3];
            ligne[0] = "+";
            ligne[1] = "";
            ligne[2] = jTextFieldNom.getText();
            idtm.addRow(ligne);
            int liMax = jTableMedia.getRowCount() - 1;
            jTableMedia.getSelectionModel().setSelectionInterval(liMax, liMax);
            jTableMedia.scrollRectToVisible(new Rectangle(jTableMedia.getCellRect(liMax, 0, true)));
        }
    }//GEN-LAST:event_jButtonAjouterActionPerformed

    private void jButtonModifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModifierActionPerformed
        //
        int liLigneSelectionnee = jTableMedia.getSelectedRow();

        if (liLigneSelectionnee == -1) {
            jLabelMessage.setText("Sélectionnez une ligne !!!");
        } else {
            if (jTextFieldNom.getText().trim().equals("")) {
                jLabelMessage.setText("Saisies obligatoires");
            } else {
                String lsFlag = jTableMedia.getValueAt(liLigneSelectionnee, 0).toString();
                if (lsFlag.equals("+")) {
                    jTableMedia.setValueAt(jTextFieldNom.getText(), liLigneSelectionnee, 2);
                } else {
                    jTableMedia.setValueAt("v", liLigneSelectionnee, 0);
                    jTableMedia.setValueAt(jTextFieldNom.getText(), liLigneSelectionnee, 2);
                }
//                try {
//                    String lsSQL;
//                    lsSQL = "UPDATE media SET nom_media=? WHERE id_media=?";
//                    // mediaUpdate(paramID_MEDIA INT(10),paramNOM_MEDIA VARCHAR(254))
//                    lsSQL = "{CALL media_update(?,?)}";
//
//                    PreparedStatement lpst = icn.prepareStatement(lsSQL);
//
//                    lpst.setString(1, jLabelID.getText());
//                    lpst.setString(2, jTextFieldNom.getText());
//
//                    lpst.executeUpdate();
//
//                    icn.commit();
//                    lpst.close();
//
//                    jTableMedia.setValueAt(jTextFieldNom.getText(), liLigneSelectionnee, 1);
//
//                    jLabelMessage.setText("Okay !!!");
//                } catch (SQLException e) {
//                    jLabelMessage.setText(e.getMessage());
//                    System.err.println(e.getMessage());
//                }
            }
        }
    }//GEN-LAST:event_jButtonModifierActionPerformed

    private void jButtonSupprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSupprimerActionPerformed
        //
        int liLigneSelectionnee = jTableMedia.getSelectedRow();

        if (liLigneSelectionnee != -1) {
            String lsFlag = jTableMedia.getValueAt(liLigneSelectionnee, 0).toString();
            if (lsFlag.equals("+")) {
                idtm.removeRow(liLigneSelectionnee);
            } else {
                jTableMedia.setValueAt("-", liLigneSelectionnee, 0);
            }
        } else {
            jLabelMessage.setText("Sélectionnez une ligne !!!");
        }
    }//GEN-LAST:event_jButtonSupprimerActionPerformed

    private void jTableMediaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMediaMouseClicked
        //
        int liLigne = jTableMedia.getSelectedRow();

        String lsID = jTableMedia.getValueAt(liLigne, 1).toString();
        String lsNom = jTableMedia.getValueAt(liLigne, 2).toString();

        jLabelID.setText(lsID);
        jTextFieldNom.setText(lsNom);
    }//GEN-LAST:event_jTableMediaMouseClicked

    private void jTextFieldNomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNomActionPerformed

    private void jTableMediaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableMediaKeyReleased
        // 
        jTableMediaMouseClicked(null);
    }//GEN-LAST:event_jTableMediaKeyReleased

    private void jButtonAnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAnnulerActionPerformed
        for (int i = jTableMedia.getRowCount() - 1; i >= 0; i--) {
            if (jTableMedia.getValueAt(i, 0).toString().equals("+")) {
                idtm.removeRow(i);
            } else {
                jTableMedia.setValueAt("", i, 0);
            }
        }
    }//GEN-LAST:event_jButtonAnnulerActionPerformed

    private void jButtonValiderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonValiderActionPerformed
        // 
        String lsInsert = "CALL media_insert(?,?)";
        String lsDelete = "CALL media_delete(?)";
        String lsUpdate = "CALL media_update(?,?)";
        try {

            PreparedStatement lpstInsert = icn.prepareStatement(lsInsert);
            PreparedStatement lpstDelete = icn.prepareStatement(lsDelete);
            PreparedStatement lpstUpdate = icn.prepareStatement(lsUpdate);

            String lsFlag;
            for (int i = jTableMedia.getRowCount() - 1; i >= 0; i--) {
                lsFlag = jTableMedia.getValueAt(i, 0).toString();
                if (lsFlag.equals("+")) {
                    lpstInsert.setInt(1, Types.NULL);
                    lpstInsert.setString(2, jTableMedia.getValueAt(i, 2).toString());
                    jTableMedia.setValueAt("", i, 0);
                    lpstInsert.executeUpdate();
                }
                if (lsFlag.equals("-")) {
                    lpstDelete.setString(1, jTableMedia.getValueAt(i, 1).toString());
                    lpstDelete.executeUpdate();
                    idtm.removeRow(i);
                }
                if (lsFlag.equals("v")) {
                    lpstUpdate.setString(1, jTableMedia.getValueAt(i, 1).toString());
                    lpstUpdate.setString(2, jTableMedia.getValueAt(i, 2).toString());
                    lpstUpdate.executeUpdate();
                    jTableMedia.setValueAt("", i, 0);
                }

            }
            icn.commit();
            jLabelMessage.setText("Validations exécutées");
            remplirJTable();
        } catch (SQLException e) {
            try {
                icn.rollback();
            } catch (SQLException ex) {
                Logger.getLogger(JIFMediaCRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButtonValiderActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAjouter;
    private javax.swing.JButton jButtonAnnuler;
    private javax.swing.JButton jButtonModifier;
    private javax.swing.JButton jButtonSupprimer;
    private javax.swing.JButton jButtonValider;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelID;
    private javax.swing.JLabel jLabelMessage;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableMedia;
    private javax.swing.JTextField jTextFieldNom;
    // End of variables declaration//GEN-END:variables
}

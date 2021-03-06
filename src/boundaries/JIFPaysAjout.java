/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boundaries;

import bdd.paysModel;
import daos.Globale;
import daos.PaysDAO;
import entities.Pays;
import java.sql.Connection;

/**
 *
 * @author formation
 */
public class JIFPaysAjout extends javax.swing.JInternalFrame {
private Connection icnx;
private PaysDAO dao;
    /**
     * Creates new form JIFPaysAjout
     */
    public JIFPaysAjout() {
        initComponents();
        icnx = Globale.getCnx();
        dao = new PaysDAO(icnx);
//        resetFields();
//        jLabelMessage.setText(null);
        
        setVisible(true);
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
        jTextFieldNomPays = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldNomMasculin = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldNomFeminin = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldNomNeutre = new javax.swing.JTextField();
        jButtonAjouter = new javax.swing.JButton();
        jLabelMessage = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Ajout Pays");

        jLabel1.setText("Nom du pays");

        jLabel2.setText("Masculin");

        jLabel3.setText("Féminin");

        jLabel4.setText("Neutre");

        jButtonAjouter.setText("Ajouter");
        jButtonAjouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAjouterActionPerformed(evt);
            }
        });

        jLabelMessage.setText("Message");

        jLabel5.setText("Veuillez remplir tous les champs pour ajouter un pays");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonAjouter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextFieldNomPays)
                                    .addComponent(jTextFieldNomMasculin)
                                    .addComponent(jTextFieldNomFeminin)
                                    .addComponent(jTextFieldNomNeutre, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelMessage))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelMessage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldNomPays, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldNomMasculin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldNomFeminin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldNomNeutre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(27, 27, 27)
                .addComponent(jButtonAjouter)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAjouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAjouterActionPerformed
        // TODO add your handling code here:
        // test if there is an empty field
        if (jTextFieldNomPays.getText().isEmpty() || jTextFieldNomMasculin.getText().isEmpty()
                || jTextFieldNomFeminin.getText().isEmpty() || jTextFieldNomNeutre.getText().isEmpty()) {
            
            jLabelMessage.setText("Tous les champs sont obligatoires");
            
        } else { // No fields empty. Insertion in the database
            Pays d = new Pays(jTextFieldNomPays.getText().toString(), jTextFieldNomMasculin.getText().toString(),
            jTextFieldNomFeminin.getText().toString(), jTextFieldNomNeutre.getText().toString());
            
            dao.insert(d);
            
            jLabelMessage.setText("Le Pays " + jTextFieldNomPays.getText() + " a été rajouter avec succes");
            
            resetFields();
        }
    }//GEN-LAST:event_jButtonAjouterActionPerformed
    
    private void resetFields() {
        jTextFieldNomPays.setText(null);
        jTextFieldNomMasculin.setText(null);
        jTextFieldNomFeminin.setText(null);
        jTextFieldNomNeutre.setText(null);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAjouter;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelMessage;
    private javax.swing.JTextField jTextFieldNomFeminin;
    private javax.swing.JTextField jTextFieldNomMasculin;
    private javax.swing.JTextField jTextFieldNomNeutre;
    private javax.swing.JTextField jTextFieldNomPays;
    // End of variables declaration//GEN-END:variables
}

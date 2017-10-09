/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boundaries;

import connexion.Connexion;
import daos.Globale;
import java.awt.Frame;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;

/**
 *
 * @author formation
 */
public class MDI extends javax.swing.JFrame {
    private Connection icnx;
    /**
     * Creates new form MDI
     */
    public MDI() {
        initComponents();

        
        setTitle("MDI - Cinéscope 2017");
        setLocationRelativeTo(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);

//         icnx = Connexion.getConnectionMySQL("mysql-yemeialways.alwaysdata.net", "yemeialways_cine2017", "3306", "143657", "YemeiAlways@01");
         icnx = Connexion.getConnectionMySQL("127.0.0.1", "cinescope2017", "3306", "root", "");
         Globale.setCnx(icnx);
         
//        openMenuItemActionPerformed(null);
//        saveMenuItemActionPerformed(null);
//        supMenuItemActionPerformed(null);
//        delMenuItemActionPerformed(null); 
//        transfertMenuItemActionPerformed(null);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        menuBar = new javax.swing.JMenuBar();
        editMenu = new javax.swing.JMenu();
        transfertMenuItem = new javax.swing.JMenuItem();
        copyMenuItem = new javax.swing.JMenuItem();
        deleteMenuItem = new javax.swing.JMenuItem();
        fileMenu = new javax.swing.JMenu();
        openMenuItem = new javax.swing.JMenuItem();
        supMenuItem = new javax.swing.JMenuItem();
        delMenuItem = new javax.swing.JMenuItem();
        saveMenuItem = new javax.swing.JMenuItem();
        editMenuItem = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        jMenuItem11 = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        jMenuItem15 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItemHorizontale = new javax.swing.JMenuItem();
        jMenuItemVerticale = new javax.swing.JMenuItem();
        jMenuItemCascade = new javax.swing.JMenuItem();
        jMenuItemFermer = new javax.swing.JMenuItem();
        jMenuItemFermerTout = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        contentMenuItem = new javax.swing.JMenuItem();
        aboutMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        editMenu.setMnemonic('e');
        editMenu.setText("Fichier");

        transfertMenuItem.setText("Transfert CSV 2 BD");
        transfertMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transfertMenuItemActionPerformed(evt);
            }
        });
        editMenu.add(transfertMenuItem);

        copyMenuItem.setMnemonic('y');
        copyMenuItem.setText("Se déconnecter");
        editMenu.add(copyMenuItem);

        deleteMenuItem.setMnemonic('d');
        deleteMenuItem.setText("Quitter");
        editMenu.add(deleteMenuItem);

        menuBar.add(editMenu);

        fileMenu.setMnemonic('f');
        fileMenu.setText("CRUD");

        openMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.SHIFT_MASK));
        openMenuItem.setMnemonic('o');
        openMenuItem.setText("Pays(Ajouter)");
        openMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(openMenuItem);

        supMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.SHIFT_MASK));
        supMenuItem.setText("Pays (Suppression)");
        supMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(supMenuItem);

        delMenuItem.setText("Pays (Delete)");
        delMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(delMenuItem);

        saveMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.SHIFT_MASK));
        saveMenuItem.setMnemonic('s');
        saveMenuItem.setText("Pays(Visualisation)");
        saveMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(saveMenuItem);

        editMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.SHIFT_MASK));
        editMenuItem.setText("Pays (Modification)");
        editMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(editMenuItem);
        fileMenu.add(jSeparator1);

        jMenuItem3.setText("Arrondissements CRUD");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        fileMenu.add(jMenuItem3);

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.SHIFT_MASK));
        jMenuItem4.setText("Départements CRUD");
        fileMenu.add(jMenuItem4);

        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.SHIFT_MASK));
        jMenuItem5.setText("Villes CRUD");
        fileMenu.add(jMenuItem5);
        fileMenu.add(jSeparator3);

        jMenuItem6.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.SHIFT_MASK));
        jMenuItem6.setText("Genres CRUD");
        fileMenu.add(jMenuItem6);

        jMenuItem7.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.SHIFT_MASK));
        jMenuItem7.setText("Rubriques CRUD");
        fileMenu.add(jMenuItem7);
        fileMenu.add(jSeparator2);

        jMenuItem8.setText("Media (CRUD)");
        fileMenu.add(jMenuItem8);

        jMenuItem9.setText("Appréciation (CRUD)");
        fileMenu.add(jMenuItem9);

        jMenuItem10.setText("Journalistes (CRUD)");
        fileMenu.add(jMenuItem10);
        fileMenu.add(jSeparator4);

        jMenuItem11.setText("Cinémas (Ajout)");
        fileMenu.add(jMenuItem11);
        fileMenu.add(jSeparator5);

        jMenuItem12.setText("Générique (CRUD)");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        fileMenu.add(jMenuItem12);

        menuBar.add(fileMenu);

        jMenu2.setText("Chaque semaine");

        jMenuItem13.setText("Articles (CRUD)");
        jMenu2.add(jMenuItem13);

        jMenuItem14.setText("Apprécrier (CRUD)");
        jMenu2.add(jMenuItem14);
        jMenu2.add(jSeparator6);

        jMenuItem15.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem15.setText("Films (Ajout)");
        jMenu2.add(jMenuItem15);

        menuBar.add(jMenu2);

        jMenu1.setText("Fenêtre");

        jMenuItemHorizontale.setText("Horizontale");
        jMenuItemHorizontale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemHorizontaleActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemHorizontale);

        jMenuItemVerticale.setText("Verticale");
        jMenuItemVerticale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemVerticaleActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemVerticale);

        jMenuItemCascade.setText("Cascade");
        jMenuItemCascade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCascadeActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemCascade);

        jMenuItemFermer.setText("Fermer");
        jMenuItemFermer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemFermerActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemFermer);

        jMenuItemFermerTout.setText("Fermer tout");
        jMenuItemFermerTout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemFermerToutActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemFermerTout);

        menuBar.add(jMenu1);

        helpMenu.setMnemonic('h');
        helpMenu.setText("Help");

        contentMenuItem.setMnemonic('c');
        contentMenuItem.setText("Contents");
        helpMenu.add(contentMenuItem);

        aboutMenuItem.setMnemonic('a');
        aboutMenuItem.setText("About");
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 491, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 399, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void openMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openMenuItemActionPerformed
        // TODO add your handling code here:
        JIFPaysAjout jif = new JIFPaysAjout();
        this.desktopPane.add(jif);
    }//GEN-LAST:event_openMenuItemActionPerformed

    private void saveMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveMenuItemActionPerformed
        // TODO add your handling code here:
        JIFPaysVisu jif = new JIFPaysVisu();
        this.desktopPane.add(jif);
    }//GEN-LAST:event_saveMenuItemActionPerformed

    private void jMenuItemFermerToutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemFermerToutActionPerformed
        // TODO add your handling code here:
        JDesktopPane jdpBureau = this.desktopPane;

        JInternalFrame[] tFrames = jdpBureau.getAllFrames();
        try {
            for (int i = 0; i < tFrames.length; ++i) {
                tFrames[i].setClosed(true);
            }
        } catch (PropertyVetoException e) {
        }
    }//GEN-LAST:event_jMenuItemFermerToutActionPerformed


    private void jMenuItemFermerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemFermerActionPerformed
        // TODO add your handling code here:
        JDesktopPane jdpBureau = this.desktopPane;

        JInternalFrame[] tFrames = jdpBureau.getAllFrames();
        try {
            if (tFrames.length > 0) {
                tFrames[0].setClosed(true);
            }
        } catch (PropertyVetoException e) {
        }
    }//GEN-LAST:event_jMenuItemFermerActionPerformed

    private void jMenuItemHorizontaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemHorizontaleActionPerformed
        // TODO add your handling code here:
        JDesktopPane jdpBureau = this.desktopPane;

        JInternalFrame[] tFrames = jdpBureau.getAllFrames();

        try {
            int ly = 0;

            int liLargeurBureau = jdpBureau.getWidth();
            int liHauteurBureau = jdpBureau.getHeight();
            int liHauteur = liHauteurBureau / tFrames.length;

            for (int i = tFrames.length - 1; i >= 0; i--) {
                tFrames[i].setBounds(0, ly, liLargeurBureau, liHauteur);
                ly += liHauteur;
            }

        } catch (Exception e) {
        }

    }//GEN-LAST:event_jMenuItemHorizontaleActionPerformed

    private void jMenuItemVerticaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemVerticaleActionPerformed
        // TODO add your handling code here:
        JDesktopPane jdpBureau = this.desktopPane;

        JInternalFrame[] tFrames = jdpBureau.getAllFrames();
        try {
            int lx = 0;

            int liLargeurBureau = jdpBureau.getWidth();
            int liHauteurBureau = jdpBureau.getHeight();
            int liLargeur = liLargeurBureau / tFrames.length;

            for (int i = tFrames.length - 1; i >= 0; i--) {
                tFrames[i].setBounds(lx, 0, liLargeur, liHauteurBureau);
                lx += liLargeur;
            }

        } catch (Exception e) {
        }

    }//GEN-LAST:event_jMenuItemVerticaleActionPerformed

    private void jMenuItemCascadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCascadeActionPerformed
        // TODO add your handling code here:
        // desktopPane: récupère l'object bureau
        JDesktopPane jdpBureau = this.desktopPane;
        // Récupère tous les internales Frames ouvertes 
        JInternalFrame[] tFrames = jdpBureau.getAllFrames();
        try {
            int lx = 0, ly = 0;

            for (int i = tFrames.length - 1; i >= 0; i--) {
                // Arbitrairement a 500 sur 300
                tFrames[i].setBounds(lx, ly, 500, 300);
                lx += 30;
                ly += 30;
            }

        } catch (Exception e) {
        }

    }//GEN-LAST:event_jMenuItemCascadeActionPerformed

    private void supMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supMenuItemActionPerformed
        // TODO add your handling code here:
        JIFPaysSuppression jif = new JIFPaysSuppression();
        this.desktopPane.add(jif);
    }//GEN-LAST:event_supMenuItemActionPerformed

    private void delMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delMenuItemActionPerformed
        // TODO add your handling code here:
        JIFPaysDelete jif = new JIFPaysDelete();
        this.desktopPane.add(jif);
    }//GEN-LAST:event_delMenuItemActionPerformed

    private void editMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editMenuItemActionPerformed
        // TODO add your handling code here:
        JIFPaysModification jif = new JIFPaysModification();
        this.desktopPane.add(jif);        
    }//GEN-LAST:event_editMenuItemActionPerformed

    private void transfertMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transfertMenuItemActionPerformed
        // TODO add your handling code here:
        JIFTransfertFile jif = new JIFTransfertFile();
        this.desktopPane.add(jif);
    }//GEN-LAST:event_transfertMenuItemActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        JIFArrondissement jif = new JIFArrondissement();
        this.desktopPane.add(jif);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        Connexion.disconnection(icnx);
    }//GEN-LAST:event_formWindowClosing

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        // TODO add your handling code here:
        JIFGeneriqueNouveauStyle jif = new JIFGeneriqueNouveauStyle("pays");
        this.desktopPane.add(jif);
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(MDI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(MDI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(MDI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(MDI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new MDI().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JMenuItem contentMenuItem;
    private javax.swing.JMenuItem copyMenuItem;
    private javax.swing.JMenuItem delMenuItem;
    private javax.swing.JMenuItem deleteMenuItem;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenuItem editMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JMenuItem jMenuItemCascade;
    private javax.swing.JMenuItem jMenuItemFermer;
    private javax.swing.JMenuItem jMenuItemFermerTout;
    private javax.swing.JMenuItem jMenuItemHorizontale;
    private javax.swing.JMenuItem jMenuItemVerticale;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem openMenuItem;
    private javax.swing.JMenuItem saveMenuItem;
    private javax.swing.JMenuItem supMenuItem;
    private javax.swing.JMenuItem transfertMenuItem;
    // End of variables declaration//GEN-END:variables

}

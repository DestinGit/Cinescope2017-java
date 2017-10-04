/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package boundaries;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author formation
 */
public class JIFPaysVisu extends javax.swing.JInternalFrame {

    /**
     * Creates new form JIFPaysVisu
     */
    public JIFPaysVisu() {
        initComponents();

        
        try {
	Class.forName("org.gjt.mm.mysql.Driver");
	Connection lcn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/cinescope2017", "root", "");

	PreparedStatement lpst = lcn.prepareStatement("SELECT * FROM pays");
	ResultSet lrs = lpst.executeQuery();

	Object[] tLigne;

	DefaultTableModel ldtm = (DefaultTableModel)jTablePays.getModel();

	while(lrs.next()) {
		tLigne = new Object[5];

		tLigne[0] = lrs.getString(1);
		tLigne[1] = lrs.getString(2);
		tLigne[2] = lrs.getString(3);
		tLigne[3] = lrs.getString(4);
		tLigne[4] = lrs.getString(5);

		ldtm.addRow(tLigne);
	}

	lrs.close();
	lpst.close();
	lcn.close();

	jLabelMessage.setText("Jusque là tout va bien !!!");

} catch (ClassNotFoundException | SQLException e) {
	jLabelMessage.setText(e.getMessage());
}
        
        
        
        
        
        
        
        
        
        
        
        
        
        
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTablePays = new javax.swing.JTable();
        jLabelMessage = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Visualisation Pays");

        jTablePays.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Pays", "Nom du pays", "Masculin", "Féminin", "Neutre"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTablePays);

        jLabelMessage.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelMessage)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelMessage)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelMessage;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTablePays;
    // End of variables declaration//GEN-END:variables
}

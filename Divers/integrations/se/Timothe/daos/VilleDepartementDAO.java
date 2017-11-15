
package daos;


import entities.VilleDepartement;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author formation
 */
public class VilleDepartementDAO {
  private  Connection icnx ;
    
    public VilleDepartementDAO(Connection icnx) {
        this.icnx = icnx;
    }
    
    
     public List<VilleDepartement> selectAll() {
        ArrayList<VilleDepartement> lVille = new ArrayList<>();

        VilleDepartement vd;
        ResultSet lrs;
        try {

            String lrSQL = "CALL v_villeSelectAll()";
            PreparedStatement lpst = icnx.prepareStatement(lrSQL);
            lrs = lpst.executeQuery();
            while (lrs.next()) {
                vd = new VilleDepartement();
                vd.setIDVille(lrs.getInt("ID_ville"));
                vd.setIDDepartement(lrs.getInt("ID_departement"));
                vd.setCP(lrs.getString("CP"));
                vd.setNomVille(lrs.getString("NOM_ville"));
                vd.setNomDepartement(lrs.getString("NOM_departement"));

                lVille.add(vd);
            }

            lrs.close();
            lpst.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }

        return lVille;
    }
}

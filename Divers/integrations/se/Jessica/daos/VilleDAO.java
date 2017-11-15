/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package daos;

import entities.Ville;
import java.sql.*;

/**
 *
 * @author Administrateur
 */
public class VilleDAO {
    
    private Connection icnx;

    public VilleDAO(Connection icnx) {
        this.icnx = icnx;
    }
    
    public Ville selectOne(String ville) {
        Ville v = new Ville();

        try {
            PreparedStatement lpst = icnx.prepareStatement("CALL kica_cinescope.villeSelectOne(?)");
            lpst.setString(1, ville);
            ResultSet lrs = lpst.executeQuery();
            if (lrs.next()) {
                v.setIdVille(lrs.getInt("ID_ville"));
            } else {
                v.setIdVille(0);
            }
            lrs.close();
            lpst.close();
        } catch (SQLException e) {
            v.setIdVille(-1);
        }

        return v;
    }
    
}

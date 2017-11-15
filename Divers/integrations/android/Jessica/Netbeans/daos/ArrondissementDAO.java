/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.pb.daos;

import connexion.Connexion;
import fr.pb.entities.Arrondissement;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Administrateur
 */
public class ArrondissementDAO {

    private Connection icnx;

    public ArrondissementDAO(Connection icnx) {
        this.icnx = icnx;
    }
    
    public static String selectAll() {
        
        JSONArray tableauJSON = null;
        JSONObject objetJSON;

        Connection lcn = Connexion.getConnexionMySQL("172.26.55.55", "cinescope2014", "3306", "p", "b");

        try {
            PreparedStatement lpst = lcn.prepareStatement("SELECT * FROM arrondissement");
            ResultSet lrs = lpst.executeQuery();

            tableauJSON = new JSONArray();
            while (lrs.next()) {
                objetJSON = new JSONObject();
                objetJSON.put("id", lrs.getString(1));
                objetJSON.put("code", lrs.getString(2));
                objetJSON.put("nom", lrs.getString(3));
                tableauJSON.put(objetJSON);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        Connexion.seDeconnecter(lcn);
        
        return tableauJSON.toString();
    }// Fin selectAll
}

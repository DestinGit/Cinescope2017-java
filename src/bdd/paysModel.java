/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdd;

import java.sql.*;
import java.util.*;

/**
 *
 * @author formation
 */
public class paysModel extends bddManager {

    public paysModel() {
        super();
    }

    public void insertData(String name, String nameMale, String nameFemale, String neutral) {
        Connection lcn = this.connect();

        String lsSQL = "INSERT INTO pays(NOM_pays, MASCULIN, FEMININ, NEUTRE) VALUES(?,?,?,?)";
        try {
            // --- Creation de l'objet "commande SQL"
            PreparedStatement lpst = lcn.prepareStatement(lsSQL);

            // --- Valorisation du ou des parametre(s)
            lpst.setString(1, name);
            lpst.setString(2, nameMale);
            lpst.setString(3, nameFemale);
            lpst.setString(4, neutral);
            // --- Execution de la requete
            lpst.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erreur Insertion : " + e.getMessage());
        }

        this.disconnect();
    }

    public Map getData() {
        Connection lcn = this.connect();
        Map<String, String> mapPays = new HashMap();

        String lsSQL = "SELECT ID_pays, NOM_pays FROM pays";
        try {
            // --- Creation de l'objet "commande SQL"
            PreparedStatement lpst = lcn.prepareStatement(lsSQL);
            ResultSet lrs = lpst.executeQuery();
            while (lrs.next()) {
                mapPays.put(lrs.getString(2), lrs.getString(1));
            }
        } catch (SQLException e) {
            System.out.println("Erreur list : " + e.getMessage());
        }

        return mapPays;
    }

    public void deleteData(String pId) {
        Connection lcn = this.connect();

        String lsSQL = "DELETE FROM pays WHERE ID_pays = ?";
        try {
            // --- Creation de l'objet "commande SQL"
            PreparedStatement lpst = lcn.prepareStatement(lsSQL);
            lpst.setString(1, pId);
            lpst.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Delete Exception : " + e.getMessage());
        }

        this.disconnect();
    }

}

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
//public class paysModel extends bddManager {
public class paysModel {
    
    public paysModel() {
//        super();
    }

    public void insertData(String name, String nameMale, String nameFemale, String neutral) {
//        Connection lcn = this.connect();
        Connection lcn = bddConnection.getInstance();
        
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

//        this.disconnect();
    }

    public Map getData() {
//        Connection lcn = this.connect();
        Connection lcn = bddConnection.getInstance();
        Map<String, String> mapPays = new HashMap();

        String lsSQL = "SELECT ID_pays, NOM_pays, MASCULIN, FEMININ, NEUTRE FROM pays";
        try {
            // --- Creation de l'objet "commande SQL"
            PreparedStatement lpst = lcn.prepareStatement(lsSQL);
            ResultSet lrs = lpst.executeQuery();
            while (lrs.next()) {
                mapPays.put(lrs.getString(2), lrs.getString(1));
            }
            lrs.close();
            lpst.close();
            
        } catch (SQLException e) {
            System.out.println("Erreur list : " + e.getMessage());
        }

//        this.disconnect();

        return mapPays;
    }

    /**
     * 
     * @return 
     */
    public List<Map<String, String>> getAllData() {
//        Connection lcn = this.connect();
        Connection lcn = bddConnection.getInstance();
        
        String lsSQL = "SELECT ID_pays, NOM_pays, MASCULIN, FEMININ, NEUTRE FROM pays";

        List<Map<String, String>> listCountries = new ArrayList();

        try {
            // --- Creation de l'objet "commande SQL"
            PreparedStatement lpst = lcn.prepareStatement(lsSQL);
            ResultSet lrs = lpst.executeQuery();
            while (lrs.next()) {
                Map<String, String> mapPays = new HashMap();
                mapPays.put("ID_pays", lrs.getString("ID_pays"));
                mapPays.put("NOM_pays", lrs.getString("NOM_pays"));
                mapPays.put("MASCULIN", lrs.getString("MASCULIN"));
                mapPays.put("FEMININ", lrs.getString("FEMININ"));
                mapPays.put("NEUTRE", lrs.getString("NEUTRE"));

                listCountries.add(mapPays);
            }
            lrs.close();
            lpst.close();
           
        } catch (SQLException e) {
            System.out.println("Erreur list : " + e.getMessage());
        }

//        this.disconnect();

        return listCountries;
    }

    /**
     *
     * @param pId
     * @return
     */
    public Map<String, String> getOneData(String pId) {

        System.out.println("id" + pId);

//        Connection lcn = this.connect();
        Connection lcn = bddConnection.getInstance();
        
        Map<String, String> mapPays = new HashMap();
        String lsSQL = "SELECT * FROM pays WHERE ID_pays = ?";
        try {
            // --- Creation de l'objet "commande SQL"
            PreparedStatement lpst = lcn.prepareStatement(lsSQL);
            lpst.setString(1, pId);
            ResultSet lrs = lpst.executeQuery();
            if (lrs.next()) {
                mapPays.put("ID_pays", lrs.getString("ID_pays"));
                mapPays.put("Nom_pays", lrs.getString("Nom_pays"));
                mapPays.put("MASCULIN", lrs.getString("MASCULIN"));
                mapPays.put("FEMININ", lrs.getString("FEMININ"));
                mapPays.put("Neutre", lrs.getString("Neutre"));
            } else {
                mapPays.put("ID_Pays", "0");
                mapPays.put("Nom_pays", "Introuvable");
            }
            
            lrs.close();
            lpst.close();
            
        } catch (SQLException e) {
            System.out.println("Select one exception : " + e.getMessage());
        }

//        this.disconnect();

        return mapPays;
    }

    public void updateData(String id, String name, String nameMale, String nameFemale, String neutral) {
//        Connection lcn = this.connect();
        Connection lcn = bddConnection.getInstance();

        String lsSQL = "UPDATE pays SET NOM_pays = ?, MASCULIN = ?, FEMININ = ?, NEUTRE = ? WHERE ID_pays = ? ";
        try {
            // --- Creation de l'objet "commande SQL"
            PreparedStatement lpst = lcn.prepareStatement(lsSQL);

            // --- Valorisation du ou des parametre(s)
            lpst.setString(1, name);
            lpst.setString(2, nameMale);
            lpst.setString(3, nameFemale);
            lpst.setString(4, neutral);
            lpst.setString(5, id);
            // --- Execution de la requete
            lpst.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erreur Insertion : " + e.getMessage());
        }

//        this.disconnect();
    }

    /**
     *
     * @param pId
     */
    public void deleteData(String pId) {
//        Connection lcn = this.connect();
        Connection lcn = bddConnection.getInstance();
        
        String lsSQL = "DELETE FROM pays WHERE ID_pays = ?";
        try {
            // --- Creation de l'objet "commande SQL"
            PreparedStatement lpst = lcn.prepareStatement(lsSQL);
            lpst.setString(1, pId);
            lpst.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Delete Exception : " + e.getMessage());
        }

//        this.disconnect();
    }

}

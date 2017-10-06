/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdd;

import java.sql.*;

/**
 *
 * @author formation
 */
//public class metroModel extends bddManager {
public class metroModel {

    public metroModel() {
//        super();
    }
    
    public void insertData(String name, String lat, String lng) {
//        Connection lcn = this.connect();
        Connection lcn = bddConnection.getInstance();
        
        String lsSQL = "INSERT INTO station_metro(NOM_station_metro, lat, lng) VALUES(?,?,?)";
        
        try{
            // --- Creation de l'objet "commande SQL"
            PreparedStatement lpst = lcn.prepareStatement(lsSQL);
            
            lpst.setString(1, name);
            lpst.setString(2, lat);
            lpst.setString(3, lng);
            
            // --- Execution de la requete
            lpst.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println("Erreur Insertion : " + e.getMessage());            
        }
    }

}

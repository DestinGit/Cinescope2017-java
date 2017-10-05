/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author formation
 */
public class bddConnection {
    /**
     * Instance unique pré-initialisée
     */
    private static bddConnection INSTANCE = null;
    
    /** Ma connexion **/
    private Connection lcn;
    
    /**
     * Constructeur privé
     */
    private bddConnection() {
        // --- Pour une connexion MySQL native
        String lsServer = "127.0.0.1";
        String lsPort = "3306";
        String lsBD = "cinescope2017";
        String lsUt = "root";
        String lsMdp = "";
        
        String lsDSN = "jdbc:mysql://" + lsServer + ":" + lsPort + "/" + lsBD;
        
        try {
            lcn = DriverManager.getConnection(lsDSN, lsUt, lsMdp);
        } catch (SQLException e) {
            System.out.println("connection failed : " + e.getMessage());
        }
    }

    public static bddConnection getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new bddConnection();
        }
        return INSTANCE;
    }
    
//    public void bddDisconnect() {
//        try {
//            lcn.close();
//        } catch (SQLException e) {
//            System.out.println("Disconnect : " + e.getMessage());
//        }        
//    }
}

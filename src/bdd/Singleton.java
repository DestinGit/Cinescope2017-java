/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdd;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author formation
 */
public class Singleton implements Serializable {
    /**
     * Instance unique pré-initialisée
     */
    private static Singleton INSTANCE = null;
    
    /** Ma connexion **/
    private Connection lcn;
    
    /**
     * Constructeur privé
     */
    private Singleton() {

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

    /**
     * Point d'accès pour l'instance unique du singleton
     */
    public static Singleton getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Singleton();
        }
        return INSTANCE;
    }

}

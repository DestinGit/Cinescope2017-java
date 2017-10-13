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
public class bddManager {

    private Connection lcn;
    private String lsServer;
    private String lsPort;
    private String lsBD;
    private String lsUt;
    private String lsMdp;

    /**
     * Constructor
     */
    public bddManager() {
        // --- Pour une connexion MySQL native
        lsServer = "127.0.0.1";
        lsPort = "3306";
        lsBD = "cinescope2017";
        lsUt = "root";
        lsMdp = "";

        lcn = null;
    }

    /**
     * To connection to BDD
     * @return 
     */
    public Connection connect() {
        String lsDSN = "jdbc:mysql://" + lsServer + ":" + lsPort + "/" + lsBD;
        try {
            lcn = DriverManager.getConnection(lsDSN, lsUt, lsMdp);
        } catch (SQLException e) {
            System.out.println("connection failed : " + e.getMessage());
        }
        return lcn;
    }

    /**
     * To disconnect to BDD
     */
    public void disconnect() {
        try {
            lcn.close();
        } catch (SQLException e) {
            System.out.println("Disconnect : " + e.getMessage());
        }
        
        lcn = null;
    }

//    public StringBuilder getData() {
//        StringBuilder lsbContent = new StringBuilder();
//        return lsbContent;
//    }
//
//    public void insert() {
//
//    }
}

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
     * Ma connexion *
     */
    private static Connection lcn = null;

    /**
     * Constructeur privé
     */
    private bddConnection() {
    }

    /**
     *
     * @return Connection
     */
    public static Connection getInstance() {
        if (lcn == null) {
            // --- Pour une connexion MySQL native
//            String lsServer = "127.0.0.1";
//            String lsPort = "3306";
//            String lsBD = "cinescope2017";
//            String lsUt = "root";
//            String lsMdp = "";
//
//            String lsDSN = "jdbc:mysql://" + lsServer + ":" + lsPort + "/" + lsBD;

            String lsServer = "mysql-yemeialways.alwaysdata.net";
            String lsPort = "3306";
            String lsBD = "yemeialways_cine2017";
            String lsUt = "143657";
            String lsMdp = "YemeiAlways@01";

            String lsDSN = "jdbc:mysql://" + lsServer + ":" + lsPort + "/" + lsBD;

            try {
                lcn = DriverManager.getConnection(lsDSN, lsUt, lsMdp);
            } catch (SQLException e) {
                System.out.println("connection failed : " + e.getMessage());
            }

        }
        return lcn;
    }

    /**
     * Close Connection
     */
    public void bddDisconnect() {
        try {
            lcn.close();
        } catch (SQLException e) {
            System.out.println("Disconnect : " + e.getMessage());
        }

        lcn = null;
    }
}

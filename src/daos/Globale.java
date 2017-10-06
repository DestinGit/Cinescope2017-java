/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package daos;

import java.sql.Connection;

/**
 *
 * @author formation
 */
public class Globale {
    private static Connection cnx;

    public static Connection getCnx() {
        return cnx;
    }

    public static void setCnx(Connection cnx) {
        Globale.cnx = cnx;
    }
    
}

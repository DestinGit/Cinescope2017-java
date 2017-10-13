/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package essais;

import connexion.Connexion;
import java.sql.Connection;

/**
 *
 * @author formation
 */
public class ConnexionTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Connection cn = Connexion.getConnectionMySQL("127.0.0.1", "cours", "3306", "root", "");
        System.out.println(cn);
        
        Connexion.disconnection(cn);
    }
    
}

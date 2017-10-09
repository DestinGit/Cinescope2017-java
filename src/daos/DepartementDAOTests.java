/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package daos;

import java.sql.Connection;
import connexion.Connexion;
import entities.Departement;
/**
 *
 * @author formation
 */
public class DepartementDAOTests {
    public static void main(String[] args) {
        Connection lcnx;
        lcnx = Connexion.getConnectionMySQL("127.0.0.1", "cinescope2017", "3306", "root", "");
        Departement d = new Departement("99", "Neuf");
        DepartementDAO dao = new DepartementDAO(lcnx);
        
        int r = dao.insert(d);
        System.out.println(r);
    }
            
}

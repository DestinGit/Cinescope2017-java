/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package daos;

import java.sql.Connection;
import connexion.Connexion;
import entities.Departement;
import java.util.List;
/**
 *
 * @author formation
 */
public class DepartementDAOTests {
    public static void main(String[] args) {
        Connection lcnx;
        lcnx = Connexion.getConnectionMySQL("127.0.0.1", "cinescope2017", "3306", "root", "");
        /// POUR L'INSERTION
//        Departement d = new Departement("88", "Huit");
//        DepartementDAO dao = new DepartementDAO(lcnx);        
//        int r = dao.insert(d);
        
        
        /// POUR LE DELETE
//        Departement d = new Departement(1,"99", "Neuf");
//        DepartementDAO dao = new DepartementDAO(lcnx);
//        int r = dao.delete(d);
//        System.out.println(r);
        
        /// POUR LE SELECT ONE
//        DepartementDAO dao2 = new DepartementDAO(lcnx);
//        Departement r2 = dao2.selectOne(3);
//        System.out.println(r2);
        
        // POUR LE SELECT ALL
//        DepartementDAO dao3 = new DepartementDAO(lcnx);
//        List result = dao3.selectAll();
//        result.stream().forEach((rs) -> {
//            System.out.println(rs);
//        });
        
        // POUR LE UPDATE
        DepartementDAO dao4 = new DepartementDAO(lcnx);
        Departement d = new Departement(4,"988", "HuitHuit");
        int r = dao4.update(d);
        System.out.println(r);
        
    }
            
}

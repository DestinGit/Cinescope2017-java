/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.pb.daos;

import fr.pb.entities.Metro;
import java.sql.*;
import java.util.*;

/**
 *
 * @author formation
 */
public class SallesDeParisDAO {

//    private Connection con;
//
//    public SallesDeParisDAO(Connection con) {
//        this.con = con;
//    }
    public static List<Metro> selectAll(Connection con) throws ClassNotFoundException {
        List<Metro> liste = new ArrayList();
        Metro SallesDeParis = null;
        try {
            String query = "select * from cinema_general_view";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                SallesDeParis = new Metro(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6)
                );
                liste.add(SallesDeParis);
            }
            rs.close();
            stmt.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return liste;
    } //selectAll
}

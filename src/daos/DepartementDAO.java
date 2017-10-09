/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package daos;

import entities.Departement;
import java.sql.*;

/**
 *
 * @author formation
 */
public class DepartementDAO {
    private Connection icnx;

    public DepartementDAO(Connection icnx) {
        this.icnx = icnx;
    }
    
    public int insert(Departement d){
        int liAffecte = 0;
        try {
            String lsSQL = "INSERT INTO departement(code_departement, nom_departement) VALUES (?,?)";
            PreparedStatement lpst = icnx.prepareStatement(lsSQL);
            lpst.setString(1, d.getCodeDepartement());
            lpst.setString(2, d.getNomDepartement());
            lpst.executeUpdate();
            icnx.commit();
        } catch (SQLException e) {
            liAffecte = -1;
            System.out.println("erreu INSERT : " + e.getMessage());
        } 
        
        return liAffecte;
    } //insert
} /// class

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import entities.Rubrique;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author formation
 */
public class RubriqueDAO implements IDAO<Rubrique> {

    private Connection cnx;

    public RubriqueDAO(Connection cnx) {
        this.cnx = cnx;
    }

    @Override
    public int insert(Rubrique objet) {
        int liAffecte = 0;

        String lsInsert = "CALL rubriqueInsert(?,?)";

        try {
            // Preparation de la requête
            PreparedStatement pst = this.cnx.prepareStatement(lsInsert);
            // valorisation des variables
            pst.setString(1, objet.getCodeRubrique());
            pst.setString(2, objet.getIntituleRubrique());
            // Exécution de la requête
            liAffecte = pst.executeUpdate();
            // Fermeture du PreparedStatement
            pst.close();

        } catch (SQLException e) {
            liAffecte = -1;
            System.out.println("Insert erreur : " + e.getMessage());
        }

        return liAffecte;
    }

    @Override
    public List<Rubrique> selectAll() {
        List<Rubrique> resultList = new ArrayList();
        Rubrique d;

        try {
            String lsSQL = "CALL rubriqueSelectAll()";
            Statement lpst = cnx.createStatement();
            ResultSet lrs = lpst.executeQuery(lsSQL);
            while (lrs.next()) {
                d = new Rubrique(lrs.getInt(1), lrs.getString("code_rubrique"), lrs.getString("intitule_rubrique"));
                resultList.add(d);
            }
            lrs.close();
            lpst.close();
        } catch (SQLException e) {
            d = new Rubrique(-1, null, null);
            resultList.add(d);
        }

        return resultList;      
    }

    @Override
    public Rubrique selectOne(int id) {
        Rubrique d = new Rubrique();

        try {
            String lsSQL = "CALL rubriqueSelectOne(?)";
            PreparedStatement lpst = cnx.prepareStatement(lsSQL);
            lpst.setInt(1, d.getIdRubrique());
            ResultSet lrs = lpst.executeQuery();
            if (lrs.next()) {
                d.setIdRubrique(id);
                d.setCodeRubrique(lrs.getString("code_rubrique"));
                d.setIntituleRubrique(lrs.getString("intitule_rubrique"));
            } else {
                d.setIdRubrique(0);
                d.setCodeRubrique(null);
                d.setIntituleRubrique(null);
            }
            lrs.close();
            lpst.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return d;
    }

    @Override
    public int delete(Rubrique objet) {
        int liAffecte;

        try {
            String lsSQL = "CALL rubriqueDelete(?)";
            PreparedStatement lpst = cnx.prepareStatement(lsSQL);
            lpst.setInt(1, objet.getIdRubrique());
            liAffecte = lpst.executeUpdate();

            lpst.close();

        } catch (SQLException ex) {
            liAffecte = -1;
            System.out.println(ex.getMessage());
        }

        return liAffecte;
    }

    @Override
    public int update(Rubrique objet) {
        int liAffecte;

        try {
            String lsSQL = "CALL rubriqueUpdate(?,?,?)";
            PreparedStatement lpst = cnx.prepareStatement(lsSQL);
            
            lpst.setInt(1, objet.getIdRubrique());
            lpst.setString(2, objet.getCodeRubrique());
            lpst.setString(3, objet.getIntituleRubrique());

            liAffecte = lpst.executeUpdate();

            lpst.close();

        } catch (SQLException ex) {
            liAffecte = -1;
            System.out.println(ex.getMessage());
        }

        return liAffecte;
    }

}

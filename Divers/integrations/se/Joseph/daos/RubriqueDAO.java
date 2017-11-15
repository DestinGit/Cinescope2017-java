/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import entities.Rubrique;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rayanakel
 */
public class RubriqueDAO implements IDAO<Rubrique> {

    private final Connection icnx;

    public RubriqueDAO(Connection icnx) {
        this.icnx = icnx;
    }

    @Override
    public int insert(Rubrique objet) {
        int liAffecte;

        try {
            String lsSQL = "CALL rubriqueInsert(?,?)";
            PreparedStatement lpst = icnx.prepareStatement(lsSQL);
            lpst.setString(1, objet.getCodeRubrique());
            lpst.setString(2, objet.getIntituleRubrique());
            liAffecte = lpst.executeUpdate();

            icnx.commit();

            lpst.close();

        } catch (SQLException e) {
            liAffecte = -1;
            System.out.println(e.getMessage());
        }

        return liAffecte;
    }

    @Override
    public List<Rubrique> selectAll() {
        List<Rubrique> liste = new ArrayList();
        Rubrique d;

        try {
            String lsSQL = "CALL rubriqueSelectAll()";
            Statement lpst = icnx.createStatement();
            ResultSet lrs = lpst.executeQuery(lsSQL);
            while (lrs.next()) {
                d = new Rubrique(lrs.getInt(1), lrs.getString("code_rubrique"), lrs.getString("intitule_rubrique"));
                liste.add(d);
            }
            lrs.close();
            lpst.close();
        } catch (SQLException e) {
            d = new Rubrique(-1, e.getMessage(), e.getMessage());
            liste.add(d);
        }

        return liste;
    }

    @Override
    public Rubrique selectOne(int id) {
        Rubrique d = new Rubrique();

        try {
            String lsSQL = "CALL rubriqueSelectOne(?)";
            PreparedStatement lpst = icnx.prepareStatement(lsSQL);
            lpst.setInt(1, d.getIdRubrique());
            ResultSet lrs = lpst.executeQuery();
            if (lrs.next()) {
                d.setIdRubrique(id);
                d.setCodeRubrique(lrs.getString("code_rubrique"));
                d.setIntituleRubrique(lrs.getString("intitule_rubrique"));
            } else {
                d.setIdRubrique(0);
                d.setCodeRubrique("INTROUVABLE");
                d.setIntituleRubrique("INTROUVABLE");
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
            PreparedStatement lpst = icnx.prepareStatement(lsSQL);
            lpst.setInt(1, objet.getIdRubrique());
            liAffecte = lpst.executeUpdate();

            icnx.commit();

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
            PreparedStatement lpst = icnx.prepareStatement(lsSQL);

            lpst.setString(1, objet.getCodeRubrique());
            lpst.setString(2, objet.getIntituleRubrique());
            lpst.setInt(3, objet.getIdRubrique());

            liAffecte = lpst.executeUpdate();

            icnx.commit();

            lpst.close();

        } catch (SQLException ex) {
            liAffecte = -1;
            System.out.println(ex.getMessage());
        }

        return liAffecte;
    }

}

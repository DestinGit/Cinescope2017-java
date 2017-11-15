/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import entities.Departement;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Jessica
 */
public class DepartementDAO {

    private Connection icnx;

    public DepartementDAO(Connection icnx) {
        this.icnx = icnx;
    }

    public int insert(Departement d) {
        int liAffecte;

        try {
            PreparedStatement lpst = icnx.prepareStatement("CALL kica_cinescope.departementInsert(?,?)");
            lpst.setString(1, d.getCodeDepartement());
            lpst.setString(2, d.getNomDepartement());
            liAffecte = lpst.executeUpdate();
            icnx.commit();
            lpst.close();
        } catch (SQLException e) {
            liAffecte = -1;
            System.out.println(e.getMessage());
        }

        return liAffecte;
    }

    public int delete(Departement d) {
        int liAffecte;

        try {
            PreparedStatement lpst = icnx.prepareStatement("CALL kica_cinescope.departementDelete(?)");
            lpst.setInt(1, d.getIdDepartement());
            liAffecte = lpst.executeUpdate();
            icnx.commit();
            lpst.close();
        } catch (SQLException e) {
            liAffecte = -1;
            System.out.println(e.getMessage());
        }

        return liAffecte;
    }

    public int update(Departement d) {
        int liAffecte;

        try {
            PreparedStatement lpst = icnx.prepareStatement("CALL kica_cinescope.departementUpdate(?,?,?)");
            lpst.setString(1, d.getNomDepartement());
            lpst.setString(2, d.getCodeDepartement());
            lpst.setInt(3, d.getIdDepartement());
            liAffecte = lpst.executeUpdate();
            icnx.commit();
            lpst.close();
        } catch (SQLException e) {
            liAffecte = -1;
            System.out.println(e.getMessage());
        }

        return liAffecte;
    }

    public Departement selectOne(int id) {
        Departement d = new Departement();

        try {
            PreparedStatement lpst = icnx.prepareStatement("CALL kica_cinescope.departementSelectOne(?)");
            lpst.setInt(1, id);
            ResultSet lrs = lpst.executeQuery();
            if (lrs.next()) {
                d.setIdDepartement(id);
                d.setCodeDepartement(lrs.getString("code_departement"));
                d.setNomDepartement(lrs.getString("nom_departement"));
            } else {
                d.setIdDepartement(0);
                d.setCodeDepartement("INTROUVABLE");
                d.setNomDepartement("INTROUVABLE");
            }
            lrs.close();
            lpst.close();
        } catch (SQLException e) {
            d.setIdDepartement(-1);
            d.setCodeDepartement(e.getMessage());
        }

        return d;
    }

    public List<Departement> selectAll() {
        List<Departement> tDepartements = new ArrayList<>();

        try {
            PreparedStatement lpst = icnx.prepareStatement("CALL kica_cinescope.departementSelectAll()");
            ResultSet lrs = lpst.executeQuery();

            while (lrs.next()) {
                Departement d = new Departement();
                d.setIdDepartement(lrs.getInt(1));
                d.setCodeDepartement(lrs.getString(2));
                d.setNomDepartement(lrs.getString(3));
                tDepartements.add(d);
            }
            lrs.close();
            lpst.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return tDepartements;

    }

}

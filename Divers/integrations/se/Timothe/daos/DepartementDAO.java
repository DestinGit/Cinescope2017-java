package daos;

import entities.Departement;

import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author formation
 */
public class DepartementDAO {

    private Connection icnx;

    public DepartementDAO(Connection icnx) {
        this.icnx = icnx;
    }/// contructeur

    public int insert(Departement d) {
        int liAffecte = 0;

        try {

            String lrSQL = "CALL departementInsert(? , ?)";
            PreparedStatement lpst = icnx.prepareStatement(lrSQL);
            lpst.setString(1, d.getCodeDepartement());
            lpst.setString(2, d.getNomDepartement());
            liAffecte = lpst.executeUpdate();

            icnx.commit();
            lpst.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            liAffecte = -1;
        }

        return liAffecte;
    }// inserte

    public int delete(Departement d) {
        int liAffecte = 0;

        try {
            String lrSQL = "CALL departementDelete(?)";
            PreparedStatement lpst = icnx.prepareStatement(lrSQL);
            lpst.setInt(1, d.getIdDepartement());

            System.out.println(lpst);
            liAffecte = lpst.executeUpdate();
            icnx.commit();
            lpst.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return liAffecte;
    }

    public Departement selectOne(String str) {
        Departement d = new Departement();
        try {

            String lrSQL = "CALL departementSelectOne(?)";
            PreparedStatement lpst = icnx.prepareStatement(lrSQL);
            lpst.setString(1, str);
            ResultSet lrs = lpst.executeQuery();
            if (lrs.next()) {
                d.setIdDepartement(lrs.getInt("ID_departement"));
                d.setCodeDepartement(lrs.getString("code_departement"));
                d.setNomDepartement(lrs.getString("nom_departement"));
            } else {
                d.setIdDepartement(0);
                d.setCodeDepartement("INTROUVABLE");
                d.setNomDepartement("INTROUVABLE");
            }
            lrs.close();
            lpst.close();
        } catch (Exception e) {

        }

        return d;
    }

    public int update(Departement d) {
        int out = 0;

        try {
            String lrSQL = "CALL departementUpdate(?,?,?)";
            PreparedStatement lpst = icnx.prepareStatement(lrSQL);
            lpst.setString(2, d.getCodeDepartement());
            lpst.setString(3, d.getNomDepartement());

            out = lpst.executeUpdate();

            icnx.commit();
            lpst.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }

        return out;
    }

    /**
     *
     * @return
     */
    public ArrayList<Departement> selectAll() {
        ArrayList<Departement> lDepartement = new ArrayList<>();

        Departement d;
        ResultSet lrs;
        try {

            String lrSQL = "CALL departementSelectAll()";
            PreparedStatement lpst = icnx.prepareStatement(lrSQL);
            lrs = lpst.executeQuery();
            while (lrs.next()) {
                d = new Departement();
                d.setIdDepartement(lrs.getInt("ID_departement"));
                d.setCodeDepartement(lrs.getString("code_departement"));
                d.setNomDepartement(lrs.getString("nom_departement"));
                lDepartement.add(d);
            }

            lrs.close();
            lpst.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }

        return lDepartement;
    }
}///class

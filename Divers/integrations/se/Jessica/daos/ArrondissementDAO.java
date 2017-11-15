/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package daos;

import entities.Arrondissement;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrateur
 */
public class ArrondissementDAO {
    
    private Connection icnx;

    public ArrondissementDAO(Connection icnx) {
        this.icnx = icnx;
    }
    
    public Arrondissement selectOne(String arrondissement) {
        Arrondissement a = new Arrondissement();

        try {
            PreparedStatement lpst = icnx.prepareStatement("CALL kica_cinescope.arrondissementSelectOne(?)");
            lpst.setString(1, arrondissement);
            ResultSet lrs = lpst.executeQuery();
            if (lrs.next()) {
                a.setIdArrondissement(lrs.getInt("ID_arrondissement"));
            } else {
                a.setIdArrondissement(0);
            }
            lrs.close();
            lpst.close();
        } catch (SQLException e) {
            a.setIdArrondissement(-1);
        }

        return a;
    }
    
    public Arrondissement selectOneBis(int id) {
        Arrondissement a = new Arrondissement();

        try {
            PreparedStatement lpst = icnx.prepareStatement("CALL kica_cinescope.arrondissementSelectOne(?)");
            lpst.setInt(1, id);
            ResultSet lrs = lpst.executeQuery();
            if (lrs.next()) {
                a.setIdArrondissement(id);
                a.setCodeArrondissement(lrs.getString("CODE_arrondissement"));
                a.setNomArrondissement(lrs.getString("NOM_arrondissement"));
            } else {
                a.setIdArrondissement(0);
                a.setCodeArrondissement("INTROUVABLE");
                a.setNomArrondissement("INTROUVABLE");
            }
            lrs.close();
            lpst.close();
        } catch (SQLException ex) {
            a.setIdArrondissement(-1);
            a.setCodeArrondissement(ex.getMessage());
            a.setNomArrondissement(ex.getMessage());
        }

        return a;
    }
    
    public List<Arrondissement> selectAll() {
        List<Arrondissement> listeArrondissement = new ArrayList();

        try {
            PreparedStatement lpst = icnx.prepareStatement("CALL kica_cinescope.arrondissementSelectAll()");
            ResultSet lrs = lpst.executeQuery();
            while (lrs.next()) {
                Arrondissement a = new Arrondissement();
                a.setIdArrondissement(lrs.getInt(1));
                a.setCodeArrondissement(lrs.getString(2));
                a.setNomArrondissement(lrs.getString(3));
                listeArrondissement.add(a);
            }
            lrs.close();
            lpst.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return listeArrondissement;
    }
    
    public int insert(Arrondissement objet) {
        int liAffecte = 0;

        try {
            PreparedStatement lpst = icnx.prepareStatement("CALL kica_cinescope.arrondissementInsert(?,?)");
            lpst.setString(1, objet.getCodeArrondissement());
            lpst.setString(2, objet.getNomArrondissement());
            liAffecte = lpst.executeUpdate();
            lpst.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            liAffecte = -1;
        }

        return liAffecte;
    }
    
    public int update(Arrondissement objet) {
        int liAffecte;

        try {
            PreparedStatement lpst = icnx.prepareStatement("CALL kica_cinescope.arrondissementUpdate(?,?,?)");
            lpst.setString(1, objet.getCodeArrondissement());
            lpst.setString(2, objet.getNomArrondissement());
            lpst.setInt(3, objet.getIdArrondissement());
            liAffecte = lpst.executeUpdate();
            lpst.close();
        } catch (SQLException ex) {
            liAffecte = -1;
            System.out.println(ex.getMessage());
        }
        
        return liAffecte;
    }
    
    public int delete(Arrondissement objet) {
        int liAffecte;

        try {
            PreparedStatement lpst = icnx.prepareStatement("CALL kica_cinescope.arrondissementDelete(?)");
            lpst.setInt(1, objet.getIdArrondissement());
            liAffecte = lpst.executeUpdate();
            lpst.close();
        } catch (SQLException ex) {
            liAffecte = -1;
            System.out.println(ex.getMessage());
        }

        return liAffecte;
    }
    
}

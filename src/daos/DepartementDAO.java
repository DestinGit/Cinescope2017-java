/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import entities.Departement;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author formation
 */
public class DepartementDAO {

    private Connection icnx;

    public DepartementDAO(Connection icnx) {
        this.icnx = icnx;
    }

//    public void commit() {
//        try {
//            icnx.commit();
//        } catch (SQLException e) {
//            rollback();
//            System.out.println("erreur COMMIT : " + e.getMessage());
//        }
//    }
//
//    public void rollback() {
//        try {
//            icnx.rollback();
//        } catch (SQLException e) {
//            System.out.println("erreur ROLLBACK : " + e.getMessage());
//        }
//    }

    /**
     *
     * @param d
     * @return
     */
    public int insert(Departement d) {
        int liAffecte;
        try {
            String lsSQL = "CALL departementInsert(?, ?)";
            PreparedStatement lpst = icnx.prepareStatement(lsSQL, Statement.RETURN_GENERATED_KEYS);
            lpst.setString(1, d.getCodeDepartement());
            lpst.setString(2, d.getNomDepartement());
            liAffecte = lpst.executeUpdate();
//            if (liAffecte > 0) {
//                ResultSet lrsNouvelleCle = lpst.getGeneratedKeys();
//                if (lrsNouvelleCle.next()) {
//                    int liNewID = lrsNouvelleCle.getInt(1);
//                    System.out.println(" liNewID : " + liNewID);
//                }
//            }
            lpst.close();
        } catch (SQLException e) {
            liAffecte = -1;
            System.out.println("erreur INSERT : " + e.getMessage());
        }

        return liAffecte;
    } //insert

    /**
     *
     * @param d
     * @return
     */
    public int delete(Departement d) {
        int liAffecte = 0;
        try {
            String lsSQL = "CALL departementDelete(?)";
            // Préparation de la requete
            try (PreparedStatement lpst = icnx.prepareStatement(lsSQL)) {
                //  Valorisation de la variable
                lpst.setInt(1, d.getIdDepartement());
                // Exécution de la requête
                liAffecte = lpst.executeUpdate();
                // Validation de l'exécution
//                icnx.commit();
                // fermeture du pointeur
                lpst.close();
            }
        } catch (SQLException e) { // Exécution quand une exception est levée
            liAffecte = -1;
            System.out.println("DELETE : " + e.getMessage());
        }
        return liAffecte;
    } /// delete

    /**
     *
     * @param id
     * @return
     */
    public Departement selectOne(int id) {
        Departement d = new Departement();
        String lsSQL = "CALL departementSelectOne(?)";
        try {
            // Préparation de la requete
            PreparedStatement lpst = icnx.prepareStatement(lsSQL);
            // Valorisation des variables
            lpst.setInt(1, id);
            // Exécution de la requête
            ResultSet lrs = lpst.executeQuery();
            // test si resultat existe. Si oui, initialiser l'objet Departement
            if (lrs.next()) {
                d.setIdDepartement(id);
                d.setCodeDepartement(lrs.getString("code_departement"));
                d.setNomDepartement(lrs.getString("nom_departement"));
            } else { // Si non, initialiser l'objet Departement avec les valeurs par défaut
                d.setIdDepartement(0);
                d.setCodeDepartement("INTROUVALE");
                d.setNomDepartement("INTROUVALE");
            }
            // Fermeture des pointeurs
            lrs.close();
            lpst.close();
        } catch (SQLException e) { // Exécution quand une exception est levée
            System.out.println("SELECT ONE : " + e.getMessage());
        }
        return d;
    } /// selectOne

    /**
     *
     * @return
     */
    public List<Departement> selectAll() {
        List<Departement> resultList = new ArrayList();

        String lsSQL = "CALL departementSelectAll()";
        try {
            // Préparation de la requete
            PreparedStatement lpst = icnx.prepareStatement(lsSQL);
            // Exécution de la requete
            ResultSet lrs = lpst.executeQuery();
            // Lecture des datas
            while (lrs.next()) {
                Departement d = new Departement(lrs.getInt("id_departement"),
                        lrs.getString("code_departement"),
                        lrs.getString("nom_departement"));
//                d.setIdDepartement(lrs.getInt("id_departement"));
//                d.setCodeDepartement(lrs.getString("code_departement"));
//                d.setNomDepartement(lrs.getString("nom_departement"));
                // Sauvegarde des datas dans une liste
                resultList.add(d);
            }

            // Fermeture des pointeurs
            lrs.close();
            lpst.close();
        } catch (SQLException e) { // Exécution quand une exception est levée
            System.out.println("SELECT ALL : " + e.getMessage());
            Departement d = new Departement(-1, null, null);
            resultList.add(d);
        }

        // renvoi de la liste des résultats (une list d'objets)
        return resultList;
    } /// selectAll

    /**
     *
     * @param d
     * @return
     */
    public int update(Departement d) {
        int liAffecte = 0;
        String lsSQL = "CALL departementUpdate(?, ?, ?)";
        try {
            // Préparation de la requete
            PreparedStatement lpst = icnx.prepareStatement(lsSQL);

            // Valorisation des variables
            lpst.setInt(1, d.getIdDepartement());
            lpst.setString(2, d.getCodeDepartement());
            lpst.setString(3, d.getNomDepartement());

            // Exécution de la requete
            liAffecte = lpst.executeUpdate();
            // Valider l'exécution
//            icnx.commit();
            lpst.close();
        } catch (SQLException e) { // Si l'exception est levée
            liAffecte = -1;
            System.out.println("UPDATE : " + e.getMessage());
        }

        // renvoi du nombre de ligne affectée
        return liAffecte;
    }
} /// class

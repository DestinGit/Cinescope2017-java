/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import entities.Pays;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author formation
 */
public class PaysDAO implements IDAO<Pays> {

    private Connection cnx;

    public PaysDAO(Connection cnx) {
        this.cnx = cnx;
    }
    
    @Override
    public int insert(Pays objet) {
        int liAffecte = 0;

        String lsInsert = "INSERT INTO pays(NOM_pays, MASCULIN, FEMININ, NEUTRE) VALUES(?,?,?,?)";

        try {
            // Preparation de la requête
            PreparedStatement pst = this.cnx.prepareStatement(lsInsert);
            // valorisation des variables
            pst.setString(1, objet.getNomPays());
            pst.setString(2, objet.getMasculin());
            pst.setString(3, objet.getFeminin());
            pst.setString(4, objet.getNeutre());
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
    public List<Pays> selectAll() {
        List<Pays> resultList = new ArrayList();

        String lsSQL = "CALL paysSelectAll()";
        try {
            // Préparation de la requete
            PreparedStatement lpst = cnx.prepareStatement(lsSQL);
            // Exécution de la requete
            ResultSet lrs = lpst.executeQuery();
            // Lecture des datas
            while (lrs.next()) {
                Pays g = new Pays(lrs.getInt("ID_pays"), lrs.getString("NOM_pays"),
                        lrs.getString("MASCULIN"), lrs.getString("FEMININ"), lrs.getString("NEUTRE"));
                resultList.add(g);
            }

            // Fermeture des pointeurs
            lrs.close();
            lpst.close();
        } catch (SQLException e) { // Exécution quand une exception est levée
            System.out.println("SELECT ALL : " + e.getMessage());
            Pays d = new Pays(-1, null, null, null, null);
            resultList.add(d);
        }

        // renvoi de la liste des résultats (une list d'objets)
        return resultList;
    }

    @Override
    public Pays selectOne(int id) {
        Pays d = new Pays();
        String lsSQL = "SELECT * FROM pays WHERE ID_pays = ?";
        try {
            // Préparation de la requete
            PreparedStatement lpst = cnx.prepareStatement(lsSQL);
            // Valorisation des variables
            lpst.setInt(1, id);
            // Exécution de la requête
            ResultSet lrs = lpst.executeQuery();
            // test si resultat existe. Si oui, initialiser l'objet Departement
            if (lrs.next()) {
                d.setIdPays(id);
                d.setNomPays(lrs.getString("NOM_pays"));
                d.setMasculin(lrs.getString("MASCULIN"));
                d.setFeminin(lrs.getString("FEMININ"));
                d.setNeutre(lrs.getString("NEUTRE"));
            } else { // Si non, initialiser l'objet Departement avec les valeurs par défaut
                d.setIdPays(0);
                d.setNomPays(null);
                d.setMasculin(null);
                d.setFeminin(null);
                d.setNeutre(null);
            }
            // Fermeture des pointeurs
            lrs.close();
            lpst.close();
        } catch (SQLException e) { // Exécution quand une exception est levée
            System.out.println("SELECT ONE : " + e.getMessage());
        }
        return d;
    }

    @Override
    public int delete(Pays objet) {
        int liAffecte = 0;
        try {
            String lsSQL = "DELETE FROM pays WHERE ID_pays = ?";
            // Préparation de la requete
            try (PreparedStatement lpst = cnx.prepareStatement(lsSQL)) {
                //  Valorisation de la variable
                lpst.setInt(1, objet.getIdPays());
                // Exécution de la requête
                liAffecte = lpst.executeUpdate();
                // fermeture du pointeur
                lpst.close();
            }
        } catch (SQLException e) { // Exécution quand une exception est levée
            liAffecte = -1;
            System.out.println("DELETE : " + e.getMessage());
        }
        return liAffecte;
    }

    @Override
    public int update(Pays objet) {
        int liAffecte = 0;
        String lsSQL = "CALL genreUpdate(?, ?, ?, ?)";
        try {
            // Préparation de la requete
            PreparedStatement lpst = cnx.prepareStatement(lsSQL);

            // Valorisation des variables
            lpst.setInt(1, objet.getIdPays());
            lpst.setString(2, objet.getNomPays());
            lpst.setString(3, objet.getMasculin());
            lpst.setString(4, objet.getFeminin());
            lpst.setString(5, objet.getNeutre());

            // Exécution de la requete
            liAffecte = lpst.executeUpdate();
            // Valider l'exécution
            lpst.close();
        } catch (SQLException e) { // Si l'exception est levée
            liAffecte = -1;
            System.out.println("UPDATE : " + e.getMessage());
        }

        // renvoi du nombre de ligne affectée
        return liAffecte;
    }

}

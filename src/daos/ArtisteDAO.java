/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import entities.Artiste;
import entities.Pays;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author formation
 */
public class ArtisteDAO implements IDAO<Artiste> {

    private Connection cnx;

    public ArtisteDAO(Connection cnx) {
        this.cnx = cnx;
    }

    @Override
    public int insert(Artiste objet) {
        int liAffecte = 0;

        String lsInsert = "CALL artisteInsert(?)";

        try {
            // Preparation de la requête
            PreparedStatement pst = this.cnx.prepareStatement(lsInsert);
            // valorisation des variables
            pst.setString(1, objet.getNomArtiste());
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
    public List<Artiste> selectAll() {
        List<Artiste> resultList = new ArrayList();

        String lsSQL = "CALL artisteSelectAll()";
        try {
            // Préparation de la requete
            PreparedStatement lpst = cnx.prepareStatement(lsSQL);
            // Exécution de la requete
            ResultSet lrs = lpst.executeQuery();
            // Lecture des datas
            while (lrs.next()) {
                Artiste g = new Artiste(lrs.getInt("ID_artiste"), lrs.getString("NOM_artiste"));
                resultList.add(g);
            }

            // Fermeture des pointeurs
            lrs.close();
            lpst.close();
        } catch (SQLException e) { // Exécution quand une exception est levée
            System.out.println("SELECT ALL : " + e.getMessage());
            Artiste d = new Artiste(-1, null);
            resultList.add(d);
        }

        // renvoi de la liste des résultats (une list d'objets)
        return resultList;
    }

    @Override
    public Artiste selectOne(int id) {
        Artiste d = new Artiste();
        String lsSQL = "CALL artisteSelectOne(?)";
        try {
            // Préparation de la requete
            PreparedStatement lpst = cnx.prepareStatement(lsSQL);
            // Valorisation des variables
            lpst.setInt(1, id);
            // Exécution de la requête
            ResultSet lrs = lpst.executeQuery();
            // test si resultat existe. Si oui, initialiser l'objet Departement
            if (lrs.next()) {
                d.setIdArtiste(id);
                d.setNomArtiste(lrs.getString("NOM_artiste"));
            } else { // Si non, initialiser l'objet Departement avec les valeurs par défaut
                d.setIdArtiste(-1);
                d.setNomArtiste(null);
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
    public int delete(Artiste objet) {
        int liAffecte = 0;
        try {
            String lsSQL = "CALL artisteDelete(?)";
            // Préparation de la requete
            try (PreparedStatement lpst = cnx.prepareStatement(lsSQL)) {
                //  Valorisation de la variable
                lpst.setInt(1, objet.getIdArtiste());
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
    public int update(Artiste objet) {
        int liAffecte = 0;
        String lsSQL = "CALL artisteUpdate(?,?)";
        try {
            // Préparation de la requete
            PreparedStatement lpst = cnx.prepareStatement(lsSQL);

            // Valorisation des variables
            lpst.setInt(1, objet.getIdArtiste());
            lpst.setString(2, objet.getNomArtiste());

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

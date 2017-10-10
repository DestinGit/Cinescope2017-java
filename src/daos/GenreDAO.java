/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import entities.Departement;
import entities.Genre;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author formation
 */
public class GenreDAO implements IDAO<Genre> {

    private Connection cnx;

    public GenreDAO(Connection cnx) {
        this.cnx = cnx;
    }

    @Override
    public int insert(Genre objet) {
        int liAffecte = 0;

        String lsInsert = "CALL genreInsert(?,?,?)";

        try {
            // Preparation de la requête
            PreparedStatement pst = this.cnx.prepareStatement(lsInsert);
            // valorisation des variables
            pst.setString(1, objet.getCodeGenre());
            pst.setString(2, objet.getLibelleGenre());
            pst.setString(3, objet.getGenreGrammatical());
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
    public List<Genre> selectAll() {
        List<Genre> resultList = new ArrayList();

        String lsSQL = "CALL genreSelectAll()";
        try {
            // Préparation de la requete
            PreparedStatement lpst = cnx.prepareStatement(lsSQL);
            // Exécution de la requete
            ResultSet lrs = lpst.executeQuery();
            // Lecture des datas
            while (lrs.next()) {
                Genre g = new Genre(lrs.getInt("ID_genre"), lrs.getString("CODE_genre"),
                        lrs.getString("LIBELLE_genre"), lrs.getString("genre_GRAMMATICAL"));
                resultList.add(g);
            }

            // Fermeture des pointeurs
            lrs.close();
            lpst.close();
        } catch (SQLException e) { // Exécution quand une exception est levée
            System.out.println("SELECT ALL : " + e.getMessage());
            Genre d = new Genre(-1, null, null, null);
            resultList.add(d);
        }

        // renvoi de la liste des résultats (une list d'objets)
        return resultList;
    }

    @Override
    public Genre selectOne(int id) {
        Genre d = new Genre();
        String lsSQL = "CALL genreSelectOne(?)";
        try {
            // Préparation de la requete
            PreparedStatement lpst = cnx.prepareStatement(lsSQL);
            // Valorisation des variables
            lpst.setInt(1, id);
            // Exécution de la requête
            ResultSet lrs = lpst.executeQuery();
            // test si resultat existe. Si oui, initialiser l'objet Departement
            if (lrs.next()) {
                d.setIdGenre(id);
                d.setCodeGenre(lrs.getString("CODE_genre"));
                d.setLibelleGenre(lrs.getString("LIBELLE_genre"));
                d.setGenreGrammatical(lrs.getString("genre_GRAMMATICAL"));
            } else { // Si non, initialiser l'objet Departement avec les valeurs par défaut
                d.setIdGenre(0);
                d.setCodeGenre(null);
                d.setLibelleGenre(null);
                d.setGenreGrammatical(null);
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
    public int delete(Genre objet) {
        int liAffecte = 0;
        try {
            String lsSQL = "CALL genreDelete(?)";
            // Préparation de la requete
            try (PreparedStatement lpst = cnx.prepareStatement(lsSQL)) {
                //  Valorisation de la variable
                lpst.setInt(1, objet.getIdGenre());
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
    public int update(Genre objet) {
        int liAffecte = 0;
        String lsSQL = "CALL genreUpdate(?, ?, ?, ?)";
        try {
            // Préparation de la requete
            PreparedStatement lpst = cnx.prepareStatement(lsSQL);

            // Valorisation des variables
            lpst.setInt(1, objet.getIdGenre());
            lpst.setString(2, objet.getCodeGenre());
            lpst.setString(3, objet.getLibelleGenre());
            lpst.setString(4, objet.getGenreGrammatical());

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

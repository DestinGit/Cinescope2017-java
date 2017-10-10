/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

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
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Genre> selectAll() {
         List<Genre> resultList = new ArrayList();

        String lsSQL = "CALL departementSelectAll()";
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
       
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Genre selectOne(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(Genre objet) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int update(Genre objet) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

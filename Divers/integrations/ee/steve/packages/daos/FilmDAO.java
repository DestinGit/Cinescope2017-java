/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import connexion.Connexion;
import entities.FilmRecherche;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author allth
 */
public class FilmDAO {

    public static String getHPP() {

        StringBuilder lsb = new StringBuilder();

        //Connection lcn = getConnexionMySQL(String asServeur, String asBD, String asPort, String asUT, String asMDP);
        Connection lcn = Connexion.getConnexionMySQL("172.26.55.55", "cinescope2014", "3306", "p", "b");

        try {
            PreparedStatement lpst = lcn.prepareStatement("CALL xxx_hit_parade_du_public()");
            ResultSet lrs = lpst.executeQuery();

            // j'ajoute les titres à ma StringBuilder
            lsb.append("Titre film | Entrees semaine | Nombre semaines | Total entrées\n");

            // à chaque ligne du curseur de notre ResultSet, on ajoute a la StringBuilder la ligne d'un film
            while (lrs.next()) {

                lsb.append(lrs.getString(1));
                lsb.append("|");
                lsb.append(lrs.getString(2));
                lsb.append("|");
                lsb.append(lrs.getString(3));
                lsb.append("|");
                lsb.append(lrs.getString(4));
                lsb.append("\n");

            }
        } catch (SQLException e) {
            lsb.append(e.getMessage());
        }

        Connexion.seDeconnecter(lcn);

        return lsb.toString();
    } /// getHPP

    public static String getBO() {

        //Connection lcn = getConnexionMySQL(String asServeur, String asBD, String asPort, String asUT, String asMDP);
        Connection lcn = Connexion.getConnexionMySQL("172.26.55.55", "cinescope2014", "3306", "p", "b");

        // mes variables
        JSONObject ObjectJSON;
        JSONArray tableauJSON = new JSONArray();
        try {
            PreparedStatement lpst = lcn.prepareStatement("CALL box_office()");
            ResultSet lrs = lpst.executeQuery();
            // j'utilise i pour donner la position du film par rapport à son notre d'entrée
            int i = 1;
            /* à chaque enregistrement du curseur, on instancie un objet json et on lui put les 
             données et à la fin on poute l'objet dans le tableau de jason*/
            while (lrs.next()) {
                ObjectJSON = new JSONObject();
                ObjectJSON.put("titre", lrs.getString(1));
                ObjectJSON.put("entrees", lrs.getString(2));
                ObjectJSON.put("position", Integer.toString(i));
                i++;
                //ici le poute dans le tableau
                tableauJSON.put(ObjectJSON);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FilmDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        Connexion.seDeconnecter(lcn);

        return tableauJSON.toString();
    } /// getHPP

    public static String getFilmAutoCompletion() {

        //StringBuilder lsb = new StringBuilder();
        //Connection lcn = getConnexionMySQL(String asServeur, String asBD, String asPort, String asUT, String asMDP);
        //Connection lcn = Connexion.getConnexionMySQL("172.26.55.55", "cinescope2014", "3306", "p", "b");
        Connection lcn = Connexion.getConnexionMySQL("localhost", "cinescope2017", "3306", "root", "");

        //mes variables
        JSONObject ObjectJSON;
        JSONArray tableauJSON = new JSONArray();
        try {
            PreparedStatement lpst = lcn.prepareStatement("select TITRE_film from film");
            ResultSet lrs = lpst.executeQuery();

            // à chaque enregistrement de mon curseur, j'instancie un objet json que je put à un tableau de json
            while (lrs.next()) {
                ObjectJSON = new JSONObject();
                ObjectJSON.put("titre", lrs.getString(1));
                tableauJSON.put(ObjectJSON);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FilmDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        Connexion.seDeconnecter(lcn);

        return tableauJSON.toString();
    } ///

    public static List<FilmRecherche> getFilmsRecherche(String Recherche) {

        //StringBuilder lsb = new StringBuilder();
        //Connection lcn = getConnexionMySQL(String asServeur, String asBD, String asPort, String asUT, String asMDP);
        //Connection lcn = Connexion.getConnexionMySQL("172.26.55.55", "cinescope2014", "3306", "p", "b");
        Connection lcn = Connexion.getConnexionMySQL("localhost", "cinescope2017", "3306", "root", "");

        //mes variables
        List<FilmRecherche> listeFilms;
        listeFilms = new ArrayList<FilmRecherche>();
        try {
//Ordre SQL qui me concatène tout les acteurs qui ont joué dans chasue film, etc...
//            String lsSQL = "SELECT group_concat(artiste.NOM_artiste) ,"
//                    + "        film.TITRE_film,"
//                    + "        film.ANNEE,"
//                    + "        film.duree,"
//                    + "        film.couleurs,"
//                    + "       genre.LIBELLE_genre,"
//                    + "       pays.MASCULIN,"
//                    + "       genre.genre_GRAMMATICAL,"
//                    + "       pays.FEMININ,"
//                    + "       pays.NEUTRE,"
//                    + "       pays.NOM_pays"
//                    + "  FROM cinescope2017.film film"
//                    + "INNER JOIN cinescope2017.genre genre"
//                    + "  ON film.ID_genre = genre.ID_genre"
//                    + "INNER JOIN cinescope2017.jouer jouer"
//                    + "  ON jouer.ID_film = film.ID_film"
//                    + "INNER JOIN cinescope2017.artiste artiste"
//                    + "  ON jouer.ID_artiste = artiste.ID_artiste"
//                    + "INNER JOIN cinescope2017.produire produire"
//                    + "  ON produire.ID_film = film.ID_film"
//                    + "INNER JOIN cinescope2017.pays pays"
//                    + "  ON produire.ID_pays = pays.ID_pays"
//                    + " group by film.titre_film";

            //ordre sql simplifié pour pouvoir afficher un max de film dans la recherche
            String lsSQL = "SELECT"
                    + " film.TITRE_film,"
                    + " film.ANNEE,"
                    + " film.couleurs,"
                    + " genre.LIBELLE_genre,"
                    + " genre.genre_GRAMMATICAL"
                    + " FROM cinescope2017.film film"
                    + " INNER JOIN cinescope2017.genre genre"
                    + "  ON film.ID_genre = genre.ID_genre"
                    + " where titre_film like ?";
            PreparedStatement lpst = lcn.prepareStatement(lsSQL);
            // paramètre de l'ordre sql, la saisie de la barre de recherche
            lpst.setString(1, Recherche);
            ResultSet lrs = lpst.executeQuery();

            // à chaque enregistrement de mon curseur j'instancie un objet FilmRecherche que j'ajoute à la liste de films
            while (lrs.next()) {
                FilmRecherche film = new FilmRecherche();
                film.setTitreFilm(lrs.getString(1).toString());
                film.setAnnee(lrs.getString(2).toString());
                film.setCouleur(lrs.getString(3).toString());
                film.setGenre(lrs.getString(4).toString());
                film.setGenreGrammatical(lrs.getString(5).toString());
                listeFilms.add(film);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FilmDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        Connexion.seDeconnecter(lcn);

        return listeFilms;
    } /// getHPP
} /// class

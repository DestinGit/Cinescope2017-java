/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import entities.Salle;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author formation
 */
public class SalleDAO implements IDAO<Salle> {

    private Connection cnx;

    public SalleDAO(Connection cnx) {
        this.cnx = cnx;
    }

    @Override
    public int insert(Salle objet) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Salle> selectAll() {
        List<Salle> resultList = new ArrayList();

        String lsSQL = "CALL salleSelectAll()";
        try {
            // Préparation de la requete
            PreparedStatement lpst = cnx.prepareStatement(lsSQL);
            // Exécution de la requete
            ResultSet lrs = lpst.executeQuery();
            // Lecture des datas
            while (lrs.next()) {
                Salle g = new Salle(lrs.getInt("ID_salle"), lrs.getInt("ID_cinema"),
                        lrs.getInt("ID_festival"), lrs.getString("NOM_salle"), lrs.getString("DESCRIPTION_salle"));
                resultList.add(g);
            }

            // Fermeture des pointeurs
            lrs.close();
            lpst.close();
        } catch (SQLException e) { // Exécution quand une exception est levée
            System.out.println("SELECT ALL : " + e.getMessage());
            Salle d = new Salle(-1, -1, -1, null, null);
            resultList.add(d);
        }

        // renvoi de la liste des résultats (une list d'objets)
        return resultList;
    }

    @Override
    public Salle selectOne(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(Salle objet) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int update(Salle objet) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

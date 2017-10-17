/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import entities.Produire;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author formation
 */
public class ProduireDAO implements IDAO<Produire>{
    private final Connection cnx;

    public ProduireDAO(Connection cnx) {
        this.cnx = cnx;
    }

    @Override
    public int insert(Produire objet) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Produire> selectAll() {
        List<Produire> resultList = new ArrayList();

        String lsSQL = "CALL produireSelectAll()";
        try {
            // Préparation de la requete
            PreparedStatement lpst = cnx.prepareStatement(lsSQL);
            // Exécution de la requete
            ResultSet lrs = lpst.executeQuery();
            // Lecture des datas
            while (lrs.next()) {
                Produire g = new Produire(lrs.getInt("ID_pays"), lrs.getInt("ID_film"),
                        lrs.getInt("RANG_PRODUCTION"));
                resultList.add(g);
            }

            // Fermeture des pointeurs
            lrs.close();
            lpst.close();
        } catch (SQLException e) { // Exécution quand une exception est levée
            System.out.println("SELECT ALL : " + e.getMessage());
            Produire d = new Produire(-1, -1, -1);
            resultList.add(d);
        }

        // renvoi de la liste des résultats (une list d'objets)
        return resultList;
    }

    @Override
    public Produire selectOne(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(Produire objet) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int update(Produire objet) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

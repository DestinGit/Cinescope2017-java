/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import entities.Media;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author formation
 */
public class MediaDAO implements IDAO<Media> {

    private Connection con;
    private int ligneAffecte;

    public MediaDAO(Connection con) {
        this.con = con;
    }

    @Override
    public int insert(Media objet) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Media> selectAll() {
        List<Media> Media = new ArrayList<>();
        try {
            String query = "CALL mediaSelectAll()";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Media media = new Media(rs.getInt(1), rs.getString(2));
                Media.add(media);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            Media media = new Media(-1, e.getMessage());
            Media.add(media);
        }
        return Media;
    }

    @Override
    public Media selectOne(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(Media objet) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int update(Media objet) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

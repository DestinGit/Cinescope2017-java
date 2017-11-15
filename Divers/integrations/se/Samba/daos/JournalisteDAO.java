/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import entities.Journaliste;
import java.sql.*;
import java.util.*;

/**
 *
 * @author formation
 */
public class JournalisteDAO implements IDAO<Journaliste> {

    private Connection con;
    private int ligneAffecte;

    public JournalisteDAO(Connection con) {
        this.con = con;
    }

    @Override
    public int insert(Journaliste journaliste) {
        try {
            String query = "CALL journalisteInsert(?,?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, journaliste.getId_media());
            ps.setString(2, journaliste.getNom_journaliste());
            ps.executeUpdate();
            ligneAffecte = 1;
            con.commit();
            ps.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            ligneAffecte = -1;
        }
        return ligneAffecte;
    }

    @Override
    public List<Journaliste> selectAll() {
        List<Journaliste> Journaliste = new ArrayList<>();

        try {
            String query = "CALL journalisteSelectAllJoinMedia()";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Journaliste journaliste = new Journaliste(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4));
                Journaliste.add(journaliste);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            Journaliste journaliste = new Journaliste(-1, -1, e.getMessage(), e.getMessage());
            Journaliste.add(journaliste);
        }
        return Journaliste;
    }

    @Override
    public Journaliste selectOne(int id) {

        Journaliste journaliste = new Journaliste();
        try {
            String query = "CALL journalisteSelectOne(?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, journaliste.getId_journaliste());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                journaliste.setId_journaliste(id);
                journaliste.setId_media(rs.getInt(1));
                journaliste.setNom_journaliste(rs.getString(2));

            } else {
                journaliste.setId_journaliste(0);
                journaliste.setId_media(1);
                journaliste.setNom_journaliste("INTROUVABLE");
            }
            rs.close();
            ps.close();

        } catch (SQLException e) {
            journaliste.setId_journaliste(-1);
            journaliste.setId_media(-1);
            journaliste.setNom_journaliste(e.getMessage());
            System.out.println(e.getMessage());
        }
        return journaliste;
    }

    @Override
    public int delete(Journaliste journaliste) {

        try {
            String query = "CALL journalisteDelete(?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, journaliste.getId_journaliste());
            ps.executeUpdate();
            ligneAffecte = 1;
            con.commit();
            ps.close();
        } catch (SQLException e) {

            System.out.println(e.getMessage());
            ligneAffecte = -1;
        }
        return ligneAffecte;
    }

    @Override
    public int update(Journaliste journaliste) {
        try {
            String query = "CALL journalisteUpdate(?,?,?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, journaliste.getId_media());
            ps.setString(2, journaliste.getNom_journaliste());
            ps.setInt(3, journaliste.getId_journaliste());
            ps.executeUpdate();
            ligneAffecte = 1;
            ps.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            ligneAffecte = -1;
        }
        return ligneAffecte;
    }

}

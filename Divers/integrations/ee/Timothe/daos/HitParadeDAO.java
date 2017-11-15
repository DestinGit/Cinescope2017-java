/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.c2017.daos;

import fr.c2017.entities.HitParade;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author formation
 */
public class HitParadeDAO {

    private Connection icn;

    public HitParadeDAO(Connection icn) {
        this.icn = icn;
    }

    public List<HitParade> selectAll() {

        List<HitParade> LHitP = new ArrayList<>();
        HitParade hp;
        ResultSet lrs;
        PreparedStatement lpst;
        try {
            String rSQL = "CALL xxx_hit_parade_du_public()";
            lpst = icn.prepareStatement(rSQL);

            lrs = lpst.executeQuery();
            while (lrs.next()) {
                hp = new HitParade();
                hp.setLnom(lrs.getString("TITRE_film"));
                hp.setLentreeSe(lrs.getDouble("ENTREES_SEMAINE"));
                hp.setLsemaines(lrs.getDouble("NOMBRE_SEMAINES"));
                hp.setLentreeTT(lrs.getDouble("TOTAL_ENTREES"));

                LHitP.add(hp);

            }

            lrs.close();
            lpst.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }

        return LHitP;
    }

}

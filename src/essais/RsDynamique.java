/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package essais;

/**
 *
 * @author formation
 */
import java.sql.*;

public class RsDynamique {

    public static void main(String[] args) {
        // --- Declarations
        Connection lcConnexion;
        Statement lstSql;
        ResultSet lrs;
        ResultSetMetaData lrsmd;
        String lsSelect;
        StringBuilder lsbEntetes = new StringBuilder();
        StringBuilder lsbData = new StringBuilder();
        int liCols, liCtr;
        Object loValeur;

        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            lcConnexion = DriverManager.getConnection("jdbc:mysql://localhost/cours", "root", "");

            lstSql = lcConnexion.createStatement();

            lsSelect = "SELECT * FROM villes";
//            lsSelect = "SELECT id_client AS 'ID Client', nom FROM clients";
//            lsSelect = "SELECT  nom_ville as 'Ville', nom FROM villes v, clients c WHERE v.cp = c.cp";
            lrs = lstSql.executeQuery(lsSelect);
            lrsmd = lrs.getMetaData();
            liCols = lrsmd.getColumnCount();

            // --- Affichage des en-têtes des colonnes
            for (liCtr = 1; liCtr <= liCols; ++liCtr) {
                lsbEntetes.append(lrsmd.getColumnLabel(liCtr));
                lsbEntetes.append("-");
            }
            lsbEntetes.deleteCharAt(lsbEntetes.length() - 1);
            System.out.println(lsbEntetes.toString());

            // --- Affichage du contenu des colonnes
            while (lrs.next()) {
                for (liCtr = 1; liCtr <= liCols; liCtr++) {
                    loValeur = lrs.getObject(liCtr);
                    if (loValeur == null) {
                        lsbData.append("NUL -");
                    } else {
                        lsbData.append(loValeur.toString());
                        lsbData.append("-");
                    }

                } /// for colonnes
                lsbData.deleteCharAt(lsbData.length() - 1);
                lsbData.append("\n");
                } /// lignes
            System.out.println(lsbData.toString());

            lrs.close();
            lstSql.close();
            lcConnexion.close();
        } catch (ClassNotFoundException err) {
            System.err.println("Pilote non monté : " + err);
        } catch (SQLException err) {
            System.err.println("Erreur SQL : " + err);
        }

    } /// main

} /// class
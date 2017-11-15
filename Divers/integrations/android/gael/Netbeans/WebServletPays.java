/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controls;

import daos.Connexion;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.*;
import static javafx.scene.input.KeyCode.T;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author formation
 */
@WebServlet(name = "SQLite", urlPatterns = {"/SQLite"})

public class SQLite extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String chaineJSON = "";
        JSONArray tableauJSON = new JSONArray();;
        JSONObject objetJSON;

        try {
            Connection lcn = Connexion.getConnexionMySQL("172.26.55.55", "cinescope2014", "3306", "p", "b");
            Statement lst = lcn.createStatement();
            ResultSet lrs = lst.executeQuery("SELECT * FROM pays");
            ResultSetMetaData lrsmd = lrs.getMetaData();

            int liCols = lrsmd.getColumnCount();

            while (lrs.next()) {
                
                objetJSON = new JSONObject();
                for (int i = 1; i <= liCols; i++) {
                    objetJSON.put(lrsmd.getColumnName(i), lrs.getString(i));
                }
                tableauJSON.put(objetJSON);
            }
            lcn.close();
        } catch (Exception e) {
            tableauJSON = new JSONArray();
            objetJSON = new JSONObject();
            try {
                objetJSON.put("Erreur", e.getMessage());
            } catch (JSONException ex) {
            }

            tableauJSON.put(objetJSON);

        }
      /*  JSONObject ob = null;
        for (int i = 0; i < tableauJSON.length(); i++) {
            ob = (JSONObject) tableauJSON.get(i);
            out.print(ob.get("NOM_PAYS") + "\t");

        }*/
        //out.print(ob);
        out.print(tableauJSON);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String chaineJSON = "";
        JSONArray tableauJSON = new JSONArray();;
        JSONObject objetJSON;

        try {
            Connection lcn = Connexion.getConnexionMySQL("172.26.55.55", "cinescope2014", "3306", "p", "b");
            Statement lst = lcn.createStatement();
            ResultSet lrs = lst.executeQuery("SELECT * FROM pays");
            ResultSetMetaData lrsmd = lrs.getMetaData();

            int liCols = lrsmd.getColumnCount();

            while (lrs.next()) {
                objetJSON = new JSONObject();
                for (int i = 1; i <= liCols; i++) {
                    objetJSON.put(lrsmd.getColumnName(i), lrs.getString(i));
                }
                tableauJSON.put(objetJSON);
            }
            lcn.close();
        } catch (Exception e) {
            tableauJSON = new JSONArray();
            objetJSON = new JSONObject();
            try {
                objetJSON.put("Erreur", e.getMessage());
            } catch (JSONException ex) {
            }
            tableauJSON.put(objetJSON);
        }
        chaineJSON = tableauJSON.toString();
    }


}

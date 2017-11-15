/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controls;

import connexion.Connexion;
import java.io.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import org.json.*;

/**
 *
 * @author quent
 */
@WebServlet(name = "DepartementSelectAll", urlPatterns = {"/DepartementSelectAll"})
public class DepartementSelectAll extends HttpServlet {

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

        response.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = response.getWriter();

        Connection lcn = Connexion.getConnexionMySQL("172.26.55.55", "cinescope2014", "3306", "p", "b");
        JSONObject departement;
        JSONArray tableauJSON = new JSONArray();

        try {
            PreparedStatement lpst = lcn.prepareStatement("CALL departementSelectAll()");
            ResultSet lrs = lpst.executeQuery();

            while (lrs.next()) {
                departement = new JSONObject();
                departement.put("ID_DEPARTEMENT", lrs.getString(1));
                departement.put("CODE_DEPARTEMENT", lrs.getString(2));
                departement.put("NOM_DEPARTEMENT", lrs.getString(3));
                tableauJSON.put(departement);
            }

            out.print(tableauJSON.toString());
            lrs.close();
            lpst.close();

        } catch (SQLException e) {
            out.print(e.getMessage());
        }

        Connexion.seDeconnecter(lcn);
    }
    
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

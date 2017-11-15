/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.pb.controls;

import daos.FilmDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author allth
 */
@WebServlet(name = "ResultatRecherchePrincipale", urlPatterns = {"/ResultatRecherchePrincipale"})
public class ResultatRecherchePrincipale extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("plain/text;charset=UTF-8");
        
        // variable qui concatène le %saisieDeLaRecherche% pour l'utiliser dans l'ordre sql avec un 'where titre_film like ?"
        String caractereSaisie = "%" + request.getParameter("recherche") + "%";

        //on incorpore a la request la saisie de recherche et la liste des films obtenu grace au DAO
        request.setAttribute("saisieDeRecherche", request.getParameter("recherche").trim());
        request.setAttribute("ListFilmResultat", FilmDAO.getFilmsRecherche(caractereSaisie));
        // string de l'url
        String lsURL = "ResultatRecherche.jsp";
        ServletContext sc = getServletContext();
        //tchouktchouk
        RequestDispatcher rd = sc.getRequestDispatcher("/jsp/" + lsURL);
        rd.forward(request, response);

    }

}

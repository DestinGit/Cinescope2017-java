/*
 * ControleurPrincipal.java
 */
package fr.pb.controls;

import connexion.Connexion;
import java.io.IOException;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author pascal
 */
@WebServlet(name = "ControleurPrincipal", urlPatterns = {"/ControleurPrincipal"})
public class ControleurPrincipal extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /*
        Connexion au serveur de BD
        */
        Connection lcn = Connexion.getConnexionMySQL("localhost", "cinescope2017", "3306", "root", "");
        /*
        Récupération de la session courante
        */
        HttpSession session = request.getSession();
        /*
        Mise en session de la connexion BD
        */
        session.setAttribute("gcnx", lcn);
        
        String lsURL = "Accueil.jsp";
        getServletContext().getRequestDispatcher("/jsp/" + lsURL).forward(request, response);
    } /// doGet

} /// class

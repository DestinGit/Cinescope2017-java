/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.c2017.controls;

import fr.c2017.daos.HitParadeDAO;
import fr.c2017.entities.HitParade;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author formation
 */
@WebServlet(name = "CHitParade", urlPatterns = {"/CHitParade"})
public class CHitParade extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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

        HttpSession session = request.getSession();
        Connection lcn = (Connection) session.getAttribute("gcnx");

        HitParadeDAO dao = new HitParadeDAO(lcn);
        List<HitParade> LHP = new ArrayList<>();
        LHP = dao.selectAll();
        System.out.println();
        session.setAttribute("tableau", LHP);
        ServletContext sc = getServletContext();
        RequestDispatcher rd = sc.getRequestDispatcher("/jsp/HitParade.jsp");
        rd.forward(request, response);

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
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession();
        Connection lcn = (Connection) session.getAttribute("gcnx");

        HitParadeDAO dao = new HitParadeDAO(lcn);
        HitParade hp;
        List<HitParade> LHP = new ArrayList<>();

        LHP = dao.selectAll();
        session.setAttribute("tableau", LHP);
        ServletContext sc = getServletContext();
        RequestDispatcher rd = sc.getRequestDispatcher("/jsp/HitParade.jsp");
        rd.forward(request, response);
    }
}

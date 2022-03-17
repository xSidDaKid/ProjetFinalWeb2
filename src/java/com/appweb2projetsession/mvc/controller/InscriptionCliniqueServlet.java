/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appweb2projetsession.mvc.controller;

import com.appweb2projetsession.action.CliniqueAction;
import com.appweb2projetsession.dao.clinique.CliniqueDAO;
import com.appweb2projetsession.dao.clinique.CliniqueImpDAO;
import com.appweb2projetsession.mvc.model.Clinique;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Robydul
 */
@WebServlet(name = "inscriptionCliniqueServlet", urlPatterns
        = {
            "/InscriptionCliniqueServlet"
        })
public class InscriptionCliniqueServlet extends HttpServlet {

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
        String nom = request.getParameter("nom");
        String adresse = request.getParameter("adresse");
        String tel = request.getParameter("tel");
        String services = request.getParameter("services");
        HttpSession session = request.getSession(true);
        int userID = (Integer) session.getAttribute("id");
        try {
            Clinique c1 = new Clinique(nom, adresse, tel, services, userID);
            boolean retour = CliniqueAction.ajouterClinique(c1);
            if (retour) {
                request.setAttribute("listeClinique", CliniqueAction.afficherTousClinique());
                request.getRequestDispatcher("WEB-INF/jsp/home.jsp").forward(request, response);

            }
        } catch (NullPointerException e) {
            request.getRequestDispatcher("WEB-INF/jsp/inscriptionClinique.jsp").forward(request, response);
        }
    }

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
        processRequest(request, response);
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
        processRequest(request, response);
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

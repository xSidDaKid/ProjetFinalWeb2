/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appweb2projetsession.mvc.controller;

import com.appweb2projetsession.action.CliniqueAction;
import com.appweb2projetsession.action.MedecinAction;
import com.appweb2projetsession.action.UtilisateurAction;
import com.appweb2projetsession.mvc.model.Clinique;
import com.appweb2projetsession.mvc.model.Medecin;
import com.appweb2projetsession.mvc.model.Utilisateur;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Shajaan
 */
public class InscriptionUser extends HttpServlet {

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

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String role = request.getParameter("role");
        boolean verif = false;
        //LISTE DES CLINIQUES
        List<Clinique> listeClinique = CliniqueAction.afficherTousClinique();
        request.setAttribute("listeClinique", listeClinique);

        //LISTE DES MEDECINS
        List<Medecin> listeMedecin = MedecinAction.afficherTous();
        request.setAttribute("listeMedecin", listeMedecin);

        try {
            if (UtilisateurAction.findByEmail(email) != null) {
                request.setAttribute("existe", "Un utilisateur avec ce email existe deja.");
            }
            if (username != null && password != null && email != null && role != null) {
                verif = UtilisateurAction.create(new Utilisateur(username, password, email, role));
            }
            Utilisateur nouveau = UtilisateurAction.findByEmail(email);
            if (verif) {
                HttpSession session = request.getSession(true);
                session.setAttribute("User", nouveau);

                if (role.equals("patient")) {
                    request.getRequestDispatcher("WEB-INF/jsp/inscriptionPatient.jsp").include(request, response);
                } else if (role.equals("clinique")) {
                    request.getRequestDispatcher("WEB-INF/jsp/inscriptionClinique.jsp").include(request, response);
                } else if (role.equals("medecin")) {
                    request.getRequestDispatcher("WEB-INF/jsp/inscriptionMedecin.jsp").include(request, response);
                } else {
                    request.getRequestDispatcher("WEB-INF/jsp/home.jsp").include(request, response);
                }
            } else {
                request.getRequestDispatcher("WEB-INF/jsp/inscriptionUser.jsp").include(request, response);

            }
        } catch (NullPointerException e) {
            request.getRequestDispatcher("WEB-INF/jsp/inscriptionUser.jsp").include(request, response);

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

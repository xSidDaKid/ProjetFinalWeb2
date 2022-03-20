/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appweb2projetsession.mvc.controller;

import com.appweb2projetsession.action.PatientAction;
import com.appweb2projetsession.mvc.model.Patient;
import com.appweb2projetsession.mvc.model.Utilisateur;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Shajaan
 */
public class InscriptionPatientServlet extends HttpServlet {

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

        HttpSession session = request.getSession(true);

        //INFO FORMULAIRE
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String nam = request.getParameter("nam");
        String nbSequentiel = request.getParameter("nbSequentiel");
        String dateNaissance = request.getParameter("dateNaissance");
        String sexe = request.getParameter("sexe");

        //SAUVEGARDE SESSION
        Utilisateur u1 = (Utilisateur) session.getAttribute("User");

        try {
            Patient p1 = new Patient(nom, prenom, nam, Integer.parseInt(nbSequentiel), dateNaissance, sexe.charAt(0), 1, 1, u1.getId());

            //VERIF NAM
            if (PatientAction.findByNAM(nam) != null) {
                request.setAttribute("existeNAM", "Un utilisateur avec ce numero d'assurance maladie existe deja.");
                request.getRequestDispatcher("WEB-INF/jsp/inscriptionPatient.jsp").forward(request, response);

            }
            //VERIF NB SEQUENTIEL
            if (PatientAction.findByNB(Integer.parseInt(nbSequentiel)) != null) {
                request.setAttribute("existeNB", "Un utilisateur avec ce numero sequentiel existe deja.");
                request.getRequestDispatcher("WEB-INF/jsp/inscriptionPatient.jsp").forward(request, response);

            }

            boolean verif = PatientAction.create(p1);

            Patient patient = PatientAction.findByIdUser(u1.getId());

            if (verif) {
                session.setAttribute("Patient", patient);
                request.getRequestDispatcher("WEB-INF/jsp/home.jsp").forward(request, response);
            }
        } catch (NullPointerException e) {
            request.getRequestDispatcher("WEB-INF/jsp/inscriptionPatient.jsp").forward(request, response);
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appweb2projetsession.mvc.controller;

import com.appweb2projetsession.action.MedecinAction;
import com.appweb2projetsession.mvc.model.Medecin;
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
public class InscriptionMedecin extends HttpServlet {

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
        String profession = request.getParameter("profession");
        String nbProfessionnel = request.getParameter("nbProfessionnel");
        String ententes = request.getParameter("ententes");
        String adresse = request.getParameter("adresse");
        String lieuProfession = request.getParameter("lieuProfession");

        //SAUVEGARDE SESSION
        Utilisateur u1 = (Utilisateur) session.getAttribute("User");
        try {
            Medecin m1 = new Medecin(nom, prenom, profession, nbProfessionnel, ententes, adresse, lieuProfession, 1, u1.getId());
            boolean verif = MedecinAction.create(m1);
            Medecin medecin = MedecinAction.findByIdUser(u1.getId());
            System.out.println(medecin);
            if (verif) {
                session.setAttribute("Medecin", medecin);
                request.getRequestDispatcher("WEB-INF/jsp/home.jsp").forward(request, response);
            }
        } catch (NullPointerException e) {
            request.getRequestDispatcher("WEB-INF/jsp/inscriptionMedecin.jsp").forward(request, response);
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

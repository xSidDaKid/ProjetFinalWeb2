/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appweb2projetsession.mvc.controller;

import com.appweb2projetsession.action.RendezVousAction;
import com.appweb2projetsession.mvc.model.Medecin;
import com.appweb2projetsession.mvc.model.RendezVous;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Shajaan
 */
public class Disponibilite extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.text.ParseException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession(true);
        Medecin m = (Medecin) session.getAttribute("Medecin");

        String date = request.getParameter("date");
        String time = request.getParameter("time");
        String s1 = date + " " + time;

        String deletedId = request.getParameter("deletedId");
        String modifId = request.getParameter("modifId");

        boolean create = false;

        if (date != null && time != null) {
            create = RendezVousAction.create(new RendezVous(s1, m.getId()));
        }

        if (deletedId != null) {
            boolean verifDelete = RendezVousAction.delete(Integer.parseInt(deletedId));
            if (verifDelete) {
                request.setAttribute("deleted", "Cette disponibilité a été supprimer avec succès!");
            }
        }

        List<RendezVous> listeRendezVousMedecin = RendezVousAction.findByMedecinId(m.getId());

        //Messages
        if (create) {
            request.setAttribute("DispoCreer", "Votre disponibilité a été ajoutée avec succès");
        }
        //Messages d'erreurs---
        if (listeRendezVousMedecin.isEmpty()) {
            request.setAttribute("erreurDispo", "Aucune disponibilité a été définie");
        } else {
            request.setAttribute("listeRendezVousMedecin", listeRendezVousMedecin);
        }
        request.getRequestDispatcher("WEB-INF/jsp/disponibilite.jsp").forward(request, response);
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(Disponibilite.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(Disponibilite.class.getName()).log(Level.SEVERE, null, ex);
        }
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

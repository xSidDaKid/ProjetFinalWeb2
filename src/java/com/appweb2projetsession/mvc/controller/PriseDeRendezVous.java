/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appweb2projetsession.mvc.controller;

import com.appweb2projetsession.action.MedecinAction;
import com.appweb2projetsession.action.RendezVousAction;
import com.appweb2projetsession.mvc.model.Patient;
import com.appweb2projetsession.mvc.model.Medecin;
import com.appweb2projetsession.mvc.model.RendezVous;
import java.io.IOException;
import java.io.PrintWriter;
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
public class PriseDeRendezVous extends HttpServlet {

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
        HttpSession session = request.getSession(false);

        //INFO FORMULAIRE
        String raison = request.getParameter("raison");
        String description = request.getParameter("description");
        String date = request.getParameter("date");

        //LE PATIENT QUI VEUT UN RENDEZ-VOUS :)
        Patient patient = (Patient) session.getAttribute("Patient");
        int idPatient = patient.getId();

        //LE MEDECIN DU PATIENT
        int idMedecin = patient.getId_medecin();
        Medecin medecin = MedecinAction.findById(idMedecin);

        //LES DISPONIBILITES DU MEDECIN DU PATIENT
        List<RendezVous> rV = RendezVousAction.findByAvaiableDate(idMedecin);

        //LE RENDEZ-VOUS CHOISI PAR LE PATIENT
        RendezVous rVChoisi = RendezVousAction.findByDate(date);
        int idRvChoisi = rVChoisi.getId();
        RendezVous nouveau = new RendezVous(idRvChoisi, date, idMedecin, idPatient, raison, description);
        boolean rvCreer = RendezVousAction.update(nouveau);

        if (rvCreer) {
            request.setAttribute("rvCreer", "Votre rendez-vous a été ajoutée avec succès!");
        }

        //LISTE DES RENDEZ-VOUS DU PATIENT
        List<RendezVous> mesRV = RendezVousAction.findByPatientId(idPatient);
        if (mesRV.isEmpty()) {
            request.setAttribute("erreurRV", "Aucun rendez-vous a été pris");
        } else {
            request.setAttribute("mesRV", mesRV);
        }

        request.setAttribute("medecinPatient", medecin);
        request.setAttribute("listeRendezVous", rV);

        request.getRequestDispatcher("WEB-INF/jsp/priseDeRendezVous.jsp").include(request, response);

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

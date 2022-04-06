/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appweb2projetsession.mvc.controller;

import com.appweb2projetsession.action.ProfilAction;
import com.appweb2projetsession.mvc.model.Patient;
import com.appweb2projetsession.mvc.model.Profil;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author Shajaan
 */
@MultipartConfig(maxFileSize = 16177215)
public class EnvoieInfo extends HttpServlet {

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

        //INFO FORMULAIRE
        String info = request.getParameter("info");
        String fichier = request.getParameter("fichier");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
        LocalDateTime now = LocalDateTime.now();
        String date = dtf.format(now);

        //SESSION
        HttpSession session = request.getSession(true);
        Patient patient = (Patient) session.getAttribute("Patient");
        int id_Patient = patient.getId();
        int id_Medecin = patient.getId_medecin();

        //CREER UN INPUTSTREAM DU FICHIER ENVOYER
        InputStream inputStream = null;
        String nomFichier = "";
        try {

            Part filePart = request.getPart("fichier");
            if (filePart != null) {
                nomFichier = filePart.getSubmittedFileName();
                inputStream = filePart.getInputStream();
            }
        } catch (Exception e) {
            request.getRequestDispatcher("WEB-INF/jsp/envoieInfo.jsp").forward(request, response);
        }
        
        //CREER PROFIL
        if (info != null) {
            Profil profil = new Profil(nomFichier, inputStream, info, date, id_Patient, id_Medecin);
            boolean verif = ProfilAction.create(profil);
        }

        request.getRequestDispatcher("WEB-INF/jsp/envoieInfo.jsp").forward(request, response);

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

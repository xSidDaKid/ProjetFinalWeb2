/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appweb2projetsession.mvc.controller;

import com.appweb2projetsession.action.PatientAction;
import com.appweb2projetsession.action.ProfilAction;
import com.appweb2projetsession.mvc.model.Medecin;
import com.appweb2projetsession.mvc.model.Patient;
import com.appweb2projetsession.mvc.model.Profil;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
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
public class EspacePatient extends HttpServlet {

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

        boolean verif = false;
        request.setAttribute("verif", verif);
        String patient = request.getParameter("patient");

        //SESSION
        HttpSession session = request.getSession(true);
        Medecin medecin = (Medecin) session.getAttribute("Medecin");

        //PATIENTS DU MEDECIN
        List<com.appweb2projetsession.mvc.model.Patient> listePatient = PatientAction.findByIdMedecin(medecin.getId());
        request.setAttribute("listePatient", listePatient);

        if (patient != null) {

            int id_Patient = Integer.parseInt(patient);
            verif = true;
            request.setAttribute("verif", verif);

            Patient infoPatient = PatientAction.findById(id_Patient);
            request.setAttribute("infoPatient", infoPatient);

            //LIRE LE FICHIER ENVOYER
            List<Profil> lstProfil = ProfilAction.afficherPatientMedecin(Integer.parseInt(patient), medecin.getId());
            request.setAttribute("lstProfil", lstProfil);
            
            for (Profil profil : lstProfil) {

                File file = new File(profil.getNomFichier());
                FileOutputStream output = new FileOutputStream(file);
                System.out.println("Writing to file " + file.getAbsolutePath());
                byte[] buffer = new byte[1024];

                while (profil.getContenuFichier().read(buffer) > 0) {
                    output.write(buffer);
                }
                Desktop.getDesktop().open(new File(file.getAbsolutePath()));
            }
        }
        request.getRequestDispatcher("WEB-INF/jsp/espacePatient.jsp").forward(request, response);
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

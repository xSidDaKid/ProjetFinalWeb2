/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appweb2projetsession.mvc.controller;

import com.appweb2projetsession.action.CliniqueAction;
import com.appweb2projetsession.action.PatientAction;
import com.appweb2projetsession.mvc.model.Clinique;
import com.appweb2projetsession.mvc.model.Patient;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Shajaan
 */
@WebServlet(name = "Admin", urlPatterns = {"/admin"})
public class Admin extends HttpServlet {

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

        String supprimer = request.getParameter("deletedId");
        String modifier = request.getParameter("modifId");

        List<Patient> listePatient = PatientAction.afficherTous();
        List<Clinique> listeClinique = CliniqueAction.afficherTousClinique();

        request.setAttribute("listePatient", listePatient);
        request.setAttribute("listeClinique", listeClinique);

        if (supprimer != null) {
            boolean v = false;
            v = PatientAction.delete(Integer.parseInt(supprimer));
            v = CliniqueAction.supprimerClinique(Integer.parseInt(supprimer));
            
            listePatient = PatientAction.afficherTous();
            listeClinique = CliniqueAction.afficherTousClinique();

            request.setAttribute("listePatient", listePatient);
            request.setAttribute("listeClinique", listeClinique);
            request.getRequestDispatcher("WEB-INF/jsp/admin.jsp").forward(request, response);
        }
        if (modifier != null) {
            Patient patient = PatientAction.findById(Integer.parseInt(modifier));
            request.setAttribute("patient", patient);
            PatientAction.update(patient);
            listePatient = PatientAction.afficherTous();
            request.setAttribute("listePatient", listePatient);
            request.getRequestDispatcher("WEB-INF/jsp/admin.jsp").forward(request, response);
        }
        request.getRequestDispatcher("WEB-INF/jsp/admin.jsp").forward(request, response);
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

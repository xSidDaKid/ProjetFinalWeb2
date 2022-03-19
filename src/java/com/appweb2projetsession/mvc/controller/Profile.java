/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appweb2projetsession.mvc.controller;

import com.appweb2projetsession.action.CliniqueAction;
import com.appweb2projetsession.action.PatientAction;
import com.appweb2projetsession.action.UtilisateurAction;
import com.appweb2projetsession.mvc.model.Clinique;
import com.appweb2projetsession.mvc.model.Patient;
import com.appweb2projetsession.mvc.model.Utilisateur;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
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
public class Profile extends HttpServlet {

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

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String role = request.getParameter("role");

        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String nam = request.getParameter("nam");
        String nbSequentiel = request.getParameter("nbSequentiel");
        String dateNaissance = request.getParameter("dateNaissance");
        String sexe = request.getParameter("sexe");
        List<Patient> listePatient = PatientAction.afficherTous();
        List<Clinique> listeClinique = CliniqueAction.afficherTousClinique();
        List<Utilisateur> listeUtilisateur = UtilisateurAction.findAll();

        try {

            if (session != null) {
                if (session.getAttribute("username").equals("admin")) {
                    Utilisateur userModier = (Utilisateur) session.getAttribute("userModif");
                    Patient patientModier = (Patient) session.getAttribute("patientModif");
                    System.out.println("b" + session.getAttribute("patientModif"));
                    System.out.println("user" + userModier);
                    System.out.println("nom: " + nom);
                    UtilisateurAction.update(userModier = new Utilisateur(userModier.getId(), username, password, email, userModier.getRole()));
                    PatientAction.update(patientModier = new Patient(patientModier.getId(), nom, prenom, nam, Integer.parseInt(nbSequentiel), dateNaissance, sexe.charAt(0), 1, 1, userModier.getId()));
                    listePatient = PatientAction.afficherTous();
                    listeClinique = CliniqueAction.afficherTousClinique();
                    listeUtilisateur = UtilisateurAction.findAll();

                    request.setAttribute("listePatient", listePatient);
                    request.setAttribute("listeClinique", listeClinique);
                    request.setAttribute("listeUtilisateur", listeUtilisateur);
                    request.getRequestDispatcher("WEB-INF/jsp/admin.jsp").forward(request, response);

                } else {
                    Utilisateur user = (Utilisateur) session.getAttribute("User");
                    Patient patient = (Patient) session.getAttribute("Patient");

                    boolean verifU = UtilisateurAction.update(user = new Utilisateur(user.getId(), username, password, email, user.getRole()));
                    boolean verifP = PatientAction.update(patient = new Patient(patient.getId(), nom, prenom, nam, Integer.parseInt(nbSequentiel), dateNaissance, sexe.charAt(0), 1, 1, user.getId()));
                    session.setAttribute("User", user);
                    session.setAttribute("Patient", patient);
                    request.getRequestDispatcher("WEB-INF/jsp/profile.jsp").include(request, response);
                }
            }
        } catch (NumberFormatException e) {
            request.getRequestDispatcher("WEB-INF/jsp/profile.jsp").include(request, response);

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

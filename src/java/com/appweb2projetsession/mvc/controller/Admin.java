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
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
        HttpSession session = request.getSession(true);

        String supprimer = request.getParameter("deletedId");
        String modifier = request.getParameter("modifId");
        //Liste des tables SQL TODO:MEDECIN
        List<Patient> listePatient = PatientAction.afficherTous();
        List<Clinique> listeClinique = CliniqueAction.afficherTousClinique();
        List<Utilisateur> listeUtilisateur = UtilisateurAction.findAll();

        //Messages d'erreurs---
        if (listePatient.isEmpty()) {
            request.setAttribute("erreur", "La liste est vide");
        } else {
            request.setAttribute("listePatient", listePatient);
        }
        if (listeClinique.isEmpty()) {
            request.setAttribute("erreur", "La liste est vide");
        } else {
            request.setAttribute("listeClinique", listeClinique);
        }
        if (listeUtilisateur.isEmpty()) {
            request.setAttribute("erreur", "La liste est vide");
        } else {
            request.setAttribute("listeUtilisateur", listeUtilisateur);
        }

        //FONCTION: DELETE---
        if (supprimer != null) {
            boolean v = false;
            v = PatientAction.delete(Integer.parseInt(supprimer));
            v = CliniqueAction.supprimerClinique(Integer.parseInt(supprimer));
            v = UtilisateurAction.delete(Integer.parseInt(supprimer));

            listePatient = PatientAction.afficherTous();
            listeClinique = CliniqueAction.afficherTousClinique();
            listeUtilisateur = UtilisateurAction.findAll();

            request.setAttribute("listePatient", listePatient);
            request.setAttribute("listeClinique", listeClinique);
            request.setAttribute("listeUtilisateur", listeUtilisateur);

            request.getRequestDispatcher("WEB-INF/jsp/admin.jsp").forward(request, response);

        } else if (modifier != null) {
            try {

                Patient patient = PatientAction.findById(Integer.parseInt(modifier));
                Utilisateur user = UtilisateurAction.findByID(patient.getId_user());
                // session.setAttribute("patientModif", patient);
//                request.setAttribute("patientModif", patient);
System.out.println("user: " + user);
                session.setAttribute("patientModif", patient);
                session.setAttribute("userModif", user);
                //request.setAttribute("userModif", user);

                request.getRequestDispatcher("WEB-INF/jsp/profile.jsp").include(request, response);

//                String username = user.getUsername();
//                String password = user.getPassword();
//                String email = user.getEmail();
//                String role = user.getRole();;
//
//                String nom = patient.getNom();
//                String prenom = patient.getPrenom();
//                String nam = patient.getNam();
//                int nbSequentiel = patient.getNbSequentiel();
//                String dateNaissance = patient.getDateNaissance();
//                char sexe = patient.getSexe();
//
//                System.out.println(patient);
//                System.out.println(user);

//            boolean verif2 =PatientAction.update(patient = new Patient(patient.getId(), nom, prenom, nam, Integer.parseInt(nbSequentiel), dateNaissance, sexe.charAt(0), 1, 1, user.getId()));
//            System.out.println(verif);
//            System.out.println(verif2);
//            listePatient = PatientAction.afficherTous();
//            listeUtilisateur = UtilisateurAction.findAll();
//
//            request.setAttribute("listePatient", listePatient);
//            request.setAttribute("listeUtilisateur", listeUtilisateur);
//
//            request.getRequestDispatcher("WEB-INF/jsp/admin.jsp").include(request, response);
            } catch (NullPointerException e) {
            }
        } else if (session.getAttribute("username") == ("admin")) {
            request.getRequestDispatcher("WEB-INF/jsp/admin.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("WEB-INF/jsp/login.jsp").forward(request, response);
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

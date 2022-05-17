/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appweb2projetsession.mvc.controller;

import com.appweb2projetsession.action.CliniqueAction;
import com.appweb2projetsession.action.MedecinAction;
import com.appweb2projetsession.action.PatientAction;
import com.appweb2projetsession.action.UtilisateurAction;
import com.appweb2projetsession.mvc.model.Clinique;
import com.appweb2projetsession.mvc.model.Medecin;
import com.appweb2projetsession.mvc.model.Patient;
import com.appweb2projetsession.mvc.model.Utilisateur;
import java.io.IOException;
import java.util.Enumeration;
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

        //INFO FORMULAIRE
        //USER
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String role = request.getParameter("role");

        //PATIENT
        String nomPatient = request.getParameter("nomPatient");
        String prenomPatient = request.getParameter("prenomPatient");
        String nam = request.getParameter("nam");
        String nbSequentiel = request.getParameter("nbSequentiel");
        String dateNaissance = request.getParameter("dateNaissance");
        String sexe = request.getParameter("sexe");
        String id_clinique = request.getParameter("id_clinique");
        String id_medecin = request.getParameter("id_medecin");

        //MEDECIN
        String nomMedecin = request.getParameter("nomMedecin");
        String prenomMedecin = request.getParameter("prenomMedecin");
        String profession = request.getParameter("profession");
        String nbProfessionnel = request.getParameter("nbProfessionnel");
        String ententes = request.getParameter("ententes");
        String adresse = request.getParameter("adresse");
        String lieuProfession = request.getParameter("lieuProfession");
        String id_clinique_medecin = request.getParameter("id_clinique_medecin");

        //CLINIQUE
        String nomClinique = request.getParameter("nomClinique");
        String adresseClinique = request.getParameter("adresseClinique");
        String telephone = request.getParameter("telephone");
        String services = request.getParameter("services");

        Enumeration<String> attributes = request.getSession().getAttributeNames();
        while (attributes.hasMoreElements()) {
            String attribute = (String) attributes.nextElement();
            System.out.println("Profile Attributes List: " + attribute + " : " + request.getSession().getAttribute(attribute));
        }
        try {

            if (session != null) {
                //MODIF-DELETE USER
                if (session.getAttribute("User") != null) {
                    Utilisateur user = (Utilisateur) session.getAttribute("User");
                    Patient patient = (Patient) session.getAttribute("Patient");
                    Medecin medecin = (Medecin) session.getAttribute("Medecin");
                    Clinique clinique = (Clinique) session.getAttribute("Clinique");

                    if (user != null) {
                        boolean verifU = UtilisateurAction.update(user = new Utilisateur(user.getId(), username, password, email, user.getRole()));
                        if (verifU) {
                            session.setAttribute("User", user);
                            // request.getRequestDispatcher("WEB-INF/jsp/home.jsp").include(request, response);
                        }
                    }
                    if (patient != null) {
                        boolean verifP = PatientAction.update(patient = new Patient(patient.getId(), nomPatient, prenomPatient, nam, Integer.parseInt(nbSequentiel), dateNaissance, sexe.charAt(0), patient.getId_clinique(), patient.getId_medecin(), user.getId()));
                        if (verifP) {
                            session.setAttribute("Patient", patient);
                            request.getRequestDispatcher("WEB-INF/jsp/home.jsp").include(request, response);
                        }

                    } else if (medecin != null) {
                        boolean verifM = MedecinAction.update(medecin = new Medecin(medecin.getId(), nomMedecin, prenomMedecin, profession, nbProfessionnel, ententes, adresse, lieuProfession, medecin.getId_clinique(), user.getId()));
                        if (verifM) {
                            session.setAttribute("Medecin", medecin);
                            request.getRequestDispatcher("WEB-INF/jsp/home.jsp").include(request, response);
                        }

                    } else if (clinique != null) {
                        boolean verifC = CliniqueAction.miseajour(clinique = new Clinique(clinique.getId(), nomClinique, adresseClinique, telephone, services, user.getId()));
                        System.out.println(verifC);
                        if (verifC) {
                            session.setAttribute("Clinique", clinique);
                            request.getRequestDispatcher("WEB-INF/jsp/home.jsp").include(request, response);
                        }
                    }
                    request.getRequestDispatcher("WEB-INF/jsp/profile.jsp").forward(request, response);

                } //MODIF-DELETE ADMIN
                else if (session.getAttribute("username").equals("admin")) {
                    System.out.println("Test admibn");
                    Patient patientModier = (Patient) session.getAttribute("patientModif");
                    Medecin medecinModif = (Medecin) session.getAttribute("medecinModif");
                    Clinique cliniqueModif = (Clinique) session.getAttribute("cliniqueModif");

                    Utilisateur userModier = (Utilisateur) session.getAttribute("userModif");
                    userModier = new Utilisateur(userModier.getId(), username, password, email, userModier.getRole());
                    UtilisateurAction.update(userModier);

                    if (patientModier != null) {
                        patientModier = new Patient(patientModier.getId(), nomPatient, prenomPatient, nam, Integer.parseInt(nbSequentiel), dateNaissance, sexe.charAt(0), patientModier.getId_clinique(), patientModier.getId_medecin(), userModier.getId());
                        PatientAction.update(patientModier);
                        session.setAttribute("patientModif", patientModier);
                    }
                    if (medecinModif != null) {
                        medecinModif = new Medecin(medecinModif.getId(), nomMedecin, prenomMedecin, profession, nbProfessionnel, ententes, adresse, lieuProfession, medecinModif.getId_clinique(), userModier.getId());
                        MedecinAction.update(medecinModif);
                        session.setAttribute("medecinModif", medecinModif);
                    }
                    if (cliniqueModif != null) {
                        cliniqueModif = new Clinique(cliniqueModif.getId(), nomClinique, adresseClinique, telephone, services, userModier.getId());
                        CliniqueAction.miseajour(cliniqueModif);
                        session.setAttribute("cliniqueModif", cliniqueModif);
                    }

                    session.setAttribute("userModif", userModier);
                    request.getRequestDispatcher("WEB-INF/jsp/home.jsp").forward(request, response);

                }

            }
        } catch (NumberFormatException | NullPointerException e) {
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

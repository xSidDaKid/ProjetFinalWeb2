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
import javax.servlet.http.HttpSession;

/**
 * Classe qui permet d'afficher la page de profile pour les utilisateurs
 *
 * @author Shajaan
 * @Groupe 02
 * @Remis_a Dini Ahamada
 * @Cours 420-G26-RO
 * @Date_de_remise 26 mai 2022
 */
public class Profile extends AbstractAction {

    @Override
    public String execute() {
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
                            return "home";
                        }

                    } else if (medecin != null) {
                        boolean verifM = MedecinAction.update(medecin = new Medecin(medecin.getId(), nomMedecin, prenomMedecin, profession, nbProfessionnel, ententes, adresse, lieuProfession, medecin.getId_clinique(), user.getId()));
                        if (verifM) {
                            session.setAttribute("Medecin", medecin);
                            return "home";
                        }

                    } else if (clinique != null) {
                        boolean verifC = CliniqueAction.miseajour(clinique = new Clinique(clinique.getId(), nomClinique, adresseClinique, telephone, services, user.getId()));
                        System.out.println(verifC);
                        if (verifC) {
                            session.setAttribute("Clinique", clinique);
                            return "home";
                        }
                    }
                    return "profile";

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
                    return "home";

                }

            }
        } catch (NumberFormatException | NullPointerException e) {
            return "profile";
        }
        return "profile";
    }
}

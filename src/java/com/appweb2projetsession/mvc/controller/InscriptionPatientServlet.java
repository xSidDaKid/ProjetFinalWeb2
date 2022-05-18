/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appweb2projetsession.mvc.controller;

import com.appweb2projetsession.action.PatientAction;
import com.appweb2projetsession.mvc.model.Patient;
import com.appweb2projetsession.mvc.model.Utilisateur;
import javax.servlet.http.HttpSession;

/**
 * Classe qui permet d'afficher la page d'inscription pour un patient
 *
 * @author Shajaan
 * @Groupe 02
 * @Remis_a Dini Ahamada
 * @Cours 420-G26-RO
 * @Date_de_remise 26 mai 2022
 */
public class InscriptionPatientServlet extends AbstractAction {

    @Override
    public String execute() {
        HttpSession session = request.getSession(true);

        //INFO FORMULAIRE
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String nam = request.getParameter("nam");
        String nbSequentiel = request.getParameter("nbSequentiel");
        String dateNaissance = request.getParameter("dateNaissance");
        String sexe = request.getParameter("sexe");
        String clinique_id = request.getParameter("clinique_id");
        String medecin_id = request.getParameter("medecin_id");

        //SAUVEGARDE SESSION
        Utilisateur u1 = (Utilisateur) session.getAttribute("User");

        try {
            Patient p1 = new Patient(nom, prenom, nam, Integer.parseInt(nbSequentiel), dateNaissance, sexe.charAt(0), Integer.parseInt(clinique_id), Integer.parseInt(medecin_id), u1.getId());

            //VERIF NAM
            if (PatientAction.findByNAM(nam) != null) {
                request.setAttribute("existeNAM", "Un utilisateur avec ce numero d'assurance maladie existe deja.");
                return "inscriptionPatient";
            }

            //VERIF NB SEQUENTIEL
            if (PatientAction.findByNB(Integer.parseInt(nbSequentiel)) != null) {
                request.setAttribute("existeNB", "Un utilisateur avec ce numero sequentiel existe deja.");
                return "inscriptionPatient";
            }

            boolean verif = PatientAction.create(p1);

            Patient patient = PatientAction.findByIdUser(u1.getId());

            if (verif) {
                session.setAttribute("Patient", patient);
                return "home";
            }
        } catch (NullPointerException e) {
            return "inscriptionPatient";
        }
        return "inscriptionPatient";
    }
}

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
import java.util.List;
import javax.servlet.http.HttpSession;

/**
 * Classe qui permet d'afficher la page d'accueil
 *
 * @author Shajaan
 * @Groupe 02
 * @Remis_a Dini Ahamada
 * @Cours 420-G26-RO
 * @Date_de_remise 26 mai 2022
 */
public class HomeServlet extends AbstractAction {

    @Override
    public String execute() {
        List<Clinique> listeClinique = CliniqueAction.afficherTousClinique();
        List<Medecin> listeMedecin = MedecinAction.afficherTous();
        List<Patient> listePatient = PatientAction.afficherTous();
        List<Utilisateur> listeUtilisateur = UtilisateurAction.findAll();
        
        HttpSession session = request.getSession(true);
        try {
            session.setAttribute("lang", "fr");
            String langage = request.getParameter("langage");
            if (langage.equals("en")) {
                session.setAttribute("lang", "en");
            }
            if (langage.equals("fr")) {
                session.setAttribute("lang", "fr");
            }
        } catch (NullPointerException e) {
            return "home";
        }

        if (listeClinique.isEmpty()) {
            request.setAttribute("erreur", "La liste est vide");
        } else {
            int nbClinique = listeClinique.size();
            System.out.println(nbClinique);
            request.setAttribute("nbClinique", nbClinique);
        }

        if (listeMedecin.isEmpty()) {
            request.setAttribute("erreur", "La liste est vide");
        } else {
            int nbMedecin = listeMedecin.size();
            request.setAttribute("nbMedecin", nbMedecin);
        }

        if (listePatient.isEmpty()) {
            request.setAttribute("erreur", "La liste est vide");
        } else {
            int nbPatient = listePatient.size();
            request.setAttribute("nbPatient", nbPatient);
        }

        if (listeUtilisateur.isEmpty()) {
            request.setAttribute("erreur", "La liste est vide");
        } else {
            int nbUtilisateur = listeUtilisateur.size();
            request.setAttribute("nbUtilisateur", nbUtilisateur);
        }
        return "home";
    }
}

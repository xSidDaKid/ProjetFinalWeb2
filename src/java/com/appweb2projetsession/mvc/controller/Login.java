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
 * Classe qui permet d'afficher la page de login
 *
 * @author Shajaan
 * @Groupe 02
 * @Remis_a Dini Ahamada
 * @Cours 420-G26-RO
 * @Date_de_remise 26 mai 2022
 */
public class Login extends AbstractAction {

    @Override
    public String execute() {

        //INFO FORMULAIRE
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        HttpSession session = request.getSession(true);

        boolean langEN = false;
        try {
            if (session.getAttribute("lang").equals("en")) {
                langEN = true;
            }
        } catch (NullPointerException e) {
        }

        try {
            //VERIFICATION ADMIN
            if (email.equals("admin") && password.equals("admin")) {
                session.setAttribute("username", "admin");
                session.setAttribute("role", "admin");
                return "home";
            } else {
                Utilisateur u = UtilisateurAction.connexion(email, password);

                if (u != null) {
                    Patient p = PatientAction.findByIdUser(u.getId());
                    Medecin m = MedecinAction.findByIdUser(u.getId());
                    Clinique c = CliniqueAction.rechercherCliniqueParUserId(u.getId());

                    //CREATION DES SESSIONS
                    session.setAttribute("User", u);
                    session.setAttribute("Patient", p);
                    session.setAttribute("Medecin", m);
                    session.setAttribute("Clinique", c);

                    return "home";
                } else {
                    if (langEN) {
                        request.setAttribute("erreur", "Invalid email or password");
                    } else {
                        request.setAttribute("erreur", "Le email ou le mot de passe est invalide");
                    }
                    return "login";
                }
            }
        } catch (NullPointerException e) {
            return "login";
        }
    }
}

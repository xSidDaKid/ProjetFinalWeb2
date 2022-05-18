/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appweb2projetsession.mvc.controller;

import com.appweb2projetsession.action.CliniqueAction;
import com.appweb2projetsession.action.MedecinAction;
import com.appweb2projetsession.action.UtilisateurAction;
import com.appweb2projetsession.mvc.model.Clinique;
import com.appweb2projetsession.mvc.model.Medecin;
import com.appweb2projetsession.mvc.model.Utilisateur;
import java.util.List;
import javax.servlet.http.HttpSession;

/**
 * Classe qui permet d'afficher la page d'inscription pour un utilisateur
 *
 * @author Shajaan
 * @Groupe 02
 * @Remis_a Dini Ahamada
 * @Cours 420-G26-RO
 * @Date_de_remise 26 mai 2022
 */
public class InscriptionUser extends AbstractAction {

    @Override
    public String execute() {

        //INFO FORMULAIRE
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String password2 = request.getParameter("password2");
        String email = request.getParameter("email");
        String role = request.getParameter("role");

        boolean verif = false;

        //LISTE DES CLINIQUES
        List<Clinique> listeClinique = CliniqueAction.afficherTousClinique();
        request.setAttribute("listeClinique", listeClinique);

        //LISTE DES MEDECINS
        List<Medecin> listeMedecin = MedecinAction.afficherTous();
        request.setAttribute("listeMedecin", listeMedecin);

        try {
            //VERIFICATION
            if (UtilisateurAction.findByEmail(email) != null) {
                request.setAttribute("existe", "Un utilisateur avec ce email existe deja.");
            }

            if (username != null && password != null && email != null && role != null) {
                if (!(password.equals(password2))) {
                    request.setAttribute("motDePasse", "Les deux mots de passe ne sont pas identiques!");
                } else {
                    verif = UtilisateurAction.create(new Utilisateur(username, password, email, role));
                }
            }
            //AJOUT
            Utilisateur nouveau = UtilisateurAction.findByEmail(email);
            if (verif) {
                HttpSession session = request.getSession(true);
                session.setAttribute("User", nouveau);

                if (role.equals("patient")) {
                    return "inscriptionPatient";
                } else if (role.equals("clinique")) {
                    return "inscriptionClinique";
                } else if (role.equals("medecin")) {
                    return "inscriptionMedecin";
                } else {
                    return "home";
                }
            } else {
                return "inscriptionUser";
            }
        } catch (NullPointerException e) {
            return "inscriptionUser";
        }
    }
}

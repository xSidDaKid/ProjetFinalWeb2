/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appweb2projetsession.mvc.controller;

import com.appweb2projetsession.action.CliniqueAction;
import com.appweb2projetsession.mvc.model.Clinique;
import com.appweb2projetsession.mvc.model.Utilisateur;
import javax.servlet.http.HttpSession;

/**
 * Classe qui permet d'afficher la page d'inscription pour une clinique
 *
 * @author Robydul
 * @Groupe 02
 * @Remis_a Dini Ahamada
 * @Cours 420-G26-RO
 * @Date_de_remise 26 mai 2022
 */
public class InscriptionCliniqueServlet extends AbstractAction {

    @Override
    public String execute() {
        HttpSession session = request.getSession(true);

        //INFO FORMULAIRE
        String nom = request.getParameter("nom");
        String adresse = request.getParameter("adresse");
        String tel = request.getParameter("tel");
        String services = request.getParameter("services");

        //SAUVEGARDE SESSION
        Utilisateur u1 = (Utilisateur) session.getAttribute("User");

        try {
            Clinique c1 = new Clinique(nom, adresse, tel, services, u1.getId());
            boolean retour = CliniqueAction.ajouterClinique(c1);
            Clinique clinique = CliniqueAction.rechercherCliniqueParUserId(u1.getId());
            if (retour) {
                request.setAttribute("listeClinique", CliniqueAction.afficherTousClinique());
                session.setAttribute("Clinique", clinique);
                return "home";
            }
        } catch (NullPointerException e) {
            return "inscriptionClinique";
        }
        return "inscriptionClinique";
    }
}

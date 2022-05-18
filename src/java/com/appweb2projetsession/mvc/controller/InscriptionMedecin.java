/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appweb2projetsession.mvc.controller;

import com.appweb2projetsession.action.MedecinAction;
import com.appweb2projetsession.mvc.model.Medecin;
import com.appweb2projetsession.mvc.model.Utilisateur;
import javax.servlet.http.HttpSession;

/**
 * Classe qui permet d'afficher la page d'inscription pour un medecin
 *
 * @author Shajaan
 * @Groupe 02
 * @Remis_a Dini Ahamada
 * @Cours 420-G26-RO
 * @Date_de_remise 26 mai 2022
 */
public class InscriptionMedecin extends AbstractAction {

    @Override
    public String execute() {
        HttpSession session = request.getSession(true);

        //INFO FORMULAIRE
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String profession = request.getParameter("profession");
        String nbProfessionnel = request.getParameter("nbProfessionnel");
        String ententes = request.getParameter("ententes");
        String adresse = request.getParameter("adresse");
        String lieuProfession = request.getParameter("lieuProfession");
        String clinique_id = request.getParameter("clinique_id");
        
        //SAUVEGARDE SESSION
        Utilisateur u1 = (Utilisateur) session.getAttribute("User");
        
        try {
            Medecin m1 = new Medecin(nom, prenom, profession, nbProfessionnel, ententes, adresse, lieuProfession, Integer.parseInt(clinique_id), u1.getId());
            boolean verif = MedecinAction.create(m1);
            Medecin medecin = MedecinAction.findByIdUser(u1.getId());
            if (verif) {
                session.setAttribute("Medecin", medecin);
                return "home";
            }
        } catch (NullPointerException e) {
            return "inscriptionMedecin";
        }
        return "inscriptionMedecin";
    }
}

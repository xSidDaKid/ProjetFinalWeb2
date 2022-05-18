/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appweb2projetsession.mvc.controller;

import com.appweb2projetsession.action.RendezVousAction;
import com.appweb2projetsession.action.UtilisateurAction;
import com.appweb2projetsession.mvc.model.Patient;
import com.appweb2projetsession.mvc.model.RendezVous;
import com.appweb2projetsession.mvc.model.Utilisateur;
import java.util.List;
import javax.servlet.http.HttpSession;

/**
 * Classe qui permet d'afficher la page d'envoie d'un email
 *
 * @author Shajaan
 * @Groupe 02s
 * @Remis_a Dini Ahamada
 * @Cours 420-G26-RO
 * @Date_de_remise 26 mai 2022
 */
public class AfficherPageEmail extends AbstractAction {

    @Override
    public String execute() {
        //SESSION
        HttpSession session = request.getSession(true);
        Patient patient = (Patient) session.getAttribute("infoPatient");
        Utilisateur user = UtilisateurAction.findByID(patient.getId_user());
        List<RendezVous> lstRV = RendezVousAction.findByPatientId(patient.getId());

        request.setAttribute("user", user);
        request.setAttribute("lstRV", lstRV);

        return "emailForm";

    }
}

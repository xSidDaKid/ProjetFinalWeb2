/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appweb2projetsession.mvc.controller;

import com.appweb2projetsession.action.RendezVousAction;
import com.appweb2projetsession.mvc.model.Medecin;
import com.appweb2projetsession.mvc.model.RendezVous;
import java.util.List;
import javax.servlet.http.HttpSession;

/**
 * Classe qui permet d'afficher la page de Disponibilite pour que le medecin
 * puisse ajouter ces disponibilites
 *
 * @author Shajaan
 * @Groupe 02
 * @Remis_a Dini Ahamada
 * @Cours 420-G26-RO
 * @Date_de_remise 26 mai 2022
 */
public class Disponibilite extends AbstractAction {

    @Override
    public String execute() {
        HttpSession session = request.getSession(true);
        Medecin m = (Medecin) session.getAttribute("Medecin");

        String date = request.getParameter("date");
        String time = request.getParameter("time");
        String s1 = date + " " + time;

        String deletedId = request.getParameter("deletedId");
        String modifId = request.getParameter("modifId");

        boolean create = false;

        if (date != null && time != null) {
            create = RendezVousAction.create(new RendezVous(s1, m.getId()));
        }

        if (deletedId != null) {
            boolean verifDelete = RendezVousAction.delete(Integer.parseInt(deletedId));
            if (verifDelete) {
                request.setAttribute("deleted", "Cette disponibilité a été supprimer avec succès!");
            }
        }

        List<RendezVous> listeRendezVousMedecin = RendezVousAction.findByMedecinId(m.getId());

        //Messages
        if (create) {
            request.setAttribute("DispoCreer", "Votre disponibilité a été ajoutée avec succès");
        }
        //Messages d'erreurs---
        if (listeRendezVousMedecin.isEmpty()) {
            request.setAttribute("erreurDispo", "Aucune disponibilité a été définie");
        } else {
            request.setAttribute("listeRendezVousMedecin", listeRendezVousMedecin);
        }
        return "disponibilite";
    }
}

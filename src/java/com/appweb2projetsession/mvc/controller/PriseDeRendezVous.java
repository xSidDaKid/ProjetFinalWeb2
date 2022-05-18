/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appweb2projetsession.mvc.controller;

import com.appweb2projetsession.action.MedecinAction;
import com.appweb2projetsession.action.RendezVousAction;
import com.appweb2projetsession.mvc.model.Patient;
import com.appweb2projetsession.mvc.model.Medecin;
import com.appweb2projetsession.mvc.model.RendezVous;
import java.util.List;
import javax.servlet.http.HttpSession;

/**
 * Classe qui permet a un patient de prendre un rendez-vous avec son medecin
 *
 * @author Shajaan
 * @Groupe 02
 * @Remis_a Dini Ahamada
 * @Cours 420-G26-RO
 * @Date_de_remise 26 mai 2022
 */
public class PriseDeRendezVous extends AbstractAction {

    @Override
    public String execute() {
        HttpSession session = request.getSession(false);

        //INFO FORMULAIRE
        String raison = request.getParameter("raison");
        String description = request.getParameter("description");
        String date = request.getParameter("date");

        //LE PATIENT QUI VEUT UN RENDEZ-VOUS :)
        Patient patient = (Patient) session.getAttribute("Patient");
        int idPatient = patient.getId();

        //LE MEDECIN DU PATIENT
        int idMedecin = patient.getId_medecin();
        Medecin medecin = MedecinAction.findById(idMedecin);
        request.setAttribute("medecinPatient", medecin);

        //LES DISPONIBILITES DU MEDECIN DU PATIENT
        List<RendezVous> rV = RendezVousAction.findByAvaiableDate(idMedecin);
        request.setAttribute("listeRendezVous", rV);

        //LE RENDEZ-VOUS CHOISI PAR LE PATIENT
        try {

            RendezVous rVChoisi = RendezVousAction.findByDate(date);
            int idRvChoisi = rVChoisi.getId();
            RendezVous nouveau = new RendezVous(idRvChoisi, date, idMedecin, idPatient, raison, description);
            boolean rvCreer = RendezVousAction.update(nouveau);

            if (rvCreer) {
                request.setAttribute("rvCreer", "Votre rendez-vous a été ajoutée avec succès!");

                //LISTE DES RENDEZ-VOUS DU PATIENT
                List<RendezVous> mesRV = RendezVousAction.findByPatientId(idPatient);
                if (mesRV.isEmpty()) {
                    request.setAttribute("erreurRV", "Aucun rendez-vous a été pris");
                } else {
                    request.setAttribute("mesRV", mesRV);
                }
                return "priseDeRendezVous";
            }
        } catch (NullPointerException e) {
            return "priseDeRendezVous";
        }
        return "priseDeRendezVous";
    }
}

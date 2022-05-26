/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appweb2projetsession.mvc.controller;

import com.appweb2projetsession.action.MedecinAction;
import com.appweb2projetsession.action.ProfilAction;
import com.appweb2projetsession.mvc.model.Patient;
import com.appweb2projetsession.mvc.model.Profil;
import com.appweb2projetsession.mvc.model.Medecin;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 * Classe qui permet d'afficher la page d'envoie de Fichier par le patient pour
 * son medecin
 *
 * @author Shajaan
 * @Groupe 02
 * @Remis_a Dini Ahamada
 * @Cours 420-G26-RO
 * @Date_de_remise 26 mai 2022
 */
@MultipartConfig(maxFileSize = 16177215)
public class EnvoieInfo extends AbstractAction {

    @Override
    public String execute() {
        //INFO FORMULAIRE
        String info = request.getParameter("info");
        String fichier = request.getParameter("fichier");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
        LocalDateTime now = LocalDateTime.now();
        String date = dtf.format(now);

        //SESSION
        HttpSession session = request.getSession(true);
        Patient patient = (Patient) session.getAttribute("Patient");
        int id_Patient = patient.getId();
        int id_Medecin = patient.getId_medecin();
        Medecin m1 = MedecinAction.findById(id_Medecin);
        request.setAttribute("m1", m1);
        
        boolean langEN = false;
        try {
            if (session.getAttribute("lang").equals("en")) {
                langEN = true;
            }
        } catch (NullPointerException e) {
        }

        //CREER UN INPUTSTREAM DU FICHIER ENVOYER
        InputStream inputStream = null;
        String nomFichier = "";
        try {

            Part filePart = request.getPart("fichier");
            if (filePart != null) {
                nomFichier = filePart.getSubmittedFileName();
                inputStream = filePart.getInputStream();
            }
            if (nomFichier.length() > 45) {
                nomFichier = "File";
            }
        } catch (Exception e) {
            return "envoieInfo";
        }

        //CREER PROFIL
        if (info != null) {
            Profil profil = new Profil(nomFichier, inputStream, info, date, id_Patient, id_Medecin);
            boolean verif = ProfilAction.create(profil);
            if (verif) {
                if (langEN) {
                    request.setAttribute("sent", "Info Sent!");
                } else {
                    request.setAttribute("sent", "Information envoyée!");
                }
            }
        }

        return "envoieInfo";
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appweb2projetsession.mvc.controller;

import com.appweb2projetsession.action.PatientAction;
import com.appweb2projetsession.action.ProfilAction;
import com.appweb2projetsession.mvc.model.Medecin;
import com.appweb2projetsession.mvc.model.Patient;
import com.appweb2projetsession.mvc.model.Profil;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;

/**
 * Classe qui permet d'afficher la page des patients du medecin, de voir les
 * fichiers qu'il a recu de son patient et aussi d'envoyer des emails (Espace
 * Medecin-Patient)
 *
 * @author Shajaan
 * @Groupe 02
 * @Remis_a Dini Ahamada
 * @Cours 420-G26-RO
 * @Date_de_remise 26 mai 2022
 */
public class EspacePatient extends AbstractAction {

    @Override
    public String execute() {
        boolean verif = false;
        request.setAttribute("verif", verif);
        String patient = request.getParameter("patient");

        //SESSION
        HttpSession session = request.getSession(true);
        Medecin medecin = (Medecin) session.getAttribute("Medecin");

        //PATIENTS DU MEDECIN
        List<com.appweb2projetsession.mvc.model.Patient> listePatient = PatientAction.findByIdMedecin(medecin.getId());
        request.setAttribute("listePatient", listePatient);

        if (patient != null) {

            int id_Patient = Integer.parseInt(patient);
            verif = true;
            request.setAttribute("verif", verif);

            Patient infoPatient = PatientAction.findById(id_Patient);
            session.setAttribute("infoPatient", infoPatient);

            //LIRE LE FICHIER ENVOYER
            List<Profil> lstProfil = ProfilAction.afficherPatientMedecin(Integer.parseInt(patient), medecin.getId());
            request.setAttribute("lstProfil", lstProfil);

            for (Profil profil : lstProfil) {

                File file = new File(profil.getNomFichier());
                try {
                    FileOutputStream output = null;
                    output = new FileOutputStream(file);

                    System.out.println("Writing to file " + file.getAbsolutePath());
                    byte[] buffer = new byte[1024];

                    while (profil.getContenuFichier().read(buffer) > 0) {
                        output.write(buffer);
                    }

                    Desktop.getDesktop().open(new File(file.getAbsolutePath()));
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(EspacePatient.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(EspacePatient.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            return "espacePatient";

        }

        return "espacePatient";
    }
}

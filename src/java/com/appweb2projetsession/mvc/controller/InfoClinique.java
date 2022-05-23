/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appweb2projetsession.mvc.controller;

import com.appweb2projetsession.action.MedecinAction;
import com.appweb2projetsession.action.PatientAction;
import com.appweb2projetsession.mvc.model.Patient;
import com.appweb2projetsession.mvc.model.Clinique;
import com.appweb2projetsession.mvc.model.Medecin;
import java.util.List;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Shajaan
 */
public class InfoClinique extends AbstractAction {

    @Override
    public String execute() {
        HttpSession session = request.getSession(false);
        Clinique c = (Clinique) session.getAttribute("Clinique");
        //Liste des tables SQL
        List<Patient> listePatient = PatientAction.findByIdClinique(c.getId());
        request.setAttribute("listePatient", listePatient);

        List<Medecin> listeMedecin = MedecinAction.findByIdClinique(c.getId());
        request.setAttribute("listeMedecin", listeMedecin);
        

        return "infoClinique";
    }
}

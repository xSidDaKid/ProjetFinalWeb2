/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appweb2projetsession.mvc.controller;

import com.appweb2projetsession.action.PatientAction;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe qui permet de recuperer le nombre de patient pour l'utiliser dans une
 * fonction Ajax
 *
 * @author Shajaan
 * @Groupe 02
 * @Remis_a Dini Ahamada
 * @Cours 420-G26-RO
 * @Date_de_remise 26 mai 2022
 */
public class PatientNombre extends AbstractAction {

    @Override
    public String execute() {
        PrintWriter out;
        try {
            out = response.getWriter();
            out.print(PatientAction.afficherTous().size());
            out.flush();
            out.close();
        } catch (IOException ex) {
            Logger.getLogger(PatientNombre.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "home";
    }
}

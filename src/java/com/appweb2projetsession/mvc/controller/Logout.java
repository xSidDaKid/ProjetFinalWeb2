/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appweb2projetsession.mvc.controller;

import javax.servlet.http.HttpSession;

/**
 * Classe qui permet a un utilisateur de se deconnecter
 *
 * @author Shajaan
 * @Groupe 02
 * @Remis_a Dini Ahamada
 * @Cours 420-G26-RO
 * @Date_de_remise 26 mai 2022
 */
public class Logout extends AbstractAction {

    @Override
    public String execute() {
        HttpSession session = request.getSession(false);

        if (session != null) {
            String message = "Vous êtes déconnecté avec succès ";
            session.invalidate();
            request.setAttribute("message", message);
            return "home";
        }
        return "home";
    }
}

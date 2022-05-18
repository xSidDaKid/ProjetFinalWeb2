/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appweb2projetsession.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Classe abstraite qui implémente l’interface Action en fournissant les
 * implémentations des 2 méthodes requise pour traiter les requetes de
 * l'utilisateur
 *
 * @author Shajaan, dahamada
 * @Groupe 02
 * @Remis_a Dini Ahamada
 * @Cours 420-G26-RO
 * @Date_de_remise 26 mai 2022
 */
public abstract class AbstractAction implements Action {

    protected HttpServletRequest request;
    protected HttpServletResponse response;

    @Override
    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    @Override
    public void setResponse(HttpServletResponse response) {
        this.response = response;
    }
}

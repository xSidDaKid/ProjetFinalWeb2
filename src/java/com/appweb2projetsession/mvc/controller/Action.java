/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appweb2projetsession.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Interface qui sera implementer par le controlleur frontal
 *
 * @author Shajaan, dahamada
 * @Groupe 02
 * @Remis_a Dini Ahamada
 * @Cours 420-G26-RO
 * @Date_de_remise 26 mai 2022
 */
public interface Action {

    public String execute();

    public void setRequest(HttpServletRequest request);

    public void setResponse(HttpServletResponse response);
}
